package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.X25519;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EciesPrivateKey extends HybridPrivateKey {

    @Nullable
    private final SecretBigInteger nistPrivateKeyValue;
    private final EciesPublicKey publicKey;

    @Nullable
    private final SecretBytes x25519PrivateKeyBytes;

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

    private EciesPrivateKey(EciesPublicKey publicKey, @Nullable SecretBigInteger nistPrivateKeyValue, @Nullable SecretBytes x25519PrivateKeyBytes) {
        this.publicKey = publicKey;
        this.nistPrivateKeyValue = nistPrivateKeyValue;
        this.x25519PrivateKeyBytes = x25519PrivateKeyBytes;
    }

    private static ECParameterSpec toParameterSpecNistCurve(EciesParameters.CurveType curveType) {
        if (curveType != EciesParameters.CurveType.NIST_P256) goto L7;
        return EllipticCurves.getNistP256Params();
    L7:
        if (curveType != EciesParameters.CurveType.NIST_P384) goto L11;
        return EllipticCurves.getNistP384Params();
    L11:
        if (curveType != EciesParameters.CurveType.NIST_P521) goto L15;
        return EllipticCurves.getNistP521Params();
    L15:
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + curveType);
    }

    private static void validateNistPrivateKeyValue(BigInteger privateValue, ECPoint publicPoint, EciesParameters.CurveType curveType) throws GeneralSecurityException {
        BigInteger r0 = toParameterSpecNistCurve(curveType).getOrder();
        if (privateValue.signum() <= 0) goto L12;
        if (privateValue.compareTo(r0) >= 0) goto L12;
        if (EllipticCurvesUtil.multiplyByGenerator(privateValue, toParameterSpecNistCurve(curveType)).equals(publicPoint) == false) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Invalid private value");
    L12:
        throw new GeneralSecurityException("Invalid private value");
    }

    private static void validateX25519PrivateKeyBytes(byte[] privateKeyBytes, byte[] publicKeyBytes) throws GeneralSecurityException {
        if (privateKeyBytes.length != 32) goto L10;
        if (Arrays.equals(X25519.publicFromPrivate(privateKeyBytes), publicKeyBytes) == false) goto L8;
        return;
    L8:
        throw new GeneralSecurityException("Invalid private key for public key.");
    L10:
        throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
    }

    public static EciesPrivateKey createForCurveX25519(EciesPublicKey publicKey, SecretBytes x25519PrivateKeyBytes) throws GeneralSecurityException {
        if (publicKey == null) goto L13;
        if (publicKey.getX25519CurvePointBytes() == null) goto L11;
        if (x25519PrivateKeyBytes == null) goto L9;
        validateX25519PrivateKeyBytes(x25519PrivateKeyBytes.toByteArray(InsecureSecretKeyAccess.get()), publicKey.getX25519CurvePointBytes().toByteArray());
        return new EciesPrivateKey(publicKey, null, x25519PrivateKeyBytes);
    L9:
        throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
    L11:
        throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
    L13:
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    public static EciesPrivateKey createForNistCurve(EciesPublicKey publicKey, SecretBigInteger nistPrivateKeyValue) throws GeneralSecurityException {
        if (publicKey == null) goto L13;
        if (publicKey.getNistCurvePoint() == null) goto L11;
        if (nistPrivateKeyValue == null) goto L9;
        validateNistPrivateKeyValue(nistPrivateKeyValue.getBigInteger(InsecureSecretKeyAccess.get()), publicKey.getNistCurvePoint(), publicKey.getParameters().getCurveType());
        return new EciesPrivateKey(publicKey, nistPrivateKeyValue, null);
    L9:
        throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
    L11:
        throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
    L13:
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    @Nullable
    public SecretBytes getX25519PrivateKeyBytes() {
        return this.x25519PrivateKeyBytes;
    }

    @Nullable
    public SecretBigInteger getNistPrivateKeyValue() {
        return this.nistPrivateKeyValue;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.Key
    public EciesParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.PrivateKey
    public EciesPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof EciesPrivateKey) == true) goto L5;
        return false;
    L5:
        EciesPrivateKey r4 = (EciesPrivateKey) o;
        if (this.publicKey.equalsKey(r4.publicKey) == true) goto L8;
        return false;
    L8:
        SecretBytes r0 = this.x25519PrivateKeyBytes;
        if (r0 != null) goto L15;
        if (r4.x25519PrivateKeyBytes != null) goto L15;
        return this.nistPrivateKeyValue.equalsSecretBigInteger(r4.nistPrivateKeyValue);
    L15:
        return r0.equalsSecretBytes(r4.x25519PrivateKeyBytes);
    }
}
