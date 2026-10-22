package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ImageViewTargetFactory {
    public ImageViewTargetFactory() {
    }

    public <Z> ViewTarget<ImageView, Z> buildTarget(ImageView r2, Class<Z> r3) {
        if (Bitmap.class.equals(r3) == false) goto L7;
        return new BitmapImageViewTarget(r2);
    L7:
        if (Drawable.class.isAssignableFrom(r3) == false) goto L11;
        return new DrawableImageViewTarget(r2);
    L11:
        throw new IllegalArgumentException("Unhandled class: " + r3 + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
