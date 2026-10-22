package com.ss.android.message;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes4.dex */
public class PushThreadHandlerManager implements WeakHandler.IHandler {
    private static PushThreadHandlerManager sInstance;
    private final WeakHandler mHandler;
    private final Looper mLooper;
    private final HandlerThread thread;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    public static PushThreadHandlerManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(PushThreadHandlerManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PushThreadHandlerManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PushThreadHandlerManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PushThreadHandlerManager() {
        HandlerThread r0 = new HandlerThread("PushThreadHandler");
        this.thread = r0;
        r0.start();
        Looper r1 = r0.getLooper();
        this.mLooper = r1;
        this.mHandler = new WeakHandler(r1, this);
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public WeakHandler getHandler() {
        return this.mHandler;
    }

    public void postRunnable(Runnable r3) {
        postRunnable(r3, 0);
    }

    public void postRunnable(Runnable r3, long r4) {
        if (r4 > 0) goto L5;
        this.mHandler.post(r3);
        return;
    L5:
        this.mHandler.postDelayed(r3, r4);
    }
}
