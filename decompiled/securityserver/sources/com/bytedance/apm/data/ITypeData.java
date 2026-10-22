package com.bytedance.apm.data;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ITypeData {
    String getSubTypeLabel();

    String getTypeLabel();

    boolean isSampled(@Nullable JSONObject r1);

    boolean isSaveImmediately();

    boolean isUploadImmediately();

    @Nullable
    JSONObject packLog();

    boolean supportFetch();
}
