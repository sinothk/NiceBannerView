package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.Transformer;
import com.sinothk.banner.nice.demo.App;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.SampleAdapter;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BannerAnimationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Banner banner;
    List<Class<? extends ViewPager.PageTransformer>> transformers = new ArrayList<>();

    public void initData() {
        transformers.add(Transformer.Default);
        transformers.add(Transformer.Accordion);
        transformers.add(Transformer.BackgroundToForeground);
        transformers.add(Transformer.ForegroundToBackground);
        transformers.add(Transformer.CubeIn);//兼容问题，慎用
        transformers.add(Transformer.CubeOut);
        transformers.add(Transformer.DepthPage);
        transformers.add(Transformer.FlipHorizontal);
        transformers.add(Transformer.FlipVertical);
        transformers.add(Transformer.RotateDown);
        transformers.add(Transformer.RotateUp);
        transformers.add(Transformer.ScaleInOut);
        transformers.add(Transformer.Scale);
        transformers.add(Transformer.ScaleRight);
        transformers.add(Transformer.Stack);
        transformers.add(Transformer.Tablet);
        transformers.add(Transformer.ZoomIn);
        transformers.add(Transformer.ZoomOut);
        transformers.add(Transformer.ZoomOutSlide);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_animation);
        initData();
        banner = (Banner) findViewById(R.id.banner);
        ListView listView = (ListView) findViewById(R.id.list);
        String[] data = getResources().getStringArray(R.array.anim);
        listView.setAdapter(new SampleAdapter(this, data));
        listView.setOnItemClickListener(this);

        //简单使用
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(App.images.size())
                .setPages(App.images, new CustomViewHolder())
                .setDelayTime(3000)
                .start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        banner.setBannerAnimation(transformers.get(position));
    }
}
