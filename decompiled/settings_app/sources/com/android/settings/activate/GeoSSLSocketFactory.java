package com.android.settings.activate;

import com.android.settings.utils.GeoTrustManager;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class GeoSSLSocketFactory extends SSLSocketFactory {
    SSLContext mSSLContext;

    public GeoSSLSocketFactory(KeyStore r3) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r3);
        SSLContext r4 = SSLContext.getInstance("TLS");
        this.mSSLContext = r4;
        r4.init(null, new TrustManager[]{new GeoTrustManager()}, new SecureRandom());
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r1, String r2, int r3, boolean r4) throws IOException, UnknownHostException {
        return this.mSSLContext.getSocketFactory().createSocket(r1, r2, r3, r4);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.mSSLContext.getSocketFactory().createSocket();
    }
}
