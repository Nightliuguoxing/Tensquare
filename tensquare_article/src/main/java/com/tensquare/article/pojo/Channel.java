package com.tensquare.article.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: Channel
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:38
 * @Description: 频道实体类
 */
@Entity
@Table(name = "tb_channel")
public class Channel implements Serializable {

    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 频道名称
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

