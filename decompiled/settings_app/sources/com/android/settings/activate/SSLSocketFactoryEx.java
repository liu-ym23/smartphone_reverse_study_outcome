package com.android.settings.activate;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class SSLSocketFactoryEx extends SSLSocketFactory {
    SSLContext sslContext;

    public SSLSocketFactoryEx(KeyStore r3) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r3);
        this.sslContext = SSLContext.getInstance("TLS");
        X509TrustManager r4 = new AnonymousClass1(this);
        this.sslContext.init(null, new TrustManager[]{r4}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r1, String r2, int r3, boolean r4) throws IOException, UnknownHostException {
        return this.sslContext.getSocketFactory().createSocket(r1, r2, r3, r4);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }
}
