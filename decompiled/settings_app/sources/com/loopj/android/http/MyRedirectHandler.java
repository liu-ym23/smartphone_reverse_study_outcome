package com.loopj.android.http;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.impl.client.DefaultRedirectHandler;
import cz.msebera.android.httpclient.impl.client.RedirectLocations;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
class MyRedirectHandler extends DefaultRedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final boolean enableRedirects;

    public MyRedirectHandler(boolean r1) {
        this.enableRedirects = r1;
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultRedirectHandler, cz.msebera.android.httpclient.client.RedirectHandler
    public boolean isRedirectRequested(HttpResponse r1, HttpContext r2) {
        if (this.enableRedirects == true) goto L5;
        return false;
    L5:
        if (r1 == null) goto L13;
        int r0 = r1.getStatusLine().getStatusCode();
        if (r0 == 307) goto L10;
        switch(r0) {
            case 301: goto L14;
            case 302: goto L14;
            case 303: goto L14;
            default: goto L9;
        };
    L9:
        return false;
    L14:
        return true;
    L10:
        return true;
    L13:
        throw new IllegalArgumentException("HTTP response may not be null");
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultRedirectHandler, cz.msebera.android.httpclient.client.RedirectHandler
    public URI getLocationURI(HttpResponse r5, HttpContext r6) throws ProtocolException {
        if (r5 == null) goto L48;
        Header r4 = r5.getFirstHeader("location");
        if (r4 == null) goto L46;
        String r7 = r4.getValue().replaceAll(HanziToPinyin.Token.SEPARATOR, "%20");
        URI r0 = new URI(r7);     // Catch: URISyntaxException -> L42
        HttpParams r8 = r5.getParams();
        if (r0.isAbsolute() == true) goto L24;
        if (r8.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT) == true) goto L22;
        HttpHost r9 = (HttpHost) r6.getAttribute("http.target_host");
        if (r9 == null) goto L20;
        r0 = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) r6.getAttribute("http.request")).getRequestLine().getUri()), r9, true), r0);     // Catch: URISyntaxException -> L16
    L16:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    L20:
        throw new IllegalStateException("Target host not available in the HTTP context");
    L22:
        throw new ProtocolException("Relative redirect location '" + r0 + "' not allowed");
    L24:
        if (r8.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS) == false) goto L41;
        RedirectLocations r10 = (RedirectLocations) r6.getAttribute("http.protocol.redirect-locations");
        if (r10 != null) goto L29;
        r10 = new RedirectLocations();
        r6.setAttribute("http.protocol.redirect-locations", r10);
    L29:
        if (r0.getFragment() != null) goto L51;
        URI r11 = r0;
    L37:
        if (r10.contains(r11) == true) goto L40;
        r10.add(r11);
        goto L41
    L40:
        throw new CircularRedirectException("Circular redirect to '" + r11 + "'");
    L51:
        r11 = URIUtils.rewriteURI(r0, new HttpHost(r0.getHost(), r0.getPort(), r0.getScheme()), true);     // Catch: URISyntaxException -> L32
    L32:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    L41:
        return r0;
    L42:
        e = move-exception;
        throw new ProtocolException("Invalid redirect URI: " + r7, e);
    L46:
        throw new ProtocolException("Received redirect response " + r5.getStatusLine() + " but no location header");
    L48:
        throw new IllegalArgumentException("HTTP response may not be null");
    }
}
