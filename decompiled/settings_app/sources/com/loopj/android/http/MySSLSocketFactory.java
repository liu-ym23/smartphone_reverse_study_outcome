package com.loopj.android.http;

import com.android.settings.AdaptConstants;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes4.dex */
public class MySSLSocketFactory extends SSLSocketFactory {
    final SSLContext sslContext;

    public MySSLSocketFactory(KeyStore r3) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r3);
        SSLContext r4 = SSLContext.getInstance("TLS");
        this.sslContext = r4;
        r4.init(null, new TrustManager[]{new AnonymousClass1(this)}, null);
    }

    public static KeyStore getKeystoreOfCA(InputStream r3) {
        BufferedInputStream r0 = null;
        KeyStore r1 = null;
        CertificateFactory r2 = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L11 CertificateException -> L13
        BufferedInputStream r4 = new BufferedInputStream(r3);     // Catch: Throwable -> L11 CertificateException -> L13
        Certificate r5 = r2.generateCertificate(r4);     // Catch: CertificateException -> L9 Throwable -> L31
        r4.close();     // Catch: IOException -> L7
    L50:
        KeyStore r6 = KeyStore.getInstance(KeyStore.getDefaultType());     // Catch: Exception -> L28
        r6.load(null, null);     // Catch: Exception -> L26
        r6.setCertificateEntry(AdaptConstants.CERTIFICATE_USAGE_CA, r5);     // Catch: Exception -> L26
        return r6;
    L26:
        e = e;
        r1 = r6;
    L29:
        e.printStackTrace();
        return r1;
    L28:
        e = e;
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r4 != null) goto L43;
    L21:
        r5 = null;
        goto L50
    L43:
        r4.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
        r0 = r4;
    L33:
        if (r0 != null) goto L48;
    L38:
        throw th;
    L48:
        r0.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L13:
        e = e;
        r4 = null;
    L11:
        th = th;
        goto L33
    }

    public static KeyStore getKeystore() {
        KeyStore r1 = KeyStore.getInstance(KeyStore.getDefaultType());     // Catch: Throwable -> L8
        r1.load(null, null);     // Catch: Throwable -> L6
    L11:
        return r1;
    L6:
        Throwable th = th;
    L10:
        th.printStackTrace();
    L8:
        th = move-exception;
        r1 = null;
        th = th;
        goto L10
    }

    public static SSLSocketFactory getFixedSocketFactory() {
        MySSLSocketFactory r0 = new MySSLSocketFactory(getKeystore());     // Catch: Throwable -> L4
        r0.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        th.printStackTrace();
        return SSLSocketFactory.getSocketFactory();
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore r5) {
        MySSLSocketFactory r0 = new MySSLSocketFactory(r5);     // Catch: Exception -> L4
        SchemeRegistry r6 = new SchemeRegistry();     // Catch: Exception -> L4
        r6.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));     // Catch: Exception -> L4
        r6.register(new Scheme(HttpHeadTimeFetcher.FETCHER_TYPE, r0, 443));     // Catch: Exception -> L4
        BasicHttpParams r1 = new BasicHttpParams();     // Catch: Exception -> L4
        HttpProtocolParams.setVersion(r1, HttpVersion.HTTP_1_1);     // Catch: Exception -> L4
        HttpProtocolParams.setContentCharset(r1, "UTF-8");     // Catch: Exception -> L4
        return new DefaultHttpClient(new ThreadSafeClientConnManager(r1, r6), r1);
    L5:
        return new DefaultHttpClient();
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory, cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) throws IOException {
        Socket r6 = this.sslContext.getSocketFactory().createSocket(r2, r3, r4, r5);
        enableSecureProtocols(r6);
        return r6;
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory, cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket r0 = this.sslContext.getSocketFactory().createSocket();
        enableSecureProtocols(r0);
        return r0;
    }

    private void enableSecureProtocols(Socket r1) {
        ((SSLSocket) r1).setEnabledProtocols(this.sslContext.getSupportedSSLParameters().getProtocols());
    }

    public void fixHttpsURLConnection() {
        HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
    }
}
