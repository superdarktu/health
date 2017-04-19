package com.health.model.po;

public class Equipment {
    private Integer id;

    private String name;

    private String part;

    private String useway;

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