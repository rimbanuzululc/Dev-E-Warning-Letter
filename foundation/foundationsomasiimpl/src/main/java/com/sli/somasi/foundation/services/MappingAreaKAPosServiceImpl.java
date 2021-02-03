/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.MappingAreaKAPosDAO;
import com.sli.somasi.foundation.dto.District;
import com.sli.somasi.foundation.dto.MappingAreaKAPos;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;
import com.sli.somasi.foundation.service.MappingAreaKAPosService;

/**
 *
 * @author hp
 */
@Service
public class MappingAreaKAPosServiceImpl implements MappingAreaKAPosService {

    @AutoWired
    MappingAreaKAPosDAO dao;
    
    @Override
    public Future<MappingAreaKAPos> add(MappingAreaKAPos area) {
        return dao.add(area);
    }
    
    @Override
    public Future<MappingAreaKAPos> update(MappingAreaKAPos area) {
        return dao.update(area);
    }

    @Override
    public Future<Boolean> delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Future<List<MappingAreaKAPos>> list() {
        return dao.list();
    }

    @Override
    public Future<List<District>> listDistByArea(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
