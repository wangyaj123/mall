package com.office.mall.response;

public class UserResponse {

    private Integer id;


    private String username;


    private String password;


    private String phone;


    private Integer status;


    private String icon;


    private Long createTime;

    private Long lastLoginTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", icon='" + icon + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}