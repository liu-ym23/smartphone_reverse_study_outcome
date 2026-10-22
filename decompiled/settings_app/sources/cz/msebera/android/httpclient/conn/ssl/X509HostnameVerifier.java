package cz.msebera.android.httpclient.conn.ssl;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface X509HostnameVerifier extends HostnameVerifier {
    void verify(String r1, X509Certificate r2) throws SSLException;

    void verify(String r1, SSLSocket r2) throws IOException;

    void verify(String r1, String[] r2, String[] r3) throws SSLException;
}
