/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.KAPosDao;
import com.sli.somasi.foundation.dto.ConfirmKAPos;
import com.sli.somasi.foundation.service.KAPosService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author aldy.kurniawan
 */
@Service
public class KAPosServiceImpl implements KAPosService{
    
    @AutoWired
    KAPosDao dao;
    
    @Override
    public Future<ConfirmKAPos> submit(ConfirmKAPos confirm) {
        return dao.submit(confirm);
    }
}
