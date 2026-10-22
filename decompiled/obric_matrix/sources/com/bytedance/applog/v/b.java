package com.bytedance.applog.v;

import com.bytedance.applog.m;
import com.bytedance.applog.o.e;
import com.bytedance.bdinstall.m0;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String[] a(e r7, boolean r8, com.bytedance.applog.s.b r9) {
        m r0 = r7.z();
        if (r8 == false) goto L5;
        String[] r10 = r0.e();
    L6:
        if (r9 == null) goto L12;
        String[] r11 = r9.g(r10, "/service/2/app_log/");
        if (r11 == null) goto L12;
        if (r11.length <= 0) goto L12;
        r10 = r11;
    L12:
        int r12 = r10.length;
        String[] r1 = new String[r12];
        boolean r2 = com.bytedance.applog.a.n();
        int r3 = 0;
    L13:
        if (r3 >= r12) goto L18;
        r1[r3] = r10[r3];
        if (r2 == false) goto L17;
        r1[r3] = r1[r3] + "?tt_data=a";
    L17:
        r1[r3] = com.bytedance.applog.a.b(r7.r(), r1[r3], true, m0.f2843g);
        r1[r3] = a.f(r1[r3], a.f2437c);
        r3 = r3 + 1;
        goto L13
    L18:
        return r1;
    L5:
        r10 = r0.f();
        goto L6
    }
}
