package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r2 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r2;
            NetworkType r3 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r3;
            NetworkType r4 = new NetworkType("WIFI", 4, 4);
            WIFI = r4;
            NetworkType r5 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r5;
            $VALUES = new NetworkType[]{r0, r1, r2, r3, r4, r5};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public NetworkUtils() {
    }

    public static int getNetworkState(Context r1) {
        boolean r0 = isNetworkAvailable(r1);
        NetworkType r2 = getNetworkType(r1);
        if (r0 == true) goto L6;
        return 2;
    L6:
        if (NetworkType.WIFI != r2) goto L9;
        return 3;
    L9:
        if (NetworkType.NONE == r2) goto L11;
        return 4;
    L11:
        return 1;
    }

    public static NetworkType getNetworkType(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r0 == null) goto L46;
        if (r0.isAvailable() == false) goto L46;
        int r1 = r0.getType();     // Catch: Throwable -> L47
        if (1 == r1) goto L10;
        if (r1 != 0) goto L44;
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService("phone");     // Catch: Throwable -> L47
        if (r3 != null) goto L17;
        return NetworkType.MOBILE;
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
        return NetworkType.MOBILE_4G;
    L40:
        return NetworkType.MOBILE;
    L42:
        return NetworkType.MOBILE_3G;
    L44:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L46:
        return NetworkType.NONE;
    L48:
        return NetworkType.MOBILE;
    }

    public static boolean isNetworkAvailable(Context r2) {
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
