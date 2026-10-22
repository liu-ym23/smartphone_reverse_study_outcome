package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.protocol.ClientContext;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry r3) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Scheme registry");
        this.schemeRegistry = r3;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    public DefaultClientConnectionOperator(SchemeRegistry r3, DnsResolver r4) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Scheme registry");
        Args.notNull(r4, "DNS resolver");
        this.schemeRegistry = r3;
        this.dnsResolver = r4;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    private SchemeRegistry getSchemeRegistry(HttpContext r2) {
        SchemeRegistry r3 = (SchemeRegistry) r2.getAttribute(ClientContext.SCHEME_REGISTRY);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return this.schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    public void openConnection(OperatedClientConnection r17, HttpHost r18, InetAddress r19, HttpContext r20, HttpParams r21) throws IOException {
        Args.notNull(r17, "Connection");
        Args.notNull(r18, "Target host");
        Args.notNull(r21, "HTTP parameters");
        int r7 = 1;
        Asserts.check(!r17.isOpen(), "Connection must not be open");
        Scheme r0 = getSchemeRegistry(r20).getScheme(r18.getSchemeName());
        SchemeSocketFactory r8 = r0.getSchemeSocketFactory();
        InetAddress[] r9 = resolveHostname(r18.getHostName());
        int r10 = r0.resolvePort(r18.getPort());
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r9.length) goto L32;
        InetAddress r1 = r9[r12];
        if (r12 != (r9.length - r7)) goto L8;
        int r13 = r7;
    L9:
        Socket r14 = r8.createSocket(r21);
        r17.opening(r14, r18);
        HttpInetSocketAddress r15 = new HttpInetSocketAddress(r18, r1, r10);
        if (r19 == 0) goto L12;
        InetSocketAddress r2 = new InetSocketAddress(r19, r11);
    L14:
        if (this.log.isDebugEnabled() == false) goto L33;
        this.log.debug("Connecting to " + r15);
    L33:
        Socket r3 = r8.connectSocket(r14, r15, r2, r21);     // Catch: ConnectTimeoutException -> L21 ConnectException -> L25
        if (r14 == r3) goto L19;
        r17.opening(r3, r18);     // Catch: ConnectTimeoutException -> L21 ConnectException -> L25
        r14 = r3;
    L19:
        prepareSocket(r14, r20, r21);     // Catch: ConnectTimeoutException -> L21 ConnectException -> L25
        r17.openCompleted(r8.isSecure(r14), r21);     // Catch: ConnectTimeoutException -> L21 ConnectException -> L25
    L20:
        return;
    L21:
        e = move-exception;
        if (r13 != 0) goto L24;
    L28:
        if (this.log.isDebugEnabled() == false) goto L30;
        this.log.debug("Connect to " + r15 + " timed out. Connection will be retried using another IP address");
    L30:
        r12 = r12 + 1;
        r7 = 1;
        r11 = 0;
        goto L4
    L24:
        throw e;
    L25:
        e = move-exception;
        if (r13 == 0) goto L28;
        throw e;
    L12:
        r2 = null;
        goto L14
    L8:
        r13 = r11;
        goto L9
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection r6, HttpHost r7, HttpContext r8, HttpParams r9) throws IOException {
        Args.notNull(r6, "Connection");
        Args.notNull(r7, "Target host");
        Args.notNull(r9, "Parameters");
        Asserts.check(r6.isOpen(), "Connection must be open");
        Scheme r0 = getSchemeRegistry(r8).getScheme(r7.getSchemeName());
        Asserts.check(r0.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory r1 = (SchemeLayeredSocketFactory) r0.getSchemeSocketFactory();
        Socket r2 = r1.createLayeredSocket(r6.getSocket(), r7.getHostName(), r0.resolvePort(r7.getPort()), r9);
        prepareSocket(r2, r8, r9);
        r6.update(r2, r7, r1.isSecure(r2), r9);
    }

    protected void prepareSocket(Socket r1, HttpContext r2, HttpParams r3) throws IOException {
        r1.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(r3));
        r1.setSoTimeout(HttpConnectionParams.getSoTimeout(r3));
        int r0 = HttpConnectionParams.getLinger(r3);
        if (r0 < 0) goto L9;
        if (r0 <= 0) goto L6;
        boolean r4 = true;
    L7:
        r1.setSoLinger(r4, r0);
        return;
    L6:
        r4 = false;
        goto L7
    }

    protected InetAddress[] resolveHostname(String r1) throws UnknownHostException {
        return this.dnsResolver.resolve(r1);
    }
}
