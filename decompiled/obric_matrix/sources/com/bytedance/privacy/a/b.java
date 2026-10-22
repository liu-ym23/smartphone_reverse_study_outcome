package com.bytedance.privacy.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(int r6, int r7, String r8, String r9, long r10, a r12) {
        if (r6 != 0) goto L4;
        d.b.t.a.a.b.a(1, r7, r8, r9, r10);
        return;
    L4:
        d.b.t.a.a.c.a.b r11 = d.b.t.a.a.c.a.f();
        r11.f(r12.c(a.c.f5351f));
        r11.d(r12.c(a.c.f5352g));
        r11.e(r12.c(a.c.f5353h));
        r11.b(!TextUtils.isEmpty(r12.a()));
        r11.c(r12.b());
        d.b.t.a.a.a.a(1, r7, r8, r9, r6, r11.a());
    }
}
