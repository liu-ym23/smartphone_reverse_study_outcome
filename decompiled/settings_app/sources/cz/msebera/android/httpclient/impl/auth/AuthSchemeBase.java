package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
    protected ChallengeState challengeState;

    protected abstract void parseChallenge(CharArrayBuffer r1, int r2, int r3) throws MalformedChallengeException;

    @Deprecated
    public AuthSchemeBase(ChallengeState r1) {
        this.challengeState = r1;
    }

    public AuthSchemeBase() {
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header r4) throws MalformedChallengeException {
        Args.notNull(r4, "Header");
        String r0 = r4.getName();
        if (r0.equalsIgnoreCase("WWW-Authenticate") == false) goto L6;
        this.challengeState = ChallengeState.TARGET;
    L9:
        if ((r4 instanceof FormattedHeader) == false) goto L11;
        FormattedHeader r5 = (FormattedHeader) r4;
        CharArrayBuffer r1 = r5.getBuffer();
        int r6 = r5.getValuePos();
    L15:
        if (r6 >= r1.length()) goto L19;
        if (HTTP.isWhitespace(r1.charAt(r6)) == false) goto L19;
        r6 = r6 + 1;
    L19:
        int r2 = r6;
    L21:
        if (r2 >= r1.length()) goto L25;
        if (HTTP.isWhitespace(r1.charAt(r2)) == true) goto L25;
        r2 = r2 + 1;
    L25:
        String r7 = r1.substring(r6, r2);
        if (r7.equalsIgnoreCase(getSchemeName()) == false) goto L30;
        parseChallenge(r1, r2, r1.length());
        return;
    L30:
        throw new MalformedChallengeException("Invalid scheme identifier: " + r7);
    L11:
        String r8 = r4.getValue();
        if (r8 == null) goto L32;
        r1 = new CharArrayBuffer(r8.length());
        r1.append(r8);
        r6 = 0;
        goto L15
    L32:
        throw new MalformedChallengeException("Header value is null");
    L6:
        if (r0.equalsIgnoreCase("Proxy-Authenticate") == false) goto L34;
        this.challengeState = ChallengeState.PROXY;
        goto L9
    L34:
        throw new MalformedChallengeException("Unexpected header name: " + r0);
    }

    @Override // cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials r1, HttpRequest r2, HttpContext r3) throws AuthenticationException {
        return authenticate(r1, r2);
    }

    public boolean isProxy() {
        ChallengeState r1 = this.challengeState;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1 != ChallengeState.PROXY) goto L7;
        return true;
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public String toString() {
        String r0 = getSchemeName();
        if (r0 == null) goto L6;
        return r0.toUpperCase(Locale.ROOT);
    L6:
        return super.toString();
    }
}
