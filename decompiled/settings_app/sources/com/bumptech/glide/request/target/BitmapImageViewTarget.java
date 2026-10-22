package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected /* bridge */ /* synthetic */ void setResource(Bitmap r1) {
        setResource2(r1);
    }

    public BitmapImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public BitmapImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    protected void setResource2(Bitmap r1) {
        ((ImageView) this.view).setImageBitmap(r1);
    }
}
