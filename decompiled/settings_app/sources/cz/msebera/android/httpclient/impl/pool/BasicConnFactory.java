package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnectionFactory;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    @Override // cz.msebera.android.httpclient.pool.ConnFactory
    public /* bridge */ /* synthetic */ HttpClientConnection create(HttpHost r1) throws IOException {
        return create2(r1);
    }

    @Deprecated
    public BasicConnFactory(SSLSocketFactory r2, HttpParams r3) {
        Args.notNull(r3, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = r2;
        this.connectTimeout = r3.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
        this.sconfig = HttpParamConfig.getSocketConfig(r3);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(r3));
    }

    @Deprecated
    public BasicConnFactory(HttpParams r2) {
        this(null, r2);
    }

    public BasicConnFactory(SocketFactory r1, SSLSocketFactory r2, int r3, SocketConfig r4, ConnectionConfig r5) {
        this.plainfactory = r1;
        this.sslfactory = r2;
        this.connectTimeout = r3;
        if (r4 != null) goto L6;
        r4 = SocketConfig.DEFAULT;
    L6:
        this.sconfig = r4;
        if (r5 != null) goto L10;
        r5 = ConnectionConfig.DEFAULT;
    L10:
        this.connFactory = new DefaultBHttpClientConnectionFactory(r5);
    }

    public BasicConnFactory(int r7, SocketConfig r8, ConnectionConfig r9) {
        this(null, null, r7, r8, r9);
    }

    public BasicConnFactory(SocketConfig r7, ConnectionConfig r8) {
        this(null, null, 0, r7, r8);
    }

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    @Deprecated
    protected HttpClientConnection create(Socket r2, HttpParams r3) throws IOException {
        DefaultBHttpClientConnection r4 = new DefaultBHttpClientConnection(r3.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 8192));
        r4.bind(r2);
        return r4;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public HttpClientConnection create2(HttpHost r7) throws IOException {
        String r0 = r7.getSchemeName();
        if ("http".equalsIgnoreCase(r0) == false) goto L8;
        SocketFactory r2 = this.plainfactory;
        if (r2 == null) goto L7;
        Socket r3 = r2.createSocket();
    L10:
        if (HttpHeadTimeFetcher.FETCHER_TYPE.equalsIgnoreCase(r0) == false) goto L16;
        SocketFactory r4 = this.sslfactory;
        if (r4 != null) goto L15;
        r4 = SSLSocketFactory.getDefault();
    L15:
        r3 = r4.createSocket();
    L16:
        if (r3 == null) goto L37;
        String r1 = r7.getHostName();
        int r5 = r7.getPort();
        if (r5 == (-1)) goto L20;
    L25:
        r3.setSoTimeout(this.sconfig.getSoTimeout());
        if (this.sconfig.getSndBufSize() <= 0) goto L29;
        r3.setSendBufferSize(this.sconfig.getSndBufSize());
    L29:
        if (this.sconfig.getRcvBufSize() <= 0) goto L31;
        r3.setReceiveBufferSize(this.sconfig.getRcvBufSize());
    L31:
        r3.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int r8 = this.sconfig.getSoLinger();
        if (r8 < 0) goto L34;
        r3.setSoLinger(true, r8);
    L34:
        r3.setKeepAlive(this.sconfig.isSoKeepAlive());
        r3.connect(new InetSocketAddress(r1, r5), this.connectTimeout);
        return (HttpClientConnection) this.connFactory.createConnection(r3);
    L20:
        if (r7.getSchemeName().equalsIgnoreCase("http") == false) goto L23;
        r5 = 80;
        goto L25
    L23:
        if (r7.getSchemeName().equalsIgnoreCase(HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L25;
        r5 = 443;
        goto L25
    L37:
        throw new IOException(r0 + " scheme is not supported");
    L7:
        r3 = new Socket();
        goto L10
    L8:
        r3 = null;
        goto L10
    }
}
