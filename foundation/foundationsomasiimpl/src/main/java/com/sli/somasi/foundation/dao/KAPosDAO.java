/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.ConfirmKAPos;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author aldy.kurniawan
 */

@DAO(config = "db")
public class KAPosDAO extends CommonDAO{
    
    public Future<ConfirmKAPos> submit (ConfirmKAPos confirm) {
        
        Future<ConfirmKAPos> result = Future.future();
        
        insert(confirm)
                .setHandler(ret -> {
                if (ret.succeeded()) {
                        result.complete(ret.result());
                    } else {
                        result.fail(ret.cause());
                    }
               });
        return result; 
        
    }
    
    public Future<List<ConfirmKAPos>> reportVerifikasi (String userId) {
        
        return queryScriptWihtParam("reportVerifikasi", ConfirmKAPos.class, "id", userId);
    }
}
