package cn.ystk.pro.controller;
import java.io.File;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.util.DateUtil;
import cn.ystk.pro.util.POIUtil;

import com.google.gson.Gson;
/**
 * 
 * 功能:excel导入功能
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月25日
 * 修改日期: 2017年4月25日
 * 修改列表:
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	@Resource
	UserService userService;
	/**
	 * 
	 * 功能：附件上传
	 * 
	 * @param fileupload
	 * @param module
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(
			@RequestParam(value = "fileupload") MultipartFile fileupload,
			@RequestParam(required = false) String module,
			HttpServletRequest req, HttpServletResponse response) {
		    {
			String fileuploadFileName = "";
			String targetDirectory = "";
			PrintWriter writer = null;
			try {
				String uploadPath = "";
			    String catalinaHome=System.getProperty("catalina.home");
				//	String catalinaHome =req.getSession().getServletContext().getRealPath("/"); 
				SimpleDateFormat sp = new SimpleDateFormat("MM/dd");
				String datePath = sp.format(new Date()); // 每月一个上传目录
				if (module != null && !"".equals(module)) {
					uploadPath = "/upload/" + datePath + "/" + module + "/";
				} else {
					uploadPath = "/upload/" + datePath + "/";
				}
				targetDirectory = catalinaHome + uploadPath;
				String uuid = UUID.randomUUID().toString();
				// 新的文件名
				fileuploadFileName = URLDecoder.decode(
						fileupload.getOriginalFilename(), "UTF-8");
				String targetFileName = uuid + "."
						+ getExtension(fileuploadFileName);
				FileUtils.copyInputStreamToFile(fileupload.getInputStream(),
						new File(targetDirectory + "/" + targetFileName));	
				writer = new PrintWriter(response.getWriter());
				Map<String,Object> jsonMap = new HashMap<String,Object>();
				jsonMap.put("fileName", uploadPath + targetFileName);
				jsonMap.put("orginName", fileupload.getOriginalFilename());
				List<String[]> list=POIUtil.readExcel(fileupload);
				for(int i=0;i<list.size();i++)
				{
					 String[]     userArray =     new   String[6]; 
			         userArray    =   list.get(i); 
			         User user=new User();
			         user.setUsername(userArray[0].toString());
			         user.setSex(userArray[1].toString());
			         user.setTelephone(userArray[3]);
			         user.setAddress(userArray[4].toString());
			         user.setBirthday(DateUtil.parseYYmmdd(userArray[5]));
			         userService.saveUser(user);
				}
			    Gson json = new Gson();
				String jsons = json.toJson(jsonMap);
				writer.print(jsons);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
		return null;
	}

	

	/**
	 * 得到文件的扩展名,得不到返回空
	 */
	private String getExtension(String fileName) {
		if ((fileName != null) && (fileName.length() > 0)) {
			int i = fileName.lastIndexOf('.');

			if ((i > -1) && (i < fileName.length() - 1)) {
				return fileName.substring(i + 1);
			}
		}
		return "";
	}
}
