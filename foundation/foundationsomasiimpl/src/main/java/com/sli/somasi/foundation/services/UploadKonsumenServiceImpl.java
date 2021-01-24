/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.KonsumenDAO;
import com.sli.somasi.foundation.dao.UploadFinanceDAO;
import com.sli.somasi.foundation.dao.UploadKonsumenDAO;
import com.sli.somasi.foundation.dto.UploadResultDTO;
import com.sli.somasi.foundation.service.UploadKonsumenService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@Service
public class UploadKonsumenServiceImpl implements UploadKonsumenService{
    
    @AutoWired
    UploadKonsumenDAO dao;
    
    @AutoWired
    UploadFinanceDAO financeDAO;

    @Override
    public Future<UploadResultDTO> getFileExcel(String file) {
        return dao.getFileExcel(file);
    }

    @Override
    public Future<UploadResultDTO> getFileExcelFinance(String file) {
        return financeDAO.getFileExcel(file);
    }
    
}
