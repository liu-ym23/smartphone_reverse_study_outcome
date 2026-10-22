package org.apache.commons.math3.ode.nonstiff;

import com.ttnet.org.chromium.net.NetError;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DormandPrince54FieldIntegrator<T extends RealFieldElement<T>> extends EmbeddedRungeKuttaFieldIntegrator<T> {
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";
    private final T e1;
    private final T e3;
    private final T e4;
    private final T e5;
    private final T e6;
    private final T e7;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public int getOrder() {
        return 5;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public DormandPrince54FieldIntegrator(Field<T> r14, double r15, double r17, double r19, double r21) {
        super(r14, METHOD_NAME, 6, r15, r17, r19, r21);
        this.e1 = fraction(71, 57600);
        this.e3 = fraction(-71, 16695);
        this.e4 = fraction(71, 1920);
        this.e5 = fraction(-17253, 339200);
        this.e6 = fraction(22, 525);
        this.e7 = fraction(-1, 40);
    }

    public DormandPrince54FieldIntegrator(Field<T> r12, double r13, double r15, double[] r17, double[] r18) {
        super(r12, METHOD_NAME, 6, r13, r15, r17, r18);
        this.e1 = fraction(71, 57600);
        this.e3 = fraction(-71, 16695);
        this.e4 = fraction(71, 1920);
        this.e5 = fraction(-17253, 339200);
        this.e6 = fraction(22, 525);
        this.e7 = fraction(-1, 40);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 6));
        r0[0] = fraction(1, 5);
        r0[1] = fraction(3, 10);
        r0[2] = fraction(4, 5);
        r0[3] = fraction(8, 9);
        r0[4] = getField().getOne();
        r0[5] = getField().getOne();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 6, -1));
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L6;
        int r4 = r2 + 1;
        r0[r2] = (RealFieldElement[]) MathArrays.buildArray(getField(), r4);
        r2 = r4;
        goto L4
    L6:
        r0[0][0] = fraction(1, 5);
        r0[1][0] = fraction(3, 40);
        r0[1][1] = fraction(9, 40);
        r0[2][0] = fraction(44, 45);
        r0[2][1] = fraction(-56, 15);
        r0[2][2] = fraction(32, 9);
        r0[3][0] = fraction(19372, 6561);
        r0[3][1] = fraction(-25360, 2187);
        r0[3][2] = fraction(64448, 6561);
        r0[3][3] = fraction(NetError.ERR_CERT_NAME_CONSTRAINT_VIOLATION, 729);
        r0[4][0] = fraction(9017, 3168);
        r0[4][1] = fraction(NetError.ERR_INCOMPLETE_CHUNKED_ENCODING, 33);
        r0[4][2] = fraction(46732, 5247);
        r0[4][3] = fraction(49, 176);
        r0[4][4] = fraction(-5103, 18656);
        r0[5][0] = fraction(35, 384);
        r0[5][1] = getField().getZero();
        r0[5][2] = fraction(500, 1113);
        r0[5][3] = fraction(125, 192);
        r0[5][4] = fraction(-2187, 6784);
        r0[5][5] = fraction(11, 84);
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 7));
        r0[0] = fraction(35, 384);
        r0[1] = getField().getZero();
        r0[2] = fraction(500, 1113);
        r0[3] = fraction(125, 192);
        r0[4] = fraction(-2187, 6784);
        r0[5] = fraction(11, 84);
        r0[6] = getField().getZero();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected DormandPrince54FieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new DormandPrince54FieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected T estimateError(T[][] r8, T[] r9, T[] r10, T r11) {
        T r0 = getField().getZero();
        int r2 = 0;
    L4:
        if (r2 >= this.mainSetDimension) goto L11;
        RealFieldElement r3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8[0][r2].multiply(this.e1)).add(r8[2][r2].multiply(this.e3))).add(r8[3][r2].multiply(this.e4))).add(r8[4][r2].multiply(this.e5))).add(r8[5][r2].multiply(this.e6))).add(r8[6][r2].multiply(this.e7));
        RealFieldElement r4 = MathUtils.max((RealFieldElement) r9[r2].abs(), (RealFieldElement) r10[r2].abs());
        if (this.vecAbsoluteTolerance != null) goto L8;
        RealFieldElement r5 = (RealFieldElement) r4.multiply(this.scalRelativeTolerance);
        double r6 = this.scalAbsoluteTolerance;
    L9:
        RealFieldElement r7 = (RealFieldElement) ((RealFieldElement) r11.multiply(r3)).divide((RealFieldElement) r5.add(r6));
        r0 = (T) r0.add(r7.multiply(r7));
        r2 = r2 + 1;
        goto L4
    L8:
        r5 = (RealFieldElement) r4.multiply(this.vecRelativeTolerance[r2]);
        r6 = this.vecAbsoluteTolerance[r2];
        goto L9
    L11:
        return (T) ((RealFieldElement) r0.divide(this.mainSetDimension)).sqrt();
    }
}
