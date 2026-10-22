package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public class BasicScheme extends RFC2617Scheme {
    private static final long serialVersionUID = -1931571557597830536L;
    private boolean complete;

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "basic";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public BasicScheme(Charset r1) {
        super(r1);
        this.complete = false;
    }

    @Deprecated
    public BasicScheme(ChallengeState r1) {
        super(r1);
    }

    public BasicScheme() {
        this(Consts.ASCII);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header r1) throws MalformedChallengeException {
        super.processChallenge(r1);
        this.complete = true;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        return this.complete;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials r2, HttpRequest r3) throws AuthenticationException {
        return authenticate(r2, r3, new BasicHttpContext());
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials r2, HttpRequest r3, HttpContext r4) throws AuthenticationException {
        Args.notNull(r2, "Credentials");
        Args.notNull(r3, "HTTP request");
        StringBuilder r5 = new StringBuilder();
        r5.append(r2.getUserPrincipal().getName());
        r5.append(":");
        if (r2.getPassword() != null) goto L5;
        String r6 = "null";
    L6:
        r5.append(r6);
        byte[] r7 = Base64.encode(EncodingUtils.getBytes(r5.toString(), getCredentialsCharset(r3)), 2);
        CharArrayBuffer r8 = new CharArrayBuffer(32);
        if (isProxy() == false) goto L9;
        r8.append("Proxy-Authorization");
    L10:
        r8.append(": Basic ");
        r8.append(r7, 0, r7.length);
        return new BufferedHeader(r8);
    L9:
        r8.append("Authorization");
        goto L10
    L5:
        r6 = r2.getPassword();
        goto L6
    }

    @Deprecated
    public static Header authenticate(Credentials r2, String r3, boolean r4) {
        Args.notNull(r2, "Credentials");
        Args.notNull(r3, "charset");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getUserPrincipal().getName());
        r0.append(":");
        if (r2.getPassword() != null) goto L5;
        String r5 = "null";
    L6:
        r0.append(r5);
        byte[] r6 = Base64.encode(EncodingUtils.getBytes(r0.toString(), r3), 2);
        CharArrayBuffer r7 = new CharArrayBuffer(32);
        if (r4 == false) goto L9;
        r7.append("Proxy-Authorization");
    L10:
        r7.append(": Basic ");
        r7.append(r6, 0, r6.length);
        return new BufferedHeader(r7);
    L9:
        r7.append("Authorization");
        goto L10
    L5:
        r5 = r2.getPassword();
        goto L6
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        StringBuilder r0 = new StringBuilder("BASIC [complete=");
        r0.append(this.complete).append("]");
        return r0.toString();
    }
}
