package d.c.b.a;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<d> f15269a;

    @Override // d.c.b.a.d
    public String a() {
        return this.f15269a.get(0).a();
    }

    public List<d> b() {
        return this.f15269a;
    }

    @Override // d.c.b.a.d
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof g) == true) goto L8;
        return false;
    L8:
        return this.f15269a.equals(((g) r2).f15269a);
    }

    @Override // d.c.b.a.d
    public int hashCode() {
        return this.f15269a.hashCode();
    }

    @Override // d.c.b.a.d
    public String toString() {
        return "MultiCacheKey:" + this.f15269a.toString();
    }
}
