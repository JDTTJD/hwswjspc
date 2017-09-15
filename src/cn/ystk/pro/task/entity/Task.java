/**  
*
*/
package cn.ystk.pro.task.entity;

import java.util.Date;

/**
 * 
 * Title：hwswjs Description：Task
 * 
 * @author：唐及第
 * @date：2017年7月12日 下午4:55:03
 * @version 1.0
 * 
 */
public class Task {
	private int id;
	private String taskName;
	private int roleId;
	private String taskContent;
	private Date createTime;
	private int createUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

}
