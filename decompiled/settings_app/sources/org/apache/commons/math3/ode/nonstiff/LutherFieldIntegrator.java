package org.apache.commons.math3.ode.nonstiff;

import android.icu.lang.UCharacter;
import com.ttnet.org.chromium.net.NetError;
import obric.bluetooth.SmartBluetoothBinderClient;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class LutherFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public LutherFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "Luther", r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) getField().getZero().add(21.0d)).sqrt();
        T[] r1 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 6));
        r1[0] = getField().getOne();
        r1[1] = fraction(1, 2);
        r1[2] = fraction(2, 3);
        r1[3] = (RealFieldElement) ((RealFieldElement) r0.subtract(7.0d)).divide(-14.0d);
        r1[4] = (RealFieldElement) ((RealFieldElement) r0.add(7.0d)).divide(14.0d);
        r1[5] = getField().getOne();
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) getField().getZero().add(21.0d)).sqrt();
        T[][] r1 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 6, -1));
        int r3 = 0;
    L4:
        if (r3 >= r1.length) goto L6;
        int r5 = r3 + 1;
        r1[r3] = (RealFieldElement[]) MathArrays.buildArray(getField(), r5);
        r3 = r5;
        goto L4
    L6:
        r1[0][0] = getField().getOne();
        r1[1][0] = fraction(3, 8);
        r1[1][1] = fraction(1, 8);
        r1[2][0] = fraction(8, 27);
        r1[2][1] = fraction(2, 27);
        Object[] r7 = r1[2];
        r7[2] = r7[0];
        r1[3][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(9)).add(-21.0d)).divide(392.0d);
        r1[3][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(8)).add(-56.0d)).divide(392.0d);
        r1[3][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(-48)).add(336.0d)).divide(392.0d);
        r1[3][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(3)).add(-63.0d)).divide(392.0d);
        r1[4][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(-255)).add(-1155.0d)).divide(1960.0d);
        r1[4][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(-40)).add(-280.0d)).divide(1960.0d);
        r1[4][2] = (RealFieldElement) ((RealFieldElement) r0.multiply(NetError.ERR_INVALID_RESPONSE)).divide(1960.0d);
        r1[4][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(SmartBluetoothBinderClient.PRODUCT_3)).add(63.0d)).divide(1960.0d);
        r1[4][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(392)).add(2352.0d)).divide(1960.0d);
        r1[5][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(105)).add(330.0d)).divide(180.0d);
        r1[5][1] = fraction(2, 3);
        r1[5][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(UCharacter.UnicodeBlock.ZANABAZAR_SQUARE_ID)).add(-200.0d)).divide(180.0d);
        r1[5][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(NetError.ERR_TTNET_SPECIFIED_NETWORK_UNAVAILABLE_FOR_SOCKET)).add(126.0d)).divide(180.0d);
        r1[5][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(NetError.ERR_SSL_BAD_RECORD_MAC_ALERT)).add(-686.0d)).divide(180.0d);
        r1[5][5] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(-70)).add(490.0d)).divide(180.0d);
        return r1;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 7));
        r0[0] = fraction(1, 20);
        r0[1] = getField().getZero();
        r0[2] = fraction(16, 45);
        r0[3] = getField().getZero();
        T r4 = fraction(49, 180);
        r0[4] = r4;
        r0[5] = r4;
        r0[6] = r0[0];
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected LutherFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new LutherFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
