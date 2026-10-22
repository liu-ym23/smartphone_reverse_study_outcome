package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    public d(String r1, String r2) {
    }

    public /* synthetic */ d(String r2, String r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r1) {
        o.g(r1, "queryBuilder");
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
        return 4;
    }
}
