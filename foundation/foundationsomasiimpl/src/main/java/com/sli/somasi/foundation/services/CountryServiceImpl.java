/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.CountryDAO;
import com.sli.somasi.foundation.dto.Country;
import com.sli.somasi.foundation.service.CountryService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author Aldy Kurniawan S
 */

@Service
public class CountryServiceImpl implements CountryService{

    @AutoWired
    protected CountryDAO dao;
    
    
    @Override
    public Future<List<Country>> listAll() {
        
        return dao.listAll();
    }
    
    
}
