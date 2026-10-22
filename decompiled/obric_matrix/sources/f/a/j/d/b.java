package f.a.j.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends f.a.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final C0453b f17086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final f f17087d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f17088e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final c f17089f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadFactory f17090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<C0453b> f17091b;

    static final class a extends f.a.f.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final f.a.j.a.e f17092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final f.a.g.a f17093g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final f.a.j.a.e f17094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c f17095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f17096j;

        a(c r3) {
            this.f17095i = r3;
            f.a.j.a.e r4 = new f.a.j.a.e();
            this.f17092f = r4;
            f.a.g.a r0 = new f.a.g.a();
            this.f17093g = r0;
            f.a.j.a.e r1 = new f.a.j.a.e();
            this.f17094h = r1;
            r1.b(r4);
            r1.b(r0);
        }

        @Override // f.a.f.b
        public f.a.g.b b(Runnable r7, long r8, TimeUnit r10) {
            if (this.f17096j == false) goto L7;
            return f.a.j.a.d.f17053f;
        L7:
            return this.f17095i.c(r7, r8, r10, this.f17093g);
        }

        @Override // f.a.g.b
        public void dispose() {
            if (this.f17096j == true) goto L6;
            this.f17096j = true;
            this.f17094h.dispose();
            return;
        }
    }

    /* JADX INFO: renamed from: f.a.j.d.b$b, reason: collision with other inner class name */
    static final class C0453b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f17097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f17098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f17099c;

        C0453b(int r4, ThreadFactory r5) {
            this.f17097a = r4;
            this.f17098b = new c[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.f17098b[r0] = new c(r5);
            r0 = r0 + 1;
            goto L3
        }

        public c a() {
            int r0 = this.f17097a;
            if (r0 == 0) goto L5;
            c[] r1 = this.f17098b;
            long r2 = this.f17099c;
            this.f17099c = 1 + r2;
            return r1[(int) (r2 % ((long) r0))];
        L5:
            return b.f17089f;
        }

        public void b() {
            c[] r3 = this.f17098b;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }
    }

    static final class c extends e {
        c(ThreadFactory r1) {
            super(r1);
        }
    }

    static {
        f17088e = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
        c r0 = new c(new f("RxComputationShutdown"));
        f17089f = r0;
        r0.dispose();
        f r3 = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f17087d = r3;
        C0453b r1 = new C0453b(0, r3);
        f17086c = r1;
        r1.b();
    }

    public b() {
        this(f17087d);
    }

    public b(ThreadFactory r2) {
        this.f17090a = r2;
        this.f17091b = new AtomicReference(f17086c);
        e();
    }

    static int d(int r0, int r1) {
        if (r1 <= 0) goto L7;
        if (r1 <= r0) goto L6;
        return r0;
    L6:
        return r1;
    L7:
        return r0;
    }

    @Override // f.a.f
    public f.a.f.b a() {
        return new a(this.f17091b.get().a());
    }

    @Override // f.a.f
    public f.a.g.b c(Runnable r1, long r2, TimeUnit r4) {
        return this.f17091b.get().a().d(r1, r2, r4);
    }

    public void e() {
        C0453b r0 = new C0453b(f17088e, this.f17090a);
        if (this.f17091b.compareAndSet(f17086c, r0) == true) goto L6;
        r0.b();
        return;
    }
}
