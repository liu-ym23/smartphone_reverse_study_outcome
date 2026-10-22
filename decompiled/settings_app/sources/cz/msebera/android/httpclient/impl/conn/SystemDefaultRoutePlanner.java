package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner$1, reason: invalid class name */
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

    public SystemDefaultRoutePlanner(SchemePortResolver r1, ProxySelector r2) {
        super(r1);
        this.proxySelector = r2;
    }

    public SystemDefaultRoutePlanner(ProxySelector r2) {
        this(null, r2);
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner
    protected HttpHost determineProxy(HttpHost r2, HttpRequest r3, HttpContext r4) throws HttpException {
        URI r5 = new URI(r2.toURI());     // Catch: URISyntaxException -> L17
        ProxySelector r6 = this.proxySelector;
        if (r6 != null) goto L7;
        r6 = ProxySelector.getDefault();
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        Proxy r7 = chooseProxy(r6.select(r5));
        if (r7.type() == Proxy.Type.HTTP) goto L12;
        return null;
    L12:
        if ((r7.address() instanceof InetSocketAddress) == false) goto L15;
        InetSocketAddress r8 = (InetSocketAddress) r7.address();
        return new HttpHost(getHost(r8), r8.getPort());
    L15:
        throw new HttpException("Unable to handle non-Inet proxy address: " + r7.address());
    L17:
        e = move-exception;
        throw new HttpException("Cannot convert host to URI: " + r2, e);
    }

    private String getHost(InetSocketAddress r1) {
        if (r1.isUnresolved() == false) goto L6;
        return r1.getHostName();
    L6:
        return r1.getAddress().getHostAddress();
    }

    private Proxy chooseProxy(List<Proxy> r5) {
        Proxy r4 = null;
        int r0 = 0;
    L3:
        if (r4 != null) goto L13;
        if (r0 >= r5.size()) goto L13;
        Proxy r1 = r5.get(r0);
        int r2 = AnonymousClass1.$SwitchMap$java$net$Proxy$Type[r1.type().ordinal()];
        if (r2 != 1) goto L9;
    L11:
        r4 = r1;
    L12:
        r0 = r0 + 1;
        goto L3
    L9:
        if (r2 == 2) goto L11;
    L13:
        if (r4 == null) goto L15;
        return r4;
    L15:
        return Proxy.NO_PROXY;
    }
}
