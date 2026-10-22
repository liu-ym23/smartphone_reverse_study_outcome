package com.bytedance.apm6.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.android.settings.MultiSimAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class NetUtils {
    public static final int NET_DEFAULT = -10000;

    public NetUtils() {
    }

    public static boolean isNetworkTrulyAvailable(Context r2) {
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");     // Catch: Exception -> L12
        if (r3 == null) goto L6;
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Exception -> L12
    L7:
        if (r4 == null) goto L15;
        if (r4.isConnected() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L6:
        r4 = null;
    L17:
        return false;
    }

    public static int getMobileNetworkType(Context r3) {
        ConnectivityManager r1 = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L16
        if (ContextCompat.checkSelfPermission(r3, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Throwable -> L16
    L7:
        if (r2 == null) goto L15;
        if (r2.isAvailable() == false) goto L15;
        if (r2.getType() != 0) goto L15;
        return ((TelephonyManager) r3.getSystemService(MultiSimAdapter.PHONE_KEY)).getNetworkType();
    L6:
        r2 = null;
    L15:
        return -10000;
    }
}
