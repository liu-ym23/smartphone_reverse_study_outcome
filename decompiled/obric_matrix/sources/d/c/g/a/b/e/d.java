package d.c.g.a.b.e;

/* JADX INFO: loaded from: classes.dex */
public class d implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f15784b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15785a;

    static {
        f15784b = d.class;
    }

    public d() {
        this(3);
    }

    public d(int r1) {
        this.f15785a = r1;
    }

    @Override // d.c.g.a.b.e.a
    public void a(b r7, d.c.g.a.b.b r8, d.c.g.a.a.a r9, int r10) {
        int r0 = 1;
    L4:
        if (r0 > this.f15785a) goto L12;
        int r1 = (r10 + r0) % r9.a();
        if (d.c.c.e.a.p(2) == false) goto L9;
        d.c.c.e.a.t(f15784b, "Preparing frame %d, last drawn: %d", Integer.valueOf(r1), Integer.valueOf(r10));
    L9:
        if (r7.a(r8, r9, r1) == false) goto L10;
        r0 = r0 + 1;
        goto L4
    L10:
        return;
    }
}
