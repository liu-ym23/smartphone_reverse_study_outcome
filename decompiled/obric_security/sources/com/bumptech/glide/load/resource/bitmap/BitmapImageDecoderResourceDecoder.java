package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapImageDecoderResourceDecoder implements ResourceDecoder<ImageDecoder.Source, Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool;

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ImageDecoder.Source r1, Options r2) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(ImageDecoder.Source r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ImageDecoder.Source r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    public BitmapImageDecoderResourceDecoder() {
        this.bitmapPool = new BitmapPoolAdapter();
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(ImageDecoder.Source r4, int r5, int r6, Options r7) throws IOException {
        Bitmap r8 = ImageDecoder.decodeBitmap(r4, new DefaultOnHeaderDecodedListener(r5, r6, r7));
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        Log.v(TAG, "Decoded [" + r8.getWidth() + MaterialConfigFormatNames.X + r8.getHeight() + "] for [" + r5 + MaterialConfigFormatNames.X + r6 + "]");
    L6:
        return new BitmapResource(r8, this.bitmapPool);
    }
}
