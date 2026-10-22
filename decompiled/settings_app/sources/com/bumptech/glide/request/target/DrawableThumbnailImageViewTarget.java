package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget<Drawable> {
    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    protected Drawable getDrawable2(Drawable r1) {
        return r1;
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    protected /* bridge */ /* synthetic */ Drawable getDrawable(Drawable r1) {
        return getDrawable2(r1);
    }

    public DrawableThumbnailImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public DrawableThumbnailImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }
}
