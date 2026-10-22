package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    private Animatable animatable;

    protected abstract void setResource(Z r1);

    public ImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public ImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void setDrawable(Drawable r1) {
        ((ImageView) this.view).setImageDrawable(r1);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r2) {
        super.onLoadStarted(r2);
        setResourceInternal(null);
        setDrawable(r2);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        setResourceInternal(null);
        setDrawable(r2);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r2) {
        super.onLoadCleared(r2);
        Animatable r0 = this.animatable;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        setResourceInternal(null);
        setDrawable(r2);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z r1, Transition<? super Z> r2) {
        if (r2 != null) goto L4;
    L7:
        setResourceInternal(r1);
        return;
    L4:
        if (r2.transition(r1, this) == false) goto L7;
        maybeUpdateAnimatable(r1);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable r0 = this.animatable;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable r0 = this.animatable;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    private void setResourceInternal(Z r1) {
        setResource(r1);
        maybeUpdateAnimatable(r1);
    }

    private void maybeUpdateAnimatable(Z r2) {
        if ((r2 instanceof Animatable) == false) goto L5;
        Animatable r3 = (Animatable) r2;
        this.animatable = r3;
        r3.start();
        return;
    L5:
        this.animatable = null;
    }
}
