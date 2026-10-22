package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r1);
    }

    public WeakHandler(IHandler r2) {
        if (Looper.myLooper() != null) goto L5;
        Looper r0 = Looper.getMainLooper();
    L6:
        this(r0, r2);
        return;
    L5:
        r0 = Looper.myLooper();
        goto L6
    }

    public WeakHandler(Looper r1, IHandler r2) {
        super(r1);
        this.mRef = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r1) {
        IHandler r0 = this.mRef.get();
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.handleMsg(r1);
        return;
    L8:
        return;
    }
}
