package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class FieldBracketingNthOrderBrentSolver<T extends RealFieldElement<T>> implements BracketedRealFieldUnivariateSolver<T> {
    private static final int MAXIMAL_AGING = 2;
    private final T absoluteAccuracy;
    private IntegerSequence.Incrementor evaluations;
    private final Field<T> field;
    private final T functionValueAccuracy;
    private final int maximalOrder;
    private final T relativeAccuracy;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver$1, reason: invalid class name */
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

    public FieldBracketingNthOrderBrentSolver(T r2, T r3, T r4, int r5) throws NumberIsTooSmallException {
        if (r5 < 2) goto L7;
        this.field = r2.getField();
        this.maximalOrder = r5;
        this.absoluteAccuracy = r3;
        this.relativeAccuracy = r2;
        this.functionValueAccuracy = r4;
        this.evaluations = IntegerSequence.Incrementor.create();
        return;
    L7:
        throw new NumberIsTooSmallException(Integer.valueOf(r5), 2, true);
    }

    public int getMaximalOrder() {
        return this.maximalOrder;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T solve(int r9, RealFieldUnivariateFunction<T> r10, T r11, T r12, AllowedSolution r13) throws NullArgumentException, NoBracketingException {
        return (T) solve(r9, r10, r11, r12, (RealFieldElement) ((RealFieldElement) r11.add(r12)).divide(2.0d), r13);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T solve(int r34, RealFieldUnivariateFunction<T> r35, T r36, T r37, T r38, AllowedSolution r39) throws NullArgumentException, NoBracketingException {
        FieldBracketingNthOrderBrentSolver<T> r6 = this;
        RealFieldUnivariateFunction<T> r7 = r35;
        MathUtils.checkNotNull(r35);
        r6.evaluations = r6.evaluations.withMaximalCount(r34).withStart(0);
        T r9 = r6.field.getZero();
        RealFieldElement r10 = (RealFieldElement) r9.add(Double.NaN);
        RealFieldElement[] r12 = (RealFieldElement[]) MathArrays.buildArray(r6.field, r6.maximalOrder + 1);
        RealFieldElement[] r13 = (RealFieldElement[]) MathArrays.buildArray(r6.field, r6.maximalOrder + 1);
        r12[0] = r36;
        r12[1] = r38;
        r12[2] = r37;
        r6.evaluations.increment();
        RealFieldElement r0 = r7.value(r12[1]);
        r13[1] = r0;
        double r4 = 0.0d;
        if (Precision.equals(r0.getReal(), 0.0d, 1) == true) goto L5;
        r6.evaluations.increment();
        RealFieldElement r1 = r7.value(r12[0]);
        r13[0] = r1;
        if (Precision.equals(r1.getReal(), 0.0d, 1) == false) goto L11;
        return (T) r12[0];
    L11:
        if (((RealFieldElement) r13[0].multiply(r13[1])).getReal() >= 0.0d) goto L13;
        int r2 = 1;
        int r3 = 2;
    L20:
        RealFieldElement[] r5 = (RealFieldElement[]) MathArrays.buildArray(r6.field, r12.length);
        int r8 = r2 - 1;
        RealFieldElement r16 = r12[r8];
        RealFieldElement r11 = r13[r8];
        RealFieldElement r15 = (RealFieldElement) r16.abs();
        RealFieldElement r17 = (RealFieldElement) r11.abs();
        RealFieldElement r18 = r12[r2];
        RealFieldElement r19 = r13[r2];
        RealFieldElement r14 = (RealFieldElement) r18.abs();
        T r110 = (T) r16;
        RealFieldElement r111 = r17;
        Object r21 = r18;
        RealFieldElement r22 = r19;
        RealFieldElement r23 = (RealFieldElement) r19.abs();
        int r24 = 0;
        int r25 = 0;
        int r20 = r2;
        RealFieldElement r26 = r11;
    L22:
        if (((RealFieldElement) r15.subtract(r14)).getReal() >= r4) goto L24;
        RealFieldElement r27 = r14;
    L25:
        RealFieldElement r28 = r23;
        if (((RealFieldElement) r111.subtract(r28)).getReal() >= 0.0d) goto L28;
        RealFieldElement r29 = r28;
    L29:
        RealFieldElement r112 = r28;
        RealFieldElement r30 = (RealFieldElement) r6.absoluteAccuracy.add(r6.relativeAccuracy.multiply(r27));
        T r31 = (T) r21;
        double r210 = 0.0d;
        if (((RealFieldElement) ((RealFieldElement) r31.subtract(r110)).subtract(r30)).getReal() <= 0.0d) goto L84;
        if (((RealFieldElement) r29.subtract(r6.functionValueAccuracy)).getReal() < 0.0d) goto L84;
        T r211 = r31;
        int r32 = r24;
        if (r32 < 2) goto L37;
        RealFieldElement r33 = r22;
        RealFieldElement r212 = (RealFieldElement) ((RealFieldElement) r33.divide(16.0d)).negate();
        int r213 = r32;
        RealFieldElement r310 = r14;
        int r40 = r25;
    L41:
        int r214 = r3;
        int r41 = 0;
    L42:
        System.arraycopy(r12, r41, r5, r41, r214 - r41);
        RealFieldElement r42 = r26;
        T r215 = r9;
        int r43 = r3;
        RealFieldElement r113 = r10;
        RealFieldElement r311 = r15;
        int r114 = r20;
        RealFieldElement[] r115 = r5;
        RealFieldElement r216 = r111;
        RealFieldElement r312 = r112;
        double r116 = r210;
        int r117 = r41;
        T r313 = r211;
        RealFieldElement r217 = r33;
        T r44 = guessX(r212, r5, r13, r41, r214);
        if (((RealFieldElement) r44.subtract(r110)).getReal() <= r116) goto L48;
        T r45 = r313;
        if (((RealFieldElement) r44.subtract(r45)).getReal() >= r116) goto L50;
        r41 = r117;
    L55:
        if (Double.isNaN(r44.getReal()) == false) goto L61;
        if ((r214 - r41) <= 1) goto L61;
        r210 = r116;
        r5 = r115;
        r33 = r217;
        r111 = r216;
        r26 = r42;
        r112 = r312;
        r15 = r311;
        r211 = r45;
        r20 = r114;
        r10 = r113;
        r3 = r43;
        r9 = r215;
    L61:
        if (Double.isNaN(r44.getReal()) == false) goto L63;
        r44 = (T) r110.add(((RealFieldElement) r45.subtract(r110)).divide(2.0d));
        r41 = r114 - 1;
        int r46 = r114;
    L64:
        r6.evaluations.increment();
        RealFieldElement r47 = r7.value(r44);
        if (Precision.equals(r47.getReal(), r116, 1) == true) goto L66;
        if (r43 <= 2) goto L74;
        int r48 = r46 - r41;
        if (r48 == r43) goto L74;
        System.arraycopy(r12, r41, r12, 0, r48);
        System.arraycopy(r13, r41, r13, 0, r48);
        int r49 = r114 - r41;
    L72:
        r114 = r49;
    L79:
        int r50 = r114 + 1;
        int r51 = r48 - r114;
        System.arraycopy(r12, r114, r12, r50, r51);
        r12[r114] = r44;
        System.arraycopy(r13, r114, r13, r50, r51);
        r13[r114] = r47;
        int r52 = r48 + 1;
        if (((RealFieldElement) r47.multiply(r42)).getReal() > r116) goto L82;
        int r53 = r213 + 1;
        r21 = r44;
        r23 = (RealFieldElement) r47.abs();
        r22 = r47;
        r26 = r42;
        int r54 = 0;
    L83:
        r6 = this;
        r7 = r35;
        r14 = r310;
        r5 = r115;
        r9 = r215;
        r24 = r53;
        r4 = r116;
        r111 = r216;
        r15 = r311;
        r25 = r54;
        r3 = r52;
        r20 = r114;
        r10 = r113;
        goto L22
    L82:
        r110 = r44;
        r21 = r45;
        r26 = r47;
        r114 = r50;
        r22 = r217;
        r54 = r40 + 1;
        r23 = r312;
        r53 = 0;
        r216 = (RealFieldElement) r47.abs();
    L74:
        if (r43 != r12.length) goto L78;
        r48 = r43 - 1;
        if (r114 < ((r12.length + 1) / 2)) goto L79;
        System.arraycopy(r12, 1, r12, 0, r48);
        System.arraycopy(r13, 1, r13, 0, r48);
        r49 = r114 - 1;
        goto L72
    L78:
        r48 = r43;
        goto L79
    L66:
        return (T) r44;
    L63:
        r46 = r214;
    L50:
        if ((r114 - r117) < (r214 - r114)) goto L52;
        r41 = r117 + 1;
    L53:
        r44 = r113;
        goto L55
    L52:
        r214 = r214 - 1;
        r41 = r117;
        goto L53
    L48:
        r45 = r313;
        goto L50
    L37:
        r213 = r32;
        r310 = r14;
        r33 = r22;
        r40 = r25;
        if (r40 < 2) goto L40;
        r212 = (RealFieldElement) ((RealFieldElement) r26.divide(16.0d)).negate();
        goto L41
    L40:
        r212 = r9;
    L84:
        RealFieldElement r218 = r111;
        RealFieldElement r55 = r26;
        int r56 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[r39.ordinal()];
        if (r56 == 1) goto L108;
        if (r56 != 2) goto L89;
        return r110;
    L89:
        if (r56 != 3) goto L91;
        return r31;
    L91:
        if (r56 == 4) goto L101;
        if (r56 != 5) goto L99;
        if (r55.getReal() < 0.0d) goto L97;
        return r110;
    L97:
        return r31;
    L99:
        throw new MathInternalError(null);
    L101:
        if (r55.getReal() > 0.0d) goto L104;
        return r110;
    L104:
        return r31;
    L108:
        if (((RealFieldElement) r218.subtract(r112)).getReal() >= 0.0d) goto L111;
        return r110;
    L111:
        return r31;
    L28:
        r29 = r111;
        goto L29
    L24:
        r27 = r15;
        goto L25
    L13:
        r6.evaluations.increment();
        RealFieldElement r57 = r7.value(r12[2]);
        r13[2] = r57;
        if (Precision.equals(r57.getReal(), 0.0d, 1) == false) goto L18;
        return (T) r12[2];
    L18:
        if (((RealFieldElement) r13[1].multiply(r13[2])).getReal() >= 0.0d) goto L113;
        r2 = 2;
        r3 = 3;
        goto L20
    L113:
        throw new NoBracketingException(r12[0].getReal(), r12[2].getReal(), r13[0].getReal(), r13[2].getReal());
    L5:
        return (T) r12[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T guessX(T r8, T[] r9, T[] r10, int r11, int r12) {
        int r0 = r11;
    L3:
        int r1 = r12 - 1;
        if (r0 >= r1) goto L9;
        int r2 = r0 + 1;
        int r3 = r2 - r11;
    L6:
        if (r1 <= r0) goto L8;
        r9[r1] = (RealFieldElement) ((RealFieldElement) r9[r1].subtract(r9[r1 - 1])).divide(r10[r1].subtract(r10[r1 - r3]));
        r1 = r1 - 1;
        goto L6
    L8:
        r0 = r2;
        goto L3
    L9:
        T r7 = this.field.getZero();
    L10:
        if (r1 < r11) goto L12;
        r7 = (T) r9[r1].add(r7.multiply(r8.subtract(r10[r1])));
        r1 = r1 - 1;
        goto L10
    L12:
        return r7;
    }
}
