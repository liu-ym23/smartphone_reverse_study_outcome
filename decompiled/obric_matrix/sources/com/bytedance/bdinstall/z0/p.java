package com.bytedance.bdinstall.z0;

import android.content.Context;
import com.bytedance.bdinstall.i0;

/* JADX INFO: loaded from: classes.dex */
public class p extends k {
    public p(Context r1, i0 r2, com.bytedance.bdinstall.r r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.bdinstall.z0.k
    public void B() {
        super.B();
        if (this.f2927f.T() == false) goto L5;
        return;
    L5:
        if (this.f2927f.b() == true) goto L7;
        return;
    L7:
        if (com.bytedance.bdinstall.d1.l.q() == true) goto L9;
    L12:
        com.bytedance.bdinstall.t.f(new j(this.f2927f));
        return;
    L9:
        if (com.bytedance.bdinstall.d1.l.B(this.f2926e) == false) goto L12;
        com.bytedance.bdinstall.q.a("target r, not clean");
    }

    @Override // com.bytedance.bdinstall.z0.k
    protected void u() {
        super.u();
        if (com.bytedance.bdinstall.i.g().b() == false) goto L6;
        com.bytedance.bdinstall.a1.b.l(this.f2926e).k();
        return;
    }
}
