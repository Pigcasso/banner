package com.test.banner.loader;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.test.banner.R;
import com.test.banner.data.Item;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.List;

/**
 * @author Zhu Liang
 */

public class ThreeItemsImageLoader implements ImageLoaderInterface<View, List<Item>> {

    @Override
    public void displayImage(Context context, List<Item> path, View imageView) {
        ImageView itemIv0 = (ImageView) imageView.findViewById(R.id.iv_item_0);
        Glide.with(context).load(Uri.parse(path.get(0).imgUrl)).into(itemIv0);

        ImageView itemIv1 = (ImageView) imageView.findViewById(R.id.iv_item_1);
        Glide.with(context).load(Uri.parse(path.get(1).imgUrl)).into(itemIv1);

        ImageView itemIv2 = (ImageView) imageView.findViewById(R.id.iv_item_2);
        Glide.with(context).load(Uri.parse(path.get(2).imgUrl)).into(itemIv2);

    }

    @Override
    public View createImageView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.view_pager_item_banner, null);
    }
}
