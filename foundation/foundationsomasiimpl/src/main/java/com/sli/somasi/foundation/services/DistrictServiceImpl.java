/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.DistrictDAO;
import com.sli.somasi.foundation.dto.District;
import com.sli.somasi.foundation.service.DistrictService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class DistrictServiceImpl implements DistrictService{
    
    @AutoWired
    DistrictDAO dao;

    @Override
    public Future<List<District>> listDistrictByCity(int cityid) {
        return dao.listByCity(cityid);
    }

    @Override
    public Future<List<District>> listDistrictByKodeArea(String kode) {
        return dao.listDistrictByKodeArea(kode);
    }
    
}
