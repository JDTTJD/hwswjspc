package cn.ystk.pro.controller.photodetains;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ystk.pro.photodetains.entity.PhotoDetains;
import cn.ystk.pro.photodetains.service.PhotoDetainsService;
/**
 * 
 * 功能: 图片的下载功能
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月29日
 * 修改日期: 2017年6月29日
 * 修改列表:
 */
@Controller
@RequestMapping("/downPic")
public class DownPicController {
	@Autowired
	private PhotoDetainsService photoDetainsService;
	/**
	 * 
	 * 功能：下载文件
	 * @param response
	 * @param request
	 */
	@RequestMapping("/downFile")
	public void downFile(HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id,
			HttpServletRequest request) {
		response.reset();
		response.setContentType("application/x-download");
		java.io.OutputStream outp = null;
		java.io.FileInputStream in = null;
		try {
			String catalinaHome=System.getProperty("catalina.home");
			String url="";
			String photoName="";
			PhotoDetains photoDetains=photoDetainsService.findPhotoDetainsById(id);
			if(photoDetains!=null)
			{
				url=photoDetains.getUrl();
				photoName=url.substring(url.lastIndexOf("\\"),url.length());
			}
			String filedownload=catalinaHome+"/"+url;		
			String filedisplay = photoName;
			filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filedisplay);
			outp = response.getOutputStream();
			File tempFile = new File(filedownload);
			in = new FileInputStream(filedownload);
			response.addHeader("Content-Length", "" + tempFile.length());
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
				in = null;
			}
		}
	}
}
