package com.devglan.service.impl;

import com.devglan.dao.BusinessDao;
import com.devglan.dao.UserDao;
import com.devglan.dto.BusinessDto;
import com.devglan.model.Business;
import com.devglan.model.User;
import com.devglan.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by m.shahoseini on 7/15/2018.
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BusinessDao businessDao;

    @Override
    public Business save(BusinessDto businessDto) {
        Optional<User> optional = userDao.findById(businessDto.getUserId());
        Business business = new Business();
        optional.ifPresent(business::setUser);
        business.setName(businessDto.getName());
        return businessDao.save(business);

    }
}
