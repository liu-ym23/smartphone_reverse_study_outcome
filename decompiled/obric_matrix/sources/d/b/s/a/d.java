package d.b.s.a;

import d.b.s.a.q.j.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends d.b.s.a.q.j.b> extends d.b.s.a.q.j.a<T> {
    public d() {
    }

    @Override // d.b.s.a.q.j.a
    public void c(T r2) {
        if (r2.f14887c == false) goto L6;
        l(r2);
        return;
    L6:
        if (h(r2) == true) goto L8;
    L10:
        j(r2, r2.f14891g);
        return;
    L8:
        if (i(r2) == false) goto L10;
        k(r2, g(r2));
    }

    @Deprecated
    public String g(T r1) {
        return null;
    }

    @Deprecated
    public boolean h(T r1) {
        return false;
    }

    @Deprecated
    public boolean i(T r1) {
        return false;
    }

    public abstract void j(T r1, int r2);

    @Deprecated
    public void k(T r1, String r2) {
    }

    public abstract void l(T r1);
}
