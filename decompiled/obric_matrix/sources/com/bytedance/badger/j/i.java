package com.bytedance.badger.j;

import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final String a(String r14) {
        o.g(r14, "$this$getPathFast");
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L30:
        return null;
    L9:
        if (k.A(r14, "http://", false, 2, null) == false) goto L11;
    L13:
        int r3 = k.Q(r14, "://", 0, false, 6, null) + 3;
        if (r3 < r14.length()) goto L16;
        return "";
    L16:
        int r1 = k.P(r14, '/', r3, false, 4, null);
        if (r1 != (-1)) goto L19;
        return "";
    L19:
        int r2 = k.P(r14, '?', r1, false, 4, null);
        int r4 = k.P(r14, '#', r1, false, 4, null);
        if (r2 == (-1)) goto L23;
        if (r4 == (-1)) goto L23;
        r2 = Math.min(r2, r4);
    L28:
        String r15 = r14.substring(r1, r2);
        o.b(r15, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r15;
    L23:
        if (r2 != (-1)) goto L28;
        if (r4 == (-1)) goto L27;
        r2 = r4;
        goto L28
    L27:
        r2 = r14.length();
        goto L28
    L11:
        if (k.A(r14, "https://", false, 2, null) == true) goto L13;
    L5:
        r0 = false;
        goto L7
    }
}
