package com.bytedance.ttnet;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NQEManager {
    private static final String TAG = "NQEManager";
    private static Map<NQEObserver, Handler> sObservers;

    public interface NQEObserver {
        void onNetworkQualityTypeChanged(int r1);
    }

    static {
        sObservers = new HashMap();
    }

    public NQEManager() {
    }

    private static void notifyNQTChanged(final int r5) {
        monitor-enter(NQEManager.class);
        Iterator<Map.Entry<NQEObserver, Handler>> r1 = sObservers.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<NQEObserver, Handler> r2 = r1.next();     // Catch: Throwable -> L8
        final NQEObserver r3 = r2.getKey();     // Catch: Throwable -> L8
        r2.getValue().post(new AnonymousClass1(r3, r5));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void regNQEObserver(NQEObserver r2, Handler r3) {
        if (r2 == null) goto L18;
        if (r3 == null) goto L16;
        monitor-enter(NQEManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sObservers.containsKey(r2) == true) goto L11;
        sObservers.put(r2, r3);     // Catch: Throwable -> L9
    L11:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L9
        return;
    L16:
        throw new NullPointerException("handler == null");
    L18:
        throw new NullPointerException("observer == null");
    }

    public static void unregNQEObserver(NQEObserver r2) {
        if (r2 == null) goto L12;
        monitor-enter(NQEManager.class);
        sObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new NullPointerException("observer == null");
    }
}
