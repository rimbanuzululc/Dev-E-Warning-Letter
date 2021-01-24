
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.RoleMenu;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author Abdul.Jalil.M
 */
public interface RoleMenuService {
    
    Future<RoleMenu> add(RoleMenu RoleMenu);
    Future<RoleMenu> update(RoleMenu role);
    Future<RoleMenu> delete(int userId);
    Future<RoleMenu> getId(int userId);
    Future<List<RoleMenu>> listAll();
    Future<List<RoleMenu>> listByRoleId(int roleId);

}
