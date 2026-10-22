package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.f.k;
import d.b.u.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class h extends f {
    public h(String r1, c r2, k r3, l<Handler> r4, f.b r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.bytedance.sync.v2.compensate.f
    public void b() {
        super.b();
        d.b.u.x.b.a(this.f5905d + "cancelSync");
    }

    @Override // com.bytedance.sync.v2.compensate.f
    protected void d() {
        d.b.u.x.b.a(this.f5905d + "start send Sync");
        this.f5904c.P();
    }

    @Override // com.bytedance.sync.v2.compensate.f
    public int f() {
        return 1;
    }

    @Override // com.bytedance.sync.v2.compensate.f
    protected boolean g(com.bytedance.sync.v2.j.e r1) {
        if (r1 == null) goto L8;
        List<com.bytedance.sync.v2.j.f> r0 = r1.f6071g;
        if (r0 == null) goto L8;
        if (r0.isEmpty() == true) goto L8;
        return true;
    L8:
        return false;
    }
}
