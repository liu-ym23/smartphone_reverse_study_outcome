package c;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f426c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f428b;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    private static class ExecutorC0027b implements Executor {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ThreadLocal<Integer> f429f;

        private ExecutorC0027b() {
            this.f429f = new ThreadLocal();
        }

        /* synthetic */ ExecutorC0027b(a r1) {
            this();
        }

        private int a() {
            Integer r0 = this.f429f.get();
            if (r0 != null) goto L5;
            r0 = 0;
        L5:
            int r1 = r0.intValue() - 1;
            ThreadLocal<Integer> r2 = this.f429f;
            if (r1 != 0) goto L8;
            r2.remove();
        L9:
            return r1;
        L8:
            r2.set(Integer.valueOf(r1));
            goto L9
        }

        private int b() {
            Integer r0 = this.f429f.get();
            if (r0 != null) goto L5;
            r0 = 0;
        L5:
            int r1 = r0.intValue() + 1;
            this.f429f.set(Integer.valueOf(r1));
            return r1;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            if (b() > 15) goto L5;
            r3.run();     // Catch: Throwable -> L8
        L6:
            a();
            return;
        L5:
            b.a().execute(r3);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            a();
            throw th;
        }
    }

    static {
        f426c = new b();
    }

    private b() {
        if (c() == true) goto L5;
        ExecutorService r0 = Executors.newCachedThreadPool();
    L6:
        this.f427a = r0;
        Executors.newSingleThreadScheduledExecutor();
        this.f428b = new ExecutorC0027b(null);
        return;
    L5:
        r0 = c.a.b();
        goto L6
    }

    public static ExecutorService a() {
        return f426c.f427a;
    }

    static Executor b() {
        return f426c.f428b;
    }

    private static boolean c() {
        String r0 = System.getProperty("java.runtime.name");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.US).contains("android");
    }
}
