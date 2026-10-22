package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes5.dex */
class SizeLimitedResponseReader {
    private boolean consumed;
    private InputStream inStream;
    private InputLimit limit;
    private final long maxResponseSizeBytes;
    private final HttpRequest request;
    private Resource resource;
    private final ResourceFactory resourceFactory;
    private final CloseableHttpResponse response;

    static /* synthetic */ CloseableHttpResponse access$000(SizeLimitedResponseReader r0) {
        return r0.response;
    }

    public SizeLimitedResponseReader(ResourceFactory r1, long r2, HttpRequest r4, CloseableHttpResponse r5) {
        this.resourceFactory = r1;
        this.maxResponseSizeBytes = r2;
        this.request = r4;
        this.response = r5;
    }

    protected void readResponse() throws IOException {
        if (this.consumed == true) goto L6;
        doConsume();
        return;
    }

    private void ensureNotConsumed() {
        if (this.consumed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Response has already been consumed");
    }

    private void ensureConsumed() {
        if (this.consumed == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Response has not been consumed");
    }

    private void doConsume() throws IOException {
        ensureNotConsumed();
        this.consumed = true;
        this.limit = new InputLimit(this.maxResponseSizeBytes);
        HttpEntity r0 = this.response.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = this.request.getRequestLine().getUri();
        InputStream r2 = r0.getContent();
        this.inStream = r2;
        this.resource = this.resourceFactory.generate(r1, r2, this.limit);     // Catch: Throwable -> L11
        if (this.limit.isReached() == true) goto L18;
        this.inStream.close();
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (this.limit.isReached() == true) goto L15;
        this.inStream.close();
    L15:
        throw th;
    }

    boolean isLimitReached() {
        ensureConsumed();
        return this.limit.isReached();
    }

    Resource getResource() {
        ensureConsumed();
        return this.resource;
    }

    CloseableHttpResponse getReconstructedResponse() throws IOException {
        ensureConsumed();
        final BasicHttpResponse r0 = new BasicHttpResponse(this.response.getStatusLine());
        r0.setHeaders(this.response.getAllHeaders());
        CombinedEntity r1 = new CombinedEntity(this.resource, this.inStream);
        HttpEntity r2 = this.response.getEntity();
        if (r2 == null) goto L5;
        r1.setContentType(r2.getContentType());
        r1.setContentEncoding(r2.getContentEncoding());
        r1.setChunked(r2.isChunked());
    L5:
        r0.setEntity(r1);
        return (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new AnonymousClass1(this, r0));
    }
}
