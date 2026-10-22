package com.bytedance.bdinstall.c1;

import android.content.Context;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.r;

/* JADX INFO: loaded from: classes.dex */
class e {
    static k a(Context r2, r r3, i0 r4) {
        if (r3.f() == false) goto L5;
        String r0 = "dp";
    L6:
        String r1 = com.bytedance.bdinstall.d1.h.b(r0, r3);
        if (r4.S() == false) goto L9;
        r1 = r1 + "_local";
    L9:
        k r5 = new k();
        r5.k(r1 + ".dat");
        r5.o(r3.c(r2));
        r5.j(r4.M());
        r5.l(r4.S());
        r5.i(r4.g(), com.bytedance.bdinstall.d1.h.b("", r3));
        r5.m(r4.T());
        r5.n(r4);
        return r5;
    L5:
        r0 = "device_parameters";
        goto L6
    }
}
