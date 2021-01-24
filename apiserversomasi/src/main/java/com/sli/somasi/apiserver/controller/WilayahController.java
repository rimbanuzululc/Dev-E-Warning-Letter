/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.service.CityService;
import com.sli.somasi.foundation.service.DistrictService;
import com.sli.somasi.foundation.service.StateService;
import com.sli.somasi.foundation.service.SubDistrcitService;
import com.sli.somasi.foundation.service.ZipcodeService;
import io.starlight.AutoWired;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@RestController(value = "/wilayah")
public class WilayahController {
    
    @AutoWired
    StateService stateService;
    
    @AutoWired
    CityService cityService;
    
    @AutoWired
    DistrictService districtService;
    
    @AutoWired
    SubDistrcitService kelurahanService;
    
    @AutoWired
    ZipcodeService zipcodeService;
    
    @RequestMapping(value = "/state")
    public Future<APIResult> state () {
        
        Future<APIResult> result = Future.future();

        stateService.listAll()
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
    
    @RequestMapping(value = "/city")
    public Future<APIResult> City (@QueryParam("stateId") Integer stateId) {
        
        Future<APIResult> result = Future.future();

        cityService.listCityByState(stateId)
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
    
    @RequestMapping(value = "/district")
    public Future<APIResult> District (@QueryParam("cityId") Integer cityId) {
        
        Future<APIResult> result = Future.future();

        districtService.listDistrictByCity(cityId)
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
    
    @RequestMapping(value = "/kelurahan")
    public Future<APIResult> Kelurahan (@QueryParam("districtId") Integer districtId) {
        
        Future<APIResult> result = Future.future();

        kelurahanService.listSubDistrictByDistrict(districtId)
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
    
    @RequestMapping(value = "/zipcode")
    public Future<APIResult> Zipcode (@QueryParam("code") String code) {
        
        Future<APIResult> result = Future.future();
        
        zipcodeService.listZipcodeByKecamatan(code)
                .setHandler(ret -> {
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.setErrorMsg("Gagal get ZipCode");
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
}
