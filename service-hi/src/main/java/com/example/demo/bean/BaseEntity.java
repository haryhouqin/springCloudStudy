package com.example.demo.bean;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    protected int page = 1;

    protected int size = 20;
    /**
     * 排序名 ，默认 id
     */
    protected String sidx = "id";

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
