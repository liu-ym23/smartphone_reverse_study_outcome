package com.bytedance.applog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface f {
    void a(@NonNull String r1, @NonNull String r2, String r3, long r4, long r6, String r8);

    void onEventV3(@NonNull String r1, @Nullable JSONObject r2);
}
