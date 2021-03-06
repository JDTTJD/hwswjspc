package cn.ystk.pro.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ystk.pro.user.service.UserService;

/**
 * 
 * 功能:登录控制层 
 * 版本: 1.0 
 * 开发人员: 徐长江 
 * 创建日期: 2017年4月21日
 * 修改日期: 2017年4月21日
 * 修改列表:
 */
@Controller
public class LoginController {
	Logger loggger = Logger.getLogger(LoginController.class);
	/**
	 * 用户服务层接口注入
	 */
	@Autowired
	private UserService userService;
	/**
	 * 
	 * 功能：登录
	 * 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, 
			             String username,
			             String password) {
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		return "redirect:/rediectMainPage.action";
	}

	/**
	 * 
	 * 功能：退出登录
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session
		session.invalidate();
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

	/**
	 * 
	 * 功能：跳转到登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rediectLoginPage")
	public ModelAndView rediectLoginPage(HttpSession session) throws Exception {
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;

	}

	/**
	 * 
	 * 功能：跳转到主页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rediectMainPage")
	public ModelAndView rediectMainPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("frame");
		loggger.debug("调转到主页面");
		return modelAndView;
	}
}
