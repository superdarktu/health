package com.health.model.po;

import java.util.Date;

public class Classs {
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 教师姓名
     */
    private String teacherName;


    /**
     * 上课时间 周几
     */
    private String daytime;

    /**
     * 上课地点
     */
    private String place;

    /**
     * 开课时间
     */
    private String classTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 开课时间段
     */
    private String longTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }
}