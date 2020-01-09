package com.sinothk.banner.nice.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.demo.demo.BannerAnimationActivity;
import com.sinothk.banner.nice.demo.demo.BannerLocalActivity;
import com.sinothk.banner.nice.demo.demo.BannerStyleActivity;
import com.sinothk.banner.nice.demo.demo.CustomBannerActivity;
import com.sinothk.banner.nice.demo.demo.CustomViewPagerActivity;
import com.sinothk.banner.nice.demo.demo.IndicatorPositionActivity;
import com.sinothk.banner.nice.demo.demo.SimpleFragmentActivity;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;
import com.sinothk.banner.nice.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener {

    static final int REFRESH_COMPLETE = 0X1112;
    SwipeRefreshLayout mSwipeLayout;
    ListView listView;
    Banner banner;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    String[] urls = getResources().getStringArray(R.array.url2);
                    List list = Arrays.asList(urls);
                    List arrayList = new ArrayList(list);
                    banner.update(arrayList);
                    mSwipeLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeLayout.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.list);
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        banner = (Banner) header.findViewById(R.id.banner);
        banner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, App.H / 4));
        listView.addHeaderView(banner);

        String[] data = getResources().getStringArray(R.array.demo_list);
        listView.setAdapter(new SampleAdapter(this, data));
        listView.setOnItemClickListener(this);

        String[] urls = getResources().getStringArray(R.array.url1);
        List arrList = new ArrayList(Arrays.asList(urls));

        //简单使用
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(arrList.size())
                .setPages(arrList, new CustomViewHolder())
                .setDelayTime(3000)
                .setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void onBannerClick(List datas, int position) {
                        Toast.makeText(MainActivity.this, "你点击了：" + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .start();
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                startActivity(new Intent(this, BannerAnimationActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, BannerStyleActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, IndicatorPositionActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, CustomBannerActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, BannerLocalActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, CustomViewPagerActivity.class));
                break;
            case 7:
                startActivity(new Intent(this, SimpleFragmentActivity.class));
                break;
        }
    }

}
