package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.mac.internal.AesCmacProtoSerialization;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCmacKeyManager {
    private static final PrimitiveConstructor<AesCmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<AesCmacParameters> KEY_CREATOR = null;
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final PrimitiveConstructor<AesCmacKey, Mac> MAC_PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Mac> legacyKeyManager = null;

    public static /* synthetic */ Mac $r8$lambda$GqQTjdN51Y8YwbSeFk28ar5yvvU(AesCmacKey r0) {
        return createMac(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$_dkxQOA7Z_p4eDUl-bOFQA6BmAo, reason: not valid java name */
    public static /* synthetic */ AesCmacKey m941$r8$lambda$_dkxQOA7Z_p4eDUlbOFQA6BmAo(AesCmacParameters r0, Integer r1) {
        return createAesCmacKey(r0, r1);
    }

    public static /* synthetic */ ChunkedMac $r8$lambda$p51Nv6tnpGayGkjUyf63xRLTaO4(AesCmacKey r0) {
        return createChunkedMac(r0);
    }

    private static void validateParameters(AesCmacParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() != 32) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }

    private static AesCmacKey createAesCmacKey(AesCmacParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validateParameters(parameters);
        return AesCmacKey.builder().setParameters(parameters).setAesKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).setIdRequirement(idRequirement).build();
    }

    private static ChunkedMac createChunkedMac(AesCmacKey key) throws GeneralSecurityException {
        validateParameters(key.getParameters());
        return new ChunkedAesCmacImpl(key);
    }

    private static Mac createMac(AesCmacKey key) throws GeneralSecurityException {
        validateParameters(key.getParameters());
        return PrfMac.create(key);
    }

    static {
        KEY_CREATOR = new AesCmacKeyManager$$ExternalSyntheticLambda2();
        CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new AesCmacKeyManager$$ExternalSyntheticLambda3(), AesCmacKey.class, ChunkedMac.class);
        MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new AesCmacKeyManager$$ExternalSyntheticLambda4(), AesCmacKey.class, Mac.class);
        legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.AesCmacKey", Mac.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesCmacKey.parser());
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesCmacProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesCmacParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(MAC_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES_CMAC", PredefinedMacParameters.AES_CMAC);
        r0.put("AES256_CMAC", PredefinedMacParameters.AES_CMAC);
        r0.put("AES256_CMAC_RAW", AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(r0);
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCmacKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes256CmacTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256CmacTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCmacKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$rawAes256CmacTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.NO_PREFIX).build());
    }

    private AesCmacKeyManager() {
    }
}
