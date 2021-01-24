/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.ZipcodeDAO;
import com.sli.somasi.foundation.dto.Zipcode;
import com.sli.somasi.foundation.service.ZipcodeService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class ZipcodeServiceImpl implements ZipcodeService{
    
    @AutoWired
    ZipcodeDAO dao;

    @Override
    public Future<List<Zipcode>> listZipcodeByKecamatan(String code) {
        
        return dao.listByKec(code);
    }
    
}
