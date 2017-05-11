package com.health.model.po;

public class Login {

    /**
     * ID
     */
    private Integer id;

    /**
     * 用户类型 1：管理员 2：教练  3：学员
     */
    private String usertype;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}