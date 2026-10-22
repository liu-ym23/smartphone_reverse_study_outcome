package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda14;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
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
import com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmHkdfStreamingKeyManager {
    private static final PrimitiveConstructor<AesGcmHkdfStreamingKey, StreamingAead> AES_GCM_HKDF_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesGcmHkdfStreamingParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmHkdfStreamingParameters> KEY_DERIVER = null;
    private static final KeyManager<StreamingAead> legacyKeyManager = null;

    public static /* synthetic */ AesGcmHkdfStreamingKey $r8$lambda$6k3E5MWVnlvzkwojhbpWaE65QOo(AesGcmHkdfStreamingParameters r0, Integer r1) {
        return creatAesGcmHkdfStreamingKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    static {
        AES_GCM_HKDF_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda14(), AesGcmHkdfStreamingKey.class, StreamingAead.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), StreamingAead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.parser());
        KEY_CREATOR = new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda0();
        KEY_DERIVER = new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda1();
    }

    private static AesGcmHkdfStreamingKey creatAesGcmHkdfStreamingKey(AesGcmHkdfStreamingParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return AesGcmHkdfStreamingKey.create(parameters, SecretBytes.randomBytes(parameters.getKeySizeBytes()));
    }

    static AesGcmHkdfStreamingKey createAesGcmHkdfStreamingKeyFromRandomness(AesGcmHkdfStreamingParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        return AesGcmHkdfStreamingKey.create(parameters, Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES128_GCM_HKDF_4KB", PredefinedStreamingAeadParameters.AES128_GCM_HKDF_4KB);
        r0.put("AES128_GCM_HKDF_1MB", PredefinedStreamingAeadParameters.AES128_GCM_HKDF_1MB);
        r0.put("AES256_GCM_HKDF_4KB", PredefinedStreamingAeadParameters.AES256_GCM_HKDF_4KB);
        r0.put("AES256_GCM_HKDF_1MB", PredefinedStreamingAeadParameters.AES256_GCM_HKDF_1MB);
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesGcmHkdfStreamingProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmHkdfStreamingParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmHkdfStreamingParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_HKDF_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES-GCM HKDF Streaming AEAD is not supported in FIPS mode");
    }

    public static final KeyTemplate aes128GcmHkdf4KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda5());
    }

    static /* synthetic */ KeyTemplate lambda$aes128GcmHkdf4KBTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setCiphertextSegmentSizeBytes(4096).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes128GcmHkdf1MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$aes128GcmHkdf1MBTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setCiphertextSegmentSizeBytes(1048576).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes256GcmHkdf4KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$aes256GcmHkdf4KBTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setCiphertextSegmentSizeBytes(4096).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes256GcmHkdf1MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$aes256GcmHkdf1MBTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setCiphertextSegmentSizeBytes(1048576).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    private AesGcmHkdfStreamingKeyManager() {
    }
}
