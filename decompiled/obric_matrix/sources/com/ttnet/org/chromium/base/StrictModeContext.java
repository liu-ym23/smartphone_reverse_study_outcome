package com.ttnet.org.chromium.base;

import android.os.Build;
import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class StrictModeContext implements Closeable {
    private final StrictMode.ThreadPolicy mThreadPolicy;
    private final StrictMode.VmPolicy mVmPolicy;

    private StrictModeContext(StrictMode.ThreadPolicy r2) {
        this(r2, null);
    }

    private StrictModeContext(StrictMode.ThreadPolicy r1, StrictMode.VmPolicy r2) {
        this.mThreadPolicy = r1;
        this.mVmPolicy = r2;
    }

    private StrictModeContext(StrictMode.VmPolicy r2) {
        this(null, r2);
    }

    public static StrictModeContext allowAllThreadPolicies() {
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        return new StrictModeContext(r0);
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy r0 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(r0);
    }

    public static StrictModeContext allowDiskReads() {
        return new StrictModeContext(StrictMode.allowThreadDiskReads());
    }

    public static StrictModeContext allowDiskWrites() {
        return new StrictModeContext(StrictMode.allowThreadDiskWrites());
    }

    public static StrictModeContext allowSlowCalls() {
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitCustomSlowCalls().build());
        return new StrictModeContext(r0);
    }

    public static StrictModeContext allowUnbufferedIo() {
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitUnbufferedIo().build());
    L6:
        return new StrictModeContext(r0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r0 = this.mThreadPolicy;
        if (r0 == null) goto L5;
        StrictMode.setThreadPolicy(r0);
    L5:
        StrictMode.VmPolicy r1 = this.mVmPolicy;
        if (r1 == null) goto L9;
        StrictMode.setVmPolicy(r1);
        return;
    }
}
