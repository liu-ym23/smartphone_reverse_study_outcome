package com.google.crypto.tink.subtle;

import com.bytedance.privacy.utils.PrivacyConst;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes4.dex */
public final class EllipticCurves {

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.EllipticCurves$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType = null;

        static {
            int[] r0 = new int[CurveType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = r0;
            r0[CurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[CurveType.NIST_P384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[CurveType.NIST_P521.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[PointFormatType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType = r3;
            r3[PointFormatType.UNCOMPRESSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[PointFormatType.COMPRESSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static final enum CurveType extends Enum<CurveType> {
        private static final /* synthetic */ CurveType[] $VALUES = null;
        public static final CurveType NIST_P256 = null;
        public static final CurveType NIST_P384 = null;
        public static final CurveType NIST_P521 = null;

        private CurveType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static CurveType valueOf(String name) {
            return (CurveType) Enum.valueOf(CurveType.class, name);
        }

        public static CurveType[] values() {
            return (CurveType[]) $VALUES.clone();
        }

        static {
            CurveType r0 = new CurveType("NIST_P256", 0);
            NIST_P256 = r0;
            CurveType r1 = new CurveType("NIST_P384", 1);
            NIST_P384 = r1;
            CurveType r3 = new CurveType("NIST_P521", 2);
            NIST_P521 = r3;
            $VALUES = new CurveType[]{r0, r1, r3};
        }
    }

    public static final enum EcdsaEncoding extends Enum<EcdsaEncoding> {
        private static final /* synthetic */ EcdsaEncoding[] $VALUES = null;
        public static final EcdsaEncoding DER = null;
        public static final EcdsaEncoding IEEE_P1363 = null;

        private EcdsaEncoding(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static EcdsaEncoding valueOf(String name) {
            return (EcdsaEncoding) Enum.valueOf(EcdsaEncoding.class, name);
        }

        public static EcdsaEncoding[] values() {
            return (EcdsaEncoding[]) $VALUES.clone();
        }

        static {
            EcdsaEncoding r0 = new EcdsaEncoding("IEEE_P1363", 0);
            IEEE_P1363 = r0;
            EcdsaEncoding r1 = new EcdsaEncoding("DER", 1);
            DER = r1;
            $VALUES = new EcdsaEncoding[]{r0, r1};
        }
    }

    public static final enum PointFormatType extends Enum<PointFormatType> {
        private static final /* synthetic */ PointFormatType[] $VALUES = null;
        public static final PointFormatType COMPRESSED = null;
        public static final PointFormatType DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
        public static final PointFormatType UNCOMPRESSED = null;

        private PointFormatType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static PointFormatType valueOf(String name) {
            return (PointFormatType) Enum.valueOf(PointFormatType.class, name);
        }

        public static PointFormatType[] values() {
            return (PointFormatType[]) $VALUES.clone();
        }

        static {
            PointFormatType r0 = new PointFormatType("UNCOMPRESSED", 0);
            UNCOMPRESSED = r0;
            PointFormatType r1 = new PointFormatType("COMPRESSED", 1);
            COMPRESSED = r1;
            PointFormatType r3 = new PointFormatType("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 2);
            DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r3;
            $VALUES = new PointFormatType[]{r0, r1, r3};
        }
    }

    public static ECParameterSpec getNistP256Params() {
        return EllipticCurvesUtil.NIST_P256_PARAMS;
    }

    public static ECParameterSpec getNistP384Params() {
        return EllipticCurvesUtil.NIST_P384_PARAMS;
    }

    public static ECParameterSpec getNistP521Params() {
        return EllipticCurvesUtil.NIST_P521_PARAMS;
    }

    static void checkPublicKey(ECPublicKey key) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(key.getW(), key.getParams().getCurve());
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec spec) {
        return EllipticCurvesUtil.isNistEcParameterSpec(spec);
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec one, ECParameterSpec two) {
        return EllipticCurvesUtil.isSameEcParameterSpec(one, two);
    }

    public static void validatePublicKey(ECPublicKey publicKey, ECPrivateKey privateKey) throws GeneralSecurityException {
        validatePublicKeySpec(publicKey, privateKey);
        EllipticCurvesUtil.checkPointOnCurve(publicKey.getW(), privateKey.getParams().getCurve());
    }

    static void validatePublicKeySpec(ECPublicKey publicKey, ECPrivateKey privateKey) throws GeneralSecurityException {
    L7:
        e = move-exception;
        throw new GeneralSecurityException(e);
    L3:
        if (isSameEcParameterSpec(publicKey.getParams(), privateKey.getParams()) == false) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("invalid public key spec");     // Catch: Throwable -> L7
    }

    public static BigInteger getModulus(EllipticCurve curve) throws GeneralSecurityException {
        return EllipticCurvesUtil.getModulus(curve);
    }

    public static int fieldSizeInBits(EllipticCurve curve) throws GeneralSecurityException {
        return getModulus(curve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve curve) throws GeneralSecurityException {
        return (fieldSizeInBits(curve) + 7) / 8;
    }

    protected static BigInteger modSqrt(BigInteger x, BigInteger p) throws GeneralSecurityException {
        if (p.signum() != 1) goto L50;
        BigInteger r8 = x.mod(p);
        if (r8.equals(BigInteger.ZERO) == true) goto L7;
        int r0 = 0;
        if (p.testBit(0) == false) goto L14;
        if (p.testBit(1) == false) goto L14;
        BigInteger r1 = r8.modPow(p.add(BigInteger.ONE).shiftRight(2), p);
    L42:
        if (r1 != null) goto L44;
    L48:
        return r1;
    L44:
        if (r1.multiply(r1).mod(p).compareTo(r8) == 0) goto L48;
        throw new GeneralSecurityException("Could not find a modular square root");
    L14:
        if (p.testBit(0) == true) goto L16;
    L41:
        r1 = null;
        goto L42
    L16:
        if (p.testBit(1) == true) goto L41;
        BigInteger r2 = BigInteger.ONE;
        BigInteger r4 = p.subtract(BigInteger.ONE).shiftRight(1);
    L18:
        BigInteger r5 = r2.multiply(r2).subtract(r8).mod(p);
        if (r5.equals(BigInteger.ZERO) == true) goto L20;
        BigInteger r6 = r5.modPow(r4, p);
        if (r6.add(BigInteger.ONE).equals(p) == true) goto L23;
        if (r6.equals(BigInteger.ONE) == false) goto L40;
        r2 = r2.add(BigInteger.ONE);
        r0 = r0 + 1;
        if (r0 != 128) goto L18;
        if (p.isProbablePrime(80) == true) goto L18;
        throw new InvalidAlgorithmParameterException("p is not prime");
    L40:
        throw new InvalidAlgorithmParameterException("p is not prime");
    L23:
        BigInteger r3 = p.add(BigInteger.ONE).shiftRight(1);
        BigInteger r7 = BigInteger.ONE;
        int r9 = r3.bitLength() - 2;
        BigInteger r10 = r7;
        BigInteger r11 = r2;
    L24:
        if (r9 < 0) goto L29;
        BigInteger r12 = r11.multiply(r10);
        r11 = r11.multiply(r11).add(r10.multiply(r10).mod(p).multiply(r5)).mod(p);
        r10 = r12.add(r12).mod(p);
        if (r3.testBit(r9) == false) goto L28;
        BigInteger r13 = r11.multiply(r2).add(r10.multiply(r5)).mod(p);
        r10 = r2.multiply(r10).add(r11).mod(p);
        r11 = r13;
    L28:
        r9 = r9 - 1;
        goto L24
    L29:
        r1 = r11;
        goto L42
    L20:
        return r2;
    L7:
        return BigInteger.ZERO;
    L50:
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static BigInteger getY(BigInteger x, boolean lsb, EllipticCurve curve) throws GeneralSecurityException {
        BigInteger r0 = getModulus(curve);
        BigInteger r1 = curve.getA();
        BigInteger r5 = curve.getB();
        BigInteger r3 = modSqrt(x.multiply(x).add(r1).multiply(x).add(r5).mod(r0), r0);
        if (lsb != r3.testBit(0)) goto L5;
        return r3;
    L5:
        return r0.subtract(r3).mod(r0);
    }

    private static byte[] toMinimalSignedNumber(byte[] bs) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= bs.length) goto L9;
        if (bs[r1] != 0) goto L9;
        r1 = r1 + 1;
    L9:
        if (r1 != bs.length) goto L12;
        r1 = bs.length - 1;
    L12:
        if ((bs[r1] & 128) != 128) goto L14;
        r0 = 1;
    L14:
        byte[] r2 = new byte[(bs.length - r1) + r0];
        System.arraycopy(bs, r1, r2, r0, bs.length - r1);
        return r2;
    }

    public static byte[] ecdsaIeee2Der(byte[] ieee) throws GeneralSecurityException {
        if ((ieee.length % 2) != 0) goto L15;
        if (ieee.length == 0) goto L15;
        if (ieee.length > 132) goto L15;
        byte[] r0 = toMinimalSignedNumber(Arrays.copyOf(ieee, ieee.length / 2));
        byte[] r7 = toMinimalSignedNumber(Arrays.copyOfRange(ieee, ieee.length / 2, ieee.length));
        int r2 = (((r0.length + 2) + 1) + 1) + r7.length;
        if (r2 < 128) goto L11;
        byte[] r4 = new byte[r2 + 3];
        r4[0] = 48;
        r4[1] = -127;
        r4[2] = (byte) r2;
        int r3 = 3;
    L12:
        int r5 = r3 + 1;
        r4[r3] = 2;
        int r6 = r5 + 1;
        r4[r5] = (byte) r0.length;
        System.arraycopy(r0, 0, r4, r6, r0.length);
        int r8 = r6 + r0.length;
        int r1 = r8 + 1;
        r4[r8] = 2;
        r4[r1] = (byte) r7.length;
        System.arraycopy(r7, 0, r4, r1 + 1, r7.length);
        return r4;
    L11:
        r4 = new byte[r2 + 2];
        r4[0] = 48;
        r4[1] = (byte) r2;
        r3 = 2;
    L15:
        throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
    }

    public static byte[] ecdsaDer2Ieee(byte[] der, int ieeeLength) throws GeneralSecurityException {
        if (isValidDerEncoding(der) == false) goto L19;
        byte[] r0 = new byte[ieeeLength];
        int r1 = 1;
        if ((der[1] & 255) < 128) goto L7;
        int r2 = 3;
    L8:
        int r3 = r2 + 1;
        int r4 = r3 + 1;
        int r5 = der[r3];
        if (der[r4] != 0) goto L11;
        int r6 = 1;
    L12:
        System.arraycopy(der, r4 + r6, r0, ((ieeeLength / 2) - r5) + r6, r5 - r6);
        int r7 = r4 + (r5 + 1);
        int r8 = r7 + 1;
        int r9 = der[r7];
        if (der[r8] == 0) goto L16;
        r1 = 0;
    L16:
        System.arraycopy(der, r8 + r1, r0, (ieeeLength - r9) + r1, r9 - r1);
        return r0;
    L11:
        r6 = 0;
        goto L12
    L7:
        r2 = 2;
        goto L8
    L19:
        throw new GeneralSecurityException("Invalid DER encoding");
    }

    public static boolean isValidDerEncoding(final byte[] sig) {
        if (sig.length >= 8) goto L6;
        return false;
    L6:
        if (sig[0] == 48) goto L8;
        return false;
    L8:
        int r1 = sig[1] & 255;
        if (r1 != 129) goto L14;
        r1 = sig[2] & 255;
        if (r1 >= 128) goto L13;
        return false;
    L13:
        int r3 = 2;
    L19:
        if (r1 == ((sig.length - 1) - r3)) goto L21;
        return false;
    L21:
        int r2 = r3 + 1;
        if (sig[r2] == 2) goto L24;
        return false;
    L24:
        int r4 = r2 + 1;
        int r6 = sig[r4] & 255;
        int r5 = ((r4 + 1) + r6) + 1;
        if (r5 < sig.length) goto L27;
        return false;
    L27:
        if (r6 != 0) goto L29;
        return false;
    L29:
        int r7 = r3 + 3;
        byte r8 = sig[r7];
        if ((r8 & 255) < 128) goto L32;
        return false;
    L32:
        if (r6 <= 1) goto L38;
        if (r8 != 0) goto L38;
        if ((sig[r3 + 4] & 255) >= 128) goto L38;
        return false;
    L38:
        if (sig[r7 + r6] == 2) goto L40;
        return false;
    L40:
        int r9 = sig[r5] & 255;
        if (((r5 + 1) + r9) == sig.length) goto L43;
        return false;
    L43:
        if (r9 != 0) goto L45;
        return false;
    L45:
        byte r10 = sig[(r3 + 5) + r6];
        if ((r10 & 255) < 128) goto L48;
        return false;
    L48:
        if (r9 <= 1) goto L53;
        if (r10 != 0) goto L53;
        if ((sig[(r3 + 6) + r6] & 255) >= 128) goto L53;
        return false;
    L53:
        return true;
    L14:
        if (r1 == 128) goto L54;
        if (r1 > 129) goto L54;
        r3 = 1;
    L54:
        return false;
    }

    public static int encodingSizeInBytes(EllipticCurve curve, PointFormatType format) throws GeneralSecurityException {
        int r2 = fieldSizeInBytes(curve);
        int r3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[format.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L10;
        return r2 + 1;
    L10:
        throw new GeneralSecurityException("unknown EC point format");
    L12:
        return r2 * 2;
    L14:
        return (r2 * 2) + 1;
    }

    public static ECPoint ecPointDecode(EllipticCurve curve, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        return pointDecode(curve, format, encoded);
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        return pointDecode(getCurveSpec(curveType).getCurve(), format, encoded);
    }

    public static ECPoint pointDecode(EllipticCurve curve, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        int r0 = fieldSizeInBytes(curve);
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[format.ordinal()];
        boolean r3 = false;
        if (r1 == 1) goto L36;
        if (r1 == 2) goto L30;
        if (r1 != 3) goto L28;
        BigInteger r7 = getModulus(curve);
        if (encoded.length != (r0 + 1)) goto L26;
        byte r2 = encoded[0];
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L24;
        r3 = true;
        goto L15
    L24:
        throw new GeneralSecurityException("invalid format");
    L15:
        BigInteger r4 = new BigInteger(1, Arrays.copyOfRange(encoded, 1, encoded.length));
        if (r4.signum() == (-1)) goto L22;
        if (r4.compareTo(r7) >= 0) goto L22;
        return new ECPoint(r4, getY(r4, r3, curve));
    L22:
        throw new GeneralSecurityException("x is out of range");
    L26:
        throw new GeneralSecurityException("compressed point has wrong length");
    L28:
        throw new GeneralSecurityException("invalid format:" + format);
    L30:
        if (encoded.length != (r0 * 2)) goto L34;
        ECPoint r8 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(encoded, 0, r0)), new BigInteger(1, Arrays.copyOfRange(encoded, r0, encoded.length)));
        EllipticCurvesUtil.checkPointOnCurve(r8, curve);
        return r8;
    L34:
        throw new GeneralSecurityException("invalid point size");
    L36:
        if (encoded.length != ((r0 * 2) + 1)) goto L44;
        if (encoded[0] != 4) goto L42;
        int r5 = r0 + 1;
        ECPoint r9 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(encoded, 1, r5)), new BigInteger(1, Arrays.copyOfRange(encoded, r5, encoded.length)));
        EllipticCurvesUtil.checkPointOnCurve(r9, curve);
        return r9;
    L42:
        throw new GeneralSecurityException("invalid point format");
    L44:
        throw new GeneralSecurityException("invalid point size");
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType format, ECPoint point) throws GeneralSecurityException {
        return pointEncode(getCurveSpec(curveType).getCurve(), format, point);
    }

    public static byte[] pointEncode(EllipticCurve curve, PointFormatType format, ECPoint point) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(point, curve);
        int r5 = fieldSizeInBytes(curve);
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[format.ordinal()];
        if (r0 == 1) goto L23;
        int r3 = 2;
        if (r0 != 2) goto L7;
        int r6 = r5 * 2;
        byte[] r1 = new byte[r6];
        byte[] r2 = BigIntegerEncoding.toBigEndianBytes(point.getAffineX());
        if (r2.length <= r5) goto L18;
        r2 = Arrays.copyOfRange(r2, r2.length - r5, r2.length);
    L18:
        byte[] r7 = BigIntegerEncoding.toBigEndianBytes(point.getAffineY());
        if (r7.length <= r5) goto L21;
        r7 = Arrays.copyOfRange(r7, r7.length - r5, r7.length);
    L21:
        System.arraycopy(r7, 0, r1, r6 - r7.length, r7.length);
        System.arraycopy(r2, 0, r1, r5 - r2.length, r2.length);
        return r1;
    L7:
        if (r0 != 3) goto L14;
        int r8 = r5 + 1;
        byte[] r9 = new byte[r8];
        byte[] r4 = BigIntegerEncoding.toBigEndianBytes(point.getAffineX());
        System.arraycopy(r4, 0, r9, r8 - r4.length, r4.length);
        if (point.getAffineY().testBit(0) == false) goto L11;
        r3 = 3;
    L11:
        r9[0] = (byte) r3;
        return r9;
    L14:
        throw new GeneralSecurityException("invalid format:" + format);
    L23:
        int r10 = (r5 * 2) + 1;
        byte[] r11 = new byte[r10];
        byte[] r12 = BigIntegerEncoding.toBigEndianBytes(point.getAffineX());
        byte[] r13 = BigIntegerEncoding.toBigEndianBytes(point.getAffineY());
        System.arraycopy(r13, 0, r11, r10 - r13.length, r13.length);
        System.arraycopy(r12, 0, r11, (r5 + 1) - r12.length, r12.length);
        r11[0] = 4;
        return r11;
    }

    public static ECParameterSpec getCurveSpec(CurveType curve) throws NoSuchAlgorithmException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curve.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return getNistP521Params();
    L11:
        throw new NoSuchAlgorithmException("curve not implemented:" + curve);
    L13:
        return getNistP384Params();
    L15:
        return getNistP256Params();
    }

    public static ECPublicKey getEcPublicKey(final byte[] x509PublicKey) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(x509PublicKey));
    }

    public static ECPublicKey getEcPublicKey(CurveType curve, PointFormatType pointFormat, final byte[] publicKey) throws GeneralSecurityException {
        return getEcPublicKey(getCurveSpec(curve), pointFormat, publicKey);
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec spec, PointFormatType pointFormat, final byte[] publicKey) throws GeneralSecurityException {
        ECPublicKeySpec r3 = new ECPublicKeySpec(pointDecode(spec.getCurve(), pointFormat, publicKey), spec);
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePublic(r3);
    }

    public static ECPublicKey getEcPublicKey(CurveType curve, final byte[] x, final byte[] y) throws GeneralSecurityException {
        ECParameterSpec r2 = getCurveSpec(curve);
        ECPoint r4 = new ECPoint(new BigInteger(1, x), new BigInteger(1, y));
        EllipticCurvesUtil.checkPointOnCurve(r4, r2.getCurve());
        ECPublicKeySpec r3 = new ECPublicKeySpec(r4, r2);
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePublic(r3);
    }

    public static ECPrivateKey getEcPrivateKey(final byte[] pkcs8PrivateKey) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePrivate(new PKCS8EncodedKeySpec(pkcs8PrivateKey));
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curve, final byte[] keyValue) throws GeneralSecurityException {
        ECParameterSpec r1 = getCurveSpec(curve);
        ECPrivateKeySpec r0 = new ECPrivateKeySpec(BigIntegerEncoding.fromUnsignedBigEndianBytes(keyValue), r1);
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePrivate(r0);
    }

    public static KeyPair generateKeyPair(CurveType curve) throws GeneralSecurityException {
        return generateKeyPair(getCurveSpec(curve));
    }

    public static KeyPair generateKeyPair(ECParameterSpec spec) throws GeneralSecurityException {
        KeyPairGenerator r0 = EngineFactory.KEY_PAIR_GENERATOR.getInstance(PrivacyConst.ALGORITHM_EC);
        r0.initialize(spec);
        return r0.generateKeyPair();
    }

    private static void validateSharedSecret(byte[] secret, ECPrivateKey privateKey) throws GeneralSecurityException {
        EllipticCurve r4 = privateKey.getParams().getCurve();
        BigInteger r0 = new BigInteger(1, secret);
        if (r0.signum() == (-1)) goto L9;
        if (r0.compareTo(getModulus(r4)) >= 0) goto L9;
        getY(r0, true, r4);
        return;
    L9:
        throw new GeneralSecurityException("shared secret is out of range");
    }

    public static byte[] computeSharedSecret(ECPrivateKey myPrivateKey, ECPublicKey peerPublicKey) throws GeneralSecurityException {
        validatePublicKeySpec(peerPublicKey, myPrivateKey);
        return computeSharedSecret(myPrivateKey, peerPublicKey.getW());
    }

    public static byte[] computeSharedSecret(ECPrivateKey myPrivateKey, ECPoint publicPoint) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(publicPoint, myPrivateKey.getParams().getCurve());
        ECPublicKeySpec r1 = new ECPublicKeySpec(publicPoint, myPrivateKey.getParams());
        PublicKey r3 = EngineFactory.KEY_FACTORY.getInstance(PrivacyConst.ALGORITHM_EC).generatePublic(r1);
        KeyAgreement r0 = EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        r0.init(myPrivateKey);
        r0.doPhase(r3, true);     // Catch: IllegalStateException -> L5
        byte[] r4 = r0.generateSecret();     // Catch: IllegalStateException -> L5
        validateSharedSecret(r4, myPrivateKey);     // Catch: IllegalStateException -> L5
        return r4;
    L5:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }

    private EllipticCurves() {
    }
}
