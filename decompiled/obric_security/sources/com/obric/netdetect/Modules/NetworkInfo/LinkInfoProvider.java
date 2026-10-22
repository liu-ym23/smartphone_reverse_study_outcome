package com.obric.netdetect.Modules.NetworkInfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class LinkInfoProvider {
    private static final String TAG = "LinkInfoProvider";
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final Network mNetwork;

    public LinkInfoProvider(Context r1, Network r2) {
        this.mContext = r1;
        this.mNetwork = r2;
        this.mConnectivityManager = (ConnectivityManager) r1.getSystemService("connectivity");
    }

    public NetworkInfoResult.LinkInfo getLinkInfo() {
        LinkProperties r10 = this.mConnectivityManager.getLinkProperties(this.mNetwork);
        String r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<LinkAddress> r1 = r10.getLinkAddresses().iterator();
        String r3 = null;
        String r4 = null;
    L7:
        if (r1.hasNext() == false) goto L18;
        InetAddress r2 = r1.next().getAddress();
        if ((r2 instanceof Inet4Address) == true) goto L11;
        if ((r2 instanceof Inet6Address) == false) goto L7;
        if (Objects.equals(r2.getHostAddress(), "::") == true) goto L7;
        r4 = r2.getHostAddress();
        goto L7
    L11:
        if (Objects.equals(r2.getHostAddress(), "0.0.0.0") == true) goto L7;
        r3 = r2.getHostAddress();
        goto L7
    L18:
        Inet4Address r5 = r10.getDhcpServerAddress();
        if (r5 == null) goto L21;
        String r7 = r5.getHostAddress();
    L22:
        ArrayList r8 = new ArrayList();
        Iterator<InetAddress> r6 = r10.getDnsServers().iterator();
    L24:
        if (r6.hasNext() == false) goto L26;
        r8.add(r6.next().getHostAddress());
        goto L24
    L26:
        Iterator<RouteInfo> r11 = r10.getRoutes().iterator();
        String r9 = null;
    L28:
        if (r11.hasNext() == false) goto L40;
        InetAddress r12 = r11.next().getGateway();
        if ((r12 instanceof Inet4Address) == true) goto L32;
        if ((r12 instanceof Inet6Address) == false) goto L28;
        if (Objects.equals(r12.getHostAddress(), "::") == true) goto L28;
        r9 = r12.getHostAddress();
        goto L28
    L32:
        if (Objects.equals(r12.getHostAddress(), "0.0.0.0") == true) goto L28;
        r0 = r12.getHostAddress();
        goto L28
    L40:
        return new NetworkInfoResult.LinkInfo(r3, r4, r0, r9, r7, r8);
    L21:
        r7 = null;
        goto L22
    }
}
