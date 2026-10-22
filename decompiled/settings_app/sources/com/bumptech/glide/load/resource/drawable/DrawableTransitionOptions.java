package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public DrawableTransitionOptions() {
    }

    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public static DrawableTransitionOptions withCrossFade(int r1) {
        return new DrawableTransitionOptions().crossFade(r1);
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory r1) {
        return new DrawableTransitionOptions().crossFade(r1);
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder r1) {
        return new DrawableTransitionOptions().crossFade(r1);
    }

    public static DrawableTransitionOptions with(TransitionFactory<Drawable> r1) {
        return new DrawableTransitionOptions().transition(r1);
    }

    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public DrawableTransitionOptions crossFade(int r2) {
        return crossFade(new DrawableCrossFadeFactory.Builder(r2));
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory r1) {
        return transition(r1);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.Builder r1) {
        return crossFade(r1.build());
    }

    @Override // com.bumptech.glide.TransitionOptions
    public boolean equals(Object r2) {
        if ((r2 instanceof DrawableTransitionOptions) == true) goto L5;
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
