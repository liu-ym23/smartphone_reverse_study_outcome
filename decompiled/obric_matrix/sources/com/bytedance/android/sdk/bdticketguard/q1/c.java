package com.bytedance.android.sdk.bdticketguard.q1;

import android.os.SystemClock;
import android.util.Base64;
import java.util.Arrays;
import kotlin.a0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final boolean a(String r1, String r2) {
        o.g(r1, "str1");
        o.g(r2, "str2");
        byte[] r3 = Base64.decode(r1, 0);     // Catch: Exception -> L11
        byte[] r4 = Base64.decode(r2, 0);     // Catch: Exception -> L11
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        return Arrays.equals(r3, r4);
    L10:
        return false;
    }

    public static final <T> u<T, Long> b(kotlin.n0.c.a<? extends T> r4) {
        o.g(r4, "block");
        long r0 = SystemClock.elapsedRealtime();
        return a0.a(r4.invoke(), Long.valueOf(SystemClock.elapsedRealtime() - r0));
    }
}
