package com.bytedance.sdk.account.monitor.f;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5680c;

    public f(String r2, String r3) {
        o.g(r2, "key");
        o.g(r3, "value");
        super(null);
        this.f5679b = r2;
        this.f5680c = r3;
    }

    @Override // com.bytedance.sdk.account.monitor.f.g
    public boolean a(JSONObject r2) {
        o.g(r2, "params");
        return o.a(String.valueOf(r2.opt(this.f5679b)), this.f5680c);
    }
}
