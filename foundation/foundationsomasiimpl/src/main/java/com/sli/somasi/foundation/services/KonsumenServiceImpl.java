/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.KonsumenDAO;
import com.sli.somasi.foundation.dto.Konsumen;
import com.sli.somasi.foundation.service.KonsumenService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class KonsumenServiceImpl implements KonsumenService{
    
    @AutoWired
    KonsumenDAO dao;

    @Override
    public Future<Konsumen> add(Konsumen konsumen) {
        return dao.add(konsumen);
    }

    @Override
    public Future<List<Konsumen>> list() {
        return dao.list();
    }

    @Override
    public Future<List<Konsumen>> search(String param, String filter, int page) {
        return dao.search(param, filter, page);
    }

    @Override
    public Future<List<Konsumen>> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
