package com.android.apksig.internal.util;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBufferUtils {
    private ByteBufferUtils() {
    }

    public static byte[] toByteArray(ByteBuffer r1) {
        byte[] r0 = new byte[r1.remaining()];
        r1.get(r0);
        return r0;
    }
}
