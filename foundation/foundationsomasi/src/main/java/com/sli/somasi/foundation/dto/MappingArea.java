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
@Table("somasi_mappingarea")
public class MappingArea {
    
    @AutoKey
    protected Integer idMappingArea;
    
    protected String codeArea;
    protected Integer districtId;

    public Integer getIdMappingArea() {
        return idMappingArea;
    }

    public void setIdMappingArea(Integer idMappingArea) {
        this.idMappingArea = idMappingArea;
    }

    public String getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(String codeArea) {
        this.codeArea = codeArea;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
    
}
