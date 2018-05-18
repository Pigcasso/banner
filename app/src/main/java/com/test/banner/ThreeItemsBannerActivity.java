package com.test.banner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.banner.data.Item;
import com.test.banner.loader.ThreeItemsImageLoader;
import com.youth.banner.Banner;

/**
 * @author Zhu Liang
 */

public class ThreeItemsBannerActivity extends AppCompatActivity {

    private Banner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);

        banner = (Banner) findViewById(R.id.banner);
        banner
                .setImages(Item.DUMMY_ITEMS)
                .setImageLoader(new ThreeItemsImageLoader())
                .start();
    }
}
