package com.ss.thor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class Thor {
    private static final int FIXED_KEEP_ALIVE_SECONDS = 30;
    public static final int NO_C = 3;
    public static final int NO_I = 1;
    public static final int NO_U = 2;
    public static final int NO_UI = 4;
    public static final int NO_UIC = 5;
    private static final int SAMPLE_DEFAULT = 3000;
    public static final String TAG = "Thor";
    private static ThorCallback mCallBack;
    private static ExecutorService mExecutorService;
    private static HandlerThread mThorThread;
    private static AtomicInteger sThreadCount;
    private static int sample_rate;
    private static ThorHandler thorHandler;

    private static class ThorHandler extends Handler {
        public ThorHandler(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            if (Thor.access$000() != null) goto L5;
            return;
        L5:
            int r0 = r7.what;
            Context r8 = (Context) r7.obj;
            if (r0 != 1) goto L8;
            Thor.access$000().onUpdate(ThorUtils.getGalvanicNow(r8), -1.0f, -1);     // Catch: Exception -> L23
        L24:
            goto L21
        L8:
            if (r0 != 2) goto L10;
            Thor.access$000().onUpdate(-1.0f, ThorUtils.getVoltage(r8), -1);     // Catch: Exception -> L23
            goto L24
        L10:
            if (r0 != 3) goto L12;
            Thor.access$000().onUpdate(-1.0f, -1.0f, ThorUtils.getCapacity(r8));     // Catch: Exception -> L23
            goto L24
        L12:
            if (r0 != 4) goto L14;
            Thor.access$000().onUpdate(ThorUtils.getGalvanicNow(r8), ThorUtils.getVoltage(r8), -1);     // Catch: Exception -> L23
            goto L24
        L14:
            if (r0 != 5) goto L21;
            Thor.access$000().onUpdate(ThorUtils.getGalvanicNow(r8), ThorUtils.getVoltage(r8), ThorUtils.getCapacity(r8));     // Catch: Exception -> L23
        L21:
            sendMessageDelayed(obtainMessage(r0, r8), Thor.access$100());
        }
    }

    public Thor() {
    }

    static /* synthetic */ ThorCallback access$000() {
        return mCallBack;
    }

    static /* synthetic */ int access$100() {
        return sample_rate;
    }

    static /* synthetic */ AtomicInteger access$200() {
        return sThreadCount;
    }

    public static void start(Context r2, ThorCallback r3) {
        start(r2, r3, 1, 3000);
    }

    public static void start(Context r2, ThorCallback r3, int r4, int r5) {
        if (mThorThread != null) goto L5;
        HandlerThread r0 = new HandlerThread("Thor-Handler-Thread");
        mThorThread = r0;
        r0.start();
        thorHandler = new ThorHandler(mThorThread.getLooper());
        mCallBack = r3;
        r3.onStart();
        sample_rate = r5;
    L5:
        ThorHandler r6 = thorHandler;
        r6.sendMessage(r6.obtainMessage(r4, r2));
    }

    public static void stop() {
        HandlerThread r0 = mThorThread;
        if (r0 == null) goto L6;
        r0.quit();
        mCallBack.onStop();
        mThorThread = null;
        thorHandler = null;
        mCallBack = null;
        return;
    }

    static {
        sThreadCount = new AtomicInteger(0);
    }

    public static ExecutorService getExecutorService() {
        if (mExecutorService != null) goto L15;
        monitor-enter(Thor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mExecutorService != null) goto L9;
        mExecutorService = createSerialExecutor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Thor.class);     // Catch: Throwable -> L11
    L15:
        return mExecutorService;
    }

    private static ThreadFactory threadFactory(final String r1, final boolean r2, final int r3) {
        return new AnonymousClass1(r3, r1, r2);
    }

    private static ExecutorService createSerialExecutor() {
        return Executors.newSingleThreadExecutor(threadFactory(TAG, false, 0));
    }
}
