package l.b.g.b.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short[][][] f22066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private short[][][] f22067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[][] f22068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short[] f22069g;

    public a(byte r1, byte r2, short[][][] r3, short[][][] r4, short[][] r5, short[] r6) {
        int r7 = r1 & 255;
        this.f22063a = r7;
        int r8 = r2 & 255;
        this.f22064b = r8;
        this.f22065c = r8 - r7;
        this.f22066d = r3;
        this.f22067e = r4;
        this.f22068f = r5;
        this.f22069g = r6;
    }

    public short[][][] a() {
        return this.f22066d;
    }

    public short[][][] b() {
        return this.f22067e;
    }

    public short[] c() {
        return this.f22069g;
    }

    public short[][] d() {
        return this.f22068f;
    }

    public int e() {
        return this.f22065c;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof a) == false) goto L31;
        a r5 = (a) r4;
        if (this.f22063a == r5.f()) goto L10;
        return false;
    L10:
        if (this.f22064b == r5.g()) goto L12;
        return false;
    L12:
        if (this.f22065c == r5.e()) goto L14;
        return false;
    L14:
        if (l.b.g.b.e.b.a.k(this.f22066d, r5.a()) == true) goto L16;
        return false;
    L16:
        if (l.b.g.b.e.b.a.k(this.f22067e, r5.b()) == true) goto L18;
        return false;
    L18:
        if (l.b.g.b.e.b.a.j(this.f22068f, r5.d()) == true) goto L20;
        return false;
    L20:
        if (l.b.g.b.e.b.a.i(this.f22069g, r5.c()) == false) goto L30;
        return true;
    L30:
        return false;
    L31:
        return false;
    }

    public int f() {
        return this.f22063a;
    }

    public int g() {
        return this.f22064b;
    }

    public int hashCode() {
        return (((((((((((this.f22063a * 37) + this.f22064b) * 37) + this.f22065c) * 37) + l.b.h.a.p(this.f22066d)) * 37) + l.b.h.a.p(this.f22067e)) * 37) + l.b.h.a.o(this.f22068f)) * 37) + l.b.h.a.n(this.f22069g);
    }
}
