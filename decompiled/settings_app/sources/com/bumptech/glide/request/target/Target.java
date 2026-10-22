package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes3.dex */
public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback r1);

    void onLoadCleared(Drawable r1);

    void onLoadFailed(Drawable r1);

    void onLoadStarted(Drawable r1);

    void onResourceReady(R r1, Transition<? super R> r2);

    void removeCallback(SizeReadyCallback r1);

    void setRequest(Request r1);
}
