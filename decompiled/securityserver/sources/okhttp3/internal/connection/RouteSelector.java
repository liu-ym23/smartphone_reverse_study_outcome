package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
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

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress r1) {
            Intrinsics.f(r1, "$this$socketHost");
            InetAddress r0 = r1.getAddress();
            if (r0 == null) goto L6;
            String r2 = r0.getHostAddress();
            Intrinsics.e(r2, "address.hostAddress");
            return r2;
        L6:
            String r3 = r1.getHostName();
            Intrinsics.e(r3, "hostName");
            return r3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Selection {
        private int nextRouteIndex;

        @NotNull
        private final List<Route> routes;

        public Selection(@NotNull List<Route> r2) {
            Intrinsics.f(r2, "routes");
            this.routes = r2;
        }

        @NotNull
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.nextRouteIndex >= this.routes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @NotNull
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

    public RouteSelector(@NotNull Address r2, @NotNull RouteDatabase r3, @NotNull Call r4, @NotNull EventListener r5) {
        Intrinsics.f(r2, "address");
        Intrinsics.f(r3, "routeDatabase");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r5, "eventListener");
        this.address = r2;
        this.routeDatabase = r3;
        this.call = r4;
        this.eventListener = r5;
        EmptyList r6 = EmptyList.b;
        this.proxies = r6;
        this.inetSocketAddresses = r6;
        this.postponedRoutes = new ArrayList();
        resetNextProxy(r2.url(), r2.proxy());
    }

    public static final /* synthetic */ Address access$getAddress$p(RouteSelector r0) {
        return r0.address;
    }

    private final boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy nextProxy() {
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

    private final void resetNextInetSocketAddress(Proxy r5) {
        ArrayList r0 = new ArrayList();
        this.inetSocketAddresses = r0;
        if (r5.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r2 = this.address.url().host();
        int r1 = this.address.url().port();
    L14:
        if (1 > r1) goto L30;
        if (65535 < r1) goto L30;
        if (r5.type() != Proxy.Type.SOCKS) goto L20;
        r0.add(InetSocketAddress.createUnresolved(r2, r1));
        return;
    L20:
        this.eventListener.dnsStart(this.call, r2);
        List<InetAddress> r6 = this.address.dns().lookup(r2);
        if (r6.isEmpty() == true) goto L28;
        this.eventListener.dnsEnd(this.call, r2, r6);
        Iterator<InetAddress> r4 = r6.iterator();
    L24:
        if (r4.hasNext() == false) goto L32;
        r0.add(new InetSocketAddress(r4.next(), r1));
        goto L24
    L32:
        return;
    L28:
        throw new UnknownHostException(this.address.dns() + " returned no addresses for " + r2);
    L30:
        throw new SocketException("No route to " + r2 + ':' + r1 + "; port is out of range");
    L5:
        if (r5.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r3 = r5.address();
        if ((r3 instanceof InetSocketAddress) == false) goto L11;
        InetSocketAddress r7 = (InetSocketAddress) r3;
        r2 = Companion.getSocketHost(r7);
        r1 = r7.getPort();
        goto L14
    L11:
        throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + r3.getClass()).toString());
    }

    private final void resetNextProxy(final HttpUrl r3, final Proxy r4) {
        Function0<List<? extends Proxy>> r0 = new AnonymousClass1(this, r4, r3);
        this.eventListener.proxySelectStart(this.call, r3);
        List<Proxy> r5 = r0.invoke();
        this.proxies = r5;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, r3, r5);
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

    @NotNull
    public final Selection next() {
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
        CollectionsKt.d(r0, this.postponedRoutes);
        this.postponedRoutes.clear();
    L20:
        return new Selection(r0);
    L22:
        throw new NoSuchElementException();
    }
}
