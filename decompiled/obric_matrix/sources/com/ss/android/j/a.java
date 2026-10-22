package com.ss.android.j;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.badger.Badger;
import com.bytedance.badger.k.e;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.d;
import com.ss.android.i.j;
import com.ss.android.token.m;
import d.b.s.a.i;
import d.b.s.a.l0.h;
import d.b.s.a.l0.l;
import d.b.s.a.q.c;
import d.b.s.a.q.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import kotlin.u0.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static f f11950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static AtomicBoolean f11951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f11952h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f11953i = null;

    /* JADX INFO: renamed from: com.ss.android.j.a$a, reason: collision with other inner class name */
    public static final class C0310a implements com.bytedance.badger.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0310a f11954a = null;

        /* JADX INFO: renamed from: com.ss.android.j.a$a$a, reason: collision with other inner class name */
        static final class C0311a extends q implements kotlin.n0.c.a<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0311a f11955f = null;

            static {
                f11955f = new C0311a();
            }

            C0311a() {
                super(0);
            }

            public final String a() {
                com.ss.android.d r0 = j.l();
                if (r0 == null) goto L9;
                h r1 = r0.b();
                if (r1 == null) goto L9;
                String r2 = r1.getDeviceId();
                if (r2 == null) goto L9;
                return r2;
            L9:
                return "";
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: com.ss.android.j.a$a$b */
        public static final class b implements com.bytedance.badger.c {
            b() {
            }

            @Override // com.bytedance.badger.c
            public void a(String r1, String r2) {
                o.g(r1, LocationMonitorConst.TAG);
                o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
                d.b.s.a.a0.a.a(r1, r2);
            }

            @Override // com.bytedance.badger.c
            public void b(String r1, String r2) {
                o.g(r1, LocationMonitorConst.TAG);
                o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
                d.b.s.a.a0.a.d(r1, r2);
            }

            @Override // com.bytedance.badger.c
            public void c(String r1, String r2) {
                o.g(r1, LocationMonitorConst.TAG);
                o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
                d.b.s.a.a0.a.b(r1, r2);
            }

            @Override // com.bytedance.badger.c
            public void d(String r1, String r2) {
                o.g(r1, LocationMonitorConst.TAG);
                o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
                d.b.s.a.a0.a.h(r1, r2);
            }

            @Override // com.bytedance.badger.c
            public void e(String r1, String r2, Throwable r3) {
                o.g(r1, LocationMonitorConst.TAG);
                o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
                d.b.s.a.a0.a.c(r1, r2, r3);
            }

            @Override // com.bytedance.badger.c
            public void e(String r1, JSONObject r2) {
                o.g(r1, NotificationCompat.CATEGORY_EVENT);
                o.g(r2, "params");
                com.bytedance.sdk.account.monitor.a.c(r1, r2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.j.a$a$c */
        public static final class c implements com.bytedance.badger.k.b {
            c() {
            }

            @Override // com.bytedance.badger.k.b
            public com.bytedance.badger.k.f a(e r7) {
                o.g(r7, "request");
                String r6 = r7.c();
                Map<String, String> r0 = r7.a();
                List<u<String, String>> r8 = r7.b();
                ArrayList r1 = new ArrayList(r.q(r8, 10));
                Iterator<T> r9 = r8.iterator();
            L4:
                if (r9.hasNext() == false) goto L6;
                u r3 = (u) r9.next();
                r1.add(new com.ss.android.f((String) r3.c(), (String) r3.d()));
                goto L4
            L6:
                com.ss.android.h r10 = l.d(Integer.MAX_VALUE, r6, r0, r1, 0);
                o.b(r10, "ret");
                boolean r11 = r10.f();
                int r2 = r10.c();
                List<com.ss.android.f> r4 = r10.b();
                if (r4 == null) goto L12;
                List r5 = new ArrayList(r.q(r4, 10));
                Iterator<T> r12 = r4.iterator();
            L10:
                if (r12.hasNext() == false) goto L13;
                com.ss.android.f r13 = (com.ss.android.f) r12.next();
                o.b(r13, "it");
                r5.add(a0.a(r13.a(), r13.b()));
            L13:
                String r14 = r10.a();
                o.b(r14, "ret.body");
                return new com.bytedance.badger.k.f(r11, r2, r5, r14);
            L12:
                r5 = r.g();
                goto L13
            }

            @Override // com.bytedance.badger.k.b
            public String b() {
                com.ss.android.d r0 = j.l();
                if (r0 == null) goto L7;
                String r1 = r0.c();
                if (r1 == null) goto L7;
                return r1;
            L7:
                return "";
            }
        }

        /* JADX INFO: renamed from: com.ss.android.j.a$a$d */
        static final class d extends q implements kotlin.n0.c.a<com.bytedance.badger.k.d> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final d f11956f = null;

            static {
                f11956f = new d();
            }

            d() {
                super(0);
            }

            public final com.bytedance.badger.k.d a() {
                com.ss.android.d r2 = j.l();
                List<String> r0 = null;
                if (r2 == null) goto L5;
                i r3 = r2.d();
            L6:
                if (r3 == null) goto L8;
                List<String> r1 = r3.c();
            L9:
                if (r3 == null) goto L12;
                r0 = r3.a();
            L12:
                if (r1 != null) goto L15;
                r1 = r.g();
            L15:
                if (r0 != null) goto L19;
                r0 = r.g();
            L19:
                return new com.bytedance.badger.k.d(r1, r0);
            L8:
                r1 = null;
                goto L9
            L5:
                r3 = null;
                goto L6
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ com.bytedance.badger.k.d invoke() {
                return a();
            }
        }

        static {
            f11954a = new C0310a();
        }

        private C0310a() {
        }

        @Override // com.bytedance.badger.a
        public com.bytedance.badger.c a() {
            return new b();
        }

        @Override // com.bytedance.badger.a
        public kotlin.n0.c.a<com.bytedance.badger.k.d> b() {
            return d.f11956f;
        }

        @Override // com.bytedance.badger.a
        public kotlin.n0.c.a<String> c() {
            return C0311a.f11955f;
        }

        @Override // com.bytedance.badger.a
        public Context getContext() {
            Context r1 = j.j();
            o.b(r1, "TTAccountInit.getApplicationContext()");
            return r1;
        }

        @Override // com.bytedance.badger.a
        public com.bytedance.badger.k.b getNetRequestInterface() {
            return new c();
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f11957f = null;

        static {
            f11957f = new b();
        }

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = a.f11953i;     // Catch: Exception -> L14
            f r1 = a.a(r0);     // Catch: Exception -> L14
            if (r1 != null) goto L6;
        L8:
            f r2 = a.a(r0);     // Catch: Exception -> L14
            if (r2 == null) goto L11;
            boolean r3 = r2.m();     // Catch: Exception -> L14
        L12:
            d.b.s.a.a0.a.a("AccountBadger", "doDelayInitTask, login is " + r3 + ", start periodic report");     // Catch: Exception -> L14
            Badger.INSTANCE.startPeriodicReport(r3);     // Catch: Exception -> L14
            return;
        L11:
            r3 = false;
            goto L12
        L6:
            if (r1.m() != true) goto L8;
            d.b.s.a.a0.a.a("AccountBadger", "doDelayInitTask, login is true, check unfinished tasks");     // Catch: Exception -> L14
            Badger.INSTANCE.checkUnfinishedTasks();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            d.b.s.a.a0.a.c("AccountBadger", "doDelayInitTask, checkUnfinishedTasks failed", e);
        }
    }

    static {
        f11953i = new a();
        f11951g = new AtomicBoolean(false);
        f11952h = new AtomicBoolean(false);
    }

    private a() {
    }

    public static final /* synthetic */ f a(a r0) {
        return f11950f;
    }

    public static final void b() {
        if (com.bytedance.sdk.account.settings.f.a.j() == true) goto L6;
        return;
    L6:
        if (f11951g.compareAndSet(false, true) == false) goto L9;
        com.bytedance.common.utility.m.c.c(b.f11957f);
        return;
    }

    public static final void c(String r6, String r7, List<m> r8, List<m> r9) {
        if (com.bytedance.sdk.account.settings.f.a.j() == true) goto L6;
        return;
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L17;
        String r10 = "handleRequest, url is null";
    L15:
        d.b.s.a.a0.a.b("AccountBadger", r10);
        return;
    L17:
        if (r7 != null) goto L19;
    L23:
        Badger r11 = Badger.INSTANCE;
        if (r11.isInitialized() == true) goto L27;
        r10 = "handleRequest, Badger not initialized";
        goto L15
    L27:
        if (r8 == null) goto L32;
        List<u<String, String>> r1 = new ArrayList(r.q(r8, 10));
        Iterator<T> r12 = r8.iterator();
    L30:
        if (r12.hasNext() == false) goto L33;
        m r3 = (m) r12.next();
        r1.add(a0.a(r3.a(), r3.b()));
    L33:
        if (r9 == null) goto L38;
        List<u<String, String>> r13 = new ArrayList(r.q(r9, 10));
        Iterator<T> r14 = r9.iterator();
    L36:
        if (r14.hasNext() == false) goto L39;
        m r0 = (m) r14.next();
        r13.add(a0.a(r0.a(), r0.b()));
    L39:
        r11.handleResponse(r6, r1, r13);
        return;
    L38:
        r13 = r.g();
        goto L39
    L32:
        r1 = r.g();
        goto L33
    L19:
        if (k.A(r7, "/passport/", false, 2, null) == false) goto L23;
        if (f11952h.compareAndSet(false, true) == false) goto L23;
        f11953i.g();
        goto L23
    L8:
        if (r6.length() == 0) goto L11;
        r2 = false;
        goto L13
    }

    public static final void d() {
        if (com.bytedance.sdk.account.settings.f.a.j() == true) goto L5;
        return;
    L5:
        a r0 = f11953i;
        monitor-enter(r0);
        d r1 = j.l();     // Catch: Throwable -> L18
        JSONObject r2 = null;
        if (r1 == null) goto L10;
        Context r3 = r1.e();     // Catch: Throwable -> L18
    L11:
        if (r3 == null) goto L13;
        d.b.s.a.d0.r.a r4 = g.b(r3);     // Catch: Throwable -> L18
        o.b(r4, "BDAccountDelegateInner.getSettingsInstance(it)");     // Catch: Throwable -> L18
        r2 = r4.b();     // Catch: Throwable -> L18
    L13:
        if (r2 == null) goto L15;
        JSONObject r5 = r2.optJSONObject("badger_config");     // Catch: Throwable -> L18
        d.b.s.a.a0.a.d("AccountBadger", "onAccountSettingsUpdate, settings changed: " + r5);     // Catch: Throwable -> L18
        Badger.INSTANCE.updateConfig(r5);     // Catch: Throwable -> L18
    L15:
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L10:
        r3 = null;
    L18:
        th = move-exception;
        throw th;
    }

    private final void e() {
        d.b.s.a.a0.a.d("AccountBadger", "onLogout");
        Badger.INSTANCE.invalidateRecord();
    }

    public static final void f() {
        if (com.bytedance.sdk.account.settings.f.a.j() == true) goto L6;
        return;
    L6:
        if (f11952h.compareAndSet(false, true) == false) goto L9;
        f11953i.g();
        return;
    }

    private final void g() {
        d.b.s.a.a0.a.a("AccountBadger", "onSdkInit");
        Context r0 = j.k().e();
        if (r0 != null) goto L6;
        d.b.s.a.a0.a.b("AccountBadger", "onSdkInitReal, context is null");
        return;
    L6:
        f r1 = g.d(r0);
        if (r1 == null) goto L9;
        r1.b(f11953i);
        f11950f = r1;
    L9:
        d();
        d.b.s.a.a0.a.a("AccountBadger", "init badger start");
        Badger.INSTANCE.init(C0310a.f11954a);
    }

    @Override // d.b.s.a.q.c
    public void F(d.b.s.a.q.b r2) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        if (com.bytedance.sdk.account.settings.f.a.j() == true) goto L6;
        return;
    L6:
        if (r2.f14879a != 1) goto L16;
        f r3 = f11950f;
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.m() == true) goto L15;
        e();
        return;
    L15:
        return;
    }
}
