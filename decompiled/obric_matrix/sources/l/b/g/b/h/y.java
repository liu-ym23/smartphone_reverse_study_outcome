package l.b.g.b.h;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends p implements l.b.h.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x f22193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f22194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f22195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final byte[] f22197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile l.b.g.b.h.a f22198l;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f22199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f22201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f22203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f22204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f22205g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private l.b.g.b.h.a f22206h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f22207i;

        public b(x r2) {
            this.f22200b = 0;
            this.f22201c = -1;
            this.f22202d = null;
            this.f22203e = null;
            this.f22204f = null;
            this.f22205g = null;
            this.f22206h = null;
            this.f22207i = null;
            this.f22199a = r2;
        }

        static /* synthetic */ x a(b r0) {
            return r0.f22199a;
        }

        static /* synthetic */ byte[] b(b r0) {
            return r0.f22207i;
        }

        static /* synthetic */ byte[] c(b r0) {
            return r0.f22202d;
        }

        static /* synthetic */ byte[] d(b r0) {
            return r0.f22203e;
        }

        static /* synthetic */ byte[] e(b r0) {
            return r0.f22204f;
        }

        static /* synthetic */ byte[] f(b r0) {
            return r0.f22205g;
        }

        static /* synthetic */ l.b.g.b.h.a g(b r0) {
            return r0.f22206h;
        }

        static /* synthetic */ int h(b r0) {
            return r0.f22200b;
        }

        static /* synthetic */ int i(b r0) {
            return r0.f22201c;
        }

        public y j() {
            return new y(this, null);
        }

        public b k(l.b.g.b.h.a r1) {
            this.f22206h = r1;
            return this;
        }

        public b l(int r1) {
            this.f22200b = r1;
            return this;
        }

        public b m(int r1) {
            this.f22201c = r1;
            return this;
        }

        public b n(byte[] r1) {
            this.f22204f = a0.c(r1);
            return this;
        }

        public b o(byte[] r1) {
            this.f22205g = a0.c(r1);
            return this;
        }

        public b p(byte[] r1) {
            this.f22203e = a0.c(r1);
            return this;
        }

        public b q(byte[] r1) {
            this.f22202d = a0.c(r1);
            return this;
        }
    }

    private y(b r9) {
        super(true, b.a(r9).f());
        x r3 = b.a(r9);
        this.f22193g = r3;
        Objects.requireNonNull(r3, "params == null");
        int r0 = r3.h();
        byte[] r2 = b.b(r9);
        if (r2 == null) goto L20;
        int r1 = r3.b();
        int r4 = l.b.h.e.a(r2, 0);
        if (a0.l(r1, r4) == false) goto L19;
        this.f22194h = a0.g(r2, 4, r0);
        int r5 = 4 + r0;
        this.f22195i = a0.g(r2, r5, r0);
        int r6 = r5 + r0;
        this.f22196j = a0.g(r2, r6, r0);
        int r7 = r6 + r0;
        this.f22197k = a0.g(r2, r7, r0);
        int r8 = r7 + r0;
        l.b.g.b.h.a r10 = (l.b.g.b.h.a) a0.f(a0.g(r2, r8, r2.length - r8), l.b.g.b.h.a.class);     // Catch: ClassNotFoundException -> L12 IOException -> L15
        if (r10.b() != r4) goto L11;
        this.f22198l = r10.h(b.a(r9).g());     // Catch: ClassNotFoundException -> L12 IOException -> L15
        return;
    L11:
        throw new IllegalStateException("serialized BDS has wrong index");     // Catch: ClassNotFoundException -> L12 IOException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L12:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L19:
        throw new IllegalArgumentException("index out of bounds");
    L20:
        byte[] r11 = b.c(r9);
        if (r11 != null) goto L23;
        this.f22194h = new byte[r0];
    L28:
        byte[] r12 = b.d(r9);
        if (r12 != null) goto L31;
        this.f22195i = new byte[r0];
    L36:
        byte[] r13 = b.e(r9);
        if (r13 != null) goto L39;
        this.f22196j = new byte[r0];
    L44:
        byte[] r14 = b.f(r9);
        if (r14 != null) goto L47;
        this.f22197k = new byte[r0];
    L52:
        l.b.g.b.h.a r15 = b.g(r9);
        if (r15 == null) goto L56;
    L54:
        this.f22198l = r15;
        if (b.i(r9) >= 0) goto L64;
        return;
    L64:
        if (b.i(r9) != this.f22198l.c()) goto L67;
        return;
    L67:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L56:
        if (b.h(r9) >= ((1 << r3.b()) - 2)) goto L60;
        if (r13 == null) goto L60;
        if (r11 == null) goto L60;
        r15 = new l.b.g.b.h.a(r3, r13, r11, (j) new j.b().l(), b.h(r9));
    L60:
        r15 = new l.b.g.b.h.a(r3, (1 << r3.b()) - 1, b.h(r9));
        goto L54
    L47:
        if (r14.length != r0) goto L50;
        this.f22197k = r14;
        goto L52
    L50:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L39:
        if (r13.length != r0) goto L42;
        this.f22196j = r13;
        goto L44
    L42:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L31:
        if (r12.length != r0) goto L34;
        this.f22195i = r12;
        goto L36
    L34:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L23:
        if (r11.length != r0) goto L26;
        this.f22194h = r11;
        goto L28
    L26:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    }

    /* synthetic */ y(b r1, a r2) {
        this(r1);
    }

    public x b() {
        return this.f22193g;
    }

    public byte[] c() {
        monitor-enter(this);
        int r0 = this.f22193g.h();     // Catch: Throwable -> L11
        byte[] r1 = new byte[(((r0 + 4) + r0) + r0) + r0];     // Catch: Throwable -> L11
        l.b.h.e.c(this.f22198l.b(), r1, 0);     // Catch: Throwable -> L11
        a0.e(r1, this.f22194h, 4);     // Catch: Throwable -> L11
        int r3 = 4 + r0;     // Catch: Throwable -> L11
        a0.e(r1, this.f22195i, r3);     // Catch: Throwable -> L11
        int r4 = r3 + r0;     // Catch: Throwable -> L11
        a0.e(r1, this.f22196j, r4);     // Catch: Throwable -> L11
        a0.e(r1, this.f22197k, r4 + r0);     // Catch: Throwable -> L11
        byte[] r2 = l.b.h.a.f(r1, a0.p(this.f22198l));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r2;
    L8:
        e = move-exception;
        throw new RuntimeException("error serializing bds state: " + e.getMessage());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // l.b.h.c
    public byte[] getEncoded() {
        monitor-enter(this);
        byte[] r0 = c();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
