package cn.ystk.pro.menu.mapper;
import java.util.List;
import cn.ystk.pro.menu.entity.Menu;
import cn.ystk.pro.menu.entity.MenuPage;
import cn.ystk.pro.util.database.DataSourceKey;
/**
 * 
 * 功能:功能菜单mapper
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
@DataSourceKey(value = "oracleDS")
public interface MenuMapper {
    /**
     * 
     * 功能：根据父ID节点查询菜单list
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
	 * 功能：根据id查找菜单
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
