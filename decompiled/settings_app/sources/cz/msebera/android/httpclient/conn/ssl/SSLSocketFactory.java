package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.scheme.HostNameResolver;
import cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SSLSocketFactory implements LayeredConnectionSocketFactory, SchemeLayeredSocketFactory, LayeredSchemeSocketFactory, LayeredSocketFactory {
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = null;
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;
    public static final String TLS = "TLS";
    private volatile X509HostnameVerifier hostnameVerifier;
    private final HostNameResolver nameResolver;
    private final javax.net.ssl.SSLSocketFactory socketfactory;
    private final String[] supportedCipherSuites;
    private final String[] supportedProtocols;

    protected void prepareSocket(SSLSocket r1) throws IOException {
    }

    static {
        ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
        STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    }

    public static SSLSocketFactory getSocketFactory() throws SSLInitializationException {
        return new SSLSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private static String[] split(String r1) {
        if (TextUtils.isBlank(r1) == false) goto L7;
        return null;
    L7:
        return r1.split(" *, *");
    }

    public static SSLSocketFactory getSystemSocketFactory() throws SSLInitializationException {
        return new SSLSocketFactory((javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(String r2, KeyStore r3, String r4, KeyStore r5, SecureRandom r6, HostNameResolver r7) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        SSLContextBuilder r8 = SSLContexts.custom().useProtocol(r2).setSecureRandom(r6);
        if (r4 == null) goto L5;
        char[] r9 = r4.toCharArray();
    L6:
        this(r8.loadKeyMaterial(r3, r9).loadTrustMaterial(r5).build(), r7);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public SSLSocketFactory(String r2, KeyStore r3, String r4, KeyStore r5, SecureRandom r6, TrustStrategy r7, X509HostnameVerifier r8) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        SSLContextBuilder r9 = SSLContexts.custom().useProtocol(r2).setSecureRandom(r6);
        if (r4 == null) goto L5;
        char[] r10 = r4.toCharArray();
    L6:
        this(r9.loadKeyMaterial(r3, r10).loadTrustMaterial(r5, r7).build(), r8);
        return;
    L5:
        r10 = null;
        goto L6
    }

    public SSLSocketFactory(String r2, KeyStore r3, String r4, KeyStore r5, SecureRandom r6, X509HostnameVerifier r7) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        SSLContextBuilder r8 = SSLContexts.custom().useProtocol(r2).setSecureRandom(r6);
        if (r4 == null) goto L5;
        char[] r9 = r4.toCharArray();
    L6:
        this(r8.loadKeyMaterial(r3, r9).loadTrustMaterial(r5).build(), r7);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public SSLSocketFactory(KeyStore r2, String r3, KeyStore r4) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        SSLContextBuilder r0 = SSLContexts.custom();
        if (r3 == null) goto L5;
        char[] r5 = r3.toCharArray();
    L6:
        this(r0.loadKeyMaterial(r2, r5).loadTrustMaterial(r4).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public SSLSocketFactory(KeyStore r2, String r3) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        SSLContextBuilder r0 = SSLContexts.custom();
        if (r3 == null) goto L5;
        char[] r4 = r3.toCharArray();
    L6:
        this(r0.loadKeyMaterial(r2, r4).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public SSLSocketFactory(KeyStore r2) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(SSLContexts.custom().loadTrustMaterial(r2).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(TrustStrategy r3, X509HostnameVerifier r4) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(SSLContexts.custom().loadTrustMaterial(null, r3).build(), r4);
    }

    public SSLSocketFactory(TrustStrategy r3) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(SSLContexts.custom().loadTrustMaterial(null, r3).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(SSLContext r2) {
        this(r2, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(SSLContext r1, HostNameResolver r2) {
        this.socketfactory = r1.getSocketFactory();
        this.hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        this.nameResolver = r2;
        this.supportedProtocols = null;
        this.supportedCipherSuites = null;
    }

    public SSLSocketFactory(SSLContext r2, X509HostnameVerifier r3) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), null, null, r3);
    }

    public SSLSocketFactory(SSLContext r2, String[] r3, String[] r4, X509HostnameVerifier r5) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), r3, r4, r5);
    }

    public SSLSocketFactory(javax.net.ssl.SSLSocketFactory r2, X509HostnameVerifier r3) {
        this(r2, null, null, r3);
    }

    public SSLSocketFactory(javax.net.ssl.SSLSocketFactory r2, String[] r3, String[] r4, X509HostnameVerifier r5) {
        this.socketfactory = (javax.net.ssl.SSLSocketFactory) Args.notNull(r2, "SSL socket factory");
        this.supportedProtocols = r3;
        this.supportedCipherSuites = r4;
        if (r5 != null) goto L6;
        r5 = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    L6:
        this.hostnameVerifier = r5;
        this.nameResolver = null;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams r2) throws IOException {
        HttpContext r0 = (HttpContext) null;
        return createSocket(null);
    }

    public Socket createSocket() throws IOException {
        HttpContext r1 = (HttpContext) null;
        return createSocket(null);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket r12, InetSocketAddress r13, InetSocketAddress r14, HttpParams r15) throws IOException, UnknownHostException, ConnectTimeoutException {
        Args.notNull(r13, "Remote address");
        Args.notNull(r15, "HTTP parameters");
        if ((r13 instanceof HttpInetSocketAddress) == false) goto L5;
        HttpHost r0 = ((HttpInetSocketAddress) r13).getHttpHost();
    L6:
        HttpHost r7 = r0;
        int r1 = HttpConnectionParams.getSoTimeout(r15);
        int r5 = HttpConnectionParams.getConnectionTimeout(r15);
        r12.setSoTimeout(r1);
        return connectSocket(r5, r12, r7, r13, r14, null);
    L5:
        r0 = new HttpHost(r13.getHostName(), r13.getPort(), HttpHeadTimeFetcher.FETCHER_TYPE);
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket r2) throws IllegalArgumentException {
        Args.notNull(r2, "Socket");
        Asserts.check(r2 instanceof SSLSocket, "Socket not created by this factory");
        Asserts.check(!r2.isClosed(), "Socket is closed");
        return true;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket r2, String r3, int r4, HttpParams r5) throws IOException, UnknownHostException {
        HttpContext r0 = (HttpContext) null;
        return createLayeredSocket(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory
    public Socket createLayeredSocket(Socket r2, String r3, int r4, boolean r5) throws IOException, UnknownHostException {
        HttpContext r0 = (HttpContext) null;
        return createLayeredSocket(r2, r3, r4, null);
    }

    public void setHostnameVerifier(X509HostnameVerifier r2) {
        Args.notNull(r2, "Hostname verifier");
        this.hostnameVerifier = r2;
    }

    public X509HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket r3, String r4, int r5, InetAddress r6, int r7, HttpParams r8) throws IOException, UnknownHostException, ConnectTimeoutException {
        HostNameResolver r0 = this.nameResolver;
        if (r0 == null) goto L5;
        InetAddress r1 = r0.resolve(r4);
    L6:
        if (r6 != null) goto L11;
        if (r7 > 0) goto L11;
        InetSocketAddress r9 = null;
    L16:
        return connectSocket(r3, new HttpInetSocketAddress(new HttpHost(r4, r5), r1, r5), r9, r8);
    L11:
        if (r7 > 0) goto L14;
        r7 = 0;
    L14:
        r9 = new InetSocketAddress(r6, r7);
        goto L16
    L5:
        r1 = InetAddress.getByName(r4);
        goto L6
    }

    public Socket createSocket(Socket r1, String r2, int r3, boolean r4) throws IOException, UnknownHostException {
        return createLayeredSocket(r1, r2, r3, r4);
    }

    private void internalPrepareSocket(SSLSocket r2) throws IOException {
        String[] r0 = this.supportedProtocols;
        if (r0 == null) goto L5;
        r2.setEnabledProtocols(r0);
    L5:
        String[] r1 = this.supportedCipherSuites;
        if (r1 == null) goto L8;
        r2.setEnabledCipherSuites(r1);
    L8:
        prepareSocket(r2);
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext r1) throws IOException {
        return SocketFactory.getDefault().createSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int r2, Socket r3, HttpHost r4, InetSocketAddress r5, InetSocketAddress r6, HttpContext r7) throws IOException {
        Args.notNull(r4, "HTTP host");
        Args.notNull(r5, "Remote address");
        if (r3 != null) goto L6;
        r3 = createSocket(r7);
    L6:
        if (r6 == null) goto L17;
        r3.bind(r6);
    L17:
        r3.connect(r5, r2);     // Catch: SocketTimeoutException -> L15
        if ((r3 instanceof SSLSocket) == false) goto L14;
        SSLSocket r8 = (SSLSocket) r3;
        r8.startHandshake();
        verifyHostname(r8, r4.getHostName());
        return r3;
    L14:
        return createLayeredSocket(r3, r4.getHostName(), r5.getPort(), r7);
    L16:
        throw new ConnectTimeoutException("Connect to " + r5 + " timed out");
    }

    @Override // cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory
    public Socket createLayeredSocket(Socket r2, String r3, int r4, HttpContext r5) throws IOException {
        SSLSocket r6 = (SSLSocket) this.socketfactory.createSocket(r2, r3, r4, true);
        internalPrepareSocket(r6);
        r6.startHandshake();
        verifyHostname(r6, r3);
        return r6;
    }

    private void verifyHostname(SSLSocket r1, String r2) throws IOException {
        this.hostnameVerifier.verify(r2, r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        r1.close();     // Catch: Exception -> L7
    L6:
        throw e;
    }
}
