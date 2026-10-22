package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21d;
    private static final double GOLD = 1.618034d;
    private final Incrementor evaluations;
    private double fHi;
    private double fLo;
    private double fMid;
    private final double growLimit;
    private double hi;
    private double lo;
    private double mid;

    public BracketFinder() {
        this(100.0d, 50);
    }

    public BracketFinder(double r4, int r6) {
        Incrementor r0 = new Incrementor();
        this.evaluations = r0;
        if (r4 <= 0.0d) goto L10;
        if (r6 <= 0) goto L8;
        this.growLimit = r4;
        r0.setMaximalCount(r6);
        return;
    L8:
        throw new NotStrictlyPositiveException(Integer.valueOf(r6));
    L10:
        throw new NotStrictlyPositiveException(Double.valueOf(r4));
    }

    public void search(UnivariateFunction r34, GoalType r35, double r36, double r38) {
        this.evaluations.resetCount();
        if (r35 != GoalType.MINIMIZE) goto L5;
        boolean r2 = true;
    L6:
        double r3 = r36;
        double r5 = eval(r34, r3);
        r3 = r38;
        double r9 = eval(r34, r3);
        if (r2 == false) goto L12;
        if (r5 < r9) goto L13;
    L14:
        r3 = r3;
        r3 = r3;
    L15:
        r3 = ((r3 - r3) * GOLD) + r3;
        r9 = eval(r34, r3);
    L16:
        if (r2 == false) goto L21;
        if (r9 >= r9) goto L63;
    L22:
        double r17 = r3 - r3;
        double r19 = (r9 - r9) * r17;
        double r21 = r3 - r3;
        double r23 = (r9 - r5) * r21;
        double r25 = r23 - r19;
        if (FastMath.abs(r25) >= EPS_MIN) goto L25;
        double r26 = 2.0E-21d;
    L26:
        double r13 = r3 - (((r21 * r23) - (r17 * r19)) / r26);
        double r37 = r5;
        double r18 = r3 - r3;
        double r6 = (this.growLimit * r18) + r3;
        double r110 = r13 - r3;
        if (((r3 - r13) * r110) <= 0.0d) goto L44;
        double r7 = eval(r34, r13);
        if (r2 == false) goto L34;
        if (r7 < r9) goto L35;
    L36:
        if (r2 == false) goto L41;
        if (r7 > r9) goto L42;
    L43:
        r6 = r3 + (r18 * GOLD);
        double r8 = eval(r34, r6);
    L47:
        long r22 = 4609965796492119705L;
    L48:
        r9 = r8;
        r3 = r6;
    L49:
        r5 = r9;
    L42:
        double r1 = r7;
        r3 = r13;
        double r10 = r37;
        r13 = r3;
        r3 = r3;
    L64:
        this.lo = r3;
        this.fLo = r10;
        this.mid = r13;
        this.fMid = r9;
        this.hi = r3;
        this.fHi = r1;
        if (r3 <= r3) goto L76;
        this.lo = r3;
        this.hi = r3;
        this.fLo = r1;
        this.fHi = r10;
        return;
    L76:
        return;
    L41:
        if (r7 >= r9) goto L43;
    L35:
        r1 = r9;
        r10 = r9;
        r9 = r7;
        goto L64
    L34:
        if (r7 <= r9) goto L36;
    L44:
        double r11 = r13 - r6;
        if (((r6 - r3) * r11) < 0.0d) goto L51;
        r8 = eval(r34, r6);
        goto L47
    L51:
        if ((r11 * (r3 - r13)) <= 0.0d) goto L61;
        double r12 = eval(r34, r13);
        if (r2 == false) goto L58;
        if (r12 < r9) goto L59;
    L60:
        r22 = 4609965796492119705L;
        r3 = r13;
        r9 = r12;
    L59:
        r22 = 4609965796492119705L;
        double r4 = r13 + (r110 * GOLD);
        r9 = r12;
        r5 = r9;
        r9 = eval(r34, r4);
        r3 = r3;
        r3 = r4;
        r3 = r13;
        goto L16
    L58:
        if (r12 <= r9) goto L60;
    L61:
        r22 = 4609965796492119705L;
        r6 = r3 + (r18 * GOLD);
        r8 = eval(r34, r6);
        goto L48
    L25:
        r26 = r25 * 2.0d;
    L63:
        r10 = r5;
        r13 = r3;
        r3 = r3;
        r1 = r9;
        goto L64
    L21:
        if (r9 <= r9) goto L63;
    L13:
        r5 = r9;
        r9 = r5;
        goto L15
    L12:
        if (r5 <= r9) goto L14;
    L5:
        r2 = false;
        goto L6
    }

    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public double getLo() {
        return this.lo;
    }

    public double getFLo() {
        return this.fLo;
    }

    public double getHi() {
        return this.hi;
    }

    public double getFHi() {
        return this.fHi;
    }

    public double getMid() {
        return this.mid;
    }

    public double getFMid() {
        return this.fMid;
    }

    private double eval(UnivariateFunction r1, double r2) {
        this.evaluations.incrementCount();     // Catch: MaxCountExceededException -> L5
        return r1.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }
}
