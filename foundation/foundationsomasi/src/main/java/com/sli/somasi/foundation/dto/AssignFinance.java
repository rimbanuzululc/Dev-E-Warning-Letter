/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.starlight.db.AutoKey;
import io.starlight.db.Table;
import java.util.Date;

/**
 *
 * @author hp
 */

@Table("somasi_assignfinance")
public class AssignFinance {
    
    @AutoKey
    protected Integer idAssignFinance;
    
    protected Integer idAgentPos;
    protected Integer konsumenId;
    protected String noAggrement;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    protected Date assign_date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    protected Date last_modify;
    
    protected String type;
    
    protected Boolean sp;
    protected Boolean spt;
    protected Boolean print;
    protected String noDebitur;
    
    protected String status;
    
    protected String confirmDebitur;
    protected String confirmUnit;
    protected String kesimpulan;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    protected Date submit_date;
    
    public Integer getIdAssignFinance() {
        return idAssignFinance;
    }

    public void setIdAssignFinance(Integer idAssignFinance) {
        this.idAssignFinance = idAssignFinance;
    }

    public Integer getIdAgentPos() {
        return idAgentPos;
    }

    public void setIdAgentPos(Integer idAgentPos) {
        this.idAgentPos = idAgentPos;
    }

    public Integer getKonsumenId() {
        return konsumenId;
    }

    public void setKonsumenId(Integer konsumenId) {
        this.konsumenId = konsumenId;
    }

    public String getNoAggrement() {
        return noAggrement;
    }

    public void setNoAggrement(String noAggrement) {
        this.noAggrement = noAggrement;
    }

    public Date getAssign_date() {
        return assign_date;
    }

    public void setAssign_date(Date assign_date) {
        this.assign_date = assign_date;
    }

    public Date getLast_modify() {
        return last_modify;
    }

    public void setLast_modify(Date last_modify) {
        this.last_modify = last_modify;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSp() {
        return sp;
    }

    public void setSp(Boolean sp) {
        this.sp = sp;
    }

    public Boolean getSpt() {
        return spt;
    }

    public void setSpt(Boolean spt) {
        this.spt = spt;
    }

    public Boolean getPrint() {
        return print;
    }

    public void setPrint(Boolean print) {
        this.print = print;
    }

    public String getNoDebitur() {
        return noDebitur;
    }

    public void setNoDebitur(String noDebitur) {
        this.noDebitur = noDebitur;
    }

    public String getConfirmDebitur() {
        return confirmDebitur;
    }

    public void setConfirmDebitur(String confirmDebitur) {
        this.confirmDebitur = confirmDebitur;
    }

    public String getConfirmUnit() {
        return confirmUnit;
    }

    public void setConfirmUnit(String confirmUnit) {
        this.confirmUnit = confirmUnit;
    }

    public String getKesimpulan() {
        return kesimpulan;
    }

    public void setKesimpulan(String kesimpulan) {
        this.kesimpulan = kesimpulan;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
