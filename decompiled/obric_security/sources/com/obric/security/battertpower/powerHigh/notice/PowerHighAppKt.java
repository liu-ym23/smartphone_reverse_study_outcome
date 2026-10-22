package com.obric.security.battertpower.powerHigh.notice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PowerHighApp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"parseLogString", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "logStr", "", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class PowerHighAppKt {
    public static final PowerHighApp parseLogString(String r20) {
        String r1 = "";
        Intrinsics.checkNotNullParameter(r20, "logStr");
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r0 = StringsKt.split$default(r20, new String[]{" "}, false, 0, 6, null).iterator();
    L3:
        int r4 = 0;
        if (r0.hasNext() == true) goto L21;
        String r3 = (String) r2.get("uid");     // Catch: Exception -> L18
        if (r3 == null) goto L11;
        r4 = Integer.parseInt(r3);     // Catch: Exception -> L18
    L11:
        String r5 = (String) r2.get("pkgName");     // Catch: Exception -> L18
        if (r5 == null) goto L15;
        r1 = r5;
    L15:
        int r7 = r4;
        return new PowerHighApp(null, r7, r1, null, null, null, null, null, null, null, null, true, 2041, null);
    L21:
        List r6 = StringsKt.split$default((String) r0.next(), new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L17
        r2.put((String) r6.get(0), (String) r6.get(1));     // Catch: Exception -> L17
        goto L3
    }
}
