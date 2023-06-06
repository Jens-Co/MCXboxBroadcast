package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreferredColor{

    @JsonProperty("primaryColor")
    public String getPrimaryColor() {
        return this.primaryColor; }
    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor; }
    String primaryColor;

    @JsonProperty("tertiaryColor")
    public String getTertiaryColor() {
        return this.tertiaryColor; }
    public void setTertiaryColor(String tertiaryColor) {
        this.tertiaryColor = tertiaryColor; }
    String tertiaryColor;

    @JsonProperty("secondaryColor")
    public String getSecondaryColor() {
        return this.secondaryColor; }
    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor; }
    String secondaryColor;
}