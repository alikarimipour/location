package com.devglan.service;

import com.devglan.dto.BusinessDto;
import com.devglan.model.Business;

/**
 * Created by m.shahoseini on 7/15/2018.
 */
public interface BusinessService {

    Business save(BusinessDto businessDto);
}
