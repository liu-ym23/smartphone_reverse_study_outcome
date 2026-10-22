package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class RequestEntityProxy implements HttpEntity {
    private boolean consumed;
    private final HttpEntity original;

    static void enhance(HttpEntityEnclosingRequest r2) {
        HttpEntity r0 = r2.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRepeatable() == false) goto L7;
        return;
    L7:
        if (isEnhanced(r0) == true) goto L12;
        r2.setEntity(new RequestEntityProxy(r0));
        return;
    }

    static boolean isEnhanced(HttpEntity r0) {
        return r0 instanceof RequestEntityProxy;
    }

    static boolean isRepeatable(HttpRequest r2) {
        if ((r2 instanceof HttpEntityEnclosingRequest) == false) goto L13;
        HttpEntity r3 = ((HttpEntityEnclosingRequest) r2).getEntity();
        if (r3 == null) goto L13;
        if (isEnhanced(r3) == false) goto L12;
        if (((RequestEntityProxy) r3).isConsumed() == true) goto L12;
        return true;
    L12:
        return r3.isRepeatable();
    L13:
        return true;
    }

    RequestEntityProxy(HttpEntity r2) {
        this.consumed = false;
        this.original = r2;
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return this.original.isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return this.original.isChunked();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.original.getContentLength();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return this.original.getContentType();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.original.getContentEncoding();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        return this.original.getContent();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        this.consumed = true;
        this.original.writeTo(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return this.original.isStreaming();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws IOException {
        this.consumed = true;
        this.original.consumeContent();
    }

    public String toString() {
        return "RequestEntityProxy{" + this.original + '}';
    }
}
