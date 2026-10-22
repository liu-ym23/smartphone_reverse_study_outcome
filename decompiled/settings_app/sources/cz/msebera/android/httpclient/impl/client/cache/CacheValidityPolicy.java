package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
class CacheValidityPolicy {
    public static final long MAX_AGE = 2147483648L;

    CacheValidityPolicy() {
    }

    public long getCurrentAgeSecs(HttpCacheEntry r3, Date r4) {
        return getCorrectedInitialAgeSecs(r3) + getResidentTimeSecs(r3, r4);
    }

    public long getFreshnessLifetimeSecs(HttpCacheEntry r5) {
        long r0 = getMaxAge(r5);
        if (r0 <= (-1)) goto L5;
        return r0;
    L5:
        Date r1 = r5.getDate();
        if (r1 != null) goto L8;
        return 0;
    L8:
        Date r4 = getExpirationDate(r5);
        if (r4 != null) goto L12;
        return 0;
    L12:
        return (r4.getTime() - r1.getTime()) / 1000;
    }

    public boolean isResponseFresh(HttpCacheEntry r3, Date r4) {
        if (getCurrentAgeSecs(r3, r4) >= getFreshnessLifetimeSecs(r3)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isResponseHeuristicallyFresh(HttpCacheEntry r3, Date r4, float r5, long r6) {
        if (getCurrentAgeSecs(r3, r4) >= getHeuristicFreshnessLifetimeSecs(r3, r5, r6)) goto L5;
        return true;
    L5:
        return false;
    }

    public long getHeuristicFreshnessLifetimeSecs(HttpCacheEntry r2, float r3, long r4) {
        Date r0 = r2.getDate();
        Date r1 = getLastModifiedValue(r2);
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        long r5 = r0.getTime() - r1.getTime();
        if (r5 >= 0) goto L9;
        return 0;
    L9:
        return (long) (r3 * (r5 / 1000));
    L10:
        return r4;
    }

    public boolean isRevalidatable(HttpCacheEntry r1) {
        if (r1.getFirstHeader("ETag") == null) goto L5;
    L8:
        return true;
    L5:
        if (r1.getFirstHeader("Last-Modified") != null) goto L8;
        return false;
    }

    public boolean mustRevalidate(HttpCacheEntry r2) {
        return hasCacheControlDirective(r2, HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE);
    }

    public boolean proxyRevalidate(HttpCacheEntry r2) {
        return hasCacheControlDirective(r2, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE);
    }

    public boolean mayReturnStaleWhileRevalidating(HttpCacheEntry r13, Date r14) {
        Header[] r0 = r13.getHeaders("Cache-Control");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        HeaderElement[] r4 = r0[r3].getElements();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L14;
        HeaderElement r7 = r4[r6];
        if (HeaderConstants.STALE_WHILE_REVALIDATE.equalsIgnoreCase(r7.getName()) == false) goto L13;
        if (getStalenessSecs(r13, r14) > Integer.parseInt(r7.getValue())) goto L13;
        return true;
    L13:
        r6 = r6 + 1;
        goto L5
    L14:
        r3 = r3 + 1;
        goto L3
    L15:
        return false;
    }

    public boolean mayReturnStaleIfError(HttpRequest r3, HttpCacheEntry r4, Date r5) {
        long r0 = getStalenessSecs(r4, r5);
        if (mayReturnStaleIfError(r3.getHeaders("Cache-Control"), r0) == false) goto L5;
    L8:
        return true;
    L5:
        if (mayReturnStaleIfError(r4.getHeaders("Cache-Control"), r0) == true) goto L8;
        return false;
    }

    private boolean mayReturnStaleIfError(Header[] r10, long r11) {
        int r9 = r10.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r9) goto L14;
        HeaderElement[] r3 = r10[r1].getElements();
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L13;
        HeaderElement r6 = r3[r5];
        if (HeaderConstants.STALE_IF_ERROR.equals(r6.getName()) == false) goto L12;
        if (r11 > Integer.parseInt(r6.getValue())) goto L12;
        r2 = true;
    L12:
        r5 = r5 + 1;
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return r2;
    }

    @Deprecated
    protected Date getDateValue(HttpCacheEntry r1) {
        return r1.getDate();
    }

    protected Date getLastModifiedValue(HttpCacheEntry r1) {
        Header r0 = r1.getFirstHeader("Last-Modified");
        if (r0 != null) goto L7;
        return null;
    L7:
        return DateUtils.parseDate(r0.getValue());
    }

    protected long getContentLengthValue(HttpCacheEntry r3) {
        Header r2 = r3.getFirstHeader("Content-Length");
        if (r2 != null) goto L8;
        return -1;
    L8:
        return Long.parseLong(r2.getValue());
    L7:
        return -1;
    }

    protected boolean hasContentLengthHeader(HttpCacheEntry r1) {
        if (r1.getFirstHeader("Content-Length") == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected boolean contentLengthHeaderMatchesActualLength(HttpCacheEntry r3) {
        if (hasContentLengthHeader(r3) == true) goto L5;
    L10:
        return true;
    L5:
        if (r3.getResource() != null) goto L7;
    L9:
        return false;
    L7:
        if (getContentLengthValue(r3) != r3.getResource().length()) goto L9;
        goto L9
    }

    protected long getApparentAgeSecs(HttpCacheEntry r4) {
        Date r3 = r4.getDate();
        if (r3 != null) goto L6;
        return MAX_AGE;
    L6:
        long r0 = r4.getResponseDate().getTime() - r3.getTime();
        if (r0 >= 0) goto L10;
        return 0;
    L10:
        return r0 / 1000;
    }

    protected long getAgeValue(HttpCacheEntry r11) {
        Header[] r10 = r11.getHeaders("Age");
        int r12 = r10.length;
        int r2 = 0;
        long r3 = 0;
    L3:
        if (r2 >= r12) goto L14;
        Header r5 = r10[r2];
        long r6 = MAX_AGE;
        long r8 = Long.parseLong(r5.getValue());     // Catch: NumberFormatException -> L15
        if (r8 < 0) goto L11;
        r6 = r8;
    L11:
        if (r6 <= r3) goto L13;
        r3 = r6;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return r3;
    }

    protected long getCorrectedReceivedAgeSecs(HttpCacheEntry r4) {
        long r0 = getApparentAgeSecs(r4);
        long r3 = getAgeValue(r4);
        if (r0 <= r3) goto L6;
        return r0;
    L6:
        return r3;
    }

    protected long getResponseDelaySecs(HttpCacheEntry r3) {
        return (r3.getResponseDate().getTime() - r3.getRequestDate().getTime()) / 1000;
    }

    protected long getCorrectedInitialAgeSecs(HttpCacheEntry r3) {
        return getCorrectedReceivedAgeSecs(r3) + getResponseDelaySecs(r3);
    }

    protected long getResidentTimeSecs(HttpCacheEntry r3, Date r4) {
        return (r4.getTime() - r3.getResponseDate().getTime()) / 1000;
    }

    protected long getMaxAge(HttpCacheEntry r13) {
        Header[] r12 = r13.getHeaders("Cache-Control");
        int r14 = r12.length;
        long r4 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r14) goto L19;
        HeaderElement[] r6 = r12[r3].getElements();
        int r7 = r6.length;
        int r8 = 0;
    L5:
        if (r8 >= r7) goto L18;
        HeaderElement r9 = r6[r8];
        if ("max-age".equals(r9.getName()) == false) goto L9;
    L20:
        long r10 = Long.parseLong(r9.getValue());     // Catch: NumberFormatException -> L16
        if (r4 != (-1)) goto L14;
    L15:
        r4 = r10;
    L17:
        r8 = r8 + 1;
        goto L5
    L14:
        if (r10 >= r4) goto L17;
    L16:
        r4 = 0;
        goto L17
    L9:
        if ("s-maxage".equals(r9.getName()) == false) goto L17;
    L18:
        r3 = r3 + 1;
        goto L3
    L19:
        return r4;
    }

    protected Date getExpirationDate(HttpCacheEntry r1) {
        Header r0 = r1.getFirstHeader("Expires");
        if (r0 != null) goto L7;
        return null;
    L7:
        return DateUtils.parseDate(r0.getValue());
    }

    public boolean hasCacheControlDirective(HttpCacheEntry r7, String r8) {
        Header[] r6 = r7.getHeaders("Cache-Control");
        int r9 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L12;
        HeaderElement[] r2 = r6[r1].getElements();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L11;
        if (r8.equalsIgnoreCase(r2[r4].getName()) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        return true;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return false;
    }

    public long getStalenessSecs(HttpCacheEntry r3, Date r4) {
        long r0 = getCurrentAgeSecs(r3, r4);
        long r2 = getFreshnessLifetimeSecs(r3);
        if (r0 > r2) goto L7;
        return 0;
    L7:
        return r0 - r2;
    }
}
