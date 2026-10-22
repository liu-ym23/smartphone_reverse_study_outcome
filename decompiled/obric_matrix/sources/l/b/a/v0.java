package l.b.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class v0 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21765f;

    public v0(String r2) {
        this(r2, false);
    }

    public v0(String r2, boolean r3) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        if (r3 == true) goto L5;
    L9:
        this.f21765f = l.b.h.g.e(r2);
        return;
    L5:
        if (w(r2) == true) goto L9;
        throw new IllegalArgumentException("'string' contains illegal characters");
    }

    v0(byte[] r1) {
        this.f21765f = r1;
    }

    public static boolean w(String r4) {
        int r0 = r4.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (r4.charAt(r0) > 127) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Override // l.b.a.z
    public String c() {
        return l.b.h.g.b(this.f21765f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21765f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof v0) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21765f, ((v0) r2).f21765f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 22, this.f21765f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21765f.length) + 1) + this.f21765f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
