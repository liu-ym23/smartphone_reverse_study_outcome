package com.ss.android.account.share.data.read;

import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11790f;

    public b(String r2, boolean r3, String r4, int r5) {
        o.g(r2, "fromPkg");
        o.g(r4, "errorMsg");
        this.f11787c = r2;
        this.f11788d = r3;
        this.f11789e = r4;
        this.f11790f = r5;
        this.f11785a = "";
        this.f11786b = "";
    }

    public /* synthetic */ b(String r2, boolean r3, String r4, int r5, int r6, g r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public final String a() {
        return this.f11789e;
    }

    public final String b() {
        return this.f11787c;
    }

    public final int c() {
        return this.f11790f;
    }

    public final String d() {
        return this.f11786b;
    }

    public final boolean e() {
        return this.f11788d;
    }

    public final void f(String r2) {
        o.g(r2, "<set-?>");
        this.f11785a = r2;
    }

    public final void g(int r1) {
        this.f11790f = r1;
    }

    public final void h(String r2) {
        o.g(r2, "<set-?>");
        this.f11786b = r2;
    }

    public String toString() {
        return "ReadResult(isSuccess=" + this.f11788d + ", errorMsg='" + this.f11789e + "', readType=" + this.f11790f + ", fromPkg='" + this.f11787c + "', key='" + this.f11785a + "', value='" + this.f11786b + "')";
    }
}
