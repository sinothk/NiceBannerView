package com.sinothk.banner.nice.demo.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.demo.LazyFragment;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends LazyFragment {

    private Banner mBanner;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        init(view);
        return view;
    }

    private void init(View view) {
        mBanner = view.findViewById(R.id.banner);
        view.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BannerLocalActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        String[] urls = getResources().getStringArray(R.array.url2);
        List arrList = new ArrayList(Arrays.asList(urls));
        mBanner.setAutoPlay(true)
                .setOffscreenPageLimit(arrList.size())
                .setPages(arrList, new CustomViewHolder())
                .start();
    }

    @Override
    protected void onFragmentVisible() {
        if (mBanner != null && !mBanner.isStart() && mBanner.isPrepare()) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    protected void onFragmentUnVisible() {
        if (mBanner != null && mBanner.isStart() && mBanner.isPrepare()) {
            mBanner.stopAutoPlay();
        }
    }
}
