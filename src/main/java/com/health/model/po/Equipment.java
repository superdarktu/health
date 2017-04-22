package com.health.model.po;

public class Equipment {

    /**
     * id
     */
    private Integer id;

    /**
     * 器材名字
     */
    private String name;

    /**
     * 锻炼部位
     */
    private String part;

    /**
     * 使用方法说明
     */
    private String useway;

    /**
     * 使用注意方式
     */
    private String useattention;

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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getUseway() {
        return useway;
    }

    public void setUseway(String useway) {
        this.useway = useway;
    }

    public String getUseattention() {
        return useattention;
    }

    public void setUseattention(String useattention) {
        this.useattention = useattention;
    }
}