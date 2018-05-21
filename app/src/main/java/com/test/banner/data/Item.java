package com.test.banner.data;

import android.content.Context;

import com.test.banner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhu Liang
 */

public class Item {

    public final String imgUrl;

    public Item(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static final List<List<Item>> DUMMY_ITEMS = new ArrayList<>();

    public static void initItems(Context context) {
        final String[] imgUrls = context.getResources().getStringArray(R.array.test_num_url);
        for (int i = 0; i < 3; i++) {
            List<Item> items = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                items.add(new Item(imgUrls[i * 3 + j]));
            }
            DUMMY_ITEMS.add(items);
        }
    }
}
