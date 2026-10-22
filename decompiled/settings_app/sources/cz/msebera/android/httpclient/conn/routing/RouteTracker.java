package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
public final class RouteTracker implements RouteInfo, Cloneable {
    private boolean connected;
    private RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private HttpHost[] proxyChain;
    private boolean secure;
    private final HttpHost targetHost;
    private RouteInfo.TunnelType tunnelled;

    public RouteTracker(HttpHost r2, InetAddress r3) {
        Args.notNull(r2, "Target host");
        this.targetHost = r2;
        this.localAddress = r3;
        this.tunnelled = RouteInfo.TunnelType.PLAIN;
        this.layered = RouteInfo.LayerType.PLAIN;
    }

    public void reset() {
        this.connected = false;
        this.proxyChain = null;
        this.tunnelled = RouteInfo.TunnelType.PLAIN;
        this.layered = RouteInfo.LayerType.PLAIN;
        this.secure = false;
    }

    public RouteTracker(HttpRoute r2) {
        this(r2.getTargetHost(), r2.getLocalAddress());
    }

    public final void connectTarget(boolean r4) {
        Asserts.check(!this.connected, "Already connected");
        this.connected = true;
        this.secure = r4;
    }

    public final void connectProxy(HttpHost r4, boolean r5) {
        Args.notNull(r4, "Proxy host");
        Asserts.check(!this.connected, "Already connected");
        this.connected = true;
        this.proxyChain = new HttpHost[]{r4};
        this.secure = r5;
    }

    public final void tunnelTarget(boolean r3) {
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
        this.secure = r3;
    }

    public final void tunnelProxy(HttpHost r6, boolean r7) {
        Args.notNull(r6, "Proxy host");
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        HttpHost[] r0 = this.proxyChain;
        int r1 = r0.length + 1;
        HttpHost[] r2 = new HttpHost[r1];
        System.arraycopy(r0, 0, r2, 0, r0.length);
        r2[r1 - 1] = r6;
        this.proxyChain = r2;
        this.secure = r7;
    }

    public final void layerProtocol(boolean r3) {
        Asserts.check(this.connected, "No layered protocol unless connected");
        this.layered = RouteInfo.LayerType.LAYERED;
        this.secure = r3;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final int getHopCount() {
        if (this.connected == false) goto L8;
        HttpHost[] r1 = this.proxyChain;
        if (r1 != null) goto L10;
        return 1;
    L10:
        return 1 + r1.length;
    L8:
        return 0;
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
        return this.proxyChain[r5];
    L10:
        return this.targetHost;
    L5:
        r2 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        HttpHost[] r1 = this.proxyChain;
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1[0];
    }

    public final boolean isConnected() {
        return this.connected;
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

    public final HttpRoute toRoute() {
        if (this.connected == true) goto L6;
        return null;
    L6:
        return new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RouteTracker) == true) goto L8;
        return false;
    L8:
        RouteTracker r6 = (RouteTracker) r5;
        if (this.connected != r6.connected) goto L24;
        if (this.secure != r6.secure) goto L24;
        if (this.tunnelled != r6.tunnelled) goto L24;
        if (this.layered != r6.layered) goto L24;
        if (LangUtils.equals(this.targetHost, r6.targetHost) == false) goto L24;
        if (LangUtils.equals(this.localAddress, r6.localAddress) == false) goto L24;
        if (LangUtils.equals(this.proxyChain, r6.proxyChain) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r0 = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        HttpHost[] r1 = this.proxyChain;
        if (r1 == null) goto L8;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L8;
        r0 = LangUtils.hashCode(r0, r1[r3]);
        r3 = r3 + 1;
    L8:
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(r0, this.connected), this.secure), this.tunnelled), this.layered);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder((getHopCount() * 30) + 50);
        r0.append("RouteTracker[");
        InetAddress r1 = this.localAddress;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append("->");
    L5:
        r0.append('{');
        if (this.connected == false) goto L9;
        r0.append('c');
    L9:
        if (this.tunnelled != RouteInfo.TunnelType.TUNNELLED) goto L12;
        r0.append('t');
    L12:
        if (this.layered != RouteInfo.LayerType.LAYERED) goto L15;
        r0.append('l');
    L15:
        if (this.secure == false) goto L17;
        r0.append('s');
    L17:
        r0.append("}->");
        HttpHost[] r2 = this.proxyChain;
        if (r2 == null) goto L22;
        int r3 = r2.length;
        int r4 = 0;
    L20:
        if (r4 >= r3) goto L22;
        r0.append(r2[r4]);
        r0.append("->");
        r4 = r4 + 1;
    L22:
        r0.append(this.targetHost);
        r0.append(']');
        return r0.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
