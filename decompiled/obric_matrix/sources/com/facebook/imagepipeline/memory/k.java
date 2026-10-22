package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f6732a = null;

    static {
        f6732a = new SparseIntArray(0);
    }

    public static f0 a() {
        return new f0(0, b(), f6732a);
    }

    private static int b() {
        int r0 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r0 <= 16777216) goto L7;
        return (r0 / 4) * 3;
    L7:
        return r0 / 2;
    }
}
