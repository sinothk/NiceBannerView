package com.sinothk.banner.nice.demo.demo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.sinothk.banner.nice.Banner;
import com.sinothk.banner.nice.BannerConfig;
import com.sinothk.banner.nice.Transformer;
import com.sinothk.banner.nice.demo.CustomData;
import com.sinothk.banner.nice.demo.R;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder2;
import com.sinothk.banner.nice.demo.ui.CustomViewHolder3;

import java.util.ArrayList;
import java.util.List;

public class CustomViewPagerActivity extends AppCompatActivity {

    Banner banner1;
    Banner banner2;
    Banner banner3;
    Banner banner4;
    LinearLayout indicator;

    private List<ImageView> indicatorImages = new ArrayList<>();
    private int mIndicatorSelectedResId = R.mipmap.indicator;
    private int mIndicatorUnselectedResId = R.mipmap.indicator2;
    private int lastPosition = 0;
    private List<CustomData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_pager);

        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);
        banner3 = (Banner) findViewById(R.id.banner3);
        banner4 = (Banner) findViewById(R.id.banner4);
        indicator = (LinearLayout) findViewById(R.id.indicator);
        indicatorImages.clear();

        mList = new ArrayList<>();
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-fc35f7c7fc8c37d2.jpg", "", false));
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-3d3ebe3484d91c0e.jpg", "", false));
        mList.add(new CustomData("https://upload-images.jianshu.io/upload_images/9913211-9b33a47c7032f638.jpg", "", false));

        ArrayList<CustomData> arrList = new ArrayList<>();
        CustomData data1 = new CustomData("https://upload-images.jianshu.io/upload_images/9913211-8f28da27dd550fe5.jpg", "", false);
        CustomData data2 = new CustomData("", "", true);
        CustomData data3 = new CustomData("https://upload-images.jianshu.io/upload_images/9913211-a0575ae640238bfe.jpg", "", false);
        arrList.add(data1);
        arrList.add(data2);
        arrList.add(data3);

        initIndicator();

        banner1.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder2())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setBannerAnimation(Transformer.Scale)
                .start();

        banner1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicatorImages.get((lastPosition + mList.size()) % mList.size()).setImageResource(mIndicatorUnselectedResId);
                indicatorImages.get((position + mList.size()) % mList.size()).setImageResource(mIndicatorSelectedResId);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        banner2.setAutoPlay(true)
                .setOffscreenPageLimit(arrList.size())
                .setPages(arrList, new CustomViewHolder3())
                .start();

        banner3.setAutoPlay(true)
                .setOffscreenPageLimit(arrList.size())
                .setPages(arrList, new CustomViewHolder3())
                .start();

        banner4.setAutoPlay(true)
                .setOffscreenPageLimit(arrList.size())
                .setBannerAnimation(Transformer.ScaleRight)
                .setPages(arrList, new CustomViewHolder3())
                .start();
    }

    private void initIndicator() {
        for (int i = 0; i < mList.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams custom_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            custom_params.leftMargin = 2;
            custom_params.rightMargin = 2;
            if (i == 0) {
                imageView.setImageResource(mIndicatorSelectedResId);
            } else {
                imageView.setImageResource(mIndicatorUnselectedResId);
            }
            indicatorImages.add(imageView);
            indicator.addView(imageView, custom_params);
        }
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner1.startAutoPlay();
        banner2.startAutoPlay();
        banner3.startAutoPlay();
        banner4.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner1.stopAutoPlay();
        banner2.stopAutoPlay();
        banner3.stopAutoPlay();
        banner4.stopAutoPlay();
    }
}
