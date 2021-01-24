/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.CodedException;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.AssignDTO;
import com.sli.somasi.foundation.dto.AgentPos;
import com.sli.somasi.foundation.service.AgentPosService;
import io.starlight.AutoWired;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;

/**
 *
 * @author hp
 */
@RestController(value = "/agentpos")
public class AgentPosController {
    
    @AutoWired
    AgentPosService service;
    
    @RequestMapping(value = "/add", method = HttpMethod.POST)
    public Future<APIResult> add (@RequestBody AgentPos agentPos) {
        
        Future<APIResult> result = Future.future();
       
       service.add(agentPos)
               .setHandler(ret -> {
                   
                APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("ZIPCODE_ALREADY_TAKEN");
                }
               
                result.complete(apiResult);
               });
        return result;
    }
    
    @RequestMapping(value = "/edit", method = HttpMethod.PUT)
    public Future<APIResult> edit (@RequestBody AgentPos agentPos) {
        
        Future<APIResult> result = Future.future();
        
        service.edit(agentPos)
                .setHandler(ret -> {
                    
                APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Fail to Edit");
                }
               
                result.complete(apiResult);
                
                });
        return result;
    }
    
    @RequestMapping(value = "/list")
    public Future<APIResult> list () {
        
        Future<APIResult> result = Future.future();
       
       service.list()
               .setHandler(ret -> {
                   
                APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Gagal Add Konsumen");
                }
               
                result.complete(apiResult);
               });
        return result;
    }
    
   @RequestMapping(value = "/assign", method = HttpMethod.POST)
   public Future<APIResult> assignKOnsumen (@RequestBody AssignDTO assignDTO) {
       
       Future<APIResult> result = Future.future();
       service.assign(assignDTO.getListIdKonsumen(), assignDTO.getIdAgentPos())
               .setHandler(ret -> {
               
               APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Gagal Assign");
                }
               
                result.complete(apiResult);
               });
        return result;
   }
   
   @RequestMapping(value = "/assign/finance", method = HttpMethod.POST)
   public Future<APIResult> assignKOnsumenFinance (@RequestBody AssignDTO assignDTO) {
       
       Future<APIResult> result = Future.future();
       service.assignFinance(assignDTO.getListIdKonsumen(), assignDTO.getIdAgentPos())
               .setHandler(ret -> {
               
               APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Gagal Assign");
                }
               
                result.complete(apiResult);
               });
        return result;
   }
   
   @RequestMapping(value = "/listAssign")
    public Future<APIResult> listAssignded () {
        
        Future<APIResult> result = Future.future();
       
       service.listAssign()
               .setHandler(ret -> {
                   
                APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Gagal List Assignded");
                }
               
                result.complete(apiResult);
               });
        return result;
    }
    
    @RequestMapping(value = "/login", method = HttpMethod.POST)
    public Future<APIResult> login (@QueryParam("username") String username, @QueryParam("password") String password) {
        
        Future<APIResult> result = Future.future();
        
        service.login(username, password)
                .setHandler(ret -> {
                    
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.error(ret.cause());
                        result.complete(apiResult);
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
    
    @RequestMapping(value = "/update/password", method = HttpMethod.POST)
    public Future<APIResult> updatePass (@QueryParam("username") String username, @QueryParam("password") String password) {
        
        Future<APIResult> result = Future.future();
        
        service.updatePass(username, password)
                .setHandler(ret -> {
                    
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.error(ret.cause());
                        result.complete(apiResult);
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
    
    
    @RequestMapping(value = "/search")
    public Future<APIResult> search (@QueryParam("districtid") Integer districtid) {
        
        Future<APIResult> result = Future.future();
       
       service.search(districtid)
               .setHandler(ret -> {
                   
                APIResult apiResult = new APIResult();
                
                if (ret.succeeded()) {
                    
                    apiResult.setResult(ret.result());
                } else {
                    apiResult.setErrorMsg("Gagal Add Konsumen");
                }
               
                result.complete(apiResult);
               });
        return result;
    }
    
}
