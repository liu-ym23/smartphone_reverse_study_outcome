package com.bytedance.frameworks.baselib.network.http.cronet.e;

import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.r.l0.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4723l;
    private final int m;

    public e(Exception r10, d.b.h.a.a.h.b r11, int r12) {
        String r0 = r10.getMessage();
        if (r10.getCause() != null) goto L5;
        Throwable r1 = r10;
    L6:
        super(r0, r1);
        URL r2 = r11.f13354a;
        if (r2 == null) goto L9;
        String r3 = r2.toString();
    L10:
        super.a(true, false, true, r3, r11.Z, r11);
        this.m = r12;
        if ((r10 instanceof d.b.h.a.a.h.l.d) == false) goto L14;
        this.f4723l = ((d.b.h.a.a.h.l.d) r10).c();
        return;
    L14:
        return;
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = r10.getCause();
        goto L6
    }

    public int b() {
        return this.m;
    }

    public d.b.h.a.a.h.b c() {
        return (d.b.h.a.a.h.b) this.f14474k;
    }

    public String d() {
        return c().E;
    }

    public int e() {
        return this.f4723l;
    }
}
