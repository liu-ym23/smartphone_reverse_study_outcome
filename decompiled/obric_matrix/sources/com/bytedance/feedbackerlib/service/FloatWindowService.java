package com.bytedance.feedbackerlib.service;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.activity.FeedbackActivity;
import com.bytedance.feedbackerlib.activity.LarkSSOLaunchTransitionActivity;
import com.bytedance.feedbackerlib.m.l;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.m.r;
import com.bytedance.feedbackerlib.model.FeedbackCommonInfo;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class FloatWindowService extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicInteger f4633l = null;
    private static final SparseArray<k> m = null;
    private static volatile boolean n;
    private static volatile long o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.a f4634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.e f4635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<String> f4636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j f4637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f4638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f4639k;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4640a;

        a(FloatWindowService r1, Looper r2) {
            this.f4640a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        @RequiresApi(api = 21)
        public void handleMessage(@NonNull Message r2) {
            super.handleMessage(r2);
            int r3 = r2.what;
            if (r3 != 0) goto L5;
            FloatWindowService.c(this.f4640a);
            return;
        L5:
            if (r3 != 1) goto L11;
            FloatWindowService.d(this.f4640a);
            return;
        }
    }

    class b extends ConnectivityManager.NetworkCallback {
        b(FloatWindowService r1) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network r3) {
            super.onAvailable(r3);
            if (Feedbacker.isFeedbackCommonInfoSetted() == true) goto L5;
            return;
        L5:
            if (Feedbacker.getApplicationContext() == null) goto L10;
            FloatWindowService.l(Feedbacker.getApplicationContext(), false, false, "on_network_available->" + System.currentTimeMillis());
            return;
        }
    }

    class c implements Feedbacker.m {
        c(FloatWindowService r1) {
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void a() {
            FloatWindowService.U(false);
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void b(@NonNull String r1) {
            FloatWindowService.U(false);
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void c() {
            FloatWindowService.U(false);
        }
    }

    class d implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4644d;

        d(FloatWindowService r1, String r2, boolean r3, boolean r4) {
            this.f4644d = r1;
            this.f4641a = r2;
            this.f4642b = r3;
            this.f4643c = r4;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context b(FloatWindowService r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r6, String r7) {
            r.k(this.f4641a, "onRequestFinished invoked", new String[]{"resultCode=" + r6, "msg=" + r7});
            if (r6 == 0) goto L19;
        L16:
            FloatWindowService.e(this.f4644d, this.f4642b, this.f4643c, this.f4641a);
            return;
        L19:
            if (Boolean.parseBoolean(r7) == false) goto L16;
            com.bytedance.feedbackerlib.model.e.e r8 = com.bytedance.feedbackerlib.model.a.I().P();     // Catch: Throwable -> L18
            if (r8 != null) goto L10;
            r.k(this.f4641a, "userProfileInfo==null", new String[0]);     // Catch: Throwable -> L18
            FloatWindowService.e(this.f4644d, this.f4642b, this.f4643c, this.f4641a);     // Catch: Throwable -> L18
            com.bytedance.feedbackerlib.j.b.a();     // Catch: Throwable -> L18
            return;
        L10:
            String r9 = r8.f4623b;     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r9) == false) goto L14;
            r.k(this.f4641a, "email is empty", new String[0]);     // Catch: Throwable -> L18
            FloatWindowService.e(this.f4644d, this.f4642b, this.f4643c, this.f4641a);     // Catch: Throwable -> L18
            com.bytedance.feedbackerlib.j.b.a();     // Catch: Throwable -> L18
            return;
        L14:
            r.k(this.f4641a, "callback lark sso success", new String[]{"email=" + r9});     // Catch: Throwable -> L18
            com.bytedance.feedbackerlib.l.a.d(b(this.f4644d), this.f4641a);     // Catch: Throwable -> L18
            FloatWindowService.R("ShowFloatWindowForWhiteList->" + System.currentTimeMillis(), b(this.f4644d));     // Catch: Throwable -> L18
            com.bytedance.feedbackerlib.j.b.a();     // Catch: Throwable -> L18
        }
    }

    class e implements com.bytedance.feedbackerlib.model.a.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4648d;

        e(FloatWindowService r1, String r2, boolean r3, boolean r4) {
            this.f4648d = r1;
            this.f4645a = r2;
            this.f4646b = r3;
            this.f4647c = r4;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context b(FloatWindowService r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // com.bytedance.feedbackerlib.model.a.u
        public void a(@NonNull Boolean r5) {
            r.k(this.f4645a, "onNetworkStateRequestFinish", new String[]{"isInternalNetwork=" + r5});
            if (r5.booleanValue() == false) goto L6;
            r.k(this.f4645a, "callback larkssobypassed", new String[0]);
            com.bytedance.feedbackerlib.l.a.b(b(this.f4648d), this.f4645a);
            com.bytedance.feedbackerlib.j.b.a();
            return;
        L6:
            FloatWindowService.f(this.f4648d, this.f4646b, this.f4647c, this.f4645a);
        }
    }

    class f implements com.bytedance.feedbackerlib.model.a.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4652d;

        f(FloatWindowService r1, String r2, boolean r3, boolean r4) {
            this.f4652d = r1;
            this.f4649a = r2;
            this.f4650b = r3;
            this.f4651c = r4;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context b(FloatWindowService r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // com.bytedance.feedbackerlib.model.a.u
        public void a(@NonNull Boolean r5) {
            r.k(this.f4649a, "onNetworkStateRequestFinish invoked", new String[]{"isValid=" + r5});
            if (r5.booleanValue() == false) goto L6;
            r.k(this.f4649a, "callback sso bypassed", new String[0]);
            com.bytedance.feedbackerlib.l.a.b(b(this.f4652d), this.f4649a);
            com.bytedance.feedbackerlib.j.b.a();
            return;
        L6:
            FloatWindowService.f(this.f4652d, this.f4650b, this.f4651c, this.f4649a);
        }
    }

    class g implements com.bytedance.feedbackerlib.model.a.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4656d;

        class a implements com.bytedance.feedbackerlib.model.a.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f4657a;

            a(g r1) {
                this.f4657a = r1;
            }

            @Proxy("getApplicationContext")
            @TargetClass(scope = Scope.ALL, value = "android.content.Context")
            public static Context b(FloatWindowService r2) {
                return r2.getApplicationContext();
            L4:
                e = move-exception;
                com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
                return com.bytedance.mpaas.app.a.a();
            }

            @Override // com.bytedance.feedbackerlib.model.a.v
            public void a(int r6, String r7) {
                r.k(this.f4657a.f4653a, "onRequestFinished invoked", new String[]{"resultCode=" + r6, "msg=" + r7});
                if (r6 != 1) goto L15;
                g r8 = this.f4657a;
                if (FloatWindowService.g(r8.f4656d, r8.f4653a) == false) goto L10;
                r.k(this.f4657a.f4653a, "callback larkssoBypassed", new String[0]);
            L7:
                com.bytedance.feedbackerlib.l.a.b(b(this.f4657a.f4656d), this.f4657a.f4653a);
            L8:
                com.bytedance.feedbackerlib.j.b.a();
                return;
            L10:
                g r9 = this.f4657a;
                if (r9.f4654b == false) goto L13;
                r.k(r9.f4653a, "start LarkSSOLaunchTransitionActivity", new String[]{"ssoIfNeed=" + this.f4657a.f4654b});
                Context r10 = b(this.f4657a.f4656d);
                g r5 = this.f4657a;
                LarkSSOLaunchTransitionActivity.Y(r10, r5.f4655c, r5.f4653a);
            L13:
                com.bytedance.feedbackerlib.j.b.a();
                return;
            L15:
                com.bytedance.feedbackerlib.model.e.e r11 = com.bytedance.feedbackerlib.model.a.I().P();
                if (r11 != null) goto L18;
            L21:
                g r12 = this.f4657a;
                if (FloatWindowService.g(r12.f4656d, r12.f4653a) == false) goto L24;
                r.k(this.f4657a.f4653a, "weakNetwork bypass sso", new String[0]);
                goto L7
            L24:
                g r13 = this.f4657a;
                if (r13.f4654b == false) goto L27;
                r.k(r13.f4653a, "startLarkSSOLaunchTransitionActivity", new String[]{"ssoIfNeed=" + this.f4657a.f4654b});
                Context r14 = b(this.f4657a.f4656d);
                g r15 = this.f4657a;
                LarkSSOLaunchTransitionActivity.Y(r14, r15.f4655c, r15.f4653a);
            L27:
                com.bytedance.feedbackerlib.j.b.a();
                return;
            L18:
                if (TextUtils.isEmpty(r11.f4623b) == true) goto L21;
                r.k(this.f4657a.f4653a, "callback lark sso success", new String[]{"email=" + Feedbacker.getLarkSSOEmail()});
                com.bytedance.feedbackerlib.l.a.d(b(this.f4657a.f4656d), this.f4657a.f4653a);
                FloatWindowService.R("ShowFloatWindowForNotIntWhiteList->" + System.currentTimeMillis(), b(this.f4657a.f4656d));
                goto L8
            }
        }

        g(FloatWindowService r1, String r2, boolean r3, boolean r4) {
            this.f4656d = r1;
            this.f4653a = r2;
            this.f4654b = r3;
            this.f4655c = r4;
        }

        @Override // com.bytedance.feedbackerlib.model.a.u
        public void a(@NonNull Boolean r4) {
            r.k(this.f4653a, "onNetworkStateRequestFinish invoked start request user profile from server", new String[0]);
            com.bytedance.feedbackerlib.model.a.I().b0(r4.booleanValue(), new a(this));
        }
    }

    class h implements com.bytedance.feedbackerlib.model.a.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4659b;

        h(FloatWindowService r1, String r2) {
            this.f4659b = r1;
            this.f4658a = r2;
        }

        @Override // com.bytedance.feedbackerlib.model.a.t
        public void a(String r3) {
            if ("success".equals(r3) == true) goto L6;
            Toast.makeText(this.f4659b, "base apk md5 计算失败：" + r3, 0).show();
            return;
        L6:
            FloatWindowService.h(this.f4659b, this.f4658a);
        }
    }

    class i implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4661b;

        i(FloatWindowService r1, String r2) {
            this.f4661b = r1;
            this.f4660a = r2;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r1, String r2) {
            FloatWindowService.i(this.f4661b, this.f4660a);
        }
    }

    private class j implements ComponentCallbacks {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FloatWindowService f4662f;

        private j(FloatWindowService r1) {
            this.f4662f = r1;
        }

        /* synthetic */ j(FloatWindowService r1, a r2) {
            this(r1);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration r1) {
            this.f4662f.P();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public interface k {
        void a();
    }

    static {
        f4633l = new AtomicInteger(0);
        m = new SparseArray();
        n = false;
        o = 0;
    }

    public FloatWindowService() {
        this.f4638j = new a(this, Looper.getMainLooper());
        this.f4636h = new HashSet();
        this.f4637i = new j(this, null);
        if (Build.VERSION.SDK_INT < 24) goto L5;
        this.f4639k = new b(this);
        return;
    L5:
        this.f4639k = null;
    }

    private void A(int r2) {
        a0();
        SparseArray<k> r1 = m;
        monitor-enter(r1);
        k r0 = r1.get(r2);     // Catch: Throwable -> L12
        if (r0 != null) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L8:
        r1.delete(r2);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        r0.a();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void B() {
        stopForeground(true);
    }

    private void C() {
        com.bytedance.feedbackerlib.m.g.f.b();
    }

    private void D() {
        com.bytedance.feedbackerlib.m.g.f.c();
    }

    private boolean E(String r10) {
        r.k(r10, "handleWeakNetworkState invoked", new String[0]);
        if (TextUtils.isEmpty(com.bytedance.feedbackerlib.model.a.I().O()) == false) goto L6;
        r.k(r10, "userAccessToken is empty return false", new String[0]);
        return false;
    L6:
        long r0 = System.currentTimeMillis();
        long r2 = q.c.f4307g.a(-1);
        if ((r0 - r2) >= 2592000000L) goto L9;
        boolean r4 = true;
    L10:
        r.k(r10, "check time is valid: ", new String[]{"currentTimeMillis=" + r0, "lastssotimestamp=" + r2, "tokenValid=" + r4});
        return r4;
    L9:
        r4 = false;
        goto L10
    }

    private void F(String r4) {
        r.g(r4, "hideFeedbackFloatWindow() is invoked", new String[0]);
        if (j() == true) goto L6;
        return;
    L6:
        if (this.f4634f == null) goto L9;
        r.g(r4, "hideFeedbackFloatWindow(): mFloatWindowManager != null", new String[0]);
        this.f4634f.C0();
        return;
    }

    public static void G(@Nullable Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_hide_float_window");
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public static boolean H() {
        return n;
    }

    private boolean I(String r5) {
        String r4 = Feedbacker.getForceSSOToken();
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService", "forceSSOToken = " + r4);
        r.k(r5, "isForceSSO is invoked", new String[]{"forceSSOToken = " + r4});
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.common.utility.k.b(r4, "default_force_sso_token") == false) goto L8;
        return true;
    L8:
        return false;
    }

    private void J() {
        stopForeground(true);
        stopSelf();
        Process.killProcess(Process.myPid());
    }

    private void K() {
        ActivityManager r0 = (ActivityManager) getSystemService("activity");
        if (r0 != null) goto L5;
        return;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r1 = r0.getRunningAppProcesses();
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = false;
        Iterator<ActivityManager.RunningAppProcessInfo> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        String r4 = r3.next().processName;
        if (r4 == null) goto L10;
        if (r4.endsWith(":feedbacker") == true) goto L10;
        r2 = true;
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        J();
    }

    private void L(String r2) {
        Feedbacker.setApplicationForegroundLogic(false);
        F(r2);
    }

    private void M(String r2) {
        Feedbacker.setApplicationForegroundLogic(true);
        S(r2);
    }

    public static void N(@Nullable Context r3, @NonNull String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_process_came_to_background");
        r0.putExtra("extra_process_name", r4);
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public static void O(@Nullable Context r3, @NonNull String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_process_came_to_foreground");
        r0.putExtra("extra_process_name", r4);
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    private void Q() {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        ConnectivityManager r0 = (ConnectivityManager) getSystemService("connectivity");
        if (r0 != null) goto L12;
        return;
    L12:
        r0.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback) this.f4639k);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L9:
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        a(this, com.bytedance.feedbackerlib.l.b.a(), r1);
    }

    public static void R(String r5, @Nullable Context r6) {
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "requestActivateInfoAndShowFloatWindowIfNecessary(Context context) is invoked");
        r.h(r5, "requestActivateInfoAndShowFloatWindowIfNecessary(Context context) is invoked", new String[0]);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getApplicationContext() == null) goto L15;
        Intent r1 = new Intent(r6.getApplicationContext(), FloatWindowService.class);
        r1.setAction("action_request_activate_info_and_show_float_window");
        r1.putExtra("extra_log_id", r5);
        r6.getApplicationContext().startService(r1);     // Catch: Throwable -> L10
        return;
    L10:
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "requestActivateInfoAndShowFloatWindowIfNecessary(Context context) has exception");
        r.h(r5, "requestActivateInfoAndShowFloatWindowIfNecessary(Context context) has exception", new String[0]);
        return;
    }

    private void S(String r3) {
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "requestFeedbackerActivateInfoAndShowFloatWindowIfNecessary is invoked");
        r.h(r3, "requestFeedbackerActivateInfoAndShowFloatWindowIfNecessary is invoked", new String[0]);
        if (TextUtils.isEmpty(com.bytedance.feedbackerlib.model.a.I().F()) == false) goto L5;
        com.bytedance.feedbackerlib.model.a.I().w(this, new h(this, r3));
        return;
    L5:
        T(r3);
    }

    private void T(String r3) {
        com.bytedance.feedbackerlib.model.a.I().V(new i(this, r3), com.bytedance.feedbackerlib.model.a.I().F(), r3);
    }

    public static void U(boolean r0) {
        n = r0;
    }

    public static void V(@Nullable Context r3, @Nullable FeedbackCommonInfo r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_set_feedback_common_info");
        r0.putExtra("extra_feedback_common_info", r4);
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    private void W(String r5) {
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "showFeedbackFloatWindow() is invoked");
        r.h(r5, "showFeedbackFloatWindow() is invoked", new String[0]);
        if (j() == true) goto L6;
        return;
    L6:
        if (this.f4634f == null) goto L9;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "mFloatWindowManager != null");
        r.h(r5, "mFloatWindowManager != null", new String[0]);
        this.f4634f.k1(r5);
        return;
    }

    public static void X(@Nullable Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_show_float_window");
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    private void Y() {
        this.f4638j.sendEmptyMessage(0);
    }

    private void Z() {
        this.f4638j.sendEmptyMessage(1);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(FloatWindowService r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    private void a0() {
        NotificationManager r0 = (NotificationManager) getSystemService("notification");
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 26) goto L8;
        r0.createNotificationChannel(new NotificationChannel("feedbackerlib.FloatWindowService", "FloatWindowService", 1));
    L8:
        NotificationCompat.Builder r2 = new NotificationCompat.Builder(this, "feedbackerlib.FloatWindowService");
        r2.setContentTitle(this.f4635g.g("feedbacker_running"));
        r2.setContentText(this.f4635g.g("enter_feedbacker"));
        r2.setSmallIcon(com.bytedance.feedbackerlib.d.m);
        if (r1 < 23) goto L11;
        int r3 = 67108864;
    L12:
        r2.setContentIntent(PendingIntent.getActivity(b(this), 0, FeedbackActivity.N0(b(this), null), r3));
        startForeground(16384, r2.build());
        return;
    L11:
        r3 = 0;
        goto L12
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context b(FloatWindowService r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    public static void b0(@Nullable Context r3, k r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L22;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_start_service_foreground");
        int r1 = n();
        r0.putExtra("extra_invoke_id", r1);
        SparseArray<k> r2 = m;
        monitor-enter(r2);
        r2.put(r1, r4);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void c(FloatWindowService r0) {
        r0.s();
    }

    public static void c0(@Nullable Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_switch_to_boe_domain");
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    static /* synthetic */ void d(FloatWindowService r0) {
        r0.t();
    }

    public static void d0(@Nullable Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L13;
        Intent r0 = new Intent(r3.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_switch_to_online_domain");
        r3.getApplicationContext().startService(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    static /* synthetic */ void e(FloatWindowService r0, boolean r1, boolean r2, String r3) {
        r0.r(r1, r2, r3);
    }

    private void e0() {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        ConnectivityManager r0 = (ConnectivityManager) getSystemService("connectivity");
        if (r0 != null) goto L7;
        return;
    L7:
        r0.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) this.f4639k);     // Catch: Throwable -> L10
    L11:
        return;
    L8:
        unregisterReceiver(com.bytedance.feedbackerlib.l.b.a());     // Catch: Throwable -> L10
    }

    static /* synthetic */ void f(FloatWindowService r0, boolean r1, boolean r2, String r3) {
        r0.q(r1, r2, r3);
    }

    static /* synthetic */ boolean g(FloatWindowService r0, String r1) {
        return r0.E(r1);
    }

    static /* synthetic */ void h(FloatWindowService r0, String r1) {
        r0.T(r1);
    }

    static /* synthetic */ void i(FloatWindowService r0, String r1) {
        r0.W(r1);
    }

    private boolean j() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public static void k(@Nullable Context r2, String r3) {
        l(r2, false, true, r3);
    }

    public static void l(@Nullable Context r9, boolean r10, boolean r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r12 = System.currentTimeMillis() + "->" + n();
    L5:
        r.k(r12, "checkLarkSSOWhiteList invoked", new String[]{"context=" + r9, "forceH5=" + r10, "ssoIfNeed=" + r11});
        if (r9 != null) goto L8;
    L15:
        r.k(r12, "args illegal", new String[]{"context=" + r9, "forceH5=" + r10, "ssoIfNeed=" + r11});
        return;
    L8:
        if (r9.getApplicationContext() == null) goto L15;
        if (Feedbacker.isBypassDebug() == true) goto L15;
        Intent r0 = new Intent(r9.getApplicationContext(), FloatWindowService.class);
        r0.setAction("action_check_sso_white_list");
        r0.putExtra("extra_force_h5", r10);
        r0.putExtra("extra_sso_if_need", r11);
        r0.putExtra("extra_log_id", r12);
        r9.getApplicationContext().startService(r0);     // Catch: Throwable -> L17
        return;
    }

    @RequiresApi(api = 21)
    private void m(String r19) {
        if (this.f4634f != null) goto L58;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "mFloatWindowManager is null");
        r.h(r19, "ensureFloatWindowStateCorrect is invoked", new String[]{"mFloatWindowManager is null"});
        return;
    L58:
        ActivityManager r9 = (ActivityManager) getSystemService("activity");     // Catch: Throwable -> L55
        if (r9 == null) goto L30;
        List<ActivityManager.RunningAppProcessInfo> r10 = r9.getRunningAppProcesses();     // Catch: Throwable -> L55
        HashSet r14 = new HashSet();     // Catch: Throwable -> L55
        if (r10 == null) goto L23;
        Iterator<ActivityManager.RunningAppProcessInfo> r11 = r10.iterator();     // Catch: Throwable -> L55
        boolean r15 = false;
    L12:
        if (r11.hasNext() == false) goto L24;
        ActivityManager.RunningAppProcessInfo r13 = r11.next();     // Catch: Throwable -> L55
        r14.add(r13.processName);     // Catch: Throwable -> L55
        Iterator<ActivityManager.RunningAppProcessInfo> r17 = r11;
        if (r13.processName.endsWith(":feedbacker") == true) goto L22;
        String[] r12 = r13.pkgList;     // Catch: Throwable -> L55
        if (r12 == null) goto L22;
        if (com.bytedance.feedbackerlib.m.e.a(r12, getPackageName()) == false) goto L22;
        if (r13.importance != 100) goto L22;
        r15 = true;
    L22:
        r11 = r17;
    L24:
        Iterator<String> r16 = this.f4636h.iterator();     // Catch: Throwable -> L55
    L26:
        if (r16.hasNext() == false) goto L33;
        if (r14.contains(r16.next()) == true) goto L26;
        r16.remove();     // Catch: Throwable -> L55
    L33:
        if (this.f4636h.size() > 0) goto L36;
        if (r15 == true) goto L36;
    L45:
        if (this.f4636h.size() > 0) goto L52;
        if (r15 == true) goto L52;
        if (Feedbacker.isApplicationForegroundLogic() == false) goto L50;
    L51:
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "mProcessesInForeground.size() is " + this.f4636h.size() + ", isApplicationForegroundImportance is " + r15 + ", isApplicationForegroundLogic() is " + Feedbacker.isApplicationForegroundLogic() + ", mFloatWindowManager.isShown() is " + this.f4634f.N0());     // Catch: Throwable -> L55
        r.h(r19, "ensureFloatWindowStateCorrect is invoked", new String[]{"mProcessesInForeground.size() is " + this.f4636h.size() + ", isApplicationForegroundImportance is " + r15 + ", isApplicationForegroundLogic() is " + Feedbacker.isApplicationForegroundLogic() + ", mFloatWindowManager.isShown() is " + this.f4634f.N0()});     // Catch: Throwable -> L55
        L(r19);     // Catch: Throwable -> L55
        goto L52
    L50:
        if (this.f4634f.N0() == true) goto L51;
    L52:
        K();     // Catch: Throwable -> L55
        return;
    L36:
        if (Feedbacker.isApplicationForegroundLogic() == true) goto L38;
    L53:
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService show", "mProcessesInForeground.size() = " + this.f4636h.size() + ",  isApplicationForegroundImportance is " + r15 + ", isBoeDomain() is " + com.bytedance.feedbackerlib.m.g.f.a() + ", mFloatWindowManager.isShown() is " + this.f4634f.N0() + ", mFloatWindowManager.isInitialOrFloatPicVideoOrRecordVideoState() is " + this.f4634f.J0());     // Catch: Throwable -> L55
        r.h(r19, "ensureFloatWindowStateCorrect is invoked", new String[]{"mProcessesInForeground.size() = " + this.f4636h.size() + ",  isApplicationForegroundImportance is " + r15 + ", isBoeDomain() is " + com.bytedance.feedbackerlib.m.g.f.a() + ", mFloatWindowManager.isShown() is " + this.f4634f.N0() + ", mFloatWindowManager.isInitialOrFloatPicVideoOrRecordVideoState() is " + this.f4634f.J0()});     // Catch: Throwable -> L55
        M(r19);     // Catch: Throwable -> L55
        return;
    L38:
        if (com.bytedance.feedbackerlib.m.g.f.a() == false) goto L45;
        if (this.f4634f.N0() == true) goto L45;
        if (this.f4634f.J0() == false) goto L45;
    L23:
        r15 = false;
        goto L24
    L30:
        r15 = false;
    L55:
        th = move-exception;
        th.printStackTrace();
    }

    private static int n() {
        return f4633l.getAndIncrement();
    }

    public static long o() {
        return o;
    }

    private void p() {
        F("handleHideFloatWindow->" + System.currentTimeMillis());
    }

    private void q(boolean r5, boolean r6, String r7) {
        r.k(r7, "handleNoSSObypassToken inovked", new String[]{"forceH5=" + r5, "ssoIfNeed=" + r6, "logId=" + r7});
        if (l.c(b(this)) == false) goto L8;
        r.k(r7, "none network", new String[0]);
        Toast.makeText(this, this.f4635g.g("network_unavailable"), 0).show();
        if (E(r7) == false) goto L8;
        r.k(r7, "callback ssoBypassed", new String[0]);
        com.bytedance.feedbackerlib.l.a.b(b(this), r7);
        com.bytedance.feedbackerlib.j.b.a();
        return;
    L8:
        r.k(r7, "start request white list info from server", new String[0]);
        com.bytedance.feedbackerlib.model.a.I().c0(new d(this, r7, r5, r6));
    }

    private void r(boolean r7, boolean r8, String r9) {
        r.k(r9, "handleNotInfWhiteList invoked", new String[]{"forceH5=" + r7, "ssoIfNeed=" + r8});
        String r0 = com.bytedance.feedbackerlib.model.a.I().O();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        r.k(r9, "userAccessToken=" + r0, new String[0]);
        if (r8 == false) goto L10;
        r.k(r9, "start LarkSSOLaunchTransitionActivity", new String[]{"ssoIfNeed=" + r8});
        LarkSSOLaunchTransitionActivity.Y(b(this), r7, r9);
        return;
    L10:
        return;
    L8:
        r.k(r9, "start request network state from server", new String[0]);
        com.bytedance.feedbackerlib.model.a.I().W(new g(this, r9, r8, r7));
    }

    @RequiresApi(api = 21)
    private void s() {
        m("handlePollingCheck->" + System.currentTimeMillis());
        this.f4638j.sendEmptyMessageDelayed(0, 500);
    }

    private void t() {
        q.c r0 = q.c.f4308h;
        long r1 = r0.a(-1);
        if (r1 >= 0) goto L5;
        r0.b(0);
    L6:
        this.f4638j.sendEmptyMessageDelayed(1, BDLocationConfig.sScanBleMaxInterval);
        return;
    L5:
        r0.b(r1 + BDLocationConfig.sScanBleMaxInterval);
        goto L6
    }

    @RequiresApi(api = 21)
    private void u(@NonNull Intent r4) {
        String r5 = r4.getStringExtra("extra_process_name");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        String r0 = "handleProcessCameToBackground->" + System.currentTimeMillis();
        this.f4636h.remove(r5);
        m(r0);
    }

    @RequiresApi(api = 21)
    private void v(@NonNull Intent r4) {
        String r5 = r4.getStringExtra("extra_process_name");
        String r0 = "handleProcessCameToForeground->" + System.currentTimeMillis();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.f4636h.add(r5);
        m(r0);
    }

    private void w(boolean r6, boolean r7, String r8) {
        r.k(r8, "handleRequestLarkSSOWhiteListInfo invoked", new String[]{"forceH5=" + r6, "ssoIfNeed=" + r7, "logId=" + r8});
        if (Feedbacker.isFeedbackCommonInfoSetted() == true) goto L7;
        r.k(r8, "!Feedbacker.isFeedbackCommonInfoSetted()", new String[0]);
    L5:
        com.bytedance.feedbackerlib.j.b.a();
        return;
    L7:
        o = System.currentTimeMillis();
        if (H() == false) goto L11;
        if (r7 == false) goto L11;
        r.k(r8, "already started sso return", new String[0]);
    L11:
        if (r7 == false) goto L14;
        r.k(r8, "setAlreadyStartedSSO(true)", new String[0]);
        U(true);
    L14:
        if (I(r8) == false) goto L17;
        r(r6, r7, r8);
        return;
    L17:
        String r0 = null;
        if (Build.VERSION.SDK_INT < 17) goto L22;
        ContentResolver r1 = getContentResolver();
        if (r1 == null) goto L22;
        r0 = Settings.Global.getString(r1, "feedbacker_sso_bypass_token");
    L22:
        r.k(r8, "ssoBypassToken=" + r0, new String[0]);
        if (TextUtils.isEmpty(r0) == false) goto L25;
        q(r6, r7, r8);
        return;
    L25:
        x(r0, r6, r7, r8);
    }

    private void x(@NonNull String r5, boolean r6, boolean r7, String r8) {
        r.k(r8, "handleSSOBypassToken invoked", new String[]{"ssoBypassToken=" + r5, "forceH5=" + r6, "ssoIfNeed=" + r7, "logId=" + r8});
        if ("default_sso_bypass_token".equals(r5) == false) goto L5;
        r.k(r8, "start request network state from server", new String[0]);
        com.bytedance.feedbackerlib.model.a.I().W(new e(this, r8, r6, r7));
        return;
    L5:
        r.k(r8, "start check sso bypass token", new String[0]);
        com.bytedance.feedbackerlib.model.a.I().x(r5, new f(this, r8, r6, r7));
    }

    private void y(@Nullable FeedbackCommonInfo r1) {
        Feedbacker.setFeedbackCommonInfo(r1);
    }

    private void z() {
        W("handleShowFloatWindow->" + System.currentTimeMillis());
    }

    public void P() {
        String r0 = "ScreenOrientationChanged->" + System.currentTimeMillis();
        com.bytedance.feedbackerlib.m.c.b("FloatWindowService", "onScreenOrientationChanged executed!");
        com.bytedance.feedbackerlib.j.a r3 = this.f4634f;
        if (r3 == null) goto L6;
        r3.Y0(r0);
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        throw new RuntimeException("cannot bind FloatWindowService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Feedbacker.init(getApplication(), false);
        Feedbacker.registerLarkSSOCallback(new c(this));
        r.e();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.f4634f = com.bytedance.feedbackerlib.j.a.z0(getApplication());
    L5:
        this.f4635g = com.bytedance.feedbackerlib.j.e.e();
        getApplication().registerComponentCallbacks(this.f4637i);
        Q();
        Y();
        Z();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e0();
    }

    @Override // android.app.Service
    @RequiresApi(api = 21)
    public int onStartCommand(Intent r4, int r5, int r6) {
        if (r4 != null) goto L5;
        return 1;
    L5:
        String r7 = r4.getAction();
        if (r7 != null) goto L8;
        return 1;
    L8:
        r7.hashCode();
        switch(r7.hashCode()) {
            case -2056974601: goto L52;
            case -1881619129: goto L48;
            case -1352100365: goto L44;
            case -1078658334: goto L40;
            case -960546673: goto L36;
            case -766753170: goto L32;
            case -476500116: goto L28;
            case 43635041: goto L24;
            case 125407246: goto L20;
            case 423422372: goto L16;
            case 2145028621: goto L12;
            default: goto L10;
        };
    L10:
        byte r8 = -1;
    L56:
        switch(r8) {
            case 0: goto L68;
            case 1: goto L67;
            case 2: goto L66;
            case 3: goto L65;
            case 4: goto L64;
            case 5: goto L63;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L60;
            case 9: goto L59;
            case 10: goto L58;
            default: goto L69;
        };
    L58:
        C();
        goto L69
    L59:
        w(r4.getBooleanExtra("extra_force_h5", false), r4.getBooleanExtra("extra_sso_if_need", true), r4.getStringExtra("extra_log_id"));
        goto L69
    L60:
        D();
        goto L69
    L61:
        B();
        goto L69
    L62:
        z();
        goto L69
    L63:
        y((FeedbackCommonInfo) r4.getParcelableExtra("extra_feedback_common_info"));
        goto L69
    L64:
        S(r4.getStringExtra("extra_log_id"));
        goto L69
    L65:
        u(r4);
        goto L69
    L66:
        A(r4.getIntExtra("extra_invoke_id", -1));
        goto L69
    L67:
        p();
        goto L69
    L68:
        v(r4);
    L69:
        return 1;
    L12:
        if (r7.equals("action_switch_to_boe_domain") == false) goto L70;
        r8 = 10;
        goto L56
    L70:
        r8 = -1;
        goto L56
    L16:
        if (r7.equals("action_check_sso_white_list") == false) goto L71;
        r8 = 9;
        goto L56
    L71:
        r8 = -1;
        goto L56
    L20:
        if (r7.equals("action_switch_to_online_domain") == false) goto L72;
        r8 = 8;
        goto L56
    L72:
        r8 = -1;
        goto L56
    L24:
        if (r7.equals("action_stop_service_foreground") == false) goto L73;
        r8 = 7;
        goto L56
    L73:
        r8 = -1;
        goto L56
    L28:
        if (r7.equals("action_show_float_window") == false) goto L74;
        r8 = 6;
        goto L56
    L74:
        r8 = -1;
        goto L56
    L32:
        if (r7.equals("action_set_feedback_common_info") == false) goto L75;
        r8 = 5;
        goto L56
    L75:
        r8 = -1;
        goto L56
    L36:
        if (r7.equals("action_request_activate_info_and_show_float_window") == false) goto L76;
        r8 = 4;
        goto L56
    L76:
        r8 = -1;
        goto L56
    L40:
        if (r7.equals("action_process_came_to_background") == false) goto L77;
        r8 = 3;
        goto L56
    L77:
        r8 = -1;
        goto L56
    L44:
        if (r7.equals("action_start_service_foreground") == false) goto L78;
        r8 = 2;
        goto L56
    L78:
        r8 = -1;
        goto L56
    L48:
        if (r7.equals("action_hide_float_window") == false) goto L79;
        r8 = 1;
        goto L56
    L79:
        r8 = -1;
        goto L56
    L52:
        if (r7.equals("action_process_came_to_foreground") == false) goto L80;
        r8 = 0;
        goto L56
    L80:
        r8 = -1;
        goto L56
    }
}
