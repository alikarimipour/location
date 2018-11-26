package com.devglan.service.impl;

import com.devglan.dao.PlaceMediaDao;
import com.devglan.dao.UserDao;
import com.devglan.dto.IPlaceMediaOutput;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;
import com.devglan.service.PlaceMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by a.karimipur on 7/15/2018.
 */
@Service("PlaceMediaService")
public class PlaceMediaServiceImpl implements PlaceMediaService {

    @Autowired
    private PlaceMediaDao placeMediaDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public PlaceMedia savePlaceMedia(PlaceMedia placeMedia, User user) {


        Optional<User> optional = userDao.findById(user.getUserId());
        optional.ifPresent(placeMedia::setUser);
        return placeMediaDao.save(placeMedia);

    }

    @Override
    public PlaceMedia loadById(Long id) {
        Optional<PlaceMedia> optionalPlaceMedia = placeMediaDao.findById(id);
        // optionalPlaceMedia.ifPresent();
        if (optionalPlaceMedia.isPresent()) {
            PlaceMedia placeMedia = optionalPlaceMedia.get();
            System.out.println("ss");
            System.out.println("ss");
            System.out.println("ss");
            return placeMedia;
        }
        return null;
    }

    public List<IPlaceMediaOutput> loadByDistance(BigDecimal latitude,BigDecimal longitude,Integer distance){
        List<IPlaceMediaOutput> iPlaceMediaOutputs=placeMediaDao.findUserByStatusAndNameNamedParams(latitude,longitude,distance);
        System.out.println(iPlaceMediaOutputs.get(0).getFile_name());
        System.out.println(iPlaceMediaOutputs.get(0).getLatitude());
        System.out.println(iPlaceMediaOutputs.get(0).getDistance());
        return iPlaceMediaOutputs;
    }
}
