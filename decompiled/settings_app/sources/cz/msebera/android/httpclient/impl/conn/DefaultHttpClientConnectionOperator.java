package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionOperator;
import cz.msebera.android.httpclient.conn.HttpHostConnectException;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpClientConnectionOperator implements HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    public DefaultHttpClientConnectionOperator(Lookup<ConnectionSocketFactory> r3, SchemePortResolver r4, DnsResolver r5) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Socket factory registry");
        this.socketFactoryRegistry = r3;
        if (r4 != null) goto L6;
        r4 = DefaultSchemePortResolver.INSTANCE;
    L6:
        this.schemePortResolver = r4;
        if (r5 != null) goto L10;
        r5 = SystemDefaultDnsResolver.INSTANCE;
    L10:
        this.dnsResolver = r5;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext r2) {
        Lookup<ConnectionSocketFactory> r3 = (Lookup) r2.getAttribute("http.socket-factory-registry");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return this.socketFactoryRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionOperator
    public void connect(ManagedHttpClientConnection r21, HttpHost r22, InetSocketAddress r23, int r24, SocketConfig r25, HttpContext r26) throws IOException {
        ConnectionSocketFactory r12 = getSocketFactoryRegistry(r26).lookup(r22.getSchemeName());
        if (r12 == null) goto L53;
        if (r22.getAddress() == null) goto L7;
        InetAddress[] r0 = {r22.getAddress()};
    L8:
        InetAddress[] r15 = r0;
        int r9 = this.schemePortResolver.resolve(r22);
        int r8 = 0;
    L10:
        if (r8 >= r15.length) goto L51;
        InetAddress r1 = r15[r8];
        if (r8 != (r15.length - 1)) goto L14;
        boolean r16 = true;
    L15:
        Socket r5 = r12.createSocket(r26);
        r5.setSoTimeout(r25.getSoTimeout());
        r5.setReuseAddress(r25.isSoReuseAddress());
        r5.setTcpNoDelay(r25.isTcpNoDelay());
        r5.setKeepAlive(r25.isSoKeepAlive());
        if (r25.getRcvBufSize() <= 0) goto L19;
        r5.setReceiveBufferSize(r25.getRcvBufSize());
    L19:
        if (r25.getSndBufSize() <= 0) goto L21;
        r5.setSendBufferSize(r25.getSndBufSize());
    L21:
        int r3 = r25.getSoLinger();
        if (r3 < 0) goto L24;
        r5.setSoLinger(true, r3);
    L24:
        r21.bind(r5);
        InetSocketAddress r7 = new InetSocketAddress(r1, r9);
        if (this.log.isDebugEnabled() == false) goto L27;
        this.log.debug("Connecting to " + r7);
    L27:
        int r18 = r8;
        int r19 = r9;
        r21.bind(r12.connectSocket(r24, r5, r22, r7, r23, r26));     // Catch: NoRouteToHostException -> L32 ConnectException -> L36 SocketTimeoutException -> L43
        if (this.log.isDebugEnabled() == false) goto L31;
        this.log.debug("Connection established " + r21);     // Catch: NoRouteToHostException -> L32 ConnectException -> L36 SocketTimeoutException -> L43
    L64:
        return;
    L31:
        return;
    L36:
        e = move-exception;
        if (r16 == true) goto L39;
    L46:
        if (this.log.isDebugEnabled() == false) goto L48;
        this.log.debug("Connect to " + r7 + " timed out. Connection will be retried using another IP address");
    L48:
        r8 = r18 + 1;
        r9 = r19;
        goto L10
    L39:
        if ("Connection timed out".equals(e.getMessage()) == false) goto L42;
        throw new ConnectTimeoutException(e, r22, r15);
    L42:
        throw new HttpHostConnectException(e, r22, r15);
    L32:
        e = move-exception;
        if (r16 == false) goto L46;
        throw e;
    L43:
        e = move-exception;
        if (r16 == false) goto L46;
        throw new ConnectTimeoutException(e, r22, r15);
    L14:
        r16 = false;
        goto L15
    L51:
        return;
    L7:
        r0 = this.dnsResolver.resolve(r22.getHostName());
        goto L8
    L53:
        throw new UnsupportedSchemeException(r22.getSchemeName() + " protocol is not supported");
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionOperator
    public void upgrade(ManagedHttpClientConnection r3, HttpHost r4, HttpContext r5) throws IOException {
        ConnectionSocketFactory r0 = getSocketFactoryRegistry(HttpClientContext.adapt(r5)).lookup(r4.getSchemeName());
        if (r0 == null) goto L11;
        if ((r0 instanceof LayeredConnectionSocketFactory) == false) goto L9;
        r3.bind(((LayeredConnectionSocketFactory) r0).createLayeredSocket(r3.getSocket(), r4.getHostName(), this.schemePortResolver.resolve(r4), r5));
        return;
    L9:
        throw new UnsupportedSchemeException(r4.getSchemeName() + " protocol does not support connection upgrade");
    L11:
        throw new UnsupportedSchemeException(r4.getSchemeName() + " protocol is not supported");
    }
}
