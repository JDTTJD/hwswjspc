package cn.ystk.pro.menu.service;

import java.util.List;
import cn.ystk.pro.menu.entity.Menu;
import cn.ystk.pro.menu.entity.MenuPage;

/**
 * 
 * 功能:菜单service 版本: 1.0 开发人员: 徐长江 创建日期: 2017年4月10日 修改日期: 2017年4月10日 修改列表:
 */
public interface MenuService {
	/**
	 * 
	 * 功能：根据父节点id查询菜单list
	 * 
	 * @param pid
	 * @return
	 */
	List<Menu> findMenuByPid(Integer pid);

	/**
	 * 
	 * 功能：列表
	 * 
	 * @param page
	 * @return
	 */
	List<Menu> findByPage(MenuPage page);

	/**
	 * 
	 * 功能：总的记录数
	 * 
	 * @param page
	 * @return
	 */
	Integer getCount(MenuPage page);
	
	/**
	 * 
	 * 功能：查询菜单list
	 * @return
	 */
	List<Menu> findMenuList();
	
	/**
	 * 
	 * 功能：保存菜单
	 * @param menu
	 * @return
	 */
	int saveMenu(Menu menu);
	/**
	 * 
	 * 功能：
	 * @param id
	 * @return
	 */
    Menu	findMenuById(Integer id);
    
    /**
     * 
     * 功能：修改菜单
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);
    
    /**
     * 
     * 功能：根据id删除菜单
     * @param id
     */
    void  deleteMenu(Integer id);
    /**
     * 
     * 功能：根据模块的id查找模块的列表
     * @param menuIds
     * @return
     */
    List<Menu> findMenuListByModuleIds(List<Integer> menuIds);
}
