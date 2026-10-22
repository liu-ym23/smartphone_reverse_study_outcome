package com.bytedance.badger.j;

import android.util.Base64;
import java.util.ArrayList;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final String a(String r5) {
        o.g(r5, "$this$deObfs");
        byte[] r6 = Base64.decode(r5, 2);
        o.b(r6, "Base64.decode(this, Base64.NO_WRAP)");
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Byte.valueOf(kotlin.o.a(r6[r2], 3)));
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r.v0(r0), kotlin.u0.d.f21429a);
    }
}
