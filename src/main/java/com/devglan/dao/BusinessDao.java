package com.devglan.dao;

import com.devglan.model.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by a.karimipour on 7/15/2018.
 */
@Repository
public interface BusinessDao extends CrudRepository<Business, Long> {

}
