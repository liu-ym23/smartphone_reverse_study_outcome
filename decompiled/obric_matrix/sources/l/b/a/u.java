package l.b.a;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends t implements Object<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    e[] f21731f;

    class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f21732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f21733b;

        a(u r1) {
            this.f21733b = r1;
            this.f21732a = 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.f21732a >= this.f21733b.f21731f.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int r0 = this.f21732a;
            e[] r1 = this.f21733b.f21731f;
            if (r0 >= r1.length) goto L7;
            this.f21732a = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException();
        }
    }

    protected u() {
        this.f21731f = f.f21555d;
    }

    protected u(e r3) {
        Objects.requireNonNull(r3, "'element' cannot be null");
        this.f21731f = new e[]{r3};
    }

    protected u(f r2) {
        Objects.requireNonNull(r2, "'elementVector' cannot be null");
        this.f21731f = r2.g();
    }

    protected u(e[] r2) {
        if (l.b.h.a.q(r2) == true) goto L7;
        this.f21731f = f.b(r2);
        return;
    L7:
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    u(e[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = f.b(r1);
    L5:
        this.f21731f = r1;
    }

    public static u w(Object r3) {
        if (r3 == null) goto L26;
        if ((r3 instanceof u) == true) goto L26;
        if ((r3 instanceof v) == false) goto L11;
        return w(((v) r3).b());
    L11:
        if ((r3 instanceof byte[]) == false) goto L18;
        return w(t.s((byte[]) r3));
    L14:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
    L18:
        if ((r3 instanceof e) == false) goto L24;
        t r0 = ((e) r3).b();
        if ((r0 instanceof u) == false) goto L24;
        return (u) r0;
    L24:
        throw new IllegalArgumentException("unknown object in getInstance: " + r3.getClass().getName());
    L26:
        return (u) r3;
    }

    public static u x(a0 r2, boolean r3) {
        if (r3 == true) goto L4;
        t r4 = r2.x();
        if (r2.z() == false) goto L18;
        if ((r2 instanceof l0) == false) goto L16;
        return new h0(r4);
    L16:
        return new p1(r4);
    L18:
        if ((r4 instanceof u) == false) goto L25;
        u r5 = (u) r4;
        if ((r2 instanceof l0) == false) goto L23;
        return r5;
    L23:
        return (u) r5.v();
    L25:
        throw new IllegalArgumentException("unknown object in getInstance: " + r2.getClass().getName());
    L4:
        if (r2.z() == false) goto L8;
        return w(r2.x());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    e[] A() {
        return this.f21731f;
    }

    @Override // l.b.a.n
    public int hashCode() {
        int r0 = this.f21731f.length;
        int r1 = r0 + 1;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        r1 = (r1 * 257) ^ this.f21731f[r0].b().hashCode();
        goto L3
    L6:
        return r1;
    }

    public Iterator<e> iterator() {
        return new l.b.h.a.C0598a(this.f21731f);
    }

    @Override // l.b.a.t
    boolean n(t r6) {
        if ((r6 instanceof u) == true) goto L5;
        return false;
    L5:
        u r7 = (u) r6;
        int r0 = size();
        if (r7.size() == r0) goto L8;
        return false;
    L8:
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L16;
        t r3 = this.f21731f[r2].b();
        t r4 = r7.f21731f[r2].b();
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
        return this.f21731f.length;
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
        r1.append(this.f21731f[r2]);
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
        return new c1(this.f21731f, false);
    }

    @Override // l.b.a.t
    t v() {
        return new p1(this.f21731f, false);
    }

    public e y(int r1) {
        return this.f21731f[r1];
    }

    public Enumeration z() {
        return new a(this);
    }
}
