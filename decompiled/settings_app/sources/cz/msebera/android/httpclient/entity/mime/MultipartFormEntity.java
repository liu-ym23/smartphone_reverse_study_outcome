package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.ContentTooLongException;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final cz.msebera.android.httpclient.Header contentType;
    private final AbstractMultipartForm multipart;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() {
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentEncoding() {
        return null;
    }

    MultipartFormEntity(AbstractMultipartForm r2, ContentType r3, long r4) {
        this.multipart = r2;
        this.contentType = new BasicHeader("Content-Type", r3.toString());
        this.contentLength = r4;
    }

    AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        if (this.contentLength == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentType() {
        return this.contentType;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        long r0 = this.contentLength;
        if (r0 < 0) goto L11;
        if (r0 > 25600) goto L9;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        writeTo(r1);
        r1.flush();
        return new ByteArrayInputStream(r1.toByteArray());
    L9:
        throw new ContentTooLongException("Content length is too long: " + this.contentLength);
    L11:
        throw new ContentTooLongException("Content length is unknown");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r1) throws IOException {
        this.multipart.writeTo(r1);
    }
}
