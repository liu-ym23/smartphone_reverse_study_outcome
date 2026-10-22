package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* JADX INFO: loaded from: classes.dex */
public class SocketHandler implements WeakHandler.IHandler {
    private static WeakHandler mHandler;
    private static volatile SocketHandler sInstance;

    private SocketHandler() {
        if (mHandler != null) goto L10;
        mHandler = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r0 = new HandlerThread("WsHT");
        r0.start();
        mHandler = new WeakHandler(r0.getLooper(), this);
        return;
    }

    public static SocketHandler inst() {
        if (sInstance != null) goto L16;
        monitor-enter(SocketHandler.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new SocketHandler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(SocketHandler.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static void setStartedHandlerThread(HandlerThread r3) {
        monitor-enter(SocketHandler.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mHandler != null) goto L9;
        mHandler = new WeakHandler(r3.getLooper(), new AnonymousClass1());     // Catch: Throwable -> L7
    L9:
        monitor-exit(SocketHandler.class);     // Catch: Throwable -> L7
    }

    public WeakHandler getHandler() {
        return mHandler;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    public void postRunnable(Runnable r3) {
        postRunnable(r3, 0);
    }

    public void postRunnable(Runnable r3, long r4) {
        if (r4 > 0) goto L5;
        mHandler.post(r3);
        return;
    L5:
        mHandler.postDelayed(r3, r4);
    }
}
