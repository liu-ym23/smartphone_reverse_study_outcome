package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public GifDrawableEncoder() {
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r1, File r2, Options r3) {
        return encode((Resource) r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r1) {
        return EncodeStrategy.SOURCE;
    }

    public boolean encode(Resource<GifDrawable> r1, File r2, Options r3) {
        ByteBufferUtil.toFile(r1.get().getBuffer(), r2);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L9;
        Log.w(TAG, "Failed to encode GIF drawable data", e);
    L9:
        return false;
    }
}
