package org.chromium.wschannel;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes6.dex */
public class TrafficChangedObservable extends Observable {
    public static final String TRAFFICCHANGED_IS_HEARTBEAT_FRAME = "is_heartbeat_frame";
    public static final String TRAFFICCHANGED_RECEIVEDBYTES = "received_bytes";
    public static final String TRAFFICCHANGED_SENTBYTES = "sent_bytes";
    public static final String TRAFFICCHANGED_URL = "url";
    private static volatile TrafficChangedObservable sInstance;

    public TrafficChangedObservable() {
    }

    public static TrafficChangedObservable inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TrafficChangedObservable.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TrafficChangedObservable();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TrafficChangedObservable.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void onTrafficChanged(String r3, long r4, long r6, boolean r8) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put(TRAFFICCHANGED_IS_HEARTBEAT_FRAME, Boolean.valueOf(r8));
        notifyTrafficChangedObservers(r0);
    }

    private void notifyTrafficChangedObservers(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }
}
