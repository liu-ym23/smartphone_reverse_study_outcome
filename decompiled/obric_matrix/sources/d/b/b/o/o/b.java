package d.b.b.o.o;

import d.b.b.o.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<c, b> f13061d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f13062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<d.b.b.o.o.a, ScheduledFuture> f13063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<d.b.b.o.o.a, Runnable> f13064c;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: d.b.b.o.o.b$b, reason: collision with other inner class name */
    private class RunnableC0346b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d.b.b.o.o.a f13065f;

        private RunnableC0346b(b r1, d.b.b.o.o.a r2) {
            this.f13065f = r2;
        }

        /* synthetic */ RunnableC0346b(b r1, d.b.b.o.o.a r2, a r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a("APM-Task");
            this.f13065f.run();     // Catch: Throwable -> L5
        L7:
            j.b();
            return;
        L5:
            th = move-exception;
            d.b.b.o.m.b.c("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
            goto L7
        }
    }

    static {
        f13061d = new HashMap();
    }

    private b(String r3) {
        this.f13063b = new ConcurrentHashMap();
        this.f13064c = new ConcurrentHashMap();
        this.f13062a = new ScheduledThreadPoolExecutor(1, new d(r3));
    }

    public static synchronized b a(c r3) {
        monitor-enter(b.class);
        if (r3 == null) goto L13;
        b r1 = f13061d.get(r3);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new b(r3.name());     // Catch: Throwable -> L10
        f13061d.put(r3, r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);
        return r1;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void b(d.b.b.o.o.a r3) {
        Runnable r0 = this.f13064c.remove(r3);     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        this.f13062a.remove(r0);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r2 = this.f13063b.remove(r3);     // Catch: Throwable -> L9
        if (r2 == null) goto L14;
        r2.cancel(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        d.b.b.o.m.b.c("APM-AsyncTask", "removeTask failed", th);
    }

    public void c(d.b.b.o.o.a r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        RunnableC0346b r7 = new RunnableC0346b(this, r9, null);     // Catch: Throwable -> L10
        if (r9.d() == false) goto L7;
        ScheduledFuture<?> r0 = this.f13062a.scheduleWithFixedDelay(r7, r9.b(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f13064c.put(r9, r7);     // Catch: Throwable -> L10
        this.f13063b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f13062a.schedule(r7, r9.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.b.b.o.m.b.c("APM-AsyncTask", "sendTask failed.", th);
    }
}
