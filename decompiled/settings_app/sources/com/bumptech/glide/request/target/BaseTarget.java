package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {
    private Request request;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public BaseTarget() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request r1) {
        this.request = r1;
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }
}
