package d.c.d;

import android.util.Pair;
import d.c.c.d.i;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements d.c.d.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f15456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f15458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Throwable f15459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<e<T>, Executor>> f15461f;

    /* JADX INFO: renamed from: d.c.d.a$a, reason: collision with other inner class name */
    class RunnableC0416a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f15462f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f15463g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f15464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f15465i;

        RunnableC0416a(a r1, boolean r2, e r3, boolean r4) {
            this.f15465i = r1;
            this.f15462f = r2;
            this.f15463g = r3;
            this.f15464h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15462f == false) goto L6;
            this.f15463g.b(this.f15465i);
            return;
        L6:
            if (this.f15464h == false) goto L8;
            this.f15463g.a(this.f15465i);
            return;
        L8:
            this.f15463g.c(this.f15465i);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f15466f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f15467g;

        b(a r1, e r2) {
            this.f15467g = r1;
            this.f15466f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15466f.d(this.f15467g);
        }
    }

    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f15468f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f15469g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f15470h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ c[] f15471i = null;

        static {
            c r0 = new c("IN_PROGRESS", 0);
            f15468f = r0;
            c r1 = new c("SUCCESS", 1);
            f15469g = r1;
            c r3 = new c("FAILURE", 2);
            f15470h = r3;
            f15471i = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f15471i.clone();
        }
    }

    protected a() {
        this.f15458c = null;
        this.f15459d = null;
        this.f15460e = 0.0f;
        this.f15457b = false;
        this.f15456a = c.f15468f;
        this.f15461f = new ConcurrentLinkedQueue();
    }

    private void j(e<T> r2, Executor r3, boolean r4, boolean r5) {
        r3.execute(new RunnableC0416a(this, r4, r2, r5));
    }

    private void k() {
        boolean r0 = h();
        boolean r1 = s();
        Iterator<Pair<e<T>, Executor>> r2 = this.f15461f.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Pair<e<T>, Executor> r3 = r2.next();
        j((e) r3.first, (Executor) r3.second, r0, r1);
        goto L4
    }

    private synchronized boolean n(Throwable r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f15457b == false) goto L6;
    L12:
        boolean r4 = false;
    L10:
        monitor-exit(this);
        return r4;
    L6:
        if (this.f15456a != c.f15468f) goto L12;
        this.f15456a = c.f15470h;     // Catch: Throwable -> L13
        this.f15459d = r3;     // Catch: Throwable -> L13
        r4 = true;
        goto L10
    }

    private synchronized boolean p(float r4) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f15457b == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.f15456a != c.f15468f) goto L17;
        if (r4 >= this.f15460e) goto L13;
        monitor-exit(this);
        return false;
    L13:
        this.f15460e = r4;     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    private boolean r(T r4, boolean r5) {
        T r0 = null;
        monitor-enter(this);     // Catch: Throwable -> L33
    L30:
        th = th;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L33
    L37:
        if (this.f15457b == true) goto L24;
        if (this.f15456a != c.f15468f) goto L24;
        if (r5 == false) goto L11;
        this.f15456a = c.f15469g;     // Catch: Throwable -> L30
        this.f15460e = 1.0f;     // Catch: Throwable -> L30
    L11:
        T r6 = this.f15458c;     // Catch: Throwable -> L30
        if (r6 != r4) goto L41;
        T r7 = null;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r7 == null) goto L22;
        g(r7);
    L22:
        return true;
    L41:
        this.f15458c = r4;     // Catch: Throwable -> L15
        r7 = r6;
    L15:
        th = th;
        r0 = r6;
    L24:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r4 == null) goto L27;
        g(r4);
    L27:
        return false;
    L28:
        th = move-exception;
        r0 = r4;
        th = th;
    L33:
        th = move-exception;
        if (r0 == null) goto L36;
        g(r0);
    L36:
        throw th;
    }

    private synchronized boolean s() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (i() == false) goto L8;
        if (b() == true) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    @Override // d.c.d.c
    public synchronized boolean a() {
        monitor-enter(this);
        if (this.f15458c == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.c.d.c
    public synchronized boolean b() {
        monitor-enter(this);
        if (this.f15456a == c.f15468f) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.c.d.c
    public synchronized Throwable c() {
        monitor-enter(this);
        Throwable r0 = this.f15459d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.d.c
    public boolean close() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f15457b == true) goto L6;
        this.f15457b = true;     // Catch: Throwable -> L22
        T r1 = this.f15458c;     // Catch: Throwable -> L22
        this.f15458c = null;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r1 == null) goto L13;
        g(r1);
    L13:
        if (b() == true) goto L15;
        k();
    L15:
        monitor-enter(this);
        this.f15461f.clear();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return true;
    L19:
        th = move-exception;
        throw th;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L22
        return false;
    }

    @Override // d.c.d.c
    public boolean d() {
        return false;
    }

    @Override // d.c.d.c
    public synchronized T e() {
        monitor-enter(this);
        T r0 = this.f15458c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.d.c
    public void f(e<T> r3, Executor r4) {
        i.g(r3);
        i.g(r4);
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f15457b == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.f15456a != c.f15468f) goto L12;
        this.f15461f.add(Pair.create(r3, r4));     // Catch: Throwable -> L24
    L12:
        if (a() == false) goto L14;
    L19:
        boolean r0 = true;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r0 == false) goto L28;
        j(r3, r4, h(), s());
        return;
    L28:
        return;
    L14:
        if (b() == true) goto L19;
        if (s() == true) goto L19;
        r0 = false;
        goto L20
    }

    protected void g(T r1) {
    }

    @Override // d.c.d.c
    public synchronized float getProgress() {
        monitor-enter(this);
        float r0 = this.f15460e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean h() {
        monitor-enter(this);
        if (this.f15456a != c.f15470h) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean i() {
        monitor-enter(this);
        boolean r0 = this.f15457b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected void l() {
        Iterator<Pair<e<T>, Executor>> r0 = this.f15461f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair<e<T>, Executor> r1 = r0.next();
        e r2 = (e) r1.first;
        ((Executor) r1.second).execute(new b(this, r2));
        goto L4
    }

    protected boolean m(Throwable r1) {
        boolean r2 = n(r1);
        if (r2 == false) goto L5;
        k();
    L5:
        return r2;
    }

    protected boolean o(float r1) {
        boolean r2 = p(r1);
        if (r2 == false) goto L5;
        l();
    L5:
        return r2;
    }

    protected boolean q(T r1, boolean r2) {
        boolean r3 = r(r1, r2);
        if (r3 == false) goto L5;
        k();
    L5:
        return r3;
    }
}
