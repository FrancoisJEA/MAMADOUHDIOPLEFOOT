package com.footaddict.superstars.footaddict;

public class LiveMatch {

    private String league_name;

    private String status;

    private String events;

    private String score;

    private String id;

    private String time;

    private String away_name;

    private String home_name;

    private String last_changed;


    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAway_name() {
        return away_name;
    }

    public void setAway_name(String away_name) {
        this.away_name = away_name;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getLast_changed() {
        return last_changed;
    }

    public void setLast_changed(String last_changed) {
        this.last_changed = last_changed;
    }

    @Override
    public String toString() {
        return "Live: [league_name = " + league_name + ", status = " + status + ", events = " + events + ", score = " + score + ", id = " + id + ", time = " + time + ", away_name = " + away_name + ", home_name = " + home_name + ", last_changed = " + last_changed + "]";
    }
}