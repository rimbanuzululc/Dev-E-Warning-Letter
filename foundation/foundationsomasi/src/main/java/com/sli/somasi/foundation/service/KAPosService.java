/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.ConfirmKAPos;
import io.vertx.core.Future;

/**
 *
 * @author aldy.kurniawan
 */
public interface KAPosService {
    
    Future<ConfirmKAPos> submit(ConfirmKAPos confirm);
}
