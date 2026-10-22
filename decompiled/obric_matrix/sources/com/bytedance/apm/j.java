package com.bytedance.apm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<i> f1641a;

    static {
        f1641a = new ArrayList(2);
    }

    public static synchronized void a(i r2) {
        monitor-enter(j.class);
        f1641a.add(r2);     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(com.bytedance.apm.config.e r3) {
        monitor-enter(j.class);
        Iterator<i> r1 = f1641a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        i r2 = r1.next();     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.b(r3);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(j.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
