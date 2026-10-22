package f.a.j.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f17131a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17132b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f17133c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f17134d = null;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f17135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17136b;

        a() {
        }

        void a(Properties r4) {
            if (r4.containsKey("rx2.purge-enabled") == false) goto L5;
            this.f17135a = Boolean.parseBoolean(r4.getProperty("rx2.purge-enabled"));
        L7:
            if (this.f17135a == true) goto L9;
        L12:
            this.f17136b = 1;
            return;
        L9:
            if (r4.containsKey("rx2.purge-period-seconds") == false) goto L12;
            this.f17136b = Integer.parseInt(r4.getProperty("rx2.purge-period-seconds"));     // Catch: NumberFormatException -> L14
            return;
        L5:
            this.f17135a = true;
            goto L7
        }
    }

    static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r2 = new ArrayList(i.f17134d.keySet()).iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            ScheduledThreadPoolExecutor r0 = (ScheduledThreadPoolExecutor) r2.next();
            if (r0.isShutdown() == true) goto L7;
            r0.purge();
            goto L4
        L7:
            i.f17134d.remove(r0);
            goto L4
        }
    }

    static {
        f17133c = new AtomicReference();
        f17134d = new ConcurrentHashMap();
        Properties r0 = System.getProperties();
        a r1 = new a();
        r1.a(r0);
        f17131a = r1.f17135a;
        f17132b = r1.f17136b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory r1) {
        ScheduledExecutorService r2 = Executors.newScheduledThreadPool(1, r1);
        c(f17131a, r2);
        return r2;
    }

    public static void b() {
        d(f17131a);
    }

    static void c(boolean r1, ScheduledExecutorService r2) {
        if (r1 == true) goto L4;
        return;
    L4:
        if ((r2 instanceof ScheduledThreadPoolExecutor) == false) goto L8;
        Map<ScheduledThreadPoolExecutor, Object> r0 = f17134d;
        r0.put((ScheduledThreadPoolExecutor) r2, r2);
        return;
    }

    static void d(boolean r11) {
        if (r11 == false) goto L11;
    L3:
        AtomicReference<ScheduledExecutorService> r12 = f17133c;
        ScheduledExecutorService r0 = r12.get();
        if (r0 != null) goto L5;
        ScheduledExecutorService r4 = Executors.newScheduledThreadPool(1, new f("RxSchedulerPurge"));
        if (r12.compareAndSet(r0, r4) == true) goto L8;
        r4.shutdownNow();
        goto L3
    L8:
        b r5 = new b();
        int r13 = f17132b;
        r4.scheduleAtFixedRate(r5, r13, r13, TimeUnit.SECONDS);
        return;
    L5:
        return;
    }
}
