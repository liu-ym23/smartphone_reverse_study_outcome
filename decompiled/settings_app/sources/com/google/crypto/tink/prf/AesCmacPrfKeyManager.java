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
import com.google.crypto.tink.prf.internal.AesCmacPrfProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCmacPrfKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<AesCmacPrfParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<AesCmacPrfKey, Prf> PRF_PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Prf> legacyKeyManager = null;

    public static /* synthetic */ AesCmacPrfKey $r8$lambda$iPmzwLJPqXfm0kf1p5tvIC6B9sE(AesCmacPrfParameters r0, Integer r1) {
        return newKey(r0, r1);
    }

    public static /* synthetic */ Prf $r8$lambda$p65lLTHoTdgeaRnZc5PAUbHTBVY(AesCmacPrfKey r0) {
        return createPrimitive(r0);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    }

    private static Prf createPrimitive(AesCmacPrfKey key) throws GeneralSecurityException {
        validate(key.getParameters());
        return PrfAesCmac.create(key);
    }

    static {
        PRF_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new AesCmacPrfKeyManager$$ExternalSyntheticLambda1(), AesCmacPrfKey.class, Prf.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Prf.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesCmacPrfKey.parser());
        KEY_CREATOR = new AesCmacPrfKeyManager$$ExternalSyntheticLambda2();
    }

    private static void validate(AesCmacPrfParameters parameters) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() != 32) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("Key size must be 32 bytes");
    }

    private static AesCmacPrfKey newKey(AesCmacPrfParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (idRequirement != null) goto L6;
        validate(parameters);
        return AesCmacPrfKey.create(parameters, SecretBytes.randomBytes(parameters.getKeySizeBytes()));
    L6:
        throw new GeneralSecurityException("Id Requirement is not supported for AES CMAC PRF keys");
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("AES256_CMAC_PRF", PredefinedPrfParameters.AES_CMAC_PRF);
        r0.put("AES_CMAC_PRF", PredefinedPrfParameters.AES_CMAC_PRF);
        return Collections.unmodifiableMap(r0);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        AesCmacPrfProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesCmacPrfParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRF_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES CMAC PRF is not supported in FIPS mode");
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new AesCmacPrfKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$aes256CmacTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesCmacPrfParameters.create(32));
    }

    private AesCmacPrfKeyManager() {
    }
}
