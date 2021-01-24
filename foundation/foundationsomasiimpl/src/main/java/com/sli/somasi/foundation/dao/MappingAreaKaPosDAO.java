/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.MappingAreaAgentKaPos;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@DAO(config = "db")
public class MappingAreaKaPosDAO extends CommonDAO{
    
    public Future<MappingAreaAgentKaPos> add (MappingAreaAgentKaPos agentKaPos) {
        
        Future<MappingAreaAgentKaPos> result = Future.future();
        
        insert(agentKaPos)
                .setHandler(ret -> {
                    
                    if (ret.succeeded()) {
                        result.complete(ret.result());
                    } else {
                        result.complete();
                    }
                
                });
        return result;
    }
    
    public Future<List<MappingAreaAgentKaPos>> list () {
        return queryScript("listMapping", MappingAreaAgentKaPos.class);
    }
    
}
