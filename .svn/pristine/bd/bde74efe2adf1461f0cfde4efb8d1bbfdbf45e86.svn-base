package cn.ystk.pro.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.ystk.pro.role.entity.Role;
import cn.ystk.pro.role.service.RoleService;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.entity.UserPage;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.userrole.entity.UserRole;
import cn.ystk.pro.userrole.service.UserRoleService;
import cn.ystk.pro.util.DateUtil;
import cn.ystk.pro.util.MD5;

import com.google.gson.Gson;

/**
 * 
 * 功能:用户控制层 版本: 1.0 开发人员: 徐长江 创建日期: 2017年4月7日 修改日期: 2017年4月7日 修改列表:
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger loggger = Logger.getLogger(UserController.class);
	/**
	 * 用户服务层接口注入
	 */
	@Autowired
	private UserService userService;
	/**
	 * 角色服务层接口注入
	 */
	@Autowired
	private RoleService roleService;
	/**
	 * 用户角色服务层接口注入
	 */
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 
	 * 功能：用户分页查询信息
	 * 
	 * @param page
	 * @param userName
	 * @param date
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findUserList")
	public String findUserList(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "date", required = true) Date date,
			@RequestParam(value = "rows", required = true) Integer rows, HttpServletResponse response)
					throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			/* page=(page-1)*rows; */
			/*
			 * if(page==0){ }else { page=page+1; //rows=page+rows-1; }
			 */
			page = page - 1;
			/*System.out.println("page:" + page + ",rows:" + rows);*/
			out = response.getWriter();// 获取PrintWriter输出流
			UserPage userPage = new UserPage();
			userPage.setFirstRec(page);
			userPage.setPageSize(rows);
			User user = new User();
			user.setUsername(userName);
			user.setBirthday(date);
			userPage.setUser(user);
			int iTotalRecords = userService.getCount(userPage);
			int iTotalDisplayRecords = userService.getCount(userPage) < 0 ? 0 : userService.getCount(userPage);
			List<User> userList = userService.findByPage(userPage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (userList != null && userList.size() > 0) {
				for (User u : userList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", u.getId());
					if (u.getUsername() != null && !"".equals(u.getUsername())) {
						map.put("username", u.getUsername());
					} else {
						map.put("username", "&nbsp;");
					}
					if (u.getAddress() != null && !"".equals(u.getAddress())) {
						map.put("address", u.getAddress());
					} else {
						map.put("address", "&nbsp;");
					}
					if (u.getTelephone() != null && !"".equals(u.getTelephone())) {
						map.put("telephone", u.getTelephone());
					} else {
						map.put("telephone", "&nbsp;");
					}
					if ("1".equals(u.getSex())) {
						map.put("sex", "1");
						map.put("sexName", "男");
					} else {
						map.put("sex", "2");
						map.put("sexName", "女");
					}

					if (u.getBirthday() != null) {
						map.put("birthday", DateUtil.formatDateYYmmdd(u.getBirthday()));
					} else {
						map.put("birthday", "&nbsp;");
					}
					if (u.getSpeciality() != null) {
						map.put("speciality", u.getSpeciality());
					} else {
						map.put("speciality", "&nbsp;");
					}
					if (u.getCreateTime() != null) {
						map.put("createTime", DateUtil.formatDateYYmmddHHmmss(u.getCreateTime()));
					} else {
						map.put("createTime", "&nbsp;");
					}
					Map<Integer, String> userRoleMap = this.getUserRoleMap(u.getId());
					map.put("roleId", userRoleMap.get(u.getId()));
					mapList.add(map);
				}
			}

			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", iTotalRecords);
			jsonMap.put("total", iTotalDisplayRecords);
			jsonMap.put("rows", mapList);
			Gson json = new Gson();
			String jsons = json.toJson(jsonMap);
			out.print(jsons);

		} catch (Exception e) {
			e.printStackTrace();
			loggger.error("findUserList发生异常", e);

		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：跳转到列表
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectUserList")
	public ModelAndView redirectUserList(HttpServletResponse response, HttpServletRequest request) throws Exception {
		List<Role> roleList = roleService.findRoleList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("roleList", roleList);
		modelAndView.setViewName("user/list");
		return modelAndView;
	}

	/**
	 * 
	 * 功能：跳转到添加页面
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectUserAdd")
	public ModelAndView redirectUserAdd(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/userAdd");
		return modelAndView;
	}

	/**
	 * 
	 * 功能：保存用户信息
	 * 
	 * @param userName
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/userAdd")
	public String saveUser(@RequestParam(required = false) String username, @RequestParam(required = false) String sex,
			@RequestParam(required = false) String address, @RequestParam(required = false) String roleIds,
			@RequestParam(required = false) Date brithday, @RequestParam(required = false) String telephone,
			@RequestParam(required = false) Integer checkType, @RequestParam(required = false) Integer speciality,
			@RequestParam(required = false) Integer id, HttpServletRequest req, HttpServletResponse response) {
		{
			try {
				String success = "1";
				if (checkType == 1) {
					User user = new User();
					user.setUsername(username);
					user.setSex(sex);
					user.setAddress(address);
					user.setBirthday(brithday);
					user.setTelephone(telephone);
					user.setSpeciality(speciality);
					user.setCreateUserId(id);
					int saveUserFlag = userService.saveUser(user);
					if (roleIds != null && !"".equals(roleIds)) {
						roleIds = roleIds.substring(0, roleIds.length() - 1);
						String[] roleIdsArray = roleIds.split(",");
						for (String roleId : roleIdsArray) {
							UserRole userRole = new UserRole();
							userRole.setRoleId(Integer.parseInt(roleId));
							userRole.setUserId(user.getId());
							userRoleService.saveUserRole(userRole);
						}
					}
					if (saveUserFlag == 1) {
						success = "2";
					}
				}
				if (checkType == 2) {
					User user = userService.findUserById(id);
					if (user != null) {
						user.setAddress(address);
						user.setBirthday(brithday);
						user.setSex(sex);
						user.setUsername(username);
						user.setUpdateTime(new Date(System.currentTimeMillis()));
					}
					int updateUserFlag = userService.updateUser(user);
					userRoleService.deleteUserRoleByUserId(user.getId());
					if (roleIds != null && !"".equals(roleIds)) {
						roleIds = roleIds.substring(0, roleIds.length() - 1);
						String[] roleIdsArray = roleIds.split(",");
						for (String roleId : roleIdsArray) {
							UserRole userRole = new UserRole();
							userRole.setRoleId(Integer.parseInt(roleId));
							userRole.setUserId(user.getId());
							userRoleService.saveUserRole(userRole);
						}
					}
					if (updateUserFlag == 1) {
						success = "2";
					}
				}
				PrintWriter writer = new PrintWriter(response.getWriter());
				writer.print(success);
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：删除用户信息
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteUsers")
	public String deleteUsers(@RequestParam(value = "ids", required = true) String ids, HttpServletResponse response)
			throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String deleteUserSuccess = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			String[] uIds = ids.split(",");
			if (uIds != null && uIds.length > 0) {
				for (int i = 0; i < uIds.length; i++) {
					User user = new User();
					Integer uId = Integer.parseInt(uIds[i]);
					user.setId(uId);
					userService.deleteUser(uId);// 删除用户
					userRoleService.deleteUserRoleByUserId(uId);// 删除用户下面的角色
				}
			}
			deleteUserSuccess = "2";
			jsonMap.put("deleteUserSuccess", deleteUserSuccess);
			Gson json = new Gson();
			String jsons = json.toJson(jsonMap);
			out.print(jsons);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：根据用户名和密码登录系统
	 * 
	 * @param username
	 * @param password
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findUserByUserNameAndPass")
	public String findUserByUserNameAndPass(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String success = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			User user = new User();
			user.setUsername(username);
			user.setPassword(MD5.encrypt(password));
			User u = userService.findUserByUserNameAndPass(user);
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
			session.setAttribute("username", username);// 这个应该是往后面页面传值使用
			if (u != null) {
				// u不等于null，说明数据库中有此用户，可以登录
				success = "2";
			}
			jsonMap.put("success", success);
			jsonMap.put("id_token", username);
			Gson json = new Gson();
			String jsons = json.toJson(jsonMap);
			out.print(jsons);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：修改密码
	 * 
	 * @param oldPass
	 * @param newPass
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePass")
	public String updatePass(@RequestParam(value = "oldPass", required = false) String oldPass,
			@RequestParam(value = "newPass", required = false) String newPass, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String responeState = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("u");
			if (user != null) {
				if (!user.getPassword().equals(MD5.encrypt(oldPass))) {
					responeState = "2";
				} else {
					user.setPassword(MD5.encrypt(newPass));
					userService.updateUser(user);
					responeState = "3";
				}

			}
			jsonMap.put("success", responeState);
			Gson json = new Gson();
			String jsons = json.toJson(jsonMap);
			out.print(jsons);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：页面跳转--跳转到用户修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectUserUpdate")
	public ModelAndView redirectUserUpdate(@RequestParam(value = "id", required = false) Integer id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findUserById(id);
		if (user != null) {
			modelAndView.addObject("user", user);
		}
		modelAndView.setViewName("user/userUpdate");
		return modelAndView;
	}

	/**
	 * 
	 * 功能：返回userRole--map
	 * 
	 * @param userId
	 * @return
	 */
	private Map<Integer, String> getUserRoleMap(Integer userId) {
		Map<Integer, String> userRoleMap = new HashMap<Integer, String>();
		List<UserRole> roleUserList = userRoleService.findUserRoleByUserId(userId);
		StringBuffer sb = new StringBuffer();
		String roleIds = "";
		for (UserRole userRole : roleUserList) {
			sb.append(userRole.getRoleId()).append(",");
		}
		roleIds = sb.toString();
		if (roleIds != null && !"".equals(roleIds)) {
			roleIds = roleIds.substring(0, roleIds.length() - 1);
		}
		userRoleMap.put(userId, roleIds);
		return userRoleMap;
	}
}
