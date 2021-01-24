/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.StatusKAPosDAO;
import com.sli.somasi.foundation.dto.StatusKAPos;
import com.sli.somasi.foundation.service.StatusKAPosService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@Service
public class StatusKAPosServiceImpl implements StatusKAPosService{

    @AutoWired
    StatusKAPosDAO kAPosDAO;
    
    @Override
    public Future<StatusKAPos> getByCode(String code) {
        return kAPosDAO.getByCode(code);
    }
    
}
