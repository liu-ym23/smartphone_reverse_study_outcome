package d.b.s.a.c0.a;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static AtomicInteger n;
    private static volatile f o;
    private static volatile boolean p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f14693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<e> f14696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue<e> f14697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PriorityBlockingQueue<e> f14698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a[] f14699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d[] f14700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f14701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f14702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f14703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f14704l;
    private volatile long m;

    static {
        n = new AtomicInteger();
        p = true;
    }

    public f() {
        this(4, 4, true);
    }

    public f(int r3, int r4, boolean r5) {
        this.f14693a = false;
        this.f14696d = new PriorityBlockingQueue();
        this.f14697e = new PriorityBlockingQueue();
        this.f14698f = new PriorityBlockingQueue();
        this.f14702j = 0;
        this.f14703k = 0;
        this.f14704l = 0;
        this.m = 0;
        this.f14694b = r3;
        this.f14699g = new a[r3 * 4];
        if (r5 == false) goto L6;
        this.f14695c = r4;
        this.f14700h = new d[r4 * 4];
        return;
    }

    public f(boolean r3) {
        this(4, 0, r3);
    }

    public static f c() {
        if (o != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (o != null) goto L9;
        o = new f(false);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return o;
    }

    public static int d() {
        return n.incrementAndGet();
    }

    public synchronized void a(c r3) {
        monitor-enter(this);
        if (r3 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
        r3.t(d());     // Catch: Throwable -> L20
        if (this.f14693a == true) goto L10;
        i();     // Catch: Throwable -> L20
    L10:
        if (r3.p() == false) goto L14;
        PriorityBlockingQueue<e> r0 = this.f14696d;     // Catch: Throwable -> L20
    L12:
        r0.add(r3);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L14:
        if (r3.b() != e.a.f14691i) goto L16;
        com.bytedance.common.utility.m.c.c(r3);     // Catch: Throwable -> L20
        goto L18
    L16:
        r3.s();     // Catch: Throwable -> L20
        r0 = this.f14697e;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized void b(c r3) {
        monitor-enter(this);
        if (r3 != null) goto L18;
        monitor-exit(this);
        return;
    L18:
        r3.t(d());     // Catch: Throwable -> L15
        if (this.f14693a == true) goto L10;
        i();     // Catch: Throwable -> L15
    L10:
        if (r3.b() != e.a.f14691i) goto L12;
        com.bytedance.common.utility.m.c.c(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L12:
        r3.r();     // Catch: Throwable -> L15
        this.f14698f.add(r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void e() {
        monitor-enter(this);
        if (p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        d.b.s.a.a0.a.a("RequestQueue", "handleExpandDownloadRequestQueueSize");     // Catch: Throwable -> L32
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L32
        if (this.f14703k <= r0) goto L11;
        this.f14703k = r0;     // Catch: Throwable -> L32
    L11:
        if ((r0 - this.f14703k) > 1000) goto L15;
        d.b.s.a.a0.a.a("RequestQueue", "handleExpandDownloadRequestQueueSize (now - mLastExpandDownloadRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L15:
        this.f14703k = r0;     // Catch: Throwable -> L32
        if (this.f14700h != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r1 = 0;
        int r2 = 0;
    L20:
        d[] r3 = this.f14700h;     // Catch: Throwable -> L32
        if (r1 >= r3.length) goto L30;
        if (r3[r1] != null) goto L29;
        r2 = r2 + 1;     // Catch: Throwable -> L32
        if (r2 > this.f14695c) goto L30;
        d r4 = new d(this.f14698f, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");     // Catch: Throwable -> L32
        d.b.s.a.a0.a.a("RequestQueue", "downloadDispatcher : " + r4.toString() + " create");     // Catch: Throwable -> L32
        this.f14700h[r1] = r4;     // Catch: Throwable -> L32
        r4.start();     // Catch: Throwable -> L32
    L29:
        r1 = r1 + 1;
    L30:
        monitor-exit(this);
    }

    public synchronized void f() {
        monitor-enter(this);
        if (p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        d.b.s.a.a0.a.a("RequestQueue", "handleExpandRequestQueueSize");     // Catch: Throwable -> L28
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L28
        if (this.f14702j <= r0) goto L11;
        this.f14702j = r0;     // Catch: Throwable -> L28
    L11:
        if ((r0 - this.f14702j) > 1000) goto L15;
        d.b.s.a.a0.a.a("RequestQueue", "handleExpandRequestQueueSize (now - mLastExpandRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L15:
        this.f14702j = r0;     // Catch: Throwable -> L28
        int r1 = 0;
        int r2 = 0;
    L16:
        a[] r3 = this.f14699g;     // Catch: Throwable -> L28
        if (r1 >= r3.length) goto L26;
        if (r3[r1] != null) goto L25;
        r2 = r2 + 1;     // Catch: Throwable -> L28
        if (r2 > this.f14694b) goto L26;
        a r4 = new a(this.f14697e, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L28
        d.b.s.a.a0.a.a("RequestQueue", "apiDispatcher : " + r4.toString() + " create");     // Catch: Throwable -> L28
        this.f14699g[r1] = r4;     // Catch: Throwable -> L28
        r4.start();     // Catch: Throwable -> L28
    L25:
        r1 = r1 + 1;
    L26:
        monitor-exit(this);
    }

    public synchronized void g() {
        monitor-enter(this);
        if (p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize");     // Catch: Throwable -> L51
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (this.m <= r0) goto L11;
        this.m = r0;     // Catch: Throwable -> L51
    L11:
        if ((r0 - this.m) > 2000) goto L15;
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize (now - mLastShrinkDownloadRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L15:
        d[] r2 = this.f14700h;     // Catch: Throwable -> L51
        if (r2 != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r3 = r2.length - 1;     // Catch: Throwable -> L51
        boolean r4 = true;
        boolean r5 = true;
    L21:
        if (r3 < this.f14695c) goto L30;
        d r6 = this.f14700h[r3];     // Catch: Throwable -> L51
        if (r6 != null) goto L25;
    L27:
        if (r6 == null) goto L29;
        r5 = false;
    L29:
        r3 = r3 - 1;     // Catch: Throwable -> L51
        goto L21
    L25:
        if (r6.c() == false) goto L27;
        r4 = false;
        goto L27
    L30:
        this.m = r0;     // Catch: Throwable -> L51
        if (r4 == false) goto L45;
        if (r5 == true) goto L45;
        int r1 = this.f14700h.length - 1;     // Catch: Throwable -> L51
    L36:
        if (r1 < this.f14695c) goto L48;
        d r7 = this.f14700h[r1];     // Catch: Throwable -> L50
        if (r7 == null) goto L44;
        if (r7.getState() == Thread.State.RUNNABLE) goto L44;
        if (r7.c() == true) goto L44;
        d.b.s.a.a0.a.a("RequestQueue", "apiDispatcher : " + r7.toString() + " quit");     // Catch: Throwable -> L50
        r7.e();     // Catch: Throwable -> L50
        this.f14700h[r1] = null;     // Catch: Throwable -> L50
    L44:
        r1 = r1 - 1;
    L45:
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize shouldShrink " + r4 + " allNull = " + r5);     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L48:
        monitor-exit(this);
    }

    public synchronized void h() {
        monitor-enter(this);
        if (p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkRequestQueueSize");     // Catch: Throwable -> L47
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L47
        if (this.f14704l <= r0) goto L11;
        this.f14704l = r0;     // Catch: Throwable -> L47
    L11:
        if ((r0 - this.f14704l) > 2000) goto L15;
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkRequestQueueSize (now - mLastShrinkRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L15:
        int r2 = this.f14699g.length - 1;     // Catch: Throwable -> L47
        boolean r4 = true;
        boolean r5 = true;
    L17:
        if (r2 < this.f14694b) goto L26;
        a r6 = this.f14699g[r2];     // Catch: Throwable -> L47
        if (r6 != null) goto L21;
    L23:
        if (r6 == null) goto L25;
        r5 = false;
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L47
        goto L17
    L21:
        if (r6.c() == false) goto L23;
        r4 = false;
        goto L23
    L26:
        this.f14704l = r0;     // Catch: Throwable -> L47
        if (r4 == false) goto L41;
        if (r5 == true) goto L41;
        int r1 = this.f14699g.length - 1;     // Catch: Throwable -> L47
    L32:
        if (r1 < this.f14694b) goto L44;
        a r3 = this.f14699g[r1];     // Catch: Throwable -> L46
        if (r3 == null) goto L40;
        if (r3.getState() == Thread.State.RUNNABLE) goto L40;
        if (r3.c() == true) goto L40;
        d.b.s.a.a0.a.a("RequestQueue", "apiDispatcher : " + r3.toString() + " quit");     // Catch: Throwable -> L46
        r3.e();     // Catch: Throwable -> L46
        this.f14699g[r1] = null;     // Catch: Throwable -> L46
    L40:
        r1 = r1 - 1;
    L41:
        d.b.s.a.a0.a.a("RequestQueue", "handleShrinkRequestQueueSize shouldShrink = " + r4 + " allNull = " + r5);     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L44:
        monitor-exit(this);
    }

    public synchronized void i() {
        monitor-enter(this);
        j();     // Catch: Throwable -> L15
        b r0 = new b(this.f14696d, this.f14697e);     // Catch: Throwable -> L15
        this.f14701i = r0;     // Catch: Throwable -> L15
        r0.start();     // Catch: Throwable -> L15
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r2 >= this.f14694b) goto L8;
        a r3 = new a(this.f14697e, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L15
        this.f14699g[r2] = r3;     // Catch: Throwable -> L15
        r3.start();     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L5
    L8:
        if (this.f14700h != null) goto L10;
    L12:
        this.f14693a = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (r1 >= this.f14695c) goto L12;
        d r4 = new d(this.f14698f, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");     // Catch: Throwable -> L15
        this.f14700h[r1] = r4;     // Catch: Throwable -> L15
        r4.start();     // Catch: Throwable -> L15
        r1 = r1 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void j() {
        monitor-enter(this);
        int r0 = 0;
        this.f14693a = false;     // Catch: Throwable -> L24
        b r1 = this.f14701i;     // Catch: Throwable -> L24
        if (r1 == null) goto L7;
        r1.b();     // Catch: Throwable -> L24
    L7:
        int r2 = 0;
    L8:
        a[] r3 = this.f14699g;     // Catch: Throwable -> L24
        if (r2 >= r3.length) goto L15;
        if (r3[r2] == null) goto L13;
        r3[r2].e();     // Catch: Throwable -> L24
        this.f14699g[r2] = null;     // Catch: Throwable -> L24
    L13:
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L8
    L15:
        if (this.f14700h == null) goto L22;
    L16:
        d[] r4 = this.f14700h;     // Catch: Throwable -> L24
        if (r0 >= r4.length) goto L22;
        if (r4[r0] == null) goto L21;
        r4[r0].e();     // Catch: Throwable -> L24
        this.f14700h[r0] = null;     // Catch: Throwable -> L24
    L21:
        r0 = r0 + 1;
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
