/**  
*
*/
package cn.ystk.pro.task.service;

import java.util.List;

import cn.ystk.pro.task.entity.Task;
import cn.ystk.pro.task.entity.TaskPage;

/**
 * 
 * Title：hwswjs Description：TaskService
 * 
 * @author：唐及第
 * @date：2017年7月12日 下午5:08:50
 * @version 1.0
 * 
 */
public interface TaskService {
	List<Task> findTaskList();

	int saveTask(Task task);

	/**
	 * 总的记录数
	 */
	Integer getCount(TaskPage page);

	/**
	 * 列表
	 */
	List<Task> findByPage(TaskPage page);

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	void deleteTasks(Integer id);

	/**
	 * 更新任务
	 */
	int updateTask(Task task);
}
