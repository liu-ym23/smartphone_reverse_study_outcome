package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public class HttpAuthenticator {
    private final HttpClientAndroidLog log;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.auth.HttpAuthenticator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = null;

        static {
            int[] r0 = new int[AuthProtocolState.values().length];
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0;
            r0[AuthProtocolState.CHALLENGED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.HANDSHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.UNCHALLENGED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public HttpAuthenticator(HttpClientAndroidLog r2) {
        if (r2 != null) goto L6;
        r2 = new HttpClientAndroidLog(getClass());
    L6:
        this.log = r2;
    }

    public HttpAuthenticator() {
        this(null);
    }

    public boolean isAuthenticationRequested(HttpHost r3, HttpResponse r4, AuthenticationStrategy r5, AuthState r6, HttpContext r7) {
        if (r5.isAuthenticationRequested(r3, r4, r7) == false) goto L8;
        this.log.debug("Authentication required");
        if (r6.getState() != AuthProtocolState.SUCCESS) goto L7;
        r5.authFailed(r3, r6.getAuthScheme(), r7);
    L7:
        return true;
    L8:
        int r8 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r6.getState().ordinal()];
        if (r8 != 1) goto L11;
    L15:
        this.log.debug("Authentication succeeded");
        r6.setState(AuthProtocolState.SUCCESS);
        r5.authSucceeded(r3, r6.getAuthScheme(), r7);
        return false;
    L11:
        if (r8 == 2) goto L15;
        if (r8 == 3) goto L18;
        r6.setState(AuthProtocolState.UNCHALLENGED);
        return false;
    L18:
        return false;
    }

    public boolean handleAuthChallenge(HttpHost r8, HttpResponse r9, AuthenticationStrategy r10, AuthState r11, HttpContext r12) {
    L46:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L50;
        this.log.warn("Malformed challenge: " + e.getMessage());
    L50:
        r11.reset();
        return false;
    L4:
        if (this.log.isDebugEnabled() == false) goto L6;
        this.log.debug(r8.toHostString() + " requested authentication");     // Catch: MalformedChallengeException -> L46
    L6:
        Map<String, Header> r2 = r10.getChallenges(r8, r9, r12);     // Catch: MalformedChallengeException -> L46
        if (r2.isEmpty() == false) goto L10;
        this.log.debug("Response contains no authentication challenges");     // Catch: MalformedChallengeException -> L46
        return false;
    L10:
        AuthScheme r3 = r11.getAuthScheme();     // Catch: MalformedChallengeException -> L46
        int r4 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r11.getState().ordinal()];     // Catch: MalformedChallengeException -> L46
        if (r4 != 1) goto L13;
    L23:
        if (r3 != null) goto L26;
        this.log.debug("Auth scheme is null");     // Catch: MalformedChallengeException -> L46
        r10.authFailed(r8, null, r12);     // Catch: MalformedChallengeException -> L46
        r11.reset();     // Catch: MalformedChallengeException -> L46
        r11.setState(AuthProtocolState.FAILURE);     // Catch: MalformedChallengeException -> L46
        return false;
    L26:
        if (r3 == null) goto L36;
        Header r5 = r2.get(r3.getSchemeName().toLowerCase(Locale.ROOT));     // Catch: MalformedChallengeException -> L46
        if (r5 == null) goto L35;
        this.log.debug("Authorization challenge processed");     // Catch: MalformedChallengeException -> L46
        r3.processChallenge(r5);     // Catch: MalformedChallengeException -> L46
        if (r3.isComplete() == false) goto L33;
        this.log.debug("Authentication failed");     // Catch: MalformedChallengeException -> L46
        r10.authFailed(r8, r11.getAuthScheme(), r12);     // Catch: MalformedChallengeException -> L46
        r11.reset();     // Catch: MalformedChallengeException -> L46
        r11.setState(AuthProtocolState.FAILURE);     // Catch: MalformedChallengeException -> L46
        return false;
    L33:
        r11.setState(AuthProtocolState.HANDSHAKE);     // Catch: MalformedChallengeException -> L46
        return true;
    L35:
        r11.reset();     // Catch: MalformedChallengeException -> L46
    L36:
        Queue<AuthOption> r13 = r10.select(r2, r8, r9, r12);     // Catch: MalformedChallengeException -> L46
        if (r13 != null) goto L39;
    L45:
        return false;
    L39:
        if (r13.isEmpty() == true) goto L45;
        if (this.log.isDebugEnabled() == false) goto L43;
        this.log.debug("Selected authentication options: " + r13);     // Catch: MalformedChallengeException -> L46
    L43:
        r11.setState(AuthProtocolState.CHALLENGED);     // Catch: MalformedChallengeException -> L46
        r11.update(r13);     // Catch: MalformedChallengeException -> L46
        return true;
    L13:
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L17;
        r11.reset();     // Catch: MalformedChallengeException -> L46
        goto L36
    L17:
        if (r4 != 4) goto L19;
        return false;
    L19:
        if (r4 == 5) goto L26;
        goto L26
    }

    public void generateAuthResponse(HttpRequest r8, AuthState r9, HttpContext r10) throws HttpException, IOException {
        AuthScheme r0 = r9.getAuthScheme();
        Credentials r1 = r9.getCredentials();
        int r2 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r9.getState().ordinal()];
        if (r2 != 1) goto L5;
        Queue<AuthOption> r3 = r9.getAuthOptions();
        if (r3 != null) goto L16;
        ensureAuthScheme(r0);
    L28:
        if (r0 == null) goto L47;
        r8.addHeader(doAuth(r0, r1, r8, r10));     // Catch: AuthenticationException -> L31
        return;
    L31:
        e = move-exception;
        if (this.log.isErrorEnabled() == false) goto L48;
        this.log.error(r0 + " authentication error: " + e.getMessage());
        return;
    L48:
        return;
    L47:
        return;
    L16:
        if (r3.isEmpty() == true) goto L26;
        AuthOption r4 = r3.remove();
        AuthScheme r5 = r4.getAuthScheme();
        Credentials r6 = r4.getCredentials();
        r9.update(r5, r6);
        if (this.log.isDebugEnabled() == false) goto L36;
        this.log.debug("Generating response to an authentication challenge using " + r5.getSchemeName() + " scheme");
    L36:
        r8.addHeader(doAuth(r5, r6, r8, r10));     // Catch: AuthenticationException -> L22
        return;
    L22:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L16;
        this.log.warn(r5 + " authentication error: " + e.getMessage());
        goto L16
    L26:
        return;
    L5:
        if (r2 != 3) goto L7;
        ensureAuthScheme(r0);
        if (r0.isConnectionBased() == false) goto L28;
        return;
    L7:
        if (r2 != 4) goto L28;
    }

    private void ensureAuthScheme(AuthScheme r1) {
        Asserts.notNull(r1, "Auth scheme");
    }

    private Header doAuth(AuthScheme r1, Credentials r2, HttpRequest r3, HttpContext r4) throws AuthenticationException {
        if ((r1 instanceof ContextAwareAuthScheme) == false) goto L6;
        return ((ContextAwareAuthScheme) r1).authenticate(r2, r3, r4);
    L6:
        return r1.authenticate(r2, r3);
    }
}
