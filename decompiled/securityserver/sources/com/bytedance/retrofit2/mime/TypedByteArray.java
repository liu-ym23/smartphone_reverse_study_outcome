package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TypedByteArray extends AbsTypedOutput implements TypedInput {
    private byte[] bytes;
    private final String fakeFileName;
    private final String mimeType;

    public TypedByteArray(String r2, byte[] r3, String... r4) {
        if (r4 != null) goto L5;
    L7:
        String r5 = null;
    L8:
        if (r2 == null) goto L10;
    L13:
        if (r3 == null) goto L17;
        this.mimeType = r2;
        this.bytes = r3;
        this.fakeFileName = r5;
        return;
    L17:
        throw new NullPointerException("bytes null");
    L10:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r2 = "application/unknown";
        goto L13
    L12:
        r2 = "application/octet-stream";
        goto L13
    L5:
        if (r4.length <= 0) goto L7;
        r5 = r4[0];
        goto L8
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public TTRequestCompressManager.CompressData compressRequestBody(String r3, String r4, boolean r5) {
        byte[] r0 = this.bytes;
        if (r0 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.CompressData r6 = TTRequestCompressManager.compressBody(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.data == null) goto L12;
        this.mOriginBodySize = this.bytes.length;
        this.bytes = r6.data;
        this.mType = r6.contentEncoding;
        goto L12
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        TypedByteArray r6 = (TypedByteArray) r5;
        if (Arrays.equals(this.bytes, r6.bytes) == true) goto L14;
        return false;
    L14:
        if (this.mimeType.equals(r6.mimeType) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        if (TextUtils.isEmpty(this.fakeFileName) == false) goto L7;
        return null;
    L7:
        return this.fakeFileName;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public byte[] getOriginBody() {
        return TTRequestCompressManager.decompressDataByType(this.bytes, this.mType, this.mOriginBodySize);
    }

    public int hashCode() {
        int r0 = this.mimeType.hashCode() * 31;
        return Arrays.hashCode(this.bytes) + r0;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public boolean interceptRequestBody() {
        byte[] r0 = this.bytes;
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.encrypt(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        this.bytes = r1;
        this.mIsBodyEncrypted = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.bytes.length;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        byte[] r0 = this.bytes;
        if (r0 != null) goto L6;
        return null;
    L6:
        this.mBodyMd5Stub = DigestUtil.md5Hex(r0);
        return this.mBodyMd5Stub;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.mimeType;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        r1.write(this.bytes);
    }
}
