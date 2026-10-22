package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    public InputStreamEntity(InputStream r3) {
        this(r3, -1);
    }

    public InputStreamEntity(InputStream r2, long r3) {
        this(r2, r3, null);
    }

    public InputStreamEntity(InputStream r3, ContentType r4) {
        this(r3, -1, r4);
    }

    public InputStreamEntity(InputStream r2, long r3, ContentType r5) {
        this.content = (InputStream) Args.notNull(r2, "Source input stream");
        this.length = r3;
        if (r5 == null) goto L6;
        setContentType(r5.toString());
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r11) throws IOException {
        Args.notNull(r11, "Output stream");
        InputStream r0 = this.content;
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L17
        long r2 = this.length;     // Catch: Throwable -> L17
        if (r2 >= 0) goto L9;
    L5:
        int r10 = r0.read(r1);     // Catch: Throwable -> L17
        if (r10 == (-1)) goto L15;
        r11.write(r1, 0, r10);     // Catch: Throwable -> L17
    L15:
        r0.close();
        return;
    L9:
        if (r2 <= 0) goto L15;
        int r12 = r0.read(r1, 0, (int) Math.min(4096, r2));     // Catch: Throwable -> L17
        if (r12 == (-1)) goto L15;
        r11.write(r1, 0, r12);     // Catch: Throwable -> L17
        r2 = r2 - ((long) r12);
    L17:
        th = move-exception;
        r0.close();
        throw th;
    }
}
