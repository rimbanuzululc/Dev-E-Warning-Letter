/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.Zipcode;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ZipcodeService {
    
    Future<List<Zipcode>> listZipcodeByKecamatan (String code);
    
}
