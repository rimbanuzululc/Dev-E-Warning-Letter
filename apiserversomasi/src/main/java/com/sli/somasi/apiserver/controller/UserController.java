package com.sli.somasi.apiserver.controller;

import com.sli.somasi.apiserver.dto.APIResult;
import com.sli.somasi.apiserver.dto.LoginRequest;
import com.sli.somasi.apiserver.dto.LoginResult;
import com.sli.somasi.apiserver.service.TokenService;
import com.sli.somasi.foundation.CodedException;
import com.sli.somasi.foundation.Errors;
import com.sli.somasi.foundation.dto.HakAksesDTO;
import com.sli.somasi.foundation.dto.Menu;
import com.sli.somasi.foundation.dto.SubMenu;
import com.sli.somasi.foundation.dto.User;
import com.sli.somasi.foundation.service.UserService;
import io.starlight.AutoWired;
import io.starlight.http.PathParam;
import io.starlight.http.QueryParam;
import io.starlight.http.RequestBody;
import io.starlight.http.RequestMapping;
import io.starlight.http.RestController;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denny
 */
@RestController("/user")
public class UserController {
    
    @AutoWired
    protected TokenService tokenService;
    
    @AutoWired
    protected UserService userService;
    
    @RequestMapping("/test")
    public Future<APIResult> test() {
        
        return Future.succeededFuture(new APIResult("Test Result"));
    }
    
    @RequestMapping("/testx")
    public Future<APIResult> testX() {
        
        return Future.succeededFuture(new APIResult("Test Result Protected URL"));
    }
    
    @RequestMapping(value = "/testy")
    public Future<APIResult> testY(@RequestBody String body) {
        
        return Future.succeededFuture(new APIResult("Test Result TestY"));
    }
    
    @RequestMapping(value = "/login", method = HttpMethod.POST)
    public Future<APIResult> login(@RequestBody LoginRequest request) {
        
        Future<APIResult> future = Future.future();
        APIResult result = new APIResult();
        
        userService.login(request.getUserId(), request.getPassword())
            .setHandler(ret -> {
                    
                if (ret.succeeded()) {
                    
                    LoginResult loginResult = new LoginResult();
                    loginResult.setAccessToken(tokenService.generateToken(request.getUserId()));
                    loginResult.setUser(ret.result());
                    result.setResult(loginResult);
                    future.complete(result);
                }
                else {
                    result.error(ret.cause());
                    future.complete(result);
                }
                     
                    
            });
        
        return future;
    }
    
    @RequestMapping("/byuserid/:userId")
    public Future<APIResult> get(@PathParam("userId") String userId) {
        
        Future<APIResult> future = Future.future();
        APIResult result = new APIResult();
        
        User usr = new User();
        usr.setUserId(userId);
        usr.setName("Test");
        usr.setPassword("xxx");
        
        result.setResult(usr);
        
        future.complete(result);
                
        /*
        userService.get(userId)
                    .setHandler(ret -> {
                       
                        if (ret.succeeded()) {
                            
                            result.setResult(ret.result());
                            future.complete(result);
                        }
                        else
                            future.fail(ret.cause());
                    });
        */
        
        return future;
    }
    
    @RequestMapping(value = "", method = HttpMethod.POST)
    public Future<APIResult> add(@RequestBody User user) {
        
        Future<APIResult> result = Future.future();
        
        userService.add(user)
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
    
    @RequestMapping(value = "", method = HttpMethod.PUT)
    public Future<APIResult> update(@RequestBody User user) {
        
        Future<APIResult> result = Future.future();
        
        userService.update(user)
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
    
    @RequestMapping("/search")
    public Future<APIResult> search(@QueryParam("filter") String filter, @QueryParam("page") int page) {
        
        Future<APIResult> result = Future.future();
        
        userService.search(filter, page)
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
    
    @RequestMapping(value = "/byid/:id", method = HttpMethod.DELETE)
    public Future<APIResult> delete(@PathParam("id") String id) {
        
        Future<APIResult> result = Future.future();
        
        userService.delete(id)
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
    
    @RequestMapping(value="/hakakses/:id", method = HttpMethod.GET)
    public Future<APIResult> hakAkses(@PathParam("id") String userId) {
        
        Future<APIResult> result = Future.future();
        System.out.println("------------"+userId);
        userService.hakAkses(userId)
                .setHandler(ret -> {
                   
                    APIResult apiResult = new APIResult();
                    
                    if (ret.succeeded()){
                        apiResult.setResult(ret.result());
                    }else{
                        apiResult.error(ret.cause());
                    }
                    result.complete(apiResult);
                });
        
        return result;
    }
    
    @RequestMapping(value = "/update/password", method = HttpMethod.PUT)
    public Future<APIResult> updatePass (@QueryParam("username") String userId, @QueryParam("password") String password) {
        
        Future<APIResult> result = Future.future();
        
        userService.updatePass(userId, password)
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
}
