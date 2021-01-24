/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.HubunganPenerimaDAO;
import com.sli.somasi.foundation.dto.HubunganPenerima;
import com.sli.somasi.foundation.service.HubunganPenerimaService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@Service
public class HubunganPenerimaServiceImpl implements HubunganPenerimaService{ 
    
    @AutoWired
    HubunganPenerimaDAO dao;

    @Override
    public Future<HubunganPenerima> getByCode(String code) {
        return dao.getByCode(code);
    }
    
}
