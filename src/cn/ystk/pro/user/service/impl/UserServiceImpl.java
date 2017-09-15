package cn.ystk.pro.user.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.entity.UserPage;
import cn.ystk.pro.user.mapper.UserMapper;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.util.MD5;
import cn.ystk.pro.util.database.MultipleDataSource;
/**
 * 
 * 功能:用户管理实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月26日
 * 修改日期: 2017年4月26日
 * 修改列表:
 */
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findByPage(UserPage page) {
		MultipleDataSource.setDataSourceKey("oracleDS");
		return userMapper.findByPage(page);
	}
	@Override
	public Integer getCount(UserPage page) {
		MultipleDataSource.setDataSourceKey("orcleDS");
		return userMapper.getCount(page);
	}
	@Override
	public int saveUser(User user) {
		user.setPassword(MD5.encrypt("123456"));
		user.setIsDelete(0);
		user.setCreateTime(new Date(System.currentTimeMillis()));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		return userMapper.saveUser(user);
	}
	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUser(id);
	}
	@Override
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}
	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
	@Override
	public User findUserByUserNameAndPass(User user) {
		return userMapper.findUserByUserNameAndPass(user);
	}
	@Override
	public List<User> findUserListForOut(UserPage userPage) {
		return userMapper.findUserListForOut(userPage);
	}
}
