package cz.msebera.android.httpclient.impl.client.cache;

import com.android.settings.ApnEditor;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.cache.CacheResponseStatus;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheContext;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public class CachingExec implements ClientExecChain {
    private static final boolean SUPPORTS_RANGE_AND_CONTENT_RANGE_HEADERS = false;
    private final AsynchronousValidator asynchRevalidator;
    private final ClientExecChain backend;
    private final CacheConfig cacheConfig;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private final AtomicLong cacheUpdates;
    private final CacheableRequestPolicy cacheableRequestPolicy;
    private final ConditionalRequestBuilder conditionalRequestBuilder;
    public HttpClientAndroidLog log;
    private final RequestProtocolCompliance requestCompliance;
    private final HttpCache responseCache;
    private final ResponseCachingPolicy responseCachingPolicy;
    private final ResponseProtocolCompliance responseCompliance;
    private final CachedHttpResponseGenerator responseGenerator;
    private final CachedResponseSuitabilityChecker suitabilityChecker;
    private final CacheValidityPolicy validityPolicy;
    private final Map<ProtocolVersion, String> viaHeaders;

    private boolean staleIfErrorAppliesTo(int r1) {
        if (r1 != 500) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 502) goto L12;
        if (r1 == 503) goto L12;
        if (r1 == 504) goto L12;
        return false;
    }

    public boolean supportsRangeAndContentRangeHeaders() {
        return false;
    }

    public CachingExec(ClientExecChain r2, HttpCache r3, CacheConfig r4) {
        this(r2, r3, r4, null);
    }

    public CachingExec(ClientExecChain r7, HttpCache r8, CacheConfig r9, AsynchronousValidator r10) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.viaHeaders = new HashMap(4);
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r7, "HTTP backend");
        Args.notNull(r8, "HttpCache");
        if (r9 != null) goto L6;
        r9 = CacheConfig.DEFAULT;
    L6:
        this.cacheConfig = r9;
        this.backend = r7;
        this.responseCache = r8;
        CacheValidityPolicy r11 = new CacheValidityPolicy();
        this.validityPolicy = r11;
        this.responseGenerator = new CachedHttpResponseGenerator(r11);
        this.cacheableRequestPolicy = new CacheableRequestPolicy();
        this.suitabilityChecker = new CachedResponseSuitabilityChecker(r11, r9);
        this.conditionalRequestBuilder = new ConditionalRequestBuilder();
        this.responseCompliance = new ResponseProtocolCompliance();
        this.requestCompliance = new RequestProtocolCompliance(r9.isWeakETagOnPutDeleteAllowed());
        this.responseCachingPolicy = new ResponseCachingPolicy(r9.getMaxObjectSize(), r9.isSharedCache(), r9.isNeverCacheHTTP10ResponsesWithQuery(), r9.is303CachingEnabled());
        this.asynchRevalidator = r10;
    }

    public CachingExec(ClientExecChain r2, ResourceFactory r3, HttpCacheStorage r4, CacheConfig r5) {
        this(r2, new BasicHttpCache(r3, r4, r5), r5);
    }

    public CachingExec(ClientExecChain r3) {
        this(r3, new BasicHttpCache(), CacheConfig.DEFAULT);
    }

    CachingExec(ClientExecChain r3, HttpCache r4, CacheValidityPolicy r5, ResponseCachingPolicy r6, CachedHttpResponseGenerator r7, CacheableRequestPolicy r8, CachedResponseSuitabilityChecker r9, ConditionalRequestBuilder r10, ResponseProtocolCompliance r11, RequestProtocolCompliance r12, CacheConfig r13, AsynchronousValidator r14) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.viaHeaders = new HashMap(4);
        this.log = new HttpClientAndroidLog(getClass());
        if (r13 != null) goto L6;
        r13 = CacheConfig.DEFAULT;
    L6:
        this.cacheConfig = r13;
        this.backend = r3;
        this.responseCache = r4;
        this.validityPolicy = r5;
        this.responseCachingPolicy = r6;
        this.responseGenerator = r7;
        this.cacheableRequestPolicy = r8;
        this.suitabilityChecker = r9;
        this.conditionalRequestBuilder = r10;
        this.responseCompliance = r11;
        this.requestCompliance = r12;
        this.asynchRevalidator = r14;
    }

    public long getCacheHits() {
        return this.cacheHits.get();
    }

    public long getCacheMisses() {
        return this.cacheMisses.get();
    }

    public long getCacheUpdates() {
        return this.cacheUpdates.get();
    }

    public CloseableHttpResponse execute(HttpRoute r3, HttpRequestWrapper r4) throws IOException, HttpException {
        return execute(r3, r4, HttpClientContext.create(), null);
    }

    public CloseableHttpResponse execute(HttpRoute r2, HttpRequestWrapper r3, HttpClientContext r4) throws IOException, HttpException {
        return execute(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r7, HttpRequestWrapper r8, HttpClientContext r9, HttpExecutionAware r10) throws IOException, HttpException {
        HttpHost r0 = r9.getTargetHost();
        String r1 = generateViaHeader(r8.getOriginal());
        setResponseStatus(r9, CacheResponseStatus.CACHE_MISS);
        if (clientRequestsOurOptions(r8) == false) goto L6;
        setResponseStatus(r9, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        return Proxies.enhanceResponse(new OptionsHttp11Response());
    L6:
        HttpResponse r2 = getFatallyNoncompliantResponse(r8, r9);
        if (r2 != null) goto L9;
        this.requestCompliance.makeRequestCompliant(r8);
        r8.addHeader("Via", r1);
        if (this.cacheableRequestPolicy.isServableFromCache(r8) == true) goto L14;
        this.log.debug("Request is not servable from cache");
        flushEntriesInvalidatedByRequest(r9.getTargetHost(), r8);
        return callBackend(r7, r8, r9, r10);
    L14:
        HttpCacheEntry r5 = satisfyFromCache(r0, r8);
        if (r5 != null) goto L19;
        this.log.debug("Cache miss");
        return handleCacheMiss(r7, r8, r9, r10);
    L19:
        return handleCacheHit(r7, r8, r9, r10, r5);
    L9:
        return Proxies.enhanceResponse(r2);
    }

    private CloseableHttpResponse handleCacheHit(HttpRoute r9, HttpRequestWrapper r10, HttpClientContext r11, HttpExecutionAware r12, HttpCacheEntry r13) throws IOException, HttpException {
        HttpHost r0 = r11.getTargetHost();
        recordCacheHit(r0, r10);
        Date r7 = getCurrentDate();
        if (this.suitabilityChecker.canCachedResponseBeUsed(r0, r10, r13, r7) == false) goto L6;
        this.log.debug("Cache hit");
        CloseableHttpResponse r8 = generateCachedResponse(r10, r11, r13, r7);
    L8:
        r11.setAttribute("http.route", r9);
        r11.setAttribute("http.target_host", r0);
        r11.setAttribute("http.request", r10);
        r11.setAttribute("http.response", r8);
        r11.setAttribute("http.request_sent", Boolean.TRUE);
        return r8;
    L6:
        if (mayCallBackend(r10) == true) goto L11;
        this.log.debug("Cache entry not suitable but only-if-cached requested");
        r8 = generateGatewayTimeout(r11);
        goto L8
    L11:
        if (r13.getStatusCode() == 304) goto L13;
    L17:
        this.log.debug("Revalidating cache entry");
        return revalidateCacheEntry(r9, r10, r11, r12, r13, r7);
    L13:
        if (this.suitabilityChecker.isConditional(r10) == true) goto L17;
        this.log.debug("Cache entry not usable; calling backend");
        return callBackend(r9, r10, r11, r12);
    }

    private CloseableHttpResponse revalidateCacheEntry(HttpRoute r9, HttpRequestWrapper r10, HttpClientContext r11, HttpExecutionAware r12, HttpCacheEntry r13, Date r14) throws HttpException {
        if (this.asynchRevalidator == null) goto L11;
        if (staleResponseNotAllowed(r10, r13, r14) == true) goto L11;
        if (this.validityPolicy.mayReturnStaleWhileRevalidating(r13, r14) == false) goto L11;
        this.log.trace("Serving stale with asynchronous revalidation");     // Catch: IOException -> L12
        CloseableHttpResponse r0 = generateCachedResponse(r10, r11, r13, r14);     // Catch: IOException -> L12
        this.asynchRevalidator.revalidateCacheEntry(this, r9, r10, r11, r12, r13);     // Catch: IOException -> L12
        return r0;
    L11:
        return revalidateCacheEntry(r9, r10, r11, r12, r13);
    L13:
        return handleRevalidationFailure(r10, r11, r13, r14);
    }

    private CloseableHttpResponse handleCacheMiss(HttpRoute r7, HttpRequestWrapper r8, HttpClientContext r9, HttpExecutionAware r10) throws IOException, HttpException {
        HttpHost r0 = r9.getTargetHost();
        recordCacheMiss(r0, r8);
        if (mayCallBackend(r8) == false) goto L5;
        Map<String, Variant> r5 = getExistingCacheVariants(r0, r8);
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        return negotiateResponseFromVariants(r7, r8, r9, r10, r5);
    L13:
        return callBackend(r7, r8, r9, r10);
    L5:
        return Proxies.enhanceResponse(new BasicHttpResponse(HttpVersion.HTTP_1_1, 504, "Gateway Timeout"));
    }

    private HttpCacheEntry satisfyFromCache(HttpHost r2, HttpRequestWrapper r3) {
        return this.responseCache.getCacheEntry(r2, r3);
    L4:
        e = move-exception;
        this.log.warn("Unable to retrieve entries from cache", e);
        return null;
    }

    private HttpResponse getFatallyNoncompliantResponse(HttpRequestWrapper r3, HttpContext r4) {
        Iterator<RequestProtocolError> r5 = this.requestCompliance.requestIsFatallyNonCompliant(r3).iterator();
        HttpResponse r0 = null;
    L4:
        if (r5.hasNext() == false) goto L6;
        RequestProtocolError r1 = r5.next();
        setResponseStatus(r4, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        r0 = this.requestCompliance.getErrorForRequest(r1);
        goto L4
    L6:
        return r0;
    }

    private Map<String, Variant> getExistingCacheVariants(HttpHost r2, HttpRequestWrapper r3) {
        return this.responseCache.getVariantCacheEntriesWithEtags(r2, r3);
    L4:
        e = move-exception;
        this.log.warn("Unable to retrieve variant entries from cache", e);
        return null;
    }

    private void recordCacheMiss(HttpHost r3, HttpRequestWrapper r4) {
        this.cacheMisses.getAndIncrement();
        if (this.log.isTraceEnabled() == false) goto L6;
        this.log.trace("Cache miss [host: " + r3 + "; uri: " + r4.getRequestLine().getUri() + "]");
        return;
    }

    private void recordCacheHit(HttpHost r3, HttpRequestWrapper r4) {
        this.cacheHits.getAndIncrement();
        if (this.log.isTraceEnabled() == false) goto L6;
        this.log.trace("Cache hit [host: " + r3 + "; uri: " + r4.getRequestLine().getUri() + "]");
        return;
    }

    private void recordCacheUpdate(HttpContext r2) {
        this.cacheUpdates.getAndIncrement();
        setResponseStatus(r2, CacheResponseStatus.VALIDATED);
    }

    private void flushEntriesInvalidatedByRequest(HttpHost r2, HttpRequestWrapper r3) {
        this.responseCache.flushInvalidatedCacheEntriesFor(r2, r3);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.log.warn("Unable to flush invalidated entries from cache", e);
    }

    private CloseableHttpResponse generateCachedResponse(HttpRequestWrapper r3, HttpContext r4, HttpCacheEntry r5, Date r6) {
        if (r3.containsHeader("If-None-Match") == false) goto L5;
    L8:
        CloseableHttpResponse r7 = this.responseGenerator.generateNotModifiedResponse(r5);
    L9:
        setResponseStatus(r4, CacheResponseStatus.CACHE_HIT);
        if (this.validityPolicy.getStalenessSecs(r5, r6) <= 0) goto L12;
        r7.addHeader("Warning", "110 localhost \"Response is stale\"");
    L12:
        return r7;
    L5:
        if (r3.containsHeader("If-Modified-Since") == true) goto L8;
        r7 = this.responseGenerator.generateResponse(r3, r5);
        goto L9
    }

    private CloseableHttpResponse handleRevalidationFailure(HttpRequestWrapper r1, HttpContext r2, HttpCacheEntry r3, Date r4) {
        if (staleResponseNotAllowed(r1, r3, r4) == false) goto L7;
        return generateGatewayTimeout(r2);
    L7:
        return unvalidatedCacheHit(r1, r2, r3);
    }

    private CloseableHttpResponse generateGatewayTimeout(HttpContext r3) {
        setResponseStatus(r3, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        return Proxies.enhanceResponse(new BasicHttpResponse(HttpVersion.HTTP_1_1, 504, "Gateway Timeout"));
    }

    private CloseableHttpResponse unvalidatedCacheHit(HttpRequestWrapper r2, HttpContext r3, HttpCacheEntry r4) {
        CloseableHttpResponse r5 = this.responseGenerator.generateResponse(r2, r4);
        setResponseStatus(r3, CacheResponseStatus.CACHE_HIT);
        r5.addHeader("Warning", "111 localhost \"Revalidation failed\"");
        return r5;
    }

    private boolean staleResponseNotAllowed(HttpRequestWrapper r2, HttpCacheEntry r3, Date r4) {
        if (this.validityPolicy.mustRevalidate(r3) == false) goto L5;
    L12:
        return true;
    L5:
        if (this.cacheConfig.isSharedCache() == false) goto L9;
        if (this.validityPolicy.proxyRevalidate(r3) == true) goto L12;
    L9:
        if (explicitFreshnessRequest(r2, r3, r4) == true) goto L12;
        return false;
    }

    private boolean mayCallBackend(HttpRequestWrapper r9) {
        Header[] r10 = r9.getHeaders("Cache-Control");
        int r0 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        HeaderElement[] r3 = r10[r2].getElements();
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        if ("only-if-cached".equals(r3[r5].getName()) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        this.log.trace("Request marked only-if-cached");
        return false;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return true;
    }

    private boolean explicitFreshnessRequest(HttpRequestWrapper r18, HttpCacheEntry r19, Date r20) {
        Header[] r2 = r18.getHeaders("Cache-Control");
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L20;
        HeaderElement[] r6 = r2[r5].getElements();
        int r7 = r6.length;
        int r8 = 0;
    L5:
        if (r8 >= r7) goto L19;
        HeaderElement r9 = r6[r8];
        if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(r9.getName()) == false) goto L13;
        if ((this.validityPolicy.getCurrentAgeSecs(r19, r20) - this.validityPolicy.getFreshnessLifetimeSecs(r19)) > Integer.parseInt(r9.getValue())) goto L11;
    L17:
        r8 = r8 + 1;
    L11:
        return true;
    L13:
        if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(r9.getName()) == true) goto L18;
        if ("max-age".equals(r9.getName()) == false) goto L17;
    L18:
        return true;
    L19:
        r5 = r5 + 1;
        goto L3
    L20:
        return false;
    }

    private String generateViaHeader(HttpMessage r10) {
        ProtocolVersion r11 = r10.getProtocolVersion();
        String r0 = this.viaHeaders.get(r11);
        if (r0 == null) goto L5;
        return r0;
    L5:
        VersionInfo r1 = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", getClass().getClassLoader());
        if (r1 == null) goto L8;
        String r2 = r1.getRelease();
    L9:
        int r3 = r11.getMajor();
        int r4 = r11.getMinor();
        if ("http".equalsIgnoreCase(r11.getProtocol()) == false) goto L12;
        String r5 = String.format("%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{Integer.valueOf(r3), Integer.valueOf(r4), r2});
    L13:
        this.viaHeaders.put(r11, r5);
        return r5;
    L12:
        r5 = String.format("%s/%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{r11.getProtocol(), Integer.valueOf(r3), Integer.valueOf(r4), r2});
        goto L13
    L8:
        r2 = VersionInfo.UNAVAILABLE;
        goto L9
    }

    private void setResponseStatus(HttpContext r1, CacheResponseStatus r2) {
        if (r1 == null) goto L5;
        r1.setAttribute(HttpCacheContext.CACHE_RESPONSE_STATUS, r2);
        return;
    }

    Date getCurrentDate() {
        return new Date();
    }

    boolean clientRequestsOurOptions(HttpRequest r3) {
        RequestLine r2 = r3.getRequestLine();
        if ("OPTIONS".equals(r2.getMethod()) == true) goto L6;
        return false;
    L6:
        if (ApnEditor.APN_TYPE_ALL.equals(r2.getUri()) == true) goto L9;
        return false;
    L9:
        if ("0".equals(r3.getFirstHeader("Max-Forwards").getValue()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    CloseableHttpResponse callBackend(HttpRoute r7, HttpRequestWrapper r8, HttpClientContext r9, HttpExecutionAware r10) throws IOException, HttpException {
        Date r3 = getCurrentDate();
        this.log.trace("Calling the backend");
        CloseableHttpResponse r11 = this.backend.execute(r7, r8, r9, r10);
        r11.addHeader("Via", generateViaHeader(r11));     // Catch: RuntimeException -> L5 IOException -> L8
        return handleBackendResponse(r8, r9, r3, getCurrentDate(), r11);
    L8:
        e = move-exception;
        r11.close();
        throw e;
    L5:
        e = move-exception;
        r11.close();
        throw e;
    }

    private boolean revalidationResponseIsTooOld(HttpResponse r1, HttpCacheEntry r2) {
        Header r3 = r2.getFirstHeader("Date");
        Header r0 = r1.getFirstHeader("Date");
        if (r3 == null) goto L13;
        if (r0 == null) goto L13;
        Date r4 = DateUtils.parseDate(r3.getValue());
        Date r5 = DateUtils.parseDate(r0.getValue());
        if (r4 == null) goto L13;
        if (r5 == null) goto L13;
        if (r5.before(r4) == false) goto L13;
        return true;
    L13:
        return false;
    }

    CloseableHttpResponse negotiateResponseFromVariants(HttpRoute r11, HttpRequestWrapper r12, HttpClientContext r13, HttpExecutionAware r14, Map<String, Variant> r15) throws IOException, HttpException {
        HttpRequestWrapper r3 = this.conditionalRequestBuilder.buildConditionalRequestFromVariants(r12, r15);
        Date r7 = getCurrentDate();
        CloseableHttpResponse r0 = this.backend.execute(r11, r3, r13, r14);
        Date r8 = getCurrentDate();     // Catch: RuntimeException -> L24 IOException -> L27
        r0.addHeader("Via", generateViaHeader(r0));     // Catch: RuntimeException -> L24 IOException -> L27
        if (r0.getStatusLine().getStatusCode() != 304) goto L6;
        Header r1 = r0.getFirstHeader("ETag");     // Catch: RuntimeException -> L24 IOException -> L27
        if (r1 != null) goto L11;
        this.log.warn("304 response did not contain ETag");     // Catch: RuntimeException -> L24 IOException -> L27
        IOUtils.consume(r0.getEntity());     // Catch: RuntimeException -> L24 IOException -> L27
        r0.close();     // Catch: RuntimeException -> L24 IOException -> L27
        return callBackend(r11, r12, r13, r14);
    L11:
        Variant r16 = r15.get(r1.getValue());     // Catch: RuntimeException -> L24 IOException -> L27
        if (r16 != null) goto L15;
        this.log.debug("304 response did not contain ETag matching one sent in If-None-Match");     // Catch: RuntimeException -> L24 IOException -> L27
        IOUtils.consume(r0.getEntity());     // Catch: RuntimeException -> L24 IOException -> L27
        r0.close();     // Catch: RuntimeException -> L24 IOException -> L27
        return callBackend(r11, r12, r13, r14);
    L15:
        HttpCacheEntry r9 = r16.getEntry();     // Catch: RuntimeException -> L24 IOException -> L27
        if (revalidationResponseIsTooOld(r0, r9) == false) goto L19;
        IOUtils.consume(r0.getEntity());     // Catch: RuntimeException -> L24 IOException -> L27
        r0.close();     // Catch: RuntimeException -> L24 IOException -> L27
        return retryRequestUnconditionally(r11, r12, r13, r14, r9);
    L19:
        recordCacheUpdate(r13);     // Catch: RuntimeException -> L24 IOException -> L27
        HttpCacheEntry r17 = getUpdatedVariantEntry(r13.getTargetHost(), r3, r7, r8, r0, r16, r9);     // Catch: RuntimeException -> L24 IOException -> L27
        r0.close();     // Catch: RuntimeException -> L24 IOException -> L27
        CloseableHttpResponse r18 = this.responseGenerator.generateResponse(r12, r17);     // Catch: RuntimeException -> L24 IOException -> L27
        tryToUpdateVariantMap(r13.getTargetHost(), r12, r16);     // Catch: RuntimeException -> L24 IOException -> L27
        if (shouldSendNotModifiedResponse(r12, r17) == true) goto L22;
        return r18;
    L22:
        return this.responseGenerator.generateNotModifiedResponse(r17);
    L6:
        return handleBackendResponse(r12, r13, r7, r8, r0);
    L27:
        e = move-exception;
        r0.close();
        throw e;
    L24:
        e = move-exception;
        r0.close();
        throw e;
    }

    private CloseableHttpResponse retryRequestUnconditionally(HttpRoute r2, HttpRequestWrapper r3, HttpClientContext r4, HttpExecutionAware r5, HttpCacheEntry r6) throws IOException, HttpException {
        return callBackend(r2, this.conditionalRequestBuilder.buildUnconditionalRequest(r3, r6), r4, r5);
    }

    private HttpCacheEntry getUpdatedVariantEntry(HttpHost r9, HttpRequestWrapper r10, Date r11, Date r12, CloseableHttpResponse r13, Variant r14, HttpCacheEntry r15) throws IOException {
        r15 = this.responseCache.updateVariantCacheEntry(r9, r10, r15, r13, r11, r12, r14.getCacheKey());     // Catch: Throwable -> L4 IOException -> L6
    L3:
        r13.close();
        return r15;
    L4:
        th = move-exception;
        r13.close();
        throw th;
    L6:
        e = move-exception;
        this.log.warn("Could not update cache entry", e);     // Catch: Throwable -> L4
        goto L3
    }

    private void tryToUpdateVariantMap(HttpHost r2, HttpRequestWrapper r3, Variant r4) {
        this.responseCache.reuseVariantEntryFor(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.log.warn("Could not update cache entry to reuse variant", e);
    }

    private boolean shouldSendNotModifiedResponse(HttpRequestWrapper r2, HttpCacheEntry r3) {
        if (this.suitabilityChecker.isConditional(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.suitabilityChecker.allConditionalsMatch(r2, r3, new Date()) == false) goto L7;
        return true;
    }

    CloseableHttpResponse revalidateCacheEntry(HttpRoute r11, HttpRequestWrapper r12, HttpClientContext r13, HttpExecutionAware r14, HttpCacheEntry r15) throws IOException, HttpException {
        HttpRequestWrapper r2 = this.conditionalRequestBuilder.buildConditionalRequest(r12, r15);
        URI r0 = r2.getURI();
        if (r0 != null) goto L41;
    L9:
        Date r1 = getCurrentDate();
        CloseableHttpResponse r3 = this.backend.execute(r11, r2, r13, r14);
        Date r4 = getCurrentDate();
        if (revalidationResponseIsTooOld(r3, r15) == false) goto L12;
        r3.close();
        HttpRequestWrapper r5 = this.conditionalRequestBuilder.buildUnconditionalRequest(r12, r15);
        Date r6 = getCurrentDate();
        CloseableHttpResponse r7 = this.backend.execute(r11, r5, r13, r14);
        Date r9 = getCurrentDate();
        Date r8 = r6;
    L13:
        r7.addHeader("Via", generateViaHeader(r7));
        int r16 = r7.getStatusLine().getStatusCode();
        if (r16 != 304) goto L16;
    L17:
        recordCacheUpdate(r13);
    L18:
        if (r16 != 304) goto L28;
        HttpCacheEntry r17 = this.responseCache.updateCacheEntry(r13.getTargetHost(), r12, r15, r7, r8, r9);
        if (this.suitabilityChecker.isConditional(r12) == false) goto L26;
        if (this.suitabilityChecker.allConditionalsMatch(r12, r17, new Date()) == false) goto L26;
        return this.responseGenerator.generateNotModifiedResponse(r17);
    L26:
        return this.responseGenerator.generateResponse(r12, r17);
    L28:
        if (staleIfErrorAppliesTo(r16) == false) goto L40;
        if (staleResponseNotAllowed(r12, r15, getCurrentDate()) == true) goto L40;
        if (this.validityPolicy.mayReturnStaleIfError(r12, r15, r9) == false) goto L40;
        CloseableHttpResponse r10 = this.responseGenerator.generateResponse(r12, r15);     // Catch: Throwable -> L36
        r10.addHeader("Warning", "110 localhost \"Response is stale\"");     // Catch: Throwable -> L36
        r7.close();
        return r10;
    L36:
        th = move-exception;
        r7.close();
        throw th;
    L40:
        return handleBackendResponse(r2, r13, r8, r9, r7);
    L16:
        if (r16 != 200) goto L18;
    L12:
        r8 = r1;
        r7 = r3;
        r9 = r4;
        goto L13
    L41:
        r2.setURI(URIUtils.rewriteURIForRoute(r0, r11, r13.getRequestConfig().isNormalizeUri()));     // Catch: URISyntaxException -> L6
    L6:
        e = move-exception;
        throw new ProtocolException("Invalid URI: " + r0, e);
    }

    CloseableHttpResponse handleBackendResponse(HttpRequestWrapper r8, HttpClientContext r9, Date r10, Date r11, CloseableHttpResponse r12) throws IOException {
        this.log.trace("Handling Backend response");
        this.responseCompliance.ensureProtocolCompliance(r8, r12);
        HttpHost r2 = r9.getTargetHost();
        boolean r13 = this.responseCachingPolicy.isResponseCacheable(r8, r12);
        this.responseCache.flushInvalidatedCacheEntriesFor(r2, r8, r12);
        if (r13 == true) goto L5;
    L8:
        if (r13 == false) goto L14;
    L13:
        return r12;
    L14:
        this.responseCache.flushCacheEntriesFor(r2, r8);     // Catch: IOException -> L11
    L11:
        e = move-exception;
        this.log.warn("Unable to flush invalid cache entries", e);
        goto L13
    L5:
        if (alreadyHaveNewerCacheEntry(r2, r8, r12) == true) goto L8;
        storeRequestIfModifiedSinceFor304Response(r8, r12);
        return this.responseCache.cacheAndReturnResponse(r2, r8, r12, r10, r11);
    }

    private void storeRequestIfModifiedSinceFor304Response(HttpRequest r2, HttpResponse r3) {
        if (r3.getStatusLine().getStatusCode() != 304) goto L8;
        Header r1 = r2.getFirstHeader("If-Modified-Since");
        if (r1 == null) goto L9;
        r3.addHeader("Last-Modified", r1.getValue());
        return;
    L9:
        return;
    }

    private boolean alreadyHaveNewerCacheEntry(HttpHost r1, HttpRequestWrapper r2, HttpResponse r3) {
        HttpCacheEntry r0 = this.responseCache.getCacheEntry(r1, r2);     // Catch: IOException -> L4
    L6:
        if (r0 != null) goto L8;
        return false;
    L8:
        Header r4 = r0.getFirstHeader("Date");
        if (r4 != null) goto L11;
        return false;
    L11:
        Header r5 = r3.getFirstHeader("Date");
        if (r5 != null) goto L14;
        return false;
    L14:
        Date r6 = DateUtils.parseDate(r4.getValue());
        Date r7 = DateUtils.parseDate(r5.getValue());
        if (r6 == null) goto L20;
        if (r7 == null) goto L20;
        return r7.before(r6);
    L20:
        return false;
    L4:
        r0 = null;
        goto L6
    }
}
