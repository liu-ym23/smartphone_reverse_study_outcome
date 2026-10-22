package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class LegendreRuleFactory extends BaseRuleFactory<Double> {
    public LegendreRuleFactory() {
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    protected Pair<Double[], Double[]> computeRule(int r28) throws DimensionMismatchException {
        Double r5 = Double.valueOf(0.0d);
        int r7 = 1;
        if (r28 == 1) goto L5;
        Double[] r8 = getRuleInternal(r28 - 1).getFirst();
        Double[] r9 = new Double[r28];
        Double[] r10 = new Double[r28];
        int r11 = r28 / 2;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L36;
        if (r12 != 0) goto L10;
        double r15 = -1.0d;
    L11:
        if (r11 != r7) goto L13;
        double r17 = 1.0d;
    L14:
        int r6 = r7;
        double r19 = r15;
        double r21 = 1.0d;
    L15:
        if (r6 >= r28) goto L17;
        int r2 = r6 + 1;
        double r13 = (((((double) ((r6 * 2) + 1)) * r15) * r19) - (((double) r6) * r21)) / ((double) r2);
        r6 = r2;
        r21 = r19;
        r19 = r13;
        goto L15
    L17:
        double r1 = (r15 + r17) * 0.5d;
        double r14 = r1;
        int r16 = 0;
        double r22 = 1.0d;
    L18:
        if (r16 != 0) goto L35;
        if ((r17 - r15) > Math.ulp(r1)) goto L22;
        r16 = r7;
    L23:
        r14 = r1;
        int r3 = r7;
        r22 = 1.0d;
    L24:
        if (r3 >= r28) goto L26;
        double r18 = ((((double) ((r3 * 2) + r7)) * r1) * r14) - (((double) r3) * r22);
        r3 = r3 + 1;
        r22 = r14;
        r5 = r5;
        r14 = r18 / ((double) r3);
        r7 = 1;
        r8 = r8;
        goto L24
    L26:
        r5 = r5;
        r8 = r8;
        if (r16 != 0) goto L34;
        if ((r19 * r14) > 0.0d) goto L31;
        r17 = r1;
    L32:
        r1 = (r15 + r17) * 0.5d;
        goto L34
    L31:
        r15 = r1;
        r19 = r14;
    L34:
        r7 = 1;
        goto L18
    L22:
        r16 = 0;
        goto L23
    L35:
        double r4 = ((double) r28) * (r22 - (r14 * r1));
        double r110 = ((1.0d - (r1 * r1)) * 2.0d) / (r4 * r4);
        r9[r12] = Double.valueOf(r1);
        r10[r12] = Double.valueOf(r110);
        int r20 = (r28 - r12) - 1;
        r9[r20] = Double.valueOf(-r1);
        r10[r20] = Double.valueOf(r110);
        r12 = r12 + 1;
        r5 = r5;
        r8 = r8;
        r7 = 1;
        goto L7
    L13:
        r17 = r8[r12].doubleValue();
        goto L14
    L10:
        r15 = r8[r12 - 1].doubleValue();
        goto L11
    L36:
        Double r24 = r5;
        int r23 = r7;
        double r111 = 1.0d;
        if ((r28 % 2) == 0) goto L43;
        int r25 = r23;
    L39:
        if (r25 >= r28) goto L41;
        r111 = (((double) (-r25)) * r111) / ((double) (r25 + 1));
        r25 = r25 + 2;
        goto L39
    L41:
        double r0 = ((double) r28) * r111;
        r9[r11] = r24;
        r10[r11] = Double.valueOf(2.0d / (r0 * r0));
    L43:
        return new Pair(r9, r10);
    L5:
        return new Pair(new Double[]{r5}, new Double[]{Double.valueOf(2.0d)});
    }
}
