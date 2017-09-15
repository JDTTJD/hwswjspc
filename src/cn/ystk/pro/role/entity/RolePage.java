package cn.ystk.pro.role.entity;
/**
 * 
 * 功能:角色模块分页参数
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public class RolePage {
	 Integer firstRec;
	 Integer pageSize;
	 Role role;
	public Integer getFirstRec() {
		return firstRec;
	}
	public void setFirstRec(Integer firstRec) {
		this.firstRec = firstRec;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	 
}
