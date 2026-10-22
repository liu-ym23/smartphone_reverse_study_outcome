package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    /* JADX INFO: renamed from: getBitmap, reason: avoid collision after fix types in other method */
    protected Bitmap getBitmap2(Bitmap r1) {
        return r1;
    }

    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    protected /* bridge */ /* synthetic */ Bitmap getBitmap(Bitmap r1) {
        return getBitmap2(r1);
    }

    public BitmapTransitionFactory(TransitionFactory<Drawable> r1) {
        super(r1);
    }
}
