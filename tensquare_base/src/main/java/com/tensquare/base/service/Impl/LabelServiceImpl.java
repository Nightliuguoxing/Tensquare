package com.tensquare.base.service.Impl;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LabelServiceImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 10:18
 * @Description: 标签业务逻辑实现
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     *
     * @return
     */
    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return
     */
    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param label
     */
    @Override
    public void add(Label label) {
        // SET ID
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     *
     * @param label
     */
    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Label> findSearch(Map searchMap) {
        Specification specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 分页条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification, pageRequest);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("labelname") != null &&
                        !"".equals(searchMap.get("labelname"))) {
                    predicateList.add(cb.like(
                            root.get("labelname").as(String.class), "%" +
                                    (String) searchMap.get("labelname") + "%"));
                }
                if (searchMap.get("state") != null &&
                        !"".equals(searchMap.get("state"))) {
                    predicateList.add(cb.equal(
                            root.get("state").as(String.class), (String) searchMap.get("state")));
                }
                if (searchMap.get("recommend") != null &&
                        !"".equals(searchMap.get("recommend"))) {
                    predicateList.add(cb.equal(
                            root.get("recommend").as(String.class),
                            (String) searchMap.get("recommend")));
                }
                return cb.and(predicateList.toArray(new
                        Predicate[predicateList.size()]));
            }
        };
    }
}