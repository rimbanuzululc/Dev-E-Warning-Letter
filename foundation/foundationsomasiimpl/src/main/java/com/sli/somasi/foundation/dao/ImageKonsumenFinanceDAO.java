/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.ImageKonsumenFinance;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import java.util.List;

/**
 *
 * @author hp
 */
@DAO(config = "db")
public class ImageKonsumenFinanceDAO extends CommonDAO {
    
    public Future<ImageKonsumenFinance> add (ImageKonsumenFinance finance) {
        
        Future<ImageKonsumenFinance> result = Future.future();
        
        insert(finance)
                .setHandler(ret -> {
                    
                    if (ret.succeeded()) {
                        result.complete(ret.result());
                    } else {
                        result.fail(ret.cause());
                    }
                });
        return result;
    }
    
    public Future<ImageKonsumenFinance> checkImage(Integer id) {
        Future<ImageKonsumenFinance> result = Future.future();
        
        queryScriptWihtParam("checkImage", ImageKonsumenFinance.class, "id", id)
            .setHandler(ret -> {
                
                if (ret.result() != null && ret.result().size() > 0) {
                    result.complete(ret.result().get(0));
                } else {
                    result.complete(null);
                }
            });
        return result;
    }
    
        
        public Future<List<ImageKonsumenFinance>> listbykonsumen(int id){
            return queryScriptWihtParam("listbykonsumen", ImageKonsumenFinance.class, "id", id);
        }
    
}
