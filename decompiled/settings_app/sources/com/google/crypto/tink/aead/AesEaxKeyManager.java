package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda9;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.internal.AesEaxProtoSerialization;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesEaxKeyManager {
    private static final PrimitiveConstructor<AesEaxKey, Aead> AES_EAX_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesEaxParameters> KEY_CREATOR = null;
    private static final KeyManager<Aead> legacyKeyManager = null;

    public static /* synthetic */ AesEaxKey $r8$lambda$ZJ7Ei1YnaGIUoQghUFdGWrewnTk(AesEaxParameters r0, Integer r1) {
        return createAesEaxKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    private static final void validate(AesEaxParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() == 24) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    static {
        AES_EAX_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda9(), AesEaxKey.class, Aead.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesEaxKey.parser());
        KEY_CREATOR = new AesEaxKeyManager$$ExternalSyntheticLambda3();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES128_EAX", PredefinedAeadParameters.AES128_EAX);
        r0.put("AES128_EAX_RAW", AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
        r0.put("AES256_EAX", PredefinedAeadParameters.AES256_EAX);
        r0.put("AES256_EAX_RAW", AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(r0);
    }

    private static AesEaxKey createAesEaxKey(AesEaxParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validate(parameters);
        return AesEaxKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesEaxProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_EAX_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesEaxParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }

    public static final KeyTemplate aes128EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesEaxKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes128EaxTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesEaxKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes128EaxTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesEaxKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$aes256EaxTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesEaxKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes256EaxTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
    }

    private AesEaxKeyManager() {
    }
}
