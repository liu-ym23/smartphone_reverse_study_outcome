package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final byte[] messageSuffix;
    private final Enums.HashType mgf1Hash;
    private final byte[] outputPrefix;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    public RsaSsaPssSignJce(final RSAPrivateCrtKey priv, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        this(priv, sigHash, mgf1Hash, saltLength, new byte[0], new byte[0]);
    }

    private RsaSsaPssSignJce(final RSAPrivateCrtKey priv, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static PublicKeySign create(RsaSsaPssPrivateKey key) throws GeneralSecurityException {
        RSAPrivateCrtKey r2 = (RSAPrivateCrtKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePrivate(new RSAPrivateCrtKeySpec(key.getPublicKey().getModulus(), key.getParameters().getPublicExponent(), key.getPrivateExponent().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getCrtCoefficient().getBigInteger(InsecureSecretKeyAccess.get())));
        RsaSsaPssParameters r0 = key.getParameters();
        Enums.HashType r3 = (Enums.HashType) RsaSsaPssVerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(r0.getSigHashType());
        Enums.HashType r4 = (Enums.HashType) RsaSsaPssVerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(r0.getMgf1HashType());
        int r5 = r0.getSaltLengthBytes();
        byte[] r6 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(RsaSsaPssParameters.Variant.LEGACY) == false) goto L5;
        byte[] r11 = {0};
    L7:
        return new RsaSsaPssSignJce(r2, r3, r4, r5, r6, r11);
    L5:
        r11 = new byte[0];
        goto L7
    }

    private byte[] noPrefixSign(final byte[] data) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(data, this.publicKey.getModulus().bitLength() - 1));
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.messageSuffix;
        if (r0.length != 0) goto L5;
        byte[] r6 = noPrefixSign(data);
    L6:
        byte[] r5 = this.outputPrefix;
        if (r5.length != 0) goto L10;
        return r6;
    L10:
        return Bytes.concat(new byte[][]{r5, r6});
    L5:
        r6 = noPrefixSign(Bytes.concat(new byte[][]{data, r0}));
        goto L6
    }

    private byte[] rsasp1(byte[] m) throws GeneralSecurityException {
        Cipher r0 = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        r0.init(2, this.privateKey);
        byte[] r1 = r0.doFinal(m);
        Cipher r2 = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        r2.init(1, this.publicKey);
        byte[] r4 = r2.doFinal(r1);
        if (new BigInteger(1, m).equals(new BigInteger(1, r4)) == false) goto L6;
        return r1;
    L6:
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    private byte[] emsaPssEncode(byte[] m, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest r0 = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] r14 = r0.digest(m);
        int r1 = r0.getDigestLength();
        int r2 = ((emBits - 1) / 8) + 1;
        int r5 = this.saltLength;
        if (r2 < ((r1 + r5) + 2)) goto L14;
        byte[] r6 = Random.randBytes(r5);
        int r7 = r1 + 8;
        byte[] r8 = new byte[this.saltLength + r7];
        System.arraycopy(r14, 0, r8, 8, r1);
        System.arraycopy(r6, 0, r8, r7, r6.length);
        byte[] r15 = r0.digest(r8);
        int r3 = (r2 - r1) - 1;
        byte[] r4 = new byte[r3];
        int r9 = this.saltLength;
        r4[((r2 - r9) - r1) - 2] = 1;
        System.arraycopy(r6, 0, r4, ((r2 - r9) - r1) - 1, r6.length);
        byte[] r13 = SubtleUtil.mgf1(r15, r3, this.mgf1Hash);
        byte[] r10 = new byte[r3];
        int r11 = 0;
    L5:
        if (r11 >= r3) goto L7;
        r10[r11] = (byte) (r4[r11] ^ r13[r11]);
        r11 = r11 + 1;
        goto L5
    L7:
        int r16 = 0;
    L9:
        if (r16 >= ((((long) r2) * 8) - ((long) emBits))) goto L11;
        int r12 = r16 / 8;
        r10[r12] = (byte) ((~(1 << (7 - (r16 % 8)))) & r10[r12]);
        r16 = r16 + 1;
        goto L9
    L11:
        int r17 = r1 + r3;
        byte[] r18 = new byte[r17 + 1];
        System.arraycopy(r10, 0, r18, 0, r3);
        System.arraycopy(r15, 0, r18, r3, r15.length);
        r18[r17] = -68;
        return r18;
    L14:
        throw new GeneralSecurityException("encoding error");
    }
}
