package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.params.ConnRouteParams;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ProxySelectorRoutePlanner implements HttpRoutePlanner {
    protected ProxySelector proxySelector;
    protected final SchemeRegistry schemeRegistry;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.conn.ProxySelectorRoutePlanner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            $SwitchMap$java$net$Proxy$Type = r0;
            r0[Proxy.Type.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$java$net$Proxy$Type[Proxy.Type.HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$java$net$Proxy$Type[Proxy.Type.SOCKS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public ProxySelectorRoutePlanner(SchemeRegistry r2, ProxySelector r3) {
        Args.notNull(r2, "SchemeRegistry");
        this.schemeRegistry = r2;
        this.proxySelector = r3;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public void setProxySelector(ProxySelector r1) {
        this.proxySelector = r1;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost r2, HttpRequest r3, HttpContext r4) throws HttpException {
        Args.notNull(r3, "HTTP request");
        HttpRoute r0 = ConnRouteParams.getForcedRoute(r3.getParams());
        if (r0 == null) goto L5;
        return r0;
    L5:
        Asserts.notNull(r2, "Target host");
        InetAddress r1 = ConnRouteParams.getLocalAddress(r3.getParams());
        HttpHost r5 = determineProxy(r2, r3, r4);
        boolean r6 = this.schemeRegistry.getScheme(r2.getSchemeName()).isLayered();
        if (r5 != null) goto L9;
        return new HttpRoute(r2, r1, r6);
    L9:
        return new HttpRoute(r2, r1, r5, r6);
    }

    protected HttpHost determineProxy(HttpHost r5, HttpRequest r6, HttpContext r7) throws HttpException {
        ProxySelector r0 = this.proxySelector;
        if (r0 != null) goto L6;
        r0 = ProxySelector.getDefault();
    L6:
        if (r0 != null) goto L20;
        return null;
    L20:
        Proxy r8 = chooseProxy(r0.select(new URI(r5.toURI())), r5, r6, r7);
        if (r8.type() == Proxy.Type.HTTP) goto L12;
        return null;
    L12:
        if ((r8.address() instanceof InetSocketAddress) == false) goto L15;
        InetSocketAddress r9 = (InetSocketAddress) r8.address();
        return new HttpHost(getHost(r9), r9.getPort());
    L15:
        throw new HttpException("Unable to handle non-Inet proxy address: " + r8.address());
    L17:
        e = move-exception;
        throw new HttpException("Cannot convert host to URI: " + r5, e);
    }

    protected String getHost(InetSocketAddress r1) {
        if (r1.isUnresolved() == false) goto L6;
        return r1.getHostName();
    L6:
        return r1.getAddress().getHostAddress();
    }

    protected Proxy chooseProxy(List<Proxy> r2, HttpHost r3, HttpRequest r4, HttpContext r5) {
        Args.notEmpty(r2, "List of proxies");
        Proxy r1 = null;
        int r6 = 0;
    L3:
        if (r1 != null) goto L13;
        if (r6 >= r2.size()) goto L13;
        Proxy r7 = r2.get(r6);
        int r8 = AnonymousClass1.$SwitchMap$java$net$Proxy$Type[r7.type().ordinal()];
        if (r8 != 1) goto L9;
    L11:
        r1 = r7;
    L12:
        r6 = r6 + 1;
        goto L3
    L9:
        if (r8 == 2) goto L11;
    L13:
        if (r1 == null) goto L15;
        return r1;
    L15:
        return Proxy.NO_PROXY;
    }
}
