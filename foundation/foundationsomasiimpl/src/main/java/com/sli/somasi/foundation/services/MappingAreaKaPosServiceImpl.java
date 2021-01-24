/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.MappingAreaKaPosDAO;
import com.sli.somasi.foundation.dto.MappingAreaAgentKaPos;
import com.sli.somasi.foundation.service.MappingAreaKaPosService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class MappingAreaKaPosServiceImpl implements MappingAreaKaPosService{
    
    @AutoWired
    MappingAreaKaPosDAO dao;

    @Override
    public Future<MappingAreaAgentKaPos> add(MappingAreaAgentKaPos agentKaPos) {
        return dao.add(agentKaPos);
    }

    @Override
    public Future<List<MappingAreaAgentKaPos>> list() {
        return dao.list();
    }
    
}
