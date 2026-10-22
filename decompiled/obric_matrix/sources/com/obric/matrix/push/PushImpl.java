package com.obric.matrix.push;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.matrix.push.service.CoreService;
import com.obric.matrix.push_api.IPush;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/matrix/push/PushImpl;", "Lcom/obric/matrix/push_api/IPush;", "()V", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLockedWhenStart", "", "isStart", "logger", "com/obric/matrix/push/PushImpl$logger$1", "Lcom/obric/matrix/push/PushImpl$logger$1;", "mTeaTrackerListener", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "init", "", "context", "Landroid/content/Context;", "initLockedWhenStart", "isInvalidDeviceId", "did", "", "onInit", "onStart", "installId", "registerPushClickListener", "iPushClickListener", "Lcom/obric/matrix/push_api/IPushClickListener;", "registerPushInterceptor", "iPushInterceptor", "Lcom/obric/matrix/push_api/IPushInterceptor;", "registerPushShowListener", "iPushShowListener", "Lcom/obric/matrix/push_api/IPushShowListener;", "showNotification", "notification", "Lcom/obric/matrix/push_api/Notification;", "intent", "Landroid/content/Intent;", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushImpl implements IPush {
    public static final a Companion = null;
    private static final String TAG = "PushImpl";
    private AtomicBoolean isInit;
    private boolean isLockedWhenStart;
    private AtomicBoolean isStart;
    private final b logger;
    private final com.obric.matrix.ostracker_api.a mTeaTrackerListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/push/PushImpl$Companion;", "", "()V", "TAG", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/push/PushImpl$logger$1", "Lcom/obric/matrix/push/common/log/ILogger;", "logd", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "loge", "tr", "", "logi", "logv", "logw", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.push.n.c.b {
        b() {
        }

        @Override // com.obric.matrix.push.n.c.b
        public void a(String r1, String r2) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            com.obric.matrix.r.c.c.b(r1, r2);
        }

        @Override // com.obric.matrix.push.n.c.b
        public void b(String r1, String r2, Throwable r3) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            com.obric.matrix.r.c.c.g(r1, r2, r3);
        }

        @Override // com.obric.matrix.push.n.c.b
        public void c(String r1, String r2, Throwable r3) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            com.obric.matrix.r.c.c.t(r1, r2, r3);
        }

        @Override // com.obric.matrix.push.n.c.b
        public void d(String r1, String r2) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            com.obric.matrix.r.c.c.j(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/push/PushImpl$mTeaTrackerListener$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushImpl f9504a;

        c(PushImpl r1) {
            this.f9504a = r1;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r3) {
            com.obric.matrix.push.n.c.c.h("on deviceId loaded did = " + r3);
            PushImpl r2 = this.f9504a;
            Application r0 = com.bytedance.mpaas.app.a.b();
            o.e(r0, "getInstance()");
            PushImpl.access$onStart(r2, r0, r3, r3);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r1) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bizId", "", "data", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends q implements p<Long, byte[], f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f9505f = null;

        static {
            f9505f = new d();
        }

        d() {
            super(2);
        }

        public final void a(long r1, byte[] r3) {
            if (r3 == null) goto L10;
            com.obric.matrix.push.m.b.f9633a.t(r1).c(r3);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            com.obric.matrix.push.n.c.c.d(PushImpl.TAG, "push decode or handler error", th);
            return;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ f0 invoke(Long r3, byte[] r4) {
            a(r3.longValue(), r4);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/push/PushImpl$onInit$2", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onScreenStateChanged", "", "on", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements com.obric.matrix.q.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushImpl f9506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f9507b;

        e(PushImpl r1, Context r2) {
            this.f9506a = r1;
            this.f9507b = r2;
        }

        public static /* synthetic */ void e(e r0) {
            h(r0);
        }

        public static /* synthetic */ void g(e r0) {
            i(r0);
        }

        private static final void h(e r1) {
            o.f(r1, "$listener");
            com.obric.matrix.q.h.k.t(r1);
        }

        private static final void i(e r1) {
            o.f(r1, "$listener");
            com.obric.matrix.q.h.k.t(r1);
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r4) {
            if (r4 == true) goto L5;
            return;
        L5:
            if (PushImpl.access$isStart$p(this.f9506a).get() == false) goto L8;
            new Handler(Looper.getMainLooper()).post(new com.obric.matrix.push.a(this));
            return;
        L8:
            boolean r5 = PushImpl.access$onStart(this.f9506a, this.f9507b, com.obric.matrix.ostracker_api.b.c(), com.obric.matrix.ostracker_api.b.e());
            com.obric.matrix.push.n.c.c.h("fallback onStart ret=" + r5 + ", did=" + com.obric.matrix.ostracker_api.b.c() + ", iid=" + com.obric.matrix.ostracker_api.b.e());
            if (r5 == false) goto L12;
            com.obric.matrix.push.n.c.c.h("fallback start success, remove screen state listener");
            new Handler(Looper.getMainLooper()).post(new com.obric.matrix.push.b(this));
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public PushImpl() {
        this.isStart = new AtomicBoolean(false);
        this.isInit = new AtomicBoolean(false);
        this.mTeaTrackerListener = new c(this);
        this.logger = new b();
    }

    public static final /* synthetic */ AtomicBoolean access$isStart$p(PushImpl r0) {
        return r0.isStart;
    }

    public static final /* synthetic */ boolean access$onStart(PushImpl r0, Context r1, String r2, String r3) {
        return r0.onStart(r1, r2, r3);
    }

    private final boolean isInvalidDeviceId(String r4) {
        boolean r3 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        com.obric.matrix.push.n.c.c.l(TAG, "invalid did: [" + r4 + ']', null, 4, null);
    L17:
        return r3;
    L11:
        if (kotlin.u0.k.q(r4) == true) goto L14;
        if (r4.length() > 6) goto L15;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void onInit(Context r3) {
        com.obric.matrix.push.q.g.f9786a.a(d.f9505f);
        com.obric.matrix.ostracker_api.b.a(this.mTeaTrackerListener);
        if (isInvalidDeviceId(com.obric.matrix.ostracker_api.b.c()) == true) goto L5;
        onStart(r3, com.obric.matrix.ostracker_api.b.c(), com.obric.matrix.ostracker_api.b.e());
    L5:
        com.obric.matrix.q.h.k.l(new e(this, r3));
    }

    private final boolean onStart(Context r4, String r5, String r6) {
        if (isInvalidDeviceId(r5) == false) goto L6;
        return false;
    L6:
        if (this.isStart.getAndSet(true) == false) goto L8;
        return false;
    L8:
        com.obric.matrix.push.m.b.f9633a.b().a(r5);
        Intent r3 = new Intent(r4, CoreService.class);
        com.obric.matrix.push.p.b r1 = com.obric.matrix.push.p.b.h0;
        r3.putExtra(r1.p(), r1.f0());
        r4.startService(r3);
        com.obric.matrix.push.q.g.f9786a.j(r5, r6);
        return true;
    }

    @Override // com.obric.matrix.push_api.IPush
    public void init(Context r4) {
        o.f(r4, "context");
        if (com.ss.android.k.c.c.c(r4) == true) goto L6;
        return;
    L6:
        if (this.isInit.getAndSet(true) == false) goto L8;
        return;
    L8:
        com.obric.matrix.push.n.c.c.f9759a.j(false, this.logger);
        com.obric.matrix.push.m.b.f9633a.D().init(r4);
        StringBuilder r0 = new StringBuilder();
        r0.append("model = ");
        com.obric.matrix.push.r.e r1 = com.obric.matrix.push.r.e.f9794a;
        r0.append(r1.d());
        r0.append(" , product = ");
        r0.append(r1.i());
        com.obric.matrix.push.n.c.c.h(r0.toString());
        onInit(r4);
    }

    @Override // com.obric.matrix.push_api.IPush
    public void initLockedWhenStart() {
        this.isLockedWhenStart = !com.obric.matrix.r.b.f9910a.d();
    }

    @Override // com.obric.matrix.push_api.IPush
    public boolean isLockedWhenStart() {
        return this.isLockedWhenStart;
    }

    @Override // com.obric.matrix.push_api.IPush
    public void registerPushClickListener(com.obric.matrix.push_api.a r1) {
        com.obric.matrix.push.m.b.f9633a.x().e(r1);
    }

    @Override // com.obric.matrix.push_api.IPush
    public void registerPushInterceptor(com.obric.matrix.push_api.b r1) {
        com.obric.matrix.push.m.b.f9633a.x().f(r1);
    }

    @Override // com.obric.matrix.push_api.IPush
    public void registerPushShowListener(com.obric.matrix.push_api.c r1) {
        com.obric.matrix.push.m.b.f9633a.x().g(r1);
    }

    @Override // com.obric.matrix.push_api.IPush
    public void showNotification(com.obric.matrix.push_api.e r1, Intent r2) {
        o.f(r1, "notification");
        o.f(r2, "intent");
        com.obric.matrix.push.m.b.f9633a.v().showNotification(r1, r2);
    }
}
