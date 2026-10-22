package com.bytedance.apm.o.a;

import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Object r3, boolean r4) {
        if ((r3 instanceof String) == false) goto L5;
        String r0 = (String) r3;
    L6:
        JSONObject r1 = new JSONObject();
        if ((r3 instanceof a) == false) goto L10;
        r1.put("label", ((a) r3).a());     // Catch: Exception -> L19
    L10:
        if (r4 == false) goto L12;
        String r5 = "page_show";
    L13:
        if (r4 == true) goto L15;
    L17:
        com.bytedance.apm.o.b.a.c(r5, r0, r1);
        return;
    L15:
        if (ApmDelegate.k().i().m() == null) goto L17;
        ApmDelegate.k().i().m().a(r0, true);
        goto L17
    L12:
        r5 = "page_hide";
        goto L13
    L5:
        r0 = r3.getClass().getName();
        goto L6
    }
}
