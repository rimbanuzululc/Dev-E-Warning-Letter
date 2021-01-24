/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.AssignFinance;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@DAO(config = "db")
public class AssignFinanceDAO extends CommonDAO{
     public Future<AssignFinance> add (AssignFinance assign) {
        
        Future<AssignFinance> result = Future.future();
        
         System.out.println("INSERT");
        insert(assign)
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
