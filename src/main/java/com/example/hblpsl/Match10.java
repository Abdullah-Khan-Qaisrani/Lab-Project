package com.example.hblpsl;

public class Match10 {
    private Team team1;
    private Team team2;
    private Ground venue;
    private String date;
    private String result = "Not Played Yet";

    public Match10(Team team1, Team team2, Ground venue) {
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
    }

    public void addDate(String date) {
        this.date = date;
    }

    public boolean teamsComparison(Match10 otherMatch) {
        return this.team1.equals(otherMatch.team1) || this.team1.equals(otherMatch.team2) ||
                this.team2.equals(otherMatch.team1) || this.team2.equals(otherMatch.team2);
    }

    Ground ground = new Ground();

    @Override
    public String toString() {
        return team1.toString() + " vs " + team2.toString() + ", " + date + ", " + ground.toString() + ", Result: Not Played Yet";
    }

}
