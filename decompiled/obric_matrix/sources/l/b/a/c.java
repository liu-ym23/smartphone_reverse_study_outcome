package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class c extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f21521g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f21522h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte f21523f;

    static {
        f21521g = new c((byte) 0);
        f21522h = new c((byte) -1);
    }

    private c(byte r1) {
        this.f21523f = r1;
    }

    static c w(byte[] r2) {
        if (r2.length != 1) goto L14;
        byte r3 = r2[0];
        if (r3 == (-1)) goto L12;
        if (r3 == 0) goto L10;
        return new c(r3);
    L10:
        return f21521g;
    L12:
        return f21522h;
    L14:
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static c x(boolean r0) {
        if (r0 == false) goto L5;
        return f21522h;
    L5:
        return f21521g;
    }

    @Override // l.b.a.n
    public int hashCode() {
        return y() ? 1 : 0;
    }

    @Override // l.b.a.t
    boolean n(t r3) {
        if ((r3 instanceof c) == true) goto L6;
        return false;
    L6:
        if (y() != ((c) r3).y()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.j(r3, 1, this.f21523f);
    }

    @Override // l.b.a.t
    int p() {
        return 3;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        if (y() == false) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }

    @Override // l.b.a.t
    t u() {
        if (y() == false) goto L6;
        return f21522h;
    L6:
        return f21521g;
    }

    public boolean y() {
        if (this.f21523f == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
