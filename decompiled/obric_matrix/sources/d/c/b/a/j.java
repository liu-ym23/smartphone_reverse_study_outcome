package d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f15272a;

    public j(String r1) {
        d.c.c.d.i.g(r1);
        this.f15272a = r1;
    }

    @Override // d.c.b.a.d
    public String a() {
        return this.f15272a;
    }

    @Override // d.c.b.a.d
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof j) == true) goto L8;
        return false;
    L8:
        return this.f15272a.equals(((j) r2).f15272a);
    }

    @Override // d.c.b.a.d
    public int hashCode() {
        return this.f15272a.hashCode();
    }

    @Override // d.c.b.a.d
    public String toString() {
        return this.f15272a;
    }
}
