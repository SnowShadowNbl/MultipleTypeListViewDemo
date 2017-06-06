package com.nbl.multipletypelistviewdemo.model;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class Advertisement {

    private String imageUrl;

    private String titles;

    public Advertisement(String imageUrl, String titles) {
        this.imageUrl = imageUrl;
        this.titles = titles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
