package cn.ystk.pro.controller.photodetains;

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

import cn.ystk.pro.photodetains.entity.PhotoDetains;
import cn.ystk.pro.photodetains.entity.PhotoDetainsPage;
import cn.ystk.pro.photodetains.service.PhotoDetainsService;

import com.google.gson.Gson;
/**
 * 
 * 功能:图片详情
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
@Controller
@RequestMapping("/photoDetains")
public class PhotoDetainsController {
	/**
	 * 图片详情服务层接口注入
	 */
	@Autowired
	private PhotoDetainsService photoDetainsService;
	/**
	 * 
	 * 功能：分页查询role信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findPhotoDetainsList")
	public String findPhotoDetainsList(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			@RequestParam(value = "photoNo", required = true) String photoNo,
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
			PhotoDetainsPage photoDetainsPage = new PhotoDetainsPage();
			photoDetainsPage.setFirstRec(page);
			photoDetainsPage.setPageSize(rows);
			int iTotalRecords =photoDetainsService.getCount(photoDetainsPage);
			int iTotalDisplayRecords = photoDetainsService.getCount(photoDetainsPage) < 0 ? 0
					: photoDetainsService.getCount(photoDetainsPage);
			List<PhotoDetains> photoDetainsList = photoDetainsService.findByPage(photoDetainsPage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (photoDetainsList != null && photoDetainsList.size() > 0) {
				for (PhotoDetains photoDetians : photoDetainsList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", photoDetians.getId());
					//图片名称
					if(photoDetians.getPhotoName()!=null&&!"".equals(photoDetians.getPhotoName()))
					{
					map.put("photoName", photoDetians.getPhotoName());	
					}else
					{
					map.put("photoName", "&nbsp;");		
					}
					//图片的url地址
					if(photoDetians.getUrl()!=null&&!"".equals(photoDetians.getUrl()))
					{
					map.put("url", photoDetians.getUrl());	
					}else
					{
					map.put("url", "&nbsp;");		
					}
					//图片的下载
					if(photoDetians.getUrl()!=null&&!"".equals(photoDetians.getUrl()))
					{
					map.put("urlDown", photoDetians.getUrl());	
					}else
					{
					map.put("urlDown", "&nbsp;");		
					}
					//图片所属的外键
					if(photoDetians.getPhotoNo()!=null&&!"".equals(photoDetians.getPhotoNo()))
					{
					map.put("photoNo", photoDetians.getPhotoNo());	
					}else
					{
					map.put("photoNo", "&nbsp;");		
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
 * 功能：图片详情的保存功能
 * @param photoName
 * @param url
 * @param photoNo
 * @param req
 * @param response
 * @return
 */
	@RequestMapping("/photoDetainsAdd")
	public String saveRole(
			@RequestParam(required = false) String photoName,
			@RequestParam(required = false) String url,
			@RequestParam(required = false) String photoNo,
			 HttpServletRequest req,
			HttpServletResponse response) {
		{
			try {
                String success="1";
			    PhotoDetains photoDetains=new PhotoDetains();
			    photoDetains.setPhotoName(photoName);
			    photoDetains.setUrl(url);
			    photoDetains.setPhotoNo(photoNo);
			    photoDetainsService.savePhotoDetains(photoDetains);
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
	 * 功能：角色修改页面
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectPhotoDetainsList")
	public ModelAndView redirectRoleUpdate(@RequestParam(value = "photoNo", required = true) String photoNo,
			                               HttpServletResponse response,
			                               HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("photoNo", photoNo);
		modelAndView.setViewName("photoDetains/photoDetainsList");
		return modelAndView;
	}
}
