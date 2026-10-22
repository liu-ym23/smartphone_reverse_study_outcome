package com.bytedance.bdinstall.c1;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.r;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    @SuppressLint({"VisibleForTests"})
    public static void b(Context r1, r r2, i0 r3) {
        k r4 = e.a(r1, r2, r3);
        if (r2.f() == true) goto L5;
        com.bytedance.bdinstall.b1.a r5 = new c(r1, r4);
    L6:
        com.bytedance.bdinstall.b1.c r6 = (com.bytedance.bdinstall.b1.c) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.c.class);
        if (r6 == null) goto L9;
        r5 = (com.bytedance.bdinstall.b1.a) r6.b(com.bytedance.bdinstall.b1.a.class, r5);
    L9:
        com.bytedance.bdinstall.b1.e.b(com.bytedance.bdinstall.b1.a.class, r5);
        return;
    L5:
        r5 = new g(r1, r4);
        goto L6
    }
}
