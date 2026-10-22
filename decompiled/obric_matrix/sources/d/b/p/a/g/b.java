package d.b.p.a.g;

import android.app.Application;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f14296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f14297b;

    public b() {
    }

    @Override // d.b.p.a.g.a
    public final void c(Application r2) {
        super.c(r2);
        List<a> r0 = g();
        this.f14296a = r0;
        Iterator<a> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().c(r2);
        goto L4
    }

    @Override // d.b.p.a.g.a
    public final void d() {
        super.d();
        Iterator<a> r1 = this.f14296a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().d();
        goto L4
    }

    protected abstract List<a> g();

    public f h() {
        return this.f14297b;
    }

    public void i(f r1) {
        this.f14297b = r1;
    }

    public final void j(d r4) {
        Iterator<a> r0 = this.f14296a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r1 = r0.next();
        if (r1.e() != r4) goto L4;
        r1.d();
        if ((r1 instanceof f) == false) goto L4;
        this.f14297b = (f) r1;
        goto L4
    }
}
