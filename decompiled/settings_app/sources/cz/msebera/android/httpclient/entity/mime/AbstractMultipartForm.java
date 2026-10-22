package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractMultipartForm {
    private static final ByteArrayBuffer CR_LF = null;
    private static final ByteArrayBuffer FIELD_SEP = null;
    private static final ByteArrayBuffer TWO_DASHES = null;
    final String boundary;
    final Charset charset;

    protected abstract void formatMultipartHeader(FormBodyPart r1, OutputStream r2) throws IOException;

    public abstract List<FormBodyPart> getBodyParts();

    private static ByteArrayBuffer encode(Charset r2, String r3) {
        ByteBuffer r4 = r2.encode(CharBuffer.wrap(r3));
        ByteArrayBuffer r5 = new ByteArrayBuffer(r4.remaining());
        r5.append(r4.array(), r4.position(), r4.remaining());
        return r5;
    }

    private static void writeBytes(ByteArrayBuffer r2, OutputStream r3) throws IOException {
        r3.write(r2.buffer(), 0, r2.length());
    }

    private static void writeBytes(String r0, Charset r1, OutputStream r2) throws IOException {
        writeBytes(encode(r1, r0), r2);
    }

    private static void writeBytes(String r1, OutputStream r2) throws IOException {
        writeBytes(encode(MIME.DEFAULT_CHARSET, r1), r2);
    }

    protected static void writeField(MinimalField r1, OutputStream r2) throws IOException {
        writeBytes(r1.getName(), r2);
        writeBytes(FIELD_SEP, r2);
        writeBytes(r1.getBody(), r2);
        writeBytes(CR_LF, r2);
    }

    protected static void writeField(MinimalField r1, Charset r2, OutputStream r3) throws IOException {
        writeBytes(r1.getName(), r2, r3);
        writeBytes(FIELD_SEP, r3);
        writeBytes(r1.getBody(), r2, r3);
        writeBytes(CR_LF, r3);
    }

    static {
        FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
        CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
        TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    }

    public AbstractMultipartForm(Charset r2, String r3) {
        Args.notNull(r3, "Multipart boundary");
        if (r2 != null) goto L6;
        r2 = MIME.DEFAULT_CHARSET;
    L6:
        this.charset = r2;
        this.boundary = r3;
    }

    public AbstractMultipartForm(String r2) {
        this(null, r2);
    }

    void doWriteTo(OutputStream r5, boolean r6) throws IOException {
        ByteArrayBuffer r0 = encode(this.charset, this.boundary);
        Iterator<FormBodyPart> r1 = getBodyParts().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        FormBodyPart r2 = r1.next();
        writeBytes(TWO_DASHES, r5);
        writeBytes(r0, r5);
        ByteArrayBuffer r3 = CR_LF;
        writeBytes(r3, r5);
        formatMultipartHeader(r2, r5);
        writeBytes(r3, r5);
        if (r6 == false) goto L8;
        r2.getBody().writeTo(r5);
    L8:
        writeBytes(r3, r5);
        goto L4
    L9:
        ByteArrayBuffer r4 = TWO_DASHES;
        writeBytes(r4, r5);
        writeBytes(r0, r5);
        writeBytes(r4, r5);
        writeBytes(CR_LF, r5);
    }

    public void writeTo(OutputStream r2) throws IOException {
        doWriteTo(r2, true);
    }

    public long getTotalLength() {
        Iterator<FormBodyPart> r0 = getBodyParts().iterator();
        long r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        long r8 = r0.next().getBody().getContentLength();
        if (r8 < 0) goto L8;
        r3 = r3 + r8;
        goto L4
    L8:
        return -1;
    L9:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        doWriteTo(r1, false);     // Catch: IOException -> L13
        return r3 + ((long) r1.toByteArray().length);
    L13:
        return -1;
    }
}
