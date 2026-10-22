package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(Uri r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(Uri r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    public ResourceBitmapDecoder(ResourceDrawableDecoder r1, BitmapPool r2) {
        this.drawableDecoder = r1;
        this.bitmapPool = r2;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r1, Options r2) {
        return "android.resource".equals(r1.getScheme());
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(Uri r2, int r3, int r4, Options r5) {
        Resource<Drawable> r6 = this.drawableDecoder.decode2(r2, r3, r4, r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        Drawable r7 = r6.get();
        return DrawableToBitmapConverter.convert(this.bitmapPool, r7, r3, r4);
    }
}
