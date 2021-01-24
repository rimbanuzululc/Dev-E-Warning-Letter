/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.dto.MappingArea;
import com.sli.somasi.foundation.service.DistrictService;
import com.sli.somasi.foundation.service.MappingAreaService;
import io.starlight.AutoWired;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;

/**
 *
 * @author hp
 */
@RestController(value = "/mapping/area")
public class MappingAreaController {
    
    @AutoWired
    MappingAreaService area;
    
    @AutoWired
    DistrictService districtService;
    
    @RequestMapping(value = "/add", method = HttpMethod.POST)
    public Future<APIResult> add (@RequestBody MappingArea mappingArea) {
        Future<APIResult> result = Future.future();
        
        area.add(mappingArea)
                .setHandler(ret -> {
                    
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.setResult("Eror!!");
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
    
    @RequestMapping(value = "/list")
    public Future<APIResult> list () {
        Future<APIResult> result = Future.future();
        
        area.list()
                .setHandler(ret -> {
                    
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.setResult("Eror!!");
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
    
    @RequestMapping(value = "/list/code")
    public Future<APIResult> listBykodeArea (@QueryParam("codeArea") String codeArea) {
        Future<APIResult> result = Future.future();
        
        districtService.listDistrictByKodeArea(codeArea)
                .setHandler(ret -> {
                    
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()) {
                        apiResult.setResult(ret.result());
                    } else {
                        apiResult.setResult("Eror!!");
                    }
                    
                    result.complete(apiResult);
                });
        return result;
    }
    
}
