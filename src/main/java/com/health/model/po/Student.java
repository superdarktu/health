package com.health.model.po;

import java.util.Date;

public class Student {
    private Integer id;
    
    private Integer loginId;

    private String name;

    private String sex;

    private Date birthday;

    private String sfid;

    private String phone;

    private String job;

    private String email;

    private String jg;

    private Integer tcdid;

    private Integer jsfaid;

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

    public Integer getJsfaid() {
        return jsfaid;
    }

    public void setJsfaid(Integer jsfaid) {
        this.jsfaid = jsfaid;
    }
}