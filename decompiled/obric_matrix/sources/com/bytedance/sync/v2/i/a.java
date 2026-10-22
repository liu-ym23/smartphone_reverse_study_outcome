package com.bytedance.sync.v2.i;

import com.bytedance.sync.v2.f.k;
import java.util.Set;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bytedance.sync.v2.f.c {
    public a() {
    }

    @Override // com.bytedance.sync.v2.f.c
    public void B(Set<String> r3) {
        o.g(r3, "pendingRetryPollSyncId");
        k.a.a((k) com.ss.android.ug.bus.b.a(k.class), false, 1, null);
    }

    @Override // com.bytedance.sync.v2.f.c
    public boolean C(String r3, boolean r4) {
        o.g(r3, "syncId");
        d.b.u.w.c r2 = (d.b.u.w.c) com.ss.android.ug.bus.b.a(d.b.u.w.c.class);
        if (r4 == false) goto L6;
        r2.j0(Long.parseLong(r3));
    L6:
        return ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).U(r3);
    }
}
