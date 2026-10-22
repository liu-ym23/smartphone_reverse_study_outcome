package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    public ByteBufferEncoder() {
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(ByteBuffer r1, File r2, Options r3) {
        return encode2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(ByteBuffer r1, File r2, Options r3) {
        ByteBufferUtil.toFile(r1, r2);     // Catch: IOException -> L4
        return true;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Failed to write data", e);
    L8:
        return false;
    }
}
