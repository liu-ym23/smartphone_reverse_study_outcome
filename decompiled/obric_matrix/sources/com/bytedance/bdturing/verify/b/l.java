package com.bytedance.bdturing.verify.b;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class l extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f3253j;

    public l(String r2, String r3, String r4) {
        o.g(r2, "verifyTicket");
        o.g(r3, "channelMobile");
        o.g(r4, "smsContent");
        this.f3251h = r2;
        this.f3252i = r3;
        this.f3253j = r4;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r4) {
        o.g(r4, "queryBuilder");
        com.bytedance.bdturing.x.e.c(r4, "decision_config", "block-upsms");
        com.bytedance.bdturing.x.e.b(r4, "is_turing", 1);
        if (TextUtils.isEmpty(this.f3251h) == true) goto L5;
        com.bytedance.bdturing.x.e.c(r4, "verify_ticket", this.f3251h);
    L5:
        com.bytedance.bdturing.x.e.c(r4, "channel_mobile", this.f3252i);
        com.bytedance.bdturing.x.e.c(r4, "sms_content", this.f3253j);
        com.bytedance.bdturing.x.e.b(r4, "use_turing_bridge", 1);
        com.bytedance.bdturing.b r3 = com.bytedance.bdturing.b.f();
        o.b(r3, "BdTuring.getInstance()");
        BdTuringConfig r5 = r3.e();
        if (r5 == null) goto L8;
        int r6 = r5.getSmsDigits();
    L9:
        com.bytedance.bdturing.x.e.b(r4, "use_sms_mode", r6);
        return;
    L8:
        r6 = 0;
        goto L9
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
        return 6;
    }
}
