package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h extends a<Long> {
    public h(String r2, long r3, kotlin.n0.c.a<? extends JSONObject> r5) {
        o.g(r2, "settingKey");
        o.g(r5, "configProvider");
        super(r2, Long.valueOf(r3), r5);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.p1.a
    public /* bridge */ /* synthetic */ Long c(JSONObject r3, String r4, Long r5) {
        return d(r3, r4, r5.longValue());
    }

    public Long d(JSONObject r1, String r2, long r3) {
        o.g(r2, "key");
        if (r1 == null) goto L6;
        r3 = r1.optLong(r2, r3);
    L6:
        return Long.valueOf(r3);
    }
}
