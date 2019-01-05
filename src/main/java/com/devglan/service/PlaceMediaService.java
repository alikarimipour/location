package com.devglan.service;

import com.devglan.dto.IPlaceMediaOutput;
import com.devglan.dto.PlaceMediaDto;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface PlaceMediaService {
     PlaceMedia savePlaceMedia(PlaceMedia placeMedia);
     PlaceMedia loadById(Long id);
     List<IPlaceMediaOutput> loadByDistance(BigDecimal latitude, BigDecimal longitude, Integer distance);
}
