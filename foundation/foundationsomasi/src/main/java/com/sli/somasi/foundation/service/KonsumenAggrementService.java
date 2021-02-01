/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.DetailDebitur;
import com.sli.somasi.foundation.dto.KonsumenAggrement;
import com.sli.somasi.foundation.dto.ListSomasi;
import io.vertx.core.Future;
import java.util.Date;
import java.util.List;
import javax.xml.soap.Detail;

/**
 *
 * @author hp
 */

public interface KonsumenAggrementService {
    
    Future<KonsumenAggrement> add (KonsumenAggrement aggremnt);
    
    Future<List<KonsumenAggrement>> list ();
    
    Future<List<KonsumenAggrement>> search (String param, String value, String startDate, String endDate, int page);
    
    Future<DetailDebitur> getByNoAggrement (String no);
    
    Future<List<ListSomasi>> listSomasi (int idAgent);
    
    Future<List<ListSomasi>> listSomasiKA (int idAgent);
    
    Future<List<KonsumenAggrement>> historyKA (int idAgent);
    
    Future<List<KonsumenAggrement>> history (int idAgent);
    
    Future<List<KonsumenAggrement>> listUnCompleted ();
    
    Future<List<KonsumenAggrement>> listDebiturAdmin (String userId);
    
    Future<List<KonsumenAggrement>> listDebiturAgentPos (int idAgent);
    
    Future<List<KonsumenAggrement>> listAllDebitur();
}
