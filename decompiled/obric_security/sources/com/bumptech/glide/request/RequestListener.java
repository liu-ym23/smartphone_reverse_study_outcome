package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(GlideException r1, Object r2, Target<R> r3, boolean r4);

    boolean onResourceReady(R r1, Object r2, Target<R> r3, DataSource r4, boolean r5);
}
