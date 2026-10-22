package com.loopj.android.http;

import android.text.TextUtils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
class SimpleMultipartEntity implements HttpEntity {
    private static final byte[] CR_LF = null;
    private static final String LOG_TAG = "SimpleMultipartEntity";
    private static final char[] MULTIPART_CHARS = null;
    private static final String STR_CR_LF = "\r\n";
    private static final byte[] TRANSFER_ENCODING_BINARY = null;
    private final String boundary;
    private final byte[] boundaryEnd;
    private final byte[] boundaryLine;
    private long bytesWritten;
    private final List<FilePart> fileParts;
    private boolean isRepeatable;
    private final ByteArrayOutputStream out;
    private final ResponseHandlerInterface progressHandler;
    private long totalSize;

    private class FilePart {
        public final File file;
        public final byte[] header;
        final /* synthetic */ SimpleMultipartEntity this$0;

        public FilePart(SimpleMultipartEntity r1, String r2, File r3, String r4, String r5) {
            this.this$0 = r1;
            if (TextUtils.isEmpty(r5) == false) goto L5;
            r5 = r3.getName();
        L5:
            this.header = createHeader(r2, r5, r4);
            this.file = r3;
        }

        public FilePart(SimpleMultipartEntity r1, String r2, File r3, String r4) {
            this.this$0 = r1;
            this.header = createHeader(r2, r3.getName(), r4);
            this.file = r3;
        }

        private byte[] createHeader(String r3, String r4, String r5) {
            ByteArrayOutputStream r0 = new ByteArrayOutputStream();
            r0.write(SimpleMultipartEntity.access$000(this.this$0));     // Catch: IOException -> L5
            r0.write(SimpleMultipartEntity.access$100(this.this$0, r3, r4));     // Catch: IOException -> L5
            r0.write(SimpleMultipartEntity.access$200(this.this$0, r5));     // Catch: IOException -> L5
            r0.write(SimpleMultipartEntity.access$300());     // Catch: IOException -> L5
            r0.write(SimpleMultipartEntity.access$400());     // Catch: IOException -> L5
        L8:
            return r0.toByteArray();
        L5:
            e = move-exception;
            AsyncHttpClient.log.e(SimpleMultipartEntity.LOG_TAG, "createHeader ByteArrayOutputStream exception", e);
            goto L8
        }

        public long getTotalLength() {
            long r0 = this.file.length() + ((long) SimpleMultipartEntity.access$400().length);
            return ((long) this.header.length) + r0;
        }

        public void writeTo(OutputStream r7) throws IOException {
            r7.write(this.header);
            SimpleMultipartEntity.access$500(this.this$0, this.header.length);
            FileInputStream r0 = new FileInputStream(this.file);
            byte[] r1 = new byte[4096];
        L3:
            int r2 = r0.read(r1);
            if (r2 == (-1)) goto L6;
            r7.write(r1, 0, r2);
            SimpleMultipartEntity.access$500(this.this$0, r2);
            goto L3
        L6:
            r7.write(SimpleMultipartEntity.access$400());
            SimpleMultipartEntity.access$500(this.this$0, SimpleMultipartEntity.access$400().length);
            r7.flush();
            AsyncHttpClient.silentCloseInputStream(r0);
        }
    }

