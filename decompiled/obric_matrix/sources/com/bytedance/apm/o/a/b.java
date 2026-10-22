package com.bytedance.apm.o.a;

import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Object r3, boolean r4) {
        if (com.bytedance.apm.o.c.a.f1673a == true) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == false) goto L8;
        String r0 = (String) r3;
    L9:
        JSONObject r1 = new JSONObject();
        if ((r3 instanceof a) == false) goto L13;
        r1.put("label", ((a) r3).a());     // Catch: Exception -> L22
    L13:
        if (r4 == false) goto L15;
        String r5 = "page_show";
    L16:
        if (r4 == true) goto L18;
    L20:
        com.bytedance.apm.o.b.a.c(r5, r0, r1);
        return;
    L18:
        if (ApmDelegate.k().i().m() == null) goto L20;
        ApmDelegate.k().i().m().a(r0, true);
        goto L20
    L15:
        r5 = "page_hide";
        goto L16
    L8:
        r0 = r3.getClass().getName();
        goto L9
    }
}
