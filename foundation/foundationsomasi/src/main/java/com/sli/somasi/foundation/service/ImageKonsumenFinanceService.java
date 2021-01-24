/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.ImageKonsumenFinance;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ImageKonsumenFinanceService {
    
    Future<ImageKonsumenFinance> add (ImageKonsumenFinance finance);
    
    Future<List<ImageKonsumenFinance>> list();
    
    Future<List<ImageKonsumenFinance>> history (Integer id);
    
    Future<ImageKonsumenFinance> getImage (String filename, Integer id);
    
    
}
