package com.devglan.dao;

import com.devglan.dto.IPlaceMediaOutput;
import com.devglan.model.FriendGroup;
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
public interface FriendGroupDao extends CrudRepository<FriendGroup, Long> {

}
