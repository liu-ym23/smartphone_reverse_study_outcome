package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.DvmDeadLockOptimizer;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.p.a.g.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5339a;

    public b() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "DvmDeadLockOptimizerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5339a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        DvmDeadLockOptimizer.optimize(this.f5339a);
    }

    @Override // d.b.p.a.g.f
    public void g() {
        SysOptimizer.hookOptimizerEnable();
    }
}
