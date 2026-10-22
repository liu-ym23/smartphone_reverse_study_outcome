package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.impl.io.EmptyInputStream;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    public BasicHttpEntity() {
        this.length = -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IllegalStateException {
        if (this.content == null) goto L5;
        boolean r0 = true;
    L6:
        Asserts.check(r0, "Content has not been provided");
        return this.content;
    L5:
        r0 = false;
        goto L6
    }

    public void setContentLength(long r1) {
        this.length = r1;
    }

    public void setContent(InputStream r1) {
        this.content = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        InputStream r3 = getContent();
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L10
    L4:
        int r1 = r3.read(r0);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L8;
        r4.write(r0, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L8:
        r3.close();
        return;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        InputStream r1 = this.content;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1 == EmptyInputStream.INSTANCE) goto L7;
        return true;
    }
}
