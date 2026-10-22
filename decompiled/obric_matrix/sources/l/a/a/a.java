package l.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21480g;

    public a(int r1, int r2) {
        this.f21479f = r1;
        this.f21480g = r2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r3) {
        if ((r3 instanceof d) == true) goto L6;
        return -1;
    L6:
        d r4 = (d) r3;
        int r0 = this.f21479f - r4.getStart();
        if (r0 == 0) goto L10;
        return r0;
    L10:
        return this.f21480g - r4.h();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof d) == true) goto L5;
        return false;
    L5:
        d r5 = (d) r4;
        if (this.f21479f == r5.getStart()) goto L8;
        return false;
    L8:
        if (this.f21480g != r5.h()) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // l.a.a.d
    public int getStart() {
        return this.f21479f;
    }

    @Override // l.a.a.d
    public int h() {
        return this.f21480g;
    }

    public int hashCode() {
        return (this.f21479f % 100) + (this.f21480g % 100);
    }

    @Override // l.a.a.d
    public int size() {
        return (this.f21480g - this.f21479f) + 1;
    }

    public String toString() {
        return this.f21479f + ":" + this.f21480g;
    }
}
