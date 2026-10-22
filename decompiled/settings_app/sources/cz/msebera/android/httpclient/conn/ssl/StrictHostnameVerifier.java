package cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class StrictHostnameVerifier extends AbstractVerifier {
    public static final StrictHostnameVerifier INSTANCE = null;

    public final String toString() {
        return "STRICT";
    }

    public StrictHostnameVerifier() {
    }

    static {
        INSTANCE = new StrictHostnameVerifier();
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String r2, String[] r3, String[] r4) throws SSLException {
        verify(r2, r3, r4, true);
    }
}
