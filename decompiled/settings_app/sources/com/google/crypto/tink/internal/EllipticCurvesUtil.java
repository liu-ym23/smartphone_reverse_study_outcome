package com.google.crypto.tink.internal;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes4.dex */
public final class EllipticCurvesUtil {
    private static final BigInteger EIGHT = null;
    private static final BigInteger FOUR = null;
    public static final ECParameterSpec NIST_P256_PARAMS = null;
    public static final ECParameterSpec NIST_P384_PARAMS = null;
    public static final ECParameterSpec NIST_P521_PARAMS = null;
    private static final BigInteger THREE = null;
    private static final BigInteger TWO = null;

    static class JacobianEcPoint {
        static final JacobianEcPoint INFINITY = null;
        BigInteger x;
        BigInteger y;
        BigInteger z;

        JacobianEcPoint(BigInteger x, BigInteger y, BigInteger z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        boolean isInfinity() {
            return this.z.equals(BigInteger.ZERO);
        }

        ECPoint toECPoint(BigInteger modulus) {
            if (isInfinity() == true) goto L5;
            BigInteger r0 = this.z.modInverse(modulus);
            BigInteger r1 = r0.multiply(r0).mod(modulus);
            return new ECPoint(this.x.multiply(r1).mod(modulus), this.y.multiply(r1).mod(modulus).multiply(r0).mod(modulus));
        L5:
            return ECPoint.POINT_INFINITY;
        }

        static {
            INFINITY = new JacobianEcPoint(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
        }
    }

    static {
        NIST_P256_PARAMS = getNistP256Params();
        NIST_P384_PARAMS = getNistP384Params();
        NIST_P521_PARAMS = getNistP521Params();
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        FOUR = BigInteger.valueOf(4);
        EIGHT = BigInteger.valueOf(8);
    }

    private static ECParameterSpec getNistP256Params() {
        return getNistCurveSpec("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    private static ECParameterSpec getNistP384Params() {
        return getNistCurveSpec("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    private static ECParameterSpec getNistP521Params() {
        return getNistCurveSpec("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    public static void checkPointOnCurve(ECPoint point, EllipticCurve ec) throws GeneralSecurityException {
        BigInteger r0 = getModulus(ec);
        BigInteger r1 = point.getAffineX();
        BigInteger r4 = point.getAffineY();
        if (r1 == null) goto L23;
        if (r4 == null) goto L23;
        if (r1.signum() == (-1)) goto L21;
        if (r1.compareTo(r0) >= 0) goto L21;
        if (r4.signum() == (-1)) goto L19;
        if (r4.compareTo(r0) >= 0) goto L19;
        if (r4.multiply(r4).mod(r0).equals(r1.multiply(r1).add(ec.getA()).multiply(r1).add(ec.getB()).mod(r0)) == false) goto L17;
        return;
    L17:
        throw new GeneralSecurityException("Point is not on curve");
    L19:
        throw new GeneralSecurityException("y is out of range");
    L21:
        throw new GeneralSecurityException("x is out of range");
    L23:
        throw new GeneralSecurityException("point is at infinity");
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec spec) {
        if (isSameEcParameterSpec(spec, NIST_P256_PARAMS) == false) goto L5;
    L10:
        return true;
    L5:
        if (isSameEcParameterSpec(spec, NIST_P384_PARAMS) == true) goto L10;
        if (isSameEcParameterSpec(spec, NIST_P521_PARAMS) == true) goto L10;
        return false;
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec one, ECParameterSpec two) {
        if (one.getCurve().equals(two.getCurve()) == true) goto L5;
    L11:
        return false;
    L5:
        if (one.getGenerator().equals(two.getGenerator()) == false) goto L11;
        if (one.getOrder().equals(two.getOrder()) == false) goto L11;
        if (one.getCofactor() != two.getCofactor()) goto L11;
        return true;
    }

    public static BigInteger getModulus(EllipticCurve curve) throws GeneralSecurityException {
        ECField r1 = curve.getField();
        if ((r1 instanceof ECFieldFp) == false) goto L7;
        return ((ECFieldFp) r1).getP();
    L7:
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    private static ECParameterSpec getNistCurveSpec(String decimalP, String decimalN, String hexB, String hexGX, String hexGY) {
        BigInteger r0 = new BigInteger(decimalP);
        BigInteger r3 = new BigInteger(decimalN);
        BigInteger r4 = r0.subtract(new BigInteger(ExifInterface.GPS_MEASUREMENT_3D));
        BigInteger r1 = new BigInteger(hexB, 16);
        BigInteger r5 = new BigInteger(hexGX, 16);
        BigInteger r6 = new BigInteger(hexGY, 16);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(r0), r4, r1), new ECPoint(r5, r6), r3, 1);
    }

    public static ECPoint multiplyByGenerator(BigInteger x, ECParameterSpec spec) throws GeneralSecurityException {
        if (isNistEcParameterSpec(spec) == false) goto L22;
        if (x.signum() != 1) goto L20;
        if (x.compareTo(spec.getOrder()) >= 0) goto L18;
        EllipticCurve r0 = spec.getCurve();
        ECPoint r1 = spec.getGenerator();
        checkPointOnCurve(r1, r0);
        BigInteger r7 = spec.getCurve().getA();
        BigInteger r2 = getModulus(r0);
        JacobianEcPoint r3 = toJacobianEcPoint(ECPoint.POINT_INFINITY, r2);
        JacobianEcPoint r4 = toJacobianEcPoint(r1, r2);
        int r5 = x.bitLength();
    L9:
        if (r5 < 0) goto L15;
        if (x.testBit(r5) == false) goto L13;
        r3 = addJacobianPoints(r3, r4, r7, r2);
        r4 = doubleJacobianPoint(r4, r7, r2);
    L14:
        r5 = r5 - 1;
        goto L9
    L13:
        r4 = addJacobianPoints(r3, r4, r7, r2);
        r3 = doubleJacobianPoint(r3, r7, r2);
        goto L14
    L15:
        ECPoint r6 = r3.toECPoint(r2);
        checkPointOnCurve(r6, r0);
        return r6;
    L18:
        throw new GeneralSecurityException("k must be smaller than the order of the generator");
    L20:
        throw new GeneralSecurityException("k must be positive");
    L22:
        throw new GeneralSecurityException("spec must be NIST P256, P384 or P521");
    }

    static JacobianEcPoint toJacobianEcPoint(ECPoint p, BigInteger modulus) {
        if (p.equals(ECPoint.POINT_INFINITY) == true) goto L5;
        BigInteger r0 = new BigInteger(1, com.google.crypto.tink.subtle.Random.randBytes((modulus.bitLength() + 8) / 8)).mod(modulus);
        BigInteger r1 = r0.multiply(r0).mod(modulus);
        BigInteger r2 = r1.multiply(r0).mod(modulus);
        return new JacobianEcPoint(p.getAffineX().multiply(r1).mod(modulus), p.getAffineY().multiply(r2).mod(modulus), r0);
    L5:
        return JacobianEcPoint.INFINITY;
    }

    static JacobianEcPoint doubleJacobianPoint(JacobianEcPoint p, BigInteger a, BigInteger modulus) {
        if (p.y.equals(BigInteger.ZERO) == true) goto L5;
        BigInteger r0 = p.x.multiply(p.x).mod(modulus);
        BigInteger r1 = p.y.multiply(p.y).mod(modulus);
        BigInteger r2 = r1.multiply(r1).mod(modulus);
        BigInteger r3 = p.z.multiply(p.z).mod(modulus);
        BigInteger r4 = p.x.add(r1);
        BigInteger r5 = r4.multiply(r4).mod(modulus).subtract(r0).subtract(r2);
        BigInteger r6 = TWO;
        BigInteger r7 = r5.multiply(r6);
        BigInteger r8 = r0.multiply(THREE).add(a.multiply(r3).multiply(r3).mod(modulus));
        BigInteger r9 = r8.multiply(r8).mod(modulus).subtract(r7.multiply(r6)).mod(modulus);
        BigInteger r10 = r8.multiply(r7.subtract(r9)).mod(modulus).subtract(r2.multiply(EIGHT)).mod(modulus);
        BigInteger r11 = p.y.add(p.z);
        return new JacobianEcPoint(r9, r10, r11.multiply(r11).mod(modulus).subtract(r1).subtract(r3).mod(modulus));
    L5:
        return JacobianEcPoint.INFINITY;
    }

    static JacobianEcPoint addJacobianPoints(JacobianEcPoint p1, JacobianEcPoint p2, BigInteger a, BigInteger modulus) {
        if (p1.isInfinity() == false) goto L6;
        return p2;
    L6:
        if (p2.isInfinity() == false) goto L8;
        return p1;
    L8:
        BigInteger r0 = p1.z.multiply(p1.z).mod(modulus);
        BigInteger r1 = p2.z.multiply(p2.z).mod(modulus);
        BigInteger r2 = p1.x.multiply(r1).mod(modulus);
        BigInteger r3 = p2.x.multiply(r0).mod(modulus);
        BigInteger r4 = p1.y.multiply(p2.z).mod(modulus).multiply(r1).mod(modulus);
        BigInteger r5 = p2.y.multiply(p1.z).mod(modulus).multiply(r0).mod(modulus);
        if (r2.equals(r3) == true) goto L11;
        BigInteger r11 = r3.subtract(r2).mod(modulus);
        BigInteger r6 = r11.multiply(FOUR).multiply(r11).mod(modulus);
        BigInteger r7 = r11.multiply(r6).mod(modulus);
        BigInteger r8 = r5.subtract(r4);
        BigInteger r9 = TWO;
        BigInteger r10 = r8.multiply(r9).mod(modulus);
        BigInteger r12 = r2.multiply(r6).mod(modulus);
        BigInteger r13 = r10.multiply(r10).mod(modulus).subtract(r7).subtract(r12.multiply(r9)).mod(modulus);
        BigInteger r14 = r10.multiply(r12.subtract(r13)).subtract(r4.multiply(r9).multiply(r7)).mod(modulus);
        BigInteger r15 = p1.z.add(p2.z);
        return new JacobianEcPoint(r13, r14, r15.multiply(r15).mod(modulus).subtract(r0).subtract(r1).multiply(r11).mod(modulus));
    L11:
        if (r4.equals(r5) == true) goto L15;
        return JacobianEcPoint.INFINITY;
    L15:
        return doubleJacobianPoint(p1, a, modulus);
    }

    private EllipticCurvesUtil() {
    }
}
