package cn.ystk.pro.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 功能:文件的下载 
 * 版本: 1.0 
 * 开发人员: 徐长江 
 * 创建日期: 2017年4月27日 
 * 修改日期: 2017年4月27日 
 * 修改列表:
 */
@Controller
@RequestMapping("/down")
public class DownController {
	/**
	 * 
	 * 功能：下载文件
	 * @param response
	 * @param request
	 */
	@RequestMapping("/downFile")
	public void downFile(HttpServletResponse response,
			HttpServletRequest request) {
		response.reset();
		response.setContentType("application/x-download");
		java.io.OutputStream outp = null;
		java.io.FileInputStream in = null;
		try {
			// 获取文件保存路径
			String realPath = request.getSession().getServletContext()
					.getRealPath("/down");
			String filedownload = realPath + "/user.xlsx";
			String filedisplay = "用户信息.xlsx";
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
