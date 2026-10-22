package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a<Integer> {
    public g(String r2, int r3, kotlin.n0.c.a<? extends JSONObject> r4) {
        o.g(r2, "settingKey");
        o.g(r4, "configProvider");
        super(r2, Integer.valueOf(r3), r4);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.p1.a
    public /* bridge */ /* synthetic */ Integer c(JSONObject r1, String r2, Integer r3) {
        return d(r1, r2, r3.intValue());
    }

    public Integer d(JSONObject r1, String r2, int r3) {
        o.g(r2, "key");
        if (r1 == null) goto L6;
        r3 = r1.optInt(r2, r3);
    L6:
        return Integer.valueOf(r3);
    }
}
