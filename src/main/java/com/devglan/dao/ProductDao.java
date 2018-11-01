package com.devglan.dao;

import com.devglan.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by m.shahoseini on 7/16/2018.
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {



}
