package com.tensquare.spit.service;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName: SpitServicee
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 16:41
 * @Description: 吐槽业务层
 */
public interface SpitService {

    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Spit> findAll();

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */
    public Spit findById(String id);

    /**
     * 增加
     *
     * @param spit
     */
    public void add(Spit spit);

    /**
     * 修改
     *
     * @param spit
     */
    public void update(Spit spit);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据上级ID查询吐槽列表
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentid(String parentid, int page, int size);

    /**
     * 点赞
     * @param id
     */
    public void updateThumbup(String id);

}
