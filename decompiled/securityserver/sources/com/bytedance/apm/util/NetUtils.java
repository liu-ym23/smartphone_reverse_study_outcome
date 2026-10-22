package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetUtils {
    public static final boolean DEBUG_MOBILE = false;
    public static final int NET_DEFAULT = -10000;
    private static NetworkUtils.NetworkType sNetworkType;
    private static NetworkUtils.NetworkTypeInterceptor sNetworkTypeInterceptor;

    static {
        sNetworkType = NetworkUtils.NetworkType.UNKNOWN;
    }

    public NetUtils() {
    }

    public static int getMobileNetworkType(Context r4) {
        ConnectivityManager r1 = (ConnectivityManager) r4.getSystemService("connectivity");     // Catch: Throwable -> L16
        if (ContextCompat.checkSelfPermission(ApmContext.getContext(), "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Throwable -> L16
    L7:
        if (r2 == null) goto L15;
        if (r2.isAvailable() == false) goto L15;
        if (r2.getType() != 0) goto L15;
        return ((TelephonyManager) r4.getSystemService("phone")).getNetworkType();
    L6:
        r2 = null;
    L15:
        return -10000;
    }

    public static boolean isNetworkAvailable(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isWifi(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) r4.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        NetworkUtils.NetworkTypeInterceptor r1 = sNetworkTypeInterceptor;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.getNetworkType() == NetworkUtils.NetworkType.NONE) goto L17;
        if (sNetworkTypeInterceptor.getNetworkType() == NetworkUtils.NetworkType.WIFI) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r5.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static void setNetworkType(NetworkUtils.NetworkType r0) {
        sNetworkType = r0;
    }

    public static void setNetworkTypeInterceptor(NetworkUtils.NetworkTypeInterceptor r0) {
        sNetworkTypeInterceptor = r0;
    }
}
