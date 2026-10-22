package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class j1 {
    @VisibleForTesting
    public static final String a(Context r9) {
        if (r9 != null) goto L6;
        return "";
    L6:
        String r1 = null;
        boolean r2 = false;
        ProviderInfo[] r3 = r9.getPackageManager().getPackageInfo(r9.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r4 = r3.length;     // Catch: Exception -> L14
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L16;
        ProviderInfo r6 = r3[r5];     // Catch: Exception -> L14
        if (TextUtils.equals(r6.name, TicketGuardProvider.class.getName()) == true) goto L11;
        r5 = r5 + 1;
        goto L8
    L11:
        r1 = r6.authority;     // Catch: Exception -> L14
    L16:
        if (r1 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        r1 = r9.getPackageName() + ".TicketGuardProvider";
    L22:
        s0.f1065a.a("TicketGuardProvider", "getProviderAuthority, authority=" + r1);
        return r1;
    L18:
        if (r1.length() != 0) goto L20;
    L14:
        e = move-exception;
        s0.f1065a.c("TicketGuardProvider", "get authority failed", e);
        goto L16
    }
}
