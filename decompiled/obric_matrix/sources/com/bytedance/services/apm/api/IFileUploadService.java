package com.bytedance.services.apm.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IFileUploadService {
    void uploadFiles(@NonNull String r1, @NonNull String r2, @NonNull String r3, @NonNull List<String> r4, @NonNull String r5, @Nullable JSONObject r6, @Nullable IFileUploadCallback r7);
}
