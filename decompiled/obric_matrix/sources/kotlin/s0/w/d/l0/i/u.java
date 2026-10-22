package kotlin.s0.w.d.l0.i;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
class u extends kotlin.s0.w.d.l0.i.d {
    private static final int[] m = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f20374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f20377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f20378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20379l;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<kotlin.s0.w.d.l0.i.d> f20380a;

        private b() {
            this.f20380a = new Stack();
        }

        /* synthetic */ b(a r1) {
            this();
        }

        static /* synthetic */ kotlin.s0.w.d.l0.i.d a(b r0, kotlin.s0.w.d.l0.i.d r1, kotlin.s0.w.d.l0.i.d r2) {
            return r0.b(r1, r2);
        }

        private kotlin.s0.w.d.l0.i.d b(kotlin.s0.w.d.l0.i.d r3, kotlin.s0.w.d.l0.i.d r4) {
            c(r3);
            c(r4);
            kotlin.s0.w.d.l0.i.d r5 = this.f20380a.pop();
        L4:
            if (this.f20380a.isEmpty() == true) goto L6;
            r5 = new u(this.f20380a.pop(), r5, null);
            goto L4
        L6:
            return r5;
        }

        private void c(kotlin.s0.w.d.l0.i.d r3) {
            if (r3.p() == false) goto L6;
            e(r3);
            return;
        L6:
            if ((r3 instanceof u) == false) goto L9;
            u r4 = (u) r3;
            c(u.C(r4));
            c(u.D(r4));
            return;
        L9:
            String r5 = String.valueOf(String.valueOf(r3.getClass()));
            StringBuilder r0 = new StringBuilder(r5.length() + 49);
            r0.append("Has a new type of ByteString been created? Found ");
            r0.append(r5);
            throw new IllegalArgumentException(r0.toString());
        }

        private int d(int r1) {
            int r0 = Arrays.binarySearch(u.E(), r1);
            if (r0 < 0) goto L5;
            return r0;
        L5:
            return (-(r0 + 1)) - 1;
        }

