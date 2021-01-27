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
import java.util.List;

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
     
     public Future<AssignFinance> update(AssignFinance assignFinance) {
        
          Future<AssignFinance> result = Future.future();
          
         if (assignFinance.getIdAssignFinance() == null) {
             queryScriptWihtParam("getAssign", AssignFinance.class, "idAgent", assignFinance.getIdAgentPos(), 
                     "idkonsumen", assignFinance.getKonsumenId())
                     .setHandler(ret -> {
                         
                         assignFinance.setIdAssignFinance(ret.result().get(0).getIdAssignFinance());
                         
                         super.update(assignFinance)
                            .setHandler(ret2 -> {

                                if(ret2.succeeded())
                                    result.complete(ret2.result());
                                else
                                    result.fail(ret.cause());
                            });
                     
                     });
         } else {
             
                super.update(assignFinance)
                .setHandler(ret -> {

                    if(ret.succeeded())
                        result.complete(assignFinance);
                    else
                        result.fail(ret.cause());
                });

         }
        
        return result;
    }
     
    public Future<List<AssignFinance>> listDebitur() {
       
        return queryScriptWihtParam("listDebitur", AssignFinance.class);
    }
     
     public Future<List<AssignFinance>> listNoDebitur(String userId) {
       
        return queryScriptWihtParam("listNoDebitur", AssignFinance.class, "userId", userId);
    }
}
