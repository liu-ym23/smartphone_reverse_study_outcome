package l.b.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends t implements q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f21659f;

    public p(byte[] r2) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        this.f21659f = r2;
    }

    public static p w(Object r3) {
        if (r3 == null) goto L22;
        if ((r3 instanceof p) == true) goto L22;
        if ((r3 instanceof byte[]) == false) goto L14;
        return w(t.s((byte[]) r3));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
    L14:
        if ((r3 instanceof e) == false) goto L20;
        t r0 = ((e) r3).b();
        if ((r0 instanceof p) == false) goto L20;
        return (p) r0;
    L20:
        throw new IllegalArgumentException("illegal object in getInstance: " + r3.getClass().getName());
    L22:
        return (p) r3;
    }

    public static p x(a0 r2, boolean r3) {
        if (r3 == true) goto L4;
        t r4 = r2.x();
        if (r2.z() == false) goto L18;
        p r5 = w(r4);
        if ((r2 instanceof l0) == false) goto L16;
        return new f0(new p[]{r5});
    L16:
        return (p) new f0(new p[]{r5}).v();
    L18:
        if ((r4 instanceof p) == false) goto L25;
        p r6 = (p) r4;
        if ((r2 instanceof l0) == false) goto L23;
        return r6;
    L23:
        return (p) r6.v();
    L25:
        if ((r4 instanceof u) == false) goto L33;
        u r7 = (u) r4;
        if ((r2 instanceof l0) == false) goto L31;
        return f0.B(r7);
    L31:
        return (p) f0.B(r7).v();
    L33:
        throw new IllegalArgumentException("unknown object in getInstance: " + r2.getClass().getName());
    L4:
        if (r2.z() == false) goto L8;
        return w(r2.x());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    @Override // l.b.a.q
    public InputStream a() {
        return new ByteArrayInputStream(this.f21659f);
    }

    @Override // l.b.a.w1
    public t d() {
        b();
        return this;
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(y());
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof p) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21659f, ((p) r2).f21659f);
    }

    public String toString() {
        return "#" + l.b.h.g.b(l.b.h.h.f.b(this.f21659f));
    }

    @Override // l.b.a.t
    t u() {
        return new y0(this.f21659f);
    }

    @Override // l.b.a.t
    t v() {
        return new y0(this.f21659f);
    }

    public byte[] y() {
        return this.f21659f;
    }
}
