package com.bytedance.frameworks.baselib.network.http.cronet.e;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class k extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f4749a;

    public k() {
    }

    public static k a() {
        if (f4749a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4749a != null) goto L9;
        f4749a = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f4749a;
    }

    private void b(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public void c(String r3, long r4, long r6, String r8, String r9) {
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_CONNECTION_URL, r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put("content_type", r8);
        r0.put(ICronetClient.KEY_REQUEST_LOG, r9);
        b(r0);
    }
}
