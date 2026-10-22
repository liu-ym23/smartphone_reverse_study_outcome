package cz.msebera.android.httpclient.auth.params;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class AuthParams {
    private AuthParams() {
    }

    public static String getCredentialCharset(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        String r2 = (String) r1.getParameter(AuthPNames.CREDENTIAL_CHARSET);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return HTTP.DEF_PROTOCOL_CHARSET.name();
    }

    public static void setCredentialCharset(HttpParams r1, String r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter(AuthPNames.CREDENTIAL_CHARSET, r2);
    }
}
