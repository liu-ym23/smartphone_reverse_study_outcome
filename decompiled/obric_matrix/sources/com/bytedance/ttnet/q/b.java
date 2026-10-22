package com.bytedance.ttnet.q;

import d.b.h.a.a.h.d;
import d.b.r.h0.c;
import d.b.r.h0.e;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.b.r.h0.a {
    public b() {
    }

    @Override // d.b.r.h0.a
    public e a(c r2) {
        if ((r2.t() instanceof d.b.h.a.a.h.c) == false) goto L5;
        boolean r1 = ((d.b.h.a.a.h.c) r2.t()).f13376k;
    L6:
        d r3 = com.bytedance.ttnet.d.b(r2.G(), r1);
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.a(r2);
    L5:
        r1 = false;
        goto L6
    }
}
