package com.devglan.service.impl;

import com.devglan.dao.BusinessDao;
import com.devglan.dao.ProductDao;
import com.devglan.dto.ProductDto;
import com.devglan.model.Business;
import com.devglan.model.Product;
import com.devglan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by m.shahoseini on 7/16/2018.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(ProductDto productDto) {
        Optional<Business> businessOptional = businessDao.findById(productDto.getBusinessId());
        Product product = new Product();
        businessOptional.ifPresent(product::setBusiness);
        product.setName(productDto.getName());
        return productDao.save(product);
    }
}
