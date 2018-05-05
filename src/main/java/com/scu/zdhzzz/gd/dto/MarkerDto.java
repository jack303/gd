package com.scu.zdhzzz.gd.dto;


public class MarkerDto {
    private String name;
    private double[] lnglat;
    private String id;


    public MarkerDto(String name,  String id, double... lnglat) {
        this.name = name;
        this.lnglat = lnglat;
        this.id = id;
    }

    public MarkerDto(String name, double[] lnglat) {
        this.name = name;
        this.lnglat = lnglat;
    }

    public MarkerDto(double... lnglat) {
        this("",lnglat);
    }

    public MarkerDto() {
    }

    public String getName() {
        return name;
    }

    public double[] getLnglat() {
        return lnglat;
    }

    public void setLnglat(double[] lnglat) {
        this.lnglat = lnglat;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
