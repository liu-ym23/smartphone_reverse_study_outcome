package d.b.l.a.h;

import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.l.a.h.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f14101l = null;
    private static final Object m = null;
    private static final Object n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile d.b.l.a.h.g.b f14102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile d.b.l.a.h.g.b f14103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile d.b.l.a.h.g.b f14104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<d.b.l.a.h.b, Long> f14105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f f14106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d.b.l.a.h.d.a f14107k;

    /* JADX INFO: renamed from: d.b.l.a.h.a$a, reason: collision with other inner class name */
    class C0375a implements d.b.l.a.h.g.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14108a;

        C0375a(a r1) {
            this.f14108a = r1;
        }

        @Override // d.b.l.a.h.g.a.b
        public void a(long r2) {
            a.k(this.f14108a).put(d.b.l.a.h.b.f14112f, Long.valueOf(r2));
        }
    }

    class b implements d.b.l.a.h.g.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14109a;

        b(a r1) {
            this.f14109a = r1;
        }

        @Override // d.b.l.a.h.g.a.b
        public void a(long r2) {
            a.k(this.f14109a).put(d.b.l.a.h.b.f14114h, Long.valueOf(r2));
        }
    }

    class c implements d.b.l.a.h.g.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14110a;

        c(a r1) {
            this.f14110a = r1;
        }

        @Override // d.b.l.a.h.g.a.b
        public void a(long r2) {
            a.k(this.f14110a).put(d.b.l.a.h.b.f14113g, Long.valueOf(r2));
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f14111a = null;

        static {
            f14111a = new a();
        }
    }

    static {
        f14101l = new Object();
        m = new Object();
        n = new Object();
    }

    public a() {
        this.f14105i = new ConcurrentHashMap(3);
    }

    static /* synthetic */ Map k(a r0) {
        return r0.f14105i;
    }

    @NonNull
    private d.b.l.a.h.g.c l(e r2) {
        d.b.l.a.h.b r3 = r2.S();
        if (r3 != d.b.l.a.h.b.f14112f) goto L7;
        return m();
    L7:
        if (r3 != d.b.l.a.h.b.f14113g) goto L11;
        return p();
    L11:
        return o();
    }

    public static a n() {
        return d.f14111a;
    }

    private void q(f r5) {
        Object r0 = f14101l;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f14102f != null) goto L7;
        d.b.l.a.h.g.a r1 = new d.b.l.a.h.g.a("io-task");     // Catch: Throwable -> L9
        r1.c(r5);     // Catch: Throwable -> L9
        r1.d(new C0375a(this));     // Catch: Throwable -> L9
        d.b.l.a.h.g.b r2 = new d.b.l.a.h.g.b(1, r1);     // Catch: Throwable -> L9
        r2.w(r5);     // Catch: Throwable -> L9
        this.f14102f = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void r(f r5) {
        Object r0 = m;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f14103g != null) goto L7;
        d.b.l.a.h.g.a r1 = new d.b.l.a.h.g.a("light-weight-task");     // Catch: Throwable -> L9
        r1.c(r5);     // Catch: Throwable -> L9
        r1.d(new b(this));     // Catch: Throwable -> L9
        d.b.l.a.h.g.b r2 = new d.b.l.a.h.g.b(1, r1);     // Catch: Throwable -> L9
        r2.w(r5);     // Catch: Throwable -> L9
        this.f14103g = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void s(f r5) {
        Object r0 = n;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f14104h != null) goto L7;
        d.b.l.a.h.g.a r1 = new d.b.l.a.h.g.a("time-sensitive-task");     // Catch: Throwable -> L9
        r1.c(r5);     // Catch: Throwable -> L9
        r1.d(new c(this));     // Catch: Throwable -> L9
        d.b.l.a.h.g.b r2 = new d.b.l.a.h.g.b(1, r1);     // Catch: Throwable -> L9
        r2.w(r5);     // Catch: Throwable -> L9
        this.f14104h = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // d.b.l.a.h.d
    public void a(Throwable r1, String r2) {
        d.b.l.a.h.d.a r0 = this.f14107k;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // d.b.l.a.h.d
    public void b(d.b.l.a.h.d.a r1) {
        this.f14107k = r1;
    }

    @Override // d.b.l.a.h.g.c
    public void c(e r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        l(r2).c(r2);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-post");
    }

    @Override // d.b.l.a.h.d
    public void d(ExecutorService r1) {
        m().v(r1);
    }

    @Override // d.b.l.a.h.g.c
    public void e(e r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        l(r2).e(r2);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // d.b.l.a.h.d
    public ExecutorService f() {
        return m();
    }

    @Override // d.b.l.a.h.g.c
    public void g(e r7, long r8, long r10) {
        if (r7 != null) goto L9;
        return;
    L9:
        l(r7).g(r7, r8, r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // d.b.l.a.h.g.c
    public void h(e r2, long r3) {
        if (r2 != null) goto L9;
        return;
    L9:
        l(r2).h(r2, r3);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-postDelayed");
    }

    @Override // d.b.l.a.h.d
    public long i(d.b.l.a.h.b r1) {
        Long r0 = this.f14105i.get(r1);
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.longValue();
    }

    @Override // d.b.l.a.h.d
    public f j() {
        return this.f14106j;
    }

    public d.b.l.a.h.g.b m() {
        if (this.f14102f != null) goto L15;
        Object r0 = f14101l;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f14102f != null) goto L9;
        q(this.f14106j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f14102f;
    }

    public d.b.l.a.h.g.b o() {
        if (this.f14103g != null) goto L15;
        Object r0 = m;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f14103g != null) goto L9;
        r(this.f14106j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f14103g;
    }

    public d.b.l.a.h.g.b p() {
        if (this.f14104h != null) goto L15;
        Object r0 = n;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f14104h != null) goto L9;
        s(this.f14106j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f14104h;
    }
}
