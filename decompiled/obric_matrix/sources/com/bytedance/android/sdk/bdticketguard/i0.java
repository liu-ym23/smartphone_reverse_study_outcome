package com.bytedance.android.sdk.bdticketguard;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<t0> f809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f810c;

    public i0(String r2, List<t0> r3, Map<String, String> r4) {
        kotlin.n0.d.o.g(r2, "requestType");
        kotlin.n0.d.o.g(r3, "headers");
        kotlin.n0.d.o.g(r4, "bodyParams");
        this.f808a = r2;
        this.f809b = r3;
        this.f810c = r4;
    }

    public /* synthetic */ i0(String r1, List r2, Map r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = kotlin.i0.r.g();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = kotlin.i0.m0.h();
    L8:
        this(r1, r2, r3);
    }

    public final Map<String, String> a() {
        return this.f810c;
    }

    public final List<t0> b() {
        return this.f809b;
    }

    public final String c() {
        return this.f808a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i0) == false) goto L12;
        i0 r4 = (i0) r3;
        if (kotlin.n0.d.o.a(this.f808a, r4.f808a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f809b, r4.f809b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f810c, r4.f810c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.f808a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<t0> r4 = this.f809b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.f810c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RequestParams(requestType=" + this.f808a + ", headers=" + this.f809b + ", bodyParams=" + this.f810c + ")";
    }
}
