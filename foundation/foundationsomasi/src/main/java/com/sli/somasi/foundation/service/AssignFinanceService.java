package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.dto.KonsumenAggrement;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface AssignFinanceService {
    
    Future<AssignFinance> update(AssignFinance assignFinance);
    Future<List<AssignFinance>> listDebitur();
    
}
