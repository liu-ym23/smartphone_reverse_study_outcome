package d.c.i.f;

import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f16023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f16024d;

    public f(int r2, int r3) {
        this(r2, r3, 2048.0f);
    }

    public f(int r2, int r3, float r4) {
        this(r2, r3, r4, 0.6666667f);
    }

    public f(int r4, int r5, float r6, float r7) {
        boolean r0 = true;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        i.b(r2);
        if (r5 > 0) goto L10;
        r0 = false;
    L10:
        i.b(r0);
        this.f16021a = r4;
        this.f16022b = r5;
        this.f16023c = r6;
        this.f16024d = r7;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.f16021a != r6.f16021a) goto L14;
        if (this.f16022b != r6.f16022b) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return d.c.c.k.b.a(this.f16021a, this.f16022b);
    }

    public String toString() {
        return String.format(null, "%dx%d", new Object[]{Integer.valueOf(this.f16021a), Integer.valueOf(this.f16022b)});
    }
}
