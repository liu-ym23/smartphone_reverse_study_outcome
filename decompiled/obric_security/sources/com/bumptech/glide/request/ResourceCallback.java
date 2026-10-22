package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes.dex */
public interface ResourceCallback {
    Object getLock();

    void onLoadFailed(GlideException r1);

    void onResourceReady(Resource<?> r1, DataSource r2, boolean r3);
}
