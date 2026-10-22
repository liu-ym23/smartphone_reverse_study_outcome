package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.android.settingslib.accessibility.AccessibilityUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0086\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "address", "Lokhttp3/Address;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "inetSocketAddresses", "", "Ljava/net/InetSocketAddress;", "nextProxyIndex", "", "postponedRoutes", "", "Lokhttp3/Route;", "proxies", "Ljava/net/Proxy;", "hasNext", "", "hasNextProxy", "next", "Lokhttp3/internal/connection/RouteSelector$Selection;", "nextProxy", "resetNextInetSocketAddress", "", "proxy", "resetNextProxy", "url", "Lokhttp3/HttpUrl;", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RouteSelector {
    public static final Companion Companion = null;
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    /* JADX INFO: compiled from: RouteSelector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String getSocketHost(InetSocketAddress r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            InetAddress r0 = r1.getAddress();
            if (r0 != null) goto L6;
            String r2 = r1.getHostName();
            Intrinsics.checkNotNullExpressionValue(r2, "hostName");
            return r2;
        L6:
            String r3 = r0.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(r3, "address.hostAddress");
            return r3;
        }
    }

    /* JADX INFO: compiled from: RouteSelector.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u000bH\u0086\u0002J\t\u0010\f\u001a\u00020\u0004H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "routes", "", "Lokhttp3/Route;", "(Ljava/util/List;)V", "nextRouteIndex", "", "getRoutes", "()Ljava/util/List;", "hasNext", "", "next", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> r2) {
            Intrinsics.checkNotNullParameter(r2, "routes");
            this.routes = r2;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.nextRouteIndex >= this.routes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public final Route next() {
            if (hasNext() == false) goto L7;
            List<Route> r0 = this.routes;
            int r1 = this.nextRouteIndex;
            this.nextRouteIndex = r1 + 1;
            return r0.get(r1);
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RouteSelector(Address r2, RouteDatabase r3, Call r4, EventListener r5) {
        Intrinsics.checkNotNullParameter(r2, "address");
        Intrinsics.checkNotNullParameter(r3, "routeDatabase");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r5, "eventListener");
        this.address = r2;
        this.routeDatabase = r3;
        this.call = r4;
        this.eventListener = r5;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(r2.url(), r2.proxy());
    }

    public final boolean hasNext() {
        if (hasNextProxy() == false) goto L5;
        return true;
    L5:
        if ((!this.postponedRoutes.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final Selection next() throws IOException {
        if (hasNext() == false) goto L22;
        ArrayList r0 = new ArrayList();
    L6:
        if (hasNextProxy() == false) goto L17;
        Proxy r1 = nextProxy();
        Iterator<? extends InetSocketAddress> r2 = this.inetSocketAddresses.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        Route r4 = new Route(this.address, r1, r2.next());
        if (this.routeDatabase.shouldPostpone(r4) == true) goto L12;
        r0.add(r4);
        goto L9
    L12:
        this.postponedRoutes.add(r4);
        goto L9
    L15:
        if ((!r0.isEmpty()) == false) goto L6;
    L17:
        if (r0.isEmpty() == false) goto L20;
        CollectionsKt.addAll(r0, this.postponedRoutes);
        this.postponedRoutes.clear();
    L20:
        return new Selection(r0);
    L22:
        throw new NoSuchElementException();
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy r2, HttpUrl r3, RouteSelector r4) {
        if (r2 != null) goto L4;
        URI r5 = r3.uri();
        if (r5.getHost() == null) goto L8;
        List<Proxy> r6 = r4.address.proxySelector().select(r5);
        List<Proxy> r7 = r6;
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
        Intrinsics.checkNotNullExpressionValue(r6, "proxiesOrNull");
        return Util.toImmutableList(r6);
    L18:
        return Util.immutableListOf(new Proxy[]{Proxy.NO_PROXY});
    L12:
        if (r7.isEmpty() == true) goto L15;
        r8 = false;
        goto L16
    L8:
        return Util.immutableListOf(new Proxy[]{Proxy.NO_PROXY});
    L4:
        return CollectionsKt.listOf(r2);
    }

    private final void resetNextProxy(HttpUrl r3, Proxy r4) {
        this.eventListener.proxySelectStart(this.call, r3);
        List<Proxy> r5 = resetNextProxy$selectProxies(r4, r3, this);
        this.proxies = r5;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, r3, r5);
    }

    private final boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy() == false) goto L7;
        List<? extends Proxy> r0 = this.proxies;
        int r1 = this.nextProxyIndex;
        this.nextProxyIndex = r1 + 1;
        Proxy r2 = r0.get(r1);
        resetNextInetSocketAddress(r2);
        return r2;
    L7:
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy r7) throws IOException {
        ArrayList r0 = new ArrayList();
        this.inetSocketAddresses = r0;
        if (r7.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r2 = this.address.url().host();
        int r1 = this.address.url().port();
    L13:
        boolean r3 = false;
        if (1 <= r1) goto L16;
    L18:
        if (r3 == false) goto L36;
        if (r7.type() != Proxy.Type.SOCKS) goto L23;
        r0.add(InetSocketAddress.createUnresolved(r2, r1));
        return;
    L23:
        if (Util.canParseAsIpAddress(r2) == false) goto L25;
        List<InetAddress> r6 = CollectionsKt.listOf(InetAddress.getByName(r2));
    L28:
        Iterator<InetAddress> r8 = r6.iterator();
    L30:
        if (r8.hasNext() == false) goto L38;
        r0.add(new InetSocketAddress(r8.next(), r1));
        goto L30
    L38:
        return;
    L25:
        this.eventListener.dnsStart(this.call, r2);
        List<InetAddress> r9 = this.address.dns().lookup(r2);
        if (r9.isEmpty() == true) goto L34;
        this.eventListener.dnsEnd(this.call, r2, r9);
        r6 = r9;
        goto L28
    L34:
        throw new UnknownHostException(this.address.dns() + " returned no addresses for " + r2);
    L36:
        throw new SocketException("No route to " + r2 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r1 + "; port is out of range");
    L16:
        if (r1 >= 65536) goto L18;
        r3 = true;
        goto L18
    L5:
        if (r7.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r4 = r7.address();
        if ((r4 instanceof InetSocketAddress) == false) goto L11;
        Companion r5 = Companion;
        Intrinsics.checkNotNullExpressionValue(r4, "proxyAddress");
        InetSocketAddress r10 = (InetSocketAddress) r4;
        r2 = r5.getSocketHost(r10);
        r1 = r10.getPort();
        goto L13
    L11:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Proxy.address() is not an InetSocketAddress: ", r4.getClass()).toString());
    }
}
