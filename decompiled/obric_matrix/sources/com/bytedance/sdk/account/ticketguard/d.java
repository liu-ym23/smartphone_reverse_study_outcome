package com.bytedance.sdk.account.ticketguard;

import com.bytedance.android.sdk.bdticketguard.t0;
import com.bytedance.android.sdk.bdticketguard.u0;
import com.bytedance.android.sdk.bdticketguard.w;
import d.b.s.a.l0.l;
import d.b.s.a.l0.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements w {
    public d() {
    }

    @Override // com.bytedance.android.sdk.bdticketguard.w
    public u0 a(int r1, String r2, Map<String, String> r3, List<t0> r4) {
        List r0 = o.b(r4);
        if (r3 != null) goto L5;
        r3 = new HashMap();
    L5:
        if (r0 != null) goto L7;
        r0 = new ArrayList();
    L7:
        com.ss.android.h r5 = l.d(r1, r2, r3, r0, 0);
        if (r5 == null) goto L11;
        List<t0> r6 = o.a(r5.b());
        return new u0(r5.e(), r5.c(), r6, r5.a());
    L11:
        return null;
    }
}
