package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.BannerConfig;
import com.sinothk.banner.nice.demo.App;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;

public class CustomBannerActivity extends AppCompatActivity {

    Banner banner1, banner2, banner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_banner);
        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);
        banner3 = (Banner) findViewById(R.id.banner3);

        banner1.setAutoPlay(true)
                .setOffscreenPageLimit(App.images.size())
                .setPages(App.images, new CustomViewHolder())
                .start();

        banner2.setAutoPlay(true)
                .setOffscreenPageLimit(App.images.size())
                .setPages(App.images, new CustomViewHolder())
                .start();

        banner3.setBannerTitles(App.titles)
                .setAutoPlay(true)
                .setOffscreenPageLimit(App.images.size())
                .setPages(App.images, new CustomViewHolder())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .start();
    }
}
