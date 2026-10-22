package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Zstd {
    static {
        Native.a();
    }

    public Zstd() {
    }

    public static native long errGeneric();

    public static final byte[] extractArray(ByteBuffer r1) {
        if (r1.hasArray() == false) goto L9;
        if (r1.arrayOffset() != 0) goto L9;
        return r1.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static native long getErrorCode(long r0);

    public static native String getErrorName(long r0);

    public static long getFunAddressBySymbol(String r2) {
        long[] r3 = getFunAddressesBySymbols(new String[]{r2});
        if (r3 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r3.length != 1) goto L7;
        return r3[0];
    }

    public static native long[] getFunAddressesBySymbols(String[] r0);

    public static native boolean isError(long r0);
}
