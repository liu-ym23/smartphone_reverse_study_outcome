package com.bytedance.ttnet.k;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f6465a;

    static {
    }

    public b() {
    }

    public static b a() {
        if (f6465a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6465a != null) goto L9;
        f6465a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f6465a;
    }

    private void b(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public void c(String r3, String r4, String r5, String r6, String r7, String r8) {
        Logger.debug();
        HashMap r0 = new HashMap();
        r0.put("store_idc", r3);
        r0.put("store_region", r4);
        r0.put("region_source", r5);
        r0.put("region_legacy_user", r6);
        r0.put("sec_uid", r7);
        r0.put("logid", r8);
        b(r0);
    }
}
