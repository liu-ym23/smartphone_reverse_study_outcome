package com.google.crypto.tink.prf;

import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda4;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
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
import com.google.crypto.tink.prf.internal.HmacPrfProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HmacPrfKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<HmacPrfParameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<HmacPrfParameters> KEY_DERIVER = null;
    private static final PrimitiveConstructor<HmacPrfKey, Prf> PRF_PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Prf> legacyKeyManager = null;

    public static /* synthetic */ HmacPrfKey $r8$lambda$A6c1OPjtnCwdNxC5xxy68cbePMM(HmacPrfParameters r0, Integer r1) {
        return newKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    static {
        PRF_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda4(), HmacPrfKey.class, Prf.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Prf.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HmacPrfKey.parser());
        KEY_CREATOR = new HmacPrfKeyManager$$ExternalSyntheticLambda0();
        KEY_DERIVER = new HmacPrfKeyManager$$ExternalSyntheticLambda1();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static HmacPrfKey newKey(HmacPrfParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (idRequirement != null) goto L6;
        return HmacPrfKey.builder().setParameters(parameters).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes())).build();
    L6:
        throw new GeneralSecurityException("Id Requirement is not supported for HMAC PRF keys");
    }

    static HmacPrfKey createHmacKeyFromRandomness(HmacPrfParameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        return HmacPrfKey.builder().setParameters(parameters).setKeyBytes(Util.readIntoSecretBytes(stream, parameters.getKeySizeBytes(), access)).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("HMAC_SHA256_PRF", PredefinedPrfParameters.HMAC_SHA256_PRF);
        r0.put("HMAC_SHA512_PRF", PredefinedPrfParameters.HMAC_SHA512_PRF);
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        HmacPrfProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRF_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HmacPrfParameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, HmacPrfParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, r0, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate hmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacPrfKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha256Template$0() throws Exception {
        return KeyTemplate.createFrom(HmacPrfParameters.builder().setKeySizeBytes(32).setHashType(HmacPrfParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate hmacSha512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new HmacPrfKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$hmacSha512Template$1() throws Exception {
        return KeyTemplate.createFrom(HmacPrfParameters.builder().setKeySizeBytes(64).setHashType(HmacPrfParameters.HashType.SHA512).build());
    }

    private HmacPrfKeyManager() {
    }
}
