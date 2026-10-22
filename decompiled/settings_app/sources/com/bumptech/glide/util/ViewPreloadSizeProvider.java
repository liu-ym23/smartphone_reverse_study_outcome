package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r1, Transition<? super Object> r2) {
        }

        SizeViewTarget(View r1) {
            super(r1);
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(View r2) {
        SizeViewTarget r0 = new SizeViewTarget(r2);
        this.viewTarget = r0;
        r0.getSize(this);
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T r1, int r2, int r3) {
        int[] r0 = this.size;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Arrays.copyOf(r0, r0.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int r3, int r4) {
        this.size = new int[]{r3, r4};
        this.viewTarget = null;
    }

    public void setView(View r2) {
        if (this.size == null) goto L5;
        return;
    L5:
        if (this.viewTarget != null) goto L10;
        SizeViewTarget r0 = new SizeViewTarget(r2);
        this.viewTarget = r0;
        r0.getSize(this);
        return;
    }
}
