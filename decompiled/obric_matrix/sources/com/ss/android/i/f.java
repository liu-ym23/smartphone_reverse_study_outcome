package com.ss.android.i;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static com.ss.android.i.k.b a() {
        com.ss.android.i.k.b r0 = j.k().i();
        if (r0 == null) goto L14;
        if (r0.b() == false) goto L7;
        d.b.s.a.a0.a.h("BdTruingInitHelper", "force disable IBdTruing is not recommend");
    L12:
        return r0;
    L7:
        if (r0.init(j.k().e()) == true) goto L12;
        throw new RuntimeException("please implement IBdTruing interface correctly");
    L14:
        throw new RuntimeException("please provide IBdTruing implementation");
    }
}
