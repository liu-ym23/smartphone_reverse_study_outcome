package com.bytedance.retrofit2.mime;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface TypedOutput {
    String fileName();

    long length();

    String md5Stub();

    String mimeType();

    void writeTo(OutputStream r1);
}
