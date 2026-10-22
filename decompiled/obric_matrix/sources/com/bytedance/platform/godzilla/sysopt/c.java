package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.DvmOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5340a;

    public c() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "DvmOptimizerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5340a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        Application r0 = this.f5340a;
        if (r0 == null) goto L6;
        DvmOptimizer.optDvmLinearAllocBuffer(r0);
        return;
    }
}
