package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.AuthSchemes;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = null;
    private final int challengeCode;
    private final String headerName;
    public HttpClientAndroidLog log;

    abstract Collection<String> getPreferredAuthSchemes(RequestConfig r1);

    static {
        DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"Negotiate", "Kerberos", "NTLM", AuthSchemes.CREDSSP, "Digest", "Basic"}));
    }

    AuthenticationStrategyImpl(int r3, String r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.challengeCode = r3;
        this.headerName = r4;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public boolean isAuthenticationRequested(HttpHost r1, HttpResponse r2, HttpContext r3) {
        Args.notNull(r2, "HTTP response");
        if (r2.getStatusLine().getStatusCode() != this.challengeCode) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Map<String, Header> getChallenges(HttpHost r7, HttpResponse r8, HttpContext r9) throws MalformedChallengeException {
        Args.notNull(r8, "HTTP response");
        Header[] r6 = r8.getHeaders(this.headerName);
        HashMap r10 = new HashMap(r6.length);
        int r11 = r6.length;
        int r0 = 0;
    L3:
        if (r0 >= r11) goto L24;
        Header r1 = r6[r0];
        if ((r1 instanceof FormattedHeader) == false) goto L7;
        FormattedHeader r2 = (FormattedHeader) r1;
        CharArrayBuffer r3 = r2.getBuffer();
        int r4 = r2.getValuePos();
    L11:
        if (r4 >= r3.length()) goto L15;
        if (HTTP.isWhitespace(r3.charAt(r4)) == false) goto L15;
        r4 = r4 + 1;
    L15:
        int r5 = r4;
    L17:
        if (r5 >= r3.length()) goto L21;
        if (HTTP.isWhitespace(r3.charAt(r5)) == true) goto L21;
        r5 = r5 + 1;
    L21:
        r10.put(r3.substring(r4, r5).toLowerCase(Locale.ROOT), r1);
        r0 = r0 + 1;
        goto L3
    L7:
        String r12 = r1.getValue();
        if (r12 == null) goto L23;
        r3 = new CharArrayBuffer(r12.length());
        r3.append(r12);
        r4 = 0;
        goto L11
    L23:
        throw new MalformedChallengeException("Header value is null");
    L24:
        return r10;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Queue<AuthOption> select(Map<String, Header> r8, HttpHost r9, HttpResponse r10, HttpContext r11) throws MalformedChallengeException {
        Args.notNull(r8, "Map of auth challenges");
        Args.notNull(r9, "Host");
        Args.notNull(r10, "HTTP response");
        Args.notNull(r11, "HTTP context");
        HttpClientContext r12 = HttpClientContext.adapt(r11);
        LinkedList r0 = new LinkedList();
        Lookup<AuthSchemeProvider> r1 = r12.getAuthSchemeRegistry();
        if (r1 != null) goto L6;
        this.log.debug("Auth scheme registry not set in the context");
        return r0;
    L6:
        CredentialsProvider r2 = r12.getCredentialsProvider();
        if (r2 != null) goto L10;
        this.log.debug("Credentials provider not set in the context");
        return r0;
    L10:
        Collection<String> r13 = getPreferredAuthSchemes(r12.getRequestConfig());
        if (r13 != null) goto L14;
        r13 = DEFAULT_SCHEME_PRIORITY;
    L14:
        if (this.log.isDebugEnabled() == false) goto L16;
        this.log.debug("Authentication schemes in the order of preference: " + r13);
    L16:
        Iterator<String> r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L32;
        String r3 = r14.next();
        Header r4 = r8.get(r3.toLowerCase(Locale.ROOT));
        if (r4 != null) goto L21;
        if (this.log.isDebugEnabled() == false) goto L18;
        this.log.debug("Challenge for " + r3 + " authentication scheme not available");
        goto L18
    L21:
        AuthSchemeProvider r5 = r1.lookup(r3);
        if (r5 == null) goto L24;
        AuthScheme r6 = r5.create(r11);
        r6.processChallenge(r4);
        Credentials r7 = r2.getCredentials(new AuthScope(r9, r6.getRealm(), r6.getSchemeName()));
        if (r7 == null) goto L18;
        r0.add(new AuthOption(r6, r7));
        goto L18
    L24:
        if (this.log.isWarnEnabled() == false) goto L18;
        this.log.warn("Authentication scheme " + r3 + " not supported");
        goto L18
    L32:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authSucceeded(HttpHost r3, AuthScheme r4, HttpContext r5) {
        Args.notNull(r3, "Host");
        Args.notNull(r4, "Auth scheme");
        Args.notNull(r5, "HTTP context");
        HttpClientContext r6 = HttpClientContext.adapt(r5);
        if (isCachable(r4) == false) goto L12;
        AuthCache r0 = r6.getAuthCache();
        if (r0 != null) goto L8;
        r0 = new BasicAuthCache();
        r6.setAuthCache(r0);
    L8:
        if (this.log.isDebugEnabled() == false) goto L10;
        this.log.debug("Caching '" + r4.getSchemeName() + "' auth scheme for " + r3);
    L10:
        r0.put(r3, r4);
        return;
    }

    protected boolean isCachable(AuthScheme r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isComplete() == true) goto L7;
        return false;
    L7:
        return r1.getSchemeName().equalsIgnoreCase("Basic");
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authFailed(HttpHost r2, AuthScheme r3, HttpContext r4) {
        Args.notNull(r2, "Host");
        Args.notNull(r4, "HTTP context");
        AuthCache r5 = HttpClientContext.adapt(r4).getAuthCache();
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.log.isDebugEnabled() == false) goto L7;
        this.log.debug("Clearing cached auth scheme for " + r2);
    L7:
        r5.remove(r2);
    }
}
