package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.params.AuthPNames;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    public DefaultTargetAuthenticationHandler() {
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationHandler
    public boolean isAuthenticationRequested(HttpResponse r1, HttpContext r2) {
        Args.notNull(r1, "HTTP response");
        if (r1.getStatusLine().getStatusCode() != 401) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationHandler
    public Map<String, Header> getChallenges(HttpResponse r1, HttpContext r2) throws MalformedChallengeException {
        Args.notNull(r1, "HTTP response");
        return parseChallenges(r1.getHeaders("WWW-Authenticate"));
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractAuthenticationHandler
    protected List<String> getAuthPreferences(HttpResponse r3, HttpContext r4) {
        List<String> r0 = (List) r3.getParams().getParameter(AuthPNames.TARGET_AUTH_PREF);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.getAuthPreferences(r3, r4);
    }
}
