/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.MappingAreaDAO;
import com.sli.somasi.foundation.dto.District;
import com.sli.somasi.foundation.dto.MappingArea;
import com.sli.somasi.foundation.service.MappingAreaService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class MappingAreaServiceImpl implements MappingAreaService {

    @AutoWired
    MappingAreaDAO dao;
    
    @Override
    public Future<MappingArea> add(MappingArea area) {
        return dao.add(area);
    }

    @Override
    public Future<Boolean> delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Future<List<MappingArea>> list() {
        return dao.list();
    }

    @Override
    public Future<List<District>> listDistByArea(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
