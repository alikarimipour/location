package com.devglan.service;

import com.devglan.dto.ProductDto;
import com.devglan.model.Product;

/**
 * Created by m.shahoseini on 7/16/2018.
 */
public interface ProductService {
    Product save(ProductDto productDto);
}
