package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class h extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3242h;

    public h(String r1) {
        this.f3242h = r1;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r3) {
        o.g(r3, "queryBuilder");
        com.bytedance.bdturing.x.e.b(r3, "isPop", !d() ? 1 : 0);
        com.bytedance.bdturing.x.e.c(r3, "uid", this.f3242h);
        com.bytedance.bdturing.x.e.b(r3, "use_dialog_size_v2", com.bytedance.bdturing.v.h.f3217l.s());
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        return "qa";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 3;
    }
}
