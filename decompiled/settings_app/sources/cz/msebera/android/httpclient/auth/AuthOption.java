package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class AuthOption {
    private final AuthScheme authScheme;
    private final Credentials creds;

    public AuthOption(AuthScheme r2, Credentials r3) {
        Args.notNull(r2, "Auth scheme");
        Args.notNull(r3, "User credentials");
        this.authScheme = r2;
        this.creds = r3;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.creds;
    }

    public String toString() {
        return this.authScheme.toString();
    }
}
