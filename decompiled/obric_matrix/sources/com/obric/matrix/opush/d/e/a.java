package com.obric.matrix.opush.d.e;

import com.obric.matrix.opush.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/opush/base/host/HostAppManagerService;", "Lcom/obric/matrix/opush/base/host/IHostAppManagerService;", "()V", "isHostAppHasToken", "", "pkgName", "", "onHostAppInstall", "", "sdkVersionName", "sdkVersionCode", "", "onHostAppUninstall", "onHostAppUpgrade", "packageName", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {
    public a() {
    }

    @Override // com.obric.matrix.opush.d.e.b
    public void a(String r3, String r4, int r5) {
        o.f(r3, "pkgName");
        o.f(r4, "sdkVersionName");
        c.f9247a.a("onHostAppInstall: pkgName is " + r3 + " sdkVersionName is " + r4 + " sdkVersionCode is " + r5 + " , try updateDeviceInfo");
    }

    @Override // com.obric.matrix.opush.d.e.b
    public void b(String r3) {
        o.f(r3, "packageName");
        c.f9247a.a("onHostAppUpgrade: pkgName is " + r3);
    }

    @Override // com.obric.matrix.opush.d.e.b
    public boolean c(String r1) {
        o.f(r1, "pkgName");
        return com.obric.matrix.opush.d.b.f9251a.u().c(r1);
    }

    @Override // com.obric.matrix.opush.d.e.b
    public void d(String r3) {
        o.f(r3, "pkgName");
        c.f9247a.a("onHostAppUninstall: pkgName is " + r3);
        com.obric.matrix.opush.d.b.f9251a.u().b(r3);
    }
}
