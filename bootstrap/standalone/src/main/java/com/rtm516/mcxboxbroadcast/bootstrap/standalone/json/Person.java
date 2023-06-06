package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Person{

    @JsonProperty("gamertag")
    public String getGamertag() {
        return this.gamertag; }
    public void setGamertag(String gamertag) {
        this.gamertag = gamertag; }
    String gamertag;

    @JsonProperty("broadcast")
    public ArrayList<Object> getBroadcast() {
        return this.broadcast; }
    public void setBroadcast(ArrayList<Object> broadcast) {
        this.broadcast = broadcast; }
    ArrayList<Object> broadcast;

    @JsonProperty("presenceState")
    public Object getPresenceState() {
        return this.presenceState; }
    public void setPresenceState(Object presenceState) {
        this.presenceState = presenceState; }
    Object presenceState;

    @JsonProperty("displayPicRaw")
    public String getDisplayPicRaw() {
        return this.displayPicRaw; }
    public void setDisplayPicRaw(String displayPicRaw) {
        this.displayPicRaw = displayPicRaw; }
    String displayPicRaw;

    @JsonProperty("isFollowingCaller")
    public boolean getIsFollowingCaller() {
        return this.isFollowingCaller; }
    public void setIsFollowingCaller(boolean isFollowingCaller) {
        this.isFollowingCaller = isFollowingCaller; }
    boolean isFollowingCaller;

    @JsonProperty("displayName")
    public String getDisplayName() {
        return this.displayName; }
    public void setDisplayName(String displayName) {
        this.displayName = displayName; }
    String displayName;

    @JsonProperty("isBroadcasting")
    public boolean getIsBroadcasting() {
        return this.isBroadcasting; }
    public void setIsBroadcasting(boolean isBroadcasting) {
        this.isBroadcasting = isBroadcasting; }
    boolean isBroadcasting;

    @JsonProperty("recommendation")
    public Object getRecommendation() {
        return this.recommendation; }
    public void setRecommendation(Object recommendation) {
        this.recommendation = recommendation; }
    Object recommendation;

    @JsonProperty("gamerScore")
    public String getGamerScore() {
        return this.gamerScore; }
    public void setGamerScore(String gamerScore) {
        this.gamerScore = gamerScore; }
    String gamerScore;

    @JsonProperty("preferredColor")
    public PreferredColor getPreferredColor() {
        return this.preferredColor; }
    public void setPreferredColor(PreferredColor preferredColor) {
        this.preferredColor = preferredColor; }
    PreferredColor preferredColor;

    @JsonProperty("titleSummaries")
    public Object getTitleSummaries() {
        return this.titleSummaries; }
    public void setTitleSummaries(Object titleSummaries) {
        this.titleSummaries = titleSummaries; }
    Object titleSummaries;

    @JsonProperty("presenceTitleIds")
    public Object getPresenceTitleIds() {
        return this.presenceTitleIds; }
    public void setPresenceTitleIds(Object presenceTitleIds) {
        this.presenceTitleIds = presenceTitleIds; }
    Object presenceTitleIds;

    @JsonProperty("tournamentSummary")
    public Object getTournamentSummary() {
        return this.tournamentSummary; }
    public void setTournamentSummary(Object tournamentSummary) {
        this.tournamentSummary = tournamentSummary; }
    Object tournamentSummary;

    @JsonProperty("isQuarantined")
    public boolean getIsQuarantined() {
        return this.isQuarantined; }
    public void setIsQuarantined(boolean isQuarantined) {
        this.isQuarantined = isQuarantined; }
    boolean isQuarantined;

    @JsonProperty("titleHistory")
    public Object getTitleHistory() {
        return this.titleHistory; }
    public void setTitleHistory(Object titleHistory) {
        this.titleHistory = titleHistory; }
    Object titleHistory;

    @JsonProperty("xuid")
    public String getXuid() {
        return this.xuid; }
    public void setXuid(String xuid) {
        this.xuid = xuid; }
    String xuid;

    @JsonProperty("socialManager")
    public SocialManager getSocialManager() {
        return this.socialManager; }
    public void setSocialManager(SocialManager socialManager) {
        this.socialManager = socialManager; }
    SocialManager socialManager;

    @JsonProperty("follower")
    public Object getFollower() {
        return this.follower; }
    public void setFollower(Object follower) {
        this.follower = follower; }
    Object follower;

    @JsonProperty("isIdentityShared")
    public boolean getIsIdentityShared() {
        return this.isIdentityShared; }
    public void setIsIdentityShared(boolean isIdentityShared) {
        this.isIdentityShared = isIdentityShared; }
    boolean isIdentityShared;

    @JsonProperty("suggestion")
    public Object getSuggestion() {
        return this.suggestion; }
    public void setSuggestion(Object suggestion) {
        this.suggestion = suggestion; }
    Object suggestion;

    @JsonProperty("recentPlayer")
    public RecentPlayer getRecentPlayer() {
        return this.recentPlayer; }
    public void setRecentPlayer(RecentPlayer recentPlayer) {
        this.recentPlayer = recentPlayer; }
    RecentPlayer recentPlayer;

    @JsonProperty("titlePresence")
    public Object getTitlePresence() {
        return this.titlePresence; }
    public void setTitlePresence(Object titlePresence) {
        this.titlePresence = titlePresence; }
    Object titlePresence;

    @JsonProperty("isCloaked")
    public Object getIsCloaked() {
        return this.isCloaked; }
    public void setIsCloaked(Object isCloaked) {
        this.isCloaked = isCloaked; }
    Object isCloaked;

    @JsonProperty("showUserAsAvatar")
    public String getShowUserAsAvatar() {
        return this.showUserAsAvatar; }
    public void setShowUserAsAvatar(String showUserAsAvatar) {
        this.showUserAsAvatar = showUserAsAvatar; }
    String showUserAsAvatar;

    @JsonProperty("presenceDevices")
    public Object getPresenceDevices() {
        return this.presenceDevices; }
    public void setPresenceDevices(Object presenceDevices) {
        this.presenceDevices = presenceDevices; }
    Object presenceDevices;

    @JsonProperty("avatar")
    public Object getAvatar() {
        return this.avatar; }
    public void setAvatar(Object avatar) {
        this.avatar = avatar; }
    Object avatar;

    @JsonProperty("addedDateTimeUtc")
    public Object getAddedDateTimeUtc() {
        return this.addedDateTimeUtc; }
    public void setAddedDateTimeUtc(Object addedDateTimeUtc) {
        this.addedDateTimeUtc = addedDateTimeUtc; }
    Object addedDateTimeUtc;

    @JsonProperty("presenceDetails")
    public Object getPresenceDetails() {
        return this.presenceDetails; }
    public void setPresenceDetails(Object presenceDetails) {
        this.presenceDetails = presenceDetails; }
    Object presenceDetails;

    @JsonProperty("realName")
    public String getRealName() {
        return this.realName; }
    public void setRealName(String realName) {
        this.realName = realName; }
    String realName;

    @JsonProperty("xboxOneRep")
    public String getXboxOneRep() {
        return this.xboxOneRep; }
    public void setXboxOneRep(String xboxOneRep) {
        this.xboxOneRep = xboxOneRep; }
    String xboxOneRep;

    @JsonProperty("isFollowedByCaller")
    public boolean getIsFollowedByCaller() {
        return this.isFollowedByCaller; }
    public void setIsFollowedByCaller(boolean isFollowedByCaller) {
        this.isFollowedByCaller = isFollowedByCaller; }
    boolean isFollowedByCaller;

    @JsonProperty("communityManagerTitles")
    public Object getCommunityManagerTitles() {
        return this.communityManagerTitles; }
    public void setCommunityManagerTitles(Object communityManagerTitles) {
        this.communityManagerTitles = communityManagerTitles; }
    Object communityManagerTitles;

    @JsonProperty("multiplayerSummary")
    public MultiplayerSummary getMultiplayerSummary() {
        return this.multiplayerSummary; }
    public void setMultiplayerSummary(MultiplayerSummary multiplayerSummary) {
        this.multiplayerSummary = multiplayerSummary; }
    MultiplayerSummary multiplayerSummary;

    @JsonProperty("presenceText")
    public Object getPresenceText() {
        return this.presenceText; }
    public void setPresenceText(Object presenceText) {
        this.presenceText = presenceText; }
    Object presenceText;

    @JsonProperty("detail")
    public Object getDetail() {
        return this.detail; }
    public void setDetail(Object detail) {
        this.detail = detail; }
    Object detail;

    @JsonProperty("isFavorite")
    public boolean getIsFavorite() {
        return this.isFavorite; }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite; }
    boolean isFavorite;
}