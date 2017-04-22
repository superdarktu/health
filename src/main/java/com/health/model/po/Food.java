package com.health.model.po;

public class Food {
    private Integer id;

    /**
     * 食物名称
     */
    private String name;

    /**
     * 食物类别
     */
    private String sort;

    /**
     * 食物热量
     */
    private Integer number;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}