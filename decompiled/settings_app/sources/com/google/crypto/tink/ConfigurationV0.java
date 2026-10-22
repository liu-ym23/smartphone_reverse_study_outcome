package com.google.crypto.tink;

import com.google.crypto.tink.aead.AeadWrapper;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.aead.ChaCha20Poly1305Key;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.aead.internal.ChaCha20Poly1305Jce;
import com.google.crypto.tink.aead.internal.XChaCha20Poly1305Jce;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.daead.DeterministicAeadWrapper;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.hybrid.HybridDecryptWrapper;
import com.google.crypto.tink.hybrid.HybridEncryptWrapper;
import com.google.crypto.tink.internal.InternalConfiguration;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacWrapper;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.MacWrapper;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.prf.HkdfPrfParameters;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.PrfSetWrapper;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.signature.PublicKeySignWrapper;
import com.google.crypto.tink.signature.PublicKeyVerifyWrapper;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.StreamingAeadWrapper;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigurationV0 {
    private static final int AES_CMAC_KEY_SIZE_BYTES = 32;

    public static /* synthetic */ Aead $r8$lambda$1CeEzI8YedCzSVu3rBvWA1uqnaA(XChaCha20Poly1305Key r0) {
        return createXChaCha20Poly1305(r0);
    }

    public static /* synthetic */ Mac $r8$lambda$B97gVFtCrhSw_qVPIlVKy4s84fg(AesCmacKey r0) {
        return createAesCmac(r0);
    }

    public static /* synthetic */ DeterministicAead $r8$lambda$Coi_FXAa6o6Xq5WlnZZ2Iuy_uXA(AesSivKey r0) {
        return createAesSiv(r0);
    }

    public static /* synthetic */ Aead $r8$lambda$JXQoddODyv8od2avWPf3RboKOsA(ChaCha20Poly1305Key r0) {
        return createChaCha20Poly1305(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Tk5Uiz3Li9GsOy1uz-4wTiGgoWI, reason: not valid java name */
    public static /* synthetic */ ChunkedMac m915$r8$lambda$Tk5Uiz3Li9GsOy1uz4wTiGgoWI(AesCmacKey r0) {
        return createChunkedAesCmac(r0);
    }

    public static /* synthetic */ Prf $r8$lambda$Uw8W4_ANmTA214jaJUyM4ST31pY(AesCmacPrfKey r0) {
        return createAesCmacPrf(r0);
    }

    public static /* synthetic */ Prf $r8$lambda$ZAz9hYGYiazbQKFCwqT4QB0_7H8(HkdfPrfKey r0) {
        return createHkdfPrf(r0);
    }

    private ConfigurationV0() {
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips() == true) goto L7;
        PrimitiveRegistry.Builder r0 = PrimitiveRegistry.builder();
        MacWrapper.registerToInternalPrimitiveRegistry(r0);
        ChunkedMacWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda0(), AesCmacKey.class, Mac.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda0(), HmacKey.class, Mac.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda8(), AesCmacKey.class, ChunkedMac.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda1(), HmacKey.class, ChunkedMac.class));
        AeadWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda2(), AesCtrHmacAeadKey.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda9(), AesEaxKey.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda3(), AesGcmKey.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda10(), AesGcmSivKey.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda11(), ChaCha20Poly1305Key.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda12(), XChaCha20Poly1305Key.class, Aead.class));
        DeterministicAeadWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda7(), AesSivKey.class, DeterministicAead.class));
        StreamingAeadWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda13(), AesCtrHmacStreamingKey.class, StreamingAead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda14(), AesGcmHkdfStreamingKey.class, StreamingAead.class));
        HybridEncryptWrapper.registerToInternalPrimitiveRegistry(r0);
        HybridDecryptWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda15(), EciesPublicKey.class, HybridEncrypt.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda16(), EciesPrivateKey.class, HybridDecrypt.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda17(), HpkePublicKey.class, HybridEncrypt.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda18(), HpkePrivateKey.class, HybridDecrypt.class));
        PrfSetWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda19(), AesCmacPrfKey.class, Prf.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda20(), HkdfPrfKey.class, Prf.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda4(), HmacPrfKey.class, Prf.class));
        PublicKeySignWrapper.registerToInternalPrimitiveRegistry(r0);
        PublicKeyVerifyWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda5(), EcdsaPrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda6(), EcdsaPublicKey.class, PublicKeyVerify.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda1(), Ed25519PrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda2(), Ed25519PublicKey.class, PublicKeyVerify.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda3(), RsaSsaPkcs1PrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda4(), RsaSsaPkcs1PublicKey.class, PublicKeyVerify.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda5(), RsaSsaPssPrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda6(), RsaSsaPssPublicKey.class, PublicKeyVerify.class));
        return InternalConfiguration.createFromPrimitiveRegistry(r0.build());
    L7:
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant ConfigurationV0 in FIPS mode");
    }

    private static Aead createChaCha20Poly1305(ChaCha20Poly1305Key key) throws GeneralSecurityException {
        if (ChaCha20Poly1305Jce.isSupported() == false) goto L7;
        return ChaCha20Poly1305Jce.create(key);
    L7:
        return ChaCha20Poly1305.create(key);
    }

    private static Aead createXChaCha20Poly1305(XChaCha20Poly1305Key key) throws GeneralSecurityException {
        if (XChaCha20Poly1305Jce.isSupported() == false) goto L7;
        return XChaCha20Poly1305Jce.create(key);
    L7:
        return XChaCha20Poly1305.create(key);
    }

    private static DeterministicAead createAesSiv(AesSivKey key) throws GeneralSecurityException {
        if (key.getParameters().getKeySizeBytes() != 64) goto L7;
        return AesSiv.create(key);
    L7:
        throw new GeneralSecurityException("invalid key size: " + key.getParameters().getKeySizeBytes() + ". Valid keys must have 64 bytes.");
    }

    private static Prf createHkdfPrf(HkdfPrfKey key) throws GeneralSecurityException {
        if (key.getParameters().getKeySizeBytes() < 32) goto L14;
        if (key.getParameters().getHashType() == HkdfPrfParameters.HashType.SHA256) goto L12;
        if (key.getParameters().getHashType() == HkdfPrfParameters.HashType.SHA512) goto L12;
        throw new GeneralSecurityException("Hash type must be SHA256 or SHA512");
    L12:
        return PrfImpl.wrap(HkdfStreamingPrf.create(key));
    L14:
        throw new GeneralSecurityException("Key size must be at least 32");
    }

    private static Prf createAesCmacPrf(AesCmacPrfKey key) throws GeneralSecurityException {
        if (key.getParameters().getKeySizeBytes() != 32) goto L7;
        return PrfAesCmac.create(key);
    L7:
        throw new GeneralSecurityException("Key size must be 32 bytes");
    }

    private static ChunkedMac createChunkedAesCmac(AesCmacKey key) throws GeneralSecurityException {
        if (key.getParameters().getKeySizeBytes() != 32) goto L7;
        return new ChunkedAesCmacImpl(key);
    L7:
        throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
    }

    private static Mac createAesCmac(AesCmacKey key) throws GeneralSecurityException {
        if (key.getParameters().getKeySizeBytes() != 32) goto L7;
        return PrfMac.create(key);
    L7:
        throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
    }
}
