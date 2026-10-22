package d.c.i.e;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class v implements d.c.b.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.f.f f15982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15984d;

    public v(String r4, d.c.i.f.f r5, File r6) {
        d.c.c.d.i.g(r4);
        String r7 = r4;
        this.f15981a = r7;
        d.c.c.d.i.g(r5);
        this.f15982b = r5;
        StringBuilder r0 = new StringBuilder();
        d.c.c.d.i.g(r6);
        r0.append(Long.toString(r6.lastModified()));
        r0.append(Long.toString(r6.length()));
        this.f15983c = r0.toString();
        this.f15984d = d.c.c.k.b.b(r7.hashCode(), r5.hashCode(), r7.hashCode());
    }

    @Override // d.c.b.a.d
    public String a() {
        return toString();
    }

    @Override // d.c.b.a.d
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == false) goto L18;
        v r6 = (v) r5;
        if (this.f15984d != r6.f15984d) goto L17;
        if (this.f15981a.equals(r6.f15981a) == false) goto L17;
        if (this.f15982b.equals(r6.f15982b) == false) goto L17;
        if (this.f15983c.equals(r6.f15983c) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    @Override // d.c.b.a.d
    public int hashCode() {
        return this.f15984d;
    }

    @Override // d.c.b.a.d
    public String toString() {
        return String.format(null, "%s_%s_%s_%d", new Object[]{this.f15981a, this.f15982b, this.f15983c, Integer.valueOf(this.f15984d)});
    }
}
