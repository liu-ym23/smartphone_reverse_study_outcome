package cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    public static final BrowserCompatHostnameVerifier INSTANCE = null;

    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }

    public BrowserCompatHostnameVerifier() {
    }

    static {
        INSTANCE = new BrowserCompatHostnameVerifier();
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String r2, String[] r3, String[] r4) throws SSLException {
        verify(r2, r3, r4, false);
    }
}
