package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public void onRequestStarted(Object r1) {
    }

    public abstract boolean onResourceReady(ResourceT r1, Object r2, Target<ResourceT> r3, DataSource r4, boolean r5, boolean r6);

    public ExperimentalRequestListener() {
    }
}
