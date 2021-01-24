/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.CityDAO;
import com.sli.somasi.foundation.dto.City;
import com.sli.somasi.foundation.service.CityService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class CityServiceImpl implements CityService {

    @AutoWired
    CityDAO dao;
        
    @Override
    public Future<List<City>> listCityByState(int stateId) {
        return dao.listByState(stateId);
    }
    
}
