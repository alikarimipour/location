package com.devglan.controller;

import com.devglan.dto.*;
import com.devglan.model.Comment;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;
import com.devglan.service.CommentService;
import com.devglan.service.PlaceMediaService;
import com.devglan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceMediaService placeMediaService;
    @Autowired
    private CommentService commentService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public UsersDto listUser() {
      /*  User user=new User();
        user.setMobile("0912");
        List<User> users=new ArrayList<>();
        users.add(user);
        return users;*/
        List<User> users = userService.findAll();
        UsersDto usersDto = new UsersDto();
        usersDto.setUsers(users);
        usersDto.setCurentPage(1L);
        return usersDto;
    }

    //@Secured("ROLE_USER")
//    @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user) {
        User userSaved = userService.save(user);
        userSaved.setMobile(null);
        return userSaved;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUserByToken(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User loadedUser = userService.findByUsername(userDetails.getUsername());
        return ResponseEntity.ok(new AuthToken(null, 1L, null, loadedUser.getUserId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }


    public User loadUserByToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userService.findByUsername(userDetails.getUsername());
    }

    public static JSONObject convertStringToJson2(String username) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("username", username);
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/upload", method = RequestMethod.POST) // //new annotation since 4.3
    public ResponseEntity<?> singleFileUpload(@RequestParam("ufile") MultipartFile file,
                                              @RequestParam("latitude") BigDecimal latitude,
                                              @RequestParam("longitude") BigDecimal longitude,
                                              RedirectAttributes redirectAttributes) {

        User user = loadUserByToken();
        PlaceMedia placeMedia = null;
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return ResponseEntity.ok("redirect:uploadStatus");
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C://locTemp//" + file.getOriginalFilename());

            Files.write(path, bytes);
            placeMedia = placeMediaService.savePlaceMedia(new PlaceMedia(bytes, file.getOriginalFilename(), latitude, longitude), user);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        placeMedia.setFileContent(null);
        return ResponseEntity.ok(placeMedia);
    }

/*    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/loadPlaceMedia/{id}", method = RequestMethod.POST) // //new annotation since 4.3
    public ResponseEntity<Resource> singleFileDownload(@PathVariable(value = "id") Long id) throws SQLException {
        PlaceMedia placeMedia=placeMediaService.loadById(id);
//        Resource resource=new MultipartFile();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "salam" + "\"")
                .contentLength(placeMedia.getFileContent().length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(placeMedia.getFileContent().getBinaryStream());
    }*/

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/loadPlaceMedia/{id}", method = RequestMethod.GET) // //new annotation since 4.3
    public StreamingResponseBody getSteamingFile(HttpServletResponse response, @PathVariable(value = "id") Long id) throws IOException, SQLException {
//        response.setContentType("application/pdf");
        PlaceMedia placeMedia = placeMediaService.loadById(id);
        InputStream inputStream = placeMedia.getFileContent().getBinaryStream();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + placeMedia.getFileName() + "\"");
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
    }

    @RequestMapping(value = "/loadPlaceMedia/getListByDistance/{latitude}/{longitude}/{distance}", method = RequestMethod.POST) // //new annotation since 4.3
    public List<IPlaceMediaOutput> getListFilesByDistance(HttpServletResponse response, @PathVariable(value = "latitude") BigDecimal latitude,@PathVariable(value = "longitude") BigDecimal longitude,@PathVariable(value = "distance") Integer distance) throws IOException, SQLException {
//        response.setContentType("application/pdf");
        List<IPlaceMediaOutput> placeMedia = placeMediaService.loadByDistance(latitude,longitude,distance);

        return placeMedia;
    }

    @RequestMapping(value = "/loadPlaceMedia/saveAdmin", method = RequestMethod.GET) // //new annotation since 4.3
    public User saveAdmin() throws SQLException {
        return userService.saveAdmin();
    }

    @RequestMapping(value = "/loadPlaceMedia/testMethod", method = RequestMethod.GET) // //new annotation since 4.3
//    public List<IPlaceMediaOutput> testMethod() throws SQLException {
    public Comment testMethod() {
        Comment comment=new Comment();
        comment.setCommentText("salam");
        PlaceMedia placeMedia=new PlaceMedia();
        placeMedia.setMediaId(12L);
        comment.setPlaceMedia(placeMedia);
        //return placeMediaService.loadByDistance();
        return comment;
    }

    @RequestMapping(value = "/loadPlaceMedia/addComment", method = RequestMethod.POST) // //new annotation since 4.3
    public PlaceMediaDto addComment(@RequestBody Comment comment) {
        Comment comment1=commentService.save(comment);
        System.out.println(comment1);
        System.out.println(comment1);
        System.out.println(comment1);
        PlaceMediaDto placeMediaDto=new PlaceMediaDto(comment.getPlaceMedia().getFileName(),comment.getPlaceMedia().getLatitude(),comment.getPlaceMedia().getLongitude(),comment.getPlaceMedia().getComments());

        return placeMediaDto;
    }
}
