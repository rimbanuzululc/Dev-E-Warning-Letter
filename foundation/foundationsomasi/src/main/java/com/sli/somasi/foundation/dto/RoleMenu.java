
package com.sli.somasi.foundation.dto;

import io.starlight.db.AutoKey;
import io.starlight.db.Computed;
import io.starlight.db.Table;
import java.util.List;

/**
 *
 * @author Abddul.Jalil.M
 */
@Table("somasi_rolemenu")
public class RoleMenu {

    protected Integer roleId;
    protected Integer menuId;

    
    @Computed
    protected List<RoleMenu> listRole;
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<RoleMenu> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleMenu> listRole) {
        this.listRole = listRole;
    }
    
    
}
