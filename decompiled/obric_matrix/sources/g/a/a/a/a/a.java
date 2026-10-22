package g.a.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    @Override // g.a.a.a.a.b
    public double a(double r3, double r5, double r7, double r9) {
        double r4 = r3 / (r9 / 2.0d);
        double r8 = r7 / 2.0d;
        if (r4 >= 1.0d) goto L7;
        double r10 = ((r8 * r4) * r4) * r4;
    L6:
        return r10 + r5;
    L7:
        double r6 = r4 - 2.0d;
        r10 = r8 * (((r6 * r6) * r6) + 2.0d);
        goto L6
    }

    @Override // g.a.a.a.a.b
    public double b(double r3, double r5, double r7, double r9) {
        double r4 = (r3 / r9) - 1.0d;
        return (r7 * (((r4 * r4) * r4) + 1.0d)) + r5;
    }
}
