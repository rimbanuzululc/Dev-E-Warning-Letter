
package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.Role;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author Abdul.Jalil.M
 */
public interface RoleService {
    
    Future<Role> add(Role role);
    Future<Role> update(Role role);
    Future<Role> delete(int roleId);
    Future<Role> getId(int roleId);
    Future<List<Role>> search(String filter,int page);
    Future<List<Role>> listAll();

}
