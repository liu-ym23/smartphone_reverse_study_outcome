package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3240h;

    public f(int r1) {
        this.f3240h = r1;
    }

    public /* synthetic */ f(int r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r2) {
        o.g(r2, "queryBuilder");
        int r1 = this.f3240h;
        if (r1 == 0) goto L5;
        com.bytedance.bdturing.x.e.b(r2, "challenge_code", r1);
    L5:
        com.bytedance.bdturing.x.e.b(r2, "use_dialog_size_v2", com.bytedance.bdturing.v.h.f3217l.s());
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        return "verify";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 2;
    }
}
