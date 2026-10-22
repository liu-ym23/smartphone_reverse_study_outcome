package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
@MainDex
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    interface Natives {
        void reportJavaException(boolean r1, Throwable r2);

        void reportJavaStackTrace(String r1);
    }

    static {
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler r1, boolean r2) {
        this.mParent = r1;
        this.mCrashAfterReport = r2;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r3, Throwable r4) {
        if (this.mHandlingException == true) goto L5;
        this.mHandlingException = true;
        JavaExceptionReporterJni.get().reportJavaException(this.mCrashAfterReport, r4);
    L5:
        Thread.UncaughtExceptionHandler r2 = this.mParent;
        if (r2 == null) goto L9;
        r2.uncaughtException(r3, r4);
        return;
    }

    public static void reportStackTrace(String r1) {
        JavaExceptionReporterJni.get().reportJavaStackTrace(PiiElider.sanitizeStacktrace(r1));
    }

    public static void reportException(Throwable r2) {
        JavaExceptionReporterJni.get().reportJavaException(false, r2);
    }

    private static void installHandler(boolean r2) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r2));
    }
}
