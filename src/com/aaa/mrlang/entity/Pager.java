package com.aaa.mrlang.entity;

import java.io.Serializable;
import java.util.List;

public class Pager implements Serializable {

    private Integer code=0;
    private String msg="";
    /**
     * 当前页码：传参
     */
    private Integer pageNo;
    /**
     * 每页条数：传参
     */
    private Integer pageSize;
    /**
     * 首页
     */
    private Integer first;
    /**
     * 下页
     */
    private Integer next;
    /**
     * 前页码
     */
    private Integer prev;
    /**
     * 尾页
     */
    private Integer last;

    /**
     * 总页数
     */
    private Integer pages;





    /**
     * 当前页要显示的数据集合
     */
    private List data;

    /**
     * 总条数
     */
    private Integer count;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Pager(Integer pageNo, Integer pageSize, List data, Integer totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.data = data;
        this.count = totalCount;

//        当前页的处理
        if(pageNo<=0) this.pageNo=1;

        //首页
        this.first=1;

        //总页数
        this.pages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        //前页
        if(this.pageNo>1){
            this.prev=this.pageNo-1;
        }else{
            this.prev=1;
        }

        //下页
        if(this.pageNo<this.pages){
            this.next=this.pageNo+1;
        }else{
            this.next=this.pages;
        }

        //尾页
        this.last=this.pages;





    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPrev() {
        return prev;
    }

    public void setPrev(Integer prev) {
        this.prev = prev;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", first=" + first +
                ", next=" + next +
                ", prev=" + prev +
                ", last=" + last +
                ", pages=" + pages +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
