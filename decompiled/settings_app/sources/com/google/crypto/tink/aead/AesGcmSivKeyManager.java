package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda10;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.internal.AesGcmSivProtoSerialization;
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
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmSivKeyManager {
    private static final PrimitiveConstructor<AesGcmSivKey, Aead> AES_GCM_SIV_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesGcmSivParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmSivParameters> KEY_DERIVER = null;
    private static final KeyManager<Aead> legacyKeyManager = null;

    /* JADX INFO: renamed from: $r8$lambda$RTyON_KDNWDYOE4fOdJc--uvLVg, reason: not valid java name */
    public static /* synthetic */ AesGcmSivKey m916$r8$lambda$RTyON_KDNWDYOE4fOdJcuvLVg(AesGcmSivParameters r0, Integer r1) {
        return createAesGcmSivKey(r0, r1);
    }

    static {
        AES_GCM_SIV_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda10(), AesGcmSivKey.class, Aead.class);
        KEY_CREATOR = new AesGcmSivKeyManager$$ExternalSyntheticLambda3();
        KEY_DERIVER = new AesGcmSivKeyManager$$ExternalSyntheticLambda4();
        legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.AesGcmSivKey", Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmSivKey.parser());
    }

    static AesGcmSivKey createAesGcmSivKeyFromRandomness(AesGcmSivParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        return AesGcmSivKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access)).build();
    }

    private static AesGcmSivKey createAesGcmSivKey(AesGcmSivParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return AesGcmSivKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES128_GCM_SIV", AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.TINK).build());
        r0.put("AES128_GCM_SIV_RAW", AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
        r0.put("AES256_GCM_SIV", AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.TINK).build());
        r0.put("AES256_GCM_SIV_RAW", AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(r0);
    }

    private static boolean canUseAesGcmSive() {
        Cipher.getInstance("AES/GCM-SIV/NoPadding");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L9;
        AesGcmSivProtoSerialization.register();
        if (canUseAesGcmSive() == false) goto L10;
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_SIV_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmSivParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmSivParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L10:
        return;
    L9:
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }

    public static final KeyTemplate aes128GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmSivKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes128GcmSivTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmSivKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes128GcmSivTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmSivKeyManager$$ExternalSyntheticLambda5());
    }

    static /* synthetic */ KeyTemplate lambda$aes256GcmSivTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmSivKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes256GcmSivTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
    }

    private AesGcmSivKeyManager() {
    }
}
