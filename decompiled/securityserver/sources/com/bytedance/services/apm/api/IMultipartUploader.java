package com.bytedance.services.apm.api;

import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IMultipartUploader {
    void addFilePart(String r1, File r2, String r3, Map<String, String> r4);

    void addFilePart(String r1, String r2, String r3, Map<String, String> r4);

    void addFormField(String r1, String r2);

    HttpResponse finish();
}
