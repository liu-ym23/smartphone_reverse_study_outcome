package kotlin.s0.w.d.l0.n.w1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ArrayList<m> implements l {
    public a(int r1) {
        super(r1);
    }

    public /* bridge */ boolean a(m r1) {
        return super.contains(r1);
    }

    public /* bridge */ int c() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof m) == true) goto L7;
        return false;
    L7:
        return a((m) r2);
    }

    public /* bridge */ int d(m r1) {
        return super.indexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof m) == true) goto L7;
        return -1;
    L7:
        return d((m) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof m) == true) goto L7;
        return -1;
    L7:
        return m((m) r2);
    }

    public /* bridge */ int m(m r1) {
        return super.lastIndexOf(r1);
    }

    public /* bridge */ boolean n(m r1) {
        return super.remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof m) == true) goto L7;
        return false;
    L7:
        return n((m) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return c();
    }
}
