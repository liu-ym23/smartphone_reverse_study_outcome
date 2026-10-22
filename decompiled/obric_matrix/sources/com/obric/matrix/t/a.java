package com.obric.matrix.t;

import android.util.Log;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/launch/BdInstallUtils;", "", "()V", "BDINSTALL_INSTALL_EVENT_TIMEOUT", "", "BDINSTALL_INSTALL_EVENT_TIMEOUT_SECOND", "TAG", "", "tryReInstallIfNeed", "", LocationMonitorConst.TAG, "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10032a = null;

    /* JADX INFO: renamed from: com.obric.matrix.t.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/launch/BdInstallUtils$tryReInstallIfNeed$1", "Lcom/bytedance/bdinstall/OnResetListener;", "onDidUpdate", "", "installInfo", "Lcom/bytedance/bdinstall/InstallInfo;", "onTimeout", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0285a implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10033a;

        C0285a(String r1) {
            this.f10033a = r1;
        }

        @Override // com.bytedance.bdinstall.n0
        public void a() {
            c.b("BdInstallUtils", "bdinstall on update did timeout in " + this.f10033a);
        }

        @Override // com.bytedance.bdinstall.n0
        public void b(h0 r3) {
            c.b("BdInstallUtils", "bdinstall onDid update in " + this.f10033a + " installinfo " + r3 + ' ');
        }
    }

    static {
        f10032a = new a();
    }

    private a() {
    }

    public final void a(String r6) {
        o.f(r6, LocationMonitorConst.TAG);
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L19
        r0.append("tryReInstallIfNeed deviceID ");     // Catch: Exception -> L19
        h0 r1 = i.l();     // Catch: Exception -> L19
        String r2 = null;
        if (r1 == null) goto L6;
        String r3 = r1.c();     // Catch: Exception -> L19
    L7:
        r0.append(r3);     // Catch: Exception -> L19
        c.b("BdInstallUtils", r0.toString());     // Catch: Exception -> L19
        h0 r4 = i.l();     // Catch: Exception -> L19
        if (r4 == null) goto L10;
        r2 = r4.c();     // Catch: Exception -> L19
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L24;
        c.b("BdInstallUtils", "try ReInstall start tag " + r6 + " ENV " + i.i().a());     // Catch: Exception -> L19
        i.s(com.bytedance.mpaas.app.a.a(), i.i(), BDLocationConfig.sScanBleMaxInterval, new C0285a(r6));     // Catch: Exception -> L19
        return;
    L24:
        return;
    L12:
        if (r2.length() == 0) goto L15;
        r5 = false;
        goto L16
    L6:
        r3 = null;
    L19:
        e = move-exception;
        c.b("BdInstallUtils", "reset and install in " + r6 + ", exception " + Log.getStackTraceString(e) + ' ');
    }
}
