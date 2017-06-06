package com.nbl.multipletypelistviewdemo.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.adapter.HorizontalAdapter;
import com.nbl.multipletypelistviewdemo.model.Horizontal;
import com.nbl.multipletypelistviewdemo.model.ListItem;
import com.nbl.multipletypelistviewdemo.utils.ToastUtil;

import java.util.List;


/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class HorizontalHolder {
    private Context context;
    private RecyclerView mRecyclerView;
    private HorizontalAdapter mAdapter;

    public HorizontalHolder(Context context, View convertView){
        this.context = context;
        if(convertView != null){
            mRecyclerView = (RecyclerView)convertView.findViewById(R.id.recycler_view);
        }
    }

    public void initView(ListItem listItem){
        List<Horizontal> horizontalList = listItem.getHorizontalList();
        mAdapter = new HorizontalAdapter(context,horizontalList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new HorizontalAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                ToastUtil.show("position: "+position);
            }
        });
    }
}
