package com.aaa.mrlang.entity;

import java.util.List;

/**
 * @author 郎老师
 * @company AAA软件教育
 * @title PageInfo
 * @date 2019/9/21 18:25
 */
public class PageInfo {
    private Integer draw;
    private List data;
    private Integer start;
    private Integer length;
    private Integer recordsTotal;
    private Integer recordsFiltered;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public PageInfo(List data, Integer start, Integer length, Integer recordsTotal) {
        this.data = data;
        this.start = start;
        this.length = length;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered=recordsTotal;
    }
}
