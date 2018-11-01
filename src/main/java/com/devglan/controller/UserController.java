package com.devglan.controller;

import com.devglan.dto.UsersDto;
import com.devglan.model.User;
import com.devglan.dto.UserDto;
import com.devglan.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class UserController {

    @Autowired
    private UserService userService;

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
    public String getUserByToken(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JSONObject output = null;
        output = convertStringToJson2(auth.getName());
        assert output != null;
        return output.toString();
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
    public String singleFileUpload(@RequestParam("ufile") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C://locTemp//" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "salam";
    }
}
