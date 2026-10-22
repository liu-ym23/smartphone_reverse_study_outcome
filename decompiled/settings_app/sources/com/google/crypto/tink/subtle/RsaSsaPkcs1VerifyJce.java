package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
    private static final String ASN_PREFIX_SHA384 = "3041300d060960864801650304020205000430";
    private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    static final EnumTypeProtoConverter<Enums.HashType, RsaSsaPkcs1Parameters.HashType> HASH_TYPE_CONVERTER = null;
    private final Enums.HashType hash;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final RSAPublicKey publicKey;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = null;

        static {
            int[] r0 = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0;
            r0[Enums.HashType.SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, RsaSsaPkcs1Parameters.HashType.SHA256).add(Enums.HashType.SHA384, RsaSsaPkcs1Parameters.HashType.SHA384).add(Enums.HashType.SHA512, RsaSsaPkcs1Parameters.HashType.SHA512).build();
    }

    public static PublicKeyVerify create(RsaSsaPkcs1PublicKey key) throws GeneralSecurityException {
        RSAPublicKey r0 = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(key.getModulus(), key.getParameters().getPublicExponent()));
        Enums.HashType r2 = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        byte[] r3 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(RsaSsaPkcs1Parameters.Variant.LEGACY) == false) goto L5;
        byte[] r5 = {0};
    L7:
        return new RsaSsaPkcs1VerifyJce(r0, r2, r3, r5);
    L5:
        r5 = new byte[0];
        goto L7
    }

    private RsaSsaPkcs1VerifyJce(final RSAPublicKey pubKey, Enums.HashType hash, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateSignatureHash(hash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.hash = hash;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA-PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
    }

    public RsaSsaPkcs1VerifyJce(final RSAPublicKey pubKey, Enums.HashType hash) throws GeneralSecurityException {
        this(pubKey, hash, new byte[0], new byte[0]);
    }

    private void noPrefixVerify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger r0 = this.publicKey.getPublicExponent();
        BigInteger r1 = this.publicKey.getModulus();
        int r2 = (r1.bitLength() + 7) / 8;
        if (r2 != signature.length) goto L14;
        BigInteger r5 = SubtleUtil.bytes2Integer(signature);
        if (r5.compareTo(r1) >= 0) goto L12;
        if (Bytes.equal(SubtleUtil.integer2Bytes(r5.modPow(r0, r1), r2), emsaPkcs1(data, r2, this.hash)) == false) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("invalid signature");
    L12:
        throw new GeneralSecurityException("signature out of range");
    L14:
        throw new GeneralSecurityException("invalid signature's length");
    }

    private byte[] emsaPkcs1(byte[] m, int emLen, Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        MessageDigest r0 = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
        r0.update(m);
        byte[] r7 = r0.digest();
        byte[] r6 = toAsnPrefix(hash);
        int r9 = r6.length + r7.length;
        if (emLen < (r9 + 11)) goto L11;
        byte[] r1 = new byte[emLen];
        r1[0] = 0;
        r1[1] = 1;
        int r2 = 2;
        int r3 = 0;
    L6:
        if (r3 >= ((emLen - r9) - 3)) goto L8;
        r1[r2] = -1;
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L6
    L8:
        int r8 = r2 + 1;
        r1[r2] = 0;
        System.arraycopy(r6, 0, r1, r8, r6.length);
        System.arraycopy(r7, 0, r1, r8 + r6.length, r7.length);
        return r1;
    L11:
        throw new GeneralSecurityException("intended encoded message length too short");
    }

    private byte[] toAsnPrefix(Enums.HashType hash) throws GeneralSecurityException {
        int r2 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 != 3) goto L11;
        return Hex.decode(ASN_PREFIX_SHA512);
    L11:
        throw new GeneralSecurityException("Unsupported hash " + hash);
    L13:
        return Hex.decode(ASN_PREFIX_SHA384);
    L15:
        return Hex.decode(ASN_PREFIX_SHA256);
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
