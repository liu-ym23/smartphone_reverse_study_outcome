package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class BrentOptimizer extends UnivariateOptimizer {
    private static final double GOLDEN_SECTION = 0.0d;
    private static final double MIN_RELATIVE_TOLERANCE = 0.0d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ UnivariatePointValuePair doOptimize() {
        return doOptimize2();
    }

    static {
        GOLDEN_SECTION = (3.0d - FastMath.sqrt(5.0d)) * 0.5d;
        MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    }

    public BrentOptimizer(double r3, double r5, ConvergenceChecker<UnivariatePointValuePair> r7) {
        super(r7);
        double r0 = MIN_RELATIVE_TOLERANCE;
        if (r3 < r0) goto L11;
        if (r5 <= 0.0d) goto L9;
        this.relativeThreshold = r3;
        this.absoluteThreshold = r5;
        return;
    L9:
        throw new NotStrictlyPositiveException(Double.valueOf(r5));
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r3), Double.valueOf(r0), true);
    }

    public BrentOptimizer(double r7, double r9) {
        this(r7, r9, null);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    /* JADX INFO: renamed from: doOptimize, reason: avoid collision after fix types in other method */
    protected UnivariatePointValuePair doOptimize2() {
        if (getGoalType() != GoalType.MINIMIZE) goto L5;
        boolean r1 = true;
    L6:
        double r5 = getMin();
        double r7 = getStartValue();
        double r9 = getMax();
        ConvergenceChecker<UnivariatePointValuePair> r2 = getConvergenceChecker();
        if (r5 < r9) goto L10;
        r5 = r9;
        r9 = r5;
    L10:
        double r11 = computeObjectiveValue(r7);
        if (r1 == true) goto L14;
        r11 = -r11;
    L14:
        if (r1 == false) goto L16;
        double r14 = r11;
    L17:
        UnivariatePointValuePair r13 = new UnivariatePointValuePair(r7, r14);
        double r18 = r11;
        double r20 = r18;
        double r22 = r20;
        UnivariatePointValuePair r3 = r13;
        UnivariatePointValuePair r4 = null;
        double r24 = 0.0d;
        double r26 = 0.0d;
        double r12 = r7;
        double r16 = r9;
        double r10 = r12;
    L18:
        double r28 = (r5 + r16) * 0.5d;
        ConvergenceChecker<UnivariatePointValuePair> r34 = r2;
        UnivariatePointValuePair r35 = r3;
        double r15 = (this.relativeThreshold * FastMath.abs(r7)) + this.absoluteThreshold;
        double r36 = r15 * 2.0d;
        if (FastMath.abs(r7 - r28) > (r36 - ((r16 - r5) * 0.5d))) goto L21;
        boolean r38 = true;
    L22:
        if (r38 == true) goto L103;
        if (FastMath.abs(r24) <= r15) goto L49;
        double r39 = r7 - r10;
        double r40 = (r18 - r20) * r39;
        double r42 = r7 - r12;
        double r44 = (r18 - r22) * r42;
        double r46 = r12;
        double r17 = (r42 * r44) - (r39 * r40);
        double r6 = 2.0d * (r44 - r40);
        if (r6 <= 0.0d) goto L28;
        r17 = -r17;
    L29:
        double r310 = r5 - r7;
        if (r17 <= (r6 * r310)) goto L46;
        if (r17 >= ((r16 - r7) * r6)) goto L46;
        if (FastMath.abs(r17) >= FastMath.abs((0.5d * r6) * r24)) goto L46;
        double r19 = r17 / r6;
        double r8 = r7 + r19;
        if ((r8 - r5) < r36) goto L42;
        if ((r16 - r8) < r36) goto L42;
        r24 = r26;
    L54:
        r26 = r19;
    L56:
        if (FastMath.abs(r26) < r15) goto L58;
        double r110 = r7 + r26;
    L62:
        double r111 = computeObjectiveValue(r110);
        if (r1 == true) goto L66;
        r111 = -r111;
    L66:
        if (r1 == false) goto L68;
        double r21 = r111;
    L69:
        UnivariatePointValuePair r23 = new UnivariatePointValuePair(r110, r21);
        r13 = best(r13, best(r35, r23, r1), r1);
        if (r34 == null) goto L74;
        ConvergenceChecker<UnivariatePointValuePair> r25 = r34;
        if (r25.converged(getIterations(), r35, r23) == true) goto L73;
    L76:
        if (r111 > r18) goto L83;
        if (r110 >= r7) goto L80;
        r16 = r7;
    L81:
        UnivariatePointValuePair r27 = r23;
        r20 = r22;
        r22 = r18;
        r18 = r111;
        r12 = r10;
        r10 = r7;
        r7 = r110;
    L101:
        incrementIterationCount();
        r4 = r35;
        r2 = r25;
        r3 = r27;
        r5 = r5;
        goto L18
    L80:
        r5 = r7;
        goto L81
    L83:
        if (r110 >= r7) goto L85;
        r5 = r110;
    L87:
        if (r111 > r22) goto L89;
    L100:
        r27 = r23;
        r20 = r22;
        r22 = r111;
        r12 = r10;
        r10 = r110;
        goto L101
    L89:
        if (Precision.equals(r10, r7) == true) goto L100;
        r27 = r23;
        if (r111 <= r20) goto L99;
        double r29 = r46;
        if (Precision.equals(r29, r7) == true) goto L99;
        if (Precision.equals(r29, r10) == true) goto L99;
        r12 = r29;
    L99:
        r20 = r111;
        r12 = r110;
        goto L101
    L85:
        r16 = r110;
        goto L87
    L73:
        return r13;
    L74:
        r25 = r34;
        goto L76
    L68:
        r21 = -r111;
        goto L69
    L58:
        if (r26 < 0.0d) goto L60;
        r110 = r15 + r7;
        goto L62
    L60:
        r110 = r7 - r15;
    L42:
        if (r7 > r28) goto L44;
        r24 = r26;
        r26 = r15;
        goto L56
    L44:
        r24 = r26;
        r26 = -r15;
    L46:
        if (r7 >= r28) goto L48;
        r310 = r16 - r7;
    L48:
        r26 = GOLDEN_SECTION * r310;
        r24 = r310;
        goto L56
    L28:
        r6 = -r6;
        goto L29
    L49:
        r46 = r12;
        if (r7 >= r28) goto L52;
        double r30 = r16 - r7;
    L53:
        r19 = GOLDEN_SECTION * r30;
        r24 = r30;
        goto L54
    L52:
        r30 = r5 - r7;
        goto L53
    L103:
        return best(r13, best(r4, r35, r1), r1);
    L21:
        r38 = false;
        goto L22
    L16:
        r14 = -r11;
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    private UnivariatePointValuePair best(UnivariatePointValuePair r5, UnivariatePointValuePair r6, boolean r7) {
        if (r5 != null) goto L4;
        return r6;
    L4:
        if (r6 != null) goto L6;
        return r5;
    L6:
        if (r7 == false) goto L13;
        if (r5.getValue() > r6.getValue()) goto L11;
        return r5;
    L11:
        return r6;
    L13:
        if (r5.getValue() < r6.getValue()) goto L16;
        return r5;
    L16:
        return r6;
    }
}
