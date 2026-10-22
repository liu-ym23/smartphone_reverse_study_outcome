package com.bytedance.badger.h;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {
    public c(g r2, String r3, boolean r4) {
        o.g(r3, "key");
        super(r2, r3, Boolean.valueOf(r4));
    }

    @Override // com.bytedance.badger.h.b
    public Object b(JSONObject r1, String r2, Object r3) {
        boolean r0 = ((Boolean) r3).booleanValue();
        o.g(r1, "$this$optValue");
        o.g(r2, "key");
        return Boolean.valueOf(r1.optBoolean(r2, r0));
    }
}
