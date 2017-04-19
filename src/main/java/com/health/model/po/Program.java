package com.health.model.po;

import java.util.Date;

public class Program {
    private Integer id;

    private String cfmd;

    private Integer teacherId;

    private String jszyd;

    private String teacherName;

    private Integer days;

    private Date createDate;

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