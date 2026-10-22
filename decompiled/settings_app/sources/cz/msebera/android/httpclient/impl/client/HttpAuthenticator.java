package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpAuthenticator extends cz.msebera.android.httpclient.impl.auth.HttpAuthenticator {
    public HttpAuthenticator(HttpClientAndroidLog r1) {
        super(r1);
    }

    public HttpAuthenticator() {
    }

    public boolean authenticate(HttpHost r1, HttpResponse r2, AuthenticationStrategy r3, AuthState r4, HttpContext r5) {
        return handleAuthChallenge(r1, r2, r3, r4, r5);
    }
}
