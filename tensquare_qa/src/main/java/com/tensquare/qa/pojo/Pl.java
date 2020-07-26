package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName: Pl
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 08:43
 * @Description: 问答中间表实体类
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {

    @Id
    private String problemid;

    @Id
    private String lableid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLableid() {
        return lableid;
    }

    public void setLableid(String lableid) {
        this.lableid = lableid;
    }
}
