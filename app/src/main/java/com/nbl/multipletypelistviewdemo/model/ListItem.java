package com.nbl.multipletypelistviewdemo.model;

import java.util.List;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class ListItem {

    private ItemType itemType;

    private List<Advertisement> advertisementList;

    private String tagName;

    private List<Quality> qualityList;

    private List<Horizontal> horizontalList;

    private BigImage bigImage;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public List<Advertisement> getAdvertisementList() {
        return advertisementList;
    }

    public void setAdvertisementList(List<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Quality> getQualityList() {
        return qualityList;
    }

    public void setQualityList(List<Quality> qualityList) {
        this.qualityList = qualityList;
    }

    public List<Horizontal> getHorizontalList() {
        return horizontalList;
    }

    public void setHorizontalList(List<Horizontal> horizontalList) {
        this.horizontalList = horizontalList;
    }

    public BigImage getBigImage() {
        return bigImage;
    }

    public void setBigImage(BigImage bigImage) {
        this.bigImage = bigImage;
    }
}
