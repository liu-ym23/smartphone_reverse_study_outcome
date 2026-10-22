package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    static final EnumTypeProtoConverter<Enums.HashType, RsaSsaPssParameters.HashType> HASH_TYPE_CONVERTER = null;
    private final byte[] messageSuffix;
    private final Enums.HashType mgf1Hash;
    private final byte[] outputPrefix;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, RsaSsaPssParameters.HashType.SHA256).add(Enums.HashType.SHA384, RsaSsaPssParameters.HashType.SHA384).add(Enums.HashType.SHA512, RsaSsaPssParameters.HashType.SHA512).build();
    }

    public static PublicKeyVerify create(RsaSsaPssPublicKey key) throws GeneralSecurityException {
        RSAPublicKey r2 = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(key.getModulus(), key.getParameters().getPublicExponent()));
        RsaSsaPssParameters r0 = key.getParameters();
        EnumTypeProtoConverter<Enums.HashType, RsaSsaPssParameters.HashType> r1 = HASH_TYPE_CONVERTER;
        Enums.HashType r3 = (Enums.HashType) r1.toProtoEnum(r0.getSigHashType());
        Enums.HashType r4 = (Enums.HashType) r1.toProtoEnum(r0.getMgf1HashType());
        int r5 = r0.getSaltLengthBytes();
        byte[] r6 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(RsaSsaPssParameters.Variant.LEGACY) == false) goto L5;
        byte[] r9 = {0};
    L7:
        return new RsaSsaPssVerifyJce(r2, r3, r4, r5, r6, r9);
    L5:
        r9 = new byte[0];
        goto L7
    }

    public RsaSsaPssVerifyJce(final RSAPublicKey pubKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        this(pubKey, sigHash, mgf1Hash, saltLength, new byte[0], new byte[0]);
    }

    private RsaSsaPssVerifyJce(final RSAPublicKey pubKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
    }

    private void noPrefixVerify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger r0 = this.publicKey.getPublicExponent();
        BigInteger r1 = this.publicKey.getModulus();
        int r2 = (r1.bitLength() + 7) / 8;
        int r3 = ((r1.bitLength() - 1) + 7) / 8;
        if (r2 != signature.length) goto L11;
        BigInteger r6 = SubtleUtil.bytes2Integer(signature);
        if (r6.compareTo(r1) >= 0) goto L9;
        emsaPssVerify(data, SubtleUtil.integer2Bytes(r6.modPow(r0, r1), r3), r1.bitLength() - 1);
        return;
    L9:
        throw new GeneralSecurityException("signature out of range");
    L11:
        throw new GeneralSecurityException("invalid signature's length");
    }

    private void emsaPssVerify(byte[] m, byte[] em, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest r2 = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] r3 = r2.digest(m);
        int r4 = r2.getDigestLength();
        int r5 = em.length;
        if (r5 < ((this.saltLength + r4) + 2)) goto L41;
        if (em[em.length - 1] != (-68)) goto L39;
        int r6 = r5 - r4;
        int r9 = r6 - 1;
        byte[] r10 = Arrays.copyOf(em, r9);
        byte[] r1 = Arrays.copyOfRange(em, r10.length, r10.length + r4);
        int r12 = 0;
    L7:
        int r15 = r9;
        MessageDigest r16 = r2;
        byte[] r17 = r3;
        long r8 = (((long) r5) * 8) - ((long) emBits);
        if (r12 >= r8) goto L14;
        if (((r10[r12 / 8] >> (7 - (r12 % 8))) & 1) != 0) goto L13;
        r12 = r12 + 1;
        r9 = r15;
        r2 = r16;
        r3 = r17;
        goto L7
    L13:
        throw new GeneralSecurityException("inconsistent");
    L14:
        byte[] r7 = SubtleUtil.mgf1(r1, r15, this.mgf1Hash);
        int r11 = r7.length;
        byte[] r13 = new byte[r11];
        int r14 = 0;
    L15:
        if (r14 >= r11) goto L17;
        r13[r14] = (byte) (r7[r14] ^ r10[r14]);
        r14 = r14 + 1;
        goto L15
    L17:
        int r18 = 0;
    L19:
        if (r18 > r8) goto L21;
        int r19 = r18 / 8;
        r13[r19] = (byte) ((~(1 << (7 - (r18 % 8)))) & r13[r19]);
        r18 = r18 + 1;
        goto L19
    L21:
        int r20 = 0;
    L22:
        int r21 = this.saltLength;
        if (r20 >= ((r6 - r21) - 2)) goto L30;
        if (r13[r20] != 0) goto L28;
        r20 = r20 + 1;
        goto L22
    L28:
        throw new GeneralSecurityException("inconsistent");
    L30:
        if (r13[(r6 - r21) - 2] != 1) goto L37;
        byte[] r22 = Arrays.copyOfRange(r13, r11 - r21, r11);
        int r23 = r4 + 8;
        byte[] r0 = new byte[this.saltLength + r23];
        System.arraycopy(r17, 0, r0, 8, r17.length);
        System.arraycopy(r22, 0, r0, r23, r22.length);
        if (Bytes.equal(r16.digest(r0), r1) == false) goto L35;
        return;
    L35:
        throw new GeneralSecurityException("inconsistent");
    L37:
        throw new GeneralSecurityException("inconsistent");
    L39:
        throw new GeneralSecurityException("inconsistent");
    L41:
        throw new GeneralSecurityException("inconsistent");
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L9;
        if (this.messageSuffix.length != 0) goto L9;
        noPrefixVerify(signature, data);
        return;
    L9:
        if (Util.isPrefix(r0, signature) == false) goto L16;
        byte[] r1 = this.messageSuffix;
        if (r1.length == 0) goto L13;
        data = Bytes.concat(new byte[][]{data, r1});
    L13:
        noPrefixVerify(Arrays.copyOfRange(signature, this.outputPrefix.length, signature.length), data);
        return;
    L16:
        throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
    }
}
