package com.obric.matrix.launch.godzilla;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.r.e.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/matrix/launch/godzilla/LaunchSafeConfigFetcher;", "Lcom/bytedance/platform/godzilla/launch/safe/LaunchSafePlugin$IFetchConfig;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getBindLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "setBindLock", "(Ljava/util/concurrent/locks/ReentrantLock;)V", "bindLockCondition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getBindLockCondition", "()Ljava/util/concurrent/locks/Condition;", "setBindLockCondition", "(Ljava/util/concurrent/locks/Condition;)V", "isUpdateSettingsTimeOut", "", "()Z", "setUpdateSettingsTimeOut", "(Z)V", "fixSuccessful", "", "strategy", "Lcom/bytedance/platform/godzilla/launch/safe/Strategy;", "crashKey", "", "serialCrhCount", "", "getCrashLimit", "getStrategy", "", "getWatchDogTime", "", "occurSerialCrash", "count", "Companion", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f implements d.b.p.a.f.a.c.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f9143d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<String> f9144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f9145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f9146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f9148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f9149j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ReentrantLock f9150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Condition f9151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9152c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\b\u0010 \u001a\u00020\u001cH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/obric/matrix/launch/godzilla/LaunchSafeConfigFetcher$Companion;", "", "()V", "KEY_FIX_SUCCESSFUL", "", "getKEY_FIX_SUCCESSFUL", "()Ljava/lang/String;", "setKEY_FIX_SUCCESSFUL", "(Ljava/lang/String;)V", "KEY_GET_STRATEGY", "getKEY_GET_STRATEGY", "setKEY_GET_STRATEGY", "KEY_OCCUR_SERIAL_CRASH", "getKEY_OCCUR_SERIAL_CRASH", "setKEY_OCCUR_SERIAL_CRASH", "KEY_SETTINGS_STRATEGY_TYPE_ERR", "getKEY_SETTINGS_STRATEGY_TYPE_ERR", "setKEY_SETTINGS_STRATEGY_TYPE_ERR", "SP_NAME", "getSP_NAME", "TAG", "sKeys", "", "getSKeys", "()Ljava/util/List;", "setSKeys", "(Ljava/util/List;)V", "saveData", "", "method", "jsonObject", "Lorg/json/JSONObject;", "uploadData", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static SharedPreferences a(Application r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final String b() {
            return f.f();
        }

        public final List<String> c() {
            return f.g();
        }

        public final String d() {
            return f.h();
        }

        @SuppressLint({"CommitPrefEdits"})
        public final void e(String r3, JSONObject r4) {
            a(com.bytedance.mpaas.app.a.f5245g, d(), 0).edit().putString(r3, String.valueOf(r4)).commit();
        }

        @SuppressLint({"CommitPrefEdits"})
        public final void f() {
            SharedPreferences r0 = a(com.bytedance.mpaas.app.a.f5245g, d(), 0);     // Catch: Exception -> L8
            Iterator<String> r4 = c().iterator();     // Catch: Exception -> L8
        L4:
            if (r4.hasNext() == false) goto L6;
            String r1 = r4.next();     // Catch: Exception -> L8
            String r2 = r0.getString(r1, "");     // Catch: Exception -> L8
            com.obric.matrix.ostracker_api.b.g(r1, l.f9944a.b(r2));     // Catch: Exception -> L8
            goto L4
        L6:
            r0.edit().clear().apply();     // Catch: Exception -> L8
            return;
        }
    }

    static {
        f9143d = new a(null);
        ArrayList r0 = new ArrayList();
        f9144e = r0;
        f9145f = "launch_safe_get_strategy";
        f9146g = "launch_safe_occur_serial_crash";
        f9147h = "launch_safe_fix_successful";
        f9148i = "launch_safe_settings_strategy_type_err";
        f9149j = "godzilla_launch_safe_event";
        r0.add("launch_safe_get_strategy");
        f9144e.add(f9146g);
        f9144e.add(f9147h);
    }

    public f(Context r2) {
        o.f(r2, "mContext");
        ReentrantLock r3 = new ReentrantLock();
        this.f9150a = r3;
        this.f9151b = r3.newCondition();
        f9143d.f();
    }

    public static final /* synthetic */ String f() {
        return f9148i;
    }

    public static final /* synthetic */ List g() {
        return f9144e;
    }

    public static final /* synthetic */ String h() {
        return f9149j;
    }

    private static final void i(f r0, com.bytedance.news.common.settings.g.c r1) {
        o.f(r0, "this$0");
        ReentrantLock r2 = r0.f9150a;
        r2.lock();
        r0.f9151b.signalAll();     // Catch: Throwable -> L6
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L6
        r2.unlock();
        return;
    L6:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    private static final void j(f r2) {
        o.f(r2, "this$0");
        Thread.sleep(WsConstants.EXIT_DELAY_TIME);
        ReentrantLock r0 = r2.f9150a;
        r0.lock();
        r2.f9152c = true;     // Catch: Throwable -> L6
        r2.f9151b.signalAll();     // Catch: Throwable -> L6
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static /* synthetic */ void k(f r0, com.bytedance.news.common.settings.g.c r1) {
        i(r0, r1);
    }

    public static /* synthetic */ void l(f r0) {
        j(r0);
    }

    @Override // d.b.p.a.f.a.c.b
    public List<d.b.p.a.f.a.d> a() {
        int r1 = 0;
        com.bytedance.news.common.settings.e.f(new com.obric.matrix.launch.godzilla.a(this), false);
        com.bytedance.news.common.settings.e.g(true);
        this.f9152c = false;
        new Thread(new b(this)).start();
        ReentrantLock r2 = this.f9150a;
        r2.lock();
        this.f9151b.await();     // Catch: Throwable -> L12
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L15 Throwable -> L12
        if (this.f9152c == true) goto L8;
        r1 = 1;
    L8:
        r3.put("sync_get_setting_data_successful", r1);     // Catch: Exception -> L15 Throwable -> L12
        f9143d.e(f9145f, r3);     // Catch: Exception -> L15 Throwable -> L12
    L9:
        List<d.b.p.a.f.a.d> r5 = ((IgodzillaLaunchSafeConfig) com.bytedance.news.common.settings.e.e(IgodzillaLaunchSafeConfig.class)).getLaunchSafeConfig().d();     // Catch: Throwable -> L12
        r2.unlock();
        return r5;
    L12:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    @Override // d.b.p.a.f.a.c.b
    public int b() {
        return ((IgodzillaLaunchSafeConfig) com.bytedance.news.common.settings.e.e(IgodzillaLaunchSafeConfig.class)).getLaunchSafeConfig().b();
    }

    @Override // d.b.p.a.f.a.c.b
    public void c(d.b.p.a.f.a.d r1, String r2, int r3) {
        o.f(r1, "strategy");
        o.f(r2, "crashKey");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L5
        r0.put("crash_count", r3);     // Catch: Exception -> L5
        r0.put("crash_key", r2);     // Catch: Exception -> L5
        f9143d.e(f9147h, r0);     // Catch: Exception -> L5
        return;
    }

    @Override // d.b.p.a.f.a.c.b
    public long d() {
        return ((IgodzillaLaunchSafeConfig) com.bytedance.news.common.settings.e.e(IgodzillaLaunchSafeConfig.class)).getLaunchSafeConfig().c();
    }

    @Override // d.b.p.a.f.a.c.b
    public void e(String r2, int r3) {
        o.f(r2, "crashKey");
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("crash_count", r3);     // Catch: Exception -> L5
        r1.put("crash_key", r2);     // Catch: Exception -> L5
        f9143d.e(f9146g, r1);     // Catch: Exception -> L5
        return;
    }
}
