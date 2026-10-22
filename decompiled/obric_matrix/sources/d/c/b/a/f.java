package d.c.b.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<c> f15268a;

    public f() {
        this.f15268a = new CopyOnWriteArrayList();
    }

    @Override // d.c.b.a.c
    public void a(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void b(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().b(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void c() {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().c();
        goto L4
    }

    @Override // d.c.b.a.c
    public void d(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().d(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void e(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().e(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void f(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().f(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void g(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().g(r2);
        goto L4
    }

    @Override // d.c.b.a.c
    public void h(b r2) {
        Iterator<c> r1 = this.f15268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().h(r2);
        goto L4
    }

    public void i(c r1) {
        this.f15268a.add(r1);
    }
}
