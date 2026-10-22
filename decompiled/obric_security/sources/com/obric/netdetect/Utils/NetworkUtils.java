package com.obric.netdetect.Utils;

import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtils {
    private static final String TAG = "NetworkUtils";
    private final ConnectivityManager mConnectivityManager;

    public String getIface(int r1) {
        if (r1 == 1) goto L6;
        return null;
    L6:
        return "wlan0";
    }

    public NetworkUtils(ConnectivityManager r1) {
        this.mConnectivityManager = r1;
    }

    public InetAddress getGatewayIpv4InetAddress(Network r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkProperties r3 = this.mConnectivityManager.getLinkProperties(r4);
        if (r3 != null) goto L8;
        return null;
    L8:
        Iterator<RouteInfo> r5 = r3.getRoutes().iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        InetAddress r6 = r5.next().getGateway();
        if ((r6 instanceof Inet4Address) == false) goto L10;
        if (r6.getHostAddress().equals("0.0.0.0") == true) goto L10;
        return r6;
    L16:
        return null;
    }

    public InetAddress getIpv4InetAddress(Network r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkProperties r3 = this.mConnectivityManager.getLinkProperties(r4);
        if (r3 != null) goto L8;
        return null;
    L8:
        Iterator<LinkAddress> r5 = r3.getLinkAddresses().iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        InetAddress r6 = r5.next().getAddress();
        if ((r6 instanceof Inet4Address) == false) goto L10;
        if (r6.getHostAddress().equals("0.0.0.0") == true) goto L10;
        return r6;
    L16:
        return null;
    }

    public byte[] getMacAddress(String r4) {
        NetworkInterface r5 = NetworkInterface.getByName(r4);     // Catch: Exception -> L9
        if (r5 != null) goto L7;
        NetDetectLog.e(TAG, "get mac address failed, interface is null");     // Catch: Exception -> L9
        return null;
    L7:
        NetDetectLog.d(TAG, "mac:" + Arrays.toString(r5.getHardwareAddress()));     // Catch: Exception -> L9
        return r5.getHardwareAddress();
    L9:
        e = move-exception;
        e.printStackTrace();
        NetDetectLog.e(TAG, "get mac address failed, exception: " + e.getMessage());
        return null;
    }
}
