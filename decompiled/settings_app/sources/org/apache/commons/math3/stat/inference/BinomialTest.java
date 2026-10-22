package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class BinomialTest {

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.inference.BinomialTest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis = null;

        static {
            int[] r0 = new int[AlternativeHypothesis.values().length];
            $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis = r0;
            r0[AlternativeHypothesis.GREATER_THAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[AlternativeHypothesis.LESS_THAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[AlternativeHypothesis.TWO_SIDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public BinomialTest() {
    }

    public boolean binomialTest(int r1, int r2, double r3, AlternativeHypothesis r5, double r6) {
        if (binomialTest(r1, r2, r3, r5) >= r6) goto L5;
        return true;
    L5:
        return false;
    }

    public double binomialTest(int r9, int r10, double r11, AlternativeHypothesis r13) {
        if (r9 < 0) goto L42;
        if (r10 < 0) goto L40;
        double r0 = 0.0d;
        int r2 = 0;
        if (r11 < 0.0d) goto L38;
        if (r11 > 1.0d) goto L38;
        if (r9 < r10) goto L36;
        if (r13 == null) goto L34;
        BinomialDistribution r6 = new BinomialDistribution(null, r9, r11);
        int r12 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[r13.ordinal()];
        if (r12 == 1) goto L32;
        if (r12 == 2) goto L30;
        if (r12 != 3) goto L28;
    L16:
        double r14 = r6.probability(r2);
        double r3 = r6.probability(r9);
        if (r14 != r3) goto L21;
        r0 = r0 + (r14 * 2.0d);
        r2 = r2 + 1;
    L19:
        r9 = r9 - 1;
    L24:
        if (r2 > r10) goto L26;
        if (r9 >= r10) goto L16;
    L26:
        return r0;
    L21:
        if (r14 >= r3) goto L23;
        r0 = r0 + r14;
        r2 = r2 + 1;
        goto L24
    L23:
        r0 = r0 + r3;
        goto L19
    L28:
        throw new MathInternalError(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{r13, AlternativeHypothesis.TWO_SIDED, AlternativeHypothesis.LESS_THAN});
    L30:
        return r6.cumulativeProbability(r10);
    L32:
        return 1.0d - r6.cumulativeProbability(r10 - 1);
    L34:
        throw new NullArgumentException();
    L36:
        throw new MathIllegalArgumentException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, new Object[]{Integer.valueOf(r9), Integer.valueOf(r10)});
    L38:
        throw new OutOfRangeException(Double.valueOf(r11), 0, 1);
    L40:
        throw new NotPositiveException(Integer.valueOf(r10));
    L42:
        throw new NotPositiveException(Integer.valueOf(r9));
    }
}
