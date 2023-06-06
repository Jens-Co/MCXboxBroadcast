package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RecentPlayer{
    @JsonProperty("titles")
    public ArrayList<Title> getTitles() {
        return this.titles; }
    public void setTitles(ArrayList<Title> titles) {
        this.titles = titles; }
    ArrayList<Title> titles;
    @JsonProperty("text")
    public String getText() {
        return this.text; }
    public void setText(String text) {
        this.text = text; }
    String text;
}