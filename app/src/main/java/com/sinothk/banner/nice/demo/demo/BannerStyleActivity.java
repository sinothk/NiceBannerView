package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.BannerConfig;
import com.sinothk.banner.nice.demo.App;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;

public class BannerStyleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Banner banner;
    Spinner spinnerStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_style);
        banner = (Banner) findViewById(R.id.banner);
        spinnerStyle = (Spinner) findViewById(R.id.spinnerStyle);
        spinnerStyle.setOnItemSelectedListener(this);

        //简单使用
        banner.setBannerTitles(App.titles)
                .setOffscreenPageLimit(App.images.size())
                .setPages(App.images, new CustomViewHolder())
                .setAutoPlay(true)
                .setDelayTime(3000)
                .start();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                banner.updateBannerStyle(BannerConfig.NOT_INDICATOR);
                break;
            case 1:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                break;
            case 2:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR);
                break;
            case 3:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                break;
            case 4:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                break;
            case 5:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                break;
            case 6:
                banner.setIndicatorRes(R.mipmap.indicator, R.drawable.gray_radius);
                banner.updateBannerStyle(BannerConfig.CUSTOM_INDICATOR);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
