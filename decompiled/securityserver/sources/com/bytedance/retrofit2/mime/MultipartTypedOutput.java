package com.bytedance.retrofit2.mime;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class MultipartTypedOutput implements TypedOutput {
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private final String boundary;
    private final byte[] footer;
    private long length;
    private final List<MimePart> mimeParts;

    public static final class MimePart {
        private final TypedOutput body;
        private final String boundary;
        private boolean isBuilt;
        private final boolean isFirst;
        private final String name;
        private byte[] partBoundary;
        private byte[] partHeader;
        private final String transferEncoding;

        public MimePart(String r1, String r2, TypedOutput r3, String r4, boolean r5) {
            this.name = r1;
            this.transferEncoding = r2;
            this.body = r3;
            this.isFirst = r5;
            this.boundary = r4;
        }

        private void build() {
            if (this.isBuilt == false) goto L5;
            return;
        L5:
            this.partBoundary = MultipartTypedOutput.access$000(this.boundary, this.isFirst, false);
            this.partHeader = MultipartTypedOutput.access$100(this.name, this.transferEncoding, this.body);
            this.isBuilt = true;
        }

        public long size() {
            build();
            if (this.body.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.body.length() + ((long) this.partBoundary.length)) + ((long) this.partHeader.length);
        }

        public void writeTo(OutputStream r2) {
            build();
            r2.write(this.partBoundary);
            r2.write(this.partHeader);
            this.body.writeTo(r2);
        }
    }

    public MultipartTypedOutput() {
        this(UUID.randomUUID().toString());
    }

    public static /* synthetic */ byte[] access$000(String r0, boolean r1, boolean r2) {
        return buildBoundary(r0, r1, r2);
    }

    public static /* synthetic */ byte[] access$100(String r0, String r1, TypedOutput r2) {
        return buildHeader(r0, r1, r2);
    }

    private static byte[] buildBoundary(String r3, boolean r4, boolean r5) {
        StringBuilder r1 = new StringBuilder(r3.length() + 8);     // Catch: IOException -> L7
        if (r4 == true) goto L9;
        r1.append("\r\n");     // Catch: IOException -> L7
    L9:
        r1.append("--");     // Catch: IOException -> L7
        r1.append(r3);     // Catch: IOException -> L7
        if (r5 == false) goto L12;
        r1.append("--");     // Catch: IOException -> L7
    L12:
        r1.append("\r\n");     // Catch: IOException -> L7
        return r1.toString().getBytes("UTF-8");
    L7:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] buildHeader(String r5, String r6, TypedOutput r7) {
        StringBuilder r0 = new StringBuilder(128);     // Catch: IOException -> L5
        r0.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L5
        r0.append(r5);     // Catch: IOException -> L5
        String r8 = r7.fileName();     // Catch: IOException -> L5
        if (r8 == null) goto L7;
        r0.append("\"; filename=\"");     // Catch: IOException -> L5
        r0.append(r8);     // Catch: IOException -> L5
    L7:
        r0.append("\"\r\nContent-Type: ");     // Catch: IOException -> L5
        r0.append(r7.mimeType());     // Catch: IOException -> L5
        long r1 = r7.length();     // Catch: IOException -> L5
        if (r1 == (-1)) goto L10;
        r0.append("\r\nContent-Length: ");     // Catch: IOException -> L5
        r0.append(r1);     // Catch: IOException -> L5
    L10:
        r0.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L5
        r0.append(r6);     // Catch: IOException -> L5
        r0.append("\r\n\r\n");     // Catch: IOException -> L5
        return r0.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    public void addPart(String r2, TypedOutput r3) {
        addPart(r2, DEFAULT_TRANSFER_ENCODING, r3);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public int getPartCount() {
        return this.mimeParts.size();
    }

    public List<byte[]> getParts() {
        ArrayList r0 = new ArrayList(this.mimeParts.size());
        Iterator<MimePart> r3 = this.mimeParts.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        MimePart r1 = r3.next();
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r1.writeTo(r2);
        r0.add(r2.toByteArray());
        goto L4
    L6:
        return r0;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        if (this.length != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        writeTo(r0);     // Catch: Throwable -> L11
        ByteArrayInputStream r4 = new ByteArrayInputStream(r0.toByteArray());     // Catch: Throwable -> L11
        String r1 = DigestUtil.md5Hex(r4);     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L18
    L27:
        r4.close();     // Catch: Throwable -> L19
    L10:
        return r1;
    L13:
        if (r0 != null) goto L35;
    L15:
        if (r4 != null) goto L25;
    L17:
        return null;
    L25:
        r4.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r0.close();     // Catch: Throwable -> L21
    L11:
        r4 = null;
    L12:
        r4 = null;
        r0 = null;
        goto L13
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "multipart/form-data; boundary=" + this.boundary;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r3) {
        Iterator<MimePart> r0 = this.mimeParts.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().writeTo(r3);
        goto L4
    L6:
        r3.write(this.footer);
    }

    public MultipartTypedOutput(String r3) {
        this.mimeParts = new LinkedList();
        this.boundary = r3;
        byte[] r4 = buildBoundary(r3, false, true);
        this.footer = r4;
        this.length = r4.length;
    }

    public void addPart(String r8, String r9, TypedOutput r10) {
        if (r8 == null) goto L17;
        if (r9 == null) goto L15;
        if (r10 == null) goto L13;
        MimePart r6 = new MimePart(r8, r9, r10, this.boundary, this.mimeParts.isEmpty());
        this.mimeParts.add(r6);
        long r11 = r6.size();
        if (r11 != (-1)) goto L8;
        this.length = -1;
        return;
    L8:
        long r2 = this.length;
        if (r2 == (-1)) goto L19;
        this.length = r2 + r11;
        return;
    L19:
        return;
    L13:
        throw new NullPointerException("Part body must not be null.");
    L15:
        throw new NullPointerException("Transfer encoding must not be null.");
    L17:
        throw new NullPointerException("Part name must not be null.");
    }
}
