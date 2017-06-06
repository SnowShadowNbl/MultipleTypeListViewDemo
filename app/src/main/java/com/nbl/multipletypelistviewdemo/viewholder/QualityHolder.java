package com.nbl.multipletypelistviewdemo.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.model.ListItem;
import com.nbl.multipletypelistviewdemo.model.Quality;
import com.nbl.multipletypelistviewdemo.utils.ToastUtil;

import java.util.List;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class QualityHolder {

    private RelativeLayout rlMenu1;
    private RelativeLayout rlMenu2;

    private ImageView ivImg1,ivImg2;
    private TextView tvTitle1,tvTitle2;
    private TextView tvContent1,tvContent2;

    public QualityHolder(View convertView){
        if(convertView != null){

            rlMenu1 = (RelativeLayout)convertView.findViewById(R.id.i_menu_one);
            rlMenu2=(RelativeLayout)convertView.findViewById(R.id.i_menu_two);

            ivImg1 = (ImageView) rlMenu1.findViewById(R.id.iv_menu_img);
            tvTitle1 = (TextView) rlMenu1.findViewById(R.id.tv_menu_title);
            tvContent1 = (TextView) rlMenu1.findViewById(R.id.tv_menu_content);

            ivImg2 = (ImageView) rlMenu2.findViewById(R.id.iv_menu_img);
            tvTitle2 = (TextView) rlMenu2.findViewById(R.id.tv_menu_title);
            tvContent2 = (TextView) rlMenu2.findViewById(R.id.tv_menu_content);

            rlMenu1.setOnClickListener(onMenuClickListener);
            rlMenu2.setOnClickListener(onMenuClickListener);

        }
    }

    View.OnClickListener onMenuClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(view.getId()== R.id.i_menu_one){
                ToastUtil.show("i am menu one");
            }else if(view.getId()==R.id.i_menu_two){
                ToastUtil.show("i am menu two");
            }
        }
    };

    public void refreshUI(ListItem listItem){

        List<Quality> qualityList = listItem.getQualityList();

        boolean isEven = false;

        if(qualityList.size() % 2 != 0){
            isEven = false;
        }else{
            isEven = true;
        }

        tvTitle1.setText(qualityList.get(0).getTitle());
        tvContent1.setText(qualityList.get(0).getContent());

        if(isEven == false){

            rlMenu2.setVisibility(View.INVISIBLE);
            return;

        }else{

            tvTitle2.setText(qualityList.get(1).getTitle());
            tvContent2.setText(qualityList.get(1).getContent());

        }

    }
}
