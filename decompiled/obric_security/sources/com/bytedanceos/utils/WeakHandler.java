package com.bytedanceos.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message msg);
    }

    public WeakHandler(IHandler handler) {
        this.mRef = new WeakReference(handler);
    }

    public WeakHandler(Looper looper, IHandler handler) {
        super(looper);
        this.mRef = new WeakReference(handler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        IHandler r0 = this.mRef.get();
        if (r0 == null) goto L7;
        if (msg == null) goto L8;
        r0.handleMsg(msg);
        return;
    L8:
        return;
    }
}
