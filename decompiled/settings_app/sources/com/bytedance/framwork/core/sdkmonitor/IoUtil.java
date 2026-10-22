package com.bytedance.framwork.core.sdkmonitor;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public class IoUtil {
    public IoUtil() {
    }

    public static void close(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
