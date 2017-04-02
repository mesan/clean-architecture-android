package com.netcompany.android.ncpizza.domain;

public class Pizza {
    private String name;
    private String imageSrc;

    public Pizza(String name, String imageSrc) {
        this.name = name;
        this.imageSrc = imageSrc;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getName() {
        return name;
    }
}
