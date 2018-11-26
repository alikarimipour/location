package com.devglan.dao;

import com.devglan.dto.IPlaceMediaOutput;
import com.devglan.dto.PlaceMediaDto;
import com.devglan.model.PlaceMedia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by a.karimipour on 7/15/2018.
 */
@Repository
public interface PlaceMediaDao extends CrudRepository<PlaceMedia, Long> {

//    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    @Query(value = "SELECT  file_name, latitude, longitude, ( 3959 * acos( cos( radians(?1) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?2) ) + sin( radians(?1) ) * sin( radians( latitude ) ) ) ) AS distance FROM tbl_place_media HAVING distance < ?3 ORDER BY distance LIMIT 0 , 20",nativeQuery = true)
    List<IPlaceMediaOutput> findUserByStatusAndNameNamedParams(@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude, @Param("distance") Integer distance);
}
