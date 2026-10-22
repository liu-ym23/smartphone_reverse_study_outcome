package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final DefaultRedirectStrategy INSTANCE = null;

    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String[] REDIRECT_METHODS = null;
    public HttpClientAndroidLog log;

    static {
        INSTANCE = new DefaultRedirectStrategy();
        REDIRECT_METHODS = new String[]{"GET", "HEAD"};
    }

    public DefaultRedirectStrategy() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public boolean isRedirected(HttpRequest r3, HttpResponse r4, HttpContext r5) throws ProtocolException {
        Args.notNull(r3, "HTTP request");
        Args.notNull(r4, "HTTP response");
        int r6 = r4.getStatusLine().getStatusCode();
        String r7 = r3.getRequestLine().getMethod();
        Header r8 = r4.getFirstHeader("location");
        if (r6 == 307) goto L14;
        switch(r6) {
            case 301: goto L14;
            case 302: goto L9;
            case 303: goto L7;
            default: goto L6;
        };
    L6:
        return false;
    L7:
        return true;
    L9:
        if (isRedirectable(r7) == false) goto L15;
        if (r8 != null) goto L12;
        return false;
    L12:
        return true;
    L15:
        return false;
    L14:
        return isRedirectable(r7);
    }

    public URI getLocationURI(HttpRequest r7, HttpResponse r8, HttpContext r9) throws ProtocolException {
        Args.notNull(r7, "HTTP request");
        Args.notNull(r8, "HTTP response");
        Args.notNull(r9, "HTTP context");
        HttpClientContext r1 = HttpClientContext.adapt(r9);
        Header r2 = r8.getFirstHeader("location");
        if (r2 == null) goto L38;
        String r10 = r2.getValue();
        if (this.log.isDebugEnabled() == false) goto L7;
        this.log.debug("Redirect requested to location '" + r10 + "'");
    L7:
        RequestConfig r3 = r1.getRequestConfig();
        URI r6 = createLocationURI(r10);
    L34:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    L9:
        if (r3.isNormalizeUri() == false) goto L12;
        r6 = URIUtils.normalizeSyntax(r6);     // Catch: URISyntaxException -> L34
    L12:
        if (r6.isAbsolute() == false) goto L14;
    L22:
        RedirectLocations r11 = (RedirectLocations) r1.getAttribute("http.protocol.redirect-locations");
        if (r11 != null) goto L26;
        r11 = new RedirectLocations();
        r9.setAttribute("http.protocol.redirect-locations", r11);
    L26:
        if (r3.isCircularRedirectsAllowed() == false) goto L28;
    L32:
        r11.add(r6);
        return r6;
    L28:
        if (r11.contains(r6) == false) goto L32;
        throw new CircularRedirectException("Circular redirect to '" + r6 + "'");
    L14:
        if (r3.isRelativeRedirectsAllowed() == false) goto L21;
        HttpHost r12 = r1.getTargetHost();     // Catch: URISyntaxException -> L34
        Asserts.notNull(r12, "Target host");     // Catch: URISyntaxException -> L34
        URI r0 = new URI(r7.getRequestLine().getUri());     // Catch: URISyntaxException -> L34
        if (r3.isNormalizeUri() == false) goto L18;
        EnumSet<URIUtils.UriFlag> r13 = URIUtils.NORMALIZE;     // Catch: URISyntaxException -> L34
    L19:
        r6 = URIUtils.resolve(URIUtils.rewriteURI(r0, r12, r13), r6);     // Catch: URISyntaxException -> L34
        goto L22
    L18:
        r13 = URIUtils.NO_FLAGS;     // Catch: URISyntaxException -> L34
        goto L19
    L21:
        throw new ProtocolException("Relative redirect location '" + r6 + "' not allowed");     // Catch: URISyntaxException -> L34
    L38:
        throw new ProtocolException("Received redirect response " + r8.getStatusLine() + " but no location header");
    }

    protected URI createLocationURI(String r4) throws ProtocolException {
        return new URI(r4);
    L4:
        e = move-exception;
        throw new ProtocolException("Invalid redirect URI: " + r4, e);
    }

    protected boolean isRedirectable(String r5) {
        String[] r4 = REDIRECT_METHODS;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equalsIgnoreCase(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public HttpUriRequest getRedirect(HttpRequest r2, HttpResponse r3, HttpContext r4) throws ProtocolException {
        URI r1 = getLocationURI(r2, r3, r4);
        String r5 = r2.getRequestLine().getMethod();
        if (r5.equalsIgnoreCase("HEAD") == false) goto L7;
        return new HttpHead(r1);
    L7:
        if (r5.equalsIgnoreCase("GET") == false) goto L11;
        return new HttpGet(r1);
    L11:
        if (r3.getStatusLine().getStatusCode() != 307) goto L14;
        return RequestBuilder.copy(r2).setUri(r1).build();
    L14:
        return new HttpGet(r1);
    }
}
