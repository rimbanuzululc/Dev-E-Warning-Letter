package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.Role;
import com.sli.somasi.foundation.service.RoleService;
import com.sli.somasi.foundation.dto.RoleMenu;
import com.sli.somasi.foundation.service.MenuService;
import com.sli.somasi.foundation.service.RoleMenuService;
import io.starlight.AutoWired;
import io.starlight.http.PathParam;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;

/**
 *
 * @author anisa.pebriani
 */

@RestController("/role")
public class RoleController {
    
    @AutoWired 
    protected RoleService service;
    
    @AutoWired 
    protected RoleMenuService serviceMenu;
    
    @RequestMapping(value = "", method = HttpMethod.PUT)
    public Future<APIResult> add(@RequestBody Role role) {
        
        Future<APIResult> result = Future.future();
        
        service.add(role)
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
    
    @RequestMapping(value = "/menu", method = HttpMethod.PUT)
    public Future<APIResult> addMenu(@RequestBody RoleMenu roleMenu) {
        
        Future<APIResult> result = Future.future();
        
        serviceMenu.add(roleMenu)
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
    
     @RequestMapping(value = "/menu", method = HttpMethod.POST)
    public Future<APIResult> updaterolemenu(@RequestBody RoleMenu roleMenu) {
        
        Future<APIResult> result = Future.future();
        
        serviceMenu.update(roleMenu)
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
    
    @RequestMapping(value = "", method = HttpMethod.POST)
    public Future<APIResult> update(@RequestBody Role role) {
        
        Future<APIResult> result = Future.future();
        
        service.update(role)
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
    
    @RequestMapping(value = "/byid/:id", method = HttpMethod.DELETE)
    public Future<APIResult> delete(@PathParam("id") int id) {
        
        Future<APIResult> result = Future.future();
        
        service.delete(id)
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
    
    @RequestMapping("/search")
    public Future<APIResult> search(@QueryParam("filter") String filter, @QueryParam("page") int page) {
        
        Future<APIResult> result = Future.future();
        
        service.search(filter, page)
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
    
    @RequestMapping("/byid/:id")
    public Future<APIResult> get(@PathParam("id") int id) {
        
        Future<APIResult> result = Future.future();
        
        service.getId(id)
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
    
    @RequestMapping("/listAll")
    public Future<APIResult> listRole() {
        
        Future<APIResult> result = Future.future();
        
        service.listAll()
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
    
    @RequestMapping("/menu/list/:id")
    public Future<APIResult> list(@PathParam("id") int id) {
        
        Future<APIResult> result = Future.future();
        
        serviceMenu.listByRoleId(id)
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
