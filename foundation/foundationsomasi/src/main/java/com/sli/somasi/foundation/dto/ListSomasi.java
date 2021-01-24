/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.starlight.db.Computed;
import java.util.Date;

/**
 *
 * @author hp
 */
public class ListSomasi {
    
    protected String namaDebitur;
    protected String alamat;
    protected String noTelp;
    protected String noAggrement;
    protected String type;
    protected String nomorPolisi;
    
    @Computed
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    protected Date assign_date;

    public String getNamaDebitur() {
        return namaDebitur;
    }

    public void setNamaDebitur(String namaDebitur) {
        this.namaDebitur = namaDebitur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoAggrement() {
        return noAggrement;
    }

    public void setNoAggrement(String noAggrement) {
        this.noAggrement = noAggrement;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAssign_date() {
        return assign_date;
    }

    public void setAssign_date(Date assign_date) {
        this.assign_date = assign_date;
    }
    
}
