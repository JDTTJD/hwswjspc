package cn.ystk.pro.user.mapper;
import java.util.List;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.entity.UserPage;
/**
 * 
 * 功能:用户信息管理
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月5日
 * 修改日期: 2017年4月5日
 * 修改列表:
 */
public interface UserMapper {
    /**
     * 分页查询
     * @param page
     * @return
     */
	
    List<User> findByPage(UserPage page);     
    /**
     * 分页查询时得到符合条件的数据
     * @param page
     * @return
     */
    Integer getCount(UserPage page);
    /**
     * 
     * 功能：保存用户信息
     * @param user
     * @return
     */
	int saveUser(User user);
	/**
	 * 
	 * 功能：根据用户id删除用户信息
	 * @param id
	 */
	void deleteUser(Integer id);
	
	/**
	 * 
	 * 功能：根据用户的id获取用户的信息
	 * @param id
	 * @return
	 */
	 User findUserById(Integer id);
     /**
      * 
      * 功能：修改用户信息
      * @param user
      * @return
      */
	 int updateUser(User user);
	 
	 /**
	  * 
	  * 功能：根据用户名和密码查询用户信息
	  * @param user
	  * @return
	  */
	 User findUserByUserNameAndPass(User user);
	 /**
	  * 
	  * 功能：导出功能返回的list
	  * @param userPage
	  * @return
	  */
	 List<User> findUserListForOut(UserPage userPage);
}