package com.bytedance.android.sdk.bdticketguard;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends j0<s> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m0 f720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<v0> f721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f722f;

    public f0(s r8, String r9, String r10, m0 r11, List<v0> r12, String r13, String r14) {
        kotlin.n0.d.o.g(r8, "handleProviderResponseParam");
        kotlin.n0.d.o.g(r9, "logid");
        kotlin.n0.d.o.g(r10, "serverDataStr");
        super(r8, r9, 0, 4, null);
        this.f719c = r10;
        this.f720d = r11;
        this.f721e = r12;
        this.f722f = r14;
    }

    public final String c() {
        return this.f722f;
    }

    public final String d() {
        return this.f719c;
    }

    public final List<v0> e() {
        return this.f721e;
    }
}
