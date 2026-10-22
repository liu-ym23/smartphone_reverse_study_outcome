package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.MIME;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public class StringBody extends AbstractContentBody {
    private final byte[] content;

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    @Deprecated
    public static StringBody create(String r2, String r3, Charset r4) throws IllegalArgumentException {
        return new StringBody(r2, r3, r4);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Charset " + r4 + " is not supported", e);
    }

    @Deprecated
    public static StringBody create(String r1, Charset r2) throws IllegalArgumentException {
        return create(r1, null, r2);
    }

    @Deprecated
    public static StringBody create(String r1) throws IllegalArgumentException {
        return create(r1, null, null);
    }

    @Deprecated
    public StringBody(String r1, String r2, Charset r3) throws UnsupportedEncodingException {
        if (r3 != null) goto L5;
        r3 = Consts.ASCII;
    L5:
        this(r1, ContentType.create(r2, r3));
    }

    @Deprecated
    public StringBody(String r2, Charset r3) throws UnsupportedEncodingException {
        this(r2, "text/plain", r3);
    }

    @Deprecated
    public StringBody(String r3) throws UnsupportedEncodingException {
        this(r3, "text/plain", Consts.ASCII);
    }

    public StringBody(String r2, ContentType r3) {
        super(r3);
        Args.notNull(r2, "Text");
        Charset r4 = r3.getCharset();
        if (r4 != null) goto L6;
        r4 = Consts.ASCII;
    L6:
        this.content = r2.getBytes(r4);
    }

    public Reader getReader() {
        Charset r0 = getContentType().getCharset();
        ByteArrayInputStream r2 = new ByteArrayInputStream(this.content);
        if (r0 != null) goto L7;
        r0 = Consts.ASCII;
    L7:
        return new InputStreamReader(r2, r0);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        ByteArrayInputStream r0 = new ByteArrayInputStream(this.content);
        byte[] r3 = new byte[4096];
    L3:
        int r1 = r0.read(r3);
        if (r1 == (-1)) goto L6;
        r4.write(r3, 0, r1);
        goto L3
    L6:
        r4.flush();
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }
}
