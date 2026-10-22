package com.bytedance.apm6.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class Tools {
    private static Handler sHandler;

    public Tools() {
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
    }

    public static byte[] safeGetBytes(String r1) {
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        if (r1.length() <= 0) goto L8;
        return r1.getBytes("UTF-8");
    L12:
        return r1.getBytes();
    }

    public static void runOnUiThread(Runnable r1) {
        sHandler.post(r1);
    }
}
