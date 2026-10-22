package com.bytedance.android.sdk.bdticketguard.n1;

import com.bytedance.android.sdk.bdticketguard.s0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f902a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f903b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f904c = null;

    static final class a extends q implements kotlin.n0.c.a<Map<Class<? extends d>, ? extends ThreadPoolExecutor>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f905f = null;

        static {
            f905f = new a();
        }

        a() {
            super(0);
        }

        public final Map<Class<? extends d>, ThreadPoolExecutor> a() {
            Set<Class<? extends d>> r10 = d.f884e.a();
            LinkedHashMap r0 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r10, 10)), 16));
            Iterator<T> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Object r1 = r11.next();
            Class r2 = (Class) r1;
            ThreadPoolExecutor r3 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
            r3.allowCoreThreadTimeOut(true);
            r0.put(r1, r3);
            goto L4
        L6:
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<Class<? extends d>, ? extends ThreadPoolExecutor> invoke() {
            return a();
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f906f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f907g;

        b(d r1, Class r2) {
            this.f906f = r1;
            this.f907g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.r().b().booleanValue() == true) goto L5;
        L7:
            s0.f1065a.e("InitTaskManager", "run init task: " + this.f907g + " with normal priority, source: " + this.f906f.d());
            this.f906f.b().invoke();
            return;
        L5:
            if (this.f906f.c() == false) goto L7;
            s0.f1065a.e("InitTaskManager", "run init task: " + this.f907g + " with high priority, source: " + this.f906f.d());
            j.a(this.f906f.b());
        }
    }

    static {
        f902a = new kotlin.s0.l[]{e0.g(new y(e0.b(i.class), "executors", "getExecutors()Ljava/util/Map;"))};
        f904c = new i();
        f903b = kotlin.i.b(a.f905f);
    }

    private i() {
    }

    private final Map<Class<? extends d>, ExecutorService> a() {
        kotlin.h r2 = f903b;
        kotlin.s0.l r0 = f902a[0];
        return (Map) r2.getValue();
    }

    public final void b(d r4) {
        o.g(r4, "task");
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.r().b().booleanValue() == true) goto L5;
    L7:
        s0.f1065a.e("InitTaskManager", "run init task: " + r4.getClass() + " with normal priority on demand, source: " + r4.d());
        r4.b().invoke();
        return;
    L5:
        if (r4.c() == false) goto L7;
        s0.f1065a.e("InitTaskManager", "run init task: " + r4.getClass() + " with high priority on demand, source: " + r4.d());
        j.a(r4.b());
    }

    public final synchronized void c(d r4) {
        monitor-enter(this);
        o.g(r4, "task");     // Catch: Throwable -> L11
        Class<?> r0 = r4.getClass();     // Catch: Throwable -> L11
        ExecutorService r1 = a().get(r0);     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.submit(new b(r4, r0));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        o.p();     // Catch: Throwable -> L11
        throw null;
    L11:
        th = move-exception;
        throw th;
    }
}
