package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.demo.CustomData;
import com.sinothk.banner.nice.demo.LazyFragment;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder2;

import java.util.ArrayList;
import java.util.List;

public class MoreFragment extends LazyFragment {

    private Banner mBanner;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, null);
        init(view);
        return view;
    }

    private void init(View view) {
        mBanner = view.findViewById(R.id.banner);
    }

    @Override
    protected void initData() {
        List mList = new ArrayList<>();
        mList.add(new CustomData("", "CustomLayout", false));
        mList.add(new CustomData("", "Transformer", false));
        mList.add(new CustomData("", "Viewpager", false));
        mBanner.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder2())
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
