package com.test.banner.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.banner.R;
import com.test.banner.data.Item;
import com.test.banner.loader.CustomItemViewImageLoader;
import com.youth.banner.Banner;

/**
 * @author Zhu Liang
 */

public class CustomItemViewActivity extends AppCompatActivity {

    private Banner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_item_view);

        banner = findViewById(R.id.banner);
        banner
                .setImages(Item.DUMMY_ITEMS)
                .setImageLoader(new CustomItemViewImageLoader())
                .start();
    }
}
