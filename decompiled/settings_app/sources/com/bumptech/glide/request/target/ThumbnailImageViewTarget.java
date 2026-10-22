package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    protected abstract Drawable getDrawable(T r1);

    public ThumbnailImageViewTarget(ImageView r1) {
        super(r1);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView r1, boolean r2) {
        super(r1, r2);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void setResource(T r4) {
        ViewGroup.LayoutParams r0 = ((ImageView) this.view).getLayoutParams();
        Drawable r5 = getDrawable(r4);
        if (r0 != null) goto L5;
    L9:
        ((ImageView) this.view).setImageDrawable(r5);
        return;
    L5:
        if (r0.width <= 0) goto L9;
        if (r0.height <= 0) goto L9;
        r5 = new FixedSizeDrawable(r5, r0.width, r0.height);
        goto L9
    }
}
