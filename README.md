# NiceBannerView


## 注意事项

    setCurrentPage 方法不建议调用,因为使用的是成员变量保存,除非再次初始化,否则每次初始化都会先显示设定位置的图片
    有问题先参考 demo

另只要是 banner 中布局中可以定义的,都可以重写,包括但不限于指示器,图片,文字等.各个模式相应的代码 demo 中已经有了,可以作为参考,如果有问题可以提 issue
属性和方法介绍
## xml 文件可配置的属性
    属性 	值 	描述
    delay_time 	integer 	轮播下一张图片的延迟时间
    scroll_time 	integer 	滚动到下一张图片的时间
    is_auto_play 	boolean 	是否自动轮播
    is_loop 	boolean 	是否循环
    title_background 	color、reference 	title 的背景
    title_textcolor 	color 	title 的字体颜色
    title_textsize 	dimension 	title 的字体大小
    title_height 	dimension 	title 的高度
    indicator_width 	dimension 	指示器的宽度
    indicator_height 	dimension 	指示器的高度
    indicator_margin 	dimension 	指示器到底部的距离
    indicator_padding 	dimension 	指示器之间的间距
    indicator_drawable_selected 	reference 	选中的指示器图片
    indicator_drawable_unselected 	reference 	未选中的指示器图片
    banner_default_image 	reference 	默认的图片
    page_left_margin 	dimension 	左边缩进的距离
    page_right_margin 	dimension 	右边缩进的距离
    arc_height 	dimension 	底部弧形的高度
    arc_start_color 	reference 	底部弧形的起始颜色
    arc_end_color 	reference 	底部弧形的结束颜色
    arc_direction 	enum 	底部弧形的方向
    
## java 文件可调用的方法

    setDelayTime                设置延迟时间
    setAutoPlay                 设置是否自动轮播
    setLoop                     设置是否循环
    setIndicatorGravity         设置指示器位置
    setBannerAnimation          设置滚动动画
    setBannerTitles             设置 title 数据
    setBannerStyle              设置样式
    setViewPagerIsScroll        设置是否可以滚动
    setPages                    设置数据源
    setCurrentPage              设置当前页
    update                      刷新
    updateBannerStyle           刷新样式
    start                       开始使用
    isPrepare                   是否加载完成
    isStart                     是否轮播中
    setIndicatorRes             设置指示器资源
    startAutoPlay               开始自动轮播
    stopAutoPlay                停止轮播
    setOnBannerClickListener    监听点击事件
    setOnPageChangeListener     监听页面变化事件

## 混淆
    -keep class com.ms.banner.** {*;}


NiceBannerView Powered By https://github.com/wenchaosong/Banner
