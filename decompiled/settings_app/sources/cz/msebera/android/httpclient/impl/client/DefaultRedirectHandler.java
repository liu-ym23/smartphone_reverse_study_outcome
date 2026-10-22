package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultRedirectHandler implements RedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public HttpClientAndroidLog log;

    public DefaultRedirectHandler() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.client.RedirectHandler
    public boolean isRedirectRequested(HttpResponse r3, HttpContext r4) {
        Args.notNull(r3, "HTTP response");
        int r2 = r3.getStatusLine().getStatusCode();
        if (r2 == 307) goto L7;
        switch(r2) {
            case 301: goto L7;
            case 302: goto L7;
            case 303: goto L6;
            default: goto L5;
        };
    L5:
        return false;
    L6:
        return true;
    L7:
        String r5 = ((HttpRequest) r4.getAttribute("http.request")).getRequestLine().getMethod();
        if (r5.equalsIgnoreCase("GET") == true) goto L12;
        if (r5.equalsIgnoreCase("HEAD") == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // cz.msebera.android.httpclient.client.RedirectHandler
    public URI getLocationURI(HttpResponse r5, HttpContext r6) throws ProtocolException {
        Args.notNull(r5, "HTTP response");
        Header r0 = r5.getFirstHeader("location");
        if (r0 == null) goto L43;
        String r1 = r0.getValue();
        if (this.log.isDebugEnabled() == false) goto L48;
        this.log.debug("Redirect requested to location '" + r1 + "'");
    L48:
        URI r4 = new URI(r1);     // Catch: URISyntaxException -> L39
        HttpParams r7 = r5.getParams();
        if (r4.isAbsolute() == true) goto L21;
        if (r7.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT) == true) goto L19;
        HttpHost r2 = (HttpHost) r6.getAttribute("http.target_host");
        Asserts.notNull(r2, "Target host");
        r4 = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) r6.getAttribute("http.request")).getRequestLine().getUri()), r2, URIUtils.DROP_FRAGMENT_AND_NORMALIZE), r4);     // Catch: URISyntaxException -> L15
    L15:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    L19:
        throw new ProtocolException("Relative redirect location '" + r4 + "' not allowed");
    L21:
        if (r7.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS) == false) goto L38;
        RedirectLocations r3 = (RedirectLocations) r6.getAttribute("http.protocol.redirect-locations");
        if (r3 != null) goto L26;
        r3 = new RedirectLocations();
        r6.setAttribute("http.protocol.redirect-locations", r3);
    L26:
        if (r4.getFragment() != null) goto L46;
        URI r8 = r4;
    L34:
        if (r3.contains(r8) == true) goto L37;
        r3.add(r8);
        goto L38
    L37:
        throw new CircularRedirectException("Circular redirect to '" + r8 + "'");
    L46:
        r8 = URIUtils.rewriteURI(r4, new HttpHost(r4.getHost(), r4.getPort(), r4.getScheme()), URIUtils.DROP_FRAGMENT_AND_NORMALIZE);     // Catch: URISyntaxException -> L29
    L29:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    L38:
        return r4;
    L39:
        e = move-exception;
        throw new ProtocolException("Invalid redirect URI: " + r1, e);
    L43:
        throw new ProtocolException("Received redirect response " + r5.getStatusLine() + " but no location header");
    }
}
