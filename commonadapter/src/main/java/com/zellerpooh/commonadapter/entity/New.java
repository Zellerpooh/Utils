package com.zellerpooh.commonadapter.entity;

/**
 * Created by Zellerpooh on 16/8/26.
 */
public class New {
    public String title;
    public String content;
    public String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public New() {
    }

    public New(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
