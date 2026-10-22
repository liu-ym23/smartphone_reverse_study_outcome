package com.ss.ttuploader.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes2.dex */
public class NetUtils {
    public static final int NETTYPE_UNKNOWN = -1;

    public NetUtils() {
    }

    public static String getNetExtraInfo(Context r2) {
        NetworkInfo r3 = getNetworkInfo(r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        if (r3.isAvailable() == false) goto L9;
        return r3.getExtraInfo();
    L9:
        return null;
    }

    public static int getNetType(Context r2) {
        NetworkInfo r3 = getNetworkInfo(r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        if (r3.isAvailable() == false) goto L9;
        return r3.getType();
    L9:
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context r1) {
        return ((ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        return null;
    }
}
