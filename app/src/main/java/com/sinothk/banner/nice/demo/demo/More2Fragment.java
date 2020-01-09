package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.BannerConfig;
import com.sinothk.banner.nice.Transformer;
import com.sinothk.banner.nice.demo.CustomData;
import com.sinothk.banner.nice.demo.LazyFragment;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder2;

import java.util.ArrayList;
import java.util.List;

public class More2Fragment extends Fragment {

    private Banner mBanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_custom_banner2, null);
        mBanner = view.findViewById(R.id.banner);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List mList = new ArrayList<>();
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-fc35f7c7fc8c37d2.jpg", "CustomLayout", false));
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-51b0484e0c906c91.jpg", "Transformer", false));
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-1c553827bdae32d2.jpg", "Viewpager", false));
        mBanner.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder2())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setBannerAnimation(Transformer.Scale)
                .start();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mBanner != null && !mBanner.isStart() && mBanner.isPrepare()) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mBanner != null && mBanner.isStart() && mBanner.isPrepare()) {
            mBanner.stopAutoPlay();
        }
    }
}
