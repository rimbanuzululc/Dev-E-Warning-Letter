/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.services;

import com.sli.somasi.foundation.dao.ImageKonsumenFinanceDAO;
import com.sli.somasi.foundation.dto.ImageKonsumenFinance;
import com.sli.somasi.foundation.service.ImageKonsumenFinanceService;
import io.starlight.AutoWired;
import io.starlight.Service;
import io.vertx.core.Future;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author hp
 */
@Service
public class ImageKonsumenFinanceServiceImpl implements ImageKonsumenFinanceService{

    @AutoWired
    ImageKonsumenFinanceDAO financeDAO;
    
    @Override
    public Future<ImageKonsumenFinance> add(ImageKonsumenFinance finance) {
        Date date = new Date();
        finance.setCreated(date);
        
        String encodedBase64 = null;
        String targetFolderString = "D:/SLI/e-WL/"+finance.getKonsumenid();
        File targetFolder = new File(targetFolderString);
        String base64String = finance.getImageFile();
        BufferedImage image = null;
        String fileOutput = targetFolder+"/"+finance.getImageName();
        
        if (targetFolder.exists()) {
            
            if (targetFolder.isDirectory()) {
                
                String targetName = "";
                for(File file : targetFolder.listFiles()){
                    
                    String fileName = file.getName();
                    if(fileName.equalsIgnoreCase(finance.getImageName()))
                    {
                        targetName = file.getName();
                        File fldr = new File(targetFolder+"/"+targetName);
                        String fileOut = targetFolder+"/"+targetName;
                        fldr.delete(); 
                        try (FileOutputStream outputStream = new FileOutputStream(fileOut)){
                            byte[] decodedBytes = Base64.getMimeDecoder().decode(base64String);
                            
                            outputStream.write(decodedBytes);

                        } catch (IOException ex) {
                        }
                          break;
                    } else {
                        
                        File f= new File(targetFolder+"/"+finance.getImageName());
                        try (FileOutputStream outputStream = new FileOutputStream(fileOutput)){
                            byte[] decodedBytes = Base64.getMimeDecoder().decode(base64String);

                            outputStream.write(decodedBytes);

                        } catch (IOException ex) {
                        }
                    }
                }  
            }
            
        } else {
            if (targetFolder.mkdirs()) {
                
                File f1 = new File(targetFolder+"/"+finance.getImageName());
                try (FileOutputStream outputStream = new FileOutputStream(fileOutput)){
                            byte[] decodedBytes = Base64.getMimeDecoder().decode(base64String);

                            outputStream.write(decodedBytes);

                        } catch (IOException ex) {
                        }
                
            } else {
            }
        }
        
        finance.setImagePath(targetFolderString);
        finance.setImageFile("");
        
        return financeDAO.add(finance);
    }

    @Override
    public Future<List<ImageKonsumenFinance>> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Future<List<ImageKonsumenFinance>> history(Integer id) {
       return financeDAO.listbykonsumen(id);
    }

    @Override
    public Future<ImageKonsumenFinance> getImage(String filename, Integer id) {
        
        Future<ImageKonsumenFinance> result = Future.future();
        
        String targetFolderString = "/home/somasi/konsumenImage/"+id;
        File targetFolder = new File(targetFolderString);
        ImageKonsumenFinance image = new ImageKonsumenFinance();
        
        if (targetFolder.exists()) {
            
            if (targetFolder.isDirectory()) {
                
                String targetName = "";
                for(File file : targetFolder.listFiles()){
                    
                    String fileNama = file.getName();
                    
                    if(fileNama.equalsIgnoreCase(filename)) {
                        targetName = file.getName();
                        break;
                        
                    }
                }
                    
                    if (targetName != null) {
                        
                        File f = new File(targetFolderString + "/" + targetName);
                        String encode = "";
                        
                        try {
                            
                            FileInputStream fileInputStreamReader = new FileInputStream(f);
                            byte[] bytes = new byte[(int) f.length()];
                            fileInputStreamReader.read(bytes);
                            
                            encode = new String(Base64.getEncoder().encode(bytes), "UTF-8");
                            
                            image.setKonsumenid(id);
                            image.setImageFile(encode);
                            image.setImageName(targetName);
                            
                            result.complete(image);
                            
                            
                        } catch (Exception e) {
                            result.fail(new Exception("Error encode " + e));
                        }
                    } else {
                        result.fail(new Exception("File not found"));
                    }
                } else {
                    result.fail(new Exception("File not found"));
                }  
            } else {
                result.fail(new Exception("File not found"));
            }
         return result;
    }
    
}
