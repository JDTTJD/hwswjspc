package cn.ystk.pro.controller.menu;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.ystk.pro.menu.entity.Menu;
import cn.ystk.pro.menu.entity.MenuPage;
import cn.ystk.pro.menu.service.MenuService;
import cn.ystk.pro.role.service.RoleService;
import cn.ystk.pro.rolemodule.entity.RoleModule;
import cn.ystk.pro.rolemodule.service.RoleModuleService;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.userrole.entity.UserRole;
import cn.ystk.pro.userrole.service.UserRoleService;
import cn.ystk.pro.util.TreeNode;

import com.google.gson.Gson;
/**
 * 
 * 功能:模块控制类
 * 版本: 1.0
 * 开发人员: 徐长江 
 * 创建日期: 2017年4月21日
 * 修改日期: 2017年4月21日
 * 修改列表:
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	/**
	 * 服务层接口注入
	 */
	@Autowired
	private MenuService menuService;
	/**
	 * 用户角色服务层层接口注入
	 */
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 角色模块服务层接口注入
	 */
	@Autowired
	private RoleModuleService roleModuleService;
	/**
	 * 角色服务层接口注入
	 */
	@Autowired
	private RoleService roleService;
	/**
	 * 
	 * 功能：返回模块list
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findMenuList")
	public String findMenuList(HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<Menu> menuList = menuService.findMenuByPid(0);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (menuList != null && menuList.size() > 0) {
				for (Menu menu : menuList) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<Menu> menuChildList = new ArrayList<Menu>();
					map.put("menuId", menu.getMenuId());
					map.put("menuname", menu.getMenuname());
					map.put("icon", menu.getIcon());
					menuChildList = menuService.findMenuByPid(menu.getMenuId());
					if (menuChildList != null && menuChildList.size() > 0) {
						map.put("menus", menuChildList);
					}
					mapList.add(map);
				}
			}
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("menus", mapList);
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
	 * 功能：菜单分页查询
	 * 
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findMenuPageList")
	public String findMenuPageList(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			page = (page - 1) * rows;
			if (page == 0) {

			} else {
				page = page + 1;
				rows = page + rows-1;
			}
			out = response.getWriter();
			MenuPage menuPage = new MenuPage();
			menuPage.setFirstRec(page);
			menuPage.setPageSize(rows);
			int iTotalRecords = menuService.getCount(menuPage);
			int iTotalDisplayRecords = menuService.getCount(menuPage) < 0 ? 0
					: menuService.getCount(menuPage);
			List<Menu> menuList = menuService.findByPage(menuPage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (menuList != null && menuList.size() > 0) {
				for (Menu menu : menuList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", menu.getMenuId());
					/**
					 * 菜单名称
					 */
					if (menu.getMenuname() != null
							&& !"".equals(menu.getMenuname())) {
						map.put("menuName", menu.getMenuname());
					} else {
						map.put("menuName", "&nbsp;");
					}
					/**
					 * 菜单图标
					 */
					if (menu.getIcon() != null && !"".equals(menu.getIcon())) {
						map.put("icon", menu.getIcon());
					} else {
						map.put("icon", "&nbsp;");
					}
					/**
					 * url
					 */
					if (menu.getUrl() != null && !"".equals(menu.getUrl())) {
						map.put("url", menu.getUrl());
					} else {
						map.put("url", "&nbsp;");
					}
					/**
					 * 父节点id
					 */

					if (menu.getPid() != null) {
						map.put("pid", menu.getPid());
					} else {
						map.put("pid", "&nbsp;");
					}
					/**
					 * 父节点名称
					 */
                    Menu mu=menuService.findMenuById(menu.getPid());
					if(mu!=null)
					{
				     map.put("parentName", mu.getMenuname());
					}else
					{
					map.put("parentName", "默认节点");	
					}
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

		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * 功能：跳转到菜单列表
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectMenuList")
	public ModelAndView redirectMenuList(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("menu/menuList");
		return modelAndView;
	}

	/**
	 * 
	 * 功能：树形结构
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping("/ztree")
	public String moduleTree(HttpServletResponse response) {
		try {
			List<Menu> listMenu = menuService.findMenuList();
			Collection<TreeNode> treeNodes = new ArrayList<TreeNode>();
			TreeNode treeNode = null;
			response.setContentType("application/xml;utf-8");
			response.setCharacterEncoding("utf-8");
			if (listMenu != null && listMenu.size() > 0) {
				for (int i = 0; i < listMenu.size(); i++) {
					treeNode = new TreeNode();
					String menuName = listMenu.get(i).getMenuname();
					String url = listMenu.get(i).getUrl();
					Integer menuId = listMenu.get(i).getMenuId();
					Integer menuPid = listMenu.get(i).getPid();
					treeNode.setName(menuName);
					treeNode.setModuleUrl(url);
					treeNode.setId(menuId.toString());
					treeNode.setpId(menuPid.toString());
					treeNodes.add(treeNode);
				}
			}
			Gson json = new Gson();
			String treeJsons = json.toJson(treeNodes);
			PrintWriter writer = new PrintWriter(response.getWriter());
			writer.print(treeJsons);
			writer.flush();
			writer.close();
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping("/menuAdd")
	public String saveMenu(@RequestParam(required = false) String menuName,
			@RequestParam(required = false) String url,
			@RequestParam(required = false) String icon,
			@RequestParam(required = false) Integer pid,
			@RequestParam(required = false) Integer checkType,
			@RequestParam(required = false) Integer id, HttpServletRequest req,
			HttpServletResponse response) {
		{
			try {

				String success = "1";
				if (checkType == 1) {
					Menu menu = new Menu();
					menu.setIcon(icon);
					menu.setMenuname(menuName);
					menu.setUrl(url);
					menu.setPid(pid);
					int saveMenuFlag = menuService.saveMenu(menu);
					if (saveMenuFlag == 1) {
						success = "2";
					}
				}
				if (checkType == 2) {
					Menu menu = menuService.findMenuById(id);
					if (menu != null) {
						menu.setIcon(icon);
						menu.setMenuId(id);
						menu.setMenuname(menuName);
						menu.setUrl(url);
						menu.setPid(pid);
						menu.setMenuId(id);
					}
					int updateMenuFlag = menuService.updateMenu(menu);
					if (updateMenuFlag == 1) {
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
	 * 功能：删除菜单功能
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMenus")
	public String deleteMenus(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String deleteMenuSuccess = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			String[] uIds = ids.split(",");
			if (uIds != null && uIds.length > 0) {
				for (int i = 0; i < uIds.length; i++) {
					Integer uId = Integer.parseInt(uIds[i]);
					menuService.deleteMenu(uId);
				}
			}
			deleteMenuSuccess = "2";
			jsonMap.put("deleteMenuSuccess", deleteMenuSuccess);
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
	 * 功能：查找已选中的树形结构list
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCheckedModuleList")
	public String findCheckedModuleList(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Integer roleId = null;
			List<RoleModule> moduleList = null;
			List<Integer> roleIds = new ArrayList<Integer>();
			List<Integer> moduleIds = new ArrayList<Integer>();
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("u");
			if (u != null) {
				List<UserRole> roleUserList = userRoleService
						.findUserRoleByUserId(u.getId());//根据登录用户查询到user role中的userId
				if (roleUserList != null && roleUserList.size() > 0) {
					for (UserRole userRole : roleUserList) {
						roleId = userRole.getRoleId();
						roleIds.add(roleId);
					}

				}
				moduleList = roleModuleService.findModuleListByRoleIds(roleIds);
				if (moduleList != null && moduleList.size() > 0) {
					for (int i = 0; i < moduleList.size(); i++) {
						RoleModule roleModule = moduleList.get(i);
						if (moduleIds.contains(roleModule.getModuleId())) {
						} else {
							moduleIds.add(roleModule.getModuleId());
						}
					}
				}
			}
			List<Menu> menuList = menuService
					.findMenuListByModuleIds(moduleIds);
			List<Integer> childAllList = new ArrayList<Integer>();
			for (Menu menuAllCh : menuList) {
				if (menuAllCh.getPid() != 0) {
					childAllList.add(menuAllCh.getMenuId());
				}
			}
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (menuList != null && menuList.size() > 0) {
				for (Menu menu : menuList) {
					if (menu.getPid() == 0) {
						Map<String, Object> map = new HashMap<String, Object>();
						List<Menu> menuChildList = new ArrayList<Menu>();
						map.put("menuId", menu.getMenuId());
						map.put("menuname", menu.getMenuname());
						map.put("icon", menu.getIcon());
						List<Menu> muList = menuService.findMenuByPid(menu
								.getMenuId());
						for (Menu mu : muList) {
							if (childAllList.contains(mu.getMenuId())) {
								menuChildList.add(mu);
							} else {
							}
						}
						map.put("menus", menuChildList);
						mapList.add(map);
					}
				}
			}
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("menus", mapList);
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
	 * 功能：根据角色id获得已经选中的模块
	 * 
	 * @param roleId
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/getSelectModule")
	public String getSelectModule(
			@RequestParam(required = false) Integer roleId,
			HttpServletRequest req, HttpServletResponse response) {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<RoleModule> roleModuleList = roleModuleService
					.findModuleListByRoleId(roleId);
			List<Integer> moduleIds = new ArrayList<Integer>();
			List<Menu> listModule = null;
			if (roleModuleList != null && roleModuleList.size() > 0) {
				for (int i = 0; i < roleModuleList.size(); i++) {
					RoleModule roleModule = roleModuleList.get(i);
					moduleIds.add(roleModule.getModuleId());
				}
			}
			if (moduleIds != null && moduleIds.size() > 0) {
				listModule = menuService.findMenuListByModuleIds(moduleIds);
			}
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("roleModuleList", listModule);
			Gson json = new Gson();
			String jsons = json.toJson(jsonMap);
			out.print(jsons);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
