package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
final class j<T> extends e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.n0.c.a<T> f1022a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlin.n0.c.a<? extends T> r2) {
        o.g(r2, "getter");
        super(null);
        this.f1022a = r2;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.p1.e
    public T a() {
        return this.f1022a.invoke();
    }
}
