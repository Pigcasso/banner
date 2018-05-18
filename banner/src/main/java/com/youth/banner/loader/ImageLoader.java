package com.youth.banner.loader;

import android.content.Context;
import android.widget.ImageView;


public abstract class ImageLoader implements ImageLoaderInterface<ImageView, Object> {

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }

}