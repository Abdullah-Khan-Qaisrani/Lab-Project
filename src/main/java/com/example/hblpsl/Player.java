package com.example.hblpsl;

import java.security.PrivateKey;

public class Player {

    private String imagePath;
    private String playerID;
    private String playerName;
    private String nationality;
    private String franchise;
    private String role;
    private int age;
    private int jerseyNumber;
    private int totalRuns;
    private int highestScores;
    private int centuries;
    private int halfCenturies;
    private static int counter = 0;

    public Player(String playerName, String nationality, String franchise, String role, int age,
                  int jerseyNumber, int totalRuns, int highestScores, int centuries, int halfCenturies, String imagePath) {
        this.imagePath = imagePath;
        this.playerID = String.format("%03d",++counter);
        this.playerName = playerName;
        this.age = age;
        this.nationality = nationality;
        this.franchise = franchise;
        this.role = role;
        this.jerseyNumber = jerseyNumber;
        this.totalRuns = totalRuns;
        this.highestScores = highestScores;
        this.halfCenturies = halfCenturies;
        this.centuries = centuries;
    }


    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getHighestScores() {
        return highestScores;
    }

    public void setHighestScores(int highestScores) {
        this.highestScores = highestScores;
    }

    public int getCenturies() {
        return centuries;
    }

    public void setCenturies(int centuries) {
        this.centuries = centuries;
    }

    public int getHalfCenturies() {
        return halfCenturies;
    }

    public void setHalfCenturies(int halfCenturies) {
        this.halfCenturies = halfCenturies;
    }

    @Override
    public String toString() {
        return imagePath + "," + playerID + "," + playerName + "," + age + "," + nationality + "," + franchise + "," + role + "," + jerseyNumber + "," + totalRuns + "," + highestScores + "," + halfCenturies + "," + centuries;
    }
}
