package cn.ystk.pro.role.entity;
import cn.ystk.pro.base.BaseEntity;
/**
 * 
 * 功能:角色模块
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public class Role extends BaseEntity{
      /**
	 * 描述含义
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 角色描述  
     */
      private String roleDes;
    /**
     * 角色等级  
     */
      private String rolePrivLevel;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDes() {
		return roleDes;
	}
	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}
	public String getRolePrivLevel() {
		return rolePrivLevel;
	}
	public void setRolePrivLevel(String rolePrivLevel) {
		this.rolePrivLevel = rolePrivLevel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
