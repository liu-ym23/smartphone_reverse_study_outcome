package d.b.h.a.a.h.o.b;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class h implements d.b.h.a.a.h.o.b.x.k.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.h.a.a.h.o.b.x.k.e f13496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f13497b;

    class a extends BroadcastReceiver {
        a(h r1) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r2.getAction()) == true) goto L8;
            return;
        L8:
            d.b.h.a.a.h.o.b.x.e.q().v();
        }
    }

    static {
    }

    public h() {
        this.f13496a = new d.b.h.a.a.h.o.b.x.k.e();
        this.f13497b = new a(this);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    private void c(Context r2) {
        Logger.debug();
        if ((r2 instanceof Application) == false) goto L8;
        Application r3 = (Application) r2;
        if (r3 == null) goto L9;
        this.f13496a.e(this);
        r3.registerActivityLifecycleCallbacks(this.f13496a);
        return;
    L9:
        return;
    }

    private void d(Context r3) {
        if (r3 == null) goto L5;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        a(r3, this.f13497b, r0);
        Logger.debug();
        return;
    }

    public void b(Context r1) {
        d(r1);
        c(r1);
    }

    @Override // d.b.h.a.a.h.o.b.x.k.e.c
    public void onEnterToBackground() {
    }

    @Override // d.b.h.a.a.h.o.b.x.k.e.c
    public void onEnterToForeground() {
        d.b.h.a.a.h.o.b.x.e.q().w();
    }
}
