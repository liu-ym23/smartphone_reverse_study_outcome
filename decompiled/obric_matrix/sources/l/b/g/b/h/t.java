package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends q implements l.b.h.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f22174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f22176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22177j;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f22178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f22179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f22180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22181d;

        public b(r r2) {
            this.f22179b = null;
            this.f22180c = null;
            this.f22181d = null;
            this.f22178a = r2;
        }

        static /* synthetic */ r a(b r0) {
            return r0.f22178a;
        }

        static /* synthetic */ byte[] b(b r0) {
            return r0.f22181d;
        }

        static /* synthetic */ byte[] c(b r0) {
            return r0.f22179b;
        }

        static /* synthetic */ byte[] d(b r0) {
            return r0.f22180c;
        }

        public t e() {
            return new t(this, null);
        }

        public b f(byte[] r1) {
            this.f22181d = a0.c(r1);
            return this;
        }

        public b g(byte[] r1) {
            this.f22180c = a0.c(r1);
            return this;
        }

        public b h(byte[] r1) {
            this.f22179b = a0.c(r1);
            return this;
        }
    }

    private t(b r5) {
        super(false, b.a(r5).e());
        r r0 = b.a(r5);
        this.f22174g = r0;
        Objects.requireNonNull(r0, "params == null");
        int r2 = r0.f();
        byte[] r3 = b.b(r5);
        if (r3 == null) goto L13;
        if (r3.length != (r2 + r2)) goto L8;
        this.f22175h = 0;
        this.f22176i = a0.g(r3, 0, r2);
        this.f22177j = a0.g(r3, r2 + 0, r2);
        return;
    L8:
        if (r3.length != ((r2 + 4) + r2)) goto L11;
        this.f22175h = l.b.h.e.a(r3, 0);
        this.f22176i = a0.g(r3, 4, r2);
        this.f22177j = a0.g(r3, 4 + r2, r2);
        return;
    L11:
        throw new IllegalArgumentException("public key has wrong size");
    L13:
        if (r0.d() == null) goto L15;
        this.f22175h = r0.d().a();
    L16:
        byte[] r1 = b.c(r5);
        if (r1 != null) goto L19;
        this.f22176i = new byte[r2];
    L24:
        byte[] r6 = b.d(r5);
        if (r6 != null) goto L27;
        this.f22177j = new byte[r2];
        return;
    L27:
        if (r6.length != r2) goto L30;
        this.f22177j = r6;
        return;
    L30:
        throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
    L19:
        if (r1.length != r2) goto L22;
        this.f22176i = r1;
        goto L24
    L22:
        throw new IllegalArgumentException("length of root must be equal to length of digest");
    L15:
        this.f22175h = 0;
        goto L16
    }

    /* synthetic */ t(b r1, a r2) {
        this(r1);
    }

    public r b() {
        return this.f22174g;
    }

    public byte[] c() {
        return a0.c(this.f22177j);
    }

    public byte[] d() {
        return a0.c(this.f22176i);
    }

    public byte[] e() {
        int r0 = this.f22174g.f();
        int r1 = this.f22175h;
        int r2 = 0;
        if (r1 == 0) goto L5;
        byte[] r3 = new byte[(r0 + 4) + r0];
        l.b.h.e.c(r1, r3, 0);
        r2 = 4;
    L6:
        a0.e(r3, this.f22176i, r2);
        byte[] r4 = this.f22177j;
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
