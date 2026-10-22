package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
class f<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Queue f6714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6716e;

    public f(int r4, int r5, int r6, boolean r7) {
        boolean r0 = true;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.i(r2);
        if (r5 < 0) goto L9;
        boolean r3 = true;
    L10:
        d.c.c.d.i.i(r3);
        if (r6 >= 0) goto L14;
        r0 = false;
    L14:
        d.c.c.d.i.i(r0);
        this.f6712a = r4;
        this.f6713b = r5;
        this.f6714c = new LinkedList();
        this.f6716e = r6;
        this.f6715d = r7;
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    void a(V r1) {
        this.f6714c.add(r1);
    }

    public void b() {
        if (this.f6716e <= 0) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.i(r0);
        this.f6716e--;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    public V c() {
        V r0 = h();
        if (r0 == null) goto L5;
        this.f6716e++;
    L5:
        return r0;
    }

    int d() {
        return this.f6714c.size();
    }

    public int e() {
        return this.f6716e;
    }

    public void f() {
        this.f6716e++;
    }

    public boolean g() {
        if ((this.f6716e + d()) <= this.f6713b) goto L5;
        return true;
    L5:
        return false;
    }

    public V h() {
        return (V) this.f6714c.poll();
    }

    public void i(V r4) {
        d.c.c.d.i.g(r4);
        boolean r1 = false;
        if (this.f6715d == true) goto L5;
        int r0 = this.f6716e;
        if (r0 <= 0) goto L11;
    L10:
        this.f6716e = r0 - 1;
        a(r4);
        return;
    L11:
        d.c.c.e.a.l("BUCKET", "Tried to release value %s from an empty bucket!", new Object[]{r4});
        return;
    L5:
        if (this.f6716e <= 0) goto L7;
        r1 = true;
    L7:
        d.c.c.d.i.i(r1);
        r0 = this.f6716e;
        goto L10
    }
}
