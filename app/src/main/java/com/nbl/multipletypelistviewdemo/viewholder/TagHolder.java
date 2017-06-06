package com.nbl.multipletypelistviewdemo.viewholder;

import android.view.View;
import android.widget.TextView;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.model.ListItem;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class TagHolder {

    public TextView tvType;

    public TagHolder(View convertView){
        if(convertView != null){
            tvType = (TextView)convertView.findViewById(R.id.tv_tag_txt);
        }
    }

    public void refreshUI(ListItem listItem){
        tvType.setText(listItem.getTagName());
    }
}
