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
import com.sli.somasi.foundation.service.KonsumenAggrementService;
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
    
    @AutoWired
    KonsumenAggrementService konsumenAggreService;
    
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
    public Future<APIResult> listDebiturAdmin(@QueryParam ("userId") String userId) {
        
        Future<APIResult> result = Future.future();
        
        konsumenAggreService.listDebiturAdmin(userId)
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
    
    @RequestMapping("/listnodebitur")
    public Future<APIResult> listNoDebiturAdmin(@QueryParam ("userId") String userId) {
        
        Future<APIResult> result = Future.future();
        
        assignService.listNoDebiturAdmin(userId)
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
    
    @RequestMapping("/reportallkapos")
    public Future<APIResult> reportAllKAPos() {
        
        Future<APIResult> result = Future.future();
        
        kapos.reportAllVerifikasi()
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
    
    @RequestMapping("/reportallsenddebitur")
    public Future<APIResult> reportAllSendDebitur() {
        
        Future<APIResult> result = Future.future();
        
        assignService.reportAllSendDebitur()
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
    
    @RequestMapping("/listallnodebitur")
    public Future<APIResult> listAllNoDebitur() {
        
        Future<APIResult> result = Future.future();
        
        assignService.listAllNoDebitur()
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
