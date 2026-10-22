package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f3235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f3236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f3237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f3238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f3239l;
    private final boolean m;

    public e(String r2, String r3, String r4, String r5, String r6, boolean r7) {
        o.g(r2, "scene");
        o.g(r3, "flow");
        o.g(r4, "source");
        o.g(r5, "detail");
        o.g(r6, "ticket");
        this.f3235h = r2;
        this.f3236i = r3;
        this.f3237j = r4;
        this.f3238k = r5;
        this.f3239l = r6;
        this.m = r7;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r3) {
        o.g(r3, "queryBuilder");
        kotlin.u0.k.f(r3);
        r3.append(com.bytedance.bdturing.v.h.f3217l.j(i(), "report_url"));
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        return "verify_identity";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 14;
    }

    public final String q() {
        return this.f3238k;
    }

    public final String r() {
        return this.f3236i;
    }

    public final String s() {
        return this.f3235h;
    }

    public final boolean t() {
        return this.m;
    }

    public final String u() {
        return this.f3237j;
    }

    public final String v() {
        return this.f3239l;
    }
}
