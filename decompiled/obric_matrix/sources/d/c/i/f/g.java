package d.c.i.f;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g f16025c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g f16026d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final g f16027e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16029b;

    static {
        f16025c = new g(-1, false);
        f16026d = new g(-2, false);
        f16027e = new g(-1, true);
    }

    private g(int r1, boolean r2) {
        this.f16028a = r1;
        this.f16029b = r2;
    }

    public static g a() {
        return f16025c;
    }

    public static g b() {
        return f16027e;
    }

    public static g d() {
        return f16026d;
    }

    public boolean c() {
        return this.f16029b;
    }

    public int e() {
        if (g() == true) goto L7;
        return this.f16028a;
    L7:
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.f16028a != r6.f16028a) goto L14;
        if (this.f16029b != r6.f16029b) goto L14;
        return true;
    L14:
        return false;
    }

    public boolean f() {
        if (this.f16028a == (-2)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f16028a != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return d.c.c.k.b.d(Integer.valueOf(this.f16028a), Boolean.valueOf(this.f16029b));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", new Object[]{Integer.valueOf(this.f16028a), Boolean.valueOf(this.f16029b)});
    }
}
