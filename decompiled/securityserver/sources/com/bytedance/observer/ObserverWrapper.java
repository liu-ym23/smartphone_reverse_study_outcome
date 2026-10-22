package com.bytedance.observer;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.bytedance.apm.block.LooperObserverMonitor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ObserverWrapper extends LooperObserverMonitor.BaseObserver implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    public ObserverWrapper() {
    }

    public void dispatchingThrewException(Object r2, Message r3, Exception r4) {
        if (LooperObserverMonitor.sOriginObserver == null) goto L18;
        Looper.Observer r1 = this.mOriginObserver;
        if (r1 == null) goto L16;
        r1.dispatchingThrewException(r2, r3, r4);
        return;
    L16:
        LooperObserverMonitor.dispatchingThrewException.invoke(LooperObserverMonitor.sOriginObserver, new Object[]{r2, r3, r4});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L21:
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

    public Object messageDispatchStarting() {
        Object r1 = null;
        if (LooperObserverMonitor.sOriginObserver == null) goto L16;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L19;
        r1 = r0.messageDispatchStarting();
        goto L16
    L19:
        r1 = LooperObserverMonitor.messageDispatchStarting.invoke(LooperObserverMonitor.sOriginObserver, null);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (LooperObserverMonitor.sMainThread != Thread.currentThread()) goto L18;
        messageDispatchStarting(LooperObserverMonitor.sStart);
    L18:
        return r1;
    }

    public void messageDispatched(Object r3, Message r4) {
        if (LooperObserverMonitor.sOriginObserver == null) goto L16;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L19;
        r0.messageDispatched(r3, r4);
        goto L16
    L19:
        LooperObserverMonitor.messageDispatched.invoke(LooperObserverMonitor.sOriginObserver, new Object[]{r3, r4});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (LooperObserverMonitor.sMainThread != Thread.currentThread()) goto L21;
        messageDispatched(LooperObserverMonitor.sEnd, r4);
        return;
    }

    @Override // com.bytedance.apm.block.LooperObserverMonitor.BaseObserver
    public void setup(Object r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r2;
        return;
    }
}
