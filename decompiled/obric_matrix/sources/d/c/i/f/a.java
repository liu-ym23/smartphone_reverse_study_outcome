package d.c.i.f;

import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15988b;

    public a(int r1, int r2) {
        this.f15987a = r1;
        this.f15988b = r2;
    }

    public static a b(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        i.b(r0);
        return new a(r2, Integer.MAX_VALUE);
    L4:
        r0 = false;
        goto L5
    }

    public static a c(int r2) {
        if (r2 <= 0) goto L5;
        boolean r1 = true;
    L6:
        i.b(r1);
        return new a(0, r2);
    L5:
        r1 = false;
        goto L6
    }

    private static String d(int r1) {
        if (r1 != Integer.MAX_VALUE) goto L7;
        return "";
    L7:
        return Integer.toString(r1);
    }

    public boolean a(a r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.f15987a <= r4.f15987a) goto L8;
        return false;
    L8:
        if (this.f15988b < r4.f15988b) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.f15987a != r6.f15987a) goto L14;
        if (this.f15988b != r6.f15988b) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return d.c.c.k.b.a(this.f15987a, this.f15988b);
    }

    public String toString() {
        return String.format(null, "%s-%s", new Object[]{d(this.f15987a), d(this.f15988b)});
    }
}
