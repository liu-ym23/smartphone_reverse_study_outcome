package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    public BufferedHttpEntity(HttpEntity r5) throws IOException {
        super(r5);
        if (r5.isRepeatable() == true) goto L5;
    L8:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r5.writeTo(r0);
        r0.flush();
        this.buffer = r0.toByteArray();
        return;
    L5:
        if (r5.getContentLength() < 0) goto L8;
        this.buffer = null;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        byte[] r0 = this.buffer;
        if (r0 == null) goto L6;
        return r0.length;
    L6:
        return super.getContentLength();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        if (this.buffer == null) goto L6;
        return new ByteArrayInputStream(this.buffer);
    L6:
        return super.getContent();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        if (this.buffer == null) goto L5;
    L7:
        return false;
    L5:
        if (super.isChunked() == false) goto L7;
        return true;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        Args.notNull(r2, "Output stream");
        byte[] r0 = this.buffer;
        if (r0 == null) goto L5;
        r2.write(r0);
        return;
    L5:
        super.writeTo(r2);
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        if (this.buffer == null) goto L5;
    L7:
        return false;
    L5:
        if (super.isStreaming() == false) goto L7;
        return true;
    }
}
