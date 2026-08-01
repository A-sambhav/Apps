package com.example.planetsapp;
// this class is acting as a model for the listview
public class Planet {
// Attributes
    private String planetname;
    private String mooncount;
    private int planetImage;
// Constructor
    public Planet(String planetname, String mooncount, int planetImage) {
        this.planetname = planetname;
        this.mooncount = mooncount;
        this.planetImage = planetImage;
    }
    // Getter Methods
    public String getPlanetname() {
        return planetname;
    }
    public String getMooncount() {
        return mooncount;
    }
    public int getPlanetImage() {
        return planetImage;
    }
    // Setter Methods
    public void setPlanetname(String planetname) {
        this.planetname = planetname;
    }
    public void setMooncount(String mooncount) {
        this.mooncount = mooncount;
    }
    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }

}
