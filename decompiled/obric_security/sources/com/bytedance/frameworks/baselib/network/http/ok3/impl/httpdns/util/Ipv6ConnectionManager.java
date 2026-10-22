package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class Ipv6ConnectionManager {
    private static final String TAG = "Ipv6ConnectionManager";
    private static String mIPv6ProbeAddress = "2001:4860:4860::8888";
    private static AtomicBoolean mIsIpv6GloballyReachable;

    public Ipv6ConnectionManager() {
    }

    static {
        mIsIpv6GloballyReachable = new AtomicBoolean(false);
    }

    public static void detectIpv6Reachable() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "detectIpv6Reachable");
    L5:
        mIsIpv6GloballyReachable.set(isGloballyIpv6Reachable());
    }

    private static boolean isGloballyIpv6Reachable() {
        boolean r0 = false;
        DatagramSocket r1 = null;
        DatagramSocket r2 = new DatagramSocket();     // Catch: Throwable -> L14 IOException -> L21
        r2.connect(new InetSocketAddress(mIPv6ProbeAddress, 53));     // Catch: Throwable -> L11 IOException -> L13
        InetAddress r3 = r2.getLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if ((r3 instanceof Inet6Address) == false) goto L10;
        boolean r4 = !r3.isLinkLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if (r3.getHostAddress().startsWith("2001:0000") == true) goto L10;
        r0 = r4;
        goto L10
    L10:
        r2.close();
    L20:
        return r0;
    L13:
        r1 = r2;
    L11:
        th = th;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        r1.close();
    L17:
        throw th;
    L14:
        th = th;
    L18:
        if (r1 == null) goto L20;
        r1.close();
        goto L20
    }

    public static AtomicBoolean getIpv6GloballyReachable() {
        return mIsIpv6GloballyReachable;
    }
}
