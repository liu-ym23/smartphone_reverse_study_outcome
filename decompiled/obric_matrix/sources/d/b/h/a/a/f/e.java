package d.b.h.a.a.f;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f13297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f13299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13300d;

    public e(double r3) {
        this.f13299c = -1.0d;
        this.f13297a = r3;
        if (r3 != 0.0d) goto L5;
        int r4 = Integer.MAX_VALUE;
    L6:
        this.f13298b = r4;
        return;
    L5:
        r4 = (int) Math.ceil(1.0d / r3);
        goto L6
    }

    public void a(double r8) {
        double r0 = 1.0d - this.f13297a;
        int r4 = this.f13300d;
        if (r4 <= this.f13298b) goto L7;
        double r1 = r0 * Math.log(this.f13299c);
        double r2 = this.f13297a;
    L5:
        r8 = Math.exp(r1 + (r2 * Math.log(r8)));
    L6:
        this.f13299c = r8;
        this.f13300d++;
        return;
    L7:
        if (r4 <= 0) goto L6;
        double r3 = (r0 * ((double) r4)) / (((double) r4) + 1.0d);
        r2 = 1.0d - r3;
        r1 = r3 * Math.log(this.f13299c);
        goto L5
    }

    public double b() {
        return this.f13299c;
    }
}
