/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import se.rebtel.countriesinfo.data.source.injection.DaggerDiRepositoryComponent;
import se.rebtel.countriesinfo.data.source.injection.DiRepositoryComponent;
import se.rebtel.countriesinfo.data.source.injection.DiRepositoryModule;
import se.rebtel.countriesinfo.data.source.remote.net.injection.DiRetrofitCountriesModule;

/**
 * Global application that:
 *  creates Dagger Repository component
 *  init Image Library (UIL) options
 */
public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getSimpleName();

    protected static DisplayImageOptions sDisplayImageLoaderOptions;
    private DiRepositoryComponent mDiRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mDiRepositoryComponent = DaggerDiRepositoryComponent.builder()
                .diAppContextModule(new DiAppContextModule(this))
                .diRetrofitCountriesModule(new DiRetrofitCountriesModule())
                .diRepositoryModule(new DiRepositoryModule())
                .build();
    }

    public DiRepositoryComponent getDiRepositoryComponent() {
        return mDiRepositoryComponent;
    }

    /**
     * Returns DisplayImageOptions of UIL image library.
     *
     * @param context
     * @return
     */
    public static DisplayImageOptions getDisplayImageLoaderOptions(Context context) {
        if (sDisplayImageLoaderOptions == null) {
            initImageLoader(context.getApplicationContext());
        }

        return sDisplayImageLoaderOptions;
    }

    private static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.MAX_PRIORITY);
        config.threadPoolSize(10);
        config.denyCacheImageMultipleSizesInMemory();
        config.memoryCacheSizePercentage(20); // % of available app memory..
        config.tasksProcessingOrder(QueueProcessingType.FIFO);

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());

        sDisplayImageLoaderOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }
}