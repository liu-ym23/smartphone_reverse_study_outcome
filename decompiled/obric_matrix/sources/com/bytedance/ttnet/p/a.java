package com.bytedance.ttnet.p;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.o.b.z.l;
import d.b.r.y;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class a extends i.a {
    public a() {
    }

    private int i(d.b.r.h0.c r3) {
        List<d.b.r.h0.b> r2 = r3.H("x-tt-request-tag");
        if (r2 != null) goto L5;
    L9:
        String r4 = "";
    L11:
        return l.m().d(r3.G(), r4);
    L5:
        if (r2.size() < 1) goto L9;
        if (TextUtils.isEmpty(r2.get(0).b()) == true) goto L9;
        r4 = r2.get(0).b();
        goto L11
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r9, y r10) {
        long r5 = i(r9);
        Logger.debug();
        this.f6557a.h(r9, true, false, r5, r10);
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r10, y r11, Executor r12, Runnable r13) {
        long r4 = i(r10);
        Logger.debug();
        return this.f6557a.g(r10, true, r4, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void f() {
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void g() {
    }

    @Override // com.bytedance.ttnet.p.i.a
    i.b h() {
        return i.b.f6561g;
    }
}
