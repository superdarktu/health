package com.health.model.po;

public class Item {

    /**
     * 方案ID
     */
    private Integer id;

    private Integer programId;

    private String no;

    /**
     * 运动项目
     */
    private String name;

    /**
     * 负荷
     */
    private Double load;

    /**
     * 时间间隔
     */
    private Integer interval;

    /**
     * 组词/次数
     */
    private Integer number;

    /**
     * 动作要点
     */
    private String points;

    /**
     * 注意事项
     */
    private String matter;


    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLoad() {
        return load;
    }

    public void setLoad(Double load) {
        this.load = load;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}