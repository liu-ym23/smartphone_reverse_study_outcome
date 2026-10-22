package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected /* bridge */ /* synthetic */ void setResource(Drawable r1) {
        setResource2(r1);
    }

    public DrawableImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public DrawableImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    protected void setResource2(Drawable r1) {
        ((ImageView) this.view).setImageDrawable(r1);
    }
}
