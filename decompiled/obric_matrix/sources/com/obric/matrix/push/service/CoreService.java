package com.obric.matrix.push.service;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.news.common.settings.e;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.base.settings.iconfig.IPushConfig;
import com.obric.matrix.push.m.i.d;
import com.obric.matrix.push.receiver.CoreBroadCastReceiver;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/push/service/CoreService;", "Lcom/obric/matrix/push/service/BaseCrossProcessServiceProxy;", "()V", "TAG", "", "coreBroadCastReceiver", "Lcom/obric/matrix/push/receiver/CoreBroadCastReceiver;", "enableOceanPushRegister", "", "initialized", "onCreate", "", "onDestroy", "onDeviceInit", "intent", "Landroid/content/Intent;", "onNotificationClick", "onStartCommand", "", "flags", "startId", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreService extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoreBroadCastReceiver f9806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f9808i;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements l<Boolean, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoreService f9809f;

        a(CoreService r1) {
            this.f9809f = r1;
            super(1);
        }

        public final void a(boolean r4) {
            com.obric.matrix.push.m.c.b.a.a(com.obric.matrix.push.m.b.f9633a.b(), this.f9809f, false, 2, null);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Boolean r1) {
            a(r1.booleanValue());
            return f0.f18324a;
        }
    }

    public CoreService() {
        this.f9805f = "CoreService";
        this.f9806g = new CoreBroadCastReceiver();
        this.f9807h = ((IPushConfig) e.e(IPushConfig.class)).enableOceanPushRegister();
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

    public static /* synthetic */ void b(CoreService r0, Application r1, com.bytedance.news.common.settings.g.c r2) {
        d(r0, r1, r2);
    }

    private final void c(Intent r5) {
        com.obric.matrix.push.n.c.c.b(this.f9805f, "[onDeviceInit] start init cross process ability " + this.f9807h);
        final Application r6 = com.bytedance.mpaas.app.a.b();
        if (this.f9807h == true) goto L5;
        com.obric.matrix.push.n.a r0 = com.obric.matrix.push.n.a.f9741a;
        o.e(r6, "context");
        r0.a(r6).a(new com.obric.matrix.push.o.a.a());
    L5:
        e.f(new com.obric.matrix.push.service.a(this, r6), true);
        com.obric.matrix.push.n.a r1 = com.obric.matrix.push.n.a.f9741a;
        o.e(r6, "context");
        r1.a(r6).a(new com.obric.matrix.push.o.a.c());
        r1.a(r6).a(new com.obric.matrix.push.o.a.b());
        com.obric.matrix.push.n.c.c.b(this.f9805f, "[onDeviceInit] start wschannel ability");
        com.obric.matrix.push.m.b r7 = com.obric.matrix.push.m.b.f9633a;
        r7.w().b();
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.PACKAGE_ADDED");
        r2.addAction("android.intent.action.PACKAGE_REPLACED");
        r2.addAction("android.intent.action.PACKAGE_REMOVED");
        r2.addDataScheme("package");
        com.obric.matrix.push.n.c.c.b(this.f9805f, "[onDeviceInit] registerReceiver");
        a(this, this.f9806g, r2);
        com.obric.matrix.push.n.c.c.b(this.f9805f, "[onDeviceInit] update device info to server");
        r7.b().b(this, true);
        r7.D().a(new a(this));
        this.f9808i = true;
    }

    private static final void d(CoreService r3, Application r4, com.bytedance.news.common.settings.g.c r5) {
        o.f(r3, "this$0");
        boolean r6 = ((IPushConfig) e.e(IPushConfig.class)).enableOceanPushRegister();
        com.obric.matrix.push.n.c.c.i(r3.f9805f, "onSettingsUpdate enableOceanPushRegister=" + r6);
        if (r6 == r3.f9807h) goto L8;
        r3.f9807h = r6;
        if (r6 == true) goto L9;
        com.obric.matrix.push.n.a r7 = com.obric.matrix.push.n.a.f9741a;
        o.e(r4, "context");
        r7.a(r4).a(new com.obric.matrix.push.o.a.a());
        return;
    L9:
        return;
    }

    private final void e(Intent r3) {
        String r4 = r3.getStringExtra("msg_id");
        com.obric.matrix.push.n.c.c.b(this.f9805f, "on push click:" + r4);
        if (r4 == null) goto L6;
        com.obric.matrix.push.m.b.f9633a.c().a(r4, "");
        return;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.obric.matrix.push.n.c.c.b(this.f9805f, "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.obric.matrix.push.n.c.c.b(this.f9805f, "onDestroy");
        if (this.f9808i == true) goto L10;
    L8:
        super.onDestroy();
        return;
    L10:
        unregisterReceiver(this.f9806g);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9805f, "unregisterReceiver error", e);
        goto L8
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r9, int r10, int r11) {
        if (r9 != null) goto L5;
        return 2;
    L5:
        String r12 = r9.getAction();
        com.obric.matrix.push.p.b r0 = com.obric.matrix.push.p.b.h0;
        if (TextUtils.equals(r12, r0.d()) == true) goto L42;
    L34:
        com.obric.matrix.push.p.b r13 = com.obric.matrix.push.p.b.h0;
        String r1 = r9.getStringExtra(r13.p());
        if (o.a(r1, r13.f0()) == false) goto L39;
        c(r9);
    L41:
        return 1;
    L39:
        if (o.a(r1, r13.g0()) == false) goto L44;
        e(r9);
        goto L41
    L44:
        return 2;
    L42:
        JSONObject r14 = new JSONObject(r9.getStringExtra("data"));     // Catch: Throwable -> L32
        String r2 = r14.optString("msg_id");     // Catch: Throwable -> L32
        String r3 = r14.optString("package_name");     // Catch: Throwable -> L32
        String r4 = r9.getStringExtra(r0.o());     // Catch: Throwable -> L32
        if (o.a(r4, r0.e0()) == false) goto L17;
        if (TextUtils.isEmpty(r2) == true) goto L43;
        if (TextUtils.isEmpty(r3) == true) goto L43;
        com.obric.matrix.push.m.i.c r15 = com.obric.matrix.push.m.b.f9633a.w();     // Catch: Throwable -> L32
        o.e(r2, "msgId");     // Catch: Throwable -> L32
        o.e(r3, "pkgName");     // Catch: Throwable -> L32
        r15.a(r2, r3);     // Catch: Throwable -> L32
    L43:
        return 1;
    L17:
        if (o.a(r4, r0.c0()) == false) goto L24;
        if (TextUtils.isEmpty(r2) == true) goto L43;
        if (TextUtils.isEmpty(r3) == true) goto L43;
        com.obric.matrix.push.m.i.c r16 = com.obric.matrix.push.m.b.f9633a.w();     // Catch: Throwable -> L32
        o.e(r2, "msgId");     // Catch: Throwable -> L32
        o.e(r3, "pkgName");     // Catch: Throwable -> L32
        r16.c(r2, r3, null);     // Catch: Throwable -> L32
        goto L43
    L24:
        if (o.a(r4, r0.d0()) == false) goto L30;
        int r17 = r14.optInt("result");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r2) == true) goto L43;
        if (TextUtils.isEmpty(r3) == true) goto L43;
        d r5 = com.obric.matrix.push.m.b.f9633a.C();     // Catch: Throwable -> L32
        o.e(r2, "msgId");     // Catch: Throwable -> L32
        o.e(r3, "pkgName");     // Catch: Throwable -> L32
        r5.a(r2, r3, r17);     // Catch: Throwable -> L32
        goto L43
    L30:
        com.obric.matrix.push.n.c.c.c("this event is not support");     // Catch: Throwable -> L32
        return 2;
    L32:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("", "", th);
        goto L34
    }
}
