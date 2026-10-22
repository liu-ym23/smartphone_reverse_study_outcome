package com.obric.matrix.launch.bdtracker;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.obric.matrix.base.env.d;
import com.obric.matrix.r.c.c;
import com.ss.android.init.tasks.BdtrackerInitTaskHook;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import os.teatracker.BdInstallImpl;
import os.teatracker.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/matrix/launch/bdtracker/BDTrackerInitTaskHooker;", "Lcom/ss/android/init/tasks/BdtrackerInitTaskHook;", "()V", "after", "", "before", "config", "Los/teatracker/TeaConfig$Builder;", "registerNetworkChange", "Companion", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BDTrackerInitTaskHooker implements BdtrackerInitTaskHook {
    public static final a Companion = null;
    private static final String TAG = "BDTrackerInitTaskHooker";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/launch/bdtracker/BDTrackerInitTaskHooker$Companion;", "", "()V", "TAG", "", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/launch/bdtracker/BDTrackerInitTaskHooker$registerNetworkChange$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            o.f(r1, "network");
            c.b(BDTrackerInitTaskHooker.TAG, "bdinstall receiver network onAvailable");
            com.obric.matrix.t.a.f10032a.a(BDTrackerInitTaskHooker.TAG);
        }
    }

    static {
        Companion = new a(null);
    }

    public BDTrackerInitTaskHooker() {
    }

    public static /* synthetic */ void a(BDTrackerInitTaskHooker r0) {
        m59after$lambda0(r0);
    }

    /* JADX INFO: renamed from: after$lambda-0, reason: not valid java name */
    private static final void m59after$lambda0(BDTrackerInitTaskHooker r1) {
        o.f(r1, "this$0");
        r1.registerNetworkChange();
    }

    private final void registerNetworkChange() {
        ConnectivityManager r1 = (ConnectivityManager) com.bytedance.mpaas.app.a.a().getSystemService("connectivity");
        if (r1 == null) goto L6;
        r1.registerDefaultNetworkCallback(new b());
        return;
    }

    @Override // com.ss.android.init.tasks.BdtrackerInitTaskHook
    public void after() {
        com.obric.matrix.ostracker_api.b.f();
        new Handler(com.bytedance.mpaas.app.a.a().getMainLooper()).postDelayed(new com.obric.matrix.launch.bdtracker.a(this), BDLocationConfig.sScanBleMaxInterval);
    }

    @Override // com.ss.android.init.tasks.BdtrackerInitTaskHook
    public void before(f.a r1) {
        o.f(r1, "config");
        r1.c("o_project_test");
        r1.b("508474");
        com.obric.matrix.ostracker_api.b.i(d.f8838a.e());
        BdInstallImpl.setNetworkClient(com.obric.matrix.launch.bdtracker.b.f9119a);
    }
}
