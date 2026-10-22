package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class j {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f3775f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f3776g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f3777h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f3778i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f3779j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f3780k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ a[] f3781l = null;

        static {
            a r0 = new a("NONE", 0, 0);
            f3775f = r0;
            a r1 = new a("MOBILE", 1, 1);
            f3776g = r1;
            a r3 = new a("MOBILE_2G", 2, 2);
            f3777h = r3;
            a r5 = new a("MOBILE_3G", 3, 3);
            f3778i = r5;
            a r7 = new a("WIFI", 4, 4);
            f3779j = r7;
            a r9 = new a("MOBILE_4G", 5, 5);
            f3780k = r9;
            f3781l = new a[]{r0, r1, r3, r5, r7, r9};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f3781l.clone();
        }
    }

    static int a(Context r1) {
        boolean r0 = c(r1);
        a r2 = b(r1);
        if (r0 == true) goto L6;
        return 2;
    L6:
        if (a.f3779j != r2) goto L9;
        return 3;
    L9:
        if (a.f3775f == r2) goto L11;
        return 4;
    L11:
        return 1;
    }

    public static a b(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r0 == null) goto L46;
        if (r0.isAvailable() == false) goto L46;
        int r1 = r0.getType();     // Catch: Throwable -> L47
        if (1 == r1) goto L10;
        if (r1 != 0) goto L44;
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService("phone");     // Catch: Throwable -> L47
        if (r3 != null) goto L17;
        return a.f3776g;
    L17:
        if (r3.getNetworkType() == 3) goto L42;
        if (r3.getNetworkType() == 5) goto L42;
        if (r3.getNetworkType() == 6) goto L42;
        if (r3.getNetworkType() == 8) goto L42;
        if (r3.getNetworkType() == 9) goto L42;
        if (r3.getNetworkType() == 10) goto L42;
        if (r3.getNetworkType() == 12) goto L42;
        if (r3.getNetworkType() == 14) goto L42;
        if (r3.getNetworkType() == 15) goto L42;
        if (r3.getNetworkType() != 13) goto L40;
        return a.f3780k;
    L40:
        return a.f3776g;
    L42:
        return a.f3778i;
    L44:
        return a.f3776g;
    L10:
        return a.f3779j;
    L46:
        return a.f3775f;
    L48:
        return a.f3776g;
    }

    public static boolean c(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
