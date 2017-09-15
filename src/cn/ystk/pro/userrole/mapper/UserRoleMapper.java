package cn.ystk.pro.userrole.mapper;

import java.util.List;
import cn.ystk.pro.userrole.entity.UserRole;
/**
 * 
 * 功能:用户角色mapper
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月13日
 * 修改日期: 2017年4月13日
 * 修改列表:
 */
public interface UserRoleMapper {
	/**
	 * 
	 * 功能：保存用户角色信息
	 * @param userRole
	 * @return
	 */
	int saveUserRole(UserRole userRole);
    /**
     * 
     * 功能：修改用户角色信息
     * @param userRole
     * @return
     */
	int updateUserRole(UserRole userRole);
	/**
	 * 
	 * 功能：根据用户的id得到用户角色list
	 * @param userId
	 * @return
	 */
	List<UserRole> findUserRoleByUserId(Integer userId);
	/**
	 * 
	 * 功能：根据角色用户删除记录
	 * @param roleUserId
	 */
	void deleteUserRole(Integer roleUserId);
	/**
	 * 
	 * 功能：
	 * @param userId
	 */
	void deleteUserRoleByUserId(Integer userId);
}
