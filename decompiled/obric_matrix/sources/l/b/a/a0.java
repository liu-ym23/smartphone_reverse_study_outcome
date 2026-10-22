package l.b.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends t implements e, w1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f21509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f21510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final e f21511h;

    public a0(boolean r2, int r3, e r4) {
        Objects.requireNonNull(r4, "'obj' cannot be null");
        this.f21509f = r3;
        if (r2 == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        this.f21510g = r5;
        this.f21511h = r4;
        return;
    L5:
        if ((r4 instanceof d) == true) goto L8;
        r5 = false;
        goto L9
    }

    public static a0 w(Object r3) {
        if (r3 == null) goto L16;
        if ((r3 instanceof a0) == true) goto L16;
        if ((r3 instanceof byte[]) == false) goto L14;
        return w(t.s((byte[]) r3));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
    L14:
        throw new IllegalArgumentException("unknown object in getInstance: " + r3.getClass().getName());
    L16:
        return (a0) r3;
    }

    @Override // l.b.a.w1
    public t d() {
        b();
        return this;
    }

    @Override // l.b.a.n
    public int hashCode() {
        int r0 = this.f21509f;
        if (this.f21510g == false) goto L5;
        int r1 = 15;
    L6:
        int r2 = this.f21511h.b().hashCode();
        return r2 ^ (r0 ^ r1);
    L5:
        r1 = 240;
        goto L6
    }

    @Override // l.b.a.t
    boolean n(t r4) {
        if ((r4 instanceof a0) == true) goto L5;
        return false;
    L5:
        a0 r5 = (a0) r4;
        if (this.f21509f == r5.f21509f) goto L8;
        return false;
    L8:
        if (this.f21510g != r5.f21510g) goto L18;
        t r3 = this.f21511h.b();
        t r6 = r5.f21511h.b();
        if (r3 != r6) goto L13;
    L14:
        return true;
    L13:
        if (r3.n(r6) == true) goto L14;
        return false;
    L18:
        return false;
    }

    public String toString() {
        return "[" + this.f21509f + "]" + this.f21511h;
    }

    @Override // l.b.a.t
    t u() {
        return new f1(this.f21510g, this.f21509f, this.f21511h);
    }

    @Override // l.b.a.t
    t v() {
        return new t1(this.f21510g, this.f21509f, this.f21511h);
    }

    public t x() {
        return this.f21511h.b();
    }

    public int y() {
        return this.f21509f;
    }

    public boolean z() {
        return this.f21510g;
    }
}
