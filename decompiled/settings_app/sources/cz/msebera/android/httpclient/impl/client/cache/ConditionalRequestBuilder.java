package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class ConditionalRequestBuilder {
    ConditionalRequestBuilder() {
    }

    public HttpRequestWrapper buildConditionalRequest(HttpRequestWrapper r11, HttpCacheEntry r12) throws ProtocolException {
        HttpRequestWrapper r10 = HttpRequestWrapper.wrap(r11.getOriginal());
        r10.setHeaders(r11.getAllHeaders());
        Header r13 = r12.getFirstHeader("ETag");
        if (r13 == null) goto L5;
        r10.setHeader("If-None-Match", r13.getValue());
    L5:
        Header r14 = r12.getFirstHeader("Last-Modified");
        if (r14 == null) goto L8;
        r10.setHeader("If-Modified-Since", r14.getValue());
    L8:
        Header[] r15 = r12.getHeaders("Cache-Control");
        int r0 = r15.length;
        int r2 = 0;
        boolean r3 = false;
    L9:
        if (r2 >= r0) goto L20;
        HeaderElement[] r4 = r15[r2].getElements();
        int r5 = r4.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L19;
        HeaderElement r7 = r4[r6];
        if (HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE.equalsIgnoreCase(r7.getName()) == true) goto L18;
        if (HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE.equalsIgnoreCase(r7.getName()) == true) goto L18;
        r6 = r6 + 1;
    L18:
        r3 = true;
    L19:
        r2 = r2 + 1;
        goto L9
    L20:
        if (r3 == false) goto L22;
        r10.addHeader("Cache-Control", "max-age=0");
    L22:
        return r10;
    }

    public HttpRequestWrapper buildConditionalRequestFromVariants(HttpRequestWrapper r3, Map<String, Variant> r4) {
        HttpRequestWrapper r2 = HttpRequestWrapper.wrap(r3.getOriginal());
        r2.setHeaders(r3.getAllHeaders());
        StringBuilder r5 = new StringBuilder();
        Iterator<String> r6 = r4.keySet().iterator();
        boolean r0 = true;
    L4:
        if (r6.hasNext() == false) goto L9;
        String r1 = r6.next();
        if (r0 == true) goto L8;
        r5.append(",");
    L8:
        r5.append(r1);
        r0 = false;
        goto L4
    L9:
        r2.setHeader("If-None-Match", r5.toString());
        return r2;
    }

    public HttpRequestWrapper buildUnconditionalRequest(HttpRequestWrapper r1, HttpCacheEntry r2) {
        HttpRequestWrapper r0 = HttpRequestWrapper.wrap(r1.getOriginal());
        r0.setHeaders(r1.getAllHeaders());
        r0.addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        r0.addHeader("Pragma", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        r0.removeHeaders("If-Range");
        r0.removeHeaders("If-Match");
        r0.removeHeaders("If-None-Match");
        r0.removeHeaders("If-Unmodified-Since");
        r0.removeHeaders("If-Modified-Since");
        return r0;
    }
}
