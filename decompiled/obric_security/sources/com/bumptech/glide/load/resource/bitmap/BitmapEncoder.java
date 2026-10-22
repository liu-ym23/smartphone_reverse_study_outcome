package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = null;
    public static final Option<Integer> COMPRESSION_QUALITY = null;
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r1, File r2, Options r3) {
        return encode((Resource) r1, r2, r3);
    }

    static {
        COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public BitmapEncoder(ArrayPool r1) {
        this.arrayPool = r1;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    public boolean encode(Resource<Bitmap> r9, File r10, Options r11) {
        Bitmap r12 = r9.get();
        Bitmap.CompressFormat r2 = getFormat(r12, r11);
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(r12.getWidth()), Integer.valueOf(r12.getHeight()), r2);
        long r3 = LogTime.getLogTime();     // Catch: Throwable -> L37
        int r5 = ((Integer) r11.get(COMPRESSION_QUALITY)).intValue();     // Catch: Throwable -> L37
        OutputStream r6 = null;
        FileOutputStream r7 = new FileOutputStream(r10);     // Catch: Throwable -> L18 IOException -> L20
    L16:
        e = e;
        r6 = r7;
    L23:
        if (Log.isLoggable(TAG, 3) == false) goto L25;
        Log.d(TAG, "Failed to encode Bitmap", e);     // Catch: Throwable -> L18
    L25:
        if (r6 != null) goto L51;
    L27:
        boolean r8 = false;
    L30:
        if (Log.isLoggable(TAG, 2) == false) goto L32;
        Log.v(TAG, "Compressed with type: " + r2 + " of size " + Util.getBitmapByteSize(r12) + " in " + LogTime.getElapsedMillis(r3) + ", options format: " + r11.get(COMPRESSION_FORMAT) + ", hasAlpha: " + r12.hasAlpha());     // Catch: Throwable -> L37
    L32:
        GlideTrace.endSection();
        return r8;
    L51:
        r6.close();     // Catch: IOException -> L42 Throwable -> L37
    L14:
        th = th;
        r6 = r7;
    L34:
        if (r6 != null) goto L45;
    L36:
        throw th;     // Catch: Throwable -> L37
    L45:
        r6.close();     // Catch: IOException -> L41 Throwable -> L37
        goto L36
    L7:
        if (this.arrayPool == null) goto L10;
        r6 = new BufferedOutputStream(r7, this.arrayPool);     // Catch: Throwable -> L14 IOException -> L16
    L11:
        r12.compress(r2, r5, r6);     // Catch: Throwable -> L18 IOException -> L20
        r6.close();     // Catch: Throwable -> L18 IOException -> L20
        r6.close();     // Catch: IOException -> L40 Throwable -> L37
    L13:
        r8 = true;
        goto L30
    L10:
        r6 = r7;
    L20:
        e = e;
    L18:
        th = th;
    L37:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    private Bitmap.CompressFormat getFormat(Bitmap r1, Options r2) {
        Bitmap.CompressFormat r0 = (Bitmap.CompressFormat) r2.get(COMPRESSION_FORMAT);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r1.hasAlpha() == false) goto L10;
        return Bitmap.CompressFormat.PNG;
    L10:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r1) {
        return EncodeStrategy.TRANSFORMED;
    }
}
