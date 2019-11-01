package com.mike.recyclerviewexample.cache;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mike.recyclerviewexample.R;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CacheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "CacheAdapter";
    private List<Integer> mColors = new ArrayList<>();
    private MainActivity mActivity;

    public CacheAdapter(MainActivity activity) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            mColors.add(Color.rgb(r, g, b));
        }
        mActivity = activity;
    }

    int sum = 0;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        sum++;
        Log.d(TAG, "sum -->" + sum);
        mActivity.updateTextDisplay("view holder 数量:" + sum);
        return new CacheViewHolder(inflater.inflate(R.layout.cache_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "bind");
        CacheViewHolder cacheViewHolder = (CacheViewHolder) holder;
        ViewGroup.LayoutParams lps = cacheViewHolder.itemView.getLayoutParams();
        lps.width = mActivity.getWidth();
        lps.height = mActivity.getWidth();
        cacheViewHolder.img.setBackgroundColor(mColors.get(position));
        cacheViewHolder.tv.setText(Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return mColors.size();
    }

    public static class CacheViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView tv;

        public CacheViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
