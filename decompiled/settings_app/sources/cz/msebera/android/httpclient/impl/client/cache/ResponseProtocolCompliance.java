package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
class ResponseProtocolCompliance {
    private static final String UNEXPECTED_100_CONTINUE = "The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.";
    private static final String UNEXPECTED_PARTIAL_CONTENT = "partial content was returned for a request that did not ask for it";

    ResponseProtocolCompliance() {
    }

    public void ensureProtocolCompliance(HttpRequestWrapper r2, HttpResponse r3) throws IOException {
        if (backendResponseMustNotHaveBody(r2, r3) == false) goto L5;
        consumeBody(r3);
        r3.setEntity(null);
    L5:
        requestDidNotExpect100ContinueButResponseIsOne(r2, r3);
        transferEncodingIsNotReturnedTo1_0Client(r2, r3);
        ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(r2, r3);
        ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(r2, r3);
        ensure206ContainsDateHeader(r3);
        ensure304DoesNotContainExtraEntityHeaders(r3);
        identityIsNotUsedInContentEncoding(r3);
        warningsWithNonMatchingWarnDatesAreRemoved(r3);
    }

    private void consumeBody(HttpResponse r1) throws IOException {
        HttpEntity r0 = r1.getEntity();
        if (r0 == null) goto L6;
        IOUtils.consume(r0);
        return;
    }

    private void warningsWithNonMatchingWarnDatesAreRemoved(HttpResponse r13) {
        Date r12 = DateUtils.parseDate(r13.getFirstHeader("Date").getValue());
        if (r12 != null) goto L5;
        return;
    L5:
        Header[] r1 = r13.getHeaders("Warning");
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.length == 0) goto L35;
        ArrayList r2 = new ArrayList();
        int r3 = r1.length;
        int r5 = 0;
        boolean r6 = false;
    L11:
        if (r5 >= r3) goto L23;
        WarningValue[] r7 = WarningValue.getWarningValues(r1[r5]);
        int r8 = r7.length;
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L22;
        WarningValue r10 = r7[r9];
        Date r11 = r10.getWarnDate();
        if (r11 != null) goto L17;
    L20:
        r2.add(new BasicHeader("Warning", r10.toString()));
    L21:
        r9 = r9 + 1;
        goto L13
    L17:
        if (r11.equals(r12) == true) goto L20;
        r6 = true;
        goto L21
    L22:
        r5 = r5 + 1;
        goto L11
    L23:
        if (r6 == false) goto L34;
        r13.removeHeaders("Warning");
        Iterator r14 = r2.iterator();
    L26:
        if (r14.hasNext() == false) goto L36;
        r13.addHeader((Header) r14.next());
        goto L26
    L36:
        return;
    L34:
        return;
    }

    private void identityIsNotUsedInContentEncoding(HttpResponse r17) {
        Header[] r2 = r17.getHeaders("Content-Encoding");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.length == 0) goto L36;
        ArrayList r3 = new ArrayList();
        int r4 = r2.length;
        int r6 = 0;
        boolean r7 = false;
    L8:
        if (r6 >= r4) goto L22;
        Header r8 = r2[r6];
        StringBuilder r9 = new StringBuilder();
        HeaderElement[] r10 = r8.getElements();
        int r11 = r10.length;
        boolean r13 = true;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L18;
        HeaderElement r14 = r10[r12];
        if ("identity".equalsIgnoreCase(r14.getName()) == false) goto L14;
        r7 = true;
    L17:
        r12 = r12 + 1;
        goto L10
    L14:
        if (r13 == true) goto L16;
        r9.append(",");
    L16:
        r9.append(r14.toString());
        r13 = false;
        goto L17
    L18:
        String r5 = r9.toString();
        if ("".equals(r5) == true) goto L21;
        r3.add(new BasicHeader("Content-Encoding", r5));
    L21:
        r6 = r6 + 1;
        goto L8
    L22:
        if (r7 == true) goto L24;
        return;
    L24:
        r17.removeHeaders("Content-Encoding");
        Iterator r1 = r3.iterator();
    L26:
        if (r1.hasNext() == false) goto L37;
        r17.addHeader((Header) r1.next());
        goto L26
    L37:
        return;
    }

    private void ensure206ContainsDateHeader(HttpResponse r2) {
        if (r2.getFirstHeader("Date") != null) goto L6;
        r2.addHeader("Date", DateUtils.formatDate(new Date()));
        return;
    }

    private void ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(HttpRequest r2, HttpResponse r3) throws IOException {
        if (r2.getFirstHeader("Range") == null) goto L5;
        return;
    L5:
        if (r3.getStatusLine().getStatusCode() != 206) goto L10;
        consumeBody(r3);
        throw new ClientProtocolException(UNEXPECTED_PARTIAL_CONTENT);
    }

    private void ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(HttpRequest r1, HttpResponse r2) {
        if (r1.getRequestLine().getMethod().equalsIgnoreCase("OPTIONS") == true) goto L6;
        return;
    L6:
        if (r2.getStatusLine().getStatusCode() == 200) goto L9;
        return;
    L9:
        if (r2.getFirstHeader("Content-Length") != null) goto L12;
        r2.addHeader("Content-Length", "0");
        return;
    }

    private void ensure304DoesNotContainExtraEntityHeaders(HttpResponse r9) {
        String[] r8 = {"Allow", "Content-Encoding", "Content-Language", "Content-Length", "Content-MD5", "Content-Range", "Content-Type", "Last-Modified"};
        if (r9.getStatusLine().getStatusCode() != 304) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= 8) goto L10;
        r9.removeHeaders(r8[r0]);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    private boolean backendResponseMustNotHaveBody(HttpRequest r1, HttpResponse r2) {
        if ("HEAD".equals(r1.getRequestLine().getMethod()) == false) goto L5;
    L12:
        return true;
    L5:
        if (r2.getStatusLine().getStatusCode() == 204) goto L12;
        if (r2.getStatusLine().getStatusCode() == 205) goto L12;
        if (r2.getStatusLine().getStatusCode() == 304) goto L12;
        return false;
    }

    private void requestDidNotExpect100ContinueButResponseIsOne(HttpRequestWrapper r3, HttpResponse r4) throws IOException {
        if (r4.getStatusLine().getStatusCode() == 100) goto L5;
        return;
    L5:
        HttpRequest r5 = r3.getOriginal();
        if ((r5 instanceof HttpEntityEnclosingRequest) == true) goto L8;
    L10:
        consumeBody(r4);
        throw new ClientProtocolException(UNEXPECTED_100_CONTINUE);
    L8:
        if (((HttpEntityEnclosingRequest) r5).expectContinue() == false) goto L10;
    }

    private void transferEncodingIsNotReturnedTo1_0Client(HttpRequestWrapper r2, HttpResponse r3) {
        if (r2.getOriginal().getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) < 0) goto L5;
        return;
    L5:
        removeResponseTransferEncoding(r3);
    }

    private void removeResponseTransferEncoding(HttpResponse r1) {
        r1.removeHeaders("TE");
        r1.removeHeaders("Transfer-Encoding");
    }
}
