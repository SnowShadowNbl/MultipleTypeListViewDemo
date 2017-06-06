package com.nbl.multipletypelistviewdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.adapter.HomeAdapter;
import com.nbl.multipletypelistviewdemo.model.Advertisement;
import com.nbl.multipletypelistviewdemo.model.BigImage;
import com.nbl.multipletypelistviewdemo.model.Horizontal;
import com.nbl.multipletypelistviewdemo.model.ItemType;
import com.nbl.multipletypelistviewdemo.model.ListItem;
import com.nbl.multipletypelistviewdemo.model.Quality;
import com.nbl.multipletypelistviewdemo.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: Nbl(SnowShadow)
 * email: vsnowshadow@gmail.com
 * created
 */
public class HomeActivity extends AppCompatActivity implements
        SwipeRefreshLayout.OnRefreshListener, SwipeRefreshView.OnLoadListener {

    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.swipe_container)
    SwipeRefreshView swipeContainer;

    private boolean isRefresh = false;//是否刷新中

    private List<ListItem> listItemList = new ArrayList<>();
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(this);
        swipeContainer.setOnLoadListener(this);
        swipeContainer.setColorSchemeColors(Color.GRAY);

        initView();

    }

    private void initView() {

        addAdData();

        ListItem doubleAd = new ListItem();
        doubleAd.setItemType(ItemType.DOUBLE_AD);
        listItemList.add(doubleAd);

        ListItem tag1 = new ListItem();
        tag1.setItemType(ItemType.TAG);
        tag1.setTagName("精品推荐");
        listItemList.add(tag1);

        addQualityData(2);
        addQualityData(1);

        mHomeAdapter = new HomeAdapter(this, listItemList);
        lv.setAdapter(mHomeAdapter);

        ListItem tag2 = new ListItem();
        tag2.setItemType(ItemType.TAG);
        tag2.setTagName("商家自荐");
        listItemList.add(tag2);

        addHorizontalData();

        ListItem tag3 = new ListItem();
        tag3.setItemType(ItemType.TAG);
        tag3.setTagName("猜你喜欢");
        listItemList.add(tag3);

        addBigImageData();

    }

    private void addAdData() {

        ListItem adItem = new ListItem();
        adItem.setItemType(ItemType.ADVERTISEMENT);

        List<Advertisement> advertisementList = new ArrayList<>();

        Advertisement advertisement1 = new Advertisement("http://chuantu.biz/t5/101/1496747023x2890174249.jpg", "此广告位常年招商espresso.kim");
        Advertisement advertisement2 = new Advertisement("http://chuantu.biz/t5/101/1496747149x2890171474.jpg", "此广告位常年招商espresso.kim");
        Advertisement advertisement3 = new Advertisement("http://chuantu.biz/t5/101/1496747173x2890171474.jpg", "此广告位常年招商espresso.kim");
        Advertisement advertisement4 = new Advertisement("http://chuantu.biz/t5/101/1496747196x2890171474.jpg", "此广告位常年招商espresso.kim");
        Advertisement advertisement5 = new Advertisement("http://chuantu.biz/t5/101/1496747237x2890171474.jpg", "此广告位常年招商espresso.kim");

        advertisementList.add(advertisement1);
        advertisementList.add(advertisement2);
        advertisementList.add(advertisement3);
        advertisementList.add(advertisement4);
        advertisementList.add(advertisement5);

        adItem.setAdvertisementList(advertisementList);
        listItemList.add(adItem);

    }

    private void addQualityData(int i) {

        ListItem qulityItem = new ListItem();
        qulityItem.setItemType(ItemType.QUALITY_GOODS);

        List<Quality> qualityList = new ArrayList<>();

        for (int j = 0; j < i; j++) {

            Quality quality = new Quality(null, "精品标题", "精品内容");
            qualityList.add(quality);

        }

        qulityItem.setQualityList(qualityList);
        listItemList.add(qulityItem);

    }

    private void addHorizontalData() {

        ListItem horizontalItem = new ListItem();
        horizontalItem.setItemType(ItemType.HORIZONTAL_VIEW);

        List<Horizontal> horizontalList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Horizontal horizontal = new Horizontal(null, "自荐商户标题");
            horizontalList.add(horizontal);
        }

        horizontalItem.setHorizontalList(horizontalList);
        listItemList.add(horizontalItem);

    }

    private void addBigImageData() {

        for (int i = 0; i < 6; i++) {
            ListItem listItem = new ListItem();
            BigImage bigImage = new BigImage();
            bigImage.setTitle("星时光数码影音体验馆");
            bigImage.setContent("星时光数码影音体验馆是一家高档的私人情侣影院，拥有高端视听设备，百寸以上高清影院画框幕， 采用先进的3D播放器材，THX认证5.1环绕声道（美国哈曼卡顿、JBL）高端音响。");
            listItem.setItemType(ItemType.BIG_IMG);
            listItem.setBigImage(bigImage);
            listItemList.add(listItem);
        }

    }

    private void loadBigImageData() {

        for (int i = 0; i < 6; i++) {
            ListItem listItem = new ListItem();
            BigImage bigImage = new BigImage();
            bigImage.setTitle("Sun.Day末羞花美甲工作室");
            bigImage.setContent("Sun.Day美甲工作室");
            listItem.setItemType(ItemType.BIG_IMG);
            listItem.setBigImage(bigImage);
            listItemList.add(listItem);
        }

    }

    @Override
    public void onRefresh() {

        if(!isRefresh){
            isRefresh = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    swipeContainer.setRefreshing(false);
                    isRefresh = false;
                }
            }, 2000);
        }

    }

    @Override
    public void onLoad() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                loadBigImageData();
                mHomeAdapter.notifyDataSetChanged();
                swipeContainer.setLoading(false);
            }
        }, 2000);
    }
}
