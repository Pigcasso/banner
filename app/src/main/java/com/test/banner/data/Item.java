package com.test.banner.data;

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

    public static final List<List<Item>> DUMMY_ITEMS;

    static {
        DUMMY_ITEMS = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            List<Item> items = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                items.add(new Item("http://img04.muzhiwan.com/2015/06/16/upload_557fd293326f5.jpg"));
            }
            DUMMY_ITEMS.add(items);
        }
    }
}
