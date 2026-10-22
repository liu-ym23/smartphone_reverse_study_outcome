package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class DecompressingEntity extends HttpEntityWrapper {
    private static final int BUFFER_SIZE = 2048;
    private InputStream content;
    private final InputStreamFactory inputStreamFactory;

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1;
    }

    public DecompressingEntity(HttpEntity r1, InputStreamFactory r2) {
        super(r1);
        this.inputStreamFactory = r2;
    }

    private InputStream getDecompressingStream() throws IOException {
        return new LazyDecompressingInputStream(this.wrappedEntity.getContent(), this.inputStreamFactory);
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        if (this.wrappedEntity.isStreaming() == false) goto L10;
        if (this.content != null) goto L8;
        this.content = getDecompressingStream();
    L8:
        return this.content;
    L10:
        return getDecompressingStream();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        InputStream r3 = getContent();
        byte[] r0 = new byte[2048];     // Catch: Throwable -> L10
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
}
