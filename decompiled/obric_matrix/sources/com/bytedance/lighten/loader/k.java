package com.bytedance.lighten.loader;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class k implements d.b.k.a.c {
    k() {
    }

    @Override // d.b.k.a.c
    public File a(Uri r2) {
        d.c.i.q.b r1 = d.c.i.q.b.a(r2);
        d.c.b.a.d r3 = d.c.i.e.j.h().e(r1, null);
        d.c.a.a r4 = d.c.f.a.a.c.b().q().c(r3);
        if (r4 != null) goto L6;
        r4 = d.c.f.a.a.c.b().w().c(r3);
    L6:
        if ((r4 instanceof d.c.a.b) == false) goto L12;
        File r5 = ((d.c.a.b) r4).c();
        if (r5 == null) goto L12;
        if (r5.exists() == false) goto L12;
        return r5;
    L12:
        return null;
    }

    @Override // d.b.k.a.c
    public boolean b(Uri r2) {
        d.c.i.q.b r1 = d.c.i.q.b.a(r2);
        d.c.b.a.d r3 = d.c.i.e.j.h().e(r1, null);
        if (d.c.i.g.j.o().q().g(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (d.c.i.g.j.o().w().g(r3) == true) goto L8;
        return false;
    }
}
