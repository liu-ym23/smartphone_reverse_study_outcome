package com.bytedance.observer;

import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.block.LooperObserverMonitor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public class ObserverWrapper extends LooperObserverMonitor.BaseObserver implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    static {
    }

    public ObserverWrapper() {
    }

    @Override // com.bytedance.apm.block.LooperObserverMonitor.BaseObserver
    protected void setup(Object r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r2;
        return;
    }

    public Object messageDispatchStarting() {
        if (LooperObserverMonitor.sOriginObserver == null) goto L13;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L18;
        Object r1 = r0.messageDispatchStarting();
    L15:
        if (LooperObserverMonitor.sMainThread != Thread.currentThread()) goto L17;
        messageDispatchStarting(LooperObserverMonitor.sStart);
    L17:
        return r1;
    L18:
        r1 = LooperObserverMonitor.messageDispatchStarting.invoke(LooperObserverMonitor.sOriginObserver, new Object[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        r1 = null;
        goto L15
    }

    public void messageDispatched(Object r5, Message r6) {
        if (LooperObserverMonitor.sOriginObserver == null) goto L14;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L17;
        r0.messageDispatched(r5, r6);
        goto L14
    L17:
        LooperObserverMonitor.messageDispatched.invoke(LooperObserverMonitor.sOriginObserver, new Object[]{r5, r6});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (LooperObserverMonitor.sMainThread != Thread.currentThread()) goto L19;
        messageDispatched(LooperObserverMonitor.sEnd, r6);
        return;
    }

    public void dispatchingThrewException(Object r4, Message r5, Exception r6) {
        if (LooperObserverMonitor.sOriginObserver == null) goto L16;
        Looper.Observer r3 = this.mOriginObserver;
        if (r3 == null) goto L14;
        r3.dispatchingThrewException(r4, r5, r6);
        return;
    L14:
        LooperObserverMonitor.dispatchingThrewException.invoke(LooperObserverMonitor.sOriginObserver, new Object[]{r4, r5, r6});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
