package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    private static a p;
    private static a[] q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f22006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final k f22007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f22008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f22009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<a, byte[]> f22011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f22012l;
    private final l.b.b.a m;
    private int n;
    private i o;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22013a;

        a(int r1) {
            this.f22013a = r1;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f22013a;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof a) == true) goto L5;
            return false;
        L5:
            if (((a) r3).f22013a != this.f22013a) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.f22013a;
        }
    }

    static {
        a r0 = new a(1);
        p = r0;
        a[] r2 = new a[129];
        q = r2;
        r2[1] = r0;
        int r1 = 2;
    L3:
        a[] r3 = q;
        if (r1 >= r3.length) goto L6;
        r3[r1] = new a(r1);
        r1 = r1 + 1;
        goto L3
    }

    public h(k r2, e r3, int r4, byte[] r5, int r6, byte[] r7) {
        super(true);
        this.f22007g = r2;
        this.f22008h = r3;
        this.n = r4;
        this.f22006f = l.b.h.a.d(r5);
        this.f22009i = r6;
        this.f22010j = l.b.h.a.d(r7);
        this.f22012l = 1 << (r2.c() + 1);
        this.f22011k = new WeakHashMap();
        this.m = b.a(r2.b());
    }

    private byte[] a(int r6) {
        int r0 = 1 << j().c();
        if (r6 < r0) goto L6;
        m.a(d(), this.m);
        m.c(r6, this.m);
        m.b(-32126, this.m);
        m.a(l.a(h(), d(), r6 - r0, g()), this.m);
        byte[] r7 = new byte[this.m.f()];
        this.m.a(r7, 0);
        return r7;
    L6:
        int r1 = r6 * 2;
        byte[] r3 = b(r1);
        byte[] r2 = b(r1 + 1);
        m.a(d(), this.m);
        m.c(r6, this.m);
        m.b(-31869, this.m);
        m.a(r3, this.m);
        m.a(r2, this.m);
        byte[] r8 = new byte[this.m.f()];
        this.m.a(r8, 0);
        return r8;
    }

    private byte[] c(a r3) {
        Map<a, byte[]> r0 = this.f22011k;
        monitor-enter(r0);
        byte[] r1 = this.f22011k.get(r3);     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L8:
        byte[] r2 = a(a.a(r3));     // Catch: Throwable -> L11
        this.f22011k.put(r3, r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public static h e(Object r8) {
        if ((r8 instanceof h) == false) goto L7;
        return (h) r8;
    L7:
        if ((r8 instanceof DataInputStream) == false) goto L23;
        DataInputStream r9 = (DataInputStream) r8;
        if (r9.readInt() != 0) goto L21;
        k r2 = k.e(r9.readInt());
        e r3 = e.e(r9.readInt());
        byte[] r5 = new byte[16];
        r9.readFully(r5);
        int r4 = r9.readInt();
        int r6 = r9.readInt();
        int r0 = r9.readInt();
        if (r0 < 0) goto L19;
        if (r0 > r9.available()) goto L17;
        byte[] r7 = new byte[r0];
        r9.readFully(r7);
        return new h(r2, r3, r4, r5, r6, r7);
    L17:
        throw new IOException("secret length exceeded " + r9.available());
    L19:
        throw new IllegalStateException("secret length less than zero");
    L21:
        throw new IllegalStateException("expected version 0 lms private key");
    L23:
        if ((r8 instanceof byte[]) == false) goto L36;
        DataInputStream r1 = null;
        DataInputStream r10 = new DataInputStream(new ByteArrayInputStream((byte[]) r8));     // Catch: Throwable -> L31
        h r11 = e(r10);     // Catch: Throwable -> L29
        r10.close();
        return r11;
    L29:
        th = th;
        r1 = r10;
    L32:
        if (r1 == null) goto L34;
        r1.close();
    L34:
        throw th;
    L31:
        th = th;
        goto L32
    L36:
        if ((r8 instanceof InputStream) == false) goto L40;
        return e(l.b.h.i.a.b((InputStream) r8));
    L40:
        throw new IllegalArgumentException("cannot parse " + r8);
    }

    public static h f(byte[] r0, byte[] r1) {
        h r2 = e(r0);
        r2.o = i.a(r1);
        return r2;
    }

    byte[] b(int r3) {
        if (r3 >= this.f22012l) goto L11;
        a[] r0 = q;
        if (r3 >= r0.length) goto L7;
        a r4 = r0[r3];
    L9:
        return c(r4);
    L7:
        r4 = new a(r3);
        goto L9
    L11:
        return a(r3);
    }

    public byte[] d() {
        return l.b.h.a.d(this.f22006f);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L45:
        return false;
    L8:
        if (h.class != r5.getClass()) goto L45;
        h r6 = (h) r5;
        if (this.n == r6.n) goto L14;
        return false;
    L14:
        if (this.f22009i == r6.f22009i) goto L17;
        return false;
    L17:
        if (l.b.h.a.a(this.f22006f, r6.f22006f) == true) goto L19;
        return false;
    L19:
        k r2 = this.f22007g;
        if (r2 == null) goto L25;
        if (r2.equals(r6.f22007g) == false) goto L26;
    L27:
        e r3 = this.f22008h;
        if (r3 == null) goto L33;
        if (r3.equals(r6.f22008h) == true) goto L36;
    L34:
        return false;
    L36:
        if (l.b.h.a.a(this.f22010j, r6.f22010j) == true) goto L38;
        return false;
    L38:
        i r4 = this.o;
        if (r4 == null) goto L44;
        i r7 = r6.o;
        if (r7 == null) goto L44;
        return r4.equals(r7);
    L44:
        return true;
    L33:
        if (r6.f22008h == null) goto L36;
    L26:
        return false;
    L25:
        if (r6.f22007g == null) goto L27;
        goto L26
    }

    public byte[] g() {
        return l.b.h.a.d(this.f22010j);
    }

    @Override // l.b.g.b.a.g, l.b.h.c
    public byte[] getEncoded() {
        l.b.g.b.a.a r0 = l.b.g.b.a.a.f();
        r0.i(0);
        r0.i(this.f22007g.f());
        r0.i(this.f22008h.f());
        r0.d(this.f22006f);
        r0.i(this.n);
        r0.i(this.f22009i);
        r0.i(this.f22010j.length);
        r0.d(this.f22010j);
        return r0.b();
    }

    public e h() {
        return this.f22008h;
    }

    public int hashCode() {
        int r0 = ((this.n * 31) + l.b.h.a.j(this.f22006f)) * 31;
        k r1 = this.f22007g;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        e r5 = this.f22008h;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((r4 + r6) * 31) + this.f22009i) * 31) + l.b.h.a.j(this.f22010j)) * 31;
        i r8 = this.o;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public i i() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.o != null) goto L6;
        this.o = new i(this.f22007g, this.f22008h, c(p), this.f22006f);     // Catch: Throwable -> L9
    L6:
        i r0 = this.o;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    }

    public k j() {
        return this.f22007g;
    }
}
