package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes5.dex */
public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public StringEntity(String r2, ContentType r3) throws UnsupportedCharsetException {
        Args.notNull(r2, "Source string");
        if (r3 == null) goto L5;
        Charset r0 = r3.getCharset();
    L6:
        if (r0 != null) goto L8;
        r0 = HTTP.DEF_CONTENT_CHARSET;
    L8:
        this.content = r2.getBytes(r0);
        if (r3 == null) goto L12;
        setContentType(r3.toString());
        return;
    L12:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Deprecated
    public StringEntity(String r2, String r3, String r4) throws UnsupportedEncodingException {
        Args.notNull(r2, "Source string");
        if (r3 != null) goto L6;
        r3 = "text/plain";
    L6:
        if (r4 != null) goto L9;
        r4 = "ISO-8859-1";
    L9:
        this.content = r2.getBytes(r4);
        setContentType(r3 + "; charset=" + r4);
    }

    public StringEntity(String r2, String r3) throws UnsupportedCharsetException {
        this(r2, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), r3));
    }

    public StringEntity(String r2, Charset r3) {
        this(r2, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), r3));
    }

    public StringEntity(String r2) throws UnsupportedEncodingException {
        this(r2, ContentType.DEFAULT_TEXT);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.content.length;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        Args.notNull(r2, "Output stream");
        r2.write(this.content);
        r2.flush();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
