package com.bytedance.bdturing.verify.b;

import com.bytedance.bdturing.BdTuringConfig;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class k extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f3250j;

    public k(String r1, boolean r2, String r3) {
        this.f3248h = r1;
        this.f3249i = r2;
        this.f3250j = r3;
        m(true);
    }

    public /* synthetic */ k(String r2, boolean r3, String r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r3) {
        o.g(r3, "queryBuilder");
        com.bytedance.bdturing.x.e.c(r3, "scene", this.f3248h);
        com.bytedance.bdturing.x.e.b(r3, "show_success_toast", this.f3249i ? 1 : 0);
        com.bytedance.bdturing.x.e.c(r3, "uid", this.f3250j);
        com.bytedance.bdturing.x.e.b(r3, "use_dialog_size_v2", com.bytedance.bdturing.v.h.f3217l.s());
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        return "sms";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        return 1;
    }
}
