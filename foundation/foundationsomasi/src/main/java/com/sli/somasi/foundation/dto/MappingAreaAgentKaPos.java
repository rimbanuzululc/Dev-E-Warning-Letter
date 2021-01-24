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
@Table("somasi_mappingareakapos")
public class MappingAreaAgentKaPos {
    
    @AutoKey
    protected Integer idMappingAreaKaPos;
    
    protected Integer idAgentPos;
    protected Integer idMappingArea;   

    public Integer getIdAgentPos() {
        return idAgentPos;
    }

    public void setIdAgentPos(Integer idAgentPos) {
        this.idAgentPos = idAgentPos;
    }

    public Integer getIdMappingArea() {
        return idMappingArea;
    }

    public void setIdMappingArea(Integer idMappingArea) {
        this.idMappingArea = idMappingArea;
    }
}
