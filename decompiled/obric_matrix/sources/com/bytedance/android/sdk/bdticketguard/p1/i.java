package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a<String> {
    public i(String r2, String r3, kotlin.n0.c.a<? extends JSONObject> r4) {
        o.g(r2, "settingKey");
        o.g(r3, "defaultValue");
        o.g(r4, "configProvider");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.p1.a
    public /* bridge */ /* synthetic */ String c(JSONObject r1, String r2, String r3) {
        return d(r1, r2, r3);
    }

    public String d(JSONObject r1, String r2, String r3) {
        o.g(r2, "key");
        o.g(r3, "defaultValue");
        if (r1 == null) goto L8;
        String r0 = r1.optString(r2, r3);
        if (r0 != null) goto L7;
        return r3;
    L7:
        return r0;
    L8:
        return r3;
    }
}
