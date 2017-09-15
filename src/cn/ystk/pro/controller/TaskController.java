/**  
*
*/
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cn.ystk.pro.task.entity.Task;
import cn.ystk.pro.task.entity.TaskPage;
import cn.ystk.pro.task.service.TaskService;
import cn.ystk.pro.user.entity.User;
import cn.ystk.pro.user.service.UserService;
import cn.ystk.pro.util.DateUtil;

/**
 * 
 * Title：hwswjs Description：TaskController
 * 
 * @author：唐及第
 * @date：2017年7月12日 下午4:35:40
 * @version 1.0
 * 
 */
/**
 * 
 * Title：hwswjs 功能：控制页面的跳转
 * 
 * @author：唐及第
 * @date：2017年7月25日 下午3:32:16
 * @version 1.0
 *
 */
@Controller
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@RequestMapping("/taskSendList")
	public ModelAndView taskQuery() {
		// List<Task> taskList = taskService.findTaskList();
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("task", taskList);

		modelAndView.setViewName("task/taskMain");
		return modelAndView;

	}

	/**
	 * 显示用户列表
	 */
	
	@RequestMapping("/findTaskList")
	public void findTaskList(@RequestParam(value = "rows", required = true) Integer rows,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "order", required = true) String order,
			@RequestParam(value = "sort", required = true) String sort, HttpServletResponse response) throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			page = page - 1;
			out = response.getWriter();
			TaskPage taskPage = new TaskPage();
			taskPage.setFirstRec(page);
			taskPage.setPageSize(rows);
			taskPage.setOrder(order);
			taskPage.setSort(sort);
			Task task = new Task();
			taskPage.setTask(task);

			int iTotalRecords = taskService.getCount(taskPage);

			List<Task> taskList = taskService.findByPage(taskPage);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (taskList != null && taskList.size() > 0) {
				for (Task t : taskList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", t.getId());
					if (t.getTaskName() != null && !"".equals(t.getTaskName())) {
						map.put("taskName", t.getTaskName());
					} else {
						map.put("taskName", "&nbsp;");
					}
					if (!"".equals(t.getRoleId())) {
						map.put("roleId", t.getRoleId());
					} else {
						map.put("roleId", "&nbsp;");
					}
					if (t.getTaskContent() != null && !"".equals(t.getTaskContent())) {
						map.put("taskContent", t.getTaskContent());
					} else {
						map.put("taskContent", "&nbsp;");
					}
					if (t.getCreateTime() != null) {
						map.put("createTime", DateUtil.formatDateYYmmddHHmmss(t.getCreateTime()));
					} else {
						map.put("createTime", "&nbsp;");
					}
					if (!"".equals(t.getCreateUserId())) {
						User user = userService.findUserById(t.getCreateUserId());
						if (user != null) {
							map.put("createUserId", user.getUsername());
						}
					} else {
						map.put("createUserId", "&nbsp;");
					}
					mapList.add(map);
				}
			}
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", iTotalRecords);
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
	}

	/**
	 * 功能：删除任务
	 */
	@RequestMapping("/deleteTasks")
	// required=false表示不传的话，会给参数赋值为null，required=true就是必须要有
	public String deleteTasks(@RequestParam(value = "ids", required = true) String ids, HttpServletResponse response)
			throws Exception {
		response.setContentType("application/xml;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String deleteTasksSuccess = "1";
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			String[] tIds = ids.split(",");
			if (tIds != null && tIds.length > 0) {
				for (int i = 0; i < tIds.length; i++) {
					Task task = new Task();
					Integer tId = Integer.parseInt(tIds[i]);
					task.setId(tId);
					taskService.deleteTasks(tId);
				}
			}
			deleteTasksSuccess = "2";
			jsonMap.put("deleteTasksSuccess", deleteTasksSuccess);
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
	 * @author Administratort 新增
	 */
	// required=false表示不传的话，会给参数赋值为null，required=true就是必须要有
	@RequestMapping("/addTask")
	public String saveTask(@RequestParam(required = false) String taskname,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(required = false) String taskmain, HttpServletRequest request, HttpServletResponse response) {
		try {
			String success = "1";
			// username=(String) request.getAttribute("username");
			Task task = new Task();
			task.setTaskName(taskname);
			task.setTaskContent(taskmain);
			// 传入登陆人的username
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("u");
			Integer userId = null;
			if (user != null) {
				userId = user.getId();
			}
			task.setCreateUserId(userId);// userid

			/*
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"
			 * ); Date time = null; time = sdf.parse(sdf.format(new Date()));
			 */
			task.setCreateTime(new Date());
			int saveTaskFlag = taskService.saveTask(task);
			if (saveTaskFlag == 1) {
				success = "2";
			}
			PrintWriter writer = new PrintWriter(response.getWriter());
			writer.print(success);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;

	}
}
