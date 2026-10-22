package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.ArtOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5338a;

    public a() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "ArtOptimizerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5338a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        Application r0 = this.f5338a;
        if (r0 == null) goto L6;
        ArtOptimizer.optSuspendTimeout(r0);
        return;
    }
}
