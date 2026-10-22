package com.bytedance.retrofit2.mime;

import android.util.Pair;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class FormUrlEncodedTypedOutput extends AbsTypedOutput {
    ByteArrayOutputStream content;
    private final boolean enableRecordFields;
    private final Map<String, List<String>> fields;

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public FormUrlEncodedTypedOutput() {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = false;
    }

    public FormUrlEncodedTypedOutput(boolean r2) {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = r2;
    }

    public void addField(String r2, String r3) {
        addField(r2, true, r3, true);
    }

    public void addField(String r3, boolean r4, String r5, boolean r6) {
        if (r3 == null) goto L26;
        if (r5 == null) goto L24;
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
        if (r4 == true) goto L27;
    L16:
        if (r6 == false) goto L18;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: IOException -> L20
    L18:
        this.content.write(r3.getBytes("UTF-8"));     // Catch: IOException -> L20
        this.content.write(61);     // Catch: IOException -> L20
        this.content.write(r5.getBytes("UTF-8"));     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L27:
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: IOException -> L20
        goto L16
    L24:
        throw new NullPointerException("value");
    L26:
        throw new NullPointerException("name");
    }

    public Map<String, List<String>> fields() {
        return this.fields;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) throws IOException {
        r1.write(this.content.toByteArray());
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        this.mBodyMd5Stub = DigestUtil.md5Hex(this.content.toByteArray());
        return this.mBodyMd5Stub;
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

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public String compressRequestBody(String r4, String r5, boolean r6) {
        byte[] r0 = this.content.toByteArray();
        if (r0 != null) goto L5;
        return null;
    L5:
        Pair<byte[], String> r7 = TTRequestCompressManager.compressBody(r0, r0.length, r4, r5, r6);
        if (r7 != null) goto L8;
    L12:
        return null;
    L8:
        if (r7.first == null) goto L12;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(((byte[]) r7.first).length);
        this.content = r8;
        r8.write((byte[]) r7.first, 0, ((byte[]) r7.first).length);
        this.mType = (String) r7.second;
        return this.mType;
    }
}
