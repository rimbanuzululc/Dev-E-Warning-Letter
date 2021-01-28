package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.AssignFinance;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface AssignFinanceService {
    
    Future<AssignFinance> update(AssignFinance assignFinance);
    Future<List<AssignFinance>> listDebitur();
    Future<List<AssignFinance>> listNoDebitur(String userId);
    Future<List<AssignFinance>> reportSendDebitur();
    
}
