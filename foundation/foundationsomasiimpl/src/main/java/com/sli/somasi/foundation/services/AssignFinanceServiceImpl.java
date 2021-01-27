/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.AssignFinanceDAO;
import com.sli.somasi.foundation.dao.ConfirmAgentPosDAO;
import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.service.AssignFinanceService;
import io.starlight.Service;
import io.vertx.core.Future;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 *
 * @author aldy.kurniawan
 */

@Service
public class AssignFinanceServiceImpl implements AssignFinanceService {
    
    @AutoWired
    AssignFinanceDAO dao;
    
    @AutoWired
    protected ConfirmAgentPosDAO confirmAgentPosDao;
    
    @Override
    public Future<AssignFinance> update(AssignFinance assignFinance) {
        
        
        if (assignFinance.getConfirmDebitur()  != null && assignFinance.getNoDebitur() != null) {
            assignFinance.setSubmit_date(Date.from(Instant.now()));
        }
        
        if (assignFinance.getConfirmDebitur() != null || !assignFinance.getConfirmDebitur().equals("")){
            
            confirmAgentPosDao.getByCode(assignFinance.getConfirmDebitur())
                    .setHandler(ret ->{
                        if (ret.succeeded() && ret.result() != null){
                            
                            if (ret.result().getValue() == 1){
                                assignFinance.setStatus("Berhasil Terkirim");
                            } else if (ret.result().getValue() == 2){
                                assignFinance.setStatus("Pending");
                            } else if (ret.result().getValue() == 3){
                                assignFinance.setStatus("Failed");
                            }
                            
                            dao.update(assignFinance);
                        }
                        
                    });
        }
            
        return dao.update(assignFinance);
    }
    
    @Override
    public Future<List<AssignFinance>> listDebitur() {
         return dao.listDebitur();
    }
    
    @Override
    public Future<List<AssignFinance>> listNoDebitur(String userId) {
         return dao.listNoDebitur(userId);
    }
}
