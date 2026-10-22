package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class HermiteRuleFactory extends BaseRuleFactory<Double> {
    private static final double H0 = 0.7511255444649425d;
    private static final double H1 = 1.0622519320271968d;
    private static final double SQRT_PI = 1.772453850905516d;

    public HermiteRuleFactory() {
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    protected Pair<Double[], Double[]> computeRule(int r41) throws DimensionMismatchException {
        Double r3 = Double.valueOf(0.0d);
        int r5 = 1;
        if (r41 == 1) goto L5;
        int r6 = r41 - 1;
        Double[] r7 = getRuleInternal(r6).getFirst();
        Double[] r8 = new Double[r41];
        Double[] r9 = new Double[r41];
        double r10 = FastMath.sqrt(r6 * 2);
        double r12 = FastMath.sqrt(r41 * 2);
        int r14 = r41 / 2;
        int r15 = 0;
    L7:
        double r18 = H0;
        if (r15 >= r14) goto L37;
        if (r15 != 0) goto L11;
        double r1 = -r10;
    L12:
        if (r14 != r5) goto L14;
        double r22 = -0.5d;
    L15:
        double r26 = r1 * H1;
        int r4 = r5;
        double r28 = 0.7511255444649425d;
    L16:
        if (r4 >= r41) goto L18;
        int r11 = r4 + 1;
        double r30 = r10;
        double r13 = r11;
        double r16 = ((FastMath.sqrt(2.0d / r13) * r1) * r26) - (FastMath.sqrt(((double) r4) / r13) * r28);
        r28 = r26;
        r10 = r30;
        r26 = r16;
        r4 = r11;
        goto L16
    L18:
        double r31 = r10;
        double r17 = (r1 + r22) * 0.5d;
        double r32 = 0.7511255444649425d;
        boolean r29 = false;
    L19:
        if (r29 == true) goto L35;
        if ((r22 - r1) > Math.ulp(r17)) goto L23;
        r29 = true;
    L24:
        double r33 = r17 * H1;
        r32 = 0.7511255444649425d;
        int r19 = 1;
    L25:
        if (r19 >= r41) goto L27;
        int r110 = r19 + 1;
        double r36 = r1;
        double r2 = r110;
        double r20 = ((FastMath.sqrt(2.0d / r2) * r17) * r33) - (FastMath.sqrt(((double) r19) / r2) * r32);
        r19 = r110;
        r32 = r33;
        r33 = r20;
        r1 = r36;
        goto L25
    L27:
        double r37 = r1;
        if (r29 == false) goto L30;
        r1 = r37;
        goto L19
    L30:
        if ((r26 * r33) >= 0.0d) goto L32;
        r22 = r17;
        r1 = r37;
    L33:
        r17 = (r1 + r22) * 0.5d;
        goto L19
    L32:
        r1 = r17;
        r26 = r33;
        goto L33
    L23:
        r29 = false;
        goto L24
    L35:
        double r34 = r32 * r12;
        double r111 = 2.0d / (r34 * r34);
        r8[r15] = Double.valueOf(r17);
        r9[r15] = Double.valueOf(r111);
        int r21 = r6 - r15;
        r8[r21] = Double.valueOf(-r17);
        r9[r21] = Double.valueOf(r111);
        r15 = r15 + 1;
        r10 = r31;
        r5 = 1;
        goto L7
    L14:
        r22 = r7[r15].doubleValue();
        goto L15
    L11:
        r1 = r7[r15 - 1].doubleValue();
        goto L12
    L37:
        if ((r41 % 2) == 0) goto L43;
        int r23 = 1;
    L39:
        if (r23 >= r41) goto L41;
        r18 = r18 * (-FastMath.sqrt(((double) r23) / ((double) (r23 + 1))));
        r23 = r23 + 2;
        goto L39
    L41:
        double r112 = r12 * r18;
        r8[r14] = r3;
        r9[r14] = Double.valueOf(2.0d / (r112 * r112));
    L43:
        return new Pair(r8, r9);
    L5:
        return new Pair(new Double[]{r3}, new Double[]{Double.valueOf(SQRT_PI)});
    }
}
