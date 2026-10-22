package cz.msebera.android.httpclient.impl.client.cache;

import com.android.settings.ApnEditor;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
class CachedResponseSuitabilityChecker {
    private final float heuristicCoefficient;
    private final long heuristicDefaultLifetime;
    public HttpClientAndroidLog log;
    private final boolean sharedCache;
    private final boolean useHeuristicCaching;
    private final CacheValidityPolicy validityStrategy;

    CachedResponseSuitabilityChecker(CacheValidityPolicy r3, CacheConfig r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.validityStrategy = r3;
        this.sharedCache = r4.isSharedCache();
        this.useHeuristicCaching = r4.isHeuristicCachingEnabled();
        this.heuristicCoefficient = r4.getHeuristicCoefficient();
        this.heuristicDefaultLifetime = r4.getHeuristicDefaultLifetime();
    }

    CachedResponseSuitabilityChecker(CacheConfig r2) {
        this(new CacheValidityPolicy(), r2);
    }

    private boolean isFreshEnough(HttpCacheEntry r9, HttpRequest r10, Date r11) {
        if (this.validityStrategy.isResponseFresh(r9, r11) == false) goto L6;
        return true;
    L6:
        if (this.useHeuristicCaching == false) goto L11;
        if (this.validityStrategy.isResponseHeuristicallyFresh(r9, r11, this.heuristicCoefficient, this.heuristicDefaultLifetime) == false) goto L11;
        return true;
    L11:
        if (originInsistsOnFreshness(r9) == false) goto L13;
        return false;
    L13:
        long r3 = getMaxStale(r10);
        if (r3 != (-1)) goto L17;
        return false;
    L17:
        if (r3 <= this.validityStrategy.getStalenessSecs(r9, r11)) goto L20;
        return true;
    L20:
        return false;
    }

    private boolean originInsistsOnFreshness(HttpCacheEntry r4) {
        if (this.validityStrategy.mustRevalidate(r4) == false) goto L6;
        return true;
    L6:
        if (this.sharedCache == true) goto L9;
        return false;
    L9:
        if (this.validityStrategy.proxyRevalidate(r4) == false) goto L11;
        return true;
    L11:
        if (this.validityStrategy.hasCacheControlDirective(r4, "s-maxage") == false) goto L14;
        return true;
    L14:
        return false;
    }

