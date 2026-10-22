package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Choreographer;
import com.bytedance.monitor.collector.service.DoubleReflectHelper;
import com.bytedance.monitor.util.unsafe.UnsafeProxy;

/* JADX INFO: loaded from: classes.dex */
public class DoFrameBooster {
    public static final int SEND_AFTER_CURRENT = 1;
    public static final int SEND_AT_FRONT = 0;
    private static final String TAG = "doFrameBooster";
    private static volatile boolean isInited = false;
    private static final ProxyFrameHandler proxyFrameHandler = null;
    private static Object sFrameDisplayEventReceiver;
    private static Handler sFrameHandler;
    private static int sMessageGap;
    private static volatile boolean sNeedHook;
    private static int sRunMode;

    private static class ProxyFrameHandler extends Handler {
        public ProxyFrameHandler(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            DoFrameBooster.access$000().handleMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r5, long r6) {
            if (r5.getCallback() != DoFrameBooster.access$100()) goto L17;
            if (DoFrameBooster.access$200() == false) goto L17;
            if (DoFrameBooster.access$300() == 0) goto L9;
            Message r0 = LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue());
            if (r0 != null) goto L15;
            return sendMessageAtFrontOfQueue(r5);
        L15:
            return super.sendMessageAtTime(r5, Math.min(r0.getWhen() + ((long) DoFrameBooster.access$400()), r6));
        L9:
            return sendMessageAtFrontOfQueue(r5);
        L17:
            return super.sendMessageAtTime(r5, r6);
        }
    }

    public DoFrameBooster() {
    }

    static /* synthetic */ Handler access$000() {
        return sFrameHandler;
    }

    static /* synthetic */ Object access$100() {
        return sFrameDisplayEventReceiver;
    }

    static /* synthetic */ boolean access$200() {
        return sNeedHook;
    }

    static /* synthetic */ int access$300() {
        return sRunMode;
    }

    static /* synthetic */ int access$400() {
        return sMessageGap;
    }

    static {
        proxyFrameHandler = new ProxyFrameHandler(Looper.getMainLooper());
        sFrameDisplayEventReceiver = null;
        sNeedHook = false;
        sMessageGap = 0;
        sRunMode = 1;
    }

    public static synchronized void init() {
        monitor-enter(DoFrameBooster.class);
        init(Choreographer.getInstance());     // Catch: Throwable -> L7
        monitor-exit(DoFrameBooster.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Choreographer r4) {
        monitor-enter(DoFrameBooster.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isInited == false) goto L18;
        monitor-exit(DoFrameBooster.class);
        return;
    L18:
        sFrameHandler = (Handler) DoubleReflectHelper.readField(r4, "mHandler");     // Catch: Exception -> L10 Throwable -> L14
        sFrameDisplayEventReceiver = DoubleReflectHelper.readField(r4, "mDisplayEventReceiver");     // Catch: Exception -> L10 Throwable -> L14
        UnsafeProxy.putObject(r4, UnsafeProxy.objectFieldOffset(DoubleReflectHelper.getField(Choreographer.class, "mHandler")), proxyFrameHandler);     // Catch: Exception -> L10 Throwable -> L14
        Log.i(TAG, "hack Choreographer Success");     // Catch: Exception -> L10 Throwable -> L14
        isInited = true;     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(DoFrameBooster.class);
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "hack Choreographer Error", e);     // Catch: Throwable -> L14
        goto L12
    }

    public static void setNeedHook(boolean r0) {
        sNeedHook = r0;
    }

    public static void setMessageGap(int r0) {
        sMessageGap = r0;
    }

    public static void setRunMode(int r0) {
        sRunMode = r0;
    }
}
