package com.bytedance.framwork.core.sdkmonitor;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
