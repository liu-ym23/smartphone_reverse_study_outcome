package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.utility.i.b f2052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.apm.net.a f2053b;

    static {
        com.bytedance.common.utility.i.a r0 = com.bytedance.common.utility.i.a.f3283g;
    }

    public static HttpURLConnection a(String r1) {
        com.bytedance.apm.net.a r0 = f2053b;
        if (r0 != null) goto L6;
        return (HttpURLConnection) new URL(r1).openConnection();
    L6:
        return r0.a(r1);
    }

    public static boolean b(Context r2) {
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

    public static boolean c(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) r4.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        com.bytedance.common.utility.i.b r1 = f2052a;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.a() == com.bytedance.common.utility.i.a.f3284h) goto L17;
        if (f2052a.a() == com.bytedance.common.utility.i.a.f3288l) goto L15;
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

    public static void d(com.bytedance.apm.net.a r0) {
        f2053b = r0;
    }
}
