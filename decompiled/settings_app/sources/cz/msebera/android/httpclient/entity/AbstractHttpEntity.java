package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    @Override // cz.msebera.android.httpclient.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
    }

    protected AbstractHttpEntity() {
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setContentType(Header r1) {
        this.contentType = r1;
    }

    public void setContentType(String r3) {
        if (r3 == null) goto L4;
        BasicHeader r0 = new BasicHeader("Content-Type", r3);
    L5:
        setContentType(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void setContentEncoding(Header r1) {
        this.contentEncoding = r1;
    }

    public void setContentEncoding(String r3) {
        if (r3 == null) goto L4;
        BasicHeader r0 = new BasicHeader("Content-Encoding", r3);
    L5:
        setContentEncoding(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void setChunked(boolean r1) {
        this.chunked = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        if (this.contentType == null) goto L6;
        r0.append("Content-Type: ");
        r0.append(this.contentType.getValue());
        r0.append(',');
    L6:
        if (this.contentEncoding == null) goto L8;
        r0.append("Content-Encoding: ");
        r0.append(this.contentEncoding.getValue());
        r0.append(',');
    L8:
        long r3 = getContentLength();
        if (r3 < 0) goto L11;
        r0.append("Content-Length: ");
        r0.append(r3);
        r0.append(',');
    L11:
        r0.append("Chunked: ");
        r0.append(this.chunked);
        r0.append(']');
        return r0.toString();
    }
}
