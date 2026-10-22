package cz.msebera.android.httpclient.auth;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidCredentialsException extends AuthenticationException {
    private static final long serialVersionUID = -4834003835215460648L;

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String r1) {
        super(r1);
    }

    public InvalidCredentialsException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
