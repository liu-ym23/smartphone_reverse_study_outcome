package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class m extends a {
    public m() {
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r2) {
        o.g(r2, "queryBuilder");
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
        return 12;
    }
}
