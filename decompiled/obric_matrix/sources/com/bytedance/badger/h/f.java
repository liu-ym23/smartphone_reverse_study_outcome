package com.bytedance.badger.h;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.n0.d.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends b {
    public f(g r2, String r3, Collection r4) {
        o.g(r3, "key");
        o.g(r4, "defaultValue");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.badger.h.b
    public Object b(JSONObject r2, String r3, Object r4) {
        Collection r5 = (Collection) r4;
        o.g(r2, "$this$optValue");
        o.g(r3, "key");
        o.g(r5, "defaultValue");
        JSONArray r1 = r2.optJSONArray(r3);
        if (r1 == null) goto L7;
        LinkedHashSet r6 = new LinkedHashSet();
        int r7 = 0;
        int r8 = r1.length();
    L5:
        if (r7 >= r8) goto L8;
        r6.add(r1.optString(r7));
        r7 = r7 + 1;
    L8:
        return r6;
    L7:
        r6 = new LinkedHashSet(r5);
        goto L8
    }
}
