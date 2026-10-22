package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
    private final byte[] b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public ByteArrayEntity(byte[] r2, ContentType r3) {
        Args.notNull(r2, "Source byte array");
        this.content = r2;
        this.b = r2;
        this.off = 0;
        this.len = r2.length;
        if (r3 == null) goto L6;
        setContentType(r3.toString());
        return;
    }

    public ByteArrayEntity(byte[] r3, int r4, int r5, ContentType r6) {
        Args.notNull(r3, "Source byte array");
        if (r4 < 0) goto L16;
        if (r4 > r3.length) goto L16;
        if (r5 < 0) goto L16;
        int r0 = r4 + r5;
        if (r0 < 0) goto L16;
        if (r0 > r3.length) goto L16;
        this.content = r3;
        this.b = r3;
        this.off = r4;
        this.len = r5;
        if (r6 == null) goto L17;
        setContentType(r6.toString());
        return;
    L17:
        return;
    L16:
        throw new IndexOutOfBoundsException("off: " + r4 + " len: " + r5 + " b.length: " + r3.length);
    }

    public ByteArrayEntity(byte[] r2) {
        this(r2, null);
    }

    public ByteArrayEntity(byte[] r2, int r3, int r4) {
        this(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.b, this.off, this.len);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r3) throws IOException {
        Args.notNull(r3, "Output stream");
        r3.write(this.b, this.off, this.len);
        r3.flush();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
