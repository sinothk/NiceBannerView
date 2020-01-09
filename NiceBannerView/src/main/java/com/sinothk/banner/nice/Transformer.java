package com.sinothk.banner.nice;

import com.sinothk.banner.nice.transformer.AccordionTransformer;
import com.sinothk.banner.nice.transformer.BackgroundToForegroundTransformer;
import com.sinothk.banner.nice.transformer.CubeInTransformer;
import com.sinothk.banner.nice.transformer.CubeOutTransformer;
import com.sinothk.banner.nice.transformer.DefaultTransformer;
import com.sinothk.banner.nice.transformer.DepthPageTransformer;
import com.sinothk.banner.nice.transformer.FlipHorizontalTransformer;
import com.sinothk.banner.nice.transformer.FlipVerticalTransformer;
import com.sinothk.banner.nice.transformer.ForegroundToBackgroundTransformer;
import com.sinothk.banner.nice.transformer.RotateDownTransformer;
import com.sinothk.banner.nice.transformer.RotateUpTransformer;
import com.sinothk.banner.nice.transformer.ScaleInOutTransformer;
import com.sinothk.banner.nice.transformer.ScaleRightTransformer;
import com.sinothk.banner.nice.transformer.ScaleTransformer;
import com.sinothk.banner.nice.transformer.StackTransformer;
import com.sinothk.banner.nice.transformer.TabletTransformer;
import com.sinothk.banner.nice.transformer.ZoomInTransformer;
import com.sinothk.banner.nice.transformer.ZoomOutSlideTransformer;
import com.sinothk.banner.nice.transformer.ZoomOutTranformer;

import androidx.viewpager.widget.ViewPager.PageTransformer;

public class Transformer {

    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Scale = ScaleTransformer.class;
    public static Class<? extends PageTransformer> ScaleRight = ScaleRightTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;

}
