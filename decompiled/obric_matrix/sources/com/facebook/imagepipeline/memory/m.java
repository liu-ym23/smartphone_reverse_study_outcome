package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6733a = 0;

    static {
        f6733a = Runtime.getRuntime().availableProcessors();
    }

    public static SparseIntArray a(int r1, int r2, int r3) {
        SparseIntArray r0 = new SparseIntArray();
    L3:
        if (r1 > r2) goto L5;
        r0.put(r1, r3);
        r1 = r1 * 2;
        goto L3
    L5:
        return r0;
    }

    public static f0 b() {
        int r6 = f6733a;
        return new f0(4194304, r6 * 4194304, a(131072, 4194304, r6), 131072, 4194304, r6);
    }
}
