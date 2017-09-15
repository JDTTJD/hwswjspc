package cn.ystk.pro.role.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import cn.ystk.pro.role.entity.Role;
import cn.ystk.pro.role.entity.RolePage;
import cn.ystk.pro.role.mapper.RoleMapper;
import cn.ystk.pro.role.service.RoleService;
/**
 * 
 * 功能:角色接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public class RoleServiceImpl implements RoleService{
    @Autowired
	RoleMapper roleMapper;
	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}
	@Override
	public int saveRole(Role role) {
		return roleMapper.saveRole(role);
	}
	@Override
	public void deleteRole(Integer id) {
		roleMapper.deleteRole(id);	
	}
	@Override
	public List<Role> findByPage(RolePage page) {
		return roleMapper.findByPage(page);
	}
	@Override
	public Integer getCount(RolePage page) {
		return roleMapper.getCount(page);
	}
	@Override
	public Role findRoleById(Integer id) {
		return roleMapper.findRoleById(id);
	}
	@Override
	public List<Role> findRoleList() {
		return roleMapper.findRoleList();
	}
	@Override
	public Role findRoleByRoleName(String roleName) {
		return roleMapper.findRoleByRoleName(roleName);
	}
	@Override
	public List<Role> findRoleListByRoleIds(List<Integer> roleIds) {
		return roleMapper.findRoleListByRoleIds(roleIds);
	}
}
