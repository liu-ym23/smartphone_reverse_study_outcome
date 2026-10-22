package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public BitmapTransitionOptions() {
    }

    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withCrossFade(int r1) {
        return new BitmapTransitionOptions().crossFade(r1);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory r1) {
        return new BitmapTransitionOptions().crossFade(r1);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder r1) {
        return new BitmapTransitionOptions().crossFade(r1);
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> r1) {
        return new BitmapTransitionOptions().transitionUsing(r1);
    }

    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> r1) {
        return new BitmapTransitionOptions().transition(r1);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public BitmapTransitionOptions crossFade(int r2) {
        return crossFade(new DrawableCrossFadeFactory.Builder(r2));
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory r1) {
        return transitionUsing(r1);
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> r2) {
        return transition(new BitmapTransitionFactory(r2));
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder r1) {
        return transitionUsing(r1.build());
    }

    @Override // com.bumptech.glide.TransitionOptions
    public boolean equals(Object r2) {
        if ((r2 instanceof BitmapTransitionOptions) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.equals(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }
}
