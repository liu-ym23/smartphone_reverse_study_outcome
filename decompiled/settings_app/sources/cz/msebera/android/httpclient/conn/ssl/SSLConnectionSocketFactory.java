package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcherLoader;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
public class SSLConnectionSocketFactory implements LayeredConnectionSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = null;

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;
    public static final String TAG = "SSLConnSockFact";
    public static final String TLS = "TLS";
    private static final String WEAK_CIPHERS = "^(TLS|SSL)_(.*)_WITH_(NULL|DES_CBC|DES40_CBC|DES_CBC_40|3DES_EDE_CBC|RC4_128|RC4_40|RC2_CBC_40)_(.*)";
    private static final List<Pattern> WEAK_CIPHER_SUITE_PATTERNS = null;
    private static final String WEAK_KEY_EXCHANGES = "^(TLS|SSL)_(NULL|ECDH_anon|DH_anon|DH_anon_EXPORT|DHE_RSA_EXPORT|DHE_DSS_EXPORT|DSS_EXPORT|DH_DSS_EXPORT|DH_RSA_EXPORT|RSA_EXPORT|KRB5_EXPORT)_(.*)";
    private final HostnameVerifier hostnameVerifier;
    public HttpClientAndroidLog log;
    private final javax.net.ssl.SSLSocketFactory socketfactory;
    private final String[] supportedCipherSuites;
    private final String[] supportedProtocols;

    protected void prepareSocket(SSLSocket r1) throws IOException {
    }

    static {
        ALLOW_ALL_HOSTNAME_VERIFIER = AllowAllHostnameVerifier.INSTANCE;
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = BrowserCompatHostnameVerifier.INSTANCE;
        STRICT_HOSTNAME_VERIFIER = StrictHostnameVerifier.INSTANCE;
        WEAK_CIPHER_SUITE_PATTERNS = Collections.unmodifiableList(Arrays.asList(new Pattern[]{Pattern.compile(WEAK_KEY_EXCHANGES, 2), Pattern.compile(WEAK_CIPHERS, 2)}));
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        return new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault());
    }

    public static SSLConnectionSocketFactory getSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory(cz.msebera.android.httpclient.ssl.SSLContexts.createDefault(), getDefaultHostnameVerifier());
    }

    static boolean isWeakCipherSuite(String r2) {
        Iterator<Pattern> r0 = WEAK_CIPHER_SUITE_PATTERNS.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().matcher(r2).matches() == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static String[] split(String r1) {
        if (TextUtils.isBlank(r1) == false) goto L7;
        return null;
    L7:
        return r1.split(" *, *");
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory((javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), getDefaultHostnameVerifier());
    }

    public SSLConnectionSocketFactory(SSLContext r2) {
        this(r2, getDefaultHostnameVerifier());
    }

    @Deprecated
    public SSLConnectionSocketFactory(SSLContext r2, X509HostnameVerifier r3) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), null, null, r3);
    }

    @Deprecated
    public SSLConnectionSocketFactory(SSLContext r2, String[] r3, String[] r4, X509HostnameVerifier r5) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), r3, r4, r5);
    }

    @Deprecated
    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory r2, X509HostnameVerifier r3) {
        this(r2, null, null, r3);
    }

    @Deprecated
    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory r1, String[] r2, String[] r3, X509HostnameVerifier r4) {
        this(r1, r2, r3, r4);
    }

    public SSLConnectionSocketFactory(SSLContext r2, HostnameVerifier r3) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), null, null, r3);
    }

    public SSLConnectionSocketFactory(SSLContext r2, String[] r3, String[] r4, HostnameVerifier r5) {
        this(((SSLContext) Args.notNull(r2, "SSL context")).getSocketFactory(), r3, r4, r5);
    }

    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory r2, HostnameVerifier r3) {
        this(r2, null, null, r3);
    }

    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory r3, String[] r4, String[] r5, HostnameVerifier r6) {
        this.log = new HttpClientAndroidLog(getClass());
        this.socketfactory = (javax.net.ssl.SSLSocketFactory) Args.notNull(r3, "SSL socket factory");
        this.supportedProtocols = r4;
        this.supportedCipherSuites = r5;
        if (r6 != null) goto L6;
        r6 = getDefaultHostnameVerifier();
    L6:
        this.hostnameVerifier = r6;
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext r1) throws IOException {
        return SocketFactory.getDefault().createSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int r3, Socket r4, HttpHost r5, InetSocketAddress r6, InetSocketAddress r7, HttpContext r8) throws IOException {
        Args.notNull(r5, "HTTP host");
        Args.notNull(r6, "Remote address");
        if (r4 != null) goto L6;
        r4 = createSocket(r8);
    L6:
        if (r7 == null) goto L8;
        r4.bind(r7);
    L8:
        if (r3 <= 0) goto L13;
    L22:
        e = move-exception;
        r4.close();     // Catch: IOException -> L25
    L24:
        throw e;
    L10:
        if (r4.getSoTimeout() != 0) goto L13;
        r4.setSoTimeout(r3);     // Catch: IOException -> L22
    L13:
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Connecting socket to " + r6 + " with timeout " + r3);     // Catch: IOException -> L22
    L15:
        r4.connect(r6, r3);     // Catch: IOException -> L22
        if ((r4 instanceof SSLSocket) == false) goto L21;
        SSLSocket r9 = (SSLSocket) r4;
        this.log.debug("Starting handshake");
        r9.startHandshake();
        verifyHostname(r9, r5.getHostName());
        return r4;
    L21:
        return createLayeredSocket(r4, r5.getHostName(), r6.getPort(), r8);
    }

    @Override // cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory
    public Socket createLayeredSocket(Socket r7, String r8, int r9, HttpContext r10) throws IOException {
        SSLSocket r11 = (SSLSocket) this.socketfactory.createSocket(r7, r8, r9, true);
        String[] r12 = this.supportedProtocols;
        if (r12 == null) goto L5;
        r11.setEnabledProtocols(r12);
    L14:
        String[] r13 = this.supportedCipherSuites;
        if (r13 == null) goto L17;
        r11.setEnabledCipherSuites(r13);
    L27:
        if (this.log.isDebugEnabled() == false) goto L29;
        this.log.debug("Enabled protocols: " + Arrays.asList(r11.getEnabledProtocols()));
        this.log.debug("Enabled cipher suites:" + Arrays.asList(r11.getEnabledCipherSuites()));
    L29:
        prepareSocket(r11);
        if (this.log.isDebugEnabled() == false) goto L40;
        this.log.debug("Enabling SNI for " + r8);
    L40:
        r11.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(r11, new Object[]{r8});     // Catch: Exception -> L34
    L38:
        this.log.debug("Starting handshake");
        r11.startHandshake();
        verifyHostname(r11, r8);
        return r11;
    L34:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L38;
        this.log.debug("SNI configuration failed", e);
        goto L38
    L17:
        String[] r14 = r11.getEnabledCipherSuites();
        ArrayList r1 = new ArrayList(r14.length);
        int r2 = r14.length;
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L24;
        String r4 = r14[r3];
        if (isWeakCipherSuite(r4) == true) goto L22;
        r1.add(r4);
    L22:
        r3 = r3 + 1;
        goto L18
    L24:
        if (r1.isEmpty() == true) goto L27;
        r11.setEnabledCipherSuites((String[]) r1.toArray(new String[r1.size()]));
        goto L27
    L5:
        String[] r15 = r11.getEnabledProtocols();
        ArrayList r5 = new ArrayList(r15.length);
        int r6 = r15.length;
        int r16 = 0;
    L6:
        if (r16 >= r6) goto L12;
        String r17 = r15[r16];
        if (r17.startsWith("SSL") == true) goto L10;
        r5.add(r17);
    L10:
        r16 = r16 + 1;
        goto L6
    L12:
        if (r5.isEmpty() == true) goto L14;
        r11.setEnabledProtocols((String[]) r5.toArray(new String[r5.size()]));
        goto L14
    }

    private void verifyHostname(SSLSocket r9, String r10) throws IOException {
        SSLSession r3 = r9.getSession();     // Catch: IOException -> L37
        if (r3 != null) goto L8;
        r9.getInputStream().available();     // Catch: IOException -> L37
        r3 = r9.getSession();     // Catch: IOException -> L37
        if (r3 != null) goto L8;
        r9.startHandshake();     // Catch: IOException -> L37
        r3 = r9.getSession();     // Catch: IOException -> L37
    L8:
        if (r3 == null) goto L36;
        if (this.log.isDebugEnabled() == false) goto L31;
        this.log.debug("Secure session established");     // Catch: IOException -> L37
        this.log.debug(" negotiated protocol: " + r3.getProtocol());     // Catch: IOException -> L37
        this.log.debug(" negotiated cipher suite: " + r3.getCipherSuite());     // Catch: IOException -> L37
        X509Certificate r1 = (X509Certificate) r3.getPeerCertificates()[0];     // Catch: Exception -> L40 IOException -> L37
        this.log.debug(" peer principal: " + r1.getSubjectX500Principal().toString());     // Catch: Exception -> L40 IOException -> L37
        Collection<List<?>> r0 = r1.getSubjectAlternativeNames();     // Catch: Exception -> L40 IOException -> L37
        if (r0 == null) goto L21;
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L40 IOException -> L37
        Iterator<List<?>> r2 = r0.iterator();     // Catch: Exception -> L40 IOException -> L37
    L16:
        if (r2.hasNext() == false) goto L20;
        List<?> r6 = r2.next();     // Catch: Exception -> L40 IOException -> L37
        if (r6.isEmpty() == true) goto L16;
        r4.add((String) r6.get(1));     // Catch: Exception -> L40 IOException -> L37
        goto L16
    L20:
        this.log.debug(" peer alternative names: " + r4);     // Catch: Exception -> L40 IOException -> L37
    L21:
        this.log.debug(" issuer principal: " + r1.getIssuerX500Principal().toString());     // Catch: Exception -> L40 IOException -> L37
        Collection<List<?>> r5 = r1.getIssuerAlternativeNames();     // Catch: Exception -> L40 IOException -> L37
        if (r5 == null) goto L31;
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L40 IOException -> L37
        Iterator<List<?>> r8 = r5.iterator();     // Catch: Exception -> L40 IOException -> L37
    L25:
        if (r8.hasNext() == false) goto L29;
        List<?> r11 = r8.next();     // Catch: Exception -> L40 IOException -> L37
        if (r11.isEmpty() == true) goto L25;
        r7.add((String) r11.get(1));     // Catch: Exception -> L40 IOException -> L37
        goto L25
    L29:
        this.log.debug(" issuer alternative names: " + r7);     // Catch: Exception -> L40 IOException -> L37
    L31:
        if (this.hostnameVerifier.verify(r10, r3) == false) goto L34;
        return;
    L34:
        throw new SSLPeerUnverifiedException("Certificate for <" + r10 + "> doesn't match any of the subject alternative names: " + DefaultHostnameVerifier.getSubjectAltNames((X509Certificate) r3.getPeerCertificates()[0]));     // Catch: IOException -> L37
    L36:
        throw new SSLHandshakeException("SSL session not available");     // Catch: IOException -> L37
    L37:
        e = move-exception;
        r9.close();     // Catch: Exception -> L41
    L39:
        throw e;
    }
}
