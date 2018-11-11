package com.devglan.service;

import com.devglan.model.PlaceMedia;
import com.devglan.model.User;

public interface PlaceMediaService {
     PlaceMedia savePlaceMedia(PlaceMedia placeMedia, User user);
     PlaceMedia loadById(Long id);
}
