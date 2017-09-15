package cn.ystk.pro.util;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.ystk.pro.user.entity.User;
/**
 * 
 * 功能:session自动监听
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
public class MyHttpSessionAttributeListener implements
		HttpSessionAttributeListener {

	 public void attributeAdded(HttpSessionBindingEvent event) {  
		        if ("u".equals(event.getName())) {  
		            SystemSession.setUserSession((User)event.getValue());  
		        }  
		     }  
		    public void attributeReplaced(HttpSessionBindingEvent event) {  
		        if ("u".equals(event.getName())) {  
		            SystemSession.setUserSession((User)event.getValue());  
		       }  
		     }
			public void attributeRemoved(HttpSessionBindingEvent arg0) {
				
			}  
}
