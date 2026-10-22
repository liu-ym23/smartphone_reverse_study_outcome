package com.bytedance.framwork.core.sdklib.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static boolean sIsReceiverRegisted;
    private static NetworkType sNetworkType;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r2 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r2;
            $VALUES = new CompressType[]{r0, r1, r2};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType(NetworkStackConstant.UNKNOWN_TYPE, 0, -1);
            UNKNOWN = r0;
            NetworkType r1 = new NetworkType("NONE", 1, 0);
            NONE = r1;
            NetworkType r2 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r2;
            NetworkType r3 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r3;
            NetworkType r4 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r4;
            NetworkType r5 = new NetworkType("WIFI", 5, 4);
            WIFI = r5;
            NetworkType r6 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r6;
            $VALUES = new NetworkType[]{r0, r1, r2, r3, r4, r5, r6};
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

        public boolean is2G() {
            if (this != MOBILE) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_2G) goto L8;
            return false;
        }

        public boolean isAvailable() {
            if (this != UNKNOWN) goto L5;
        L7:
            return false;
        L5:
            if (this == NONE) goto L7;
            return true;
        }

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    static {
        sNetworkType = NetworkType.UNKNOWN;
        sIsReceiverRegisted = false;
    }

    public NetUtils() {
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(List<Pair<String, String>> r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, String>> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Pair<String, String> r1 = r6.next();
        String r2 = encode((String) r1.first, r5);
        String r3 = (String) r1.second;
        if (r3 == null) goto L8;
        String r7 = encode(r3, r5);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(PARAMETER_SEPARATOR);
    L12:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r7);
        goto L4
    L8:
        r7 = "";
        goto L10
    L14:
        return r0.toString();
    }

    public static String getNetworkAccessType(NetworkType r1) {
        if (r1 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r1 != NetworkType.MOBILE_2G) goto L9;
        return "2g";
    L9:
        if (r1 != NetworkType.MOBILE_3G) goto L12;
        return "3g";
    L12:
        if (r1 != NetworkType.MOBILE_4G) goto L15;
        return "4g";
    L15:
        if (r1 != NetworkType.MOBILE) goto L17;
        return "mobile";
    L17:
        return "";
    }

    public static NetworkType getNetworkType(Context r2) {
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
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L23:
        return NetworkType.NONE;
    L25:
        return NetworkType.MOBILE;
    }

    public static boolean is2G(Context r1) {
        NetworkType r2 = getNetworkType(r1);
        if (r2 != NetworkType.MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (r2 == NetworkType.MOBILE_2G) goto L8;
        return false;
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
        NetworkTypeInterceptor r1 = sNetworkTypeInterceptor;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.getNetworkType() == NetworkType.NONE) goto L17;
        if (sNetworkTypeInterceptor.getNetworkType() == NetworkType.WIFI) goto L15;
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

    public static void setNetworkType(NetworkType r0) {
        sNetworkType = r0;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r0) {
        sNetworkTypeInterceptor = r0;
    }
}
