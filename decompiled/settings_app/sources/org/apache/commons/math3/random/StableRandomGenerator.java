package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class StableRandomGenerator implements NormalizedRandomGenerator {
    private final double alpha;
    private final double beta;
    private final RandomGenerator generator;
    private final double zeta;

    public StableRandomGenerator(RandomGenerator r8, double r9, double r11) throws NullArgumentException, OutOfRangeException {
        if (r8 == null) goto L24;
        if (r9 <= 0.0d) goto L22;
        if (r9 > 2.0d) goto L22;
        if (r11 < (-1.0d)) goto L20;
        if (r11 > 1.0d) goto L20;
        this.generator = r8;
        this.alpha = r9;
        this.beta = r11;
        if (r9 < 2.0d) goto L15;
    L17:
        this.zeta = 0.0d;
        return;
    L15:
        if (r11 == 0.0d) goto L17;
        this.zeta = r11 * FastMath.tan((r9 * 3.141592653589793d) / 2.0d);
        return;
    L20:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, Double.valueOf(r11), -1, 1);
    L22:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, Double.valueOf(r9), 0, 2);
    L24:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.random.NormalizedRandomGenerator
    public double nextNormalizedDouble() {
        double r1 = -FastMath.log(this.generator.nextDouble());
        double r3 = (this.generator.nextDouble() - 0.5d) * 3.141592653589793d;
        double r7 = this.alpha;
        if (r7 != 2.0d) goto L7;
        return FastMath.sqrt(r1 * 2.0d) * FastMath.sin(r3);
    L7:
        if (this.beta == 0.0d) goto L9;
        double r8 = FastMath.cos(r3);
        if (FastMath.abs(this.alpha - 1.0d) <= 1.0E-8d) goto L15;
        double r5 = this.alpha * r3;
        double r4 = r3 - r5;
        double r9 = ((FastMath.sin(r5) + (this.zeta * FastMath.cos(r5))) / r8) * (FastMath.cos(r4) + (this.zeta * FastMath.sin(r4)));
        double r6 = this.alpha;
        return r9 / FastMath.pow(r1 * r8, (1.0d - r6) / r6);
    L15:
        double r14 = (this.beta * r3) + 1.5707963267948966d;
        double r2 = 0.6366197723675814d * ((FastMath.tan(r3) * r14) - (this.beta * FastMath.log(((r1 * 1.5707963267948966d) * r8) / r14)));
        double r10 = this.alpha;
        if (r10 == 1.0d) goto L19;
        return r2 + (this.beta * FastMath.tan((r10 * 3.141592653589793d) / 2.0d));
    L19:
        return r2;
    L9:
        if (r7 != 1.0d) goto L21;
        return FastMath.tan(r3);
    L21:
        return (FastMath.pow(r1 * FastMath.cos((1.0d - r7) * r3), (1.0d / this.alpha) - 1.0d) * FastMath.sin(this.alpha * r3)) / FastMath.pow(FastMath.cos(r3), 1.0d / this.alpha);
    }
}
