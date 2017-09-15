package cn.ystk.pro.controller.role;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.ystk.pro.role.entity.Role;
import cn.ystk.pro.role.entity.RolePage;
import cn.ystk.pro.role.service.RoleService;
import cn.ystk.pro.rolemodule.entity.RoleModule;
import cn.ystk.pro.rolemodule.service.RoleModuleService;

import com.google.gson.Gson;
/**
 * 
 * 功能:角色控制层
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月10日
 * 修改日期: 2017年4月10日
 * 修改列表:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	/**
	 * 角色服务层接口注入
	 */
	@Autowired
	private RoleService roleService;
    /**
     * 角色模块层接口注入
     */
	@Autowired
	private RoleModuleService roleModuleService;
	/**
	 * 
	 * 功能：分页查询role信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findRoleList")
	public String findRoleList(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			page=(page-1)*rows;
			if(page==0){
			}else
			{
				page=page+1;
				rows=page+rows-1;
			}
			//--------------测试开始---------------------------
			/*Geo geo=new Geo();
			geo.setName("测试空间数据");
			double coords[]={1,2,3,4};
			//构造oracle.spatial.geometry.JGeometry对象  
		    JGeometry geometry=null;
		//	geometry=JGeometry.createLinearLineString(coords, 2, 8307);
		    geometry=JGeometry.createPoint(coords, 3, 8307);
			geo.setGeometry(geometry);
			geoService.saveGeo(geo);*/
	       //---------------测试结束---------------------------			
			out = response.getWriter();
			RolePage rolePage = new RolePage();
			rolePage.setFirstRec(page);
			rolePage.setPageSize(rows);
			int iTotalRecords =roleService.getCount(rolePage);
			int iTotalDisplayRecords = roleService.getCount(rolePage) < 0 ? 0
					: roleService.getCount(rolePage);
			List<Role> roleList = roleService.findByPage(rolePage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (roleList != null && roleList.size() > 0) {
				for (Role role : roleList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", role.getId());
					//角色名称
					if(role.getRoleName()!=null&&!"".equals(role.getRoleName()))
					{
					map.put("roleName", role.getRoleName());	
					}else
					{
					map.put("roleName", "&nbsp;");		
					}
					//角色描述
					if(role.getRoleDes()!=null&&!"".equals(role.getRoleDes()))
					{
					map.put("roleDes", role.getRoleDes());	
					}else
					{
					map.put("roleDes", "&nbsp;");		
					}
					//角色等级
					if(role.getRolePrivLevel()!=null&&!"".equals(role.getRolePrivLevel()))
					{
					map.put("rolePrivLevel", role.getRolePrivLevel());	
					}else
					{
					map.put("rolePrivLevel", "&nbsp;");		
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
	 * 功能：
	 * @param roleName
	 * @param roleDes
	 * @param checkType
	 * @param id
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/roleAdd")
	public String saveRole(
			@RequestParam(required = false) String roleName,
			@RequestParam(required = false) String roleDes,
			@RequestParam(required = false) Integer checkType,
			@RequestParam(required = false) String moduleIds,
			@RequestParam(required = false) Integer roleId, HttpServletRequest req,
			HttpServletResponse response) {
		{
			try {

				String success = "1";
				if (checkType == 1) {
				Role r=roleService.findRoleByRoleName(roleName);
				if(r!=null)
				{
					success="3";
				}else{				
					Role role = new Role();
					role.setRoleName(roleName);
					role.setRoleDes(roleDes);
					role.setRolePrivLevel("2");
					int saveRoleFlag = roleService.saveRole(role);
					if(moduleIds!=null&&!"".equals(moduleIds))
					{
						String[] moduleIdsArray=moduleIds.split(",");
						for(String moduleId:moduleIdsArray)
						{
						RoleModule roleModule=new RoleModule();	
						roleModule.setModuleId(Integer.parseInt(moduleId));
						roleModule.setRoleId(role.getId());						
						roleModuleService.saveRoleModule(roleModule);
						}
					}
					if (saveRoleFlag == 1) {
						success = "2";
					}
				}
				}
				if (checkType == 2) {
				    Role	role = roleService.findRoleById(roleId);
				    Role    r=roleService.findRoleByRoleName(roleName);
				    int updateRoleFlag=0;
				    if(role!=null&&roleName.equals(role.getRoleName()))
				    {
				    	role.setRoleName(roleName);
						role.setRoleDes(roleDes);
						role.setRolePrivLevel("2");
					    updateRoleFlag = roleService.updateRole(role);
					    roleModuleService.deleteRoleModuleByRoleId(roleId);
						if(moduleIds!=null&&!"".equals(moduleIds))
						{
							String[] moduleIdsArray=moduleIds.split(",");
							for(String moduleId:moduleIdsArray)
							{
							RoleModule roleModule=new RoleModule();	
							roleModule.setModuleId(Integer.parseInt(moduleId));
							roleModule.setRoleId(role.getId());
							roleModuleService.saveRoleModule(roleModule);
							}
						}
				    }
				    else
				    {
				    	if(r!=null&&r.getRoleName().equals(roleName)){
				    		success="3";
				    	}
				    }
					if (updateRoleFlag == 1) {
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
	 * 功能：根据角色id删除角色
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteRoles")
	public String deleteRoles(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String deleteRoleSuccess = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			String[] uIds = ids.split(",");
			if (uIds != null && uIds.length > 0) {
				for (int i = 0; i < uIds.length; i++) {
					Integer uId = Integer.parseInt(uIds[i]);
					roleService.deleteRole(uId);//删除角色
					roleModuleService.deleteRoleModuleByRoleId(uId);//删除角色的同时，删除角色对应的模块
				}
			}
			deleteRoleSuccess = "2";
			jsonMap.put("deleteRoleSuccess", deleteRoleSuccess);
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
	 * 功能：跳转到角色列表页面
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectRoleList")
	public ModelAndView redirectRoleList(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("role/roleList");
		return modelAndView;
	}
	/**
	 * 
	 * 功能：跳转到角色添加页面
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectRoleAdd")
	public ModelAndView redirectUserAdd(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("role/roleAdd");
		return modelAndView;
	}
	/**
	 * 
	 * 功能：角色修改页面
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectRoleUpdate")
	public ModelAndView redirectRoleUpdate(@RequestParam(value = "roleId", required = true) Integer roleId,
			                               HttpServletResponse response,
			                               HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
	    Role role=roleService.findRoleById(roleId);
		modelAndView.addObject("role", role);
		modelAndView.setViewName("role/roleUpdate");
		return modelAndView;
	}
}
