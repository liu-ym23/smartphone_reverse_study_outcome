package com.obric.matrix.opush.service;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.news.common.settings.e;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.base.settings.iconfig.IPushConfig;
import com.obric.matrix.opush.receiver.CoreBroadCastReceiver;
import kotlin.Metadata;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/opush/service/CoreService;", "Lcom/obric/matrix/opush/service/BaseCrossProcessServiceProxy;", "()V", "TAG", "", "coreBroadCastReceiver", "Lcom/obric/matrix/opush/receiver/CoreBroadCastReceiver;", "enableOceanPushRegister", "", "initialized", "onCreate", "", "onDestroy", "onDeviceInit", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreService extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoreBroadCastReceiver f9439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f9440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9441i;

    public CoreService() {
        this.f9438f = "OCoreService";
        this.f9439g = new CoreBroadCastReceiver();
        this.f9441i = ((IPushConfig) e.e(IPushConfig.class)).enableOceanPushRegister();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(CoreService r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    public static /* synthetic */ void b(CoreService r0) {
        f(r0);
    }

    public static /* synthetic */ void c(CoreService r0, Application r1, com.bytedance.news.common.settings.g.c r2) {
        e(r0, r1, r2);
    }

    private final void d(Intent r6) {
        com.obric.matrix.opush.c r7 = com.obric.matrix.opush.c.f9247a;
        r7.b(this.f9438f, "[onDeviceInit] start init cross process ability enableOceanPushRegister=" + this.f9441i);
        final Application r0 = com.bytedance.mpaas.app.a.b();
        if (this.f9441i == false) goto L5;
        com.obric.matrix.push.n.a r1 = com.obric.matrix.push.n.a.f9741a;
        o.e(r0, "context");
        r1.a(r0).a(new com.obric.matrix.opush.e.a.a());
    L5:
        e.f(new b(this, r0), true);
        r7.b(this.f9438f, "[onDeviceInit] start wschannel ability");
        com.obric.matrix.opush.d.b r2 = com.obric.matrix.opush.d.b.f9251a;
        r2.r().b();
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.PACKAGE_ADDED");
        r3.addAction("android.intent.action.PACKAGE_REPLACED");
        r3.addAction("android.intent.action.PACKAGE_REMOVED");
        r3.addDataScheme("package");
        r7.b(this.f9438f, "[onDeviceInit] registerReceiver");
        a(this, this.f9439g, r3);
        r7.b(this.f9438f, "[onDeviceInit] update device info to server");
        r2.v().a(new a(this));
        this.f9440h = true;
    }

    private static final void e(CoreService r3, Application r4, com.bytedance.news.common.settings.g.c r5) {
        o.f(r3, "this$0");
        boolean r6 = ((IPushConfig) e.e(IPushConfig.class)).enableOceanPushRegister();
        com.obric.matrix.push.n.c.c.i(r3.f9438f, "onSettingsUpdate enableOceanPushRegister=" + r6);
        if (r6 == r3.f9441i) goto L8;
        r3.f9441i = r6;
        if (r6 == false) goto L9;
        com.obric.matrix.push.n.a r7 = com.obric.matrix.push.n.a.f9741a;
        o.e(r4, "context");
        r7.a(r4).a(new com.obric.matrix.opush.e.a.a());
        return;
    L9:
        return;
    }

    private static final void f(CoreService r2) {
        o.f(r2, "this$0");
        com.obric.matrix.opush.d.b.f9251a.b().b(r2, true);
    }

    @Override // android.app.Service
    public void onCreate() {
        com.obric.matrix.opush.c.f9247a.b(this.f9438f, "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.obric.matrix.opush.c.f9247a.b(this.f9438f, "onDestroy");
        if (this.f9440h == true) goto L10;
    L8:
        super.onDestroy();
        return;
    L10:
        unregisterReceiver(this.f9439g);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9438f, "unregisterReceiver error", e);
        goto L8
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return 2;
    L5:
        com.obric.matrix.opush.f.b r5 = com.obric.matrix.opush.f.b.G;
        if (o.a(r2.getStringExtra(r5.h()), r5.F()) == false) goto L9;
        d(r2);
        return 1;
    L9:
        return 2;
    }
}
