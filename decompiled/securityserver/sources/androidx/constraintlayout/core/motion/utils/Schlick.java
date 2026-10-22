package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;
    double mS;
    double mT;

    public Schlick(String r6) {
        this.str = r6;
        int r0 = r6.indexOf(40);
        int r2 = r6.indexOf(44, r0);
        this.mS = Double.parseDouble(r6.substring(r0 + 1, r2).trim());
        int r3 = r2 + 1;
        this.mT = Double.parseDouble(r6.substring(r3, r6.indexOf(44, r3)).trim());
    }

    private double dfunc(double r13) {
        double r0 = this.mT;
        if (r13 >= r0) goto L6;
        double r2 = this.mS;
        double r6 = ((r0 - r13) * r2) + r13;
        return ((r2 * r0) * r0) / ((((r0 - r13) * r2) + r13) * r6);
    L6:
        double r3 = this.mS;
        double r8 = r0 - 1.0d;
        double r9 = r8 * ((r0 - 1.0d) * r3);
        double r10 = r0 - r13;
        double r11 = ((r10 * (-r3)) - r13) + 1.0d;
        double r1 = r0 - r13;
        return r9 / ((((r1 * (-r3)) - r13) + 1.0d) * r11);
    }

    private double func(double r9) {
        double r0 = this.mT;
        if (r9 >= r0) goto L6;
        double r2 = r0 * r9;
        double r1 = r0 - r9;
        return r2 / ((r1 * this.mS) + r9);
    L6:
        double r6 = r9 - 1.0d;
        double r7 = r6 * (1.0d - r0);
        double r3 = r0 - r9;
        return r7 / ((1.0d - r9) - (r3 * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double r1) {
        return func(r1);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double r1) {
        return dfunc(r1);
    }
}
