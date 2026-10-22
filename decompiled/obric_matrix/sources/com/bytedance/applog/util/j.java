package com.bytedance.applog.util;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class j implements com.bytedance.applog.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile j f2424b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.h> f2425a;

    private j() {
        this.f2425a = new CopyOnWriteArraySet();
    }

    public static j b() {
        if (f2424b != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2424b != null) goto L9;
        f2424b = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f2424b;
    }

    @Override // com.bytedance.applog.h
    public void a(String r2, long r3, boolean r5) {
        Iterator<com.bytedance.applog.h> r1 = this.f2425a.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        r1.next().a(r2, r3, r5);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        n.i(th);
        goto L4
    }
}
