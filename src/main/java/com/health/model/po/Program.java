package com.health.model.po;

import java.util.Date;

public class Program {
	
	/**
	 * 健身方案ID
	 */
    private Integer id;

    /**
     * 处方目的
     */
    private String cfmd;

    /**
     * 教练ID
     */
    private Integer teacherId;

    /**
     * 健身注意点
     */
    private String jszyd;

    /**
     * 教练名字
     */
    private String teacherName;

    /**
     * 天数
     */
    private Integer days;

    /**
     * 添加日期
     */
    private Date createDate;
    
    private String no;
    
    

    public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCfmd() {
        return cfmd;
    }

    public void setCfmd(String cfmd) {
        this.cfmd = cfmd;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getJszyd() {
        return jszyd;
    }

    public void setJszyd(String jszyd) {
        this.jszyd = jszyd;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}