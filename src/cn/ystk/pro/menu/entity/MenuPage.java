package cn.ystk.pro.menu.entity;
/**
 * 
 * 功能:菜单分页查询实体类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public class MenuPage {
	Integer firstRec;//起始页
	Integer pageSize;//页面大小
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
}
