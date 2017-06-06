package com.nbl.multipletypelistviewdemo.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.utils.ToastUtil;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class DoubleHolder {

    private RelativeLayout rlOne;
    private RelativeLayout rlTwo;

    public DoubleHolder(View convertView){

        if(convertView != null){
            rlOne = (RelativeLayout)convertView.findViewById(R.id.rl_home_one);
            rlTwo = (RelativeLayout)convertView.findViewById(R.id.rl_home_two);
        }

        rlOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("module1");
            }
        });

        rlTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("module2");
            }
        });

    }

}
