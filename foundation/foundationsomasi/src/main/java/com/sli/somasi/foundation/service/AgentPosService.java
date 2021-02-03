/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.AgentPos;
import com.sli.somasi.foundation.dto.Assign;
import com.sli.somasi.foundation.dto.Konsumen;
import com.sli.somasi.foundation.dto.OTP;
import com.sli.somasi.foundation.dto.UpdatePassword;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import io.vertx.core.Future;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public interface AgentPosService {
    
    Future<AgentPos> add (AgentPos agentPos);
    Future<List<AgentPos>> list ();
    Future<Boolean> assign (List<Integer> listIdKonsumen, int idAgent);
    Future<Boolean> assignFinance (List<Integer> listKonsumenId, int idAgent);
    Future<Assign> listAssign();
    Future<AgentPos> login (String username, String password);
    
    Future<UpdatePassword> updatePass (String username, String password);
    
    Future<String> generatePDFFromTempate(String templateId, Map<String, Object> variable);
    
    Future<List<AgentPos>> search (int id);
    
    Future<AgentPos> edit (AgentPos agentPos);
    Future<AgentPos> getById (int idAgentPos);
    
    Future<OTP> sendOTP (OTP otp);
    
    Future<Boolean> validateOTP (OTP otp);
    
}
