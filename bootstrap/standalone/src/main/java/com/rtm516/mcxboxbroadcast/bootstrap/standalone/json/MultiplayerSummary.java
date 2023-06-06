package com.rtm516.mcxboxbroadcast.bootstrap.standalone.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MultiplayerSummary{

    @JsonProperty("InParty")
    public int getInParty() {
        return this.inParty; }
    public void setInParty(int inParty) {
        this.inParty = inParty; }
    int inParty;

    @JsonProperty("InMultiplayerSession")
    public int getInMultiplayerSession() {
        return this.inMultiplayerSession; }
    public void setInMultiplayerSession(int inMultiplayerSession) {
        this.inMultiplayerSession = inMultiplayerSession; }
    int inMultiplayerSession;
}