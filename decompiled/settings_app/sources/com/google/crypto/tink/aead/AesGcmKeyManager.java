package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda3;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.internal.AesGcmProtoSerialization;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableKeyDerivationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmKeyManager {
    private static final PrimitiveConstructor<AesGcmKey, Aead> AES_GCM_PRIMITIVE_CONSTRUCTOR = null;
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesGcmParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmParameters> KEY_DERIVER = null;
    private static final KeyManager<Aead> legacyKeyManager = null;

    public static /* synthetic */ AesGcmKey $r8$lambda$TDBJgmRZG0mLRtQkbnwbZr3b3fs(AesGcmParameters r0, Integer r1) {
        return createAesGcmKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    private static final void validate(AesGcmParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() == 24) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    static {
        AES_GCM_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda3(), AesGcmKey.class, Aead.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmKey.parser());
        KEY_DERIVER = new AesGcmKeyManager$$ExternalSyntheticLambda1();
        KEY_CREATOR = new AesGcmKeyManager$$ExternalSyntheticLambda2();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES128_GCM", PredefinedAeadParameters.AES128_GCM);
        r0.put("AES128_GCM_RAW", AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
        r0.put("AES256_GCM", PredefinedAeadParameters.AES256_GCM);
        r0.put("AES256_GCM_RAW", AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(r0);
    }

    static AesGcmKey createAesGcmKeyFromRandomness(AesGcmParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        validate(parameters);
        return AesGcmKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access)).build();
    }

    private static AesGcmKey createAesGcmKey(AesGcmParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validate(parameters);
        return AesGcmKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        AesGcmProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, r0, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate aes128GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$aes128GcmTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes128GcmTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes256GcmTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmKeyManager$$ExternalSyntheticLambda5());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes256GcmTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
    }

    private AesGcmKeyManager() {
    }
}
