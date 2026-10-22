package com.bytedance.retrofit2.mime;

import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FormUrlEncodedTypedOutput extends AbsTypedOutput {
    ByteArrayOutputStream content;
    private final boolean enableRecordFields;
    private final Map<String, List<String>> fields;

    public FormUrlEncodedTypedOutput() {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = false;
    }

    public void addField(String r2, String r3) {
        addField(r2, true, r3, true);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public TTRequestCompressManager.CompressData compressRequestBody(String r3, String r4, boolean r5) {
        byte[] r0 = this.content.toByteArray();
        if (r0 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.CompressData r6 = TTRequestCompressManager.compressBody(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.data == null) goto L12;
        this.mOriginBodySize = r0.length;
        ByteArrayOutputStream r7 = new ByteArrayOutputStream(r6.data.length);
        this.content = r7;
        byte[] r8 = r6.data;
        r7.write(r8, 0, r8.length);
        this.mType = r6.contentEncoding;
        goto L12
    }

    public Map<String, List<String>> fields() {
        return this.fields;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public byte[] getOriginBody() {
        return TTRequestCompressManager.decompressDataByType(this.content.toByteArray(), this.mType, this.mOriginBodySize);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public boolean interceptRequestBody() {
        byte[] r0 = this.content.toByteArray();
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.encrypt(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1.length);
        this.content = r2;
        r2.write(r1, 0, r1.length);
        this.mIsBodyEncrypted = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        this.mBodyMd5Stub = DigestUtil.md5Hex(this.content.toByteArray());
        return this.mBodyMd5Stub;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        r1.write(this.content.toByteArray());
    }

    public void addField(String r3, boolean r4, String r5, boolean r6) {
        if (r3 == null) goto L27;
        if (r5 == null) goto L25;
        if (this.content.size() <= 0) goto L8;
        this.content.write(38);
    L8:
        if (this.enableRecordFields == false) goto L14;
        if (this.fields.containsKey(r3) == false) goto L12;
        this.fields.get(r3).add(r5);
        goto L14
    L12:
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        this.fields.put(r3, r0);
    L14:
        if (r4 == true) goto L28;
    L18:
        if (r6 == false) goto L20;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: IOException -> L16
    L20:
        this.content.write(r3.getBytes("UTF-8"));     // Catch: IOException -> L16
        this.content.write(61);     // Catch: IOException -> L16
        this.content.write(r5.getBytes("UTF-8"));     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L28:
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: IOException -> L16
        goto L18
    L25:
        throw new NullPointerException("value");
    L27:
        throw new NullPointerException("name");
    }

    public FormUrlEncodedTypedOutput(boolean r2) {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = r2;
    }
}
