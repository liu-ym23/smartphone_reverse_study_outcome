package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public interface AuthenticationStrategy {
    void authFailed(HttpHost r1, AuthScheme r2, HttpContext r3);

    void authSucceeded(HttpHost r1, AuthScheme r2, HttpContext r3);

    Map<String, Header> getChallenges(HttpHost r1, HttpResponse r2, HttpContext r3) throws MalformedChallengeException;

    boolean isAuthenticationRequested(HttpHost r1, HttpResponse r2, HttpContext r3);

    Queue<AuthOption> select(Map<String, Header> r1, HttpHost r2, HttpResponse r3, HttpContext r4) throws MalformedChallengeException;
}
