package com.health.model.po;

import java.util.Date;

public class Teacher {
	
	/**
	 * 教师ID
	 */
    private Integer id;
    
    /**
     * 登录ID
     */
    private Integer loginId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String sfid;

    /**
     * 联系号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 籍贯
     */
    private String jg;

    /**
     * 教练编号
     */
    private String no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSfid() {
        return sfid;
    }

    public void setSfid(String sfid) {
        this.sfid = sfid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
    
}