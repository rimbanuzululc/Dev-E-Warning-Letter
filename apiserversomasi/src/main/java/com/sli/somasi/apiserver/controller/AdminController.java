package com.sli.somasi.apiserver.controller;

/**
 *
 * @author aldy.kurniawan
 */

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.service.AssignFinanceService;
import com.sli.somasi.foundation.service.KAPosService;
import io.starlight.AutoWired;
import io.starlight.http.PathParam;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;


@RestController("/admin")
public class AdminController {
    
    @AutoWired
    AssignFinanceService assignService;
    
    @AutoWired
    KAPosService kapos;
    
    @RequestMapping(value = "", method = HttpMethod.PUT)
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
    
    @RequestMapping("/reportKAPOS")
    public Future<APIResult> reportKAPOS (@QueryParam ("userId") String userId) {
        
        Future<APIResult> result = Future.future();
        
        kapos.reportVerifikasiForAdmin(userId)
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
    
    @RequestMapping("/reportSendDebitur")
    public Future<APIResult> reportSendDebitur (@QueryParam ("userId") String userId) {
        
        Future<APIResult> result = Future.future();
        
        assignService.reportSendDebiturforAdmin(userId)
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
