package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class HttpCacheEntry implements Serializable {
    private static final String REQUEST_METHOD_HEADER_NAME = "Hc-Request-Method";
    private static final long serialVersionUID = -6300496422359477413L;
    private final Date date;
    private final Date requestDate;
    private final Resource resource;
    private final Date responseDate;
    private final HeaderGroup responseHeaders;
    private final StatusLine statusLine;
    private final Map<String, String> variantMap;

    public HttpCacheEntry(Date r1, Date r2, StatusLine r3, Header[] r4, Resource r5, Map<String, String> r6, String r7) {
        Args.notNull(r1, "Request date");
        Args.notNull(r2, "Response date");
        Args.notNull(r3, "Status line");
        Args.notNull(r4, "Response headers");
        this.requestDate = r1;
        this.responseDate = r2;
        this.statusLine = r3;
        HeaderGroup r8 = new HeaderGroup();
        this.responseHeaders = r8;
        r8.setHeaders(r4);
        this.resource = r5;
        if (r6 == null) goto L5;
        HashMap r9 = new HashMap(r6);
    L6:
        this.variantMap = r9;
        this.date = parseDate();
        return;
    L5:
        r9 = null;
        goto L6
    }

    public HttpCacheEntry(Date r9, Date r10, StatusLine r11, Header[] r12, Resource r13, Map<String, String> r14) {
        this(r9, r10, r11, r12, r13, r14, null);
    }

    public HttpCacheEntry(Date r8, Date r9, StatusLine r10, Header[] r11, Resource r12) {
        this(r8, r9, r10, r11, r12, new HashMap());
    }

    public HttpCacheEntry(Date r9, Date r10, StatusLine r11, Header[] r12, Resource r13, String r14) {
        this(r9, r10, r11, r12, r13, new HashMap(), r14);
    }

    private Date parseDate() {
        Header r1 = getFirstHeader("Date");
        if (r1 != null) goto L7;
        return null;
    L7:
        return DateUtils.parseDate(r1.getValue());
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.statusLine.getProtocolVersion();
    }

    public String getReasonPhrase() {
        return this.statusLine.getReasonPhrase();
    }

    public int getStatusCode() {
        return this.statusLine.getStatusCode();
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public Date getResponseDate() {
        return this.responseDate;
    }

    public Header[] getAllHeaders() {
        HeaderGroup r0 = new HeaderGroup();
        HeaderIterator r4 = this.responseHeaders.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Header r1 = (Header) r4.next();
        if (REQUEST_METHOD_HEADER_NAME.equals(r1.getName()) == true) goto L4;
        r0.addHeader(r1);
        goto L4
    L9:
        return r0.getAllHeaders();
    }

    public Header getFirstHeader(String r2) {
        if (REQUEST_METHOD_HEADER_NAME.equalsIgnoreCase(r2) == false) goto L7;
        return null;
    L7:
        return this.responseHeaders.getFirstHeader(r2);
    }

    public Header[] getHeaders(String r2) {
        if (REQUEST_METHOD_HEADER_NAME.equalsIgnoreCase(r2) == false) goto L7;
        return new Header[0];
    L7:
        return this.responseHeaders.getHeaders(r2);
    }

    public Date getDate() {
        return this.date;
    }

    public Resource getResource() {
        return this.resource;
    }

    public boolean hasVariants() {
        if (getFirstHeader("Vary") == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Map<String, String> getVariantMap() {
        return Collections.unmodifiableMap(this.variantMap);
    }

    public String getRequestMethod() {
        Header r1 = this.responseHeaders.getFirstHeader(REQUEST_METHOD_HEADER_NAME);
        if (r1 != null) goto L5;
        return "GET";
    L5:
        return r1.getValue();
    }

    public String toString() {
        return "[request date=" + this.requestDate + "; response date=" + this.responseDate + "; statusLine=" + this.statusLine + "]";
    }
}
