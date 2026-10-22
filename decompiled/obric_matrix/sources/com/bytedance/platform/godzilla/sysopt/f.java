package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.MTK_PVR_Optimizer;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class f extends d.b.p.a.g.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5343b;

    public f(boolean r2) {
        this.f5343b = false;
        this.f5343b = r2;
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "MTK_PVR_OptimizerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5342a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        MTK_PVR_Optimizer.setAlwaysCatchSIGSEGV(this.f5343b);
        MTK_PVR_Optimizer.enable(this.f5342a);
    }

    @Override // d.b.p.a.g.f
    public void g() {
        SysOptimizer.hookOptimizerEnable();
    }
}
