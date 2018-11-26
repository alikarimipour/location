/*
package com.devglan.controller;

import com.devglan.dto.BusinessDto;
import com.devglan.model.Business;
import com.devglan.service.BusinessService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

*/
/**
 * Created by m.shahoseini on 7/15/2018.
 *//*

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/business")
public class BusinessController {


    @Autowired
    private BusinessService businessService;


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/saveBusiness", method = RequestMethod.POST )
    public Business saveBusiness(@RequestBody BusinessDto businessDto) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Business businessRegister = businessService.save(businessDto);
        JSONObject output = null;
        output = convertStringToJson2(businessRegister);
        assert output != null;
        return businessRegister;
    }


    public static JSONObject convertStringToJson2(Business business) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("user", business.getUser().getUsername());
            obj.put("businessId", business.getBusinesId());
            obj.put("name", business.getName());


            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
*/
