package l.b.g.b.h;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends q implements l.b.h.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f22158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f22159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f22160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final byte[] f22162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f22163l;
    private volatile l.b.g.b.h.b m;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f22164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f22165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f22168e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f22169f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f22170g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private l.b.g.b.h.b f22171h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f22172i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private x f22173j;

        public b(r r3) {
            this.f22165b = 0;
            this.f22166c = -1;
            this.f22167d = null;
            this.f22168e = null;
            this.f22169f = null;
            this.f22170g = null;
            this.f22171h = null;
            this.f22172i = null;
            this.f22173j = null;
            this.f22164a = r3;
        }

        static /* synthetic */ r a(b r0) {
            return r0.f22164a;
        }

        static /* synthetic */ byte[] b(b r0) {
            return r0.f22172i;
        }

        static /* synthetic */ x c(b r0) {
            return r0.f22173j;
        }

        static /* synthetic */ long d(b r2) {
            return r2.f22165b;
        }

        static /* synthetic */ byte[] e(b r0) {
            return r0.f22167d;
        }

        static /* synthetic */ byte[] f(b r0) {
            return r0.f22168e;
        }

        static /* synthetic */ byte[] g(b r0) {
            return r0.f22169f;
        }

        static /* synthetic */ byte[] h(b r0) {
            return r0.f22170g;
        }

        static /* synthetic */ l.b.g.b.h.b i(b r0) {
            return r0.f22171h;
        }

        static /* synthetic */ long j(b r2) {
            return r2.f22166c;
        }

        public s k() {
            return new s(this, null);
        }

        public b l(l.b.g.b.h.b r7) {
            if (r7.b() != 0) goto L5;
            this.f22171h = new l.b.g.b.h.b(r7, (1 << this.f22164a.a()) - 1);
        L6:
            return this;
        L5:
            this.f22171h = r7;
            goto L6
        }

        public b m(long r1) {
            this.f22165b = r1;
            return this;
        }

        public b n(long r1) {
            this.f22166c = r1;
            return this;
        }

        public b o(byte[] r1) {
            this.f22169f = a0.c(r1);
            return this;
        }

        public b p(byte[] r1) {
            this.f22170g = a0.c(r1);
            return this;
        }

        public b q(byte[] r1) {
            this.f22168e = a0.c(r1);
            return this;
        }

        public b r(byte[] r1) {
            this.f22167d = a0.c(r1);
            return this;
        }
    }

    private s(b r9) {
        super(true, b.a(r9).e());
        r r3 = b.a(r9);
        this.f22158g = r3;
        Objects.requireNonNull(r3, "params == null");
        int r0 = r3.f();
        byte[] r1 = b.b(r9);
        if (r1 == null) goto L17;
        Objects.requireNonNull(b.c(r9), "xmss == null");
        int r2 = r3.a();
        int r4 = (r2 + 7) / 8;
        this.f22163l = a0.a(r1, 0, r4);
        if (a0.l(r2, this.f22163l) == false) goto L16;
        int r5 = r4 + 0;
        this.f22159h = a0.g(r1, r5, r0);
        int r6 = r5 + r0;
        this.f22160i = a0.g(r1, r6, r0);
        int r7 = r6 + r0;
        this.f22161j = a0.g(r1, r7, r0);
        int r8 = r7 + r0;
        this.f22162k = a0.g(r1, r8, r0);
        int r10 = r8 + r0;
        this.m = ((l.b.g.b.h.b) a0.f(a0.g(r1, r10, r1.length - r10), l.b.g.b.h.b.class)).f(b.c(r9).g());     // Catch: ClassNotFoundException -> L9 IOException -> L12
    L68:
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L16:
        throw new IllegalArgumentException("index out of bounds");
    L17:
        this.f22163l = b.d(r9);
        byte[] r11 = b.e(r9);
        if (r11 != null) goto L20;
        this.f22159h = new byte[r0];
    L25:
        byte[] r12 = b.f(r9);
        if (r12 != null) goto L28;
        this.f22160i = new byte[r0];
    L33:
        byte[] r13 = b.g(r9);
        if (r13 != null) goto L36;
        this.f22161j = new byte[r0];
    L41:
        byte[] r14 = b.h(r9);
        if (r14 != null) goto L44;
        this.f22162k = new byte[r0];
    L49:
        l.b.g.b.h.b r15 = b.i(r9);
        if (r15 == null) goto L52;
    L51:
        this.m = r15;
        if (b.j(r9) >= 0) goto L61;
        return;
    L61:
        if (b.j(r9) != this.m.b()) goto L64;
        return;
    L64:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L52:
        long r16 = b.d(r9);
        if (a0.l(r3.a(), r16) == false) goto L57;
        if (r13 == null) goto L57;
        if (r11 == null) goto L57;
        r15 = new l.b.g.b.h.b(r3, b.d(r9), r13, r11);
    L57:
        r15 = new l.b.g.b.h.b(b.j(r9) + 1);
        goto L51
    L44:
        if (r14.length != r0) goto L47;
        this.f22162k = r14;
        goto L49
    L47:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L36:
        if (r13.length != r0) goto L39;
        this.f22161j = r13;
        goto L41
    L39:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L28:
        if (r12.length != r0) goto L31;
        this.f22160i = r12;
        goto L33
    L31:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L20:
        if (r11.length != r0) goto L23;
        this.f22159h = r11;
        goto L25
    L23:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    }

    /* synthetic */ s(b r1, a r2) {
        this(r1);
    }

    public r b() {
        return this.f22158g;
    }

    public byte[] c() {
        monitor-enter(this);
        int r0 = this.f22158g.f();     // Catch: Throwable -> L10
        int r1 = (this.f22158g.a() + 7) / 8;     // Catch: Throwable -> L10
        byte[] r2 = new byte[(((r1 + r0) + r0) + r0) + r0];     // Catch: Throwable -> L10
        a0.e(r2, a0.q(this.f22163l, r1), 0);     // Catch: Throwable -> L10
        int r3 = r1 + 0;     // Catch: Throwable -> L10
        a0.e(r2, this.f22159h, r3);     // Catch: Throwable -> L10
        int r4 = r3 + r0;     // Catch: Throwable -> L10
        a0.e(r2, this.f22160i, r4);     // Catch: Throwable -> L10
        int r5 = r4 + r0;     // Catch: Throwable -> L10
        a0.e(r2, this.f22161j, r5);     // Catch: Throwable -> L10
        a0.e(r2, this.f22162k, r5 + r0);     // Catch: Throwable -> L10
        byte[] r6 = l.b.h.a.f(r2, a0.p(this.m));     // Catch: IOException -> L7 Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r6;
    L7:
        e = move-exception;
        throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);     // Catch: Throwable -> L10
    L10:
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