    private String normalizeContentType(String r1) {
        if (r1 != null) goto L5;
        return "application/octet-stream";
    L5:
        return r1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    static /* synthetic */ byte[] access$000(SimpleMultipartEntity r0) {
        return r0.boundaryLine;
    }

    static /* synthetic */ byte[] access$100(SimpleMultipartEntity r0, String r1, String r2) {
        return r0.createContentDisposition(r1, r2);
    }

    static /* synthetic */ byte[] access$200(SimpleMultipartEntity r0, String r1) {
        return r0.createContentType(r1);
    }

    static /* synthetic */ byte[] access$300() {
        return TRANSFER_ENCODING_BINARY;
    }

    static /* synthetic */ byte[] access$400() {
        return CR_LF;
    }

    static /* synthetic */ void access$500(SimpleMultipartEntity r0, long r1) {
        r0.updateProgress(r1);
    }

    static {
        CR_LF = "\r\n".getBytes();
        TRANSFER_ENCODING_BINARY = "Content-Transfer-Encoding: binary\r\n".getBytes();
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public SimpleMultipartEntity(ResponseHandlerInterface r6) {
        this.fileParts = new ArrayList();
        this.out = new ByteArrayOutputStream();
        StringBuilder r0 = new StringBuilder();
        Random r1 = new Random();
        int r2 = 0;
    L4:
        if (r2 >= 30) goto L6;
        char[] r3 = MULTIPART_CHARS;
        r0.append(r3[r1.nextInt(r3.length)]);
        r2 = r2 + 1;
        goto L4
    L6:
        String r4 = r0.toString();
        this.boundary = r4;
        this.boundaryLine = ("--" + r4 + "\r\n").getBytes();
        this.boundaryEnd = ("--" + r4 + "--\r\n").getBytes();
        this.progressHandler = r6;
    }

    public void addPart(String r3, String r4, String r5) {
        this.out.write(this.boundaryLine);     // Catch: IOException -> L4
        this.out.write(createContentDisposition(r3));     // Catch: IOException -> L4
        this.out.write(createContentType(r5));     // Catch: IOException -> L4
        ByteArrayOutputStream r6 = this.out;     // Catch: IOException -> L4
        byte[] r7 = CR_LF;     // Catch: IOException -> L4
        r6.write(r7);     // Catch: IOException -> L4
        this.out.write(r4.getBytes());     // Catch: IOException -> L4
        this.out.write(r7);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "addPart ByteArrayOutputStream exception", e);
    }

    public void addPartWithCharset(String r3, String r4, String r5) {
        if (r5 != null) goto L4;
        r5 = "UTF-8";
    L4:
        addPart(r3, r4, "text/plain; charset=" + r5);
    }

    public void addPart(String r2, String r3) {
        addPartWithCharset(r2, r3, null);
    }

    public void addPart(String r2, File r3) {
        addPart(r2, r3, null);
    }

    public void addPart(String r3, File r4, String r5) {
        this.fileParts.add(new FilePart(this, r3, r4, normalizeContentType(r5)));
    }

    public void addPart(String r9, File r10, String r11, String r12) {
        this.fileParts.add(new FilePart(this, r9, r10, normalizeContentType(r11), r12));
    }

    public void addPart(String r3, String r4, InputStream r5, String r6) throws IOException {
        this.out.write(this.boundaryLine);
        this.out.write(createContentDisposition(r3, r4));
        this.out.write(createContentType(r6));
        this.out.write(TRANSFER_ENCODING_BINARY);
        this.out.write(CR_LF);
        byte[] r7 = new byte[4096];
    L3:
        int r8 = r5.read(r7);
        if (r8 == (-1)) goto L6;
        this.out.write(r7, 0, r8);
        goto L3
    L6:
        this.out.write(CR_LF);
        this.out.flush();
    }

    private byte[] createContentType(String r3) {
        return ("Content-Type: " + normalizeContentType(r3) + "\r\n").getBytes();
    }

    private byte[] createContentDisposition(String r2) {
        return ("Content-Disposition: form-data; name=\"" + r2 + "\"\r\n").getBytes();
    }

    private byte[] createContentDisposition(String r2, String r3) {
        return ("Content-Disposition: form-data; name=\"" + r2 + "\"; filename=\"" + r3 + "\"\r\n").getBytes();
    }

    private void updateProgress(long r5) {
        long r0 = this.bytesWritten + r5;
        this.bytesWritten = r0;
        this.progressHandler.sendProgressMessage(r0, this.totalSize);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        long r0 = this.out.size();
        Iterator<FilePart> r2 = this.fileParts.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        long r3 = r2.next().getTotalLength();
        if (r3 < 0) goto L7;
        r0 = r0 + r3;
        goto L4
    L7:
        return -1;
    L11:
        return r0 + ((long) this.boundaryEnd.length);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }

    public void setIsRepeatable(boolean r1) {
        this.isRepeatable = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return this.isRepeatable;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r3) throws IOException {
        this.bytesWritten = 0;
        this.totalSize = (int) getContentLength();
        this.out.writeTo(r3);
        updateProgress(this.out.size());
        Iterator<FilePart> r0 = this.fileParts.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().writeTo(r3);
        goto L4
    L6:
        r3.write(this.boundaryEnd);
        updateProgress(this.boundaryEnd.length);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }
}
