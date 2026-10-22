package com.bytedance.badger.h;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b {
    public e(g r2, String r3, String r4) {
        o.g(r3, "key");
        o.g(r4, "defaultValue");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.badger.h.b
    public Object b(JSONObject r1, String r2, Object r3) {
        String r4 = (String) r3;
        o.g(r1, "$this$optValue");
        o.g(r2, "key");
        o.g(r4, "defaultValue");
        String r0 = r1.optString(r2, r4);
        o.b(r0, "optString(key, defaultValue)");
        return r0;
    }
}
