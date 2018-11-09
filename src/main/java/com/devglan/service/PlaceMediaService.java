package com.devglan.service;

import com.devglan.model.PlaceMedia;

public interface PlaceMediaService {
     PlaceMedia savePlaceMedia(byte[] fileBytes,String fileName);
     PlaceMedia loadById(Long id);
}
