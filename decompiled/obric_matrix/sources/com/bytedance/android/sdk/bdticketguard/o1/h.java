package com.bytedance.android.sdk.bdticketguard.o1;

import android.util.Base64;
import java.security.Key;
import java.util.Arrays;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final String a(Key r1) {
        o.g(r1, "key");
        return Base64.encodeToString(r1.getEncoded(), 0);
    }

    public static final String b(String r3, String r4, String r5, String r6) {
        o.g(r3, "commonName");
        o.g(r4, "organizationUnit");
        o.g(r5, "organization");
        o.g(r6, "country");
        i0 r0 = i0.f18445a;
        String r7 = String.format("CN=%s, OU=%s, O=%s, C=%s", Arrays.copyOf(new Object[]{r3, r4, r5, r6}, 4));
        o.b(r7, "java.lang.String.format(format, *args)");
        return r7;
    }
}
