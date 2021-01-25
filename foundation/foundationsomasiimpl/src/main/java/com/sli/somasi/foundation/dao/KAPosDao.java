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

/**
 *
 * @author aldy.kurniawan
 */

@DAO(config = "db")
public class KAPosDao extends CommonDAO{
    
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
}
