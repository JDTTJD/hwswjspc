/**  
*
*/
package cn.ystk.pro.task.mapper;

import java.util.List;

import cn.ystk.pro.task.entity.Task;
import cn.ystk.pro.task.entity.TaskPage;

/**
 * 
 * Title：hwswjs Description：TaskMapper
 * 
 * @author：唐及第
 * @date：2017年7月12日 下午5:11:05
 * @version 1.0
 * 
 */
public interface TaskMapper {
	List<Task> findTaskList();

	/**
	 * 保存任务
	 */
	int saveTask(Task task);

	/**
	 * 总记录数
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
