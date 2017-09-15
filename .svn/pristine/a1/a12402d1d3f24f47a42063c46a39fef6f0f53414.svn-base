package cn.ystk.pro.util;

import cn.ystk.pro.user.entity.User;

/**
 * 
 * 功能:得到登陆系统的sesssion
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
public class SystemSession {  
  
   private static ThreadLocal<User> local = new ThreadLocal<User>();  
  
   public static void setUserSession(User user) {  
        local.set(user);  
   }  
 
    public static User getUserSession() {  
        return local.get();  
    }  
}  
