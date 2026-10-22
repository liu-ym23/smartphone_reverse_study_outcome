package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE = null;

    @Override // cz.msebera.android.httpclient.client.UserTokenHandler
    public Object getUserToken(HttpContext r1) {
        return null;
    }

    public NoopUserTokenHandler() {
    }

    static {
        INSTANCE = new NoopUserTokenHandler();
    }
}
