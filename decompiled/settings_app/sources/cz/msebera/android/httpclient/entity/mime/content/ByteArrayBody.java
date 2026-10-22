package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    @Override // cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody, cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Deprecated
    public ByteArrayBody(byte[] r1, String r2, String r3) {
        this(r1, ContentType.create(r2), r3);
    }

    public ByteArrayBody(byte[] r1, ContentType r2, String r3) {
        super(r2);
        Args.notNull(r1, "byte[]");
        this.data = r1;
        this.filename = r3;
    }

    public ByteArrayBody(byte[] r2, String r3) {
        this(r2, "application/octet-stream", r3);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream r1) throws IOException {
        r1.write(this.data);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.data.length;
    }
}
