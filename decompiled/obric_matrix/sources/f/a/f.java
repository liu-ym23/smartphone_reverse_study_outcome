package f.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    static final class a implements f.a.g.b, Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Runnable f17041f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final b f17042g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Thread f17043h;

        a(Runnable r1, b r2) {
            this.f17041f = r1;
            this.f17042g = r2;
        }

        @Override // f.a.g.b
        public void dispose() {
            if (this.f17043h != Thread.currentThread()) goto L7;
            b r0 = this.f17042g;
            if ((r0 instanceof f.a.j.d.e) == false) goto L7;
            ((f.a.j.d.e) r0).e();
            return;
        L7:
            this.f17042g.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17043h = Thread.currentThread();
            this.f17041f.run();     // Catch: Throwable -> L6
            dispose();
            this.f17043h = null;
            return;
        L6:
            th = move-exception;
            dispose();
            this.f17043h = null;
            throw th;
        }
    }

    public static abstract class b implements f.a.g.b {
        public b() {
        }

        public long a(TimeUnit r3) {
            return r3.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public abstract f.a.g.b b(Runnable r1, long r2, TimeUnit r4);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public f() {
    }

    public abstract b a();

    public f.a.g.b b(Runnable r4) {
        return c(r4, 0, TimeUnit.NANOSECONDS);
    }

    public f.a.g.b c(Runnable r2, long r3, TimeUnit r5) {
        b r1 = a();
        a r0 = new a(f.a.k.a.n(r2), r1);
        r1.b(r0, r3, r5);
        return r0;
    }
}
