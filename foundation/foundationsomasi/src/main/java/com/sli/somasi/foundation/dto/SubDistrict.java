/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dto;

import io.starlight.db.Table;

/**
 *
 * @author hp
 */
@Table("somasi_subdistrict")
public class SubDistrict {
    
    protected Integer subdistirctId;
    protected Integer districtId;
    protected String code;
    protected String name;
    protected Boolean isActive;
    protected Integer subdistrictorder;

    public Integer getSubdistirctId() {
        return subdistirctId;
    }

    public void setSubdistirctId(Integer subdistirctId) {
        this.subdistirctId = subdistirctId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getSubdistrictorder() {
        return subdistrictorder;
    }

    public void setSubdistrictorder(Integer subdistrictorder) {
        this.subdistrictorder = subdistrictorder;
    }
    
}
