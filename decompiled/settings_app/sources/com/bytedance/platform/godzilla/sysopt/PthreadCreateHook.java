package com.bytedance.platform.godzilla.sysopt;

/* JADX INFO: loaded from: classes3.dex */
public class PthreadCreateHook {
    public static native void end();

    public static native void start(int r0);

    static {
        System.loadLibrary("godzilla-sysopt");
    }

    private PthreadCreateHook() {
    }
}
