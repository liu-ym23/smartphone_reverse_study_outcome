package com.bytedance.apm.b0;

import com.bytedance.services.apm.api.IFileUploadService;

/* JADX INFO: loaded from: classes.dex */
public class a implements IFileUploadService {
    public static void a(String r2) {
        String r0 = "https://" + r2 + "/monitor/collect/c/code_coverage";
    }

    public static void b(String r2) {
        String r0 = "https://" + r2 + "/monitor/collect/c/logcollect";
    }
}
