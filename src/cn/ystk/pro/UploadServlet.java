/**  
*
*/
package cn.ystk.pro;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 * 
 * Title：hwswjs Description：UploadServlet
 * 
 * @author：唐及第
 * @date：2017年9月20日 上午9:09:53
 * @version 1.0
 * 
 */
public class UploadServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("进入了后台！get");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serverPath = "h:/upload/";
		System.out.println("进入了后台！post");
		// 1.创建DiskFileItemFactory对象，来配置缓存信息
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 2.创建servletFileUpload对象
		ServletFileUpload sfu = new ServletFileUpload(factory);

		// 3.设置文件编码格式
		sfu.setHeaderEncoding("utf-8");

		// 4.开始解析文件
		try {
			List<FileItem> items = sfu.parseRequest(request);

			// 5.获取文件信息
			for (FileItem item : items) {

				// 6.判断是文件还是普通信息
				if (item.isFormField()) {
					// 普通数据
					String fileName = item.getFieldName();

					if (fileName.equals("info")) {
						String info = item.getString("utf-8");
						System.out.println(info);
					}
				} else {
					// 文件

					// 获取文件名称
					String name = item.getName();

					// 获取文件实际的内容
					InputStream is = item.getInputStream();
					// 保存文件
					FileUtils.copyInputStreamToFile(is, new File(serverPath + "/" + name));
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
