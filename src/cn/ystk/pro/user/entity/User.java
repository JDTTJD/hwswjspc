package cn.ystk.pro.user.entity;
import java.util.Date;
import cn.ystk.pro.base.BaseEntity;
/**
 * 
 * 功能:用户entity
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月7日
 * 修改日期: 2017年4月7日
 * 修改列表:
 */
public class User extends BaseEntity{
    /**
	 * 描述含义
	 */
	private static final long serialVersionUID = 1L;
	//用户名
	private String username;
	//密码
	private String password;
   //生日
	private Date birthday;
    //性别 1：男   2：女
	private String sex;
	//地址
    private String address;
    //电话
    private String telephone;
    //特长
    private Integer speciality;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Integer speciality) {
		this.speciality = speciality;
	}
	
    
}