        private void e(kotlin.s0.w.d.l0.i.d r6) {
            int r0 = d(r6.size());
            int r1 = u.E()[r0 + 1];
            if (this.f20380a.isEmpty() == false) goto L5;
        L20:
            this.f20380a.push(r6);
            return;
        L5:
            if (this.f20380a.peek().size() >= r1) goto L20;
            int r2 = u.E()[r0];
            kotlin.s0.w.d.l0.i.d r3 = this.f20380a.pop();
        L8:
            a r4 = null;
            if (this.f20380a.isEmpty() == true) goto L13;
            if (this.f20380a.peek().size() >= r2) goto L13;
            r3 = new u(this.f20380a.pop(), r3, r4);
        L13:
            u r5 = new u(r3, r6, r4);
        L15:
            if (this.f20380a.isEmpty() == true) goto L19;
            int r7 = d(r5.size());
            int r8 = u.E()[r7 + 1];
            if (this.f20380a.peek().size() >= r8) goto L19;
            r5 = new u(this.f20380a.pop(), r5, r4);
        L19:
            this.f20380a.push(r5);
        }
    }

    private static class c implements Iterator<p> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Stack<u> f20381f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p f20382g;

        private c(kotlin.s0.w.d.l0.i.d r2) {
            this.f20381f = new Stack();
            this.f20382g = b(r2);
        }

        /* synthetic */ c(kotlin.s0.w.d.l0.i.d r1, a r2) {
            this(r1);
        }

        private p b(kotlin.s0.w.d.l0.i.d r2) {
        L3:
            if ((r2 instanceof u) == false) goto L6;
            u r3 = (u) r2;
            this.f20381f.push(r3);
            r2 = u.C(r3);
            goto L3
        L6:
            return (p) r2;
        }

        private p c() {
        L3:
            if (this.f20381f.isEmpty() == true) goto L4;
            p r0 = b(u.D(this.f20381f.pop()));
            if (r0.isEmpty() == true) goto L3;
            return r0;
        L4:
            return null;
        }

        public p d() {
            p r0 = this.f20382g;
            if (r0 == null) goto L7;
            this.f20382g = c();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20382g == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ p next() {
            return d();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class d implements kotlin.s0.w.d.l0.i.d.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c f20383f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private kotlin.s0.w.d.l0.i.d.a f20384g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f20385h;

        private d(u r3) {
            c r0 = new c(r3, null);
            this.f20383f = r0;
            this.f20384g = r0.d().r();
            this.f20385h = r3.size();
        }

        /* synthetic */ d(u r1, a r2) {
            this(r1);
        }

        @Override // kotlin.s0.w.d.l0.i.d.a
        public byte a() {
            if (this.f20384g.hasNext() == true) goto L5;
            this.f20384g = this.f20383f.d().r();
        L5:
            this.f20385h--;
            return this.f20384g.a();
        }

        public Byte b() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20385h <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class e extends InputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f20386f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p f20387g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20388h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20389i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20390j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20391k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ u f20392l;

        public e(u r1) {
            this.f20392l = r1;
            b();
        }

        private void a() {
            if (this.f20387g == null) goto L12;
            int r0 = this.f20389i;
            int r1 = this.f20388h;
            if (r0 != r1) goto L13;
            this.f20390j += r1;
            int r2 = 0;
            this.f20389i = 0;
            if (this.f20386f.hasNext() == false) goto L9;
            p r3 = this.f20386f.d();
            this.f20387g = r3;
            r2 = r3.size();
        L10:
            this.f20388h = r2;
            return;
        L9:
            this.f20387g = null;
            goto L10
        L13:
            return;
        }

        private void b() {
            c r0 = new c(this.f20392l, null);
            this.f20386f = r0;
            p r1 = r0.d();
            this.f20387g = r1;
            this.f20388h = r1.size();
            this.f20389i = 0;
            this.f20390j = 0;
        }

        private int g(byte[] r5, int r6, int r7) {
            int r0 = r7;
        L3:
            if (r0 <= 0) goto L14;
            a();
            if (this.f20387g == null) goto L6;
            int r1 = Math.min(this.f20388h - this.f20389i, r0);
            if (r5 == null) goto L12;
            this.f20387g.m(r5, this.f20389i, r6, r1);
            r6 = r6 + r1;
        L12:
            this.f20389i += r1;
            r0 = r0 - r1;
            goto L3
        L6:
            if (r0 != r7) goto L14;
            return -1;
        L14:
            return r7 - r0;
        }

        @Override // java.io.InputStream
        public int available() {
            int r0 = this.f20390j + this.f20389i;
            return this.f20392l.size() - r0;
        }

        @Override // java.io.InputStream
        public void mark(int r2) {
            this.f20391k = this.f20390j + this.f20389i;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            a();
            p r0 = this.f20387g;
            if (r0 != null) goto L6;
            return -1;
        L6:
            int r1 = this.f20389i;
            this.f20389i = r1 + 1;
            return r0.C(r1) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            Objects.requireNonNull(r2);
            if (r3 < 0) goto L10;
            if (r4 < 0) goto L10;
            if (r4 > (r2.length - r3)) goto L10;
            return g(r2, r3, r4);
        L10:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            b();     // Catch: Throwable -> L6
            g(null, 0, this.f20391k);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r4) {
            if (r4 < 0) goto L10;
            if (r4 <= 2147483647L) goto L8;
            r4 = 2147483647L;
        L8:
            return g(null, 0, (int) r4);
        L10:
            throw new IndexOutOfBoundsException();
        }
    }

    static {
        ArrayList r0 = new ArrayList();
        int r1 = 1;
        int r2 = 1;
    L3:
        if (r1 <= 0) goto L5;
        r0.add(Integer.valueOf(r1));
        int r3 = r2 + r1;
        r2 = r1;
        r1 = r3;
        goto L3
    L5:
        r0.add(Integer.MAX_VALUE);
        m = new int[r0.size()];
        int r4 = 0;
    L6:
        int[] r5 = m;
        if (r4 >= r5.length) goto L9;
        r5[r4] = ((Integer) r0.get(r4)).intValue();
        r4 = r4 + 1;
        goto L6
    }

    private u(kotlin.s0.w.d.l0.i.d r3, kotlin.s0.w.d.l0.i.d r4) {
        this.f20379l = 0;
        this.f20375h = r3;
        this.f20376i = r4;
        int r0 = r3.size();
        this.f20377j = r0;
        this.f20374g = r0 + r4.size();
        this.f20378k = Math.max(r3.o(), r4.o()) + 1;
    }

    /* synthetic */ u(kotlin.s0.w.d.l0.i.d r1, kotlin.s0.w.d.l0.i.d r2, a r3) {
        this(r1, r2);
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d C(u r0) {
        return r0.f20375h;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d D(u r0) {
        return r0.f20376i;
    }

    static /* synthetic */ int[] E() {
        return m;
    }

    static kotlin.s0.w.d.l0.i.d F(kotlin.s0.w.d.l0.i.d r6, kotlin.s0.w.d.l0.i.d r7) {
        a r1 = null;
        if ((r6 instanceof u) == false) goto L5;
        u r0 = (u) r6;
    L7:
        if (r7.size() != 0) goto L10;
        return r6;
    L10:
        if (r6.size() == 0) goto L30;
        int r2 = r6.size() + r7.size();
        if (r2 < 128) goto L31;
        if (r0 != null) goto L17;
    L19:
        if (r0 == null) goto L26;
        if (r0.f20375h.o() <= r0.f20376i.o()) goto L26;
        if (r0.o() <= r7.o()) goto L26;
        r7 = new u(r0.f20375h, new u(r0.f20376i, r7));
    L26:
        if (r2 < m[Math.max(r6.o(), r7.o()) + 1]) goto L29;
        return new u(r6, r7);
    L29:
        return b.a(new b(r1), r6, r7);
    L17:
        if ((r0.f20376i.size() + r7.size()) >= 128) goto L19;
        r7 = new u(r0.f20375h, G(r0.f20376i, r7));
        goto L30
    L31:
        return G(r6, r7);
    L30:
        return r7;
    L5:
        r0 = null;
        goto L7
    }

    private static p G(kotlin.s0.w.d.l0.i.d r4, kotlin.s0.w.d.l0.i.d r5) {
        int r0 = r4.size();
        int r1 = r5.size();
        byte[] r2 = new byte[r0 + r1];
        r4.m(r2, 0, 0, r0);
        r5.m(r2, 0, r0, r1);
        return new p(r2);
    }

    private boolean H(kotlin.s0.w.d.l0.i.d r12) {
        a r1 = null;
        c r0 = new c(this, r1);
        p r2 = r0.next();
        c r3 = new c(r12, r1);
        p r13 = r3.next();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        int r7 = r2.size() - r4;
        int r8 = r13.size() - r5;
        int r9 = Math.min(r7, r8);
        if (r4 != 0) goto L6;
        boolean r10 = r2.D(r13, r5, r9);
    L7:
        if (r10 == false) goto L8;
        r6 = r6 + r9;
        int r11 = this.f20374g;
        if (r6 >= r11) goto L11;
        if (r9 != r7) goto L18;
        r2 = r0.next();
        r4 = 0;
    L19:
        if (r9 == r8) goto L20;
        r5 = r5 + r9;
        goto L3
    L20:
        r13 = r3.next();
        r5 = 0;
        goto L3
    L18:
        r4 = r4 + r9;
        goto L19
    L11:
        if (r6 != r11) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r10 = r13.D(r2, r4, r9);
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.i.d
    void B(OutputStream r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.f20377j;
        if (r0 > r1) goto L6;
        kotlin.s0.w.d.l0.i.d r2 = this.f20375h;
    L5:
        r2.B(r3, r4, r5);
        return;
    L6:
        if (r4 < r1) goto L8;
        r2 = this.f20376i;
        r4 = r4 - r1;
        goto L5
    L8:
        int r6 = r1 - r4;
        this.f20375h.B(r3, r4, r6);
        r2 = this.f20376i;
        r4 = 0;
        r5 = r5 - r6;
        goto L5
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof kotlin.s0.w.d.l0.i.d) == true) goto L8;
        return false;
    L8:
        kotlin.s0.w.d.l0.i.d r6 = (kotlin.s0.w.d.l0.i.d) r5;
        if (this.f20374g == r6.size()) goto L12;
        return false;
    L12:
        if (this.f20374g != 0) goto L15;
        return true;
    L15:
        if (this.f20379l == 0) goto L22;
        int r0 = r6.w();
        if (r0 == 0) goto L22;
        if (this.f20379l == r0) goto L22;
        return false;
    L22:
        return H(r6);
    }

    public int hashCode() {
        int r0 = this.f20379l;
        if (r0 != 0) goto L8;
        int r1 = this.f20374g;
        r0 = u(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.f20379l = r0;
    L8:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.i.d, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return r();
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected void n(byte[] r3, int r4, int r5, int r6) {
        int r0 = r4 + r6;
        int r1 = this.f20377j;
        if (r0 > r1) goto L6;
        kotlin.s0.w.d.l0.i.d r2 = this.f20375h;
    L5:
        r2.n(r3, r4, r5, r6);
        return;
    L6:
        if (r4 < r1) goto L8;
        r2 = this.f20376i;
        r4 = r4 - r1;
        goto L5
    L8:
        int r7 = r1 - r4;
        this.f20375h.n(r3, r4, r5, r7);
        r2 = this.f20376i;
        r4 = 0;
        r5 = r5 + r7;
        r6 = r6 - r7;
        goto L5
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int o() {
        return this.f20378k;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected boolean p() {
        if (this.f20374g < m[this.f20378k]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public boolean q() {
        int r0 = this.f20375h.v(0, 0, this.f20377j);
        kotlin.s0.w.d.l0.i.d r3 = this.f20376i;
        if (r3.v(r0, 0, r3.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public kotlin.s0.w.d.l0.i.d.a r() {
        return new d(this, null);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public kotlin.s0.w.d.l0.i.e s() {
        return kotlin.s0.w.d.l0.i.e.g(new e(this));
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public int size() {
        return this.f20374g;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int u(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.f20377j;
        if (r0 > r1) goto L7;
        kotlin.s0.w.d.l0.i.d r2 = this.f20375h;
    L6:
        return r2.u(r3, r4, r5);
    L7:
        if (r4 < r1) goto L9;
        r2 = this.f20376i;
        r4 = r4 - r1;
        goto L6
    L9:
        int r6 = r1 - r4;
        r3 = this.f20375h.u(r3, r4, r6);
        r2 = this.f20376i;
        r4 = 0;
        r5 = r5 - r6;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int v(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.f20377j;
        if (r0 > r1) goto L7;
        kotlin.s0.w.d.l0.i.d r2 = this.f20375h;
    L6:
        return r2.v(r3, r4, r5);
    L7:
        if (r4 < r1) goto L9;
        r2 = this.f20376i;
        r4 = r4 - r1;
        goto L6
    L9:
        int r6 = r1 - r4;
        r3 = this.f20375h.v(r3, r4, r6);
        r2 = this.f20376i;
        r4 = 0;
        r5 = r5 - r6;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int w() {
        return this.f20379l;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public String y(String r2) {
        return new String(x(), r2);
    }
}
