package com.obric.matrix.push.m.f;

import com.obric.matrix.push.n.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/push/base/host/HostAppManagerService;", "Lcom/obric/matrix/push/base/host/IHostAppManagerService;", "()V", "isHostAppHasToken", "", "pkgName", "", "onHostAppInstall", "", "sdkVersionName", "sdkVersionCode", "", "onHostAppUninstall", "onHostAppUpgrade", "packageName", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {
    public a() {
    }

    @Override // com.obric.matrix.push.m.f.b
    public void a(String r9, String r10, int r11) {
        o.f(r9, "pkgName");
        o.f(r10, "sdkVersionName");
        c.a("onHostAppInstall: pkgName is " + r9 + " sdkVersionName is " + r10 + " sdkVersionCode is " + r11 + " , try updateDeviceInfo");
        com.obric.matrix.push.m.l.a.C0273a.a(com.obric.matrix.push.m.b.f9633a.A(), r9, r10, Integer.valueOf(r11), com.obric.matrix.push.p.b.h0.Y(), null, 16, null);
    }

    @Override // com.obric.matrix.push.m.f.b
    public void b(String r9) {
        o.f(r9, "packageName");
        c.a("onHostAppUpgrade: pkgName is " + r9);
        com.obric.matrix.push.m.l.a.C0273a.a(com.obric.matrix.push.m.b.f9633a.A(), r9, null, null, com.obric.matrix.push.p.b.h0.b0(), null, 22, null);
    }

    @Override // com.obric.matrix.push.m.f.b
    public boolean c(String r1) {
        o.f(r1, "pkgName");
        return com.obric.matrix.push.m.b.f9633a.B().c(r1);
    }

    @Override // com.obric.matrix.push.m.f.b
    public void d(String r10) {
        o.f(r10, "pkgName");
        c.a("onHostAppUninstall: pkgName is " + r10);
        com.obric.matrix.push.m.b r9 = com.obric.matrix.push.m.b.f9633a;
        r9.B().b(r10);
        com.obric.matrix.push.m.l.a.C0273a.a(r9.A(), r10, null, null, com.obric.matrix.push.p.b.h0.a0(), null, 22, null);
    }
}
