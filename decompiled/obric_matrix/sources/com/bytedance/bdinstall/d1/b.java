package com.bytedance.bdinstall.d1;

import com.bytedance.bdinstall.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class b implements x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f2728b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<x> f2729a;

    private b() {
        this.f2729a = new CopyOnWriteArraySet();
    }

    public static b d() {
        if (f2728b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2728b != null) goto L9;
        f2728b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2728b;
    }

    @Override // com.bytedance.bdinstall.x
    public void a(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<x> r0 = this.f2729a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // com.bytedance.bdinstall.x
    public void b(String r2, String r3, String r4) {
        Iterator<x> r1 = this.f2729a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().b(r2, r3, r4);
        goto L4
    }

    public void c(x r1) {
        if (r1 == null) goto L5;
        this.f2729a.add(r1);
        return;
    }
}
