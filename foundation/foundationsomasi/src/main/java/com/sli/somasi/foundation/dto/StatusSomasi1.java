/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dto;

import io.starlight.db.AutoKey;
import io.starlight.db.Table;

/**
 *
 * @author hp
 */
@Table("somasi_status1")
public class StatusSomasi1 {
    
    protected Integer idStatus1;
    protected String code;
    protected String description;

    public Integer getIdStatus1() {
        return idStatus1;
    }

    public void setIdStatus1(Integer idStatus1) {
        this.idStatus1 = idStatus1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
