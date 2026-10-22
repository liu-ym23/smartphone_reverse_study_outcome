package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public class TargetAuthenticationStrategy extends AuthenticationStrategyImpl {
    public static final TargetAuthenticationStrategy INSTANCE = null;

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authFailed(HttpHost r1, AuthScheme r2, HttpContext r3) {
        super.authFailed(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authSucceeded(HttpHost r1, AuthScheme r2, HttpContext r3) {
        super.authSucceeded(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Map getChallenges(HttpHost r1, HttpResponse r2, HttpContext r3) throws MalformedChallengeException {
        return super.getChallenges(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ boolean isAuthenticationRequested(HttpHost r1, HttpResponse r2, HttpContext r3) {
        return super.isAuthenticationRequested(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Queue select(Map r1, HttpHost r2, HttpResponse r3, HttpContext r4) throws MalformedChallengeException {
        return super.select(r1, r2, r3, r4);
    }

    static {
        INSTANCE = new TargetAuthenticationStrategy();
    }

    public TargetAuthenticationStrategy() {
        super(401, "WWW-Authenticate");
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl
    Collection<String> getPreferredAuthSchemes(RequestConfig r1) {
        return r1.getTargetPreferredAuthSchemes();
    }
}
