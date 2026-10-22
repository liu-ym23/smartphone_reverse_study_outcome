package com.bytedance.badger.k;

import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final String a(List<u<String, String>> r3, String r4, boolean r5) {
        o.g(r3, "$this$getFirst");
        o.g(r4, "key");
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (k.o((String) ((u) r0).c(), r4, r5) == false) goto L4;
    L9:
        u r1 = (u) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return (String) r1.d();
    L8:
        r0 = null;
        goto L9
    }

    public static /* synthetic */ String b(List r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return a(r0, r1, r2);
    }
}
