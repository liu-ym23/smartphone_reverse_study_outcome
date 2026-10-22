package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.internal.AesSivProtoSerialization;
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
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesSivKeyManager {
    private static final PrimitiveConstructor<AesSivKey, DeterministicAead> AES_SIV_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesSivParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesSivParameters> KEY_DERIVER = null;
    private static final int KEY_SIZE_IN_BYTES = 64;
    private static final KeyManager<DeterministicAead> legacyKeyManager = null;

    public static /* synthetic */ DeterministicAead $r8$lambda$luLSdLpLnu8igGj5vEIqKUG38AU(AesSivKey r0) {
        return createDeterministicAead(r0);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    private static DeterministicAead createDeterministicAead(AesSivKey key) throws GeneralSecurityException {
        validateParameters(key.getParameters());
        return AesSiv.create(key);
    }

    static {
        AES_SIV_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new AesSivKeyManager$$ExternalSyntheticLambda0(), AesSivKey.class, DeterministicAead.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), DeterministicAead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesSivKey.parser());
        KEY_DERIVER = new AesSivKeyManager$$ExternalSyntheticLambda1();
        KEY_CREATOR = new AesSivKeyManager$$ExternalSyntheticLambda2();
    }

    private static void validateParameters(AesSivParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() != 64) goto L6;
        return;
    L6:
        throw new InvalidAlgorithmParameterException("invalid key size: " + parameters.getKeySizeBytes() + ". Valid keys must have 64 bytes.");
    }

    static AesSivKey createAesSivKeyFromRandomness(AesSivParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        validateParameters(parameters);
        return AesSivKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access)).build();
    }

    static AesSivKey newKey(AesSivParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validateParameters(parameters);
        return AesSivKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES256_SIV", PredefinedDeterministicAeadParameters.AES256_SIV);
        r0.put("AES256_SIV_RAW", AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesSivProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_SIV_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesSivParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesSivParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
    }

    public static final KeyTemplate aes256SivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesSivKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$aes256SivTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256SivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesSivKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes256SivTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
    }

    private AesSivKeyManager() {
    }
}
