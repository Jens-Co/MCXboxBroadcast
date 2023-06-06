package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Title {

    @JsonProperty("titleName")
    public String getTitleName() {
        return this.titleName; }
    public void setTitleName(String titleName) {
        this.titleName = titleName; }
    String titleName;

    @JsonProperty("titleId")
    public String getTitleId() {
        return this.titleId; }
    public void setTitleId(String titleId) {
        this.titleId = titleId; }
    String titleId;

    @JsonProperty("lastPlayedWithDateTime")
    public Date getLastPlayedWithDateTime() {
        return this.lastPlayedWithDateTime; }
    public void setLastPlayedWithDateTime(Date lastPlayedWithDateTime) {
        this.lastPlayedWithDateTime = lastPlayedWithDateTime; }
    Date lastPlayedWithDateTime;
}