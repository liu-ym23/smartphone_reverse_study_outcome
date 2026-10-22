package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Deprecated
    public InputStreamBody(InputStream r1, String r2, String r3) {
        this(r1, ContentType.create(r2), r3);
    }

    public InputStreamBody(InputStream r2, String r3) {
        this(r2, ContentType.DEFAULT_BINARY, r3);
    }

    public InputStreamBody(InputStream r1, ContentType r2, String r3) {
        super(r2);
        Args.notNull(r1, "Input stream");
        this.in = r1;
        this.filename = r3;
    }

    public InputStreamBody(InputStream r2, ContentType r3) {
        this(r2, r3, null);
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L10
    L4:
        int r1 = this.in.read(r0);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L7;
        r4.write(r0, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L7:
        r4.flush();     // Catch: Throwable -> L10
        this.in.close();
        return;
    L10:
        th = move-exception;
        this.in.close();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }
}
