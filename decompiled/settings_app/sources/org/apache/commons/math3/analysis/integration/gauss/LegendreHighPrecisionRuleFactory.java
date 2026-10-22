package org.apache.commons.math3.analysis.integration.gauss;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class LegendreHighPrecisionRuleFactory extends BaseRuleFactory<BigDecimal> {
    private final MathContext mContext;
    private final BigDecimal minusOne;
    private final BigDecimal oneHalf;
    private final BigDecimal two;

    public LegendreHighPrecisionRuleFactory() {
        this(MathContext.DECIMAL128);
    }

    public LegendreHighPrecisionRuleFactory(MathContext r3) {
        this.mContext = r3;
        this.two = new BigDecimal(ExifInterface.GPS_MEASUREMENT_2D, r3);
        this.minusOne = new BigDecimal("-1", r3);
        this.oneHalf = new BigDecimal("0.5", r3);
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    protected Pair<BigDecimal[], BigDecimal[]> computeRule(int r22) throws DimensionMismatchException {
        int r3 = 1;
        if (r22 == 1) goto L5;
        BigDecimal[] r4 = getRuleInternal(r22 - 1).getFirst();
        BigDecimal[] r5 = new BigDecimal[r22];
        BigDecimal[] r6 = new BigDecimal[r22];
        int r7 = r22 / 2;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L35;
        if (r8 != 0) goto L10;
        BigDecimal r10 = this.minusOne;
    L11:
        if (r7 != r3) goto L13;
        BigDecimal r11 = BigDecimal.ONE;
    L14:
        BigDecimal r12 = BigDecimal.ONE;
        int r2 = r3;
        BigDecimal r14 = r11;
        BigDecimal r15 = BigDecimal.ONE;
        BigDecimal r13 = r12;
        BigDecimal r16 = r10;
    L15:
        if (r2 >= r22) goto L17;
        BigDecimal[] r17 = r4;
        BigDecimal r9 = new BigDecimal((r2 * 2) + 1, this.mContext);
        BigDecimal r18 = new BigDecimal(r2, this.mContext);
        int r19 = r2 + 1;
        BigDecimal r20 = new BigDecimal(r19, this.mContext);
        BigDecimal r21 = r16.multiply(r10.multiply(r9, this.mContext), this.mContext).subtract(r13.multiply(r18, this.mContext), this.mContext).divide(r20, this.mContext);
        BigDecimal r23 = r14.multiply(r11.multiply(r9, this.mContext), this.mContext).subtract(r15.multiply(r18, this.mContext), this.mContext).divide(r20, this.mContext);
        r13 = r16;
        r15 = r14;
        r4 = r17;
        r7 = r7;
        r16 = r21;
        r14 = r23;
        r2 = r19;
        goto L15
    L17:
        BigDecimal[] r110 = r4;
        int r111 = r7;
        BigDecimal r24 = r10.add(r11, this.mContext).multiply(this.oneHalf, this.mContext);
        BigDecimal r25 = BigDecimal.ONE;
        boolean r26 = false;
        BigDecimal r27 = r24;
    L18:
        if (r26 == true) goto L34;
        if (r11.subtract(r10, this.mContext).compareTo(r24.ulp().multiply(BigDecimal.TEN, this.mContext)) > 0) goto L22;
        r26 = true;
    L23:
        r25 = BigDecimal.ONE;
        int r28 = 1;
        r27 = r24;
    L24:
        if (r28 >= r22) goto L26;
        BigDecimal r112 = new BigDecimal((r28 * 2) + 1, this.mContext);
        BigDecimal r113 = new BigDecimal(r28, this.mContext);
        r28 = r28 + 1;
        BigDecimal r29 = r27.multiply(r24.multiply(r112, this.mContext), this.mContext).subtract(r25.multiply(r113, this.mContext), this.mContext).divide(new BigDecimal(r28, this.mContext), this.mContext);
        r10 = r10;
        r25 = r27;
        r27 = r29;
        goto L24
    L26:
        BigDecimal r114 = r10;
        if (r26 == false) goto L29;
        r10 = r114;
        goto L18
    L29:
        if ((r16.signum() * r27.signum()) > 0) goto L31;
        r11 = r24;
        r24 = r114;
    L32:
        r10 = r24;
        r24 = r24.add(r11, this.mContext).multiply(this.oneHalf, this.mContext);
        goto L18
    L31:
        r16 = r27;
        goto L32
    L22:
        r26 = false;
        goto L23
    L34:
        BigDecimal r30 = BigDecimal.ONE.subtract(r24.pow(2, this.mContext), this.mContext).multiply(this.two, this.mContext).divide(r25.subtract(r24.multiply(r27, this.mContext), this.mContext).multiply(new BigDecimal(r22, this.mContext)).pow(2, this.mContext), this.mContext);
        r5[r8] = r24;
        r6[r8] = r30;
        int r31 = (r22 - r8) - 1;
        r5[r31] = r24.negate(this.mContext);
        r6[r31] = r30;
        r8 = r8 + 1;
        r3 = 1;
        r4 = r110;
        r7 = r111;
        goto L7
    L13:
        r11 = r4[r8];
        goto L14
    L10:
        r10 = r4[r8 - 1];
        goto L11
    L35:
        int r115 = r7;
        int r32 = r3;
        if ((r22 % 2) == 0) goto L42;
        BigDecimal r33 = BigDecimal.ONE;
        int r34 = r32;
    L38:
        if (r34 >= r22) goto L40;
        r33 = r33.multiply(new BigDecimal(r34, this.mContext), this.mContext).divide(new BigDecimal(r34 + 1, this.mContext), this.mContext).negate(this.mContext);
        r34 = r34 + 2;
        goto L38
    L40:
        BigDecimal r0 = this.two.divide(r33.multiply(new BigDecimal(r22, this.mContext), this.mContext).pow(2, this.mContext), this.mContext);
        r5[r115] = BigDecimal.ZERO;
        r6[r115] = r0;
    L42:
        return new Pair(r5, r6);
    L5:
        return new Pair(new BigDecimal[]{BigDecimal.ZERO}, new BigDecimal[]{this.two});
    }
}
