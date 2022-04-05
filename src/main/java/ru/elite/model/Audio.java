package ru.elite.model;

import java.util.Map;

public class Audio {
    private String head;
    private Map<String, Rank> ranks;

    public String getHead() { return head; }
    public void setHead(String value) { this.head = value; }

    public Map<String, Rank> getRanks() { return ranks; }
    public void setRanks(Map<String, Rank> value) { this.ranks = value; }
}
