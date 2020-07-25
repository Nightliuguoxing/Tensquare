package com.tensquare.common.entity;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Author: Samele LGX
 * @CreateTime: 2020-07-24 20:30
 * @Description:
 */
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
