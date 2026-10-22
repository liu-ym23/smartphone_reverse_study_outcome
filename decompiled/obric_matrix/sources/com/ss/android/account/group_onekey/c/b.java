package com.ss.android.account.group_onekey.c;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile d f11753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile c f11754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f11755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11756d;

    public final boolean a() {
        return this.f11755c;
    }

    public final c b() {
        return this.f11754b;
    }

    public final d c() {
        return this.f11753a;
    }

    public final void d() {
        d.b.s.a.a0.a.d("AccountGroupAuthService", "GetTokenCache invalid");
        this.f11754b = null;
    }

    public final boolean e() {
        c r1 = this.f11754b;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.i() != true) goto L7;
        return true;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (o.a(this.f11756d, ((b) r2).f11756d) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final void f(com.ss.android.account.group_onekey.d.b r1) {
    }

    public int hashCode() {
        String r0 = this.f11756d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "GetTokenCache(clientPkg=" + this.f11756d + ")";
    }
}
