package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.List;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.geometry.enclosing.EnclosingBall;
import org.apache.commons.math3.geometry.enclosing.SupportBallGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class DiskGenerator implements SupportBallGenerator<Euclidean2D, Vector2D> {
    public DiskGenerator() {
    }

    @Override // org.apache.commons.math3.geometry.enclosing.SupportBallGenerator
    public EnclosingBall<Euclidean2D, Vector2D> ballOnSupport(List<Vector2D> r15) {
        if (r15.size() < 1) goto L5;
        Vector2D r0 = r15.get(0);
        if (r15.size() < 2) goto L9;
        Vector2D r11 = r15.get(1);
        if (r15.size() < 3) goto L13;
        Vector2D r16 = r15.get(2);
        BigFraction[] r3 = {new BigFraction(r0.getX()), new BigFraction(r11.getX()), new BigFraction(r16.getX())};
        BigFraction[] r5 = {new BigFraction(r0.getY()), new BigFraction(r11.getY()), new BigFraction(r16.getY())};
        BigFraction r7 = r3[0];
        BigFraction r8 = r7.multiply2(r7);
        BigFraction r9 = r5[0];
        BigFraction r10 = r3[1];
        BigFraction r12 = r10.multiply2(r10);
        BigFraction r13 = r5[1];
        BigFraction r14 = r3[2];
        BigFraction r17 = r14.multiply2(r14);
        BigFraction r18 = r5[2];
        BigFraction[] r6 = {r8.add2(r9.multiply2(r9)), r12.add2(r13.multiply2(r13)), r17.add2(r18.multiply2(r18))};
        BigFraction r19 = minor(r3, r5).multiply2(2);
        BigFraction r20 = minor(r6, r5);
        BigFraction r110 = minor(r6, r3);
        BigFraction r21 = r20.divide2(r19);
        BigFraction r111 = r110.divide2(r19).negate2();
        BigFraction r4 = r3[0].subtract2(r21);
        BigFraction r22 = r5[0].subtract2(r111);
        BigFraction r23 = r4.multiply2(r4).add2(r22.multiply2(r22));
        return new EnclosingBall(new Vector2D(r21.doubleValue(), r111.doubleValue()), FastMath.sqrt(r23.doubleValue()), new Vector2D[]{r0, r11, r16});
    L13:
        return new EnclosingBall(new Vector2D(0.5d, r0, 0.5d, r11), r0.distance(r11) * 0.5d, new Vector2D[]{r0, r11});
    L9:
        return new EnclosingBall(r0, 0.0d, new Vector2D[]{r0});
    L5:
        return new EnclosingBall(Vector2D.ZERO, Double.NEGATIVE_INFINITY, new Vector2D[0]);
    }

    private BigFraction minor(BigFraction[] r7, BigFraction[] r8) {
        return r8[0].multiply2(r7[2].subtract2(r7[1])).add2(r8[1].multiply2(r7[0].subtract2(r7[2]))).add2(r8[2].multiply2(r7[1].subtract2(r7[0])));
    }
}
