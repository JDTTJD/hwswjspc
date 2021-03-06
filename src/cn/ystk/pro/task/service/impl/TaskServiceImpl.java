/**  
*
*/
package cn.ystk.pro.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.task.entity.Task;
import cn.ystk.pro.task.entity.TaskPage;
import cn.ystk.pro.task.mapper.TaskMapper;
import cn.ystk.pro.task.service.TaskService;

/**
 * 
 * Title：hwswjs Description：TaskServiceImpl
 * 
 * @author：唐及第
 * @date：2017年7月12日 下午5:10:16
 * @version 1.0
 * 
 */
public class TaskServiceImpl implements TaskService {
	@Override
	public int updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskMapper.updateTask(task);
	}

	@Autowired
	private TaskMapper taskMapper;

	

	@Override
	public List<Task> findTaskList() {
		// TODO Auto-generated method stub
		return taskMapper.findTaskList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.ystk.pro.task.service.TaskService#saveTask(cn.ystk.pro.task.entity.
	 * Task)
	 */
	@Override
	public int saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskMapper.saveTask(task);
	}

	@Override
	public Integer getCount(TaskPage page) {
		// TODO Auto-generated method stub
		return taskMapper.getCount(page);
	}

	@Override
	public List<Task> findByPage(TaskPage page) {
		// TODO Auto-generated method stub
		return taskMapper.findByPage(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.ystk.pro.task.service.TaskService#deleteTasks(java.lang.Integer)
	 */
	@Override
	public void deleteTasks(Integer id) {
		// TODO Auto-generated method stub
		taskMapper.deleteTasks(id);
	}

}
