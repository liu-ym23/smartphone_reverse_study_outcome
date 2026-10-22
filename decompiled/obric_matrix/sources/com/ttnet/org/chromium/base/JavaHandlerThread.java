package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class JavaHandlerThread {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HandlerThread mThread;
    private Throwable mUnhandledException;

    interface Natives {
        void initializeThread(long r1, long r3);

        void onLooperStopped(long r1);
    }

    static {
    }

    public JavaHandlerThread(String r2, int r3) {
        this.mThread = new HandlerThread(r2, r3);
    }

    static /* synthetic */ HandlerThread access$000(JavaHandlerThread r0) {
        return r0.mThread;
    }

    static /* synthetic */ Throwable access$102(JavaHandlerThread r0, Throwable r1) {
        r0.mUnhandledException = r1;
        return r1;
    }

    @CalledByNative
    private static JavaHandlerThread create(String r1, int r2) {
        return new JavaHandlerThread(r1, r2);
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }

    private boolean hasStarted() {
        if (this.mThread.getState() == Thread.State.NEW) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.mThread.isAlive();
    }

    @CalledByNative
    private void joinThread() {
        boolean r0 = false;
    L3:
        if (r0 == true) goto L6;
        this.mThread.join();     // Catch: InterruptedException -> L7
        r0 = true;
        goto L3
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new AnonymousClass3(this));
    }

    @CalledByNative
    private void quitThreadSafely(final long r3) {
        new Handler(this.mThread.getLooper()).post(new AnonymousClass2(this, r3));
        this.mThread.getLooper().quitSafely();
    }

    @CalledByNative
    private void startAndInitialize(final long r9, final long r11) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new AnonymousClass1(this, r9, r11));
    }

    public Looper getLooper() {
        return this.mThread.getLooper();
    }

    public void maybeStart() {
        if (hasStarted() == false) goto L5;
        return;
    L5:
        this.mThread.start();
    }
}
