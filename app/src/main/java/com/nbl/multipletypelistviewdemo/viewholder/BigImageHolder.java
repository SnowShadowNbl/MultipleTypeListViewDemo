package com.nbl.multipletypelistviewdemo.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.model.BigImage;
import com.nbl.multipletypelistviewdemo.model.ListItem;
import com.nbl.multipletypelistviewdemo.utils.ToastUtil;


/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class BigImageHolder {

    private RelativeLayout rlItem;
    private ImageView ivImg;
    private TextView tvTitle;
    private TextView tvContent;

    public BigImageHolder(View convertView){
        if(convertView != null){
            rlItem = (RelativeLayout)convertView.findViewById(R.id.rl_img_item);
            ivImg = (ImageView)convertView.findViewById(R.id.iv_img);
            tvTitle = (TextView)convertView.findViewById(R.id.tv_img_title);
            tvContent = (TextView)convertView.findViewById(R.id.tv_img_content);

            rlItem.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ToastUtil.show("猜你喜欢");
                }
            });
        }
    }

    public void refreshUI(ListItem listItem){

        BigImage bigImage = listItem.getBigImage();
        tvTitle.setText(bigImage.getTitle());
        tvContent.setText(bigImage.getContent());

    }
}
