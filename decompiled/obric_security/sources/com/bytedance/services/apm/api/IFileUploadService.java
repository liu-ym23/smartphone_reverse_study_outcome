package com.bytedance.services.apm.api;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IFileUploadService {
    void uploadFiles(String r1, String r2, String r3, List<String> r4, String r5, JSONObject r6, IFileUploadCallback r7);
}
