package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Zstd {
    static {
        com.bytedance.compression.zstd.f.a.a();
    }

    public Zstd() {
    }

    static native long errGeneric();

    static final byte[] extractArray(ByteBuffer r1) {
        if (r1.hasArray() == false) goto L9;
        if (r1.arrayOffset() != 0) goto L9;
        return r1.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static native long getErrorCode(long r0);

    public static native String getErrorName(long r0);

    public static long getFunAddressBySymbol(String r3) {
        long[] r4 = getFunAddressesBySymbols(new String[]{r3});
        if (r4 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r4.length != 1) goto L7;
        return r4[0];
    }

    public static native long[] getFunAddressesBySymbols(String[] r0);

    public static native boolean isError(long r0);
}
