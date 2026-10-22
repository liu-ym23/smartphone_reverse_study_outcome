package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f3247i;

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
        return this.f3246h;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 5;
    }

    public final JSONObject q() {
        return this.f3247i;
    }
}
