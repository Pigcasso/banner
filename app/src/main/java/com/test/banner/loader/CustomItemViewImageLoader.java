package com.test.banner.loader;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.test.banner.R;
import com.test.banner.data.Item;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.List;

/**
 * @author Zhu Liang
 */

public class CustomItemViewImageLoader implements ImageLoaderInterface<View, List<Item>> {

    @Override
    public void displayImage(Context context, List<Item> path, View imageView) {
        ImageClickListener listener = new ImageClickListener(context, path);

        ImageView itemIv0 = imageView.findViewById(R.id.iv_item_0);
        itemIv0.setOnClickListener(listener);
        Glide.with(context).load(Uri.parse(path.get(0).imgUrl)).into(itemIv0);

        ImageView itemIv1 = imageView.findViewById(R.id.iv_item_1);
        itemIv1.setOnClickListener(listener);
        Glide.with(context).load(Uri.parse(path.get(1).imgUrl)).into(itemIv1);

        ImageView itemIv2 = imageView.findViewById(R.id.iv_item_2);
        itemIv2.setOnClickListener(listener);
        Glide.with(context).load(Uri.parse(path.get(2).imgUrl)).into(itemIv2);

    }

    @Override
    public View createImageView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.view_pager_item_banner, null);
    }

    private static class ImageClickListener implements View.OnClickListener {
        private Context context;
        private List<Item> items;

        public ImageClickListener(Context context, List<Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public void onClick(View v) {
            Item item;
            switch (v.getId()) {
                case R.id.iv_item_0:
                    item = items.get(0);
                    break;
                case R.id.iv_item_1:
                    item = items.get(1);
                    break;
                case R.id.iv_item_2:
                    item = items.get(2);
                    break;
                default:
                    throw new NullPointerException();
            }
            String imgUrl = item.imgUrl;
            Toast.makeText(context, imgUrl, Toast.LENGTH_SHORT).show();
        }
    }
}
