package l.b.a;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends t implements Object<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final e[] f21790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final boolean f21791g;

    class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f21792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f21793b;

        a(w r1) {
            this.f21793b = r1;
            this.f21792a = 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.f21792a >= this.f21793b.f21790f.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int r0 = this.f21792a;
            e[] r1 = this.f21793b.f21790f;
            if (r0 >= r1.length) goto L7;
            this.f21792a = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException();
        }
    }

    protected w() {
        this.f21790f = f.f21555d;
        this.f21791g = true;
    }

    protected w(e r4) {
        Objects.requireNonNull(r4, "'element' cannot be null");
        this.f21790f = new e[]{r4};
        this.f21791g = true;
    }

    protected w(f r3, boolean r4) {
        Objects.requireNonNull(r3, "'elementVector' cannot be null");
        if (r4 == true) goto L5;
    L7:
        e[] r5 = r3.g();
    L8:
        this.f21790f = r5;
        if (r4 == false) goto L11;
    L14:
        boolean r6 = true;
    L15:
        this.f21791g = r6;
        return;
    L11:
        if (r5.length < 2) goto L14;
        r6 = false;
        goto L15
    L5:
        if (r3.f() < 2) goto L7;
        r5 = r3.c();
        C(r5);
        goto L8
    }

    w(boolean r1, e[] r2) {
        this.f21790f = r2;
        if (r1 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        this.f21791g = r3;
        return;
    L5:
        if (r2.length < 2) goto L8;
        r3 = false;
        goto L9
    }

    protected w(e[] r3, boolean r4) {
        if (l.b.h.a.q(r3) == true) goto L19;
        e[] r5 = f.b(r3);
        if (r4 == true) goto L7;
    L9:
        this.f21790f = r5;
        if (r4 == false) goto L12;
    L15:
        boolean r6 = true;
    L16:
        this.f21791g = r6;
        return;
    L12:
        if (r5.length < 2) goto L15;
        r6 = false;
        goto L16
    L7:
        if (r5.length < 2) goto L9;
        C(r5);
        goto L9
    L19:
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    private static boolean B(byte[] r6, byte[] r7) {
        int r1 = r6[0] & (-33);
        int r2 = r7[0] & (-33);
        if (r1 == r2) goto L7;
        if (r1 < r2) goto L6;
        return false;
    L6:
        return true;
    L7:
        int r3 = Math.min(r6.length, r7.length) - 1;
        int r4 = 1;
    L8:
        if (r4 >= r3) goto L17;
        if (r6[r4] != r7[r4]) goto L12;
        r4 = r4 + 1;
        goto L8
    L12:
        if ((r6[r4] & 255) < (r7[r4] & 255)) goto L14;
        return false;
    L14:
        return true;
    L17:
        if ((r6[r3] & 255) <= (r7[r3] & 255)) goto L19;
        return false;
    L19:
        return true;
    }

    private static void C(e[] r14) {
        int r0 = r14.length;
        int r1 = 2;
        if (r0 >= 2) goto L5;
        return;
    L5:
        e r2 = r14[0];
        e r4 = r14[1];
        byte[] r5 = w(r2);
        byte[] r6 = w(r4);
        if (B(r6, r5) == false) goto L8;
        r4 = r2;
        r2 = r4;
        r6 = r5;
        r5 = r6;
    L8:
        if (r1 >= r0) goto L24;
        e r7 = r14[r1];
        byte[] r8 = w(r7);
        if (B(r6, r8) == false) goto L13;
        r14[r1 - 2] = r2;
        r2 = r4;
        r5 = r6;
        r4 = r7;
        r6 = r8;
    L23:
        r1 = r1 + 1;
        goto L8
    L13:
        if (B(r5, r8) == false) goto L15;
        r14[r1 - 2] = r2;
        r2 = r7;
        r5 = r8;
        goto L23
    L15:
        int r9 = r1 - 1;
    L16:
        r9 = r9 - 1;
        if (r9 <= 0) goto L22;
        e r10 = r14[r9 - 1];
        if (B(w(r10), r8) == true) goto L22;
        r14[r9] = r10;
    L22:
        r14[r9] = r7;
        goto L23
    L24:
        r14[r0 - 2] = r2;
        r14[r0 - 1] = r4;
    }

    private static byte[] w(e r1) {
        return r1.b().m("DER");
    L5:
        throw new IllegalArgumentException("cannot encode object added to SET");
    }

    public static w x(Object r3) {
        if (r3 == null) goto L26;
        if ((r3 instanceof w) == true) goto L26;
        if ((r3 instanceof x) == false) goto L11;
        return x(((x) r3).b());
    L11:
        if ((r3 instanceof byte[]) == false) goto L18;
        return x(t.s((byte[]) r3));
    L14:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
    L18:
        if ((r3 instanceof e) == false) goto L24;
        t r0 = ((e) r3).b();
        if ((r0 instanceof w) == false) goto L24;
        return (w) r0;
    L24:
        throw new IllegalArgumentException("unknown object in getInstance: " + r3.getClass().getName());
    L26:
        return (w) r3;
    }

    public static w y(a0 r2, boolean r3) {
        if (r3 == true) goto L4;
        t r4 = r2.x();
        if (r2.z() == false) goto L18;
        if ((r2 instanceof l0) == false) goto L16;
        return new j0(r4);
    L16:
        return new r1(r4);
    L18:
        if ((r4 instanceof w) == false) goto L25;
        w r5 = (w) r4;
        if ((r2 instanceof l0) == false) goto L23;
        return r5;
    L23:
        return (w) r5.v();
    L25:
        if ((r4 instanceof u) == false) goto L33;
        e[] r6 = ((u) r4).A();
        if ((r2 instanceof l0) == false) goto L31;
        return new j0(false, r6);
    L31:
        return new r1(false, r6);
    L33:
        throw new IllegalArgumentException("unknown object in getInstance: " + r2.getClass().getName());
    L4:
        if (r2.z() == false) goto L8;
        return x(r2.x());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    public Enumeration A() {
        return new a(this);
    }

    public e[] D() {
        return f.b(this.f21790f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        int r0 = this.f21790f.length;
        int r1 = r0 + 1;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        r1 = r1 + this.f21790f[r0].b().hashCode();
        goto L3
    L6:
        return r1;
    }

    public Iterator<e> iterator() {
        return new l.b.h.a.C0598a(D());
    }

    @Override // l.b.a.t
    boolean n(t r6) {
        if ((r6 instanceof w) == true) goto L5;
        return false;
    L5:
        w r7 = (w) r6;
        int r0 = size();
        if (r7.size() == r0) goto L8;
        return false;
    L8:
        d1 r5 = (d1) u();
        d1 r8 = (d1) r7.u();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L16;
        t r3 = r5.f21790f[r2].b();
        t r4 = r8.f21790f[r2].b();
        if (r3 == r4) goto L15;
        if (r3.n(r4) == true) goto L15;
        return false;
    L15:
        r2 = r2 + 1;
        goto L9
    L16:
        return true;
    }

    public int size() {
        return this.f21790f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        int r0 = size();
        if (r0 != 0) goto L6;
        return "[]";
    L6:
        StringBuffer r1 = new StringBuffer();
        r1.append('[');
        int r2 = 0;
    L7:
        r1.append(this.f21790f[r2]);
        r2 = r2 + 1;
        if (r2 >= r0) goto L9;
        r1.append(", ");
        goto L7
    L9:
        r1.append(']');
        return r1.toString();
    }

    @Override // l.b.a.t
    t u() {
        boolean r0 = this.f21791g;
        e[] r2 = this.f21790f;
        if (r0 == true) goto L7;
        r2 = (e[]) r2.clone();
        C(r2);
    L7:
        return new d1(true, r2);
    }

    @Override // l.b.a.t
    t v() {
        return new r1(this.f21791g, this.f21790f);
    }

    public e z(int r1) {
        return this.f21790f[r1];
    }
}
