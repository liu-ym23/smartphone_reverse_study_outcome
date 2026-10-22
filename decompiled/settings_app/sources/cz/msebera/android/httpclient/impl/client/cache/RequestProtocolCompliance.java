package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class RequestProtocolCompliance {
    private static final List<String> disallowedWithNoCache = null;
    private final boolean weakETagOnPutDeleteAllowed;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError = null;

        static {
            int[] r0 = new int[RequestProtocolError.values().length];
            $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError = r0;
            r0[RequestProtocolError.BODY_BUT_NO_LENGTH_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError[RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError[RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError[RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public RequestProtocolCompliance() {
        this.weakETagOnPutDeleteAllowed = false;
    }

    public RequestProtocolCompliance(boolean r1) {
        this.weakETagOnPutDeleteAllowed = r1;
    }

    static {
        disallowedWithNoCache = Arrays.asList(new String[]{HeaderConstants.CACHE_CONTROL_MIN_FRESH, HeaderConstants.CACHE_CONTROL_MAX_STALE, "max-age"});
    }

    public List<RequestProtocolError> requestIsFatallyNonCompliant(HttpRequest r3) {
        ArrayList r0 = new ArrayList();
        RequestProtocolError r1 = requestHasWeakETagAndRange(r3);
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (this.weakETagOnPutDeleteAllowed == true) goto L10;
        RequestProtocolError r2 = requestHasWeekETagForPUTOrDELETEIfMatch(r3);
        if (r2 == null) goto L10;
        r0.add(r2);
    L10:
        RequestProtocolError r4 = requestContainsNoCacheDirectiveWithFieldName(r3);
        if (r4 == null) goto L13;
        r0.add(r4);
    L13:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void makeRequestCompliant(HttpRequestWrapper r3) throws ClientProtocolException {
        if (requestMustNotHaveEntity(r3) == false) goto L5;
        ((HttpEntityEnclosingRequest) r3).setEntity(null);
    L5:
        verifyRequestWithExpectContinueFlagHas100continueHeader(r3);
        verifyOPTIONSRequestWithBodyHasContentType(r3);
        decrementOPTIONSMaxForwardsIfGreaterThen0(r3);
        stripOtherFreshnessDirectivesWithNoCache(r3);
        if (requestVersionIsTooLow(r3) == false) goto L8;
    L9:
        r3.setProtocolVersion(HttpVersion.HTTP_1_1);
        return;
    L8:
        if (requestMinorVersionIsTooHighMajorVersionsMatch(r3) == true) goto L9;
    }

    private void stripOtherFreshnessDirectivesWithNoCache(HttpRequest r14) {
        ArrayList r0 = new ArrayList();
        Header[] r2 = r14.getHeaders("Cache-Control");
        int r3 = r2.length;
        int r5 = 0;
        boolean r6 = false;
    L3:
        if (r5 >= r3) goto L14;
        HeaderElement[] r7 = r2[r5].getElements();
        int r8 = r7.length;
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L13;
        HeaderElement r10 = r7[r9];
        if (disallowedWithNoCache.contains(r10.getName()) == true) goto L10;
        r0.add(r10);
    L10:
        if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(r10.getName()) == false) goto L12;
        r6 = true;
    L12:
        r9 = r9 + 1;
        goto L5
    L13:
        r5 = r5 + 1;
        goto L3
    L14:
        if (r6 == true) goto L16;
        return;
    L16:
        r14.removeHeaders("Cache-Control");
        r14.setHeader("Cache-Control", buildHeaderFromElements(r0));
    }

    private String buildHeaderFromElements(List<HeaderElement> r4) {
        StringBuilder r3 = new StringBuilder("");
        Iterator<HeaderElement> r5 = r4.iterator();
        boolean r0 = true;
    L4:
        if (r5.hasNext() == false) goto L11;
        HeaderElement r1 = r5.next();
        if (r0 == true) goto L8;
        r3.append(",");
    L9:
        r3.append(r1.toString());
        goto L4
    L8:
        r0 = false;
        goto L9
    L11:
        return r3.toString();
    }

    private boolean requestMustNotHaveEntity(HttpRequest r2) {
        if ("TRACE".equals(r2.getRequestLine().getMethod()) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r2 instanceof HttpEntityEnclosingRequest) == false) goto L7;
        return true;
    }

    private void decrementOPTIONSMaxForwardsIfGreaterThen0(HttpRequest r2) {
        if ("OPTIONS".equals(r2.getRequestLine().getMethod()) == true) goto L5;
        return;
    L5:
        Header r0 = r2.getFirstHeader("Max-Forwards");
        if (r0 != null) goto L8;
        return;
    L8:
        r2.removeHeaders("Max-Forwards");
        r2.setHeader("Max-Forwards", Integer.toString(Integer.parseInt(r0.getValue()) - 1));
    }

    private void verifyOPTIONSRequestWithBodyHasContentType(HttpRequest r3) {
        if ("OPTIONS".equals(r3.getRequestLine().getMethod()) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof HttpEntityEnclosingRequest) == true) goto L8;
        return;
    L8:
        addContentTypeHeaderIfMissing((HttpEntityEnclosingRequest) r3);
    }

    private void addContentTypeHeaderIfMissing(HttpEntityEnclosingRequest r3) {
        final HttpEntity r0 = r3.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getContentType() != null) goto L9;
        r3.setEntity(new AnonymousClass1(this, r0));
        return;
    }

    private void verifyRequestWithExpectContinueFlagHas100continueHeader(HttpRequest r3) {
        if ((r3 instanceof HttpEntityEnclosingRequest) == false) goto L10;
        HttpEntityEnclosingRequest r0 = (HttpEntityEnclosingRequest) r3;
        if (r0.expectContinue() == true) goto L7;
    L9:
        remove100ContinueHeaderIfExists(r3);
        return;
    L7:
        if (r0.getEntity() == null) goto L9;
        add100ContinueHeaderIfMissing(r3);
        return;
    L10:
        remove100ContinueHeaderIfExists(r3);
    }

    private void remove100ContinueHeaderIfExists(HttpRequest r14) {
        Header[] r0 = r14.getHeaders("Expect");
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r4 = 0;
        boolean r5 = false;
    L3:
        if (r4 >= r2) goto L18;
        Header r6 = r0[r4];
        HeaderElement[] r7 = r6.getElements();
        int r8 = r7.length;
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L11;
        HeaderElement r10 = r7[r9];
        if ("100-continue".equalsIgnoreCase(r10.getName()) == true) goto L9;
        r1.add(r10);
    L10:
        r9 = r9 + 1;
        goto L5
    L9:
        r5 = true;
        goto L10
    L11:
        if (r5 == true) goto L12;
        r1 = new ArrayList();
        r4 = r4 + 1;
        goto L3
    L12:
        r14.removeHeader(r6);
        Iterator r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r14.addHeader(new BasicHeader("Expect", ((HeaderElement) r3.next()).getName()));
        goto L14
    L16:
        return;
    }

    private void add100ContinueHeaderIfMissing(HttpRequest r11) {
        Header[] r0 = r11.getHeaders("Expect");
        int r1 = r0.length;
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L12;
        HeaderElement[] r6 = r0[r3].getElements();
        int r7 = r6.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L11;
        if ("100-continue".equalsIgnoreCase(r6[r8].getName()) == false) goto L10;
        r4 = true;
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        r3 = r3 + 1;
        goto L4
    L12:
        if (r4 == true) goto L19;
        r11.addHeader("Expect", "100-continue");
        return;
    }

    protected boolean requestMinorVersionIsTooHighMajorVersionsMatch(HttpRequest r3) {
        ProtocolVersion r2 = r3.getProtocolVersion();
        if (r2.getMajor() == HttpVersion.HTTP_1_1.getMajor()) goto L6;
        return false;
    L6:
        if (r2.getMinor() <= HttpVersion.HTTP_1_1.getMinor()) goto L9;
        return true;
    L9:
        return false;
    }

    protected boolean requestVersionIsTooLow(HttpRequest r1) {
        if (r1.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public HttpResponse getErrorForRequest(RequestProtocolError r4) {
        int r3 = AnonymousClass2.$SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError[r4.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L15;
        if (r3 != 4) goto L13;
        return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "No-Cache directive MUST NOT include a field name"));
    L13:
        throw new IllegalStateException("The request was compliant, therefore no error can be generated for it.");
    L15:
        return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with PUT or DELETE requests"));
    L17:
        return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with byte range"));
    L19:
        return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 411, ""));
    }

    private RequestProtocolError requestHasWeakETagAndRange(HttpRequest r2) {
        if ("GET".equals(r2.getRequestLine().getMethod()) == true) goto L6;
        return null;
    L6:
        if (r2.getFirstHeader("Range") != null) goto L8;
        return null;
    L8:
        Header r1 = r2.getFirstHeader("If-Range");
        if (r1 != null) goto L12;
        return null;
    L12:
        if (r1.getValue().startsWith("W/") == true) goto L14;
        return null;
    L14:
        return RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR;
    }

    private RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch(HttpRequest r3) {
        String r2 = r3.getRequestLine().getMethod();
        if ("PUT".equals(r2) == false) goto L5;
    L7:
        Header r4 = r3.getFirstHeader("If-Match");
        if (r4 != null) goto L10;
        Header r5 = r3.getFirstHeader("If-None-Match");
        if (r5 != null) goto L17;
        return null;
    L17:
        if (r5.getValue().startsWith("W/") == true) goto L19;
    L20:
        return null;
    L19:
        return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
    L10:
        if (r4.getValue().startsWith("W/") == false) goto L20;
        return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
    L5:
        if ("DELETE".equals(r2) == true) goto L7;
        return null;
    }

    private RequestProtocolError requestContainsNoCacheDirectiveWithFieldName(HttpRequest r9) {
        Header[] r8 = r9.getHeaders("Cache-Control");
        int r10 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L14;
        HeaderElement[] r2 = r8[r1].getElements();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        HeaderElement r5 = r2[r4];
        if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(r5.getName()) == false) goto L12;
        if (r5.getValue() == null) goto L12;
        return RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME;
    L12:
        r4 = r4 + 1;
        goto L5
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return null;
    }
}
