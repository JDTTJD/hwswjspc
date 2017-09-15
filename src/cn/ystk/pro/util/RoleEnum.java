package cn.ystk.pro.util;
/**
 * 
 * 功能:枚举类型示例
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月9日
 * 修改日期: 2017年5月9日
 * 修改列表:
 */
public enum RoleEnum {
	ADMIN("管理员",1),
	USER("普通用户",2);
	private String roleName;
	private int index;
	private RoleEnum(String roleName,int index)
	{
		this.roleName=roleName;
		this.index=index;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
