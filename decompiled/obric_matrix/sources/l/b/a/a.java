package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final boolean f21506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f21507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final byte[] f21508h;

    a(boolean r1, int r2, byte[] r3) {
        this.f21506f = r1;
        this.f21507g = r2;
        this.f21508h = l.b.h.a.d(r3);
    }

    @Override // l.b.a.n
    public int hashCode() {
        boolean r0 = this.f21506f;
        int r1 = this.f21507g;
        int r2 = (r0 ? 1 : 0) ^ r1;
        return l.b.h.a.j(this.f21508h) ^ r2;
    }

    @Override // l.b.a.t
    boolean n(t r4) {
        if ((r4 instanceof a) == true) goto L5;
        return false;
    L5:
        a r5 = (a) r4;
        if (this.f21506f == r5.f21506f) goto L8;
        return false;
    L8:
        if (this.f21507g == r5.f21507g) goto L10;
        return false;
    L10:
        if (l.b.h.a.a(this.f21508h, r5.f21508h) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // l.b.a.t
    void o(r r3, boolean r4) {
        if (this.f21506f == false) goto L5;
        int r0 = 96;
    L6:
        r3.m(r4, r0, this.f21507g, this.f21508h);
        return;
    L5:
        r0 = 64;
        goto L6
    }

    @Override // l.b.a.t
    int p() {
        return (c2.b(this.f21507g) + c2.a(this.f21508h.length)) + this.f21508h.length;
    }

    @Override // l.b.a.t
    public boolean t() {
        return this.f21506f;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append("[");
        if (t() == false) goto L5;
        r0.append("CONSTRUCTED ");
    L5:
        r0.append("APPLICATION ");
        r0.append(Integer.toString(w()));
        r0.append("]");
        if (this.f21508h == null) goto L8;
        r0.append(" #");
        String r2 = l.b.h.h.f.d(this.f21508h);
    L9:
        r0.append(r2);
        r0.append(" ");
        return r0.toString();
    L8:
        r2 = " #null";
        goto L9
    }

    public int w() {
        return this.f21507g;
    }
}
