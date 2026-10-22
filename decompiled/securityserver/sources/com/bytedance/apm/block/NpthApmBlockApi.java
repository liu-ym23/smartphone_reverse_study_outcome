package com.bytedance.apm.block;

/* JADX INFO: loaded from: classes.dex */
public final class NpthApmBlockApi {
    private static Runnable sAnrListener;
    private static Runnable sSigQuitEndListener;
    private static Runnable sSigQuitListener;

    public NpthApmBlockApi() {
    }

    public static void notifyANR() {
        Runnable r0 = sAnrListener;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public static void notifySigQuit() {
        Runnable r0 = sSigQuitListener;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public static void notifySigQuitEnd() {
        Runnable r0 = sSigQuitEndListener;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public static void setAnrListener(Runnable r0) {
        sAnrListener = r0;
    }

    public static void setSigQuitEndListener(Runnable r0) {
        sSigQuitEndListener = r0;
    }

    public static void setSigQuitListener(Runnable r0) {
        sSigQuitListener = r0;
    }
}
