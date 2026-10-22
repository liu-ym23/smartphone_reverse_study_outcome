package com.bytedance.sdk.account.monitor.f;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f5681b;

    public h(g r2) {
        o.g(r2, "condition");
        super(null);
        this.f5681b = r2;
    }

    @Override // com.bytedance.sdk.account.monitor.f.g
    public boolean a(JSONObject r2) {
        o.g(r2, "params");
        return !this.f5681b.a(r2);
    }
}
