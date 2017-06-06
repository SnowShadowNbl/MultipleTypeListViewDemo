package com.nbl.multipletypelistviewdemo.model;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public enum ItemType {

    ADVERTISEMENT(0),//广告轮播图
    DOUBLE_AD(1),//两个功能位
    TAG(2),//标题
    HORIZONTAL_VIEW(3),//横向滑动VIEW
    QUALITY_GOODS(4),//中图列表
    BIG_IMG(5);//大图列表

    private int value;

    ItemType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
