package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class BracketingNthOrderBrentSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private static final int DEFAULT_MAXIMAL_ORDER = 5;
    private static final int MAXIMAL_AGING = 2;
    private static final double REDUCTION_FACTOR = 0.0625d;
    private AllowedSolution allowed;
    private final int maximalOrder;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution = null;

        static {
            int[] r0 = new int[AllowedSolution.values().length];
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution = r0;
            r0[AllowedSolution.ANY_SIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.LEFT_SIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.RIGHT_SIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.BELOW_SIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.ABOVE_SIDE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public BracketingNthOrderBrentSolver() {
        this(1.0E-6d, 5);
    }

    public BracketingNthOrderBrentSolver(double r1, int r3) throws NumberIsTooSmallException {
        super(r1);
        if (r3 < 2) goto L7;
        this.maximalOrder = r3;
        this.allowed = AllowedSolution.ANY_SIDE;
        return;
    L7:
        throw new NumberIsTooSmallException(Integer.valueOf(r3), 2, true);
    }

    public BracketingNthOrderBrentSolver(double r1, double r3, int r5) throws NumberIsTooSmallException {
        super(r1, r3);
        if (r5 < 2) goto L7;
        this.maximalOrder = r5;
        this.allowed = AllowedSolution.ANY_SIDE;
        return;
    L7:
        throw new NumberIsTooSmallException(Integer.valueOf(r5), 2, true);
    }

    public BracketingNthOrderBrentSolver(double r1, double r3, double r5, int r7) throws NumberIsTooSmallException {
        super(r1, r3, r5);
        if (r7 < 2) goto L7;
        this.maximalOrder = r7;
        this.allowed = AllowedSolution.ANY_SIDE;
        return;
    L7:
        throw new NumberIsTooSmallException(Integer.valueOf(r7), 2, true);
    }

    public int getMaximalOrder() {
        return this.maximalOrder;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        int r0 = this.maximalOrder;
        int r8 = r0 + 1;
        double[] r9 = new double[r8];
        double[] r11 = new double[r0 + 1];
        int r12 = 0;
        r9[0] = getMin();
        r9[1] = getStartValue();
        double r5 = getMax();
        int r13 = 2;
        r9[2] = r5;
        verifySequence(r9[0], r9[1], r5);
        double r1 = computeObjectiveValue(r9[1]);
        r11[1] = r1;
        if (Precision.equals(r1, 0.0d, 1) == true) goto L5;
        double r2 = computeObjectiveValue(r9[0]);
        r11[0] = r2;
        if (Precision.equals(r2, 0.0d, 1) == false) goto L11;
        return r9[0];
    L11:
        if ((r11[0] * r11[1]) >= 0.0d) goto L13;
        int r3 = 1;
        int r4 = 2;
    L20:
        double[] r6 = new double[r8];
        int r7 = r3 - 1;
        double r10 = r9[r7];
        double r16 = r11[r7];
        double r18 = FastMath.abs(r16);
        double r20 = r9[r3];
        double r22 = r11[r3];
        double r14 = FastMath.abs(r22);
        int r15 = r3;
        int r17 = r4;
        int r19 = 0;
        double r21 = r18;
        double r110 = r16;
        double r111 = r10;
    L21:
        double[] r30 = r11;
        double r112 = r20 - r111;
        if (r112 <= (getAbsoluteAccuracy() + (getRelativeAccuracy() * FastMath.max(FastMath.abs(r111), FastMath.abs(r20))))) goto L73;
        if (FastMath.max(r21, r14) < getFunctionValueAccuracy()) goto L73;
        if (r19 < r13) goto L29;
        int r26 = r19 - 2;
        double r23 = (1 << r26) - 1;
        int r113 = r26 + 1;
        double r27 = r21;
        int r24 = r19;
        double r25 = r113;
        double r33 = r23 * r110;
        double r31 = (REDUCTION_FACTOR * r25) * r22;
    L28:
        double r32 = (r33 - r31) / (r23 + r25);
    L33:
        int r114 = r17;
        int r28 = 0;
    L34:
        System.arraycopy(r9, r28, r6, r28, r114 - r28);
        int r29 = r24;
        int r34 = r17;
        double r35 = r14;
        int r115 = r15;
        double[] r116 = r6;
        double r36 = guessX(r32, r6, r30, r28, r114);
        if (r36 <= r111) goto L39;
        if (r36 >= r20) goto L39;
    L44:
        if (Double.isNaN(r36) == false) goto L50;
        if ((r114 - r28) <= 1) goto L50;
        r15 = r115;
        r17 = r34;
        r24 = r29;
        r14 = r35;
        r6 = r116;
    L50:
        if (Double.isNaN(r36) == false) goto L52;
        r36 = r111 + (r112 * 0.5d);
        r28 = r115 - 1;
        int r37 = r115;
    L53:
        double r38 = computeObjectiveValue(r36);
        if (Precision.equals(r38, 0.0d, 1) == true) goto L55;
        if (r34 <= 2) goto L61;
        int r39 = r37 - r28;
        if (r39 == r34) goto L61;
        System.arraycopy(r9, r28, r9, 0, r39);
        double[] r117 = r30;
        System.arraycopy(r117, r28, r117, 0, r39);
        r15 = r115 - r28;
    L68:
        int r40 = r15 + 1;
        int r118 = r39 - r15;
        System.arraycopy(r9, r15, r9, r40, r118);
        r9[r15] = r36;
        System.arraycopy(r117, r15, r117, r40, r118);
        r117[r15] = r38;
        r17 = r39 + 1;
        if ((r38 * r110) > 0.0d) goto L71;
        r20 = r36;
        r22 = r38;
        r19 = r29 + 1;
        r14 = FastMath.abs(r38);
        r12 = 0;
    L72:
        r11 = r117;
        r21 = r27;
        r6 = r116;
        r13 = 2;
        goto L21
    L71:
        r12 = r12 + 1;
        r111 = r36;
        r110 = r38;
        r15 = r40;
        r27 = FastMath.abs(r38);
        r14 = r35;
        r19 = 0;
    L61:
        r117 = r30;
        if (r34 != r8) goto L67;
        r39 = r34 - 1;
        if (r115 < ((r8 + 1) / 2)) goto L66;
        System.arraycopy(r9, 1, r9, 0, r39);
        System.arraycopy(r117, 1, r117, 0, r39);
        r15 = r115 - 1;
        goto L68
    L66:
        r15 = r115;
        goto L68
    L67:
        r15 = r115;
        r39 = r34;
        goto L68
    L55:
        return r36;
    L52:
        r37 = r114;
    L39:
        if ((r115 - r28) < (r114 - r115)) goto L41;
        r28 = r28 + 1;
    L42:
        r36 = Double.NaN;
        goto L44
    L41:
        r114 = r114 - 1;
        goto L42
    L29:
        r27 = r21;
        r24 = r19;
        if (r12 < r13) goto L32;
        int r41 = r12 - 2;
        r23 = r41 + 1;
        r25 = (1 << r41) - 1;
        r33 = r25 * r22;
        r31 = (REDUCTION_FACTOR * r23) * r110;
        goto L28
    L32:
        r32 = 0.0d;
    L73:
        double r210 = r21;
        double r310 = r14;
        int r42 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
        if (r42 == 1) goto L97;
        if (r42 != 2) goto L78;
        return r111;
    L78:
        if (r42 != 3) goto L80;
        return r20;
    L80:
        if (r42 == 4) goto L90;
        if (r42 != 5) goto L88;
        if (r110 < 0.0d) goto L86;
        return r111;
    L86:
        return r20;
    L88:
        throw new MathInternalError();
    L90:
        if (r110 > 0.0d) goto L93;
        return r111;
    L93:
        return r20;
    L97:
        if (r210 >= r310) goto L100;
        return r111;
    L100:
        return r20;
    L13:
        double r43 = computeObjectiveValue(r9[2]);
        r11[2] = r43;
        if (Precision.equals(r43, 0.0d, 1) == false) goto L18;
        return r9[2];
    L18:
        if ((r11[1] * r11[2]) >= 0.0d) goto L102;
        r3 = 2;
        r4 = 3;
        goto L20
    L102:
        throw new NoBracketingException(r9[0], r9[2], r11[0], r11[2]);
    L5:
        return r9[1];
    }

    private double guessX(double r10, double[] r12, double[] r13, int r14, int r15) {
        int r9 = r14;
    L3:
        int r0 = r15 - 1;
        if (r9 >= r0) goto L9;
        int r1 = r9 + 1;
        int r2 = r1 - r14;
    L6:
        if (r0 <= r9) goto L8;
        r12[r0] = (r12[r0] - r12[r0 - 1]) / (r13[r0] - r13[r0 - r2]);
        r0 = r0 - 1;
        goto L6
    L8:
        r9 = r1;
        goto L3
    L9:
        double r3 = 0.0d;
    L10:
        if (r0 < r14) goto L12;
        r3 = (r3 * (r10 - r13[r0])) + r12[r0];
        r0 = r0 - 1;
        goto L10
    L12:
        return r3;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int r1, UnivariateFunction r2, double r3, double r5, AllowedSolution r7) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        this.allowed = r7;
        return super.solve(r1, r2, r3, r5);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int r1, UnivariateFunction r2, double r3, double r5, double r7, AllowedSolution r9) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        this.allowed = r9;
        return super.solve(r1, r2, r3, r5, r7);
    }
}
