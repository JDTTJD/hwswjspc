package cn.ystk.pro.log.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 功能:日志自动拦截功能
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
public class Log  implements Serializable{   
    private static final long serialVersionUID = 1024792477652984770L;  
    private Integer id;// 日志id
    private Integer userid;//管理员id  
    private Date createdate;//日期  
    private String content;//日志内容  
    private String operation;//操作(主要是"添加"、"修改"、"删除")   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
    
}  