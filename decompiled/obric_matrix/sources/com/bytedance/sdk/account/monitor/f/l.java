package com.bytedance.sdk.account.monitor.f;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5687b;

    public l(String r2) {
        o.g(r2, "key");
        super(null);
        this.f5687b = r2;
    }

    @Override // com.bytedance.sdk.account.monitor.f.g
    public boolean a(JSONObject r2) {
        o.g(r2, "params");
        return !b(r2.opt(this.f5687b));
    }
}
