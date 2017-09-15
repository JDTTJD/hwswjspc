package cn.ystk.pro.role.mapper;

import java.util.List;

import cn.ystk.pro.role.entity.Role;
import cn.ystk.pro.role.entity.RolePage;
/**
 * 
 * 功能:角色模块mapper
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public interface RoleMapper {
	/**
	 * 
	 * 功能：角色的修改
	 * @param role
	 * @return
	 */
	int updateRole(Role role);
	/**
	 * 
	 * 功能：角色的添加
	 * @param role
	 * @return
	 */
	int saveRole(Role role);
	/**
	 * 
	 * 功能：角色的删除
	 * @param id
	 */
	void deleteRole(Integer id);
    
	/**
	 * 
	 * 功能：列表
	 * 
	 * @param page
	 * @return
	 */
	List<Role> findByPage(RolePage page);

	/**
	 * 
	 * 功能：总的记录数
	 * 
	 * @param page
	 * @return
	 */
	Integer getCount(RolePage page);
	/**
	 * 
	 * 功能：根据角色id获得角色的对象
	 * @param id
	 * @return
	 */
	Role findRoleById(Integer id);
	/**
	 * 
	 * 功能：得到角色列表
	 * @return
	 */
	List<Role> findRoleList();
	
	/**
	 * 
	 * 功能：根据角色名称获得角色对象
	 * @param roleName
	 * @return
	 */
    Role findRoleByRoleName(String roleName);
    /**
     * 
     * 功能：根据角色的ids获得角色列表
     * @param roleIds
     * @return
     */
    List<Role> findRoleListByRoleIds(List<Integer> roleIds);
	 
}
