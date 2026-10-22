package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.prf.internal.HkdfPrfProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class HkdfPrfKeyManager {
    private static final PrimitiveConstructor<HkdfPrfKey, Prf> HKDF_PRF_CONSTRUCTOR = null;
    static final MutableKeyCreationRegistry.KeyCreator<HkdfPrfParameters> KEY_CREATOR = null;
    private static final int MIN_KEY_SIZE = 32;
    private static final PrimitiveConstructor<HkdfPrfKey, StreamingPrf> STREAMING_HKDF_PRF_CONSTRUCTOR = null;
    private static final KeyManager<Prf> legacyKeyManager = null;

    public static /* synthetic */ HkdfPrfKey $r8$lambda$CO0ENnjllOCzVQ9xscU8NAlMs4w(HkdfPrfParameters r0, Integer r1) {
        return newKey(r0, r1);
    }

    public static /* synthetic */ StreamingPrf $r8$lambda$DmveEHAqVjM6eCC9j5XlKMMl6gM(HkdfPrfKey r0) {
        return createStreamingPrf(r0);
    }

    public static /* synthetic */ Prf $r8$lambda$UYgIVNJyegrYG0dgRu_OwjU9b3U(HkdfPrfKey r0) {
        return createPrf(r0);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }

    private static void validate(HkdfPrfParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() < 32) goto L13;
        if (parameters.getHashType() != HkdfPrfParameters.HashType.SHA256) goto L7;
        return;
    L7:
        if (parameters.getHashType() != HkdfPrfParameters.HashType.SHA512) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Hash type must be SHA256 or SHA512");
    L13:
        throw new GeneralSecurityException("Key size must be at least 32");
    }

    private static StreamingPrf createStreamingPrf(HkdfPrfKey key) throws GeneralSecurityException {
        validate(key.getParameters());
        return HkdfStreamingPrf.create(key);
    }

    private static Prf createPrf(HkdfPrfKey key) throws GeneralSecurityException {
        return PrfImpl.wrap(createStreamingPrf(key));
    }

    static {
        STREAMING_HKDF_PRF_CONSTRUCTOR = PrimitiveConstructor.create(new HkdfPrfKeyManager$$ExternalSyntheticLambda0(), HkdfPrfKey.class, StreamingPrf.class);
        HKDF_PRF_CONSTRUCTOR = PrimitiveConstructor.create(new HkdfPrfKeyManager$$ExternalSyntheticLambda1(), HkdfPrfKey.class, Prf.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Prf.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HkdfPrfKey.parser());
        KEY_CREATOR = new HkdfPrfKeyManager$$ExternalSyntheticLambda2();
    }

    private static HkdfPrfKey newKey(HkdfPrfParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (idRequirement != null) goto L6;
        validate(parameters);
        return HkdfPrfKey.builder().setParameters(parameters).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    L6:
        throw new GeneralSecurityException("Id Requirement is not supported for HKDF PRF keys");
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("HKDF_SHA256", PredefinedPrfParameters.HKDF_SHA256);
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        HkdfPrfProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HKDF_PRF_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(STREAMING_HKDF_PRF_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HkdfPrfParameters.class);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering HKDF PRF is not supported in FIPS mode");
    }

    public static String staticKeyType() {
        return getKeyType();
    }

    public static final KeyTemplate hkdfSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HkdfPrfKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$hkdfSha256Template$0() throws Exception {
        return KeyTemplate.createFrom(HkdfPrfParameters.builder().setKeySizeBytes(32).setHashType(HkdfPrfParameters.HashType.SHA256).build());
    }

    private HkdfPrfKeyManager() {
    }
}
