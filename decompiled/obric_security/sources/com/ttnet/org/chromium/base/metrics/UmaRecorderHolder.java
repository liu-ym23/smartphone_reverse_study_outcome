package com.ttnet.org.chromium.base.metrics;

/* JADX INFO: loaded from: classes4.dex */
public class UmaRecorderHolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sNativeInitialized;
    private static CachingUmaRecorder sRecorder;
    private static boolean sSetUpNativeUmaRecorder;

    private UmaRecorderHolder() {
    }

    static {
        sRecorder = new CachingUmaRecorder();
        sSetUpNativeUmaRecorder = true;
    }

    public static UmaRecorder get() {
        return sRecorder;
    }

    public static void setNonNativeDelegate(UmaRecorder r1) {
        sRecorder.setDelegate(r1);
    }

    public static void setUpNativeUmaRecorder(boolean r0) {
        sSetUpNativeUmaRecorder = r0;
    }

    public static void onLibraryLoaded() {
        if (sSetUpNativeUmaRecorder == true) goto L5;
        return;
    L5:
        sNativeInitialized = true;
        sRecorder.setDelegate(new NativeUmaRecorder());
    }

    public static void resetForTesting() {
        if (sNativeInitialized == true) goto L6;
        sRecorder = new CachingUmaRecorder();
        return;
    }
}
