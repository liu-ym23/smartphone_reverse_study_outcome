package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public class AuthState {
    private Queue<AuthOption> authOptions;
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;
    private AuthProtocolState state;

    public AuthState() {
        this.state = AuthProtocolState.UNCHALLENGED;
    }

    public void reset() {
        this.state = AuthProtocolState.UNCHALLENGED;
        this.authOptions = null;
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    public AuthProtocolState getState() {
        return this.state;
    }

    public void setState(AuthProtocolState r1) {
        if (r1 != null) goto L5;
        r1 = AuthProtocolState.UNCHALLENGED;
    L5:
        this.state = r1;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void update(AuthScheme r2, Credentials r3) {
        Args.notNull(r2, "Auth scheme");
        Args.notNull(r3, "Credentials");
        this.authScheme = r2;
        this.credentials = r3;
        this.authOptions = null;
    }

    public Queue<AuthOption> getAuthOptions() {
        return this.authOptions;
    }

    public boolean hasAuthOptions() {
        Queue<AuthOption> r0 = this.authOptions;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public boolean isConnectionBased() {
        AuthScheme r0 = this.authScheme;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isConnectionBased() == false) goto L7;
        return true;
    }

    public void update(Queue<AuthOption> r2) {
        Args.notEmpty(r2, "Queue of auth options");
        this.authOptions = r2;
        this.authScheme = null;
        this.credentials = null;
    }

    @Deprecated
    public void invalidate() {
        reset();
    }

    @Deprecated
    public boolean isValid() {
        if (this.authScheme == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public void setAuthScheme(AuthScheme r1) {
        if (r1 != null) goto L5;
        reset();
        return;
    L5:
        this.authScheme = r1;
    }

    @Deprecated
    public void setCredentials(Credentials r1) {
        this.credentials = r1;
    }

    @Deprecated
    public AuthScope getAuthScope() {
        return this.authScope;
    }

    @Deprecated
    public void setAuthScope(AuthScope r1) {
        this.authScope = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("state:");
        r0.append(this.state).append(";");
        if (this.authScheme == null) goto L6;
        r0.append("auth scheme:").append(this.authScheme.getSchemeName()).append(";");
    L6:
        if (this.credentials == null) goto L9;
        r0.append("credentials present");
    L9:
        return r0.toString();
    }
}
