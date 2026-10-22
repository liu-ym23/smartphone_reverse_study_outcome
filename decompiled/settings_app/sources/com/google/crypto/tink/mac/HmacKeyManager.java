package com.google.crypto.tink.mac;

import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda0;
import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda1;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
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
import com.google.crypto.tink.mac.internal.HmacProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HmacKeyManager {
    private static final PrimitiveConstructor<HmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = null;
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<HmacParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<HmacParameters> KEY_DERIVER = null;
    private static final PrimitiveConstructor<HmacKey, Mac> MAC_PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Mac> legacyKeyManager = null;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    static {
        CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda1(), HmacKey.class, ChunkedMac.class);
        MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda0(), HmacKey.class, Mac.class);
        legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.HmacKey", Mac.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HmacKey.parser());
        KEY_DERIVER = new HmacKeyManager$$ExternalSyntheticLambda4();
        KEY_CREATOR = new HmacKeyManager$$ExternalSyntheticLambda5();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    static HmacKey createHmacKeyFromRandomness(HmacParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        return HmacKey.builder().setParameters(parameters).setKeyBytes(Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access)).setIdRequirement(idRequirement).build();
    }

    static HmacKey createNewHmacKey(HmacParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return HmacKey.builder().setParameters(parameters).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).setIdRequirement(idRequirement).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("HMAC_SHA256_128BITTAG", PredefinedMacParameters.HMAC_SHA256_128BITTAG);
        r0.put("HMAC_SHA256_128BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(HmacParameters.Variant.NO_PREFIX).setHashType(HmacParameters.HashType.SHA256).build());
        r0.put("HMAC_SHA256_256BITTAG", HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA256).build());
        r0.put("HMAC_SHA256_256BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setVariant(HmacParameters.Variant.NO_PREFIX).setHashType(HmacParameters.HashType.SHA256).build());
        r0.put("HMAC_SHA512_128BITTAG", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(16).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA512).build());
        r0.put("HMAC_SHA512_128BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(16).setVariant(HmacParameters.Variant.NO_PREFIX).setHashType(HmacParameters.HashType.SHA512).build());
        r0.put("HMAC_SHA512_256BITTAG", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA512).build());
        r0.put("HMAC_SHA512_256BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setVariant(HmacParameters.Variant.NO_PREFIX).setHashType(HmacParameters.HashType.SHA512).build());
        r0.put("HMAC_SHA512_512BITTAG", PredefinedMacParameters.HMAC_SHA512_512BITTAG);
        r0.put("HMAC_SHA512_512BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(64).setVariant(HmacParameters.Variant.NO_PREFIX).setHashType(HmacParameters.HashType.SHA512).build());
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        HmacProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(MAC_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HmacParameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, HmacParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, r0, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate hmacSha256HalfDigestTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha256HalfDigestTemplate$0() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setHashType(HmacParameters.HashType.SHA256).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha256Template$1() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setHashType(HmacParameters.HashType.SHA256).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha512HalfDigestTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha512HalfDigestTemplate$2() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setHashType(HmacParameters.HashType.SHA512).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha512Template$3() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(64).setHashType(HmacParameters.HashType.SHA512).setVariant(HmacParameters.Variant.TINK).build());
    }

    private HmacKeyManager() {
    }
}
