package cn.ystk.pro.rolemodule.service;

import java.util.List;

import cn.ystk.pro.rolemodule.entity.RoleModule;

/**
 * 
 * 功能:角色模块服务层
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月13日
 * 修改日期: 2017年4月13日
 * 修改列表:
 */
public interface RoleModuleService {
	/**
	 * 
	 * 功能：角色模块保存
	 * @param roleModule
	 * @return
	 */
	int saveRoleModule(RoleModule roleModule);
	/**
	 * 
	 * 功能：角色模块修改
	 * @param roleModule
	 * @return
	 */
	int updateRoleModule(RoleModule roleModule);
	/**
	 * 
	 * 功能：根据id删除角色模块信息
	 * @param roleModuleId
	 */
	void deleteRoleModule(Integer roleModuleId);
	/**
	 * 
	 * 功能：得到角色模块list
	 * @return
	 */
	List<RoleModule> findRoleModuleList();
	
	/**
	 * 
	 * 功能：根据角色的的id获得角色模块中间表数据
	 * @param roleIds
	 * @return
	 */
    List<RoleModule>	findModuleListByRoleIds(List<Integer> roleIds);
    /**
     * 
     * 功能：根据角色id获得角色模块list
     * @param roleId
     * @return
     */
    List<RoleModule>  findModuleListByRoleId(Integer roleId);  
    
    /**
     * 
     * 功能：根据角色的id删除角色模块
     * @param roleId
     */
    void deleteRoleModuleByRoleId(Integer roleId);
}
