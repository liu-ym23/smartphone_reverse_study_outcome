package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    protected /* bridge */ /* synthetic */ Drawable getDrawable(Bitmap r1) {
        return getDrawable2(r1);
    }

    public BitmapThumbnailImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public BitmapThumbnailImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }

    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    protected Drawable getDrawable2(Bitmap r2) {
        return new BitmapDrawable(((ImageView) this.view).getResources(), r2);
    }
}
