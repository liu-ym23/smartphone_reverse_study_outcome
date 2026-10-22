package com.bytedance.sdk.account.impl;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.s.a.q.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d.b.s.a.q.g f5533b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5534a;

    private d() {
        this.f5534a = com.ss.android.i.j.k().e();
    }

    public static d.b.s.a.q.g d() {
        if (f5533b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5533b != null) goto L9;
        f5533b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f5533b;
    }

    @Override // d.b.s.a.q.g
    public void a(String r1, String r2, int r3, d.b.s.a.q.k.a r4) {
        d.b.s.a.y.a.J(this.f5534a, r1, r2, r3, r4).D();
    }

    @Override // d.b.s.a.q.g
    public void b(String r1, d.b.s.a.q.j.a<d.b.s.a.q.j.c> r2) {
        d.b.s.a.b0.b.a.J(this.f5534a, r1, r2).D();
    }

    public void c(String r13, String r14, String r15, Map<String, String> r16, d.b.s.a.b0.b.g.e r17) {
        d.b.s.a.f0.b.a(3, r13);
        d.b.s.a.b0.b.f.M(this.f5534a, r13, null, null, null, r14, null, r15, 0, r16, r17).D();
    }

    @Override // d.b.s.a.q.g
    public void e(String r13, int r14, Map<String, String> r15, d.b.s.a.b0.b.g.c r16) {
        d.b.s.a.b0.b.d.L(this.f5534a, r13, null, r14, 0, null, -1, 0, null, null, r15, r16).D();
    }

    @Override // d.b.s.a.q.g
    public void f(String r1, String r2, d.b.s.a.q.k.e r3) {
        d.b.s.a.y.f.M(this.f5534a, r1, r2, r3).D();
    }

    @Override // d.b.s.a.q.g
    public void g(String r1, String r2, d.b.s.a.b0.b.g.d r3) {
        d.b.s.a.b0.b.e.L(this.f5534a, r1, r2, r3).D();
    }

    public void h(String r9, String r10, String r11, String r12, boolean r13, d.b.s.a.b0.b.g.b r14) {
        l(r9, r10, r11, r12, r13, null, r14);
    }

    @Override // d.b.s.a.q.g
    public void i(String r8, String r9, String r10, String r11, d.b.s.a.b0.b.g.b r12) {
        h(r8, r9, r10, r11, true, r12);
    }

    @Override // d.b.s.a.q.g
    public void j(String r7, String r8, String r9, d.b.s.a.b0.b.g.e r10) {
        c(r7, r8, r9, null, r10);
    }

    @Override // d.b.s.a.q.g
    public void k(String r1, String r2, d.b.s.a.q.k.d r3) {
        d.b.s.a.y.e.L(this.f5534a, r1, r2, r3).D();
    }

    public void l(String r9, String r10, String r11, String r12, boolean r13, Map<String, String> r14, d.b.s.a.b0.b.g.b r15) {
        d.b.s.a.b0.b.c.L(this.f5534a, r9, r10, r11, r12, r13, r14, r15).D();
    }

    @Override // d.b.s.a.q.g
    public void m(String r1, d.b.s.a.q.k.b r2) {
        d.b.s.a.y.b.J(this.f5534a, r1, r2).D();
    }

    @Override // d.b.s.a.q.g
    public void n(String r9, String r10, Integer r11, String r12, Map<String, String> r13, d.b.s.a.b0.b.g.a r14) {
        d.b.s.a.f0.b.a(2, r9);
        d.b.s.a.b0.b.b.L(this.f5534a, r9, r10, r11, r12, r13, r14).D();
    }
}
