/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.AgentPos;
import com.sli.somasi.foundation.dto.District;
import com.sli.somasi.foundation.dto.MappingArea;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface MappingAreaService {
    
    Future<MappingArea> add (MappingArea area);
    Future<Boolean> delete (Integer id);
    Future<List<MappingArea>> list();
    Future<List<District>> listDistByArea (int id);
}
