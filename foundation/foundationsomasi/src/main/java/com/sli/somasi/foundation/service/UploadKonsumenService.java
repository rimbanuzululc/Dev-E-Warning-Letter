/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.UploadResultDTO;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
public interface UploadKonsumenService {
    
    Future<UploadResultDTO> getFileExcel (String file);
    Future<UploadResultDTO> getFileExcelFinance (String file);
}
