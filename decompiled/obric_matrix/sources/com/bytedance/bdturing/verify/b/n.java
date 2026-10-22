package com.bytedance.bdturing.verify.b;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class n extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3254h;

    public n(String r2) {
        o.g(r2, "verifyTicket");
        this.f3254h = r2;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r3) {
        o.g(r3, "queryBuilder");
        com.bytedance.bdturing.x.e.c(r3, "decision_config", "mobile_voice_sms_verify");
        if (TextUtils.isEmpty(this.f3254h) == true) goto L5;
        com.bytedance.bdturing.x.e.c(r3, "verify_ticket", this.f3254h);
    L5:
        com.bytedance.bdturing.x.e.b(r3, "use_turing_bridge", 1);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        return "twice_verify";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 13;
    }
}
