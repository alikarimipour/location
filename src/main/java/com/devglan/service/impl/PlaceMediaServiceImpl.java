package com.devglan.service.impl;

import com.devglan.dao.BusinessDao;
import com.devglan.dao.PlaceMediaDao;
import com.devglan.dao.UserDao;
import com.devglan.dto.BusinessDto;
import com.devglan.model.Business;
import com.devglan.model.PlaceMedia;
import com.devglan.model.Product;
import com.devglan.model.User;
import com.devglan.service.BusinessService;
import com.devglan.service.PlaceMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by m.shahoseini on 7/15/2018.
 */
@Service("PlaceMediaService")
public class PlaceMediaServiceImpl implements PlaceMediaService {

    @Autowired
    private PlaceMediaDao placeMediaDao;


    @Override
    public PlaceMedia savePlaceMedia(byte[] fileBytes) {
        PlaceMedia placeMedia = placeMediaDao.save(new PlaceMedia(fileBytes));
        return placeMedia;
    }

    @Override
    public PlaceMedia loadById(Long id) {
        Optional<PlaceMedia> optionalPlaceMedia = placeMediaDao.findById(id);
        optionalPlaceMedia.ifPresent();
        System.out.println("ss");
        System.out.println("ss");
        System.out.println("ss");
        return null;
    }
}
