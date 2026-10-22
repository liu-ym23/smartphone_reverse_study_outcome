package com.bytedance.android.standard.tools.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import io.reactivex.annotations.SchedulerSupport;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final int MAX_24G = 2500;
    private static final int MAX_5G = 5900;
    private static final int MIN_24G = 2400;
    private static final int MIN_5G = 4900;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final int NR_STATE = 3;
    private static final String PARAMETER_SEPARATOR = "&";
    private static long lastAdjustTime = 0;
    private static volatile long sInterval = 0;
    private static boolean sIsReceiverRegisted = false;
    private static NetworkType sNetworkType = null;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor = null;
    private static volatile boolean useCheckNetworkFast = false;

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
        public static final NetworkType MOBILE_3G_H = null;
        public static final NetworkType MOBILE_3G_HP = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIFI_24GHZ = null;
        public static final NetworkType WIFI_5GHZ = null;
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
            NetworkType r7 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r7;
            NetworkType r8 = new NetworkType("WIFI_24GHZ", 8, 7);
            WIFI_24GHZ = r8;
            NetworkType r9 = new NetworkType("WIFI_5GHZ", 9, 8);
            WIFI_5GHZ = r9;
            NetworkType r10 = new NetworkType("MOBILE_3G_H", 10, 9);
            MOBILE_3G_H = r10;
            NetworkType r11 = new NetworkType("MOBILE_3G_HP", 11, 10);
            MOBILE_3G_HP = r11;
            $VALUES = new NetworkType[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
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

        public boolean is3GOrHigher() {
            if (this != MOBILE_3G) goto L5;
        L14:
            return true;
        L5:
            if (this == MOBILE_3G_H) goto L14;
            if (this == MOBILE_3G_HP) goto L14;
            if (this == MOBILE_4G) goto L14;
            if (this == MOBILE_5G) goto L14;
            return false;
        }

        public boolean is4GOrHigher() {
            if (this != MOBILE_4G) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_5G) goto L8;
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
        sInterval = 2000;
        lastAdjustTime = 0;
    }

    private NetworkUtils() {
    }

    private static void adjustNetwork(Context r4) {
        if ((System.currentTimeMillis() - lastAdjustTime) <= sInterval) goto L6;
        sNetworkType = getNetworkTypeIntern(r4);
        lastAdjustTime = System.currentTimeMillis();
        return;
    }

    private static void checkNetworkTypeInit(Context r2) {
        NetworkTypeInterceptor r0 = sNetworkTypeInterceptor;
        if (r0 != null) goto L5;
    L8:
        registerReceiver(r2);
        if (sNetworkType != NetworkType.UNKNOWN) goto L12;
        sNetworkType = getNetworkTypeIntern(r2);
        return;
    L12:
        return;
    L5:
        if (r0.getNetworkType() == NetworkType.NONE) goto L8;
        sNetworkType = sNetworkTypeInterceptor.getNetworkType();
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

    public static String getMacAddress(Context r2) {
        String r0 = getMacAddressNew(r2);     // Catch: Throwable -> L11
        if (StringUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        WifiInfo r3 = ((WifiManager) r2.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        return r3.getMacAddress();
    L9:
        return null;
    L14:
        return null;
    }

    private static String getMacAddressNew(Context r8) {
        Enumeration<NetworkInterface> r0 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L21
    L4:
        if (r0.hasMoreElements() == false) goto L20;
        NetworkInterface r1 = r0.nextElement();     // Catch: SocketException -> L21
        byte[] r2 = r1.getHardwareAddress();     // Catch: SocketException -> L21
        if (r2 == null) goto L4;
        if (r2.length == 0) goto L4;
        StringBuilder r3 = new StringBuilder();     // Catch: SocketException -> L21
        int r4 = r2.length;     // Catch: SocketException -> L21
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L15;
        r3.append(String.format("%02X:", new Object[]{Byte.valueOf(r2[r5])}));     // Catch: SocketException -> L21
        r5 = r5 + 1;     // Catch: SocketException -> L21
        goto L12
    L15:
        if (r3.length() <= 0) goto L17;
        r3.deleteCharAt(r3.length() - 1);     // Catch: SocketException -> L21
    L17:
        String r6 = r3.toString();     // Catch: SocketException -> L21
        if (r1.getName().equals("wlan0") == false) goto L4;
        return r6;
    L20:
        return null;
    }

    public static String getNetworkAccessType(Context r0) {
        return getNetworkAccessType(getNetworkType(r0));
    }

    public static String getNetworkAccessTypeFast(Context r0) {
        return getNetworkAccessType(getNetworkTypeFast(r0));
    }

    public static NetworkType getNetworkType(Context r1) {
        if (useCheckNetworkFast == false) goto L7;
        return getNetworkTypeFast(r1);
    L7:
        return getNetworkTypeIntern(r1);
    }

    public static String getNetworkTypeDetail(Context r3) {
        NetworkInfo r1 = ((ConnectivityManager) r3.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L49
        if (r1 != null) goto L6;
        return SchedulerSupport.NONE;
    L6:
        if (r1.isAvailable() == false) goto L52;
        int r2 = r1.getType();     // Catch: Throwable -> L49
        if (1 == r2) goto L11;
        if (r2 != 0) goto L46;
        TelephonyManager r4 = (TelephonyManager) r3.getSystemService("phone");     // Catch: Throwable -> L49
        switch(r4.getNetworkType()) {
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            case 7: goto L19;
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L30;
            case 11: goto L19;
            case 12: goto L28;
            case 13: goto L26;
            case 14: goto L24;
            case 15: goto L22;
            case 16: goto L19;
            case 17: goto L19;
            case 18: goto L19;
            case 19: goto L19;
            case 20: goto L20;
            default: goto L19;
        };     // Catch: Throwable -> L49
    L20:
        return "nr";
    L22:
        return "hspap";
    L24:
        return "ehrpd";
    L26:
        return "lte";
    L28:
        return "evdo_b";
    L30:
        return "hspa";
    L32:
        return "hsupa";
    L34:
        return "hsdpa";
    L36:
        return "evdo_a";
    L38:
        return "evdo_0";
    L40:
        return "cdma";
    L42:
        return "umts";
    L44:
        return "edge";
    L19:
        return String.valueOf(r4.getNetworkType());
    L46:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L11:
        if (isWifi5GHz(r3) == true) goto L51;
        return "wifi";
    L51:
        return "wifi5g";
    L52:
        return SchedulerSupport.NONE;
    L49:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static NetworkType getNetworkTypeFast(Context r0) {
        checkNetworkTypeInit(r0);
        adjustNetwork(r0);
        return sNetworkType;
    }

    private static NetworkType getNetworkTypeIntern(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L34
        if (r0 == null) goto L33;
        if (r0.isAvailable() == false) goto L33;
        int r1 = r0.getType();     // Catch: Throwable -> L34
        if (1 == r1) goto L10;
        if (r1 != 0) goto L31;
        int r3 = ((TelephonyManager) r2.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L34
        if (r3 == 3) goto L29;
        if (r3 == 20) goto L27;
        if (r3 == 5) goto L29;
        if (r3 == 6) goto L29;
        switch(r3) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L21;
        };     // Catch: Throwable -> L34
    L21:
        switch(r3) {
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L23;
        };     // Catch: Throwable -> L34
    L23:
        return NetworkType.MOBILE;
    L25:
        return NetworkType.MOBILE_4G;
    L27:
        return NetworkType.MOBILE_5G;
    L29:
        return NetworkType.MOBILE_3G;
    L31:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L33:
        return NetworkType.NONE;
    L35:
        return NetworkType.MOBILE;
    }

    public static boolean is24GHz(int r1) {
        if (r1 > MIN_24G) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= MAX_24G) goto L7;
        return true;
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

    public static boolean is2GFast(Context r0) {
        checkNetworkTypeInit(r0);
        adjustNetwork(r0);
        return sNetworkType.is2G();
    }

    public static boolean is5GHz(int r1) {
        if (r1 > MIN_5G) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= MAX_5G) goto L7;
        return true;
    }

    private static boolean isNRConnected(TelephonyManager r8) {
        Object r9 = Class.forName(r8.getClass().getName()).getDeclaredMethod("getServiceState", null).invoke(r8, null);     // Catch: Exception -> L11
        Method[] r1 = Class.forName(r9.getClass().getName()).getDeclaredMethods();     // Catch: Exception -> L11
        int r2 = r1.length;     // Catch: Exception -> L11
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L19;
        Method r5 = r1[r4];     // Catch: Exception -> L11
        if (r5.getName().equals("getNrStatus") == true) goto L13;
        if (r5.getName().equals("getNrState") == true) goto L13;
        r4 = r4 + 1;     // Catch: Exception -> L11
    L13:
        r5.setAccessible(true);     // Catch: Exception -> L11
        if (((Integer) r5.invoke(r9, null)).intValue() == 3) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L19
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

    public static boolean isNetworkAvailableFast(Context r0) {
        checkNetworkTypeInit(r0);
        adjustNetwork(r0);
        return sNetworkType.isAvailable();
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

    public static boolean isWifi5GHz(Context r1) {
        return is5GHz(((WifiManager) r1.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getFrequency());
    }

    public static boolean isWifiFast(Context r0) {
        checkNetworkTypeInit(r0);
        adjustNetwork(r0);
        return sNetworkType.isWifi();
    }

    private static void registerReceiver(Context r2) {
        if (sIsReceiverRegisted == true) goto L7;
        if (r2 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        r2.getApplicationContext().registerReceiver(new NetworkConnectChangeReceiver(), r0);
        sIsReceiverRegisted = true;
        return;
    L8:
        return;
    }

    public static void setAdjustNetworkInterval(long r2) {
        if (r2 <= 0) goto L6;
        sInterval = r2;
        return;
    }

    public static void setNetworkType(NetworkType r0) {
        sNetworkType = r0;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r0) {
        sNetworkTypeInterceptor = r0;
    }

    public static void setUseCheckNetworkFast(boolean r0) {
        useCheckNetworkFast = r0;
    }

    public static String getNetworkAccessType(NetworkType r1) {
        if (r1 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r1 != NetworkType.WIFI_24GHZ) goto L9;
        return "wifi24ghz";
    L9:
        if (r1 != NetworkType.WIFI_5GHZ) goto L12;
        return "wifi5ghz";
    L12:
        if (r1 != NetworkType.MOBILE_2G) goto L15;
        return "2g";
    L15:
        if (r1 != NetworkType.MOBILE_3G) goto L18;
        return "3g";
    L18:
        if (r1 != NetworkType.MOBILE_3G_H) goto L21;
        return "3gh";
    L21:
        if (r1 != NetworkType.MOBILE_3G_HP) goto L24;
        return "3ghp";
    L24:
        if (r1 != NetworkType.MOBILE_4G) goto L27;
        return "4g";
    L27:
        if (r1 != NetworkType.MOBILE_5G) goto L30;
        return "5g";
    L30:
        if (r1 != NetworkType.MOBILE) goto L32;
        return "mobile";
    L32:
        return "";
    }
}
