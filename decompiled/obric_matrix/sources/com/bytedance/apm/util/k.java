package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static com.bytedance.common.utility.i.a a(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r0 == null) goto L22;
        if (r0.isAvailable() == false) goto L22;
        int r1 = r0.getType();     // Catch: Throwable -> L23
        if (1 == r1) goto L10;
        if (r1 != 0) goto L20;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return com.bytedance.common.utility.i.a.f3285i;
    L16:
        return com.bytedance.common.utility.i.a.m;
    L18:
        return com.bytedance.common.utility.i.a.f3287k;
    L20:
        return com.bytedance.common.utility.i.a.f3285i;
    L10:
        return com.bytedance.common.utility.i.a.f3288l;
    L22:
        return com.bytedance.common.utility.i.a.f3284h;
    L24:
        return com.bytedance.common.utility.i.a.f3285i;
    }
}
