package d.c.f.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.c.i.m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f15511b;

    public c(String r1, b r2) {
        this.f15511b = r2;
        m(r1);
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void e(String r1, String r2, boolean r3) {
        b r4 = this.f15511b;
        if (r4 == null) goto L6;
        r4.a(this.f15510a, d.a(r2), r3);
        return;
    }

    public void m(String r1) {
        this.f15510a = r1;
    }
}
