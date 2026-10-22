package com.bytedance.apm.r;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<e> f1833a;

    static {
        f1833a = new ArrayList(2);
    }

    public static synchronized void a(e r2) {
        monitor-enter(f.class);
        f1833a.add(r2);     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(boolean r3, long r4) {
        monitor-enter(f.class);
        Iterator<e> r1 = f1833a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        e r2 = r1.next();     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.a(r3, r4);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(f.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
