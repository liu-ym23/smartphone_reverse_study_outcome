package com.slardaros.client.monitor.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import androidx.core.os.EnvironmentCompat;
import com.android.settings.MultiSimAdapter;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public class NetUtil {
    public static int CONNECTION_2G = 3;
    public static int CONNECTION_3G = 4;
    public static int CONNECTION_4G = 5;
    public static int CONNECTION_5G = 8;
    public static int CONNECTION_ETHERNET = 1;
    public static int CONNECTION_LAST = 8;
    public static int CONNECTION_NONE = 6;
    public static int CONNECTION_UNKNOWN = 0;
    public static int CONNECTION_WIFI = 2;
    public static int ONNECTION_BLUETOOTH = 7;

    static {
    }

    public NetUtil() {
    }

    public static int getNetworkType(Context r2) {
        ConnectivityManager r0 = (ConnectivityManager) r2.getSystemService("connectivity");
        NetworkCapabilities r1 = r0.getNetworkCapabilities(r0.getActiveNetwork());
        if (r1 == null) goto L18;
        if (isNetConnected(r1) == false) goto L18;
        if (isWifi(r1) == true) goto L10;
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r3 != null) goto L16;
        return CONNECTION_NONE;
    L16:
        return convert2LocalNetType(r3.getDataNetworkType());
    L10:
        return CONNECTION_WIFI;
    L18:
        return CONNECTION_NONE;
    }

    private static boolean isNetConnected(NetworkCapabilities r1) {
        return r1.hasCapability(12);
    }

    private static boolean isWifi(NetworkCapabilities r1) {
        return r1.hasTransport(1);
    }

    private static int convert2LocalNetType(int r1) {
        if (r1 == 19) goto L16;
        if (r1 == 20) goto L14;
        switch(r1) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L16;
            case 14: goto L10;
            case 15: goto L10;
            default: goto L8;
        };
    L8:
        return CONNECTION_UNKNOWN;
    L10:
        return CONNECTION_3G;
    L12:
        return CONNECTION_2G;
    L14:
        return CONNECTION_5G;
    L16:
        return CONNECTION_4G;
    }

    public static boolean isIpv6Address(String r0) {
        return InetAddress.getByName(r0) instanceof Inet6Address;
    L4:
        return false;
    }

    public static String getProtocol(String r2) {
        int r0 = r2.indexOf("://");
        if (r0 != (-1)) goto L7;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L7:
        return r2.substring(0, r0);
    }

    public static String sanitizeUrl(String r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        URL r1 = new URL(r3);     // Catch: MalformedURLException -> L11
        StringBuffer r4 = new StringBuffer();
        r4.append(r1.getProtocol());
        r4.append("://");
        r4.append(r1.getHost());
        if (r1.getPort() == (-1)) goto L9;
        r4.append(":");
        r4.append(r1.getPort());
    L9:
        r4.append(r1.getPath());
        return r4.toString();
    L11:
        return null;
    }
}
