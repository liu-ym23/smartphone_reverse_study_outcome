package com.bytedance.ttnet;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NQEManager {
    private static final String TAG = "NQEManager";
    private static Map<NQEObserver, Handler> sObservers;

    public interface NQEObserver {
        void onNetworkQualityTypeChanged(int r1);
    }

    public NQEManager() {
    }

    static {
        sObservers = new HashMap();
    }

    public static void regNQEObserver(NQEObserver r2, Handler r3) {
        if (r2 == null) goto L17;
        if (r3 == null) goto L15;
        monitor-enter(NQEManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sObservers.containsKey(r2) == true) goto L9;
        sObservers.put(r2, r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L11
        return;
    L15:
        throw new NullPointerException("handler == null");
    L17:
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

    private static void notifyNQTChanged(final int r5) {
        monitor-enter(NQEManager.class);
        Iterator<Map.Entry<NQEObserver, Handler>> r1 = sObservers.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<NQEObserver, Handler> r2 = r1.next();     // Catch: Throwable -> L10
        final NQEObserver r3 = r2.getKey();     // Catch: Throwable -> L10
        r2.getValue().post(new AnonymousClass1(r3, r5));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
