package com.bytedance.bdlocation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtil {
    public NetworkUtil() {
    }

    public static boolean checkVPN(Context r6) {
        ConnectivityManager r7 = (ConnectivityManager) r6.getSystemService("connectivity");     // Catch: Throwable -> L20
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L20
        if (r1 < 23) goto L10;
        NetworkCapabilities r8 = r7.getNetworkCapabilities(r7.getActiveNetwork());     // Catch: Throwable -> L20
        if (r8 != null) goto L8;
    L22:
        return false;
    L8:
        return r8.hasTransport(4);
    L10:
        if (r1 < 21) goto L22;
        Network[] r2 = r7.getAllNetworks();     // Catch: Throwable -> L20
        int r3 = r2.length;     // Catch: Throwable -> L20
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L22;
        NetworkCapabilities r5 = r7.getNetworkCapabilities(r2[r4]);     // Catch: Throwable -> L20
        if (r5 == null) goto L19;
        if (r5.hasTransport(4) == false) goto L19;
        return true;
    L19:
        r4 = r4 + 1;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    }

    public static boolean isWifiProxy(Context r4) {
    L17:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (Build.VERSION.SDK_INT < 14) goto L10;
        String r5 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L17
        String r1 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
        r1 = "-1";
    L9:
        int r2 = Integer.parseInt(r1);     // Catch: Throwable -> L17
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return false;
    L14:
        if (r2 == (-1)) goto L23;
        return true;
    L23:
        return false;
    L10:
        String r3 = Proxy.getHost(r4);     // Catch: Throwable -> L17
        r2 = Proxy.getPort(r4);     // Catch: Throwable -> L17
        r5 = r3;
        goto L11
    }
}
