/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.ConfirmKAPos;
import com.sli.somasi.foundation.service.AssignFinanceService;
import com.sli.somasi.foundation.service.KAPosService;
import com.sli.somasi.foundation.service.StatusKAPosService;
import io.starlight.AutoWired;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;

/**
 *
 * @author aldy.kurniawan
 */

@RestController("/kapos")
public class KAPosController {
    
    @AutoWired
    KAPosService service;
    
    @AutoWired
    AssignFinanceService financeService;
    
    @AutoWired
    StatusKAPosService statusService;
    
    @RequestMapping(value = "/submit", method = HttpMethod.POST)
    public Future<APIResult> submit(@RequestBody ConfirmKAPos confirm) {
        
        Future<APIResult> result = Future.future();
        
        service.submit(confirm)
                .setHandler(ret -> {
                   
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded())
                        apiResult.setResult(ret.result());
                    else
                        apiResult.error(ret.cause());
                    
                    result.complete(apiResult);
                });
        
        return result;
    }
    
    
    @RequestMapping("/listallstatus")
    public Future<APIResult> listAllStatus() {
        
        Future<APIResult> result = Future.future();
        
        statusService.listAll()
            .setHandler(ret -> {

                APIResult apiResult = new APIResult();

                if (ret.succeeded())
                    apiResult.setResult(ret.result());
                else
                    apiResult.error(Errors.COMMON, "" + ret.cause());

                result.complete(apiResult);
            });
        
        return result;
    }
    
    @RequestMapping("/reportVerfikasi")
    public Future<APIResult> reportVerifikasi (@QueryParam ("userId") String id) {
        
        Future<APIResult> result = Future.future();
        
        service.reportVerifikasi(id)
             .setHandler(ret -> {
                 
                 APIResult apiResult = new APIResult();

                if (ret.succeeded())
                    apiResult.setResult(ret.result());
                else
                    apiResult.error(Errors.COMMON, "" + ret.cause());

                result.complete(apiResult);
            });
        
        return result;
                 
    }
    
    @RequestMapping("/reportAllSend")
    public Future<APIResult> reportAllSendDebitur (@QueryParam ("userId") String userId) {
        
        Future<APIResult> result = Future.future();
        
        financeService.reportSendDebiturAll(userId)
             .setHandler(ret -> {
                 
                 APIResult apiResult = new APIResult();

                if (ret.succeeded())
                    apiResult.setResult(ret.result());
                else
                    apiResult.error(Errors.COMMON, "" + ret.cause());

                result.complete(apiResult);
            });
        
        return result;
    }
        
}
