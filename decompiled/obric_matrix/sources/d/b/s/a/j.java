package d.b.s.a;

import d.b.s.a.b0.a.b;
import d.b.s.a.q.j.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<T extends d.b.s.a.q.j.e<K>, K extends d.b.s.a.b0.a.b> extends d<T> {
    public j() {
    }

    @Override // d.b.s.a.d
    @Deprecated
    public /* bridge */ /* synthetic */ String g(d.b.s.a.q.j.b r1) {
        return m((d.b.s.a.q.j.e) r1);
    }

    @Override // d.b.s.a.d
    @Deprecated
    public /* bridge */ /* synthetic */ boolean h(d.b.s.a.q.j.b r1) {
        return n((d.b.s.a.q.j.e) r1);
    }

    @Override // d.b.s.a.d
    @Deprecated
    public /* bridge */ /* synthetic */ boolean i(d.b.s.a.q.j.b r1) {
        return o((d.b.s.a.q.j.e) r1);
    }

    @Override // d.b.s.a.d
    public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
        p((d.b.s.a.q.j.e) r1, r2);
    }

    @Override // d.b.s.a.d
    public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
        q((d.b.s.a.q.j.e) r1);
    }

    @Deprecated
    public final String m(T r1) {
        if (r1 == null) goto L8;
        T r0 = r1.p;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return r0.f14655d;
    L8:
        return null;
    }

    @Deprecated
    public final boolean n(T r1) {
        if (r1 == null) goto L8;
        T r0 = r1.p;
        if (r0 != 0) goto L7;
        return false;
    L7:
        return r0.b();
    L8:
        return false;
    }

    @Deprecated
    public final boolean o(T r1) {
        if (r1 == null) goto L8;
        T r0 = r1.p;
        if (r0 != 0) goto L7;
        return false;
    L7:
        return r0.c();
    L8:
        return false;
    }

    public abstract void p(T r1, int r2);

    public abstract void q(T r1);
}
