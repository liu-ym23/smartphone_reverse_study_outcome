package l.b.a.u2;

import java.util.Enumeration;
import l.b.a.c1;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class c extends n implements l.b.a.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static e f21740k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f21741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f21743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b[] f21744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c1 f21745j;

    static {
        f21740k = l.b.a.u2.f.b.P;
    }

    public c(String r2) {
        this(f21740k, r2);
    }

    public c(e r1, String r2) {
        this(r1.b(r2));
        this.f21743h = r1;
    }

    private c(e r8, u r9) {
        this.f21743h = r8;
        this.f21744i = new b[r9.size()];
        Enumeration r10 = r9.z();
        int r3 = 0;
        boolean r2 = true;
    L4:
        if (r10.hasMoreElements() == false) goto L10;
        Object r4 = r10.nextElement();
        b r5 = b.o(r4);
        if (r5 != r4) goto L8;
        boolean r6 = true;
    L9:
        r2 = r2 & r6;
        this.f21744i[r3] = r5;
        r3 = r3 + 1;
        goto L4
    L8:
        r6 = false;
        goto L9
    L10:
        if (r2 == false) goto L12;
        c1 r11 = c1.B(r9);
    L13:
        this.f21745j = r11;
        return;
    L12:
        r11 = new c1(this.f21744i);
        goto L13
    }

    public c(e r1, b[] r2) {
        this.f21743h = r1;
        b[] r3 = (b[]) r2.clone();
        this.f21744i = r3;
        this.f21745j = new c1(r3);
    }

    private c(u r2) {
        this(f21740k, r2);
    }

    public c(b[] r2) {
        this(f21740k, r2);
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        return this.f21745j;
    }

    @Override // l.b.a.n
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == false) goto L8;
    L10:
        t r1 = ((l.b.a.e) r5).b();
        if (b().r(r1) == false) goto L16;
        return true;
    L16:
        return this.f21743h.a(this, new c(u.w(((l.b.a.e) r5).b())));
    L15:
        return false;
    L8:
        if ((r5 instanceof u) == true) goto L10;
        return false;
    }

    @Override // l.b.a.n
    public int hashCode() {
        if (this.f21741f == true) goto L5;
        this.f21741f = true;
        int r0 = this.f21743h.d(this);
        this.f21742g = r0;
        return r0;
    L5:
        return this.f21742g;
    }

    public b[] n() {
        return (b[]) this.f21744i.clone();
    }

    public String toString() {
        return this.f21743h.f(this);
    }
}
