package com.health.model.po;

import java.util.Date;

public class Student {
	/**
	 * 学生ID
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
    private String birthday;

    /**
     * 身份证号
     */
    private String sfid;

    /**
     * 联系号码
     */
    private String phone;

    /**
     * 工作
     */
    private String job;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 籍贯
     */
    private String jg;

    /**
     * 体测单ID
     */
    private Integer tcdid;

    /**
     * 健身方案ID
     */
    private String jsfaid;
    
    /**
     * 学员编号
     */
    private String no;
    
    /**
     * 年龄
     */
    private Integer age;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Integer getTcdid() {
        return tcdid;
    }

    public void setTcdid(Integer tcdid) {
        this.tcdid = tcdid;
    }

    public String getJsfaid() {
        return jsfaid;
    }

    public void setJsfaid(String jsfaid) {
        this.jsfaid = jsfaid;
    }

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
}