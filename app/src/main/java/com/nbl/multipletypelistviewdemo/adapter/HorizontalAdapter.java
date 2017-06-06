package com.nbl.multipletypelistviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbl.multipletypelistviewdemo.R;
import com.nbl.multipletypelistviewdemo.model.Horizontal;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.TalentShowViewHolder> {
    private List<Horizontal> horizontalList;
    private Context context;

    public HorizontalAdapter(Context context, List<Horizontal> horizontalList) {
        this.context = context;
        this.horizontalList = horizontalList;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public TalentShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TalentShowViewHolder holder = new TalentShowViewHolder(LayoutInflater.from(context).inflate(R.layout.view_horizontal_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final TalentShowViewHolder holder, final int position) {
        Horizontal horizontal = horizontalList.get(position);

        holder.tvTitle.setText(horizontal.getTitle());

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    class TalentShowViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImage;
        TextView tvTitle;

        public TalentShowViewHolder(View view) {
            super(view);
            circleImage = (CircleImageView)view.findViewById(R.id.circle_iv);
            tvTitle=(TextView)view.findViewById(R.id.tv_title);
        }

    }
}
