package cz.msebera.android.httpclient.impl.client.cache;

import com.android.settings.ApnEditor;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
class ResponseCachingPolicy {
    private static final String[] AUTH_CACHEABLE_PARAMS = null;
    private static final Set<Integer> cacheableStatuses = null;
    public HttpClientAndroidLog log;
    private final long maxObjectSizeBytes;
    private final boolean neverCache1_0ResponsesWithQueryString;
    private final boolean sharedCache;
    private final Set<Integer> uncacheableStatuses;

    private boolean unknownStatusCode(int r2) {
        if (r2 < 100) goto L8;
        if (r2 > 101) goto L8;
        return false;
    L8:
        if (r2 < 200) goto L13;
        if (r2 > 206) goto L13;
        return false;
    L13:
        if (r2 < 300) goto L18;
        if (r2 > 307) goto L18;
        return false;
    L18:
        if (r2 < 400) goto L23;
        if (r2 > 417) goto L23;
        return false;
    L23:
        if (r2 >= 500) goto L25;
        return true;
    L25:
        if (r2 > 505) goto L29;
        return false;
    L29:
        return true;
    }

    static {
        AUTH_CACHEABLE_PARAMS = new String[]{"s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, HeaderConstants.PUBLIC};
        cacheableStatuses = new HashSet(Arrays.asList(new Integer[]{200, 203, 300, 301, 410}));
    }

    public ResponseCachingPolicy(long r3, boolean r5, boolean r6, boolean r7) {
        this.log = new HttpClientAndroidLog(getClass());
        this.maxObjectSizeBytes = r3;
        this.sharedCache = r5;
        this.neverCache1_0ResponsesWithQueryString = r6;
        if (r7 == false) goto L5;
        this.uncacheableStatuses = new HashSet(Arrays.asList(new Integer[]{206}));
        return;
    L5:
        this.uncacheableStatuses = new HashSet(Arrays.asList(new Integer[]{206, 303}));
    }

    public boolean isResponseCacheable(String r11, HttpResponse r12) {
        if ("GET".equals(r11) == false) goto L5;
    L8:
        int r13 = r12.getStatusLine().getStatusCode();
        if (cacheableStatuses.contains(Integer.valueOf(r13)) == false) goto L12;
        boolean r14 = true;
    L18:
        Header r0 = r12.getFirstHeader("Content-Length");
        if (r0 == null) goto L24;
        if (Long.parseLong(r0.getValue()) <= this.maxObjectSizeBytes) goto L24;
        return false;
    L24:
        if (r12.getHeaders("Age").length <= 1) goto L27;
        return false;
    L27:
        if (r12.getHeaders("Expires").length <= 1) goto L29;
        return false;
    L29:
        Header[] r1 = r12.getHeaders("Date");
        if (r1.length == 1) goto L33;
        return false;
    L33:
        if (DateUtils.parseDate(r1[0].getValue()) != null) goto L35;
        return false;
    L35:
        Header[] r2 = r12.getHeaders("Vary");
        int r3 = r2.length;
        int r4 = 0;
    L36:
        if (r4 >= r3) goto L45;
        HeaderElement[] r5 = r2[r4].getElements();
        int r6 = r5.length;
        int r7 = 0;
    L38:
        if (r7 >= r6) goto L43;
        if (ApnEditor.APN_TYPE_ALL.equals(r5[r7].getName()) == true) goto L41;
        r7 = r7 + 1;
        goto L38
    L41:
        return false;
    L43:
        r4 = r4 + 1;
        goto L36
    L45:
        if (isExplicitlyNonCacheable(r12) == false) goto L47;
        return false;
    L47:
        if (r14 == true) goto L51;
        if (isExplicitlyCacheable(r12) == true) goto L51;
        return false;
    L51:
        return true;
    L12:
        if (this.uncacheableStatuses.contains(Integer.valueOf(r13)) == false) goto L15;
        return false;
    L15:
        if (unknownStatusCode(r13) == false) goto L17;
        return false;
    L17:
        r14 = false;
        goto L18
    L5:
        if ("HEAD".equals(r11) == true) goto L8;
        this.log.debug("Response was not cacheable.");
        return false;
    }

    protected boolean isExplicitlyNonCacheable(HttpResponse r10) {
        Header[] r11 = r10.getHeaders("Cache-Control");
        int r0 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L19;
        HeaderElement[] r3 = r11[r2].getElements();
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L18;
        HeaderElement r6 = r3[r5];
        if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(r6.getName()) == true) goto L16;
        if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(r6.getName()) == true) goto L27;
        if (this.sharedCache == false) goto L15;
        if (HeaderConstants.PRIVATE.equals(r6.getName()) == false) goto L15;
        return true;
    L15:
        r5 = r5 + 1;
        goto L5
    L27:
        return true;
    L16:
        return true;
    L18:
        r2 = r2 + 1;
        goto L3
    L19:
        return false;
    }

    protected boolean hasCacheControlParameterFrom(HttpMessage r11, String[] r12) {
        Header[] r10 = r11.getHeaders("Cache-Control");
        int r13 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r13) goto L15;
        HeaderElement[] r2 = r10[r1].getElements();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        HeaderElement r5 = r2[r4];
        int r6 = r12.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L13;
        if (r12[r7].equalsIgnoreCase(r5.getName()) == true) goto L10;
        r7 = r7 + 1;
        goto L7
    L10:
        return true;
    L13:
        r4 = r4 + 1;
        goto L5
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        return false;
    }

    protected boolean isExplicitlyCacheable(HttpResponse r6) {
        if (r6.getFirstHeader("Expires") == null) goto L7;
        return true;
    L7:
        return hasCacheControlParameterFrom(r6, new String[]{"max-age", "s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE, HeaderConstants.PUBLIC});
    }

    public boolean isResponseCacheable(HttpRequest r4, HttpResponse r5) {
        if (requestProtocolGreaterThanAccepted(r4) == false) goto L7;
        this.log.debug("Response was not cacheable.");
        return false;
    L7:
        if (hasCacheControlParameterFrom(r4, new String[]{HeaderConstants.CACHE_CONTROL_NO_STORE}) == false) goto L10;
        return false;
    L10:
        if (r4.getRequestLine().getUri().contains("?") == false) goto L22;
        if (this.neverCache1_0ResponsesWithQueryString == false) goto L18;
        if (from1_0Origin(r5) == false) goto L18;
        this.log.debug("Response was not cacheable as it had a query string.");
        return false;
    L18:
        if (isExplicitlyCacheable(r5) == true) goto L22;
        this.log.debug("Response was not cacheable as it is missing explicit caching headers.");
        return false;
    L22:
        if (expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(r5) == false) goto L25;
        return false;
    L25:
        if (this.sharedCache == false) goto L34;
        Header[] r0 = r4.getHeaders("Authorization");
        if (r0 == null) goto L34;
        if (r0.length <= 0) goto L34;
        if (hasCacheControlParameterFrom(r5, AUTH_CACHEABLE_PARAMS) == true) goto L34;
        return false;
    L34:
        return isResponseCacheable(r4.getRequestLine().getMethod(), r5);
    }

    private boolean expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(HttpResponse r3) {
        if (r3.getFirstHeader("Cache-Control") == null) goto L5;
        return false;
    L5:
        Header r2 = r3.getFirstHeader("Expires");
        Header r4 = r3.getFirstHeader("Date");
        if (r2 == null) goto L19;
        if (r4 == null) goto L22;
        Date r5 = DateUtils.parseDate(r2.getValue());
        Date r6 = DateUtils.parseDate(r4.getValue());
        if (r5 == null) goto L20;
        if (r6 != null) goto L14;
        return false;
    L14:
        if (r5.equals(r6) == false) goto L16;
    L17:
        return true;
    L16:
        if (r5.before(r6) == true) goto L17;
        return false;
    L20:
        return false;
    L22:
        return false;
    L19:
        return false;
    }

    private boolean from1_0Origin(HttpResponse r2) {
        Header r1 = r2.getFirstHeader("Via");
        if (r1 == null) goto L13;
        HeaderElement[] r3 = r1.getElements();
        if (r3.length <= 0) goto L13;
        String r4 = r3[0].toString().split("\\s")[0];
        if (r4.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L11;
        return r4.equals("HTTP/1.0");
    L11:
        return r4.equals("1.0");
    L13:
        return HttpVersion.HTTP_1_0.equals(r2.getProtocolVersion());
    }

    private boolean requestProtocolGreaterThanAccepted(HttpRequest r1) {
        if (r1.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
