package cn.ystk.pro.controller.photo;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import cn.ystk.pro.photo.entity.Photo;
import cn.ystk.pro.photo.entity.PhotoPage;
import cn.ystk.pro.photo.service.PhotoService;
import cn.ystk.pro.role.entity.Role;
import cn.ystk.pro.role.service.RoleService;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.userrole.entity.UserRole;
import cn.ystk.pro.userrole.service.UserRoleService;
import cn.ystk.pro.util.DateUtil;

import com.google.gson.Gson;
/**
 * 
 * 功能:照片控制层
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
	/**
	 * 照片服务层接口注入
	 */
	@Autowired
	private PhotoService photoService;
	/**
	 * 用户服务层接口注入
	 */
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
    /**
     * 用户角色服务层接口注入
     */
	@Autowired
    private UserRoleService userRoleService;
	/**
	 * 
	 * 功能：照片分页显示
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findPhotoList")
	public String findPhotoList(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			@RequestParam(value = "photoTime", required = true) String photoTime,
			@RequestParam(value = "photoNo", required = true) String photoNo,
			HttpServletRequest request,
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
			out = response.getWriter();
			PhotoPage photoPage = new PhotoPage();
			photoPage.setFirstRec(page);
			photoPage.setPageSize(rows);
			photoPage.setPhotoNo(photoNo);
			//得到用户的角色信息--start
			  User u=(User)request.getSession().getAttribute("u");
			  Integer userId=null;
			  List<UserRole> listUserRole=null;
			  Integer roleType=0;
			  String rolePrives="";
			  List<Integer> listRoleIds=new ArrayList<Integer>();
			  if(u!=null)
			  {
				  userId=u.getId();
				  listUserRole=userRoleService.findUserRoleByUserId(userId);
				  for(UserRole userRole:listUserRole)
				  {
					  listRoleIds.add(userRole.getRoleId()); 
				  }
				 List<Role> listRole=roleService.findRoleListByRoleIds(listRoleIds);
				 for(Role role:listRole)
				 {
					 rolePrives+=role.getRolePrivLevel()+",";
				 }
				 if(rolePrives!=null&&!"".equals(rolePrives))
				 {
				   if(rolePrives.indexOf("1")!=-1)
				   {
					   roleType=1;   
				   }
				 }
			  }		  
			  photoPage.setRoleType(roleType);
			  photoPage.setCreateUserId(u.getId());
			//得到用户的角色信息--end
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			if(photoTime!=null&&!"".equals(photoTime)){
			java.util.Date date=sdf.parse(photoTime);
			photoPage.setPhotoTime(date);
			}
			int iTotalRecords =photoService.getCount(photoPage);
			int iTotalDisplayRecords = photoService.getCount(photoPage) < 0 ? 0
					: photoService.getCount(photoPage);
			List<Photo> photoList = photoService.findByPage(photoPage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (photoList != null && photoList.size() > 0) {
				for (Photo photo : photoList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("photoNo", photo.getPhotoNo());
					map.put("photoId", photo.getPhotoNo());
					if(photo.getPhotoTime()!=null){
					
					map.put("photoTime",DateUtil.formatDateYYmmdd(photo.getPhotoTime()));
					}else
					{
					map.put("photoTime", "&nbsp;");	
					}
					map.put("photoAddr", photo.getPhotoAddr());
					
					map.put("remark", photo.getRemark());
				    User user=userService.findUserById(photo.getCreateUserId());
				    if(user!=null){
					map.put("userName", user.getUsername());
				    }else
				    {
				    map.put("userName", "&nbsp;");	
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
     * 功能：照片保存功能
     * @param photoAddr
     * @param remark
     * @param request
     * @param response
     * @return
     */
	@RequestMapping("/savePhoto")
	public String savePhoto(
			@RequestParam(required = false) String photoAddr,
			@RequestParam(required = false) String remark,
		    HttpServletRequest request,
			HttpServletResponse response) {
		{
			try {
				 HttpSession session= request.getSession();
				User user=(User)session.getAttribute("u");
				String success = "1";
				Photo photo=new Photo();
				photo.setCreateUserId(user.getCreateUserId());
				photo.setPhotoAddr(photoAddr);
				photo.setPhotoTime(new Date(System.currentTimeMillis()));
				photo.setRemark(remark);
			    photoService.savePhoto(photo);
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
	 * 功能：跳转到照片列表页面
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectPhotoList")
	public ModelAndView redirectRoleList(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("photo/list");
		return modelAndView;
	}
	
}
