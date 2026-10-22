package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.X25519;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class HpkePrivateKey extends HybridPrivateKey {
    private final SecretBytes privateKeyBytes;
    private final HpkePublicKey publicKey;

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ HybridParameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ Key getPublicKey() {
        return getPublicKey();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ HybridPublicKey getPublicKey() {
        return getPublicKey();
    }

    private HpkePrivateKey(HpkePublicKey publicKey, SecretBytes privateKeyBytes) {
        this.publicKey = publicKey;
        this.privateKeyBytes = privateKeyBytes;
    }

    private static void validatePrivateKeyByteLength(HpkeParameters.KemId kemId, SecretBytes privateKeyBytes) throws GeneralSecurityException {
        int r7 = privateKeyBytes.size();
        String r0 = "Encoded private key byte length for " + kemId + " must be %d, not " + r7;
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L9;
        if (r7 != 32) goto L7;
        return;
    L7:
        throw new GeneralSecurityException(String.format(r0, new Object[]{32}));
    L9:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L16;
        if (r7 != 48) goto L14;
        return;
    L14:
        throw new GeneralSecurityException(String.format(r0, new Object[]{48}));
    L16:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L23;
        if (r7 != 66) goto L21;
        return;
    L21:
        throw new GeneralSecurityException(String.format(r0, new Object[]{66}));
    L23:
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L29;
        if (r7 != 32) goto L27;
        return;
    L27:
        throw new GeneralSecurityException(String.format(r0, new Object[]{32}));
    L29:
        throw new GeneralSecurityException("Unable to validate private key length for " + kemId);
    }

    private static boolean isNistKem(HpkeParameters.KemId kemId) {
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L5;
    L10:
        return true;
    L5:
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L10;
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L10;
        return false;
    }

    private static ECParameterSpec getNistCurveParams(HpkeParameters.KemId kemId) {
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L7;
        return EllipticCurves.getNistP256Params();
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L11;
        return EllipticCurves.getNistP384Params();
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L15;
        return EllipticCurves.getNistP521Params();
    L15:
        throw new IllegalArgumentException("Unable to determine NIST curve params for " + kemId);
    }

    private static void validateKeyPair(HpkeParameters.KemId kemId, byte[] publicKeyBytes, byte[] privateKeyBytes) throws GeneralSecurityException {
        if (isNistKem(kemId) == false) goto L16;
        ECParameterSpec r3 = getNistCurveParams(kemId);
        BigInteger r0 = r3.getOrder();
        BigInteger r5 = BigIntegerEncoding.fromUnsignedBigEndianBytes(privateKeyBytes);
        if (r5.signum() <= 0) goto L14;
        if (r5.compareTo(r0) >= 0) goto L14;
        if (EllipticCurvesUtil.multiplyByGenerator(r5, r3).equals(EllipticCurves.pointDecode(r3.getCurve(), EllipticCurves.PointFormatType.UNCOMPRESSED, publicKeyBytes)) == false) goto L12;
        return;
    L12:
        throw new GeneralSecurityException("Invalid private key for public key.");
    L14:
        throw new GeneralSecurityException("Invalid private key.");
    L16:
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L23;
        if (Arrays.equals(X25519.publicFromPrivate(privateKeyBytes), publicKeyBytes) == false) goto L21;
        return;
    L21:
        throw new GeneralSecurityException("Invalid private key for public key.");
    L23:
        throw new IllegalArgumentException("Unable to validate key pair for " + kemId);
    }

    public static HpkePrivateKey create(HpkePublicKey publicKey, SecretBytes privateKeyBytes) throws GeneralSecurityException {
        if (publicKey == null) goto L9;
        if (privateKeyBytes == null) goto L7;
        validatePrivateKeyByteLength(publicKey.getParameters().getKemId(), privateKeyBytes);
        validateKeyPair(publicKey.getParameters().getKemId(), publicKey.getPublicKeyBytes().toByteArray(), privateKeyBytes.toByteArray(InsecureSecretKeyAccess.get()));
        return new HpkePrivateKey(publicKey, privateKeyBytes);
    L7:
        throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
    L9:
        throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
    }

    public SecretBytes getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.Key
    public HpkeParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.PrivateKey
    public HpkePublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof HpkePrivateKey) == true) goto L5;
        return false;
    L5:
        HpkePrivateKey r4 = (HpkePrivateKey) o;
        if (this.publicKey.equalsKey(r4.publicKey) == true) goto L8;
        return false;
    L8:
        if (this.privateKeyBytes.equalsSecretBytes(r4.privateKeyBytes) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
