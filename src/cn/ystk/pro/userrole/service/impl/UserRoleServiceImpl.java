package cn.ystk.pro.userrole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.userrole.entity.UserRole;
import cn.ystk.pro.userrole.mapper.UserRoleMapper;
import cn.ystk.pro.userrole.service.UserRoleService;
/**
 * 
 * 功能:用户角色接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月13日
 * 修改日期: 2017年4月13日
 * 修改列表:
 */
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
	UserRoleMapper userRoleMapper;
	@Override
	public int saveUserRole(UserRole userRole) {
		return userRoleMapper.saveUserRole(userRole);
	}
	@Override
	public int updateUserRole(UserRole userRole) {
		return userRoleMapper.saveUserRole(userRole);
	}
	@Override
	public List<UserRole> findUserRoleByUserId(Integer userId) {
		return userRoleMapper.findUserRoleByUserId(userId);
	}
	@Override
	public void deleteUserRole(Integer roleUserId) {
		userRoleMapper.deleteUserRole(roleUserId);	
	}
	@Override
	public void deleteUserRoleByUserId(Integer userId) {
		userRoleMapper.deleteUserRoleByUserId(userId);
	}
}
