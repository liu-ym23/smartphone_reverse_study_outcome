package org.apache.commons.math3.geometry.euclidean.threed;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.enclosing.EnclosingBall;
import org.apache.commons.math3.geometry.enclosing.SupportBallGenerator;
import org.apache.commons.math3.geometry.euclidean.twod.DiskGenerator;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SphereGenerator implements SupportBallGenerator<Euclidean3D, Vector3D> {
    public SphereGenerator() {
    }

    @Override // org.apache.commons.math3.geometry.enclosing.SupportBallGenerator
    public EnclosingBall<Euclidean3D, Vector3D> ballOnSupport(List<Vector3D> r23) {
        if (r23.size() < 1) goto L5;
        Vector3D r2 = r23.get(0);
        if (r23.size() < 2) goto L9;
        Vector3D r13 = r23.get(1);
        if (r23.size() < 3) goto L13;
        Vector3D r14 = r23.get(2);
        if (r23.size() >= 4) goto L18;
        Plane r0 = new Plane(r2, r13, r14, ((r2.getNorm1() + r13.getNorm1()) + r14.getNorm1()) * 1.0E-10d);
        EnclosingBall<Euclidean2D, Vector2D> r1 = new DiskGenerator().ballOnSupport(Arrays.asList(new Vector2D[]{r0.toSubSpace(r2), r0.toSubSpace(r13), r0.toSubSpace(r14)}));
        return new EnclosingBall(r0.toSpace((Vector) r1.getCenter()), r1.getRadius(), new Vector3D[]{r2, r13, r14});
    L18:
        Vector3D r3 = r23.get(3);
        BigFraction[] r5 = {new BigFraction(r2.getX()), new BigFraction(r13.getX()), new BigFraction(r14.getX()), new BigFraction(r3.getX())};
        BigFraction[] r7 = {new BigFraction(r2.getY()), new BigFraction(r13.getY()), new BigFraction(r14.getY()), new BigFraction(r3.getY())};
        BigFraction[] r8 = {new BigFraction(r2.getZ()), new BigFraction(r13.getZ()), new BigFraction(r14.getZ()), new BigFraction(r3.getZ())};
        BigFraction r6 = r5[0];
        BigFraction r9 = r6.multiply2(r6);
        BigFraction r11 = r7[0];
        BigFraction r10 = r9.add2(r11.multiply2(r11));
        BigFraction r12 = r8[0];
        BigFraction r15 = r5[1];
        BigFraction r16 = r15.multiply2(r15);
        BigFraction r17 = r7[1];
        BigFraction r18 = r16.add2(r17.multiply2(r17));
        BigFraction r19 = r8[1];
        BigFraction r20 = r5[2];
        BigFraction r21 = r20.multiply2(r20);
        BigFraction r110 = r7[2];
        BigFraction r22 = r21.add2(r110.multiply2(r110));
        BigFraction r111 = r8[2];
        BigFraction r24 = r5[3];
        BigFraction r25 = r24.multiply2(r24);
        BigFraction r112 = r7[3];
        BigFraction r26 = r25.add2(r112.multiply2(r112));
        BigFraction r113 = r8[3];
        BigFraction[] r27 = {r10.add2(r12.multiply2(r12)), r18.add2(r19.multiply2(r19)), r22.add2(r111.multiply2(r111)), r26.add2(r113.multiply2(r113))};
        BigFraction r114 = minor(r5, r7, r8).multiply2(2);
        BigFraction r115 = minor(r27, r7, r8);
        BigFraction r28 = minor(r27, r5, r8);
        BigFraction r4 = minor(r27, r5, r7);
        BigFraction r29 = r115.divide2(r114);
        BigFraction r30 = r28.divide2(r114).negate2();
        BigFraction r31 = r4.divide2(r114);
        BigFraction r32 = r5[0].subtract2(r29);
        BigFraction r33 = r7[0].subtract2(r30);
        BigFraction r34 = r8[0].subtract2(r31);
        BigFraction r35 = r32.multiply2(r32).add2(r33.multiply2(r33)).add2(r34.multiply2(r34));
        return new EnclosingBall(new Vector3D(r29.doubleValue(), r30.doubleValue(), r31.doubleValue()), FastMath.sqrt(r35.doubleValue()), new Vector3D[]{r2, r13, r14, r3});
    L13:
        return new EnclosingBall(new Vector3D(0.5d, r2, 0.5d, r13), r2.distance(r13) * 0.5d, new Vector3D[]{r2, r13});
    L9:
        return new EnclosingBall(r2, 0.0d, new Vector3D[]{r2});
    L5:
        return new EnclosingBall(Vector3D.ZERO, Double.NEGATIVE_INFINITY, new Vector3D[0]);
    }

    private BigFraction minor(BigFraction[] r8, BigFraction[] r9, BigFraction[] r10) {
        return r9[0].multiply2(r10[1]).multiply2(r8[2].subtract2(r8[3])).add2(r9[0].multiply2(r10[2]).multiply2(r8[3].subtract2(r8[1]))).add2(r9[0].multiply2(r10[3]).multiply2(r8[1].subtract2(r8[2]))).add2(r9[1].multiply2(r10[0]).multiply2(r8[3].subtract2(r8[2]))).add2(r9[1].multiply2(r10[2]).multiply2(r8[0].subtract2(r8[3]))).add2(r9[1].multiply2(r10[3]).multiply2(r8[2].subtract2(r8[0]))).add2(r9[2].multiply2(r10[0]).multiply2(r8[1].subtract2(r8[3]))).add2(r9[2].multiply2(r10[1]).multiply2(r8[3].subtract2(r8[0]))).add2(r9[2].multiply2(r10[3]).multiply2(r8[0].subtract2(r8[1]))).add2(r9[3].multiply2(r10[0]).multiply2(r8[2].subtract2(r8[1]))).add2(r9[3].multiply2(r10[1]).multiply2(r8[0].subtract2(r8[2]))).add2(r9[3].multiply2(r10[2]).multiply2(r8[1].subtract2(r8[0])));
    }
}
