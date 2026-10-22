package com.bytedance.applog.util;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m implements com.bytedance.applog.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile m f2427b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.k> f2428a;

    private m() {
        this.f2428a = new CopyOnWriteArraySet();
    }

    public static m c() {
        if (f2427b != null) goto L13;
        monitor-enter(m.class);
        f2427b = new m();     // Catch: Throwable -> L9
        monitor-exit(m.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f2427b;
    }

    @Override // com.bytedance.applog.k
    public void a(long r2, String r4, JSONObject r5) {
        Iterator<com.bytedance.applog.k> r1 = this.f2428a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a(r2, r4, r5);
        goto L4
    }

    @Override // com.bytedance.applog.k
    public void b(long r2, String r4) {
        Iterator<com.bytedance.applog.k> r1 = this.f2428a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().b(r2, r4);
        goto L4
    }
}
