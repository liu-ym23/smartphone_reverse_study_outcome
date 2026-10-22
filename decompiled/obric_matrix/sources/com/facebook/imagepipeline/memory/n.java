package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static f0 a() {
        SparseIntArray r0 = new SparseIntArray();
        r0.put(1024, 5);
        r0.put(2048, 5);
        r0.put(4096, 5);
        r0.put(8192, 5);
        r0.put(16384, 5);
        r0.put(32768, 5);
        r0.put(65536, 5);
        r0.put(131072, 5);
        r0.put(262144, 2);
        r0.put(524288, 2);
        r0.put(1048576, 2);
        return new f0(c(), b(), r0);
    }

    private static int b() {
        int r0 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r0 >= 16777216) goto L7;
        return r0 / 2;
    L7:
        return (r0 / 4) * 3;
    }

    private static int c() {
        int r0 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r0 >= 16777216) goto L7;
        return 3145728;
    L7:
        if (r0 >= 33554432) goto L10;
        return 6291456;
    L10:
        return 12582912;
    }
}
