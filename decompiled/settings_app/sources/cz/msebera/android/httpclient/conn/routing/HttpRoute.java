package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpRoute implements RouteInfo, Cloneable {
    private final RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private final List<HttpHost> proxyChain;
    private final boolean secure;
    private final HttpHost targetHost;
    private final RouteInfo.TunnelType tunnelled;

    private HttpRoute(HttpHost r2, InetAddress r3, List<HttpHost> r4, boolean r5, RouteInfo.TunnelType r6, RouteInfo.LayerType r7) {
        Args.notNull(r2, "Target host");
        this.targetHost = normalize(r2);
        this.localAddress = r3;
        if (r4 != null) goto L5;
    L7:
        this.proxyChain = null;
    L9:
        if (r6 == RouteInfo.TunnelType.TUNNELLED) goto L11;
    L15:
        this.secure = r5;
        if (r6 != null) goto L19;
        r6 = RouteInfo.TunnelType.PLAIN;
    L19:
        this.tunnelled = r6;
        if (r7 != null) goto L23;
        r7 = RouteInfo.LayerType.PLAIN;
    L23:
        this.layered = r7;
        return;
    L11:
        if (this.proxyChain == null) goto L13;
        boolean r8 = true;
    L14:
        Args.check(r8, "Proxy required if tunnelled");
        goto L15
    L13:
        r8 = false;
        goto L14
    L5:
        if (r4.isEmpty() == true) goto L7;
        this.proxyChain = new ArrayList(r4);
        goto L9
    }

    private static int getDefaultPort(String r1) {
        if ("http".equalsIgnoreCase(r1) == false) goto L7;
        return 80;
    L7:
        if (HttpHeadTimeFetcher.FETCHER_TYPE.equalsIgnoreCase(r1) == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    private static HttpHost normalize(HttpHost r3) {
        if (r3.getPort() < 0) goto L5;
        return r3;
    L5:
        InetAddress r0 = r3.getAddress();
        String r1 = r3.getSchemeName();
        if (r0 == null) goto L9;
        return new HttpHost(r0, getDefaultPort(r1), r1);
    L9:
        return new HttpHost(r3.getHostName(), getDefaultPort(r1), r1);
    }

    public HttpRoute(HttpHost r8, InetAddress r9, HttpHost[] r10, boolean r11, RouteInfo.TunnelType r12, RouteInfo.LayerType r13) {
        if (r10 == null) goto L4;
        List r14 = Arrays.asList(r10);
    L5:
        this(r8, r9, r14, r11, r12, r13);
        return;
    L4:
        r14 = null;
        goto L5
    }

    public HttpRoute(HttpHost r8, InetAddress r9, HttpHost r10, boolean r11, RouteInfo.TunnelType r12, RouteInfo.LayerType r13) {
        if (r10 == null) goto L4;
        List r14 = Collections.singletonList(r10);
    L5:
        this(r8, r9, r14, r11, r12, r13);
        return;
    L4:
        r14 = null;
        goto L5
    }

    public HttpRoute(HttpHost r8, InetAddress r9, boolean r10) {
        this(r8, r9, Collections.emptyList(), r10, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost r8) {
        this(r8, null, Collections.emptyList(), false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost r8, InetAddress r9, HttpHost r10, boolean r11) {
        List r3 = Collections.singletonList(Args.notNull(r10, "Proxy host"));
        if (r11 == false) goto L5;
        RouteInfo.TunnelType r12 = RouteInfo.TunnelType.TUNNELLED;
    L6:
        RouteInfo.TunnelType r5 = r12;
        if (r11 == false) goto L9;
        RouteInfo.LayerType r13 = RouteInfo.LayerType.LAYERED;
    L10:
        this(r8, r9, r3, r11, r5, r13);
        return;
    L9:
        r13 = RouteInfo.LayerType.PLAIN;
        goto L10
    L5:
        r12 = RouteInfo.TunnelType.PLAIN;
        goto L6
    }

    public HttpRoute(HttpHost r3, HttpHost r4) {
        this(r3, null, r4, false);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final InetSocketAddress getLocalSocketAddress() {
        if (this.localAddress != null) goto L7;
        return null;
    L7:
        return new InetSocketAddress(this.localAddress, 0);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final int getHopCount() {
        List<HttpHost> r1 = this.proxyChain;
        if (r1 != null) goto L5;
        return 1;
    L5:
        return 1 + r1.size();
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int r5) {
        Args.notNegative(r5, "Hop index");
        int r0 = getHopCount();
        if (r5 >= r0) goto L5;
        boolean r2 = true;
    L6:
        Args.check(r2, "Hop index exceeds tracked route length");
        if (r5 >= (r0 - 1)) goto L10;
        return this.proxyChain.get(r5);
    L10:
        return this.targetHost;
    L5:
        r2 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        List<HttpHost> r0 = this.proxyChain;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return this.proxyChain.get(0);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        if (this.tunnelled != RouteInfo.TunnelType.TUNNELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isLayered() {
        if (this.layered != RouteInfo.LayerType.LAYERED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isSecure() {
        return this.secure;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HttpRoute) == false) goto L22;
        HttpRoute r6 = (HttpRoute) r5;
        if (this.secure != r6.secure) goto L21;
        if (this.tunnelled != r6.tunnelled) goto L21;
        if (this.layered != r6.layered) goto L21;
        if (LangUtils.equals(this.targetHost, r6.targetHost) == false) goto L21;
        if (LangUtils.equals(this.localAddress, r6.localAddress) == false) goto L21;
        if (LangUtils.equals(this.proxyChain, r6.proxyChain) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        List<HttpHost> r1 = this.proxyChain;
        if (r1 == null) goto L9;
        Iterator<HttpHost> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        r0 = LangUtils.hashCode(r0, r2.next());
    L9:
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(r0, this.secure), this.tunnelled), this.layered);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder((getHopCount() * 30) + 50);
        InetAddress r1 = this.localAddress;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append("->");
    L5:
        r0.append('{');
        if (this.tunnelled != RouteInfo.TunnelType.TUNNELLED) goto L9;
        r0.append('t');
    L9:
        if (this.layered != RouteInfo.LayerType.LAYERED) goto L12;
        r0.append('l');
    L12:
        if (this.secure == false) goto L14;
        r0.append('s');
    L14:
        r0.append("}->");
        List<HttpHost> r2 = this.proxyChain;
        if (r2 == null) goto L20;
        Iterator<HttpHost> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        r0.append(r3.next());
        r0.append("->");
    L20:
        r0.append(this.targetHost);
        return r0.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
