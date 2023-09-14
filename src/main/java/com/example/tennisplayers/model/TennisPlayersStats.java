package com.example.tennisplayers.model;

public class TennisPlayersStats {

    private String bestRatioCountry;
    private float averageIMC;
    private float medianHeight;

    public String getBestRatioCountry() {
        return bestRatioCountry;
    }

    public void setBestRatioCountry(String bestRatioCountry) {
        this.bestRatioCountry = bestRatioCountry;
    }

    public float getAverageIMC() {
        return averageIMC;
    }

    public void setAverageIMC(float averageIMC) {
        this.averageIMC = averageIMC;
    }

    public float getMedianHeight() {
        return medianHeight;
    }

    public void setMedianHeight(float medianHeight) {
        this.medianHeight = medianHeight;
    }
}
