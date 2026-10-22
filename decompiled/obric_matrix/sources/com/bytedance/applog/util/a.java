package com.bytedance.applog.util;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.applog.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2418b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.e> f2419a;

    private a() {
        this.f2419a = new CopyOnWriteArraySet();
    }

    public static a g() {
        if (f2418b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2418b != null) goto L9;
        f2418b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2418b;
    }

    @Override // com.bytedance.applog.e
    public void a(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<com.bytedance.applog.e> r0 = this.f2419a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // com.bytedance.applog.e
    public void b(String r2, String r3, String r4) {
        Iterator<com.bytedance.applog.e> r1 = this.f2419a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().b(r2, r3, r4);
        goto L4
    }

    @Override // com.bytedance.applog.e
    public void c(boolean r2, JSONObject r3) {
        Iterator<com.bytedance.applog.e> r1 = this.f2419a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().c(r2, r3);
        goto L4
    }

    @Override // com.bytedance.applog.e
    public void d(String r2, String r3) {
        Iterator<com.bytedance.applog.e> r1 = this.f2419a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().d(r2, r3);
        goto L4
    }

    @Override // com.bytedance.applog.e
    public void e(boolean r2, JSONObject r3) {
        Iterator<com.bytedance.applog.e> r1 = this.f2419a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().e(r2, r3);
        goto L4
    }

    public void f(com.bytedance.applog.e r1) {
        if (r1 == null) goto L5;
        this.f2419a.add(r1);
        return;
    }

    public void h(com.bytedance.applog.e r1) {
        if (r1 == null) goto L5;
        this.f2419a.remove(r1);
        return;
    }
}
