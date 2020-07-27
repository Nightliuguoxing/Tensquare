package com.tensquare.user.pojo;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: Admin
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:42
 * @Description: 管理员实体类
 */
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {

    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 登陆名称
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

