package org.chromium.wschannel;

import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f22699a;

    public d() {
    }

    public static d a() {
        if (f22699a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22699a != null) goto L9;
        f22699a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f22699a;
    }

    private void b(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public void c(String r3, long r4, long r6, boolean r8) {
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_CONNECTION_URL, r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put("is_heartbeat_frame", Boolean.valueOf(r8));
        b(r0);
    }
}
