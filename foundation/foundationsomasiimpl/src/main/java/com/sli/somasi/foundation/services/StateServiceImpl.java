/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.StateDAO;
import com.sli.somasi.foundation.dto.State;
import com.sli.somasi.foundation.service.StateService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class StateServiceImpl implements StateService{
    
    @AutoWired
    StateDAO dao;

    @Override
    public Future<List<State>> listAll() {
        return dao.listAll();
    }
    
}
