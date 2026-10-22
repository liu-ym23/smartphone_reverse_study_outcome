package d.b.h.a.a.d;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<d, c> f13246e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<d.b.h.a.a.d.b, ScheduledFuture> f13247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<d.b.h.a.a.d.b, Runnable> f13248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f13249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f13250d;

    static /* synthetic */ class a {
    }

    private static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d.b.h.a.a.d.b f13251f;

        private b(d.b.h.a.a.d.b r1) {
            this.f13251f = r1;
        }

        /* synthetic */ b(d.b.h.a.a.d.b r1, a r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            System.currentTimeMillis();     // Catch: Throwable -> L6
            this.f13251f.run();     // Catch: Throwable -> L6
            Logger.debug();     // Catch: Throwable -> L6
            if (this.f13251f.isLoop() == true) goto L12;
        L8:
            c.c(this.f13251f.getTaskType()).b().remove(this.f13251f);
            c.c(this.f13251f.getTaskType()).a().remove(this.f13251f);
            return;
        L12:
            return;
        L7:
            if (this.f13251f.isLoop() == false) goto L8;
        }
    }

    static {
        f13246e = new ConcurrentHashMap();
    }

    private c(d r3) {
        this.f13247a = new ConcurrentHashMap();
        this.f13248b = new ConcurrentHashMap();
        this.f13249c = r3;
        this.f13250d = new ScheduledThreadPoolExecutor(1, new e(r3.name()));
    }

    public static c c(d r3) {
        if (r3 == null) goto L18;
        ConcurrentHashMap<d, c> r0 = f13246e;
        if (r0.get(r3) != null) goto L16;
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r0.get(r3) != null) goto L10;
        r0.put(r3, new c(r3));     // Catch: Throwable -> L12
    L10:
        monitor-exit(c.class);     // Catch: Throwable -> L12
    L16:
        return r0.get(r3);
    L18:
        throw new IllegalArgumentException("unsupported async task type");
    }

    public ConcurrentHashMap<?, ?> a() {
        return this.f13247a;
    }

    public ConcurrentHashMap<?, ?> b() {
        return this.f13248b;
    }

    public void d(d.b.h.a.a.d.b r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setTaskType(this.f13249c);
        b r0 = new b(r9, null);     // Catch: Throwable -> L11
        if (r9.isLoop() == false) goto L8;
        ScheduledFuture<?> r1 = this.f13250d.scheduleWithFixedDelay(r0, r9.getInitialDelay(), r9.getLoopInterval(), r9.getTimeUnit());     // Catch: Throwable -> L11
    L9:
        this.f13248b.put(r9, r0);     // Catch: Throwable -> L11
        this.f13247a.put(r9, r1);     // Catch: Throwable -> L11
        return;
    L8:
        r1 = this.f13250d.schedule(r0, r9.getInitialDelay(), r9.getTimeUnit());     // Catch: Throwable -> L11
    }

    public void e(d.b.h.a.a.d.b r3) {
        Runnable r0 = this.f13248b.remove(r3);     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        this.f13250d.remove(r0);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r2 = this.f13247a.remove(r3);     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        r2.cancel(true);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }
}
