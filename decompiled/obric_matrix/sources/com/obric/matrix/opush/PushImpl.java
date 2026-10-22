package com.obric.matrix.opush;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.j;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.obric.matrix.opush.service.CoreService;
import com.obric.matrix.opush_api.IPush;
import com.obric.matrix.q.h.k;
import com.obric.matrix.v.a.h;
import com.obric.matrix.ws_api.IWs;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/matrix/opush/PushImpl;", "Lcom/obric/matrix/opush_api/IPush;", "()V", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLockedWhenStart", "", "isStart", "logger", "com/obric/matrix/opush/PushImpl$logger$1", "Lcom/obric/matrix/opush/PushImpl$logger$1;", "mTeaTrackerListener", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "buildTestMessage", "Lcom/obric/matrix/o/push/Message;", "buildTestNotification", "Lcom/obric/matrix/o/push/Notification;", "Lcom/obric/matrix/opush/ONotification;", "init", "", "context", "Landroid/content/Context;", "initLockedWhenStart", "isInvalidDeviceId", "did", "", "onInit", "onStart", "installId", "registerPushClickListener", "iPushClickListener", "Lcom/obric/matrix/opush_api/IPushClickListener;", "registerPushInterceptor", "iPushInterceptor", "Lcom/obric/matrix/opush_api/IPushInterceptor;", "registerPushShowListener", "iPushShowListener", "Lcom/obric/matrix/opush_api/IPushShowListener;", "sendPing", "heartbeatCount", "", "sendTestNotification", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushImpl implements IPush {
    public static final a Companion = null;
    private static final String TAG = "PushImpl";
    private static final String TEST_NOTIFICATION_PACKAGE = "com.obric.matrix_demo";
    private AtomicBoolean isInit;
    private boolean isLockedWhenStart;
    private AtomicBoolean isStart;
    private final b logger;
    private final com.obric.matrix.ostracker_api.a mTeaTrackerListener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/opush/PushImpl$Companion;", "", "()V", "TAG", "", "TEST_NOTIFICATION_PACKAGE", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/opush/PushImpl$logger$1", "Lcom/obric/matrix/push/common/log/ILogger;", "logd", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "loge", "tr", "", "logi", "logv", "logw", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/opush/PushImpl$mTeaTrackerListener$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushImpl f9233a;

        c(PushImpl r1) {
            this.f9233a = r1;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r4) {
            com.obric.matrix.opush.c.f9247a.g("on deviceId loaded did = " + r4);
            PushImpl r3 = this.f9233a;
            Application r0 = com.bytedance.mpaas.app.a.b();
            o.e(r0, "getInstance()");
            PushImpl.access$onStart(r3, r0, r4, r4);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r1) {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/matrix/opush/PushImpl$onInit$1", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "onHeartbeat", "", "onWsChannelMsg", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements com.obric.matrix.ws_api.a {
        d() {
        }

        @Override // com.obric.matrix.ws_api.a
        public void a(com.bytedance.common.wschannel.r.b r1, JSONObject r2) {
            o.f(r1, "connectEvent");
        }

        @Override // com.obric.matrix.ws_api.a
        public void b(j r1) {
            com.obric.matrix.ws_api.a.C0289a.b(this, r1);
        }

        @Override // com.obric.matrix.ws_api.a
        public void c() {
            com.obric.matrix.opush.d.b.f9251a.r().h();
        }

        @Override // com.obric.matrix.ws_api.a
        public void d(WsChannelMsg r4) {
            o.f(r4, "wsChannelMsg");
            if (r4.s() != 16778981) goto L5;
        L6:
            byte[] r3 = r4.i();
            if (r3 == null) goto L9;
            int r5 = r3.length;
        L10:
            com.obric.matrix.opush.c.f9247a.g("onWsChannelMsg payloadType = " + r4.l() + ", payloadSize = " + r5);
            com.obric.matrix.opush.d.g.d r6 = com.obric.matrix.opush.d.b.f9251a.r();
            String r0 = r4.l();
            o.e(r0, "wsChannelMsg.payloadType");
            byte[] r7 = r4.i();
            o.e(r7, "wsChannelMsg.payload");
            r6.d(r0, r7);
            return;
        L9:
            r5 = 0;
            goto L10
        L5:
            if (r4.s() == 33555625) goto L6;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/opush/PushImpl$onInit$2", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onScreenStateChanged", "", "on", "", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements com.obric.matrix.q.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushImpl f9234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f9235b;

        e(PushImpl r1, Context r2) {
            this.f9234a = r1;
            this.f9235b = r2;
        }

        public static /* synthetic */ void e(e r0) {
            h(r0);
        }

        public static /* synthetic */ void g(e r0) {
            i(r0);
        }

        private static final void h(e r1) {
            o.f(r1, "$listener");
            k.t(r1);
        }

        private static final void i(e r1) {
            o.f(r1, "$listener");
            k.t(r1);
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r4) {
            if (r4 == true) goto L5;
            return;
        L5:
            if (PushImpl.access$isStart$p(this.f9234a).get() == false) goto L8;
            new Handler(Looper.getMainLooper()).post(new com.obric.matrix.opush.a(this));
            return;
        L8:
            boolean r5 = PushImpl.access$onStart(this.f9234a, this.f9235b, com.obric.matrix.ostracker_api.b.c(), com.obric.matrix.ostracker_api.b.e());
            com.obric.matrix.opush.c r0 = com.obric.matrix.opush.c.f9247a;
            r0.g("fallback onStart ret=" + r5 + ", did=" + com.obric.matrix.ostracker_api.b.c() + ", iid=" + com.obric.matrix.ostracker_api.b.e());
            if (r5 == false) goto L12;
            r0.g("fallback start success, remove screen state listener");
            new Handler(Looper.getMainLooper()).post(new com.obric.matrix.opush.b(this));
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

    private final com.obric.matrix.v.a.g buildTestMessage() {
        long r0 = System.currentTimeMillis();
        com.obric.matrix.v.a.g.a r6 = new com.obric.matrix.v.a.g.a();
        r6.o(1);
        r6.e("local_test");
        String r2 = com.obric.matrix.ostracker_api.b.c();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r6.d(r2);
        r6.m(0L);
        r6.a(0);
        r6.j("local_test_push_token");
        r6.k("local-test-req-" + r0);
        r6.g("local-test-msg-" + r0);
        r6.n(0);
        r6.i(TEST_NOTIFICATION_PACKAGE);
        r6.c("");
        r6.h(2);
        r6.l(Long.valueOf(r0));
        com.obric.matrix.v.a.g r7 = r6.b();
        o.e(r7, "Builder()\n            .v…amp)\n            .build()");
        return r7;
    }

    private final h buildTestNotification() {
        com.obric.matrix.v.a.d r3 = new com.obric.matrix.v.a.d();
        r3.f10057a = 1;
        com.obric.matrix.v.a.b r1 = new com.obric.matrix.v.a.b();
        r1.f10051c = 0;
        r1.f10053e = r3;
        com.obric.matrix.v.a.a r4 = new com.obric.matrix.v.a.a();
        r4.f10046a = "local_test";
        r4.f10047b = true;
        r4.f10048c = r1;
        h r0 = new h();
        r0.f10107a = "Matrix Push Test";
        r0.f10108b = "This is a local test push for com.obric.matrixdemo.";
        r0.f10110d = r4;
        return r0;
    }

    private final boolean isInvalidDeviceId(String r7) {
        boolean r6 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        r6 = true;
    L15:
        if (r6 == false) goto L17;
        com.obric.matrix.opush.c.j(com.obric.matrix.opush.c.f9247a, TAG, "invalid did: [" + r7 + ']', null, 4, null);
    L17:
        return r6;
    L11:
        if (kotlin.u0.k.q(r7) == true) goto L14;
        if (r7.length() > 6) goto L15;
    L5:
        if (r7.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void onInit(Context r3) {
        IWs r0 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);
        if (r0 == null) goto L5;
        r0.registerListener(new d());
    L5:
        com.obric.matrix.ostracker_api.b.a(this.mTeaTrackerListener);
        if (isInvalidDeviceId(com.obric.matrix.ostracker_api.b.c()) == true) goto L8;
        onStart(r3, com.obric.matrix.ostracker_api.b.c(), com.obric.matrix.ostracker_api.b.e());
    L8:
        k.l(new e(this, r3));
    }

    private final boolean onStart(Context r2, String r3, String r4) {
        if (isInvalidDeviceId(r3) == false) goto L6;
        return false;
    L6:
        if (this.isStart.getAndSet(true) == false) goto L8;
        return false;
    L8:
        com.obric.matrix.opush.d.b.f9251a.b().a(r3);
        Intent r1 = new Intent(r2, CoreService.class);
        com.obric.matrix.opush.f.b r5 = com.obric.matrix.opush.f.b.G;
        r1.putExtra(r5.h(), r5.F());
        r2.startService(r1);
        return true;
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void init(Context r5) {
        o.f(r5, "context");
        if (com.ss.android.k.c.c.c(r5) == true) goto L6;
        return;
    L6:
        if (this.isInit.getAndSet(true) == false) goto L8;
        return;
    L8:
        com.obric.matrix.opush.d.b.f9251a.v().init(r5);
        com.obric.matrix.opush.c r0 = com.obric.matrix.opush.c.f9247a;
        StringBuilder r1 = new StringBuilder();
        r1.append("model = ");
        com.obric.matrix.opush.g.d r2 = com.obric.matrix.opush.g.d.f9428a;
        r1.append(r2.a());
        r1.append(" , product = ");
        r1.append(r2.e());
        r0.g(r1.toString());
        onInit(r5);
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void initLockedWhenStart() {
        this.isLockedWhenStart = !com.obric.matrix.r.b.f9910a.d();
    }

    @Override // com.obric.matrix.opush_api.IPush
    public boolean isLockedWhenStart() {
        return this.isLockedWhenStart;
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void registerPushClickListener(com.obric.matrix.opush_api.a r1) {
        com.obric.matrix.opush.d.b.f9251a.s().c(r1);
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void registerPushInterceptor(com.obric.matrix.opush_api.b r1) {
        com.obric.matrix.opush.d.b.f9251a.s().d(r1);
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void registerPushShowListener(com.obric.matrix.opush_api.c r1) {
        com.obric.matrix.opush.d.b.f9251a.s().e(r1);
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void sendPing(long r1) {
        com.obric.matrix.opush.d.b.f9251a.r().sendPing(r1);
    }

    @Override // com.obric.matrix.opush_api.IPush
    public void sendTestNotification() {
        com.obric.matrix.v.a.g r0 = buildTestMessage();
        h r2 = buildTestNotification();
        com.obric.matrix.opush.d.b.f9251a.q().b(r0, r2);
    }
}
