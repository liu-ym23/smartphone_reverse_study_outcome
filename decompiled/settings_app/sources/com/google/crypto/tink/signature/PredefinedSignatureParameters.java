package com.google.crypto.tink.signature;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedSignatureParameters {
    public static final EcdsaParameters ECDSA_P256 = null;
    public static final EcdsaParameters ECDSA_P256_IEEE_P1363 = null;
    public static final EcdsaParameters ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX = null;
    public static final EcdsaParameters ECDSA_P384 = null;
    public static final EcdsaParameters ECDSA_P384_IEEE_P1363 = null;
    public static final EcdsaParameters ECDSA_P521 = null;
    public static final EcdsaParameters ECDSA_P521_IEEE_P1363 = null;
    public static final Ed25519Parameters ED25519 = null;
    public static final Ed25519Parameters ED25519WithRawOutput = null;
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_3072_SHA256_F4 = null;
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX = null;
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_4096_SHA512_F4 = null;
    public static final RsaSsaPssParameters RSA_SSA_PSS_3072_SHA256_SHA256_32_F4 = null;
    public static final RsaSsaPssParameters RSA_SSA_PSS_4096_SHA512_SHA512_64_F4 = null;

    static {
        ECDSA_P256 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda0());
        ECDSA_P384 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda9());
        ECDSA_P521 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda10());
        ECDSA_P256_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda11());
        ECDSA_P384_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda12());
        ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda13());
        ECDSA_P521_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda1());
        ED25519 = (Ed25519Parameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda2());
        ED25519WithRawOutput = (Ed25519Parameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda3());
        RSA_SSA_PKCS1_3072_SHA256_F4 = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda4());
        RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda5());
        RSA_SSA_PKCS1_4096_SHA512_F4 = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda6());
        RSA_SSA_PSS_3072_SHA256_SHA256_32_F4 = (RsaSsaPssParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda7());
        RSA_SSA_PSS_4096_SHA512_SHA512_64_F4 = (RsaSsaPssParameters) TinkBugException.exceptionIsBug(new PredefinedSignatureParameters$$ExternalSyntheticLambda8());
    }

    static /* synthetic */ EcdsaParameters lambda$static$0() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA256).setCurveType(EcdsaParameters.CurveType.NIST_P256).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$1() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P384).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$2() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P521).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$3() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$4() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P384).setHashType(EcdsaParameters.HashType.SHA512).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$5() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.NO_PREFIX).build();
    }

    static /* synthetic */ EcdsaParameters lambda$static$6() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P521).setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    static /* synthetic */ Ed25519Parameters lambda$static$7() throws Exception {
        return Ed25519Parameters.create(Ed25519Parameters.Variant.TINK);
    }

    static /* synthetic */ Ed25519Parameters lambda$static$8() throws Exception {
        return Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX);
    }

    static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$9() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build();
    }

    static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$10() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
    }

    static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$11() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build();
    }

    static /* synthetic */ RsaSsaPssParameters lambda$static$12() throws Exception {
        return RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA256).setMgf1HashType(RsaSsaPssParameters.HashType.SHA256).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build();
    }

    static /* synthetic */ RsaSsaPssParameters lambda$static$13() throws Exception {
        return RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA512).setMgf1HashType(RsaSsaPssParameters.HashType.SHA512).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build();
    }

    private PredefinedSignatureParameters() {
    }
}
