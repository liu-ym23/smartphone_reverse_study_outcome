package com.bytedance.framwork.core.sdkmonitor;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    @Nullable
    public static JSONObject a(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }
}
