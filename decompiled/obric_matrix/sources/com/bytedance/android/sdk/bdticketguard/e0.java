package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f712f;

    public e0(String r9, String r10, boolean r11, boolean r12, boolean r13) {
        kotlin.n0.d.o.g(r9, "host");
        kotlin.n0.d.o.g(r10, "path");
        super(r9, r10, 0, 4, null);
        this.f710d = r11;
        this.f711e = r12;
        this.f712f = r13;
    }

    public final boolean d() {
        return this.f711e;
    }

    public final boolean e() {
        return this.f710d;
    }

    public final boolean f() {
        return this.f712f;
    }
}
