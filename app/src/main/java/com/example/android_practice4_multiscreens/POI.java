package com.example.android_practice4_multiscreens;

public class POI {
    private String POIName;
    private String countryName;
    private String img1;
    private String img2;
    private String detail;

    public POI(String POIName, String countryName, String img1, String img2, String detail) {
        this.POIName = POIName;
        this.countryName = countryName;
        this.img1 = img1;
        this.img2 = img2;
        this.detail = detail;
    }

    public POI() {
        this.POIName = "";
        this.countryName = "";
        this.img1 = "";
        this.img2 = "";
        this.detail = "";
    }

    public String getPOIName() {
        return POIName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getDetail() {
        return detail;
    }
}
