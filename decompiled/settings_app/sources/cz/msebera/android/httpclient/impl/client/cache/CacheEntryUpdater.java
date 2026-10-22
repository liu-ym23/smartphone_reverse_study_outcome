package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
class CacheEntryUpdater {
    private final ResourceFactory resourceFactory;

    CacheEntryUpdater() {
        this(new HeapResourceFactory());
    }

    CacheEntryUpdater(ResourceFactory r1) {
        this.resourceFactory = r1;
    }

    public HttpCacheEntry updateCacheEntry(String r10, HttpCacheEntry r11, Date r12, Date r13, HttpResponse r14) throws IOException {
        if (r14.getStatusLine().getStatusCode() != 304) goto L5;
        boolean r0 = true;
    L6:
        Args.check(r0, "Response must have 304 status code");
        Header[] r6 = mergeHeaders(r11, r14);
        if (r11.getResource() == null) goto L9;
        Resource r9 = this.resourceFactory.copy(r10, r11.getResource());
    L10:
        StatusLine r5 = r11.getStatusLine();
        return new HttpCacheEntry(r12, r13, r5, r6, r9, r11.getRequestMethod());
    L9:
        r9 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    protected Header[] mergeHeaders(HttpCacheEntry r5, HttpResponse r6) {
        if (entryAndResponseHaveDateHeader(r5, r6) == true) goto L5;
    L8:
        HeaderGroup r4 = new HeaderGroup();
        r4.setHeaders(r5.getAllHeaders());
        HeaderIterator r7 = r6.headerIterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        Header r0 = r7.nextHeader();
        if ("Content-Encoding".equals(r0.getName()) == true) goto L10;
        Header[] r1 = r4.getHeaders(r0.getName());
        int r2 = r1.length;
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L10;
        r4.removeHeader(r1[r3]);
        r3 = r3 + 1;
        goto L15
    L17:
        HeaderIterator r8 = r4.iterator();
    L19:
        if (r8.hasNext() == false) goto L27;
        Header r9 = r8.nextHeader();
        if ("Warning".equalsIgnoreCase(r9.getName()) == false) goto L19;
        String r10 = r9.getValue();
        if (r10 == null) goto L19;
        if (r10.startsWith("1") == false) goto L19;
        r8.remove();
        goto L19
    L27:
        HeaderIterator r11 = r6.headerIterator();
    L29:
        if (r11.hasNext() == false) goto L35;
        Header r12 = r11.nextHeader();
        if ("Content-Encoding".equals(r12.getName()) == true) goto L29;
        r4.addHeader(r12);
        goto L29
    L35:
        return r4.getAllHeaders();
    L5:
        if (entryDateHeaderNewerThenResponse(r5, r6) == false) goto L8;
        return r5.getAllHeaders();
    }

    private boolean entryDateHeaderNewerThenResponse(HttpCacheEntry r1, HttpResponse r2) {
        Date r3 = DateUtils.parseDate(r1.getFirstHeader("Date").getValue());
        Date r0 = DateUtils.parseDate(r2.getFirstHeader("Date").getValue());
        if (r3 == null) goto L8;
        if (r0 == null) goto L8;
        if (r3.after(r0) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean entryAndResponseHaveDateHeader(HttpCacheEntry r1, HttpResponse r2) {
        if (r1.getFirstHeader("Date") != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getFirstHeader("Date") == null) goto L7;
        return true;
    }
}
