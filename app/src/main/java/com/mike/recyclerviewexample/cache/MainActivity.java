package com.mike.recyclerviewexample.cache;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mike.recyclerviewexample.BaseActivity;
import com.mike.recyclerviewexample.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private int mColums = 3;
    private int mWidth = 300;
    @BindView(R.id.cache_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.tv_display)
    TextView tvDisplay;

    @Override
    public void afterSetContentView() {

        ViewGroup.LayoutParams lps = recyclerView.getLayoutParams();
        lps.width = mWidth * mColums;
        lps.height = mWidth * 3;
        GridLayoutManager llm = new GridLayoutManager(this, mColums);
        llm.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(llm);
        CacheAdapter cacheAdapter = new CacheAdapter(this);
        recyclerView.setAdapter(cacheAdapter);
    }

    public void updateTextDisplay(String s) {
        tvDisplay.setText(s);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_cache;
    }

    public int getColums() {
        return mColums;
    }

    public int getWidth() {
        return mWidth;
    }
}
