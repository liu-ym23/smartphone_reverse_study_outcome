package com.bytedance.badger.h;

import java.util.concurrent.TimeUnit;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeUnit f2585d;

    public d(g r2, String r3, long r4, TimeUnit r6) {
        o.g(r3, "key");
        o.g(r6, "timeUnit");
        super(r2, r3, new h(r4, r6));
        this.f2585d = r6;
    }

    @Override // com.bytedance.badger.h.b
    public Object b(JSONObject r4, String r5, Object r6) {
        h r7 = (h) r6;
        o.g(r4, "$this$optValue");
        o.g(r5, "key");
        o.g(r7, "defaultValue");
        return new h(r4.optLong(r5, r7.b()), this.f2585d);
    }
}
