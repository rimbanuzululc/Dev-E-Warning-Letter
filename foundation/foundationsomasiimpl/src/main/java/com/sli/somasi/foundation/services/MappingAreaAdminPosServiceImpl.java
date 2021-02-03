/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.MappingAreaAdminPosDAO;
import com.sli.somasi.foundation.dto.MappingAreaAdminPos;
import com.sli.somasi.foundation.service.MappingAreaAdminPosService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@Service
public class MappingAreaAdminPosServiceImpl implements MappingAreaAdminPosService{
    
    @AutoWired
    MappingAreaAdminPosDAO adminPosDAO;

    @Override
    public Future<MappingAreaAdminPos> add(MappingAreaAdminPos adminPos) {
        return adminPosDAO.add(adminPos);
    }
    
    @Override
    public Future<MappingAreaAdminPos> update(MappingAreaAdminPos adminPos) {
        return adminPosDAO.update(adminPos);
    }
    
}
