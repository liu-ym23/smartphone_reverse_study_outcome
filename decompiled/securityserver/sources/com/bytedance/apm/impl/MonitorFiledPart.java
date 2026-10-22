package com.bytedance.apm.impl;

import androidx.annotation.Nullable;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class MonitorFiledPart implements TypedOutput {
    private final TypedFile file;
    private final Map<String, String> params;

    public MonitorFiledPart(@Nullable Map<String, String> r1, TypedFile r2) {
        this.params = r1;
        this.file = r2;
    }

    private String buildFileName() {
        StringBuilder r0 = new StringBuilder(this.file.fileName());
        r0.append("\"");
        Iterator<Map.Entry<String, String>> r5 = this.params.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r5.next();
        String r3 = r2.getKey();
        String r4 = r2.getValue();
        r0.append("; ");
        r0.append(r3);
        r0.append("=\"");
        r0.append(r4);
        r0.append("\"");
        goto L4
    L6:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return buildFileName();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.file.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return this.file.md5Stub();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.file.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        this.file.writeTo(r1);
    }
}
