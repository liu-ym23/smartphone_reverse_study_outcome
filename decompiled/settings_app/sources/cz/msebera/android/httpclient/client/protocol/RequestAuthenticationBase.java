package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
abstract class RequestAuthenticationBase implements HttpRequestInterceptor {
    final HttpClientAndroidLog log;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = null;

        static {
            int[] r0 = new int[AuthProtocolState.values().length];
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0;
            r0[AuthProtocolState.FAILURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public RequestAuthenticationBase() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    void process(AuthState r8, HttpRequest r9, HttpContext r10) {
        AuthScheme r0 = r8.getAuthScheme();
        Credentials r1 = r8.getCredentials();
        int r2 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r8.getState().ordinal()];
        if (r2 != 1) goto L5;
        return;
    L5:
        if (r2 != 2) goto L7;
        ensureAuthScheme(r0);
        if (r0.isConnectionBased() == false) goto L27;
        return;
    L27:
        if (r0 == null) goto L47;
        r9.addHeader(authenticate(r0, r1, r9, r10));     // Catch: AuthenticationException -> L30
        return;
    L30:
        e = move-exception;
        if (this.log.isErrorEnabled() == false) goto L48;
        this.log.error(r0 + " authentication error: " + e.getMessage());
        return;
    L48:
        return;
    L47:
        return;
    L7:
        if (r2 != 3) goto L27;
        Queue<AuthOption> r3 = r8.getAuthOptions();
        if (r3 != null) goto L12;
        ensureAuthScheme(r0);
    L12:
        if (r3.isEmpty() == true) goto L45;
        AuthOption r4 = r3.remove();
        AuthScheme r5 = r4.getAuthScheme();
        Credentials r6 = r4.getCredentials();
        r8.update(r5, r6);
        if (this.log.isDebugEnabled() == false) goto L35;
        this.log.debug("Generating response to an authentication challenge using " + r5.getSchemeName() + " scheme");
    L35:
        r9.addHeader(authenticate(r5, r6, r9, r10));     // Catch: AuthenticationException -> L18
        return;
    L18:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L12;
        this.log.warn(r5 + " authentication error: " + e.getMessage());
        goto L12
    }

    private void ensureAuthScheme(AuthScheme r1) {
        Asserts.notNull(r1, "Auth scheme");
    }

    private Header authenticate(AuthScheme r1, Credentials r2, HttpRequest r3, HttpContext r4) throws AuthenticationException {
        Asserts.notNull(r1, "Auth scheme");
        if ((r1 instanceof ContextAwareAuthScheme) == false) goto L7;
        return ((ContextAwareAuthScheme) r1).authenticate(r2, r3, r4);
    L7:
        return r1.authenticate(r2, r3);
    }
}
