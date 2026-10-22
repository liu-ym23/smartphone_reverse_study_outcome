package com.bytedance.news.common.settings;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.h.h;
import com.bytedance.news.common.settings.h.j;
import com.service.middleware.applog.ApplogService;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.bytedance.news.common.settings.a f5294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f5295c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<f, Boolean> f5296d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h f5297e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.bytedance.news.common.settings.h.f f5298f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile com.bytedance.news.common.settings.b f5299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f5300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f5301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f5302j;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f5303f;

        a(boolean r1) {
            this.f5303f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(this.f5303f);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map.Entry f5304f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.news.common.settings.g.c f5305g;

        b(Map.Entry r1, com.bytedance.news.common.settings.g.c r2) {
            this.f5304f = r1;
            this.f5305g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((f) this.f5304f.getKey()).a(this.f5305g);
        }
    }

    static class c implements com.service.middleware.applog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingsConfigProvider f5306a;

        c(SettingsConfigProvider r1) {
            this.f5306a = r1;
        }
    }

    static {
        f5295c = new Handler(Looper.getMainLooper());
        f5296d = new ConcurrentHashMap();
        f5297e = new h();
        f5298f = new com.bytedance.news.common.settings.h.f();
        f5300h = 0;
        f5301i = 0;
        f5302j = false;
    }

    public e() {
    }

    static /* synthetic */ void a(boolean r0) {
        c(r0);
    }

    private static void b() {
        if (f5293a == true) goto L29;
        monitor-enter(e.class);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (f5293a == true) goto L23;
        SettingsConfigProvider r1 = (SettingsConfigProvider) com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class);     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        com.bytedance.news.common.settings.b r3 = r1.getConfig();     // Catch: Throwable -> L25
    L12:
        if (r3 == null) goto L14;
    L18:
        if (r3 == null) goto L23;
        r3.k("");     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.h.a.c(r3.a());     // Catch: Throwable -> L25
        f5299g = r3;     // Catch: Throwable -> L25
        ApplogService r2 = (ApplogService) com.bytedance.news.common.service.manager.d.a(ApplogService.class);     // Catch: Throwable -> L25
        if (r2 == null) goto L22;
        r2.registerHeaderCustomCallback(new c(r1));     // Catch: Throwable -> L25
    L22:
        f5293a = true;     // Catch: Throwable -> L25
        goto L23
    L14:
        if (f5294b == null) goto L16;
        r3 = f5294b.create();     // Catch: Throwable -> L25
    L17:
        f5294b = null;     // Catch: Throwable -> L25
        goto L18
    L16:
        r3 = null;
        goto L17
    L11:
        r3 = null;
    L23:
        monitor-exit(e.class);     // Catch: Throwable -> L25
    L29:
        if (f5299g == null) goto L32;
        return;
    L32:
        throw new IllegalStateException("SettingsManager尚未被配置");
    }

    private static void c(boolean r7) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class);
        if (r0 != null) goto L5;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L26;
        long r1 = System.currentTimeMillis();
        if (r7 == false) goto L14;
    L17:
        if (r7 == false) goto L19;
    L20:
        f5302j = true;
        f5301i = r1;
        com.bytedance.news.common.settings.g.b r8 = f5299g.d().b();
        if (r8 != null) goto L23;
    L25:
        f5302j = false;
        return;
    L23:
        if (r8.f5307a == false) goto L25;
        d(r8);
        f5300h = r1;
        goto L25
    L19:
        if ((r1 - f5301i) > f5299g.e()) goto L20;
        return;
    L14:
        if ((r1 - f5300h) > f5299g.i()) goto L16;
        return;
    L16:
        if (j.a(f5299g.a()) == true) goto L17;
        return;
    L26:
        if (r0 != null) goto L28;
        return;
    L28:
        if (r0.getConfig() == null) goto L41;
        com.bytedance.news.common.settings.g.d r9 = r0.getConfig().f();
        if (r9 == null) goto L42;
        r9.c("SettingsManager", "settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
        if (r9.a() == true) goto L35;
        return;
    L35:
        throw new IllegalStateException("settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
    L42:
        return;
    L41:
        return;
    L5:
        if (r0.getConfig() == null) goto L9;
        r3 = r0.getConfig().j();
        com.bytedance.news.common.settings.g.d r4 = r0.getConfig().f();
        if (r4 == null) goto L10;
        r4.c("SettingsManager", "isMainProcess = " + r3);
        goto L10
    }

    private static void d(com.bytedance.news.common.settings.g.b r4) {
        com.bytedance.news.common.settings.g.c r0 = r4.f5308b;
        if (r0 == null) goto L6;
        f5297e.d(r0, f5299g);
    L6:
        if (r4.f5309c == null) goto L8;
        com.bytedance.news.common.settings.g.i.a.b(com.bytedance.news.common.settings.h.a.b()).f(r4.f5309c);
    L8:
        com.bytedance.news.common.settings.g.h.a.c(com.bytedance.news.common.settings.h.a.b()).d(r4.f5310d);
        com.bytedance.news.common.settings.g.c r5 = com.bytedance.news.common.settings.h.e.c(com.bytedance.news.common.settings.h.a.b()).d(f5299g.c());
        if (r5 == null) goto L17;
        Iterator<Map.Entry<f, Boolean>> r1 = f5296d.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L24;
        Map.Entry<f, Boolean> r2 = r1.next();
        if (r2.getValue().booleanValue() == true) goto L15;
        r2.getKey().a(r5);
        goto L12
    L15:
        f5295c.post(new b(r2, r5));
        goto L12
    L24:
        return;
    }

    @NonNull
    public static <T> T e(Class<T> r3) {
        b();
        if (ISettings.class.isAssignableFrom(r3) == false) goto L7;
        return (T) f5297e.c(r3, f5299g, "");
    L7:
        if (ILocalSettings.class.isAssignableFrom(r3) == false) goto L11;
        return (T) f5298f.b(r3, f5299g, "");
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public static void f(f r1, boolean r2) {
        f5296d.put(r1, Boolean.valueOf(r2));
    }

    public static void g(boolean r2) {
        b();
        if (f5302j == false) goto L5;
        return;
    L5:
        f5299g.b().execute(new a(r2));
    }
}