    private long getMaxStale(HttpRequest r15) {
        Header[] r14 = r15.getHeaders("Cache-Control");
        int r16 = r14.length;
        long r4 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r16) goto L28;
        HeaderElement[] r6 = r14[r3].getElements();
        int r7 = r6.length;
        int r8 = 0;
    L5:
        if (r8 >= r7) goto L27;
        HeaderElement r9 = r6[r8];
        if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(r9.getName()) == false) goto L26;
        if (r9.getValue() == null) goto L13;
        if ("".equals(r9.getValue().trim()) == true) goto L13;
    L15:
        long r10 = 0;
        long r12 = Long.parseLong(r9.getValue());     // Catch: NumberFormatException -> L29
        if (r12 < 0) goto L22;
        r10 = r12;
    L22:
        if (r4 == (-1)) goto L25;
        if (r10 >= r4) goto L26;
    L25:
        r4 = r10;
    L13:
        if (r4 != (-1)) goto L15;
        r4 = Long.MAX_VALUE;
    L26:
        r8 = r8 + 1;
        goto L5
    L27:
        r3 = r3 + 1;
        goto L3
    L28:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public boolean canCachedResponseBeUsed(HttpHost r17, HttpRequest r18, HttpCacheEntry r19, Date r20) {
        boolean r5 = false;
        if (isFreshEnough(r19, r18, r20) == true) goto L7;
        this.log.trace("Cache entry was not fresh enough");
        return false;
    L7:
        if (isGet(r18) == false) goto L13;
        if (this.validityStrategy.contentLengthHeaderMatchesActualLength(r19) == true) goto L13;
        this.log.debug("Cache entry Content-Length and header information do not match");
        return false;
    L13:
        if (hasUnsupportedConditionalHeaders(r18) == false) goto L17;
        this.log.debug("Request contained conditional headers we don't handle");
        return false;
    L17:
        if (isConditional(r18) == true) goto L22;
        if (r19.getStatusCode() != 304) goto L22;
        return false;
    L22:
        if (isConditional(r18) == false) goto L27;
        if (allConditionalsMatch(r18, r19, r20) == true) goto L27;
        return false;
    L27:
        if (hasUnsupportedCacheEntryForGet(r18, r19) == false) goto L30;
        this.log.debug("HEAD response caching enabled but the cache entry does not contain a request method, entity or a 204 response");
        return false;
    L30:
        Header[] r0 = r18.getHeaders("Cache-Control");
        int r4 = r0.length;
        int r6 = 0;
    L31:
        if (r6 >= r4) goto L78;
        HeaderElement[] r7 = r0[r6].getElements();
        int r8 = r7.length;
        ?? r9 = r5;
    L33:
        if (r9 >= r8) goto L77;
        HeaderElement r10 = r7[r9];
        if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(r10.getName()) == true) goto L36;
        if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(r10.getName()) == true) goto L40;
        if ("max-age".equals(r10.getName()) == false) goto L52;
    L48:
        e = move-exception;
        this.log.debug("Response from cache was malformed" + e.getMessage());
        return r5;
    L45:
        if (this.validityStrategy.getCurrentAgeSecs(r19, r20) <= Integer.parseInt(r10.getValue())) goto L52;
        this.log.trace("Response from cache was NOT suitable due to max age");     // Catch: NumberFormatException -> L48
        return r5;
    L52:
        if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(r10.getName()) == false) goto L63;
    L58:
        e = move-exception;
        this.log.debug("Response from cache was malformed: " + e.getMessage());
        return false;
    L54:
        if (this.validityStrategy.getFreshnessLifetimeSecs(r19) <= Integer.parseInt(r10.getValue())) goto L63;
        this.log.trace("Response from cache was not suitable due to Max stale freshness");     // Catch: NumberFormatException -> L58
        return false;
    L63:
        if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(r10.getName()) == false) goto L76;
        long r11 = Long.parseLong(r10.getValue());     // Catch: NumberFormatException -> L73
        if (r11 < 0) goto L66;
        if ((this.validityStrategy.getFreshnessLifetimeSecs(r19) - this.validityStrategy.getCurrentAgeSecs(r19, r20)) >= r11) goto L76;
        this.log.trace("Response from cache was not suitable due to min fresh freshness requirement");     // Catch: NumberFormatException -> L73
        return false;
    L66:
        return false;
    L73:
        e = move-exception;
        this.log.debug("Response from cache was malformed: " + e.getMessage());
        return false;
    L76:
        r5 = false;
        r6 = r6;
        r9 = r9 + 1;
        goto L33
    L40:
        this.log.trace("Response contained NO STORE directive, cache was not suitable");
        return r5;
    L36:
        this.log.trace("Response contained NO CACHE directive, cache was not suitable");
        return r5;
    L77:
        r6 = r6 + 1;
        goto L31
    L78:
        this.log.trace("Response from cache was suitable");
        return true;
    }

    private boolean isGet(HttpRequest r1) {
        return r1.getRequestLine().getMethod().equals("GET");
    }

    private boolean entryIsNotA204Response(HttpCacheEntry r1) {
        if (r1.getStatusCode() == 204) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean cacheEntryDoesNotContainMethodAndEntity(HttpCacheEntry r1) {
        if (r1.getRequestMethod() == null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getResource() != null) goto L7;
        return true;
    }

    private boolean hasUnsupportedCacheEntryForGet(HttpRequest r1, HttpCacheEntry r2) {
        if (isGet(r1) == true) goto L5;
    L9:
        return false;
    L5:
        if (cacheEntryDoesNotContainMethodAndEntity(r2) == false) goto L9;
        if (entryIsNotA204Response(r2) == false) goto L9;
        return true;
    }

    public boolean isConditional(HttpRequest r2) {
        if (hasSupportedEtagValidator(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasSupportedLastModifiedValidator(r2) == true) goto L8;
        return false;
    }

    public boolean allConditionalsMatch(HttpRequest r6, HttpCacheEntry r7, Date r8) {
        boolean r0 = hasSupportedEtagValidator(r6);
        boolean r1 = hasSupportedLastModifiedValidator(r6);
        if (r0 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r0 == false) goto L18;
        if (r1 == false) goto L18;
        if (r4 == false) goto L17;
        if (r5 == true) goto L18;
    L17:
        return false;
    L18:
        if (r0 == false) goto L21;
        if (r4 == true) goto L21;
        return false;
    L21:
        if (r1 == false) goto L24;
        if (r5 == true) goto L24;
        return false;
    L24:
        return true;
    L10:
        if (lastModifiedValidatorMatches(r6, r7, r8) == false) goto L12;
        r5 = true;
        goto L13
    L5:
        if (etagValidatorMatches(r6, r7) == false) goto L7;
        r4 = true;
        goto L8
    }

    private boolean hasUnsupportedConditionalHeaders(HttpRequest r2) {
        if (r2.getFirstHeader("If-Range") == null) goto L5;
    L10:
        return true;
    L5:
        if (r2.getFirstHeader("If-Match") != null) goto L10;
        if (hasValidDateField(r2, "If-Unmodified-Since") == true) goto L10;
        return false;
    }

    private boolean hasSupportedEtagValidator(HttpRequest r1) {
        return r1.containsHeader("If-None-Match");
    }

    private boolean hasSupportedLastModifiedValidator(HttpRequest r2) {
        return hasValidDateField(r2, "If-Modified-Since");
    }

    private boolean etagValidatorMatches(HttpRequest r8, HttpCacheEntry r9) {
        Header r7 = r9.getFirstHeader("ETag");
        if (r7 == null) goto L5;
        String r10 = r7.getValue();
    L6:
        Header[] r11 = r8.getHeaders("If-None-Match");
        if (r11 == null) goto L21;
        int r0 = r11.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L21;
        HeaderElement[] r2 = r11[r1].getElements();
        int r3 = r2.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L20;
        String r5 = r2[r4].toString();
        if (ApnEditor.APN_TYPE_ALL.equals(r5) == false) goto L16;
        if (r10 == null) goto L16;
        return true;
    L16:
        if (r5.equals(r10) == true) goto L17;
        r4 = r4 + 1;
        goto L11
    L17:
        return true;
    L20:
        r1 = r1 + 1;
    L21:
        return false;
    L5:
        r10 = null;
        goto L6
    }

    private boolean lastModifiedValidatorMatches(HttpRequest r5, HttpCacheEntry r6, Date r7) {
        Header r4 = r6.getFirstHeader("Last-Modified");
        if (r4 == null) goto L5;
        Date r8 = DateUtils.parseDate(r4.getValue());
    L7:
        if (r8 != null) goto L9;
        return false;
    L9:
        Header[] r9 = r5.getHeaders("If-Modified-Since");
        int r0 = r9.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L19;
        Date r2 = DateUtils.parseDate(r9[r1].getValue());
        if (r2 == null) goto L18;
        if (r2.after(r7) == true) goto L17;
        if (r8.after(r2) == false) goto L18;
    L17:
        return false;
    L18:
        r1 = r1 + 1;
        goto L10
    L19:
        return true;
    L5:
        r8 = null;
        goto L7
    }

    private boolean hasValidDateField(HttpRequest r1, String r2) {
        Header[] r0 = r1.getHeaders(r2);
        if (r0.length > 0) goto L5;
        return false;
    L5:
        if (DateUtils.parseDate(r0[0].getValue()) == null) goto L9;
        return true;
    L9:
        return false;
    }
}
