package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.util.Args;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import obric.time.HttpHeadTimeFetcher;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
class CacheKeyGenerator {
    private static final URI BASE_URI = null;

    CacheKeyGenerator() {
    }

    static {
        BASE_URI = URI.create("http://example.com/");
    }

    static URIBuilder getRequestUriBuilder(HttpRequest r1) throws URISyntaxException {
        if ((r1 instanceof HttpUriRequest) == false) goto L9;
        URI r0 = ((HttpUriRequest) r1).getURI();
        if (r0 == null) goto L9;
        return new URIBuilder(r0);
    L9:
        return new URIBuilder(r1.getRequestLine().getUri());
    }

    static URI getRequestUri(HttpRequest r1, HttpHost r2) throws URISyntaxException {
        Args.notNull(r1, "HTTP request");
        Args.notNull(r2, "Target");
        URIBuilder r3 = getRequestUriBuilder(r1);
        String r0 = r3.getPath();
        if (r0 == null) goto L6;
        r3.setPathSegments(URLEncodedUtils.parsePathSegments(r0));
    L6:
        if (r3.isAbsolute() == true) goto L9;
        r3.setScheme(r2.getSchemeName());
        r3.setHost(r2.getHostName());
        r3.setPort(r2.getPort());
    L9:
        return r3.build();
    }

    static URI normalize(URI r3) throws URISyntaxException {
        Args.notNull(r3, "URI");
        if (r3.isAbsolute() == false) goto L5;
        r3 = URIUtils.resolve(BASE_URI, r3);
    L5:
        URIBuilder r0 = new URIBuilder(r3);
        if (r0.getHost() != null) goto L8;
    L18:
        r0.setFragment(null);
        return r0.build();
    L8:
        if (r0.getScheme() != null) goto L11;
        r0.setScheme("http");
    L11:
        if (r0.getPort() > (-1)) goto L18;
        if ("http".equalsIgnoreCase(r0.getScheme()) == false) goto L16;
        r0.setPort(80);
        goto L18
    L16:
        if (HttpHeadTimeFetcher.FETCHER_TYPE.equalsIgnoreCase(r0.getScheme()) == false) goto L18;
        r0.setPort(443);
        goto L18
    }

    public String getURI(HttpHost r1, HttpRequest r2) {
        return normalize(getRequestUri(r2, r1)).toASCIIString();
    L5:
        return r2.getRequestLine().getUri();
    }

    public String canonicalizeUri(String r1) {
        return normalize(URIUtils.resolve(BASE_URI, r1)).toASCIIString();
    L4:
        return r1;
    }

    protected String getFullHeaderValue(Header[] r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder("");
        int r5 = r6.length;
        boolean r2 = true;
        int r3 = 0;
    L6:
        if (r3 >= r5) goto L12;
        Header r4 = r6[r3];
        if (r2 == true) goto L10;
        r0.append(", ");
    L10:
        r0.append(r4.getValue().trim());
        r3 = r3 + 1;
        r2 = false;
        goto L6
    L12:
        return r0.toString();
    }

    public String getVariantURI(HttpHost r2, HttpRequest r3, HttpCacheEntry r4) {
        if (r4.hasVariants() == true) goto L7;
        return getURI(r2, r3);
    L7:
        return getVariantKey(r3, r4) + getURI(r2, r3);
    }

    public String getVariantKey(HttpRequest r9, HttpCacheEntry r10) {
        ArrayList r0 = new ArrayList();
        Header[] r11 = r10.getHeaders("Vary");
        int r1 = r11.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        HeaderElement[] r4 = r11[r3].getElements();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L7;
        r0.add(r4[r6].getName());
        r6 = r6 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        Collections.sort(r0);
        StringBuilder r12 = new StringBuilder(VectorFormat.DEFAULT_PREFIX);     // Catch: UnsupportedEncodingException -> L19
        Iterator r2 = r0.iterator();     // Catch: UnsupportedEncodingException -> L19
        boolean r7 = true;
    L11:
        if (r2.hasNext() == false) goto L16;
        String r8 = (String) r2.next();     // Catch: UnsupportedEncodingException -> L19
        if (r7 == true) goto L15;
        r12.append("&");     // Catch: UnsupportedEncodingException -> L19
    L15:
        r12.append(URLEncoder.encode(r8, Consts.UTF_8.name()));     // Catch: UnsupportedEncodingException -> L19
        r12.append("=");     // Catch: UnsupportedEncodingException -> L19
        r12.append(URLEncoder.encode(getFullHeaderValue(r9.getHeaders(r8)), Consts.UTF_8.name()));     // Catch: UnsupportedEncodingException -> L19
        r7 = false;
        goto L11
    L16:
        r12.append(VectorFormat.DEFAULT_SUFFIX);     // Catch: UnsupportedEncodingException -> L19
        return r12.toString();
    L19:
        e = move-exception;
        throw new RuntimeException("couldn't encode to UTF-8", e);
    }
}
