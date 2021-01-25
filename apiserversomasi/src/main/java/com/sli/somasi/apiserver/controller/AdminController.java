package com.sli.somasi.apiserver.controller;

/**
 *
 * @author aldy.kurniawan
 */

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.service.AssignFinanceService;
import io.starlight.AutoWired;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;


@RestController("/assign")
public class AdminController {
    
    @AutoWired
    AssignFinanceService assignService;
    
    @RequestMapping(value = "", method = HttpMethod.POST)
    public Future<APIResult> update(@RequestBody AssignFinance assignFinance) {
        
        Future<APIResult> result = Future.future();
        
        assignService.update(assignFinance)
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
    
    @RequestMapping("/listdebitur")
    public Future<APIResult> listDebitur() {
        
        Future<APIResult> result = Future.future();
        
        assignService.listDebitur()
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
    
    @RequestMapping("/listnodebitur")
    public Future<APIResult> listNoDebitur() {
        
        Future<APIResult> result = Future.future();
        
        assignService.listNoDebitur()
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