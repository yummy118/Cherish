package com.example.myweichat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> implements ItemTouchHelperListener{
    private Context mContext;
    private View view;
    private List<String> mList = new ArrayList<>();
    private int[] mId;


    public MyAdapter(Context context) {
        mContext = context;
    }

    public void setClickDataList(List<String> list,int[] Id) {

        mList = list;
       mId=Id;

        notifyDataSetChanged();
    }
    //创建ContactViewHolder
    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tvNum, tvContent;
        ImageView Img;
        public ContactViewHolder(View itemView) {
            super(itemView);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvContent = itemView.findViewById(R.id.tv_content);
            Img=itemView.findViewById(R.id.img);

        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_2, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onItemDismiss(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        mList.remove(position);
        notifyItemRemoved(position);

        // 解决 RecyclerView 删除 Item 导致位置错乱的问题
        if (position != mList.size()) {
            notifyItemRangeChanged(position, mList.size() - position);
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final String content = mList.get(position);
        final int Img=mId[position];
        holder.tvNum.setText("联系人编号： "+position  );
        holder.tvContent.setText(content);
        holder.Img.setImageResource(Img);

        //设置点击每一项事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击的是：" + content, Toast.LENGTH_SHORT).show();
            }
        });

    }


}