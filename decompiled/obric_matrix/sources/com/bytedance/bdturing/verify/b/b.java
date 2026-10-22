package com.bytedance.bdturing.verify.b;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3233i;

    public b(String r1, String r2) {
        this.f3232h = r1;
        this.f3233i = r2;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r4) {
        o.g(r4, "queryBuilder");
        com.bytedance.bdturing.x.e.c(r4, "decision_config", "block-sms");
        com.bytedance.bdturing.x.e.b(r4, "is_turing", 1);
        if (TextUtils.isEmpty(this.f3232h) == true) goto L6;
        com.bytedance.bdturing.x.e.c(r4, "verify_ticket", this.f3232h);
    L6:
        if (TextUtils.isEmpty(this.f3233i) == true) goto L8;
        com.bytedance.bdturing.x.e.c(r4, "show_mobile", this.f3233i);
    L8:
        com.bytedance.bdturing.x.e.b(r4, "use_turing_bridge", 1);
        com.bytedance.bdturing.b r3 = com.bytedance.bdturing.b.f();
        o.b(r3, "BdTuring.getInstance()");
        BdTuringConfig r5 = r3.e();
        if (r5 == null) goto L11;
        int r6 = r5.getSmsDigits();
    L12:
        com.bytedance.bdturing.x.e.b(r4, "use_sms_mode", r6);
        return;
    L11:
        r6 = 0;
        goto L12
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
        return 7;
    }
}
