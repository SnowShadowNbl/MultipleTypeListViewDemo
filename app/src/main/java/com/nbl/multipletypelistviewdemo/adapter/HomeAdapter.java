package com.nbl.multipletypelistviewdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.model.Horizontal;
import com.nbl.multipletypelistviewdemo.model.ListItem;
import com.nbl.multipletypelistviewdemo.viewholder.AdHolder;
import com.nbl.multipletypelistviewdemo.viewholder.BigImageHolder;
import com.nbl.multipletypelistviewdemo.viewholder.DoubleHolder;
import com.nbl.multipletypelistviewdemo.viewholder.HorizontalHolder;
import com.nbl.multipletypelistviewdemo.viewholder.QualityHolder;
import com.nbl.multipletypelistviewdemo.viewholder.TagHolder;

import java.util.List;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class HomeAdapter extends BaseAdapter {

    private Context context;

    private List<ListItem> listItemList;

    private final static int ADVERTISEMENT = 0;
    private final static int DOUBLE_AD = 1;
    private final static int TAG = 2;
    private final static int HORIZONTAL_VIEW = 3;
    private final static int QUALITY_GOODS = 4;
    private final static int BIG_IMG = 5;

    public HomeAdapter(Context context, List<ListItem> listItemList) {
        this.context = context;
        this.listItemList = listItemList;
    }

    @Override
    public int getCount() {
        return listItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listItemList == null ? null : listItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListItem listItem = listItemList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        AdHolder adHolder;
        DoubleHolder doubleHolder;
        TagHolder tagHolder;
        QualityHolder qualityHolder;
        HorizontalHolder horizontalHolder;
        BigImageHolder bigImageHolder;

        int type = listItem.getItemType().getValue();

        switch (type){
            case ADVERTISEMENT:

                if(convertView == null){
                    convertView = inflater.inflate(R.layout.view_ad, null);
                    adHolder = new AdHolder(context, convertView);
                    convertView.setTag(adHolder);
                }else{
                    adHolder = (AdHolder) convertView.getTag();
                }

                adHolder.setViewPager(listItem);

                break;
            case DOUBLE_AD:

                if(convertView == null){
                    convertView = inflater.inflate(R.layout.view_double, null);
                    doubleHolder = new DoubleHolder(convertView);
                    convertView.setTag(doubleHolder);
                }else{
                    doubleHolder = (DoubleHolder) convertView.getTag();
                }

                break;
            case TAG:

                if(convertView == null){
                    convertView = inflater.inflate(R.layout.view_tag, null);
                    tagHolder = new TagHolder(convertView);
                    convertView.setTag(tagHolder);
                }else{
                    tagHolder = (TagHolder) convertView.getTag();
                }

                tagHolder.refreshUI(listItem);

                break;
            case QUALITY_GOODS:

                if(convertView == null){
                    convertView = inflater.inflate(R.layout.view_quality, null);
                    qualityHolder = new QualityHolder(convertView);
                    convertView.setTag(qualityHolder);
                }else{
                    qualityHolder = (QualityHolder) convertView.getTag();
                }

                qualityHolder.refreshUI(listItem);

                break;
            case HORIZONTAL_VIEW:

                if(convertView == null){
                    convertView = inflater.inflate(R.layout.view_horizontal, null);
                    horizontalHolder = new HorizontalHolder(context, convertView);
                    convertView.setTag(horizontalHolder);
                }else{
                    horizontalHolder = (HorizontalHolder) convertView.getTag();
                }

                horizontalHolder.initView(listItem);

                break;
            case BIG_IMG:

                if(convertView == null){
                    convertView=inflater.inflate(R.layout.view_big_image,null);
                    bigImageHolder = new BigImageHolder(convertView);
                    convertView.setTag(bigImageHolder);
                }else{
                    bigImageHolder = (BigImageHolder)convertView.getTag();
                }

                bigImageHolder.refreshUI(listItem);

                break;
            default:
                break;
        }


        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if(listItemList != null && position < listItemList.size()){
            return listItemList.get(position).getItemType().getValue();
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

}
