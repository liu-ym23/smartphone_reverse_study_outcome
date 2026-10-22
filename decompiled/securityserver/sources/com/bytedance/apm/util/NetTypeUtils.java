package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetTypeUtils {
    public static final boolean DEBUG_MOBILE = false;

    public NetTypeUtils() {
    }

    public static NetworkUtils.NetworkType getNetworkType(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r0 == null) goto L23;
        if (r0.isAvailable() == false) goto L23;
        int r1 = r0.getType();     // Catch: Throwable -> L24
        if (1 == r1) goto L10;
        if (r1 != 0) goto L21;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 3: goto L19;
            case 4: goto L15;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L15;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L15;
        };     // Catch: Throwable -> L24
    L15:
        return NetworkUtils.NetworkType.MOBILE;
    L17:
        return NetworkUtils.NetworkType.MOBILE_4G;
    L19:
        return NetworkUtils.NetworkType.MOBILE_3G;
    L21:
        return NetworkUtils.NetworkType.MOBILE;
    L10:
        return NetworkUtils.NetworkType.WIFI;
    L23:
        return NetworkUtils.NetworkType.NONE;
    L25:
        return NetworkUtils.NetworkType.MOBILE;
    }
}
