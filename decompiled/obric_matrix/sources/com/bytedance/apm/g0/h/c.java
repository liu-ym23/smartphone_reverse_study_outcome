package com.bytedance.apm.g0.h;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.r.m.b.C0058b f1593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedList<Integer> f1594b;

    static {
    }

    public static void c(com.bytedance.apm.r.m.b r0) {
    }

    public void a(long r1, boolean r3) {
        this.f1593a.a(r1, r3);
    }

    public void b(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f1594b.size() <= 20000) goto L9;
        this.f1594b.poll();     // Catch: Throwable -> L12
    L9:
        this.f1594b.add(Integer.valueOf(((int) r3) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }
}
