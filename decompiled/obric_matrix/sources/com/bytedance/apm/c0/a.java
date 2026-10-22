package com.bytedance.apm.c0;

import com.bytedance.apm.a0.c;
import com.bytedance.apm.d0.b;
import com.bytedance.apm.internal.ApmDelegate;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public a() {
    }

    @Override // com.bytedance.apm.d0.b
    public boolean a(String r1, String r2) {
        return c.a().c(r1, r2);
    }

    @Override // com.bytedance.apm.d0.b
    public boolean b(String r1) {
        return ApmDelegate.k().m(r1);
    }

    @Override // com.bytedance.apm.d0.b
    public boolean c(String r1) {
        return c.a().d(r1);
    }

    @Override // com.bytedance.apm.d0.b
    public boolean d(String r1) {
        return c.a().b(r1);
    }

    @Override // com.bytedance.apm.d0.b
    public boolean getLogTypeSwitch(String r1) {
        return ApmDelegate.k().l(r1);
    }

    @Override // com.bytedance.apm.d0.b
    public boolean getServiceSwitch(String r1) {
        return ApmDelegate.k().n(r1);
    }
}
