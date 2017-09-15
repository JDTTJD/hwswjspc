package cn.ystk.pro.rolemodule.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import cn.ystk.pro.rolemodule.entity.RoleModule;
import cn.ystk.pro.rolemodule.mapper.RoleModuleMapper;
import cn.ystk.pro.rolemodule.service.RoleModuleService;
/**
 * 
 * 功能:角色模块接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月13日
 * 修改日期: 2017年4月13日
 * 修改列表:
 */
public class RoleModuleServiceImpl implements RoleModuleService {
    @Autowired
	RoleModuleMapper roleModuleMapper;
	@Override
	public int saveRoleModule(RoleModule roleModule) {
		return roleModuleMapper.saveRoleModule(roleModule);
	}
	@Override
	public int updateRoleModule(RoleModule roleModule) {
		return roleModuleMapper.updateRoleModule(roleModule);
	}
	@Override
	public void deleteRoleModule(Integer roleModuleId) {
		roleModuleMapper.deleteRoleModule(roleModuleId);
	}
	@Override
	public List<RoleModule> findRoleModuleList() {
		return roleModuleMapper.findRoleModuleList();
	}
	@Override
	public List<RoleModule> findModuleListByRoleIds(List<Integer> roleIds) {
		return roleModuleMapper.findModuleListByRoleIds(roleIds);
	}
	@Override
	public List<RoleModule> findModuleListByRoleId(Integer roleId) {
		return roleModuleMapper.findModuleListByRoleId(roleId);
	}
	@Override
	public void deleteRoleModuleByRoleId(Integer roleId) {
		roleModuleMapper.deleteRoleModuleByRoleId(roleId);
	}

}
