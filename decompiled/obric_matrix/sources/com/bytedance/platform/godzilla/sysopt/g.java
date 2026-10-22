package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.sysoptimizer.fake.name.SmFakeNameHandler;

/* JADX INFO: loaded from: classes.dex */
public class g extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5344a;

    public g() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "SmFakeNameHandlerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f5344a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        Application r0 = this.f5344a;
        if (r0 == null) goto L6;
        SmFakeNameHandler.start(r0);
        return;
    }
}
