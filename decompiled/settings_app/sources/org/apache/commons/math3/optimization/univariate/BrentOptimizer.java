package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BrentOptimizer extends BaseAbstractUnivariateOptimizer {
    private static final double GOLDEN_SECTION = 0.0d;
    private static final double MIN_RELATIVE_TOLERANCE = 0.0d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

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

    @Override // org.apache.commons.math3.optimization.univariate.BaseAbstractUnivariateOptimizer
    protected UnivariatePointValuePair doOptimize() {
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
        int r28 = 0;
        double r12 = r7;
        double r16 = r9;
        double r10 = r12;
    L18:
        double r29 = (r5 + r16) * 0.5d;
        ConvergenceChecker<UnivariatePointValuePair> r35 = r2;
        UnivariatePointValuePair r36 = r3;
        double r15 = (this.relativeThreshold * FastMath.abs(r7)) + this.absoluteThreshold;
        double r37 = r15 * 2.0d;
        if (FastMath.abs(r7 - r29) > (r37 - ((r16 - r5) * 0.5d))) goto L21;
        boolean r39 = true;
    L22:
        if (r39 == true) goto L103;
        if (FastMath.abs(r24) <= r15) goto L49;
        double r310 = r7 - r10;
        double r41 = (r18 - r20) * r310;
        double r43 = r7 - r12;
        double r45 = (r18 - r22) * r43;
        double r47 = r12;
        double r17 = (r43 * r45) - (r310 * r41);
        double r6 = 2.0d * (r45 - r41);
        if (r6 <= 0.0d) goto L28;
        r17 = -r17;
    L29:
        double r311 = r5 - r7;
        if (r17 <= (r6 * r311)) goto L46;
        if (r17 >= ((r16 - r7) * r6)) goto L46;
        if (FastMath.abs(r17) >= FastMath.abs((0.5d * r6) * r24)) goto L46;
        double r19 = r17 / r6;
        double r8 = r7 + r19;
        if ((r8 - r5) < r37) goto L42;
        if ((r16 - r8) < r37) goto L42;
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
        r13 = best(r13, best(r36, r23, r1), r1);
        double r49 = r5;
        int r25 = r28;
        double r210 = r49;
        if (r35 == null) goto L75;
        if (r35.converged(r25, r36, r23) == false) goto L75;
        return r13;
    L75:
        if (r111 > r18) goto L82;
        if (r110 >= r7) goto L79;
        r16 = r7;
    L80:
        ConvergenceChecker<UnivariatePointValuePair> r38 = r35;
        UnivariatePointValuePair r27 = r23;
        r20 = r22;
        r22 = r18;
        r18 = r111;
        r12 = r10;
        r10 = r7;
        r7 = r110;
    L101:
        r4 = r36;
        r2 = r38;
        double r410 = r210;
        r28 = r25 + 1;
        r3 = r27;
        r5 = r410;
        goto L18
    L79:
        r210 = r7;
        goto L80
    L82:
        if (r110 >= r7) goto L84;
        r210 = r110;
    L86:
        if (r111 > r22) goto L88;
    L100:
        r38 = r35;
        r27 = r23;
        r20 = r22;
        r22 = r111;
        r12 = r10;
        r10 = r110;
        goto L101
    L88:
        if (Precision.equals(r10, r7) == true) goto L100;
        r38 = r35;
        if (r111 <= r20) goto L98;
        r27 = r23;
        double r30 = r47;
        if (Precision.equals(r30, r7) == false) goto L95;
    L99:
        r20 = r111;
        r12 = r110;
        goto L101
    L95:
        if (Precision.equals(r30, r10) == true) goto L99;
        r12 = r30;
        goto L101
    L98:
        r27 = r23;
        goto L99
    L84:
        r16 = r110;
        goto L86
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
        if (r7 > r29) goto L44;
        r24 = r26;
        r26 = r15;
        goto L56
    L44:
        r24 = r26;
        r26 = -r15;
    L46:
        if (r7 >= r29) goto L48;
        r311 = r16 - r7;
    L48:
        r26 = GOLDEN_SECTION * r311;
        r24 = r311;
        goto L56
    L28:
        r6 = -r6;
        goto L29
    L49:
        r47 = r12;
        if (r7 >= r29) goto L52;
        double r31 = r16 - r7;
    L53:
        r19 = GOLDEN_SECTION * r31;
        r24 = r31;
        goto L54
    L52:
        r31 = r5 - r7;
        goto L53
    L103:
        return best(r13, best(r4, r36, r1), r1);
    L21:
        r39 = false;
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
