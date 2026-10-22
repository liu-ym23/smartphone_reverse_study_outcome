package com.bytedance.android.sdk.bdticketguard;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a1 {
    public static final /* synthetic */ JSONObject a(kotlin.u... r0) {
        return b(r0);
    }

    private static final JSONObject b(kotlin.u<String, ? extends Object>... r5) {
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        kotlin.u<String, ? extends Object> r3 = r5[r2];
        r0.put(r3.a(), r3.b());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
