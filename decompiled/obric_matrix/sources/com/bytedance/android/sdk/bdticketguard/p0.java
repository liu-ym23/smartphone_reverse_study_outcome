package com.bytedance.android.sdk.bdticketguard;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat f1011a = null;

    static {
        f1011a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }

    public static final SimpleDateFormat a() {
        return f1011a;
    }

    public static final String b(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return String.valueOf(r6);
    L13:
        if (r6.length() < 30) goto L23;
        StringBuilder r2 = new StringBuilder();
        if (r6 == null) goto L22;
        String r0 = r6.substring(0, 10);
        kotlin.n0.d.o.b(r0, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r2.append(r0);
        r2.append("*****");
        int r3 = r6.length() - 10;
        int r4 = r6.length();
        if (r6 == null) goto L20;
        String r7 = r6.substring(r3, r4);
        kotlin.n0.d.o.b(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r2.append(r7);
        return r2.toString();
    L20:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L22:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L23:
        return "*****";
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
