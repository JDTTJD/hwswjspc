package cn.ystk.pro.util;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * 功能:session监听器
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月26日
 * 修改日期: 2017年4月26日
 * 修改列表:
 */
public class SessionListen implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
	}

}
