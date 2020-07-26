package com.tensquare.spit.service.Impl;

import com.tensquare.common.util.IdWorker;
import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: SpitServiceImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 16:44
 * @Description: 吐槽业务层实现
 */
@Service
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部记录
     *
     * @return
     */
    @Override
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */
    @Override
    public Spit findById(String id) {
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 增加
     *
     * @param spit
     */
    @Override
    public void add(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        // 发布日期
        spit.setPublishtime(new Date());
        // 浏览量
        spit.setVisits(0);
        // 分享数
        spit.setShare(0);
        // 点赞数
        spit.setThumbup(0);
        // 回复数
        spit.setComment(0);
        // 状态
        spit.setState("1");
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            //如果存在上级ID,评论
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        spitDao.save(spit);
    }

    /**
     * 修改
     *
     * @param spit
     */
    @Override
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageRequest);
    }

    /**
     * 点赞
     *
     * @param id
     */
    @Override
    public void updateThumbup(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }
}
