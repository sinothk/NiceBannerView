package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BannerLocalActivity extends AppCompatActivity {

    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_local);
        initView();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b3);

        banner.setAutoPlay(true)
                .setOffscreenPageLimit(list.size())
                .setPages(list, new CustomViewHolder())
                .start();
    }
}
