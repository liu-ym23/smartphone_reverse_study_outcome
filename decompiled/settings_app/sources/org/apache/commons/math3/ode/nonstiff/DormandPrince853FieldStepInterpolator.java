package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
class DormandPrince853FieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T[][] d;

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    DormandPrince853FieldStepInterpolator(Field<T> r25, boolean r26, T[][] r27, FieldODEStateAndDerivative<T> r28, FieldODEStateAndDerivative<T> r29, FieldODEStateAndDerivative<T> r30, FieldODEStateAndDerivative<T> r31, FieldEquationsMapper<T> r32) {
        super(r25, r26, r27, r28, r29, r30, r31, r32);
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r25, 7, 16));
        this.d = r0;
        r0[0][0] = fraction(r25, 104257.0d, 1920240.0d);
        r0[0][1] = r25.getZero();
        r0[0][2] = r25.getZero();
        r0[0][3] = r25.getZero();
        r0[0][4] = r25.getZero();
        r0[0][5] = fraction(r25, 3399327.0d, 763840.0d);
        r0[0][6] = fraction(r25, 6.6578432E7d, 3.5198415E7d);
        r0[0][7] = fraction(r25, -1.674902723E9d, 2.887164E8d);
        r0[0][8] = fraction(r25, 5.4980371265625E13d, 1.76692375811392E14d);
        r0[0][9] = fraction(r25, -734375.0d, 4826304.0d);
        r0[0][10] = fraction(r25, 1.71414593E8d, 8.512614E8d);
        r0[0][11] = fraction(r25, 137909.0d, 3084480.0d);
        r0[0][12] = r25.getZero();
        r0[0][13] = r25.getZero();
        r0[0][14] = r25.getZero();
        r0[0][15] = r25.getZero();
        r0[1][0] = (RealFieldElement) ((RealFieldElement) r0[0][0].negate()).add(1.0d);
        r0[1][1] = (RealFieldElement) r0[0][1].negate();
        r0[1][2] = (RealFieldElement) r0[0][2].negate();
        r0[1][3] = (RealFieldElement) r0[0][3].negate();
        r0[1][4] = (RealFieldElement) r0[0][4].negate();
        r0[1][5] = (RealFieldElement) r0[0][5].negate();
        r0[1][6] = (RealFieldElement) r0[0][6].negate();
        r0[1][7] = (RealFieldElement) r0[0][7].negate();
        r0[1][8] = (RealFieldElement) r0[0][8].negate();
        r0[1][9] = (RealFieldElement) r0[0][9].negate();
        r0[1][10] = (RealFieldElement) r0[0][10].negate();
        r0[1][11] = (RealFieldElement) r0[0][11].negate();
        r0[1][12] = (RealFieldElement) r0[0][12].negate();
        r0[1][13] = (RealFieldElement) r0[0][13].negate();
        r0[1][14] = (RealFieldElement) r0[0][14].negate();
        r0[1][15] = (RealFieldElement) r0[0][15].negate();
        r0[2][0] = (RealFieldElement) ((RealFieldElement) r0[0][0].multiply(2)).subtract(1.0d);
        r0[2][1] = (RealFieldElement) r0[0][1].multiply(2);
        r0[2][2] = (RealFieldElement) r0[0][2].multiply(2);
        r0[2][3] = (RealFieldElement) r0[0][3].multiply(2);
        r0[2][4] = (RealFieldElement) r0[0][4].multiply(2);
        r0[2][5] = (RealFieldElement) r0[0][5].multiply(2);
        r0[2][6] = (RealFieldElement) r0[0][6].multiply(2);
        r0[2][7] = (RealFieldElement) r0[0][7].multiply(2);
        r0[2][8] = (RealFieldElement) r0[0][8].multiply(2);
        r0[2][9] = (RealFieldElement) r0[0][9].multiply(2);
        r0[2][10] = (RealFieldElement) r0[0][10].multiply(2);
        r0[2][11] = (RealFieldElement) r0[0][11].multiply(2);
        r0[2][12] = (RealFieldElement) ((RealFieldElement) r0[0][12].multiply(2)).subtract(1.0d);
        r0[2][13] = (RealFieldElement) r0[0][13].multiply(2);
        r0[2][14] = (RealFieldElement) r0[0][14].multiply(2);
        r0[2][15] = (RealFieldElement) r0[0][15].multiply(2);
        r0[3][0] = fraction(r25, -1.7751989329E10d, 2.10607656E9d);
        r0[3][1] = r25.getZero();
        r0[3][2] = r25.getZero();
        r0[3][3] = r25.getZero();
        r0[3][4] = r25.getZero();
        r0[3][5] = fraction(r25, 4.272954039E9d, 7.53986464E9d);
        r0[3][6] = fraction(r25, -1.18476319744E11d, 3.8604839385E10d);
        r0[3][7] = fraction(r25, 7.55123450731E11d, 3.166577316E11d);
        r0[3][8] = fraction(r25, 3.6923844612348283E18d, 1.7441304416342505E18d);
        r0[3][9] = fraction(r25, -4.612609375E9d, 5.293382976E9d);
        r0[3][10] = fraction(r25, 2.091772278379E12d, 9.336445866E11d);
        r0[3][11] = fraction(r25, 2.136624137E9d, 3.38298912E9d);
        r0[3][12] = fraction(r25, -126493.0d, 1421424.0d);
        r0[3][13] = fraction(r25, 9.835E7d, 5419179.0d);
        r0[3][14] = fraction(r25, -1.8878125E7d, 2053168.0d);
        r0[3][15] = fraction(r25, -1.944542619E9d, 4.38351368E8d);
        r0[4][0] = fraction(r25, 3.2941697297E10d, 3.15911484E9d);
        r0[4][1] = r25.getZero();
        r0[4][2] = r25.getZero();
        r0[4][3] = r25.getZero();
        r0[4][4] = r25.getZero();
        r0[4][5] = fraction(r25, 4.56696183123E11d, 1.88496616E9d);
        r0[4][6] = fraction(r25, 1.9132610714624E13d, 1.15814518155E11d);
        r0[4][7] = fraction(r25, -1.77904688592943E14d, 4.749865974E11d);
        r0[4][8] = fraction(r25, -4.821139941836765E18d, 2.180163052042813E17d);
        r0[4][9] = fraction(r25, 3.0702015625E10d, 3.970037232E9d);
        r0[4][10] = fraction(r25, -8.5916079474274E13d, 2.8009337598E12d);
        r0[4][11] = fraction(r25, -5.919468007E9d, 6.3431046E8d);
        r0[4][12] = fraction(r25, 2479159.0d, 157936.0d);
        r0[4][13] = fraction(r25, -1.875E7d, 602131.0d);
        r0[4][14] = fraction(r25, -1.9203125E7d, 2053168.0d);
        r0[4][15] = fraction(r25, 1.5700361463E10d, 4.38351368E8d);
        r0[5][0] = fraction(r25, 1.2627015655E10d, 6.31822968E8d);
        r0[5][1] = r25.getZero();
        r0[5][2] = r25.getZero();
        r0[5][3] = r25.getZero();
        r0[5][4] = r25.getZero();
        r0[5][5] = fraction(r25, -7.2955222965E10d, 1.88496616E8d);
        r0[5][6] = fraction(r25, -1.314574495232E13d, 6.9488710893E10d);
        r0[5][7] = fraction(r25, 3.0084216194513E13d, 5.6998391688E10d);
        r0[5][8] = fraction(r25, -2.9685876100664064E17d, 2.5648977082856624E16d);
        r0[5][9] = fraction(r25, 5.69140625E8d, 8.2709109E7d);
        r0[5][10] = fraction(r25, -1.8684190637E10d, 1.8672891732E10d);
        r0[5][11] = fraction(r25, 6.9644045E7d, 8.9549712E7d);
        r0[5][12] = fraction(r25, -1.1847025E7d, 4264272.0d);
        r0[5][13] = fraction(r25, -9.7865E8d, 1.6257537E7d);
        r0[5][14] = fraction(r25, 5.19371875E8d, 6159504.0d);
        r0[5][15] = fraction(r25, 5.256837225E9d, 4.38351368E8d);
        r0[6][0] = fraction(r25, -4.50944925E8d, 1.7550638E7d);
        r0[6][1] = r25.getZero();
        r0[6][2] = r25.getZero();
        r0[6][3] = r25.getZero();
        r0[6][4] = r25.getZero();
        r0[6][5] = fraction(r25, -1.4532122925E10d, 9.4248308E7d);
        r0[6][6] = fraction(r25, -5.958769664E11d, 2.573655959E9d);
        r0[6][7] = fraction(r25, 1.88748653015E11d, 5.27762886E8d);
        r0[6][8] = fraction(r25, 2.5454854581152343E18d, 2.7252038150535164E16d);
        r0[6][9] = fraction(r25, -1.376953125E9d, 3.6759604E7d);
        r0[6][10] = fraction(r25, 5.3995596795E10d, 5.18691437E8d);
        r0[6][11] = fraction(r25, 2.10311225E8d, 7047894.0d);
        r0[6][12] = fraction(r25, -1718875.0d, 39484.0d);
        r0[6][13] = fraction(r25, 5.8E7d, 602131.0d);
        r0[6][14] = fraction(r25, -1546875.0d, 39484.0d);
        r0[6][15] = fraction(r25, -1.262172375E9d, 8429834.0d);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected DormandPrince853FieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new DormandPrince853FieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    private T fraction(Field<T> r1, double r2, double r4) {
        return (T) ((RealFieldElement) r1.getZero().add(r2)).divide(r4);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r33, T r34, T r35, T r36, T r37) throws MaxCountExceededException {
        T r2 = r36;
        RealFieldElement r3 = (RealFieldElement) r34.getField().getOne();
        RealFieldElement r4 = (RealFieldElement) r3.subtract(r35);
        RealFieldElement r6 = (RealFieldElement) r35.multiply(2);
        RealFieldElement r7 = (RealFieldElement) r35.multiply(r35);
        RealFieldElement r5 = (RealFieldElement) r3.subtract(r6);
        RealFieldElement r8 = (RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(-3)).add(2.0d));
        RealFieldElement r9 = (RealFieldElement) r6.multiply(((RealFieldElement) r35.multiply(r6.subtract(3.0d))).add(1.0d));
        RealFieldElement r16 = (RealFieldElement) r7.multiply(((RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(5)).subtract(8.0d))).add(3.0d));
        RealFieldElement r10 = (RealFieldElement) r7.multiply(((RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(-6)).add(15.0d))).subtract(12.0d))).add(3.0d));
        RealFieldElement r11 = (RealFieldElement) r7.multiply(r35.multiply(((RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(((RealFieldElement) r35.multiply(-7)).add(18.0d))).subtract(15.0d))).add(4.0d)));
        if (getGlobalPreviousState() != null) goto L5;
    L11:
        RealFieldElement r12 = (RealFieldElement) r37.negate();
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) r12.multiply(r35)).negate();
        RealFieldElement r14 = (RealFieldElement) r13.multiply(r35);
        RealFieldElement r15 = (RealFieldElement) r14.multiply(r4);
        RealFieldElement r17 = (RealFieldElement) r15.multiply(r35);
        RealFieldElement r18 = (RealFieldElement) r17.multiply(r4);
        RealFieldElement r1 = (RealFieldElement) r18.multiply(r35);
        RealFieldElement[] r19 = (RealFieldElement[]) MathArrays.buildArray(r34.getField(), 16);
        RealFieldElement[] r20 = (RealFieldElement[]) MathArrays.buildArray(r34.getField(), 16);
        int r110 = 0;
    L13:
        if (r110 >= r19.length) goto L15;
        RealFieldElement r38 = r12;
        r19[r110] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r12.multiply(this.d[0][r110])).add(r13.multiply(this.d[1][r110]))).add(r14.multiply(this.d[2][r110]))).add(r15.multiply(this.d[3][r110]))).add(r17.multiply(this.d[4][r110]))).add(r18.multiply(this.d[5][r110]))).add(r1.multiply(this.d[6][r110]));
        T[][] r21 = this.d;
        r20[r110] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r21[0][r110].add(r5.multiply(r21[1][r110]))).add(r8.multiply(this.d[2][r110]))).add(r9.multiply(this.d[3][r110]))).add(r16.multiply(this.d[4][r110]))).add(r10.multiply(this.d[5][r110]))).add(r11.multiply(this.d[6][r110]));
        r110 = r110 + 1;
        r12 = r38;
        r1 = r1;
        goto L13
    L15:
        T[] r22 = currentStateLinearCombination(new RealFieldElement[]{r19[0], r19[1], r19[2], r19[3], r19[4], r19[5], r19[6], r19[7], r19[8], r19[9], r19[10], r19[11], r19[12], r19[13], r19[14], r19[15]});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r20[0], r20[1], r20[2], r20[3], r20[4], r20[5], r20[6], r20[7], r20[8], r20[9], r20[10], r20[11], r20[12], r20[13], r20[14], r20[15]});
    L17:
        return new FieldODEStateAndDerivative(r34, r22, r0);
    L5:
        if (r35.getReal() > 0.5d) goto L11;
        RealFieldElement r111 = (RealFieldElement) r2.multiply(r4);
        RealFieldElement r112 = (RealFieldElement) r111.multiply(r35);
        RealFieldElement r113 = (RealFieldElement) r112.multiply(r4);
        RealFieldElement r114 = (RealFieldElement) r113.multiply(r35);
        RealFieldElement r23 = (RealFieldElement) r114.multiply(r4);
        RealFieldElement r24 = (RealFieldElement) r23.multiply(r35);
        RealFieldElement[] r115 = (RealFieldElement[]) MathArrays.buildArray(r34.getField(), 16);
        RealFieldElement[] r25 = (RealFieldElement[]) MathArrays.buildArray(r34.getField(), 16);
        int r116 = 0;
    L8:
        if (r116 >= r115.length) goto L10;
        r115[r116] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.d[0][r116])).add(r111.multiply(this.d[1][r116]))).add(r112.multiply(this.d[2][r116]))).add(r113.multiply(this.d[3][r116]))).add(r114.multiply(this.d[4][r116]))).add(r23.multiply(this.d[5][r116]))).add(r24.multiply(this.d[6][r116]));
        T[][] r26 = this.d;
        RealFieldElement r39 = r111;
        RealFieldElement r117 = r16;
        r25[r116] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r26[0][r116].add(r5.multiply(r26[1][r116]))).add(r8.multiply(this.d[2][r116]))).add(r9.multiply(this.d[3][r116]))).add(r117.multiply(this.d[4][r116]))).add(r10.multiply(this.d[5][r116]))).add(r11.multiply(this.d[6][r116]));
        r116 = r116 + 1;
        r2 = r36;
        r16 = r117;
        r111 = r39;
        goto L8
    L10:
        r22 = previousStateLinearCombination(new RealFieldElement[]{r115[0], r115[1], r115[2], r115[3], r115[4], r115[5], r115[6], r115[7], r115[8], r115[9], r115[10], r115[11], r115[12], r115[13], r115[14], r115[15]});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r25[0], r25[1], r25[2], r25[3], r25[4], r25[5], r25[6], r25[7], r25[8], r25[9], r25[10], r25[11], r25[12], r25[13], r25[14], r25[15]});
        goto L17
    }
}
