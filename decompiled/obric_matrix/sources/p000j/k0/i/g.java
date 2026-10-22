package p000j.k0.i;

import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Closeable {
    private static final ExecutorService D = null;
    final p000j.k0.i.j A;
    final l B;
    final Set<Integer> C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f17975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final j f17976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<Integer, p000j.k0.i.i> f17977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final String f17978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f17979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f17980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17981l;
    private final ScheduledExecutorService m;
    private final ExecutorService n;
    final p000j.k0.i.l o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    long v;
    long w;
    m x;
    final m y;
    final Socket z;

    class a extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f17982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p000j.k0.i.b f17983h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f17984i;

        a(g r1, String r2, Object[] r3, int r4, p000j.k0.i.b r5) {
            this.f17984i = r1;
            this.f17982g = r4;
            this.f17983h = r5;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            this.f17984i.s0(this.f17982g, this.f17983h);     // Catch: IOException -> L4
            return;
        L4:
            g.a(this.f17984i);
        }
    }

    class b extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f17985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f17986h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f17987i;

        b(g r1, String r2, Object[] r3, int r4, long r5) {
            this.f17987i = r1;
            this.f17985g = r4;
            this.f17986h = r5;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            this.f17987i.A.O(this.f17985g, this.f17986h);     // Catch: IOException -> L4
            return;
        L4:
            g.a(this.f17987i);
        }
    }

    class c extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f17988g;

        c(g r1, String r2, Object... r3) {
            this.f17988g = r1;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            this.f17988g.r0(false, 2, 0);
        }
    }

    class d extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f17989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f17990h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f17991i;

        d(g r1, String r2, Object[] r3, int r4, List r5) {
            this.f17991i = r1;
            this.f17989g = r4;
            this.f17990h = r5;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            if (this.f17991i.o.a(this.f17989g, this.f17990h) == true) goto L16;
            return;
        L16:
            this.f17991i.A.L(this.f17989g, p000j.k0.i.b.f17931l);     // Catch: IOException -> L13
            g r0 = this.f17991i;     // Catch: IOException -> L13
            monitor-enter(r0);     // Catch: IOException -> L13
            this.f17991i.C.remove(Integer.valueOf(this.f17989g));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            goto L19
        L18:
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: IOException -> L13
        }
    }

    class e extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f17992g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f17993h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f17994i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f17995j;

        e(g r1, String r2, Object[] r3, int r4, List r5, boolean r6) {
            this.f17995j = r1;
            this.f17992g = r4;
            this.f17993h = r5;
            this.f17994i = r6;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            boolean r0 = this.f17995j.o.b(this.f17992g, this.f17993h, this.f17994i);
            if (r0 == true) goto L20;
        L5:
            if (r0 == false) goto L7;
        L8:
            g r1 = this.f17995j;     // Catch: IOException -> L17
            monitor-enter(r1);     // Catch: IOException -> L17
            this.f17995j.C.remove(Integer.valueOf(this.f17992g));     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            goto L23
        L22:
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L17
        L23:
            return;
        L7:
            if (this.f17994i == true) goto L8;
            return;
        L20:
            this.f17995j.A.L(this.f17992g, p000j.k0.i.b.f17931l);     // Catch: IOException -> L17
            goto L5
        }
    }

    class f extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f17996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ k.e f17997h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f17998i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f17999j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ g f18000k;

        f(g r1, String r2, Object[] r3, int r4, k.e r5, int r6, boolean r7) {
            this.f18000k = r1;
            this.f17996g = r4;
            this.f17997h = r5;
            this.f17998i = r6;
            this.f17999j = r7;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            boolean r0 = this.f18000k.o.d(this.f17996g, this.f17997h, this.f17998i, this.f17999j);     // Catch: IOException -> L17
            if (r0 == false) goto L5;
            this.f18000k.A.L(this.f17996g, p000j.k0.i.b.f17931l);     // Catch: IOException -> L17
        L5:
            if (r0 == false) goto L7;
        L8:
            g r1 = this.f18000k;     // Catch: IOException -> L17
            monitor-enter(r1);     // Catch: IOException -> L17
            this.f18000k.C.remove(Integer.valueOf(this.f17996g));     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            goto L22
        L21:
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L17
        L7:
            if (this.f17999j == true) goto L8;
            return;
        }
    }

    /* JADX INFO: renamed from: j.k0.i.g$g, reason: collision with other inner class name */
    class C0468g extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f18001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p000j.k0.i.b f18002h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f18003i;

        C0468g(g r1, String r2, Object[] r3, int r4, p000j.k0.i.b r5) {
            this.f18003i = r1;
            this.f18001g = r4;
            this.f18002h = r5;
            super(r2, r3);
        }

        @Override // p000j.k0.b
        public void l() {
            this.f18003i.o.c(this.f18001g, this.f18002h);
            g r0 = this.f18003i;
            monitor-enter(r0);
            this.f18003i.C.remove(Integer.valueOf(this.f18001g));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Socket f18004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f18005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        k.g f18006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        k.f f18007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        j f18008e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        p000j.k0.i.l f18009f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f18010g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f18011h;

        public h(boolean r2) {
            this.f18008e = j.f18013a;
            this.f18009f = p000j.k0.i.l.f18074a;
            this.f18010g = r2;
        }

        public g a() {
            return new g(this);
        }

        public h b(j r1) {
            this.f18008e = r1;
            return this;
        }

        public h c(int r1) {
            this.f18011h = r1;
            return this;
        }

        public h d(Socket r1, String r2, k.g r3, k.f r4) {
            this.f18004a = r1;
            this.f18005b = r2;
            this.f18006c = r3;
            this.f18007d = r4;
            return this;
        }
    }

    final class i extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f18012g;

        i(g r3) {
            this.f18012g = r3;
            super("OkHttp %s ping", new Object[]{r3.f17978i});
        }

        @Override // p000j.k0.b
        public void l() {
            if (p000j.l0.a.j().b() == true) goto L5;
            return;
        L5:
            g r0 = this.f18012g;
            monitor-enter(r0);
        L17:
            th = move-exception;
            throw th;
        L8:
            if (g.b(this.f18012g) >= g.l(this.f18012g)) goto L10;
            boolean r1 = true;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L17
            g r5 = this.f18012g;
            if (r1 == false) goto L15;
            g.a(r5);
            return;
        L15:
            r5.r0(false, 1, 0);
            return;
        L10:
            g.s(this.f18012g);     // Catch: Throwable -> L17
            r1 = false;
            goto L11
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f18013a = null;

        static class a extends j {
            a() {
            }

            @Override // j.k0.i.g.j
            public void d(p000j.k0.i.i r1) {
                r1.f(p000j.k0.i.b.f17930k);
            }
        }

        static {
            f18013a = new a();
        }

        public j() {
        }

        public void c(g r1) {
        }

        public abstract void d(p000j.k0.i.i r1);
    }

    final class k extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f18014g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f18015h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f18016i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f18017j;

        k(g r3, boolean r4, int r5, int r6) {
            this.f18017j = r3;
            super("OkHttp %s ping %08x%08x", new Object[]{r3.f17978i, Integer.valueOf(r5), Integer.valueOf(r6)});
            this.f18014g = r4;
            this.f18015h = r5;
            this.f18016i = r6;
        }

        @Override // p000j.k0.b
        public void l() {
            this.f18017j.r0(this.f18014g, this.f18015h, this.f18016i);
        }
    }

    class l extends p000j.k0.b implements j.k0.i.h.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final p000j.k0.i.h f18018g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ g f18019h;

        class a extends p000j.k0.b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ p000j.k0.i.i f18020g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ l f18021h;

            a(l r1, String r2, Object[] r3, p000j.k0.i.i r4) {
                this.f18021h = r1;
                this.f18020g = r4;
                super(r2, r3);
            }

            @Override // p000j.k0.b
            public void l() {
                this.f18021h.f18019h.f17976g.d(this.f18020g);     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                p000j.k0.j.g.m().t(4, "Http2Connection.Listener failure for " + this.f18021h.f18019h.f17978i, e);
                this.f18020g.f(p000j.k0.i.b.f17927h);     // Catch: IOException -> L8
                return;
            }
        }

        class b extends p000j.k0.b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f18022g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ m f18023h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ l f18024i;

            b(l r1, String r2, Object[] r3, boolean r4, m r5) {
                this.f18024i = r1;
                this.f18022g = r4;
                this.f18023h = r5;
                super(r2, r3);
            }

            @Override // p000j.k0.b
            public void l() {
                this.f18024i.m(this.f18022g, this.f18023h);
            }
        }

        class c extends p000j.k0.b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f18025g;

            c(l r1, String r2, Object... r3) {
                this.f18025g = r1;
                super(r2, r3);
            }

            @Override // p000j.k0.b
            public void l() {
                g r1 = this.f18025g.f18019h;
                r1.f17976g.c(r1);
            }
        }

        l(g r3, p000j.k0.i.h r4) {
            this.f18019h = r3;
            super("OkHttp %s", new Object[]{r3.f17978i});
            this.f18018g = r4;
        }

        @Override // j.k0.i.h.b
        public void b() {
        }

        @Override // j.k0.i.h.b
        public void c(boolean r9, m r10) {
            g.E(this.f18019h).execute(new b(this, "OkHttp %s ACK Settings", new Object[]{this.f18019h.f17978i}, r9, r10));     // Catch: RejectedExecutionException -> L4
            return;
        }

        @Override // j.k0.i.h.b
        public void d(boolean r10, int r11, int r12, List<p000j.k0.i.c> r13) {
            if (this.f18019h.j0(r11) == false) goto L6;
            this.f18019h.g0(r11, r13, r10);
            return;
        L6:
            g r14 = this.f18019h;
            monitor-enter(r14);
            p000j.k0.i.i r0 = this.f18019h.O(r11);     // Catch: Throwable -> L30
            if (r0 == null) goto L11;
            monitor-exit(r14);     // Catch: Throwable -> L30
            r0.q(r13);
            if (r10 == false) goto L34;
            r0.p();
            return;
        L34:
            return;
        L11:
            if (g.x(this.f18019h) == false) goto L14;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L14:
            g r1 = this.f18019h;     // Catch: Throwable -> L30
            if (r11 > r1.f17979j) goto L19;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L19:
            if ((r11 % 2) != (r1.f17980k % 2)) goto L22;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L22:
            p000j.k0.i.i r15 = new p000j.k0.i.i(r11, this.f18019h, false, r10, p000j.k0.c.H(r13));     // Catch: Throwable -> L30
            g r16 = this.f18019h;     // Catch: Throwable -> L30
            r16.f17979j = r11;     // Catch: Throwable -> L30
            r16.f17977h.put(Integer.valueOf(r11), r15);     // Catch: Throwable -> L30
            g.C().execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f18019h.f17978i, Integer.valueOf(r11)}, r15));     // Catch: Throwable -> L30
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L30:
            th = move-exception;
            throw th;
        }

        @Override // j.k0.i.h.b
        public void e(int r4, long r5) {
            if (r4 != 0) goto L11;
            g r0 = this.f18019h;
            monitor-enter(r0);
            g r3 = this.f18019h;     // Catch: Throwable -> L8
            r3.w += r5;     // Catch: Throwable -> L8
            r3.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            p000j.k0.i.i r6 = this.f18019h.O(r4);
            if (r6 == null) goto L25;
            monitor-enter(r6);
            r6.c(r5);     // Catch: Throwable -> L17
            monitor-exit(r6);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // j.k0.i.h.b
        public void f(boolean r2, int r3, k.g r4, int r5) {
            if (this.f18019h.j0(r3) == false) goto L6;
            this.f18019h.Y(r3, r4, r5, r2);
            return;
        L6:
            p000j.k0.i.i r0 = this.f18019h.O(r3);
            if (r0 != null) goto L10;
            this.f18019h.t0(r3, p000j.k0.i.b.f17927h);
            long r6 = r5;
            this.f18019h.p0(r6);
            r4.skip(r6);
            return;
        L10:
            r0.o(r4, r5);
            if (r2 == false) goto L14;
            r0.p();
            return;
        }

        @Override // j.k0.i.h.b
        public void g(boolean r3, int r4, int r5) {
            if (r3 == false) goto L23;
            g r6 = this.f18019h;
            monitor-enter(r6);
            if (r4 != 1) goto L11;
            g.g(this.f18019h);     // Catch: Throwable -> L8
        L16:
            monitor-exit(r6);     // Catch: Throwable -> L8
            return;
        L11:
            if (r4 != 2) goto L14;
            g.F(this.f18019h);     // Catch: Throwable -> L8
            goto L16
        L14:
            if (r4 != 3) goto L16;
            g.L(this.f18019h);     // Catch: Throwable -> L8
            this.f18019h.notifyAll();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        L23:
            g.E(this.f18019h).execute(new k(this.f18019h, true, r4, r5));     // Catch: RejectedExecutionException -> L22
            return;
        }

        @Override // j.k0.i.h.b
        public void h(int r1, int r2, int r3, boolean r4) {
        }

        @Override // j.k0.i.h.b
        public void i(int r2, p000j.k0.i.b r3) {
            boolean r0 = this.f18019h.j0(r2);
            g r1 = this.f18019h;
            if (r0 == false) goto L6;
            r1.i0(r2, r3);
            return;
        L6:
            p000j.k0.i.i r4 = r1.k0(r2);
            if (r4 == null) goto L10;
            r4.r(r3);
            return;
        }

        @Override // j.k0.i.h.b
        public void j(int r1, int r2, List<p000j.k0.i.c> r3) {
            this.f18019h.h0(r2, r3);
        }

        @Override // j.k0.i.h.b
        public void k(int r4, p000j.k0.i.b r5, k.h r6) {
            r6.size();
            g r7 = this.f18019h;
            monitor-enter(r7);
            p000j.k0.i.i[] r8 = (p000j.k0.i.i[]) this.f18019h.f17977h.values().toArray(new p000j.k0.i.i[this.f18019h.f17977h.size()]);     // Catch: Throwable -> L15
            g.A(this.f18019h, true);     // Catch: Throwable -> L15
            monitor-exit(r7);     // Catch: Throwable -> L15
            int r9 = r8.length;
            int r0 = 0;
        L7:
            if (r0 >= r9) goto L14;
            p000j.k0.i.i r1 = r8[r0];
            if (r1.i() <= r4) goto L13;
            if (r1.l() == false) goto L13;
            r1.r(p000j.k0.i.b.f17930k);
            this.f18019h.k0(r1.i());
        L13:
            r0 = r0 + 1;
            goto L7
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // p000j.k0.b
        protected void l() {
            p000j.k0.i.b r0 = p000j.k0.i.b.f17928i;
            this.f18018g.g(this);     // Catch: Throwable -> L11 IOException -> L13
        L5:
            if (this.f18018g.b(false, this) == true) goto L5;
            p000j.k0.i.b r1 = p000j.k0.i.b.f17926g;     // Catch: Throwable -> L11 IOException -> L13
            p000j.k0.i.b r2 = p000j.k0.i.b.f17931l;     // Catch: IOException -> L23 Throwable -> L18
            this.f18019h.M(r1, r2);     // Catch: IOException -> L22
        L25:
        L18:
            th = th;
        L28:
            this.f18019h.M(r1, r0);     // Catch: IOException -> L24
        L20:
            p000j.k0.c.g(this.f18018g);
            throw th;
        L14:
            p000j.k0.i.b r3 = p000j.k0.i.b.f17927h;     // Catch: Throwable -> L18
            this.f18019h.M(r3, r3);     // Catch: IOException -> L22
            goto L25
        L13:
            r1 = r0;
        L11:
            th = th;
            r1 = r0;
        L16:
            p000j.k0.c.g(this.f18018g);
        }

        void m(boolean r6, m r7) {
            p000j.k0.i.j r0 = this.f18019h.A;
            monitor-enter(r0);
            g r1 = this.f18019h;     // Catch: Throwable -> L38
            monitor-enter(r1);     // Catch: Throwable -> L38
            int r2 = this.f18019h.y.d();     // Catch: Throwable -> L35
            if (r6 == false) goto L9;
            this.f18019h.y.a();     // Catch: Throwable -> L35
        L9:
            this.f18019h.y.h(r7);     // Catch: Throwable -> L35
            int r8 = this.f18019h.y.d();     // Catch: Throwable -> L35
            p000j.k0.i.i[] r3 = null;
            if (r8 == (-1)) goto L15;
            if (r8 == r2) goto L15;
            long r9 = r8 - r2;     // Catch: Throwable -> L35
            if (this.f18019h.f17977h.isEmpty() == true) goto L16;
            r3 = (p000j.k0.i.i[]) this.f18019h.f17977h.values().toArray(new p000j.k0.i.i[this.f18019h.f17977h.size()]);     // Catch: Throwable -> L35
        L16:
            monitor-exit(r1);     // Catch: Throwable -> L35
        L46:
            g r4 = this.f18019h;     // Catch: IOException -> L19 Throwable -> L38
            r4.A.a(r4.y);     // Catch: IOException -> L19 Throwable -> L38
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L38
            if (r3 == null) goto L33;
            int r5 = r3.length;
            int r10 = 0;
        L24:
            if (r10 >= r5) goto L33;
            p000j.k0.i.i r11 = r3[r10];
            monitor-enter(r11);
            r11.c(r9);     // Catch: Throwable -> L30
            monitor-exit(r11);     // Catch: Throwable -> L30
            r10 = r10 + 1;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        L33:
            g.C().execute(new c(this, "OkHttp %s settings", new Object[]{this.f18019h.f17978i}));
            return;
        L19:
            g.a(this.f18019h);     // Catch: Throwable -> L38
        L15:
            r9 = 0;
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        }
    }

    static {
        D = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), p000j.k0.c.G("OkHttp Http2Connection", true));
    }

    g(h r25) {
        this.f17977h = new LinkedHashMap();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.x = new m();
        m r2 = new m();
        this.y = r2;
        this.C = new LinkedHashSet();
        this.o = r25.f18009f;
        boolean r3 = r25.f18010g;
        this.f17975f = r3;
        this.f17976g = r25.f18008e;
        if (r3 == false) goto L5;
        int r6 = 1;
    L6:
        this.f17980k = r6;
        if (r3 == false) goto L10;
        this.f17980k = r6 + 2;
    L10:
        if (r3 == false) goto L12;
        this.x.i(7, 16777216);
    L12:
        String r7 = r25.f18005b;
        this.f17978i = r7;
        ScheduledThreadPoolExecutor r8 = new ScheduledThreadPoolExecutor(1, p000j.k0.c.G(p000j.k0.c.r("OkHttp %s Writer", new Object[]{r7}), false));
        this.m = r8;
        if (r25.f18011h == 0) goto L15;
        i r9 = new i(this);
        int r10 = r25.f18011h;
        r8.scheduleAtFixedRate(r9, r10, r10, TimeUnit.MILLISECONDS);
    L15:
        this.n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), p000j.k0.c.G(p000j.k0.c.r("OkHttp %s Push Observer", new Object[]{r7}), true));
        r2.i(7, SupportMenu.USER_MASK);
        r2.i(5, 16384);
        this.w = r2.d();
        this.z = r25.f18004a;
        this.A = new p000j.k0.i.j(r25.f18007d, r3);
        this.B = new l(this, new p000j.k0.i.h(r25.f18006c, r3));
        return;
    L5:
        r6 = 2;
        goto L6
    }

    static /* synthetic */ boolean A(g r0, boolean r1) {
        r0.f17981l = r1;
        return r1;
    }

    static /* synthetic */ ExecutorService C() {
        return D;
    }

    static /* synthetic */ ScheduledExecutorService E(g r0) {
        return r0.m;
    }

    static /* synthetic */ long F(g r4) {
        long r0 = r4.s;
        r4.s = 1 + r0;
        return r0;
    }

    static /* synthetic */ long L(g r4) {
        long r0 = r4.t;
        r4.t = 1 + r0;
        return r0;
    }

    private void N() {
        p000j.k0.i.b r0 = p000j.k0.i.b.f17927h;     // Catch: IOException -> L4
        M(r0, r0);     // Catch: IOException -> L4
        return;
    }

    private p000j.k0.i.i V(int r11, List<p000j.k0.i.c> r12, boolean r13) {
        boolean r6 = !r13;
        p000j.k0.i.j r7 = this.A;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L39
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L6:
        if (this.f17980k <= 1073741823) goto L9;
        m0(p000j.k0.i.b.f17930k);     // Catch: Throwable -> L36
    L9:
        if (this.f17981l == true) goto L35;
        int r8 = this.f17980k;     // Catch: Throwable -> L36
        this.f17980k = r8 + 2;     // Catch: Throwable -> L36
        p000j.k0.i.i r9 = new p000j.k0.i.i(r8, this, r6, false, null);     // Catch: Throwable -> L36
        if (r13 == true) goto L13;
    L18:
        boolean r14 = true;
    L20:
        if (r9.m() == false) goto L22;
        this.f17977h.put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L36
    L22:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r11 != 0) goto L26;
        this.A.N(r6, r8, r11, r12);     // Catch: Throwable -> L39
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L39
        if (r14 == false) goto L31;
        this.A.flush();
    L31:
        return r9;
    L26:
        if (this.f17975f == true) goto L33;
        this.A.F(r11, r8, r12);     // Catch: Throwable -> L39
        goto L28
    L33:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");     // Catch: Throwable -> L39
    L13:
        if (this.w == 0) goto L18;
        if (r9.f18038b == 0) goto L18;
        r14 = false;
        goto L20
    L35:
        throw new p000j.k0.i.a();     // Catch: Throwable -> L36
    L39:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(g r0) {
        r0.N();
    }

    static /* synthetic */ long b(g r2) {
        return r2.q;
    }

    private synchronized void d0(p000j.k0.b r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f17981l == true) goto L6;
        this.n.execute(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    static /* synthetic */ long g(g r4) {
        long r0 = r4.q;
        r4.q = 1 + r0;
        return r0;
    }

    static /* synthetic */ long l(g r2) {
        return r2.p;
    }

    static /* synthetic */ long s(g r4) {
        long r0 = r4.p;
        r4.p = 1 + r0;
        return r0;
    }

    static /* synthetic */ boolean x(g r0) {
        return r0.f17981l;
    }

    void M(p000j.k0.i.b r5, p000j.k0.i.b r6) {
        p000j.k0.i.i[] r0 = null;
        m0(r5);     // Catch: IOException -> L5
        e = null;
    L6:
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L8:
        if (this.f17977h.isEmpty() == true) goto L10;
        r0 = (p000j.k0.i.i[]) this.f17977h.values().toArray(new p000j.k0.i.i[this.f17977h.size()]);     // Catch: Throwable -> L33
        this.f17977h.clear();     // Catch: Throwable -> L33
    L10:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r0 == null) goto L40;
        int r1 = r0.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L40;
        r0[r2].f(r6);     // Catch: IOException -> L17
    L20:
        r2 = r2 + 1;
    L17:
        e = move-exception;
        if (e == null) goto L20;
        e = e;
    L40:
        this.A.close();     // Catch: IOException -> L23
    L42:
        this.z.close();     // Catch: IOException -> L28
    L29:
        this.m.shutdown();
        this.n.shutdown();
        if (e != null) goto L32;
        return;
    L32:
        throw e;
    L28:
        e = e;
    L23:
        e = move-exception;
        if (e != null) goto L42;
        e = e;
    L5:
        e = e;
        goto L6
    }

    synchronized p000j.k0.i.i O(int r2) {
        monitor-enter(this);
        p000j.k0.i.i r3 = this.f17977h.get(Integer.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean Q(long r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f17981l == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.s >= this.r) goto L16;
        if (r7 < this.u) goto L16;
        monitor-exit(this);
        return false;
    L16:
        monitor-exit(this);
        return true;
    }

    public synchronized int S() {
        monitor-enter(this);
        int r0 = this.y.e(Integer.MAX_VALUE);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public p000j.k0.i.i X(List<p000j.k0.i.c> r2, boolean r3) {
        return V(0, r2, r3);
    }

    void Y(int r9, k.g r10, int r11, boolean r12) {
        k.e r5 = new k.e();
        long r0 = r11;
        r10.b0(r0);
        r10.Z(r5, r0);
        if (r5.k0() != r0) goto L7;
        d0(new f(this, "OkHttp %s Push Data[%s]", new Object[]{this.f17978i, Integer.valueOf(r9)}, r9, r5, r11, r12));
        return;
    L7:
        throw new IOException(r5.k0() + " != " + r11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        M(p000j.k0.i.b.f17926g, p000j.k0.i.b.f17931l);
    }

    public void flush() {
        this.A.flush();
    }

    void g0(int r9, List<p000j.k0.i.c> r10, boolean r11) {
        d0(new e(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f17978i, Integer.valueOf(r9)}, r9, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    void h0(int r9, List<p000j.k0.i.c> r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.C.contains(Integer.valueOf(r9)) == false) goto L8;
        t0(r9, p000j.k0.i.b.f17927h);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L8:
        this.C.add(Integer.valueOf(r9));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        d0(new d(this, "OkHttp %s Push Request[%s]", new Object[]{this.f17978i, Integer.valueOf(r9)}, r9, r10));     // Catch: RejectedExecutionException -> L15
        return;
    }

    void i0(int r8, p000j.k0.i.b r9) {
        d0(new C0468g(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f17978i, Integer.valueOf(r8)}, r8, r9));
    }

    boolean j0(int r1) {
        if (r1 != 0) goto L5;
    L7:
        return false;
    L5:
        if ((r1 & 1) != 0) goto L7;
        return true;
    }

    synchronized p000j.k0.i.i k0(int r2) {
        monitor-enter(this);
        p000j.k0.i.i r3 = this.f17977h.remove(Integer.valueOf(r2));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    void l0() {
        monitor-enter(this);
        long r0 = this.s;     // Catch: Throwable -> L11
        long r2 = this.r;     // Catch: Throwable -> L11
        if (r0 >= r2) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.r = r2 + 1;     // Catch: Throwable -> L11
        this.u = System.nanoTime() + 1000000000;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.m.execute(new c(this, "OkHttp %s ping", new Object[]{this.f17978i}));     // Catch: RejectedExecutionException -> L14
        return;
    L18:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void m0(p000j.k0.i.b r4) {
        p000j.k0.i.j r0 = this.A;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.f17981l == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L11:
        this.f17981l = true;     // Catch: Throwable -> L16
        int r1 = this.f17979j;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.A.x(r1, r4, p000j.k0.c.f17792a);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public void n0() {
        o0(true);
    }

    void o0(boolean r6) {
        if (r6 == false) goto L6;
        this.A.b();
        this.A.M(this.x);
        int r7 = this.x.d();
        if (r7 == 65535) goto L6;
        this.A.O(0, r7 - SupportMenu.USER_MASK);
    L6:
        new Thread(this.B).start();
    }

    synchronized void p0(long r3) {
        monitor-enter(this);
        long r0 = this.v + r3;     // Catch: Throwable -> L8
        this.v = r0;     // Catch: Throwable -> L8
        if (r0 < (this.x.d() / 2)) goto L6;
        u0(0, this.v);     // Catch: Throwable -> L8
        this.v = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void q0(int r9, boolean r10, k.e r11, long r12) {
        if (r12 != 0) goto L7;
        this.A.g(r10, r9, r11, 0);
        return;
    L7:
        if (r12 <= 0) goto L31;
        monitor-enter(this);
    L32:
        long r4 = this.w;     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r4 > 0) goto L16;
        if (this.f17977h.containsKey(Integer.valueOf(r9)) == false) goto L15;
        wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        goto L32
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L25 InterruptedException -> L27
    L16:
        int r2 = Math.min((int) Math.min(r12, r4), this.A.C());     // Catch: Throwable -> L25
        long r6 = r2;
        this.w -= r6;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r12 = r12 - r6;
        p000j.k0.i.j r5 = this.A;
        if (r10 == true) goto L21;
    L23:
        boolean r7 = false;
    L24:
        r5.g(r7, r9, r11, r2);
        goto L7
    L21:
        if (r12 != 0) goto L23;
        r7 = true;
    L25:
        th = move-exception;
        throw th;
    L27:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        throw new InterruptedIOException();     // Catch: Throwable -> L25
    }

    void r0(boolean r2, int r3, int r4) {
        this.A.E(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        N();
    }

    void s0(int r1, p000j.k0.i.b r2) {
        this.A.L(r1, r2);
    }

    void t0(int r9, p000j.k0.i.b r10) {
        this.m.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f17978i, Integer.valueOf(r9)}, r9, r10));     // Catch: RejectedExecutionException -> L4
        return;
    }

    void u0(int r10, long r11) {
        this.m.execute(new b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f17978i, Integer.valueOf(r10)}, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }
}
