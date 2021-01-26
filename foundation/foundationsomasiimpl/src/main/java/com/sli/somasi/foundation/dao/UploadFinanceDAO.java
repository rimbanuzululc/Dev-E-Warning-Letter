/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dao;

import com.sli.somasi.foundation.dto.Assign;
import com.sli.somasi.foundation.dto.AssignFinance;
import com.sli.somasi.foundation.dto.KonsumenAggrement;
import com.sli.somasi.foundation.dto.UploadFailureDTO;
import com.sli.somasi.foundation.dto.UploadResultDTO;
import io.starlight.AutoWired;
import io.starlight.db.CommonDAO;
import io.starlight.db.DAO;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author hp
 */
@DAO(config = "db")
public class UploadFinanceDAO extends CommonDAO{
    
    @AutoWired
    protected AgentPosDAO agentPosDao;
    
    @AutoWired
    protected AssignFinanceDAO assignFinanceDao;
    
    public Future<UploadResultDTO> getFileExcel (String file) {
        
        UploadResultDTO resultDTO = new UploadResultDTO();
        System.out.println("file : " + file);
        Future<String> result = Future.future();

        byte[] bytes = vertx().fileSystem().readFileBlocking(file).getBytes();
        System.out.println("Bytes : " + Arrays.toString(bytes));
        InputStream iss = new ByteArrayInputStream(bytes);
        
        try {

            return readExcelAndInsert(iss)
                    .setHandler(ret -> {
                        if (ret.succeeded()) {
                            result.complete();
                        } else {
                            result.fail(ret.cause());
                        }
                    });

        } catch (InvalidFormatException | IOException ex) {
            result.fail(ex.getCause());
        }
        return Future.succeededFuture(resultDTO);
    }
    
    private Future<UploadResultDTO> readExcelAndInsert(InputStream iss) throws IOException, InvalidFormatException {
        UploadResultDTO resultDTO = new UploadResultDTO();
        List<UploadFailureDTO> failures = new ArrayList<>();
        resultDTO.setFailures(failures);
        List<Future> futures = new ArrayList<>();
        
        Workbook workbook = WorkbookFactory.create(iss);

        Sheet sheet = workbook.getSheetAt(0);


        Iterator<Row> rowIterator = sheet.rowIterator();

        if (rowIterator.hasNext()) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            resultDTO.addTotalRow();
            
            Row row = rowIterator.next();
            
            futures.add(processRowKon(sheet, resultDTO, row));
        }

