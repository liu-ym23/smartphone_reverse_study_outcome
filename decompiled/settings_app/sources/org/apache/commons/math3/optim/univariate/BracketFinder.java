package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IntegerSequence;

/* JADX INFO: loaded from: classes6.dex */
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21d;
    private static final double GOLD = 1.618034d;
    private IntegerSequence.Incrementor evaluations;
    private double fHi;
    private double fLo;
    private double fMid;
    private final double growLimit;
    private double hi;
    private double lo;
    private double mid;

    public BracketFinder() {
        this(100.0d, 500);
    }

    public BracketFinder(double r3, int r5) {
        if (r3 <= 0.0d) goto L10;
        if (r5 <= 0) goto L8;
        this.growLimit = r3;
        this.evaluations = IntegerSequence.Incrementor.create().withMaximalCount(r5);
        return;
    L8:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    L10:
        throw new NotStrictlyPositiveException(Double.valueOf(r3));
    }

    public void search(UnivariateFunction r35, GoalType r36, double r37, double r39) {
        boolean r3 = false;
        this.evaluations = this.evaluations.withStart(0);
        if (r36 != GoalType.MINIMIZE) goto L5;
        r3 = true;
    L5:
        double r4 = r37;
        double r6 = eval(r35, r4);
        r4 = r39;
        double r10 = eval(r35, r4);
        if (r3 == false) goto L11;
        if (r6 < r10) goto L12;
    L13:
        r4 = r4;
        r4 = r4;
    L14:
        r4 = ((r4 - r4) * GOLD) + r4;
        r10 = eval(r35, r4);
    L15:
        if (r3 == false) goto L20;
        if (r10 >= r10) goto L62;
    L21:
        double r18 = r4 - r4;
        double r20 = (r10 - r10) * r18;
        double r22 = r4 - r4;
        double r24 = (r10 - r6) * r22;
        double r26 = r24 - r20;
        if (FastMath.abs(r26) >= EPS_MIN) goto L24;
        double r27 = 2.0E-21d;
    L25:
        double r14 = r4 - (((r22 * r24) - (r18 * r20)) / r27);
        double r38 = r6;
        double r19 = r4 - r4;
        double r7 = (this.growLimit * r19) + r4;
        double r21 = r14 - r4;
        if (((r4 - r14) * r21) <= 0.0d) goto L43;
        double r8 = eval(r35, r14);
        if (r3 == false) goto L33;
        if (r8 < r10) goto L34;
    L35:
        if (r3 == false) goto L40;
        if (r8 > r10) goto L41;
    L42:
        r7 = r4 + (r19 * GOLD);
        double r9 = eval(r35, r7);
    L46:
        long r23 = 4609965796492119705L;
    L47:
        r10 = r9;
        r4 = r7;
    L48:
        r6 = r10;
    L41:
        double r1 = r8;
        r4 = r14;
        double r11 = r38;
        r14 = r4;
        r4 = r4;
    L63:
        this.lo = r4;
        this.fLo = r11;
        this.mid = r14;
        this.fMid = r10;
        this.hi = r4;
        this.fHi = r1;
        if (r4 <= r4) goto L75;
        this.lo = r4;
        this.hi = r4;
        this.fLo = r1;
        this.fHi = r11;
        return;
    L75:
        return;
    L40:
        if (r8 >= r10) goto L42;
    L34:
        r1 = r10;
        r11 = r10;
        r10 = r8;
        goto L63
    L33:
        if (r8 <= r10) goto L35;
    L43:
        double r12 = r14 - r7;
        if (((r7 - r4) * r12) < 0.0d) goto L50;
        r9 = eval(r35, r7);
        goto L46
    L50:
        if ((r12 * (r4 - r14)) <= 0.0d) goto L60;
        double r13 = eval(r35, r14);
        if (r3 == false) goto L57;
        if (r13 < r10) goto L58;
    L59:
        r23 = 4609965796492119705L;
        r4 = r14;
        r10 = r13;
    L58:
        r23 = 4609965796492119705L;
        double r5 = r14 + (r21 * GOLD);
        r10 = r13;
        r6 = r10;
        r10 = eval(r35, r5);
        r4 = r4;
        r4 = r5;
        r4 = r14;
        goto L15
    L57:
        if (r13 <= r10) goto L59;
    L60:
        r23 = 4609965796492119705L;
        r7 = r4 + (r19 * GOLD);
        r9 = eval(r35, r7);
        goto L47
    L24:
        r27 = r26 * 2.0d;
    L62:
        r11 = r6;
        r14 = r4;
        r4 = r4;
        r1 = r10;
        goto L63
    L20:
        if (r10 <= r10) goto L62;
    L12:
        r6 = r10;
        r10 = r6;
        goto L14
    L11:
        if (r6 <= r10) goto L13;
        goto L12
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
        this.evaluations.increment();     // Catch: MaxCountExceededException -> L5
        return r1.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }
}
