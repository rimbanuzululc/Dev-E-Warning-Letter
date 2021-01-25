/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.AssignFinanceDAO;
import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.service.AssignFinanceService;
import io.starlight.Service;
import io.vertx.core.Future;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;
/**
 *
 * @author aldy.kurniawan
 */

@Service
public class AssignFinanceServiceImpl implements AssignFinanceService {
    
    @AutoWired
    AssignFinanceDAO dao;
    
    @Override
    public Future<AssignFinance> update(AssignFinance assignFinance) {
        return dao.update(assignFinance);
    }
    
    @Override
    public Future<List<AssignFinance>> listDebitur() {
         return dao.listDebitur();
    }
    
    @Override
    public Future<List<AssignFinance>> listNoDebitur() {
         return dao.listNoDebitur();
    }
}
