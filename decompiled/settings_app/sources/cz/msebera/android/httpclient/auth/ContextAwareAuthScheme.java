package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ContextAwareAuthScheme extends AuthScheme {
    Header authenticate(Credentials r1, HttpRequest r2, HttpContext r3) throws AuthenticationException;
}
