package nl.pcmeesters.pcmeestersnl;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by Belal on 10/8/2015.
 */

public class ImageLoader {

    private static ImageLoader imageLoader;
    private static Context context;
    private RequestQueue requestQueue;
    private com.android.volley.toolbox.ImageLoader imageLoader;


    private ImageLoader(Context context) {
        this.context = context;
        this.requestQueue = getRequestQueue();

        imageLoader = new com.android.volley.toolbox.ImageLoader(requestQueue,
                new com.android.volley.toolbox.ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized ImageLoader getInstance(Context context) {
        if (imageLoader == null) {
            imageLoader = new ImageLoader(context);
        }
        return imageLoader;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            Cache cache = new DiskBasedCache(context.getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cache, network);
            requestQueue.start();
        }
        return requestQueue;
    }

    public com.android.volley.toolbox.ImageLoader getImageLoader() {
        return imageLoader;
    }

}