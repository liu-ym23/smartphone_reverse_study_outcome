package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface AuthenticationHandler {
    Map<String, Header> getChallenges(HttpResponse r1, HttpContext r2) throws MalformedChallengeException;

    boolean isAuthenticationRequested(HttpResponse r1, HttpContext r2);

    AuthScheme selectScheme(Map<String, Header> r1, HttpResponse r2, HttpContext r3) throws AuthenticationException;
}
