package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public interface AuthScheme {
    @Deprecated
    Header authenticate(Credentials r1, HttpRequest r2) throws AuthenticationException;

    String getParameter(String r1);

    String getRealm();

    String getSchemeName();

    boolean isComplete();

    boolean isConnectionBased();

    void processChallenge(Header r1) throws MalformedChallengeException;
}
