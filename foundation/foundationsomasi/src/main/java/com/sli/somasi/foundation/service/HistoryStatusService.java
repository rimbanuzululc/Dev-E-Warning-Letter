/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.SubmitSomasi;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
public interface HistoryStatusService {
    
    Future<String> add (String code, int konsumenId, int idAgentPos);
    
    Future<String> submit(SubmitSomasi somasi);
    
    Future<String> submitKA(Integer konsumenId, String code, String type, Integer agentId);
}
