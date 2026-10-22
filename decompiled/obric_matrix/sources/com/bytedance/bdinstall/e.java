package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class e {
    static void a(Context r3, i0 r4, StringBuilder r5) {
        if (r4.V() == true) goto L15;
        d.b(r5, "build_serial", com.bytedance.bdinstall.d1.m.g(r3, r4));
        if (r4.W() == false) goto L15;
        String[] r6 = com.bytedance.bdinstall.d1.m.h(r3, r4);
        if (r6 == null) goto L15;
        if (r6.length <= 0) goto L15;
        String r0 = r6[0];
        int r1 = 1;
    L12:
        if (r1 >= r6.length) goto L14;
        r0 = r0 + "," + r6[r1];
        r1 = r1 + 1;
        goto L12
    L14:
        d.b(r5, "sim_serial_number", r0);
    L15:
        com.bytedance.bdinstall.a1.b.l(r3).j();
    }

    public static void b(boolean r0, Context r1) {
        if (r0 == true) goto L4;
        return;
    L4:
        if (i.g().b() == false) goto L8;
        com.bytedance.bdinstall.a1.b.l(r1).k();
        return;
    }

    static void c(Context r2, Map<String, String> r3, boolean r4, i0 r5) {
        if (r5 != null) goto L4;
    L11:
        String r6 = com.bytedance.bdinstall.z0.a.e().a();
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r3.put("aliyun_uuid", r6);
    L14:
        if (r4 == false) goto L22;
        String r7 = com.bytedance.bdinstall.a1.b.l(r2).j();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r7) == true) goto L23;
        r3.put("oaid", r7);     // Catch: Throwable -> L19
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L4:
        if (r5.V() == true) goto L11;
        String r0 = com.bytedance.bdinstall.d1.m.e(r2);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r3.put("mac_address", r0);
    L8:
        String r8 = com.bytedance.bdinstall.d1.m.d(r2, r5);
        if (v0.i(r8) == true) goto L11;
        r3.put("uuid", r8);
        goto L11
    }
}
