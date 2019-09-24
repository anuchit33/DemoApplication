package com.theim.demo.models;

import java.io.Serializable;

public class News implements Serializable {

    private String host = "https://www-stg.aagold-th.com";

    private String title;
    private String image;
    private String detail;
    private int id;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return host+image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
