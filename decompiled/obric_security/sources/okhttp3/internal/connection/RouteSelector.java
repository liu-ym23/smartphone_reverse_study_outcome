package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDnsResult;

/* JADX INFO: loaded from: classes5.dex */
public final class RouteSelector {
    private final Address address;
    private final Call call;
    private String dnsInfoJson;
    private final EventListener eventListener;
    private int hijackedError;
    private List<InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<Proxy> proxies;
    private final RouteDatabase routeDatabase;

    public static final class Selection {
        private boolean isQuickTestPhase;
        private int nextRouteIndex;
        private final List<Route> routes;

        Selection(List<Route> r4) {
            this.nextRouteIndex = 0;
            this.isQuickTestPhase = false;
            this.routes = r4;
            if (r4.size() >= TTConfigManager.inst().getTriplicateIpNumbers()) goto L6;
            ArrayList r0 = new ArrayList(r4);
            r4.addAll(r0);
            r4.addAll(r0);
            this.isQuickTestPhase = true;
        L6:
            if (r4.size() <= 1) goto L9;
            this.isQuickTestPhase = true;
            return;
        }

        public boolean hasNext() {
            if (this.isQuickTestPhase == false) goto L8;
            if (this.nextRouteIndex != this.routes.size()) goto L8;
            this.nextRouteIndex = 0;
            this.isQuickTestPhase = false;
        L8:
            if (this.nextRouteIndex >= this.routes.size()) goto L11;
            return true;
        L11:
            return false;
        }

        public Route next() {
            if (hasNext() == false) goto L7;
            List<Route> r0 = this.routes;
            int r1 = this.nextRouteIndex;
            this.nextRouteIndex = r1 + 1;
            return r0.get(r1);
        L7:
            throw new NoSuchElementException();
        }

        public List<Route> getAll() {
            return new ArrayList(this.routes);
        }

        public boolean isQuickTestPhase() {
            return this.isQuickTestPhase;
        }

        public void setIsQuickTestPhase(boolean r1) {
            this.isQuickTestPhase = r1;
        }
    }

    public RouteSelector(Address r2, RouteDatabase r3, Call r4, EventListener r5) {
        this.hijackedError = 0;
        this.dnsInfoJson = null;
        this.proxies = Collections.emptyList();
        this.inetSocketAddresses = Collections.emptyList();
        this.postponedRoutes = new ArrayList();
        this.address = r2;
        this.routeDatabase = r3;
        this.call = r4;
        this.eventListener = r5;
        resetNextProxy(r2.url(), r2.proxy());
    }

    public boolean hasNext() {
        if (hasNextProxy() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.postponedRoutes.isEmpty() == false) goto L8;
        return false;
    }

    public Selection next() throws IOException {
        if (hasNext() == false) goto L22;
        ArrayList r0 = new ArrayList();
    L6:
        if (hasNextProxy() == false) goto L17;
        Proxy r1 = nextProxy();
        int r2 = this.inetSocketAddresses.size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L15;
        Route r4 = new Route(this.address, r1, this.inetSocketAddresses.get(r3), this.dnsInfoJson);
        if (this.routeDatabase.shouldPostpone(r4) == false) goto L12;
        this.postponedRoutes.add(r4);
    L13:
        r3 = r3 + 1;
        goto L8
    L12:
        r0.add(r4);
        goto L13
    L15:
        if (r0.isEmpty() == true) goto L6;
    L17:
        if (r0.isEmpty() == false) goto L20;
        r0.addAll(this.postponedRoutes);
        this.postponedRoutes.clear();
    L20:
        return new Selection(r0);
    L22:
        throw new NoSuchElementException();
    }

    public void connectFailed(Route r4, IOException r5) {
        if (r4.proxy().type() != Proxy.Type.DIRECT) goto L5;
    L7:
        this.routeDatabase.failed(r4);
        return;
    L5:
        if (this.address.proxySelector() == null) goto L7;
        this.address.proxySelector().connectFailed(this.address.url().uri(), r4.proxy().address(), r5);
        goto L7
    }

    private void resetNextProxy(HttpUrl r2, Proxy r3) {
        if (r3 == null) goto L5;
        this.proxies = Collections.singletonList(r3);
    L12:
        this.nextProxyIndex = 0;
        return;
    L5:
        List<Proxy> r4 = this.address.proxySelector().select(r2.uri());
        if (r4 != null) goto L8;
    L10:
        List<Proxy> r5 = Util.immutableList(new Proxy[]{Proxy.NO_PROXY});
    L11:
        this.proxies = r5;
        goto L12
    L8:
        if (r4.isEmpty() == true) goto L10;
        r5 = Util.immutableList(r4);
        goto L11
    }

    private boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy() == false) goto L7;
        List<Proxy> r0 = this.proxies;
        int r1 = this.nextProxyIndex;
        this.nextProxyIndex = r1 + 1;
        Proxy r2 = r0.get(r1);
        resetNextInetSocketAddress(r2);
        return r2;
    L7:
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy r7) throws IOException {
        this.inetSocketAddresses = new ArrayList();
        if (r7.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r1 = this.address.url().host();
        int r0 = this.address.url().port();
    L14:
        if (r0 < 1) goto L39;
        if (r0 > 65535) goto L39;
        if (r7.type() != Proxy.Type.SOCKS) goto L20;
        this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(r1, r0));
        return;
    L20:
        this.eventListener.dnsStart(this.call, r1);
        List<InetAddress> r8 = new ArrayList();
        String r4 = null;
        if (this.address.ttnetDns() == null) goto L30;
        TTNetDnsResult r2 = this.address.ttnetDns().lookup(r1, this.hijackedError);
        if (r2 == null) goto L25;
        r8 = r2.getInetAddressList();
        r4 = r2.getDnsInfoJson();
    L25:
        this.eventListener.dnsEnd(this.call, r1, r8, r4);
        this.dnsInfoJson = r4;
        if (r8.isEmpty() == true) goto L29;
    L32:
        this.eventListener.dnsEnd(this.call, r1, r8);
        int r3 = r8.size();
        int r5 = 0;
    L33:
        if (r5 >= r3) goto L41;
        this.inetSocketAddresses.add(new InetSocketAddress(r8.get(r5), r0));
        r5 = r5 + 1;
        goto L33
    L41:
        return;
    L29:
        throw new UnknownHostException(this.address.ttnetDns() + " returned no addresses for " + r1);
    L30:
        r8 = this.address.dns().lookup(r1);
        this.eventListener.dnsEnd(this.call, r1, r8, null);
        if (r8.isEmpty() == false) goto L32;
        throw new UnknownHostException(this.address.dns() + " returned no addresses for " + r1);
    L39:
        throw new SocketException("No route to " + r1 + ":" + r0 + "; port is out of range");
    L5:
        if (r7.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r6 = r7.address();
        if ((r6 instanceof InetSocketAddress) == false) goto L11;
        InetSocketAddress r9 = (InetSocketAddress) r6;
        r1 = getHostString(r9);
        r0 = r9.getPort();
        goto L14
    L11:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r6.getClass());
    }

    static String getHostString(InetSocketAddress r1) {
        InetAddress r0 = r1.getAddress();
        if (r0 != null) goto L7;
        return r1.getHostName();
    L7:
        return r0.getHostAddress();
    }

    public void resetNextProxy(int r3) {
        resetNextProxy(this.address.url(), this.address.proxy());
        this.inetSocketAddresses.clear();
        this.postponedRoutes.clear();
        this.hijackedError = r3;
        this.dnsInfoJson = null;
    }
}
