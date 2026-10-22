package cz.msebera.android.httpclient.conn.ssl;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class AllowAllHostnameVerifier extends AbstractVerifier {
    public static final AllowAllHostnameVerifier INSTANCE = null;

    public final String toString() {
        return "ALLOW_ALL";
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String r1, String[] r2, String[] r3) {
    }

    public AllowAllHostnameVerifier() {
    }

    static {
        INSTANCE = new AllowAllHostnameVerifier();
    }
}
