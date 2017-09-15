package cn.ystk.pro.controller;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.entity.UserPage;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.util.DateUtil;
import cn.ystk.pro.util.ExportExcel;
/**
 * 
 * 功能:用户导出功能
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月26日
 * 修改日期: 2017年4月26日
 * 修改列表:
 */
@Controller
@RequestMapping("/outUser")
public class OutUserController {
    @Resource
	private UserService userService;
	@RequestMapping("/outUserList")
    public   String outputDataList(@RequestParam(value = "userName", required = true) String userName,
			                       @RequestParam(value = "date", required = true) Date date,
    		                       HttpServletRequest request,
    		                       HttpServletResponse response)
		 {
         response.setContentType("application/vnd.ms-excel");
         OutputStream outp = null;
         try {
             UserPage userPage=new UserPage();
             User user=new User();
             user.setUsername(userName);
             user.setBirthday(date);
             userPage.setUser(user);
             List<User> userList=userService.findUserListForOut(userPage);          
             SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
             String nowDate=sdf.format(new Date());
             response.addHeader("Content-Disposition", "attachment;filename="
                     + new String((nowDate+"用户信息导出.xls").getBytes("GB2312"), "iso8859-1"));// 解决中文
                                                                      
             outp = response.getOutputStream();
             List<Map<String, Object>> mapList = analyzeResult(userList);
             ExportExcel exportExcel = new ExportExcel(outp,
                     getExportHeadList(), mapList, getExportKeyList());
             exportExcel.export();
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         return null;
	}
         /**
          * 
          * 功能：导出加头部
          * 
          * @return
          */

         private List<String> getExportHeadList() {
             List<String> headList = new ArrayList<String>();
             headList.add("用户名");
             headList.add("生日");
             headList.add("创建时间");
             headList.add("地址");
             return headList;
         }

         /**
          * 
          * 功能：导出对应的字段
          * 
          * @return
          */

         private List<String> getExportKeyList() {
             List<String> headList = new ArrayList<String>();
             headList.add("username");
             headList.add("birthday");
             headList.add("createTime");
             headList.add("address");
             return headList;
         }

         /**
          * 
          * 功能：传入list得到List<Map<String,Object>>
          * @param list
          * @return
          */
         private List<Map<String, Object>> analyzeResult(List<User> list) {
             // 把用户信息填充到map里面
             List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
             if (list != null) {
                 for (User user : list) {
                     Map<String, Object> map = new HashMap<String, Object>();
                     map.put("username", user.getUsername());
                     if(user.getBirthday()!=null){
                     map.put("birthday", DateUtil.formatDateYYmmdd(user.getBirthday()));
                     }else
                     {
                    	 map.put("birthday","&nbsp;");	 
                     }
                     if(user.getCreateTime()!=null)
                     {
                     map.put("createTime",DateUtil.formatDateYYmmdd(user.getCreateTime()));
                     }else
                     {
                     map.put("createTime","&nbsp;");	 
                     }
                     map.put("address", user.getAddress());

                     mapList.add(map);
                 }
             }
             return mapList;
         }

}
