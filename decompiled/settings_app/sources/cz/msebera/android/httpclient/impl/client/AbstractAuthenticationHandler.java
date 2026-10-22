package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = null;
    public HttpClientAndroidLog log;

    static {
        DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"Negotiate", "NTLM", "Digest", "Basic"}));
    }

    public AbstractAuthenticationHandler() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    protected Map<String, Header> parseChallenges(Header[] r9) throws MalformedChallengeException {
        HashMap r8 = new HashMap(r9.length);
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L24;
        Header r3 = r9[r2];
        if ((r3 instanceof FormattedHeader) == false) goto L7;
        FormattedHeader r4 = (FormattedHeader) r3;
        CharArrayBuffer r5 = r4.getBuffer();
        int r6 = r4.getValuePos();
    L11:
        if (r6 >= r5.length()) goto L15;
        if (HTTP.isWhitespace(r5.charAt(r6)) == false) goto L15;
        r6 = r6 + 1;
    L15:
        int r7 = r6;
    L17:
        if (r7 >= r5.length()) goto L21;
        if (HTTP.isWhitespace(r5.charAt(r7)) == true) goto L21;
        r7 = r7 + 1;
    L21:
        r8.put(r5.substring(r6, r7).toLowerCase(Locale.ROOT), r3);
        r2 = r2 + 1;
        goto L3
    L7:
        String r10 = r3.getValue();
        if (r10 == null) goto L23;
        r5 = new CharArrayBuffer(r10.length());
        r5.append(r10);
        r6 = 0;
        goto L11
    L23:
        throw new MalformedChallengeException("Header value is null");
    L24:
        return r8;
    }

    protected List<String> getAuthPreferences() {
        return DEFAULT_SCHEME_PRIORITY;
    }

    protected List<String> getAuthPreferences(HttpResponse r1, HttpContext r2) {
        return getAuthPreferences();
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationHandler
    public AuthScheme selectScheme(Map<String, Header> r6, HttpResponse r7, HttpContext r8) throws AuthenticationException {
        AuthSchemeRegistry r0 = (AuthSchemeRegistry) r8.getAttribute("http.authscheme-registry");
        Asserts.notNull(r0, "AuthScheme registry");
        List<String> r9 = getAuthPreferences(r7, r8);
        if (r9 != null) goto L6;
        r9 = DEFAULT_SCHEME_PRIORITY;
    L6:
        if (this.log.isDebugEnabled() == false) goto L8;
        this.log.debug("Authentication schemes in the order of preference: " + r9);
    L8:
        Iterator<String> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L24;
        String r1 = r10.next();
        if (r6.get(r1.toLowerCase(Locale.ENGLISH)) != null) goto L14;
        if (this.log.isDebugEnabled() == false) goto L10;
        this.log.debug("Challenge for " + r1 + " authentication scheme not available");
        goto L10
    L14:
        if (this.log.isDebugEnabled() == false) goto L29;
        this.log.debug(r1 + " authentication scheme selected");
    L29:
        AuthScheme r5 = r0.getAuthScheme(r1, r7.getParams());     // Catch: IllegalStateException -> L18
    L25:
        if (r5 == null) goto L28;
        return r5;
    L28:
        throw new AuthenticationException("Unable to respond to any of these challenges: " + r6);
    L19:
        if (this.log.isWarnEnabled() == false) goto L10;
        this.log.warn("Authentication scheme " + r1 + " not supported");
        goto L10
    L24:
        r5 = null;
        goto L25
    }
}
