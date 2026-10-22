package f.a.j.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f17157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f17158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f17159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f17160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    T[] f17161e;

    public b() {
        this(16, 0.75f);
    }

    public b(int r2, float r3) {
        this.f17157a = r3;
        int r4 = c.a(r2);
        this.f17158b = r4 - 1;
        this.f17160d = (int) (r3 * r4);
        this.f17161e = (T[]) new Object[r4];
    }

    static int c(int r1) {
        int r2 = r1 * (-1640531527);
        return r2 ^ (r2 >>> 16);
    }

    public boolean a(T r7) {
        T[] r0 = this.f17161e;
        int r1 = this.f17158b;
        int r2 = c(r7.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L5;
    L13:
        r0[r2] = r7;
        int r8 = this.f17159c + 1;
        this.f17159c = r8;
        if (r8 < this.f17160d) goto L16;
        d();
    L16:
        return true;
    L5:
        if (r3.equals(r7) == false) goto L7;
        return false;
    L7:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L13;
        if (r4.equals(r7) == false) goto L7;
        return false;
    }

    public Object[] b() {
        return this.f17161e;
    }

    void d() {
        T[] r0 = this.f17161e;
        int r1 = r0.length;
        int r2 = r1 << 1;
        int r3 = r2 - 1;
        T[] r4 = (T[]) new Object[r2];
        int r5 = this.f17159c;
    L3:
        int r6 = r5 - 1;
        if (r5 == 0) goto L13;
    L5:
        r1 = r1 - 1;
        if (r0[r1] == null) goto L5;
        int r7 = c(r0[r1].hashCode()) & r3;
        if (r4[r7] == null) goto L12;
    L10:
        r7 = (r7 + 1) & r3;
        if (r4[r7] != null) goto L10;
    L12:
        r4[r7] = r0[r1];
        r5 = r6;
        goto L3
    L13:
        this.f17158b = r3;
        this.f17160d = (int) (r2 * this.f17157a);
        this.f17161e = r4;
    }

    public boolean e(T r6) {
        T[] r0 = this.f17161e;
        int r1 = this.f17158b;
        int r2 = c(r6.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.equals(r6) == true) goto L8;
    L9:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L11;
        if (r4.equals(r6) == false) goto L9;
        return f(r2, r0, r1);
    L11:
        return false;
    L8:
        return f(r2, r0, r1);
    }

    boolean f(int r4, T[] r5, int r6) {
        this.f17159c--;
    L3:
        int r3 = r4 + 1;
    L4:
        int r7 = r3 & r6;
        T r0 = r5[r7];
        if (r0 == null) goto L6;
        int r2 = c(r0.hashCode()) & r6;
        if (r4 > r7) goto L13;
        if (r4 >= r2) goto L15;
        if (r2 > r7) goto L15;
    L16:
        r3 = r7 + 1;
    L15:
        r5[r4] = r0;
        r4 = r7;
        goto L3
    L13:
        if (r4 < r2) goto L16;
        if (r2 <= r7) goto L16;
    L6:
        r5[r4] = null;
        return true;
    }
}
