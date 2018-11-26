/*
package com.devglan.controller;

import com.devglan.dto.BusinessDto;
import com.devglan.dto.ProductDto;
import com.devglan.model.Business;
import com.devglan.model.Product;
import com.devglan.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

*/
/**
 * Created by a.karimipour on 7/16/2018.
 *//*

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody ProductDto productDto) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return productService.save(productDto);
    }


    public static JSONObject convertStringToJson2(Product product) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("name", product.getName());
            obj.put("productId", product.getProductId());
            obj.put("businessId", product.getBusiness().getBusinesId());


            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
*/
