package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.ProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class AuthenticationException extends ProtocolException {
    private static final long serialVersionUID = -6794031905674764776L;

    public AuthenticationException() {
    }

    public AuthenticationException(String r1) {
        super(r1);
    }

    public AuthenticationException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
