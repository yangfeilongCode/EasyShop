package feicui.edu.easyshop;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import feicui.edu.easyshop.user.model.NativeCache;

/**
 * 易淘应用
 * Created by Administrator on 2016/11/24.
 */

public class EasyShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ImageLoader
        DisplayImageOptions imageOptions=new DisplayImageOptions.Builder()
                .cacheInMemory(true)// 开启内存缓存
                .cacheOnDisk(true) //开启硬盘缓存
                .resetViewBeforeLoading(true) //在ImageView加载前清除他之前的图片
                .build();

        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSize(4*1024*1024) //设置内存缓存大小（4M）
                .defaultDisplayImageOptions(imageOptions)
                .build();

        ImageLoader.getInstance().init(configuration);

        //初始化本地配置
        NativeCache.init(this);
    }
}
