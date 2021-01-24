/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.MappingArea;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@DAO(config = "db")
public class MappingAreaDAO extends CommonDAO {
    
    public Future<MappingArea> add (MappingArea area) {
        
        Future<MappingArea> result = Future.future();
        
        insert(area)
                .setHandler(ret -> {
                    
                    if (ret.succeeded()) {
                            result.complete(ret.result());
                    } else {
                            result.complete(ret.result());
                    }
                
                });
        return result;
    }
    
    public Future<List<MappingArea>> list () {
        return queryScript("listMappingArea", MappingArea.class);
    }
    
}
