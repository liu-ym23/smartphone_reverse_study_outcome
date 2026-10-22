package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends p implements l.b.h.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x f22208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f22210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22211j;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f22212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f22213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f22214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22215d;

        public b(x r2) {
            this.f22213b = null;
            this.f22214c = null;
            this.f22215d = null;
            this.f22212a = r2;
        }

        static /* synthetic */ x a(b r0) {
            return r0.f22212a;
        }

        static /* synthetic */ byte[] b(b r0) {
            return r0.f22215d;
        }

        static /* synthetic */ byte[] c(b r0) {
            return r0.f22213b;
        }

        static /* synthetic */ byte[] d(b r0) {
            return r0.f22214c;
        }

        public z e() {
            return new z(this, null);
        }

        public b f(byte[] r1) {
            this.f22215d = a0.c(r1);
            return this;
        }

        public b g(byte[] r1) {
            this.f22214c = a0.c(r1);
            return this;
        }

        public b h(byte[] r1) {
            this.f22213b = a0.c(r1);
            return this;
        }
    }

    private z(b r5) {
        super(false, b.a(r5).f());
        x r0 = b.a(r5);
        this.f22208g = r0;
        Objects.requireNonNull(r0, "params == null");
        int r2 = r0.h();
        byte[] r3 = b.b(r5);
        if (r3 == null) goto L13;
        if (r3.length != (r2 + r2)) goto L8;
        this.f22209h = 0;
        this.f22210i = a0.g(r3, 0, r2);
        this.f22211j = a0.g(r3, r2 + 0, r2);
        return;
    L8:
        if (r3.length != ((r2 + 4) + r2)) goto L11;
        this.f22209h = l.b.h.e.a(r3, 0);
        this.f22210i = a0.g(r3, 4, r2);
        this.f22211j = a0.g(r3, 4 + r2, r2);
        return;
    L11:
        throw new IllegalArgumentException("public key has wrong size");
    L13:
        if (r0.e() == null) goto L15;
        this.f22209h = r0.e().a();
    L16:
        byte[] r1 = b.c(r5);
        if (r1 != null) goto L19;
        this.f22210i = new byte[r2];
    L24:
        byte[] r6 = b.d(r5);
        if (r6 != null) goto L27;
        this.f22211j = new byte[r2];
        return;
    L27:
        if (r6.length != r2) goto L30;
        this.f22211j = r6;
        return;
    L30:
        throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
    L19:
        if (r1.length != r2) goto L22;
        this.f22210i = r1;
        goto L24
    L22:
        throw new IllegalArgumentException("length of root must be equal to length of digest");
    L15:
        this.f22209h = 0;
        goto L16
    }

    /* synthetic */ z(b r1, a r2) {
        this(r1);
    }

    public x b() {
        return this.f22208g;
    }

    public byte[] c() {
        return a0.c(this.f22211j);
    }

    public byte[] d() {
        return a0.c(this.f22210i);
    }

    public byte[] e() {
        int r0 = this.f22208g.h();
        int r1 = this.f22209h;
        int r2 = 0;
        if (r1 == 0) goto L5;
        byte[] r3 = new byte[(r0 + 4) + r0];
        l.b.h.e.c(r1, r3, 0);
        r2 = 4;
    L6:
        a0.e(r3, this.f22210i, r2);
        byte[] r4 = this.f22211j;
        a0.e(r3, r4, r2 + r0);
        return r3;
    L5:
        r3 = new byte[r0 + r0];
        goto L6
    }

    @Override // l.b.h.c
    public byte[] getEncoded() {
        return e();
    }
}