        return CompositeFuture.all(futures)
                .compose(ret2 -> {

                    return Future.succeededFuture(resultDTO);
                });

       
    }
    
    public Future<UploadResultDTO> processRowKon (Sheet sheet, UploadResultDTO resultDTO, Row row) {
        
        Future<UploadResultDTO> future = Future.future();
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        Date currentDate = calendar.getTime();
        
        Map<String, Integer> data = new HashMap<>();
        Map<String, String> data2 = new HashMap<>();
        DataFormatter formatter = new DataFormatter();
        
        UploadFailureDTO f = new UploadFailureDTO();
        
        String noAggrement              = formatter.formatCellValue(row.getCell(0));
        String namaDebitur              = formatter.formatCellValue(row.getCell(1));
        String alamatKtp                = formatter.formatCellValue(row.getCell(2));
        String provinsiKtp              = formatter.formatCellValue(row.getCell(3));
        String kotaKtp                  = formatter.formatCellValue(row.getCell(4));
        String kecamatanKtp             = formatter.formatCellValue(row.getCell(5));
        String kelurahanKtp             = formatter.formatCellValue(row.getCell(6));
        Double zipcodeKtp               = row.getCell(7) == null ? null : row.getCell(7).getNumericCellValue();
        String alamatTinggal            = formatter.formatCellValue(row.getCell(8));
        String provinsiTinggal          = formatter.formatCellValue(row.getCell(9));
        String kotaTinggal              = formatter.formatCellValue(row.getCell(10));
        String kecamatanTinggal         = formatter.formatCellValue(row.getCell(11));
        String kelurahanTinggal         = formatter.formatCellValue(row.getCell(12));
        Double zipcodeTinggal           = row.getCell(13) == null ? null : row.getCell(13).getNumericCellValue();
        String noTelp                   = formatter.formatCellValue(row.getCell(14));
        String jenisPerjanjian          = formatter.formatCellValue(row.getCell(15));
        String tglPerjanjian            = formatter.formatCellValue(row.getCell(16));
        String merkKendaraan            = formatter.formatCellValue(row.getCell(17));
        String tahunKendaraan           = formatter.formatCellValue(row.getCell(18));
        String kondisiKendaraan         = formatter.formatCellValue(row.getCell(19));
        String nomorPolisi              = formatter.formatCellValue(row.getCell(20));
        String nomorMesin               = formatter.formatCellValue(row.getCell(21));
        String nomorRangka              = formatter.formatCellValue(row.getCell(22));
        String warna                    = formatter.formatCellValue(row.getCell(23));
        String nomorBpkb                = formatter.formatCellValue(row.getCell(24));
        String nomorStnk                = formatter.formatCellValue(row.getCell(25));
        String sertifikatJaminan        = formatter.formatCellValue(row.getCell(26));
        String atasNamaBpkb             = formatter.formatCellValue(row.getCell(27));
        String alamatBpkb               = formatter.formatCellValue(row.getCell(28));
        Double installment              = row.getCell(29) == null ? null : row.getCell(29).getNumericCellValue();
        Double sisaOutstanding          = row.getCell(30) == null ? null : row.getCell(30).getNumericCellValue();
        String tglMulaiMenunggak        = formatter.formatCellValue(row.getCell(31));
        String tglSp1                   = formatter.formatCellValue(row.getCell(32));
        String tglSp2                   = formatter.formatCellValue(row.getCell(33));
        String kronologi                = formatter.formatCellValue(row.getCell(34));
        
        System.out.println("---- Cell 00" + formatter.formatCellValue(row.getCell(0)) );
        System.out.println("---- Cell 07" + formatter.formatCellValue(row.getCell(7)) );
        
        Integer zipcodeKtp_int = null;
        if (zipcodeKtp != null) {
            zipcodeKtp_int = zipcodeKtp.intValue();
        }
        
        Integer zipcodeTinggal_int = null;
        if (zipcodeTinggal != null) {
           zipcodeTinggal_int = zipcodeTinggal.intValue();
        }
        
        Integer installment_int = null;
        if (installment != null) {
            installment_int = installment.intValue();
        }
        
        Integer sisaOutstanding_int = null;
        if (sisaOutstanding != null) {
            sisaOutstanding_int = sisaOutstanding.intValue();
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date tglMenunggak = null;
        Date tgl_Pejanjian = null;
        Date sp_1 = null;
        Date sp_2 = null;
        
        System.out.println("tglMulaiMenunggak : " +tglMulaiMenunggak);
        System.out.println("tglPerjanjian : " +tglPerjanjian);
        
        try {
            
            tglMenunggak = sdf.parse(tglMulaiMenunggak);
            tgl_Pejanjian = sdf.parse(tglPerjanjian);
            sp_1 = sdf.parse(tglSp1);
            sp_2 = sdf.parse(tglSp2);
            
        } catch (Exception e) {
        }
        
        
        KonsumenAggrement konsumen = new KonsumenAggrement();
        
        konsumen.setAlamatBpkb(alamatBpkb);
        konsumen.setAlamatKtp(alamatKtp);
        konsumen.setAlamatTinggal(alamatTinggal);
        konsumen.setAtasNamaBpkb(atasNamaBpkb);
        konsumen.setInstallment(installment_int);
        konsumen.setJenisPerjanjian(jenisPerjanjian);
        konsumen.setKecamatanKtp(kecamatanKtp);
        konsumen.setKecamatanTinggal(kecamatanTinggal);
        konsumen.setKelurahanKtp(kelurahanKtp);
        konsumen.setKelurahanTinggal(kelurahanTinggal);
        konsumen.setKondisiKendaraan(kondisiKendaraan);
        konsumen.setKotaKtp(kotaKtp);
        konsumen.setKotaTinggal(kotaTinggal);
        konsumen.setKronologi(kronologi);
        konsumen.setMerkKendaraan(merkKendaraan);
        konsumen.setNamaDebitur(namaDebitur);
        konsumen.setNoAggrement(noAggrement);
        konsumen.setNoTelp(noTelp);
        konsumen.setNomorBpkb(nomorBpkb);
        konsumen.setNomorMesin(nomorMesin);
        konsumen.setNomorPolisi(nomorPolisi);
        konsumen.setNomorRangka(nomorRangka);
        konsumen.setNomorStnk(nomorStnk);
        konsumen.setProvinsiKtp(provinsiKtp);
        konsumen.setProvinsiTinggal(provinsiTinggal);
        konsumen.setSertifikatJaminan(sertifikatJaminan);
        konsumen.setSisaOutstanding(sisaOutstanding_int);
        konsumen.setTahunKendaraan(tahunKendaraan);
        konsumen.setTglMulaiMenunggak(tglMenunggak);
        konsumen.setTglPerjanjian(tgl_Pejanjian);
        konsumen.setTglSp1(sp_1);
        konsumen.setTglSp2(sp_2);
        konsumen.setUpload_date(currentDate);
        konsumen.setWarna(warna);
        konsumen.setZipcodeKtp(zipcodeKtp_int);
        konsumen.setZipcodeTinggal(zipcodeTinggal_int);
        
        konsumen.setIsCompleted(true);
        
        
        super.insert(konsumen)
                .compose(ret -> {
                    
                    if (ret.getNamaDebitur() == null || ret.getNoAggrement() == null || ret.getAlamatKtp() == null || ret.getProvinsiKtp() == null || 
                            ret.getKotaKtp() == null || ret.getKecamatanKtp() == null || ret.getKelurahanKtp() == null || ret.getZipcodeKtp() == null || 
                            ret.getNamaDebitur().equalsIgnoreCase("") || ret.getNoAggrement().equalsIgnoreCase("") || ret.getAlamatKtp().equalsIgnoreCase("") || 
                            ret.getProvinsiKtp().equalsIgnoreCase("")  || ret.getKotaKtp().equalsIgnoreCase("") || ret.getKecamatanKtp().equalsIgnoreCase("") || ret.getKelurahanKtp().equalsIgnoreCase("")){
                        
                        KonsumenAggrement temp = new KonsumenAggrement();
                        temp.setKonsumenId(ret.getKonsumenId());
                        temp.setIsCompleted(false);
                        super.update(temp);
                        logger.info("Data Konsumen Tidak Lengkap");
                    }
                    
                    agentPosDao.getByZipcode(konsumen.getZipcodeKtp().toString())
                        .setHandler(ret1 -> {
                    
                        if (ret1.succeeded() && ret1.result() != null){
                            AssignFinance assign = new AssignFinance();
                            assign.setIdAgentPos(ret1.result().getIdAgentpos());
                            assign.setAssign_date(new Date());
                            assign.setNoAggrement(ret.getNoAggrement());
                            assign.setKonsumenId(ret.getKonsumenId());
                            assignFinanceDao.add(assign);
                        }
                     });
                    
                    return Future.succeededFuture(resultDTO);
                })
                .setHandler(retVail -> {
                
                    if(retVail.failed()){
                                f.setObject(konsumen);
                                f.setRow(row.getRowNum());
                                f.setErrorMessage("error : " + retVail.cause().toString());  
                            resultDTO.getFailures().add(f);
                            
                            resultDTO.addFailed();
                            future.complete(resultDTO);
                        }else{
                                f.setObject(konsumen);
                                f.setRow(row.getRowNum());
                                f.setErrorMessage("Success");  
                            resultDTO.getFailures().add(f);
                            resultDTO.addSuccess();
                            future.complete(resultDTO);

                        }
                });
        
//        agentPosDao.getByZipcode(konsumen.getZipcodeKtp().toString())
//                .setHandler(ret1 -> {
//                    
//                    if (ret1.succeeded() && ret1.result() != null){
//                        AssignFinance assign = new AssignFinance();
//                        assign.setIdAgentPos(ret1.result().getIdAgentpos());
//                        assign.setAssign_date(new Date());
//                        assign.setNoAggrement(noAggrement);
//                        System.out.println("Konsumen ID2 == " + konsumen.getKonsumenId());
//                        assign.setKonsumenId(konsumen.getKonsumenId());
//                        assignFinanceDao.add(assign);
//                    }
//                });
        
        return future;
    }
    
}
