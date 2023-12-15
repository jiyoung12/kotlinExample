package com.jyhong.domain.model;

import com.jiyoung.kotilnexample.server.model.NewsItemContent;

import java.util.List;

public class PageListModel {
    public long id;
    public long totalResult;
    public List<NewsItemContent> articles;
}
