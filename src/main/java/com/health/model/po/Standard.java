package com.health.model.po;

public class Standard {

    /**
     * ID
     */
    private Integer id;

    /**
     * 运动项目
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 开始年龄
     */
    private Integer startAge;

    /**
     * 结束年龄
     */
    private Integer endAge;

    /**
     * 一分的标准
     */
    private Double one;

    /**
     * 二分的标准
     */
    private Double two;

    /**
     * 三分的标准
     */
    private Double three;

    /**
     * 四分的标准
     */
    private Double four;

    /**
     * 五分的标准
     */
    private Double five;


    private Integer num;


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public Double getOne() {
        return one;
    }

    public void setOne(Double one) {
        this.one = one;
    }

    public Double getTwo() {
        return two;
    }

    public void setTwo(Double two) {
        this.two = two;
    }

    public Double getThree() {
        return three;
    }

    public void setThree(Double three) {
        this.three = three;
    }

    public Double getFour() {
        return four;
    }

    public void setFour(Double four) {
        this.four = four;
    }

    public Double getFive() {
        return five;
    }

    public void setFive(Double five) {
        this.five = five;
    }
}