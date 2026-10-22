package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static int a(@NonNull Context r2) {
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");
        if (r3 != null) goto L5;
        return 0;
    L5:
        NetworkInfo r1 = r3.getActiveNetworkInfo();
        if (r1 != null) goto L8;
    L21:
        return 0;
    L8:
        if (r1.isAvailable() == false) goto L21;
        NetworkInfo r4 = r3.getNetworkInfo(1);
        if (r4 == null) goto L19;
        NetworkInfo.State r5 = r4.getState();
        if (r5 != null) goto L15;
        return 6;
    L15:
        if (r5 != NetworkInfo.State.CONNECTED) goto L17;
    L18:
        return 1;
    L17:
        if (r5 == NetworkInfo.State.CONNECTING) goto L18;
        return 6;
    L19:
        return 6;
    }

    public static String b(@NonNull Context r1) {
        int r2 = a(r1);
        if (r2 != 0) goto L5;
        return "None network";
    L5:
        if (r2 != 1) goto L7;
        return "Wifi";
    L7:
        if (r2 != 2) goto L9;
        return "2G";
    L9:
        if (r2 != 3) goto L11;
        return "3G";
    L11:
        if (r2 != 4) goto L13;
        return "4G";
    L13:
        if (r2 == 5) goto L16;
        return "Unknown";
    L16:
        return "Mobile network";
    }

    public static boolean c(@NonNull Context r2) {
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.getApplicationContext() != null) goto L8;
        return true;
    L8:
        if (a(r2) == 0) goto L14;
        return false;
    L14:
        return true;
    }
}
