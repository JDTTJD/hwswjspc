package cn.ystk.pro.menu.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.menu.entity.Menu;
import cn.ystk.pro.menu.entity.MenuPage;
import cn.ystk.pro.menu.mapper.MenuMapper;
import cn.ystk.pro.menu.service.MenuService;
/**
 * 
 * 功能:菜单接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
public class MenuServiceImpl implements MenuService {
    @Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> findMenuByPid(Integer pid) {
		return menuMapper.findMenuByPid(pid);
	}
	@Override
	public List<Menu> findByPage(MenuPage page) {
		return menuMapper.findByPage(page);
	}
	@Override
	public Integer getCount(MenuPage page) {
		return menuMapper.getCount(page);
	}
	@Override
	public List<Menu> findMenuList() {
		return menuMapper.findMenuList();
	}
	@Override
	public int saveMenu(Menu menu) {
		return menuMapper.saveMenu(menu);
	}
	@Override
	public Menu findMenuById(Integer id) {
		return menuMapper.findMenuById(id);
	}
	@Override
	public int updateMenu(Menu menu) {
		return menuMapper.updateMenu(menu);
	}
	@Override
	public void deleteMenu(Integer id) {
		menuMapper.deleteMenu(id);
	}
	@Override
	public List<Menu> findMenuListByModuleIds(List<Integer> menuIds) {
		return menuMapper.findMenuListByModuleIds(menuIds);
	}
}
