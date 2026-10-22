package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda13;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.streamingaead.internal.AesCtrHmacStreamingProtoSerialization;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCtrHmacStreamingKeyManager {
    private static final PrimitiveConstructor<AesCtrHmacStreamingKey, StreamingAead> AES_CTR_HMAC_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesCtrHmacStreamingParameters> KEY_CREATOR = null;
    private static final KeyManager<StreamingAead> legacyKeyManager = null;

    /* JADX INFO: renamed from: $r8$lambda$Bg5qqFsEFv0WT6vqkidQ-wF0HZg, reason: not valid java name */
    public static /* synthetic */ AesCtrHmacStreamingKey m965$r8$lambda$Bg5qqFsEFv0WT6vqkidQwF0HZg(AesCtrHmacStreamingParameters r0, Integer r1) {
        return createAesCtrHmacStreamingKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    static {
        AES_CTR_HMAC_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda13(), AesCtrHmacStreamingKey.class, StreamingAead.class);
        KEY_CREATOR = new AesCtrHmacStreamingKeyManager$$ExternalSyntheticLambda2();
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), StreamingAead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesCtrHmacStreamingKey.parser());
    }

    private static AesCtrHmacStreamingKey createAesCtrHmacStreamingKey(AesCtrHmacStreamingParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return AesCtrHmacStreamingKey.create(parameters, SecretBytes.randomBytes(parameters.getKeySizeBytes()));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES128_CTR_HMAC_SHA256_4KB", PredefinedStreamingAeadParameters.AES128_CTR_HMAC_SHA256_4KB);
        r0.put("AES128_CTR_HMAC_SHA256_1MB", PredefinedStreamingAeadParameters.AES128_CTR_HMAC_SHA256_1MB);
        r0.put("AES256_CTR_HMAC_SHA256_4KB", PredefinedStreamingAeadParameters.AES256_CTR_HMAC_SHA256_4KB);
        r0.put("AES256_CTR_HMAC_SHA256_1MB", PredefinedStreamingAeadParameters.AES256_CTR_HMAC_SHA256_1MB);
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesCtrHmacStreamingProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesCtrHmacStreamingParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_CTR_HMAC_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES CTR HMAC Streaming AEAD is not supported in FIPS mode");
    }

    public static final KeyTemplate aes128CtrHmacSha2564KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCtrHmacStreamingKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$aes128CtrHmacSha2564KBTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build());
    }

    public static final KeyTemplate aes128CtrHmacSha2561MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCtrHmacStreamingKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes128CtrHmacSha2561MBTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build());
    }

    public static final KeyTemplate aes256CtrHmacSha2564KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCtrHmacStreamingKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$aes256CtrHmacSha2564KBTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build());
    }

    public static final KeyTemplate aes256CtrHmacSha2561MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCtrHmacStreamingKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$aes256CtrHmacSha2561MBTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build());
    }

    private AesCtrHmacStreamingKeyManager() {
    }
}
