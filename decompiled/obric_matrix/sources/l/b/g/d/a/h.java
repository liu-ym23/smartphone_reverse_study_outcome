package l.b.g.d.a;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f22275a;

    public h(byte[] r8) {
        if (r8.length <= 4) goto L17;
        int r0 = 0;
        int r3 = f.e(r8, 0);
        int r4 = e.a(r3 - 1);
        if (r8.length != ((r3 * r4) + 4)) goto L15;
        this.f22275a = new int[r3];
    L7:
        if (r0 >= r3) goto L10;
        this.f22275a[r0] = f.f(r8, (r0 * r4) + 4, r4);
        r0 = r0 + 1;
        goto L7
    L10:
        if (b(this.f22275a) == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("invalid encoding");
    L15:
        throw new IllegalArgumentException("invalid encoding");
    L17:
        throw new IllegalArgumentException("invalid encoding");
    }

    private boolean b(int[] r6) {
        int r5 = r6.length;
        boolean[] r0 = new boolean[r5];
        int r2 = 0;
    L4:
        if (r2 >= r5) goto L14;
        if (r6[r2] < 0) goto L13;
        if (r6[r2] >= r5) goto L13;
        if (r0[r6[r2]] == true) goto L13;
        r0[r6[r2]] = true;
        r2 = r2 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public byte[] a() {
        int r0 = this.f22275a.length;
        int r1 = e.a(r0 - 1);
        byte[] r2 = new byte[(r0 * r1) + 4];
        int r3 = 0;
        f.a(r0, r2, 0);
    L3:
        if (r3 >= r0) goto L5;
        f.b(this.f22275a[r3], r2, (r3 * r1) + 4, r1);
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof h) == true) goto L7;
        return false;
    L7:
        return d.b(this.f22275a, ((h) r2).f22275a);
    }

    public int hashCode() {
        return l.b.h.a.m(this.f22275a);
    }

    public String toString() {
        String r0 = "[" + this.f22275a[0];
        int r1 = 1;
    L4:
        if (r1 >= this.f22275a.length) goto L7;
        r0 = r0 + ", " + this.f22275a[r1];
        r1 = r1 + 1;
        goto L4
    L7:
        return r0 + "]";
    }
}
