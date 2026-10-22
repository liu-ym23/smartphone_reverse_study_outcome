package com.google.crypto.tink;

import com.google.crypto.tink.aead.AeadWrapper;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.InternalConfiguration;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.Random;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacWrapper;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.MacWrapper;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.PrfSetWrapper;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.signature.PublicKeySignWrapper;
import com.google.crypto.tink.signature.PublicKeyVerifyWrapper;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigurationFips140v2 {
    public static /* synthetic */ PublicKeySign $r8$lambda$HZAve_i99xs8w2qMMadhx0_GF2M(RsaSsaPkcs1PrivateKey r0) {
        return rsaSsaPkcs1SignCreate(r0);
    }

    public static /* synthetic */ PublicKeyVerify $r8$lambda$gMc1Ou5Q6lz4etRfW2do_1QHoLQ(RsaSsaPkcs1PublicKey r0) {
        return rsaSsaPkcs1VerifyCreate(r0);
    }

    private ConfigurationFips140v2() {
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.fipsModuleAvailable() == false) goto L7;
        Random.validateUsesConscrypt();
        PrimitiveRegistry.Builder r0 = PrimitiveRegistry.builder();
        MacWrapper.registerToInternalPrimitiveRegistry(r0);
        ChunkedMacWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda0(), HmacKey.class, Mac.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda1(), HmacKey.class, ChunkedMac.class));
        AeadWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda2(), AesCtrHmacAeadKey.class, Aead.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda3(), AesGcmKey.class, Aead.class));
        PrfSetWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda4(), HmacPrfKey.class, Prf.class));
        PublicKeySignWrapper.registerToInternalPrimitiveRegistry(r0);
        PublicKeyVerifyWrapper.registerToInternalPrimitiveRegistry(r0);
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda5(), EcdsaPrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda6(), EcdsaPublicKey.class, PublicKeyVerify.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda7(), RsaSsaPkcs1PrivateKey.class, PublicKeySign.class));
        r0.registerPrimitiveConstructor(PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda8(), RsaSsaPkcs1PublicKey.class, PublicKeyVerify.class));
        return InternalConfiguration.createFromPrimitiveRegistry(r0.build());
    L7:
        throw new GeneralSecurityException("Conscrypt is not available or does not support checking for FIPS build.");
    }

    private static PublicKeySign rsaSsaPkcs1SignCreate(RsaSsaPkcs1PrivateKey key) throws GeneralSecurityException {
        if (key.getParameters().getModulusSizeBits() == 2048) goto L10;
        if (key.getParameters().getModulusSizeBits() == 3072) goto L10;
        throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeySign: wrong RsaSsaPkcs1 key modulus size");
    L10:
        return RsaSsaPkcs1SignJce.create(key);
    }

    private static PublicKeyVerify rsaSsaPkcs1VerifyCreate(RsaSsaPkcs1PublicKey key) throws GeneralSecurityException {
        if (key.getParameters().getModulusSizeBits() == 2048) goto L10;
        if (key.getParameters().getModulusSizeBits() == 3072) goto L10;
        throw new GeneralSecurityException("Cannot create FIPS-compliant PublicKeyVerify: wrong RsaSsaPkcs1 key modulus size");
    L10:
        return RsaSsaPkcs1VerifyJce.create(key);
    }
}
