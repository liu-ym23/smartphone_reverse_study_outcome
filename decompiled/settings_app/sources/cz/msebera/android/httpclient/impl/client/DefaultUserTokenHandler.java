package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultUserTokenHandler implements UserTokenHandler {
    public static final DefaultUserTokenHandler INSTANCE = null;

    public DefaultUserTokenHandler() {
    }

    static {
        INSTANCE = new DefaultUserTokenHandler();
    }

    @Override // cz.msebera.android.httpclient.client.UserTokenHandler
    public Object getUserToken(HttpContext r2) {
        HttpClientContext r1 = HttpClientContext.adapt(r2);
        AuthState r3 = r1.getTargetAuthState();
        if (r3 == null) goto L7;
        Principal r4 = getAuthPrincipal(r3);
        if (r4 != null) goto L8;
        r4 = getAuthPrincipal(r1.getProxyAuthState());
    L8:
        if (r4 != null) goto L17;
        HttpConnection r5 = r1.getConnection();
        if (r5.isOpen() == true) goto L12;
        return r4;
    L12:
        if ((r5 instanceof ManagedHttpClientConnection) == false) goto L19;
        SSLSession r6 = ((ManagedHttpClientConnection) r5).getSSLSession();
        if (r6 != null) goto L16;
        return r4;
    L16:
        return r6.getLocalPrincipal();
    L19:
        return r4;
    L17:
        return r4;
    L7:
        r4 = null;
        goto L8
    }

    private static Principal getAuthPrincipal(AuthState r2) {
        AuthScheme r0 = r2.getAuthScheme();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isComplete() == true) goto L7;
        return null;
    L7:
        if (r0.isConnectionBased() == false) goto L15;
        Credentials r3 = r2.getCredentials();
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getUserPrincipal();
    L15:
        return null;
    }
}
