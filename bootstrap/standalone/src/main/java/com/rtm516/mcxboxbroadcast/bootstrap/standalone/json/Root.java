package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root {
    @JsonProperty("friendFinderState")
    public Object getFriendFinderState() {
        return this.friendFinderState;
    }

    public void setFriendFinderState(Object friendFinderState) {
        this.friendFinderState = friendFinderState;
    }

    Object friendFinderState;

    @JsonProperty("people")
    public ArrayList<Person> getPeople() {
        return this.people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    ArrayList<Person> people;

    @JsonProperty("recommendationSummary")
    public Object getRecommendationSummary() {
        return this.recommendationSummary;
    }

    public void setRecommendationSummary(Object recommendationSummary) {
        this.recommendationSummary = recommendationSummary;
    }

    Object recommendationSummary;
}