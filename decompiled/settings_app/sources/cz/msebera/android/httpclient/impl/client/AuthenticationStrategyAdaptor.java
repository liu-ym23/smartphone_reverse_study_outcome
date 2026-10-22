package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class AuthenticationStrategyAdaptor implements AuthenticationStrategy {
    private final AuthenticationHandler handler;
    public HttpClientAndroidLog log;

    public AuthenticationStrategyAdaptor(AuthenticationHandler r3) {
        this.log = new HttpClientAndroidLog(getClass());
        this.handler = r3;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public boolean isAuthenticationRequested(HttpHost r1, HttpResponse r2, HttpContext r3) {
        return this.handler.isAuthenticationRequested(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Map<String, Header> getChallenges(HttpHost r1, HttpResponse r2, HttpContext r3) throws MalformedChallengeException {
        return this.handler.getChallenges(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Queue<AuthOption> select(Map<String, Header> r4, HttpHost r5, HttpResponse r6, HttpContext r7) throws MalformedChallengeException {
        Args.notNull(r4, "Map of auth challenges");
        Args.notNull(r5, "Host");
        Args.notNull(r6, "HTTP response");
        Args.notNull(r7, "HTTP context");
        LinkedList r0 = new LinkedList();
        CredentialsProvider r1 = (CredentialsProvider) r7.getAttribute("http.auth.credentials-provider");
        if (r1 != null) goto L16;
        this.log.debug("Credentials provider not set in the context");
        return r0;
    L16:
        AuthScheme r3 = this.handler.selectScheme(r4, r6, r7);     // Catch: AuthenticationException -> L11
        r3.processChallenge(r4.get(r3.getSchemeName().toLowerCase(Locale.ROOT)));
        Credentials r8 = r1.getCredentials(new AuthScope(r5.getHostName(), r5.getPort(), r3.getRealm(), r3.getSchemeName()));
        if (r8 == null) goto L10;
        r0.add(new AuthOption(r3, r8));
    L10:
        return r0;
    L11:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L15;
        this.log.warn(e.getMessage(), e);
    L15:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authSucceeded(HttpHost r4, AuthScheme r5, HttpContext r6) {
        AuthCache r1 = (AuthCache) r6.getAttribute("http.auth.auth-cache");
        if (isCachable(r5) == false) goto L11;
        if (r1 != null) goto L7;
        r1 = new BasicAuthCache();
        r6.setAttribute("http.auth.auth-cache", r1);
    L7:
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("Caching '" + r5.getSchemeName() + "' auth scheme for " + r4);
    L9:
        r1.put(r4, r5);
        return;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authFailed(HttpHost r3, AuthScheme r4, HttpContext r5) {
        AuthCache r6 = (AuthCache) r5.getAttribute("http.auth.auth-cache");
        if (r6 != null) goto L6;
        return;
    L6:
        if (this.log.isDebugEnabled() == false) goto L8;
        this.log.debug("Removing from cache '" + r4.getSchemeName() + "' auth scheme for " + r3);
    L8:
        r6.remove(r3);
    }

    private boolean isCachable(AuthScheme r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isComplete() == true) goto L7;
        return false;
    L7:
        return r1.getSchemeName().equalsIgnoreCase("Basic");
    }

    public AuthenticationHandler getHandler() {
        return this.handler;
    }
}
