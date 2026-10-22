package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> extends e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f1013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.n0.c.a<JSONObject> f1014c;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, T r3, kotlin.n0.c.a<? extends JSONObject> r4) {
        o.g(r2, "settingKey");
        o.g(r4, "configProvider");
        super(null);
        this.f1012a = r2;
        this.f1013b = r3;
        this.f1014c = r4;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.p1.e
    public T a() {
        return c(this.f1014c.invoke(), this.f1012a, this.f1013b);
    }

    public abstract T c(JSONObject r1, String r2, T r3);
}
