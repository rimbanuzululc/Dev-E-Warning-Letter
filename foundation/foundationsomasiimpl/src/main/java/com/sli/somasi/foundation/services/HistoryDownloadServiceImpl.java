/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.HistoryDownloadDAO;
import com.sli.somasi.foundation.dto.HistoryDownload;
import com.sli.somasi.foundation.service.HistoryDownloadService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;

/**
 *
 * @author hp
 */
@Service
public class HistoryDownloadServiceImpl implements HistoryDownloadService{
    
    @AutoWired
    HistoryDownloadDAO dao; 

    @Override
    public Future<HistoryDownload> add(HistoryDownload historyDownload) {
        return dao.add(historyDownload);
    }

    @Override
    public Future<HistoryDownload> update(HistoryDownload historyDownload) {
        return dao.update(historyDownload); 
    }
    
}
