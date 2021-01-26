/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.ConfirmAgentPosDAO;
import com.sli.somasi.foundation.dto.ConfirmAgentPos;
import com.sli.somasi.foundation.service.ConfirmAgentPosService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
@Service
public class ConfirmAgentPosServiceImpl  implements ConfirmAgentPosService{

    @AutoWired
    ConfirmAgentPosDAO capdao;
    
    @Override
    public Future<List<ConfirmAgentPos>> list (String code) {
        return capdao.list(code);
    }
    
}
