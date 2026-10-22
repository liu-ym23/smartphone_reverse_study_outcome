package com.bytedance.sync.v2.k;

import com.bytedance.sync.v2.f.h;
import com.bytedance.sync.v2.i.d;
import com.bytedance.sync.v2.j.f;
import com.bytedance.sync.v2.j.j;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d<j> {
    public c() {
    }

    @Override // com.bytedance.sync.v2.i.d
    public /* bridge */ /* synthetic */ boolean a(j r1) {
        return c(r1);
    }

    @Override // com.bytedance.sync.v2.i.d
    public void b(com.bytedance.sync.v2.j.b r5, List<f> r6) {
        o.g(r5, "header");
        o.g(r6, "topics");
        com.bytedance.sync.v2.f.b r4 = (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        f r8 = (f) r7.next();
        Long r0 = r8.f6077i;     // Catch: Exception -> L8
        o.b(r0, "it.sync_id");     // Catch: Exception -> L8
        long r1 = r0.longValue();     // Catch: Exception -> L8
        Long r9 = r8.f6079k;     // Catch: Exception -> L8
        o.b(r9, "it.new_cursor");     // Catch: Exception -> L8
        r4.i(r1, r9.longValue());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        ((h) com.ss.android.ug.bus.b.a(h.class)).d0();
    }

    public boolean c(j r1) {
        o.g(r1, "flag");
        if (r1 != j.f6108h) goto L5;
        return true;
    L5:
        return false;
    }
}
