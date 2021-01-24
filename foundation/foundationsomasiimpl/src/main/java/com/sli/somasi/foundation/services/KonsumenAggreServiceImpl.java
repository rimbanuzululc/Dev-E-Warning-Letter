/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.KonsumenAggreDAO;
import com.sli.somasi.foundation.dto.KonsumenAggrement;
import com.sli.somasi.foundation.dto.ListSomasi;
import com.sli.somasi.foundation.service.KonsumenAggrementService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */

@Service
public class KonsumenAggreServiceImpl implements KonsumenAggrementService {

    @AutoWired
    KonsumenAggreDAO  aggreDAO;
    
    @Override
    public Future<KonsumenAggrement> add(KonsumenAggrement aggremnt) {
        return aggreDAO.add(aggremnt);
    }

    @Override
    public Future<List<KonsumenAggrement>> list() {
        return aggreDAO.list();
    }

    @Override
    public Future<List<KonsumenAggrement>> search(String param, String value, String startDate, String endDate, int page) {
        return aggreDAO.search(param, value, startDate, endDate, page);
    }

    @Override
    public Future<KonsumenAggrement> getByNoAggrement(String no) {
        return aggreDAO.getByNo(no);
    }

    @Override
    public Future<List<ListSomasi>> listSomasi(int idAgent) {
        
        Future<List<ListSomasi>> result = Future.future();
        List<Future> listFuture = new ArrayList<>();
        
        return
        aggreDAO.getKonsumenByIdAgent(idAgent)
                .compose(konsumen -> {
                
                    if (konsumen.get(0) != null) {
                        
                        for (int i = 0; i < konsumen.size(); i++) 
                        {
                            
                            listFuture.add(checkStatusSomasi(konsumen.get(i)));
                        }
                    } 
                    return CompositeFuture.join(listFuture);
        })
        .compose(ret -> {
        
            return aggreDAO.listSomasi(idAgent);
        })
        .compose(ret2 -> {
            
            return Future.succeededFuture(ret2);
        });
    }
    
    public Future<KonsumenAggrement> checkStatusSomasi (KonsumenAggrement aggrement) {
        
        Future<KonsumenAggrement> result = Future.future();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date sp1 = aggrement.getSendSomasi1Date();
        String today = sdf.format(date);
        System.out.println("Status Somasi : "+ aggrement.getType());
        
        if (sp1 != null) {
                    String tglsp1 = sdf.format(sp1);

            try {
                
                Date harini = sdf.parse(today);
                long selisih = harini.getTime() - sp1.getTime();
                System.out.println("Hari ini : "+ today);
                System.out.println("Tanggal SP1 : "+ tglsp1);
                
                long selisihDay = selisih / (24 * 60 * 60 * 1000);
                System.out.println("Selisih : " + selisihDay + "Hari");

                
                if (selisihDay > 5) {
                    aggrement.setType("SOMASI2");
                }
                
            } catch (Exception e) {
                
            }
            
        }
        
        aggreDAO.update(aggrement)
                .setHandler(ret -> {
                    
                    if (ret.result() != null) {
                        result.complete(ret.result());
                    }
                });
        
        return result;
    }

    @Override
    public Future<List<KonsumenAggrement>> history(int idAgent) {
        return aggreDAO.history(idAgent);
    }

    @Override
    public Future<List<ListSomasi>> listSomasiKA(int idAgent) {
        return aggreDAO.listSomasiKA(idAgent);
    }

    @Override
    public Future<List<KonsumenAggrement>> historyKA(int idAgent) {
        return aggreDAO.historyKA(idAgent);
    }
    
}
