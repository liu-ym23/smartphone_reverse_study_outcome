package com.ss.android.account.group_onekey.c;

import android.os.SystemClock;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f11763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f11765i;

    public c(String r2) {
        o.g(r2, "loginScene");
        this.f11765i = r2;
        this.f11758b = "";
        this.f11759c = "";
    }

    public final long a() {
        return this.f11763g;
    }

    public final int b() {
        return this.f11757a;
    }

    public final String c() {
        return this.f11758b;
    }

    public final long d() {
        return this.f11764h;
    }

    public final long e() {
        return this.f11762f;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (o.a(this.f11765i, ((c) r2).f11765i) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final String f() {
        return this.f11759c;
    }

    public final long g() {
        return this.f11761e;
    }

    public final boolean h() {
        return this.f11760d;
    }

    public int hashCode() {
        String r0 = this.f11765i;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final boolean i() {
        if (this.f11759c.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if ((SystemClock.elapsedRealtime() - this.f11763g) >= com.ss.android.account.group_onekey.e.a.f11780a.a(this.f11765i)) goto L11;
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final void j(long r1) {
        this.f11763g = r1;
    }

    public final void k(int r1) {
        this.f11757a = r1;
    }

    public final void l(String r2) {
        o.g(r2, "<set-?>");
        this.f11758b = r2;
    }

    public final void m(d.b.s.a.q.m.c r1) {
    }

    public final void n(long r1) {
        this.f11764h = r1;
    }

    public final void o(long r1) {
        this.f11762f = r1;
    }

    public final void p(boolean r1) {
    }

    public final void q(String r2) {
        o.g(r2, "<set-?>");
        this.f11759c = r2;
    }

    public final void r(long r1) {
        this.f11761e = r1;
    }

    public String toString() {
        return "GetTokenResult(loginScene=" + this.f11765i + ")";
    }
}
