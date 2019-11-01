package com.mike.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn_cache)
    Button btn_cache;

    @Override
    public void afterSetContentView() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_cache)
    public void onClickCache() {
        Intent intent = new Intent(this, com.mike.recyclerviewexample.cache.MainActivity.class);
        startActivity(intent);
    }
}
