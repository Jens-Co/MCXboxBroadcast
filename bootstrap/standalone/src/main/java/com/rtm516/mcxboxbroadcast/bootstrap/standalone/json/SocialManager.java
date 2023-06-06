package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SocialManager {

    @JsonProperty("pages")
    public ArrayList<Object> getPages() {
        return this.pages;
    }

    public void setPages(ArrayList<Object> pages) {
        this.pages = pages;
    }

    ArrayList<Object> pages;

    @JsonProperty("titleIds")
    public ArrayList<Object> getTitleIds() {
        return this.titleIds;
    }

    public void setTitleIds(ArrayList<Object> titleIds) {
        this.titleIds = titleIds;
    }

    ArrayList<Object> titleIds;
}