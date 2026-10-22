package d.c.i.p;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f16443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f16444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f16445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d.c.i.l.e f16447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f16448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    g f16449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f16450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f16451j;

    class a extends d.c.c.b.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f16452f;

        a(v r1, int r2) {
            this.f16452f = r1;
            super(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(this.f16452f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f16453f;

        b(v r1) {
            this.f16453f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(this.f16453f);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f16454f;

        c(v r1) {
            this.f16454f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.b(this.f16454f);
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16455a = null;

        static {
            int[] r0 = new int[g.values().length];
            f16455a = r0;
            r0[g.f16457f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f16455a[g.f16458g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f16455a[g.f16459h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f16455a[g.f16460i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface e {
        void a(d.c.i.l.e r1, int r2);
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ScheduledExecutorService f16456a;

        static ScheduledExecutorService a() {
            if (f16456a != null) goto L6;
            f16456a = Executors.newSingleThreadScheduledExecutor();
        L6:
            return f16456a;
        }
    }

    static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f16457f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f16458g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final g f16459h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final g f16460i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ g[] f16461j = null;

        static {
            g r0 = new g("IDLE", 0);
            f16457f = r0;
            g r1 = new g("QUEUED", 1);
            f16458g = r1;
            g r3 = new g("RUNNING", 2);
            f16459h = r3;
            g r5 = new g("RUNNING_AND_PENDING", 3);
            f16460i = r5;
            f16461j = new g[]{r0, r1, r3, r5};
        }

        private g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r1) {
            return (g) Enum.valueOf(g.class, r1);
        }

        public static g[] values() {
            return (g[]) f16461j.clone();
        }
    }

    public static abstract class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d.c.i.f.e f16462a;

        public h(d.c.i.f.e r1) {
            this.f16462a = r1;
        }

        public d.c.i.f.e b() {
            return this.f16462a;
        }
    }

    public v(Executor r1, e r2, int r3) {
        this.f16442a = r1;
        this.f16443b = r2;
        this.f16446e = r3;
        if ((r2 instanceof h) == false) goto L5;
        Runnable r4 = new a(this, d.c.i.f.e.b(((h) r2).b()));
    L6:
        this.f16444c = r4;
        this.f16445d = new c(this);
        this.f16447f = null;
        this.f16448g = 0;
        this.f16449h = g.f16457f;
        this.f16450i = 0;
        this.f16451j = 0;
        return;
    L5:
        r4 = new b(this);
        goto L6
    }

    static /* synthetic */ void a(v r0) {
        r0.d();
    }

    static /* synthetic */ void b(v r0) {
        r0.j();
    }

    private void d() {
        long r0 = SystemClock.uptimeMillis();
        monitor-enter(this);
        d.c.i.l.e r2 = this.f16447f;     // Catch: Throwable -> L14
        int r3 = this.f16448g;     // Catch: Throwable -> L14
        this.f16447f = null;     // Catch: Throwable -> L14
        this.f16448g = 0;     // Catch: Throwable -> L14
        this.f16449h = g.f16459h;     // Catch: Throwable -> L14
        this.f16451j = r0;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        d.c.i.l.e.g(r2);
        g();
        throw th;
    L7:
        if (i(r2, r3) == false) goto L9;
        this.f16443b.a(r2, r3);     // Catch: Throwable -> L11
    L9:
        d.c.i.l.e.g(r2);
        g();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void e(long r3) {
        if (r3 <= 0) goto L5;
        f.a().schedule(this.f16445d, r3, TimeUnit.MILLISECONDS);
        return;
    L5:
        this.f16445d.run();
    }

    private void g() {
        long r0 = SystemClock.uptimeMillis();
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f16449h != g.f16460i) goto L7;
        long r2 = Math.max(this.f16451j + ((long) this.f16446e), r0);     // Catch: Throwable -> L12
        boolean r4 = true;
        this.f16450i = r0;     // Catch: Throwable -> L12
        this.f16449h = g.f16458g;     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r4 == false) goto L17;
        e(r2 - r0);
        return;
    L17:
        return;
    L7:
        this.f16449h = g.f16457f;     // Catch: Throwable -> L12
        r2 = 0;
        r4 = false;
        goto L8
    }

    private static boolean i(d.c.i.l.e r1, int r2) {
        if (d.c.i.p.b.e(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (d.c.i.p.b.n(r2, 4) == true) goto L10;
        if (d.c.i.l.e.q0(r1) == true) goto L10;
        return false;
    }

    private void j() {
        this.f16442a.execute(this.f16444c);
    }

    public void c() {
        monitor-enter(this);
        d.c.i.l.e r0 = this.f16447f;     // Catch: Throwable -> L7
        this.f16447f = null;     // Catch: Throwable -> L7
        this.f16448g = 0;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        d.c.i.l.e.g(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized long f() {
        monitor-enter(this);
        long r0 = this.f16451j - this.f16450i;
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean h() {
        long r0 = SystemClock.uptimeMillis();
        monitor-enter(this);
        boolean r3 = false;
        if (i(this.f16447f, this.f16448g) == true) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L8:
        int r2 = d.f16455a[this.f16449h.ordinal()];     // Catch: Throwable -> L20
        if (r2 != 1) goto L11;
        long r5 = Math.max(this.f16451j + ((long) this.f16446e), r0);     // Catch: Throwable -> L20
        this.f16450i = r0;     // Catch: Throwable -> L20
        this.f16449h = g.f16458g;     // Catch: Throwable -> L20
        r3 = true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r3 == false) goto L19;
        e(r5 - r0);
    L19:
        return true;
    L11:
        if (r2 != 3) goto L14;
        this.f16449h = g.f16460i;     // Catch: Throwable -> L20
    L14:
        r5 = 0;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean k(d.c.i.l.e r2, int r3) {
        if (i(r2, r3) == true) goto L6;
        return false;
    L6:
        monitor-enter(this);
        d.c.i.l.e r0 = this.f16447f;     // Catch: Throwable -> L11
        this.f16447f = d.c.i.l.e.b(r2);     // Catch: Throwable -> L11
        this.f16448g = r3;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        d.c.i.l.e.g(r0);
        return true;
    L11:
        th = move-exception;
        throw th;
    }
}
