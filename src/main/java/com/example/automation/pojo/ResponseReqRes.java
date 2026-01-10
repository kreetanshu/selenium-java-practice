package com.example.automation.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseReqRes {
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    private List<DataItem> data;
    @JsonProperty("_meta")
    private Meta meta;
    private int page;
    @JsonProperty("total_pages")
    private int totalPages;
    private Support support;

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}