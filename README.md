# Android图片轮播控件

这个轮播控件库是从 https://github.com/youth5201314/banner fork 而来。在这个库的基础上做了一些修改，使得这个 banner
更加灵活。虽然说对原始库的 Java代码 并没有修改太多，但是原始库的构建工具版本并没有及时更新，我还对 module 名称进行了
修改。于是决定我来自行维护这个项目，不打算将代码提 PR 到原始项目。这个 README 只涉及我修改的内容，如果需要了解原始项目
支持的功能，请移步 [README-original](./README-original.md)。

## 下载

Gradle

添加 JitPack 仓库到项目根目录的 build.gradle：

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

添加依赖

```groovy
dependencies {
    implementation 'com.github.Pigcasso:banner:1.0.3'
}
```

## 更新日志

## v1.0.3

重构 `ImageLoaderInterface`，让轮播 ItemView 的布局更加灵活

## 使用

**注意：**这里只介绍 `v1.0.3` 的新特性的使用，如果你的项目中的图片加载器继承自 `ImageLoader`，则不会对你的项目产生任何影响。

这里以示例代码中的 `CustomItemViewActivity` 为例。

第一步：

```Java
public class CustomItemViewImageLoader implements ImageLoaderInterface<View, List<Item>> {

    @Override
    public void displayImage(Context context, List<Item> path, View imageView) {
        // 实例化点击事件
        ImageClickListener listener = new ImageClickListener(context, path);

        // 初始化 ImageView
        ImageView itemIv0 = imageView.findViewById(R.id.iv_item_0);
        // 注册监听事件
        itemIv0.setOnClickListener(listener);
        // 图片加载器加赞图片
        Glide.with(context).load(Uri.parse(path.get(0).imgUrl)).into(itemIv0);
        //...
    }

    /**
     * 初始化 ItemView 的布局
     */
    @Override
    public View createImageView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.view_pager_item_banner, null);
    }

    /**
     * 定义点击事件类
     */
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
```

第二步：

```Java
public class CustomItemViewActivity extends AppCompatActivity {

    private Banner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_item_view);

        banner = findViewById(R.id.banner);
        banner
                .setImages(Item.DUMMY_ITEMS) // 初始化轮播数据
                .setImageLoader(new CustomItemViewImageLoader()) // 设置图片加载器
                .start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
```

