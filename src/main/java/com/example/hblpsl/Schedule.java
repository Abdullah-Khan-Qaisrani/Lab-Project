package com.example.hblpsl;


import java.util.ArrayList;

public class Schedule {
    private ArrayList<Match10> matches = new ArrayList<>();

    public void addNewMatch(Match10 match) {
        matches.add(match);
    }

    public ArrayList<Match10> getMatches() {
        return matches;
    }


}