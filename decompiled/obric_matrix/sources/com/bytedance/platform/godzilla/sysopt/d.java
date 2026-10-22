package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.HighLevelTrimMemory;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class d extends d.b.p.a.g.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5341a;

    public d() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "HighLevelTrimMemoryPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5341a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        HighLevelTrimMemory.optimize(this.f5341a);
    }

    @Override // d.b.p.a.g.f
    public void g() {
        SysOptimizer.hookOptimizerEnable();
    }
}
