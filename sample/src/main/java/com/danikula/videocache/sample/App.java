package com.danikula.videocache.sample;

import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyServer;

/**
 * @author Alexey Danilov (danikula@gmail.com).
 */
public class App extends Application {

    private HttpProxyServer proxy;

    public static HttpProxyServer getProxy(Context context) {
        App app = (App) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyServer newProxy() {
        return new HttpProxyServer.Builder(this)
                .cacheDirectory(Utils.getVideoCacheDir(this))
                .build();
    }
}
