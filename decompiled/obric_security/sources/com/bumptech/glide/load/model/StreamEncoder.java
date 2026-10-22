package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(InputStream r1, File r2, Options r3) {
        return encode2(r1, r2, r3);
    }

    public StreamEncoder(ArrayPool r1) {
        this.byteArrayPool = r1;
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(InputStream r5, File r6, Options r7) {
        byte[] r0 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r6);     // Catch: Throwable -> L14 IOException -> L16
    L40:
        int r8 = r5.read(r0);     // Catch: Throwable -> L10 IOException -> L12
        if (r8 == (-1)) goto L7;
        r3.write(r0, 0, r8);     // Catch: Throwable -> L10 IOException -> L12
        goto L40
    L7:
        r3.close();     // Catch: Throwable -> L10 IOException -> L12
        r3.close();     // Catch: IOException -> L29
    L9:
        this.byteArrayPool.put(r0);
        return true;
    L12:
        e = e;
        r2 = r3;
    L19:
        if (Log.isLoggable(TAG, 3) == false) goto L21;
        Log.d(TAG, "Failed to encode data onto the OutputStream", e);     // Catch: Throwable -> L14
    L21:
        if (r2 != null) goto L32;
    L23:
        this.byteArrayPool.put(r0);
        return false;
    L32:
        r2.close();     // Catch: IOException -> L31
    L10:
        th = th;
        r2 = r3;
    L25:
        if (r2 != null) goto L38;
    L27:
        this.byteArrayPool.put(r0);
        throw th;
    L38:
        r2.close();     // Catch: IOException -> L30
    L14:
        th = th;
    L16:
        e = e;
        goto L19
    }
}
