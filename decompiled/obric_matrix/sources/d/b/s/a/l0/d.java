package d.b.s.a.l0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f14848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedList<Activity> f14849b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashSet<b> f14850c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f14851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f14852e = null;

    static class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            d.a().add(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
            d.a().remove(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
            d.c();
            if (d.b() != 1) goto L6;
            d.e();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
            d.d();
            if (d.b() != 0) goto L6;
            d.f();
            return;
        }
    }

    public static class b {
        public b() {
        }

        public void a() {
        }

        public void b() {
        }
    }

    static {
        f14849b = new LinkedList();
        f14850c = new HashSet();
        f14851d = 0;
        f14852e = new AtomicBoolean(false);
    }

    static /* synthetic */ LinkedList a() {
        return f14849b;
    }

    static /* synthetic */ int b() {
        return f14848a;
    }

    static /* synthetic */ int c() {
        int r0 = f14848a;
        f14848a = r0 + 1;
        return r0;
    }

    static /* synthetic */ int d() {
        int r0 = f14848a;
        f14848a = r0 - 1;
        return r0;
    }

    static /* synthetic */ void e() {
        m();
    }

    static /* synthetic */ void f() {
        l();
    }

    public static int g() {
        return f14849b.size();
    }

    public static long h() {
        if (f14851d > 0) goto L7;
        return -1;
    L7:
        return SystemClock.elapsedRealtime() - f14851d;
    }

    public static Activity i() {
        LinkedList<Activity> r0 = f14849b;
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        return r0.getLast();
    }

    public static void j(Application r3) {
        if (f14852e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        n();
        r3.registerActivityLifecycleCallbacks(new a());
    }

    public static boolean k() {
        if (f14848a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void l() {
        d.b.s.a.a0.a.a("AccountActivityStack", "notifyForeground");
        Iterator<b> r0 = f14850c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    }

    private static void m() {
        d.b.s.a.a0.a.a("AccountActivityStack", "notifyForeground");
        Iterator<b> r0 = f14850c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b();
        goto L4
    }

    private static void n() {
        if (f14851d <= 0) goto L5;
        return;
    L5:
        f14851d = SystemClock.elapsedRealtime();
    }
}
