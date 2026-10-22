package com.bytedance.mobsec.metasec.ml;

import android.content.Context;
import ms.bd.c.p2;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public interface a {
        int a();
    }

    private d() {
    }

    public static synchronized c a(String r2) {
        monitor-enter(d.class);
        p2.a r3 = p2.a(r2);     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        c r1 = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);
        return r1;
    L8:
        r1 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean b(Context r2, b r3) {
        monitor-enter(d.class);
        boolean r4 = p2.d(r2, r3.c(), "metasec_ml");     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }
}
