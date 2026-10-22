package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DormandPrince853FieldIntegrator<T extends RealFieldElement<T>> extends EmbeddedRungeKuttaFieldIntegrator<T> {
    private static final String METHOD_NAME = "Dormand-Prince 8 (5, 3)";
    private final T e1_01;
    private final T e1_06;
    private final T e1_07;
    private final T e1_08;
    private final T e1_09;
    private final T e1_10;
    private final T e1_11;
    private final T e1_12;
    private final T e2_01;
    private final T e2_06;
    private final T e2_07;
    private final T e2_08;
    private final T e2_09;
    private final T e2_10;
    private final T e2_11;
    private final T e2_12;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public int getOrder() {
        return 8;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public DormandPrince853FieldIntegrator(Field<T> r14, double r15, double r17, double r19, double r21) {
        super(r14, METHOD_NAME, 12, r15, r17, r19, r21);
        this.e1_01 = fraction(1.16092271E8d, 8.84846592E9d);
        this.e1_06 = fraction(-1871647.0d, 1527680.0d);
        this.e1_07 = fraction(-6.9799717E7d, 1.4079366E8d);
        this.e1_08 = fraction(1.230164450203E12d, 7.39113984E11d);
        this.e1_09 = fraction(-1.980813971228885E15d, 5.654156025964544E15d);
        this.e1_10 = fraction(4.64500805E8d, 1.389975552E9d);
        this.e1_11 = fraction(1.606764981773E12d, 1.9613062656E13d);
        this.e1_12 = fraction(-137909.0d, 6168960.0d);
        this.e2_01 = fraction(-364463.0d, 1920240.0d);
        this.e2_06 = fraction(3399327.0d, 763840.0d);
        this.e2_07 = fraction(6.6578432E7d, 3.5198415E7d);
        this.e2_08 = fraction(-1.674902723E9d, 2.887164E8d);
        this.e2_09 = fraction(-7.4684743568175E13d, 1.76692375811392E14d);
        this.e2_10 = fraction(-734375.0d, 4826304.0d);
        this.e2_11 = fraction(1.71414593E8d, 8.512614E8d);
        this.e2_12 = fraction(69869.0d, 3084480.0d);
    }

    public DormandPrince853FieldIntegrator(Field<T> r12, double r13, double r15, double[] r17, double[] r18) {
        super(r12, METHOD_NAME, 12, r13, r15, r17, r18);
        this.e1_01 = fraction(1.16092271E8d, 8.84846592E9d);
        this.e1_06 = fraction(-1871647.0d, 1527680.0d);
        this.e1_07 = fraction(-6.9799717E7d, 1.4079366E8d);
        this.e1_08 = fraction(1.230164450203E12d, 7.39113984E11d);
        this.e1_09 = fraction(-1.980813971228885E15d, 5.654156025964544E15d);
        this.e1_10 = fraction(4.64500805E8d, 1.389975552E9d);
        this.e1_11 = fraction(1.606764981773E12d, 1.9613062656E13d);
        this.e1_12 = fraction(-137909.0d, 6168960.0d);
        this.e2_01 = fraction(-364463.0d, 1920240.0d);
        this.e2_06 = fraction(3399327.0d, 763840.0d);
        this.e2_07 = fraction(6.6578432E7d, 3.5198415E7d);
        this.e2_08 = fraction(-1.674902723E9d, 2.887164E8d);
        this.e2_09 = fraction(-7.4684743568175E13d, 1.76692375811392E14d);
        this.e2_10 = fraction(-734375.0d, 4826304.0d);
        this.e2_11 = fraction(1.71414593E8d, 8.512614E8d);
        this.e2_12 = fraction(69869.0d, 3084480.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) getField().getOne().multiply(6)).sqrt();
        T[] r2 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 15));
        r2[0] = (RealFieldElement) ((RealFieldElement) r0.add(-6.0d)).divide(-67.5d);
        r2[1] = (RealFieldElement) ((RealFieldElement) r0.add(-6.0d)).divide(-45.0d);
        r2[2] = (RealFieldElement) ((RealFieldElement) r0.add(-6.0d)).divide(-30.0d);
        r2[3] = (RealFieldElement) ((RealFieldElement) r0.add(6.0d)).divide(30.0d);
        r2[4] = fraction(1, 3);
        r2[5] = fraction(1, 4);
        r2[6] = fraction(4, 13);
        r2[7] = fraction(127, 195);
        r2[8] = fraction(3, 5);
        r2[9] = fraction(6, 7);
        r2[10] = getField().getOne();
        r2[11] = getField().getOne();
        r2[12] = fraction(1.0d, 10.0d);
        r2[13] = fraction(1.0d, 5.0d);
        r2[14] = fraction(7.0d, 9.0d);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        RealFieldElement r1 = (RealFieldElement) ((RealFieldElement) getField().getOne().multiply(6)).sqrt();
        T[][] r3 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 15, -1));
        int r5 = 0;
    L4:
        if (r5 >= r3.length) goto L6;
        int r7 = r5 + 1;
        r3[r5] = (RealFieldElement[]) MathArrays.buildArray(getField(), r7);
        r5 = r7;
        goto L4
    L6:
        r3[0][0] = (RealFieldElement) ((RealFieldElement) r1.add(-6.0d)).divide(-67.5d);
        r3[1][0] = (RealFieldElement) ((RealFieldElement) r1.add(-6.0d)).divide(-180.0d);
        r3[1][1] = (RealFieldElement) ((RealFieldElement) r1.add(-6.0d)).divide(-60.0d);
        r3[2][0] = (RealFieldElement) ((RealFieldElement) r1.add(-6.0d)).divide(-120.0d);
        r3[2][1] = getField().getZero();
        r3[2][2] = (RealFieldElement) ((RealFieldElement) r1.add(-6.0d)).divide(-40.0d);
        r3[3][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(107)).add(462.0d)).divide(3000.0d);
        r3[3][1] = getField().getZero();
        r3[3][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(197)).add(402.0d)).divide(-1000.0d);
        r3[3][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(73)).add(168.0d)).divide(375.0d);
        r3[4][0] = fraction(1, 27);
        r3[4][1] = getField().getZero();
        r3[4][2] = getField().getZero();
        r3[4][3] = (RealFieldElement) ((RealFieldElement) r1.add(16.0d)).divide(108.0d);
        r3[4][4] = (RealFieldElement) ((RealFieldElement) r1.add(-16.0d)).divide(-108.0d);
        r3[5][0] = fraction(19, 512);
        r3[5][1] = getField().getZero();
        r3[5][2] = getField().getZero();
        r3[5][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(23)).add(118.0d)).divide(1024.0d);
        r3[5][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-23)).add(118.0d)).divide(1024.0d);
        r3[5][5] = fraction(-9, 512);
        r3[6][0] = fraction(13772, 371293);
        r3[6][1] = getField().getZero();
        r3[6][2] = getField().getZero();
        r3[6][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(4784)).add(51544.0d)).divide(371293.0d);
        r3[6][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-4784)).add(51544.0d)).divide(371293.0d);
        r3[6][5] = fraction(-5688, 371293);
        r3[6][6] = fraction(3072, 371293);
        r3[7][0] = fraction(5.8656157643E10d, 9.3983540625E10d);
        r3[7][1] = getField().getZero();
        r3[7][2] = getField().getZero();
        r3[7][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-3.18801444819E11d)).add(-1.324889724104E12d)).divide(6.265569375E11d);
        r3[7][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(3.18801444819E11d)).add(-1.324889724104E12d)).divide(6.265569375E11d);
        r3[7][5] = fraction(9.6044563816E10d, 3.480871875E9d);
        r3[7][6] = fraction(5.682451879168E12d, 2.81950621875E11d);
        r3[7][7] = fraction(-1.65125654E8d, 3796875.0d);
        r3[8][0] = fraction(8909899.0d, 1.8653125E7d);
        r3[8][1] = getField().getZero();
        r3[8][2] = getField().getZero();
        r3[8][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-1137963.0d)).add(-4521408.0d)).divide(2937500.0d);
        r3[8][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(1137963.0d)).add(-4521408.0d)).divide(2937500.0d);
        r3[8][5] = fraction(9.6663078E7d, 4553125.0d);
        r3[8][6] = fraction(2.107245056E9d, 1.37915625E8d);
        r3[8][7] = fraction(-4.913652016E9d, 1.47609375E8d);
        r3[8][8] = fraction(-7.889427E7d, 3.880452869E9d);
        r3[9][0] = fraction(-2.0401265806E10d, 2.1769653311E10d);
        r3[9][1] = getField().getZero();
        r3[9][2] = getField().getZero();
        r3[9][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(94326.0d)).add(354216.0d)).divide(112847.0d);
        r3[9][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-94326.0d)).add(354216.0d)).divide(112847.0d);
        r3[9][5] = fraction(-4.3306765128E10d, 5.313852383E9d);
        r3[9][6] = fraction(-2.0866708358144E13d, 1.126708119789E12d);
        r3[9][7] = fraction(1.488600343802E13d, 6.54632330667E11d);
        r3[9][8] = fraction(3.5290686222309376E16d, 1.4152473387134412E16d);
        r3[9][9] = fraction(-1.477884375E9d, 4.85066827E8d);
        r3[10][0] = fraction(3.9815761E7d, 1.7514443E7d);
        r3[10][1] = getField().getZero();
        r3[10][2] = getField().getZero();
        r3[10][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(-960905.0d)).add(-3457480.0d)).divide(551636.0d);
        r3[10][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(960905.0d)).add(-3457480.0d)).divide(551636.0d);
        r3[10][5] = fraction(-8.44554132E8d, 4.7026969E7d);
        r3[10][6] = fraction(8.444996352E9d, 3.02158619E8d);
        r3[10][7] = fraction(-2.509602342E9d, 8.77790785E8d);
        r3[10][8] = fraction(-2.838879529799625E16d, 3.199510091356783E15d);
        r3[10][9] = fraction(2.2671625E8d, 1.8341897E7d);
        r3[10][10] = fraction(1.371316744E9d, 2.131383595E9d);
        r3[11][0] = fraction(104257.0d, 1920240.0d);
        r3[11][1] = getField().getZero();
        r3[11][2] = getField().getZero();
        r3[11][3] = getField().getZero();
        r3[11][4] = getField().getZero();
        r3[11][5] = fraction(3399327.0d, 763840.0d);
        r3[11][6] = fraction(6.6578432E7d, 3.5198415E7d);
        r3[11][7] = fraction(-1.674902723E9d, 2.887164E8d);
        r3[11][8] = fraction(5.4980371265625E13d, 1.76692375811392E14d);
        r3[11][9] = fraction(-734375.0d, 4826304.0d);
        r3[11][10] = fraction(1.71414593E8d, 8.512614E8d);
        r3[11][11] = fraction(137909.0d, 3084480.0d);
        r3[12][0] = fraction(1.3481885573E10d, 2.4003E11d);
        r3[12][1] = getField().getZero();
        r3[12][2] = getField().getZero();
        r3[12][3] = getField().getZero();
        r3[12][4] = getField().getZero();
        r3[12][5] = getField().getZero();
        r3[12][6] = fraction(1.39418837528E11d, 5.49975234375E11d);
        r3[12][7] = fraction(-1.1108320068443E13d, 4.51119375E13d);
        r3[12][8] = fraction(-1.769651421925959E15d, 1.424938514608E16d);
        r3[12][9] = fraction(5.7799439E7d, 3.77055E8d);
        r3[12][10] = fraction(7.93322643029E11d, 9.673425E13d);
        r3[12][11] = fraction(1.458939311E9d, 1.9278E11d);
        r3[12][12] = fraction(-4149.0d, 500000.0d);
        r3[13][0] = fraction(1.595561272731E12d, 5.01202735E13d);
        r3[13][1] = getField().getZero();
        r3[13][2] = getField().getZero();
        r3[13][3] = getField().getZero();
        r3[13][4] = getField().getZero();
        r3[13][5] = fraction(9.75183916491E11d, 3.445768803125E13d);
        r3[13][6] = fraction(3.8492013932672E13d, 7.18912673015625E14d);
        r3[13][7] = fraction(-1.114881286517557E15d, 2.02987107675E16d);
        r3[13][8] = getField().getZero();
        r3[13][9] = getField().getZero();
        r3[13][10] = fraction(-2.538710946863E12d, 2.343122786125E16d);
        r3[13][11] = fraction(8.824659001E9d, 2.306671678125E13d);
        r3[13][12] = fraction(-1.1518334563E10d, 3.38311846125E13d);
        r3[13][13] = fraction(1.912306948E9d, 1.3532473845E10d);
        r3[14][0] = fraction(-1.3613986967E10d, 3.1741908048E10d);
        r3[14][1] = getField().getZero();
        r3[14][2] = getField().getZero();
        r3[14][3] = getField().getZero();
        r3[14][4] = getField().getZero();
        r3[14][5] = fraction(-4.755612631E9d, 1.012344804E9d);
        r3[14][6] = fraction(4.2939257944576E13d, 5.588559685701E12d);
        r3[14][7] = fraction(7.7881972900277E13d, 1.9140370552944E13d);
        r3[14][8] = fraction(2.2719829234375E13d, 6.3689648654052E13d);
        r3[14][9] = getField().getZero();
        r3[14][10] = getField().getZero();
        r3[14][11] = getField().getZero();
        r3[14][12] = fraction(-1.199007803E9d, 8.57031517296E11d);
        r3[14][13] = fraction(1.57882067E11d, 5.3564469831E10d);
        r3[14][14] = fraction(-2.90468882375E11d, 3.1741908048E10d);
        return r3;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 16));
        r0[0] = fraction(104257, 1920240);
        r0[1] = getField().getZero();
        r0[2] = getField().getZero();
        r0[3] = getField().getZero();
        r0[4] = getField().getZero();
        r0[5] = fraction(3399327.0d, 763840.0d);
        r0[6] = fraction(6.6578432E7d, 3.5198415E7d);
        r0[7] = fraction(-1.674902723E9d, 2.887164E8d);
        r0[8] = fraction(5.4980371265625E13d, 1.76692375811392E14d);
        r0[9] = fraction(-734375.0d, 4826304.0d);
        r0[10] = fraction(1.71414593E8d, 8.512614E8d);
        r0[11] = fraction(137909.0d, 3084480.0d);
        r0[12] = getField().getZero();
        r0[13] = getField().getZero();
        r0[14] = getField().getZero();
        r0[15] = getField().getZero();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected DormandPrince853FieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new DormandPrince853FieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected T estimateError(T[][] r16, T[] r17, T[] r18, T r19) {
        RealFieldElement r1 = (RealFieldElement) r19.getField().getZero();
        RealFieldElement r2 = (RealFieldElement) r19.getField().getZero();
        int r4 = 0;
    L4:
        if (r4 >= this.mainSetDimension) goto L10;
        RealFieldElement r5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r16[0][r4].multiply(this.e1_01)).add(r16[5][r4].multiply(this.e1_06))).add(r16[6][r4].multiply(this.e1_07))).add(r16[7][r4].multiply(this.e1_08))).add(r16[8][r4].multiply(this.e1_09))).add(r16[9][r4].multiply(this.e1_10))).add(r16[10][r4].multiply(this.e1_11))).add(r16[11][r4].multiply(this.e1_12));
        RealFieldElement r6 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r16[0][r4].multiply(this.e2_01)).add(r16[5][r4].multiply(this.e2_06))).add(r16[6][r4].multiply(this.e2_07))).add(r16[7][r4].multiply(this.e2_08))).add(r16[8][r4].multiply(this.e2_09))).add(r16[9][r4].multiply(this.e2_10))).add(r16[10][r4].multiply(this.e2_11))).add(r16[11][r4].multiply(this.e2_12));
        RealFieldElement r7 = MathUtils.max((RealFieldElement) r17[r4].abs(), (RealFieldElement) r18[r4].abs());
        if (this.vecAbsoluteTolerance != null) goto L8;
        RealFieldElement r8 = (RealFieldElement) r7.multiply(this.scalRelativeTolerance);
        double r9 = this.scalAbsoluteTolerance;
    L9:
        RealFieldElement r10 = (RealFieldElement) r8.add(r9);
        RealFieldElement r11 = (RealFieldElement) r5.divide(r10);
        r1 = (RealFieldElement) r1.add(r11.multiply(r11));
        RealFieldElement r12 = (RealFieldElement) r6.divide(r10);
        r2 = (RealFieldElement) r2.add(r12.multiply(r12));
        r4 = r4 + 1;
        goto L4
    L8:
        r8 = (RealFieldElement) r7.multiply(this.vecRelativeTolerance[r4]);
        r9 = this.vecAbsoluteTolerance[r4];
        goto L9
    L10:
        RealFieldElement r3 = (RealFieldElement) r1.add(r2.multiply(0.01d));
        if (r3.getReal() > 0.0d) goto L14;
        r3 = (RealFieldElement) r19.getField().getOne();
    L14:
        return (T) ((RealFieldElement) ((RealFieldElement) r19.abs()).multiply(r1)).divide(((RealFieldElement) r3.multiply(this.mainSetDimension)).sqrt());
    }
}
