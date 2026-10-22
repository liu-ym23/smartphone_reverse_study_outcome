package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.aead.internal.LegacyFullAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsAeadKey;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class KmsAeadKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<LegacyKmsAeadParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<LegacyKmsAeadKey, Aead> LEGACY_KMS_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Aead> legacyKeyManager = null;

    /* JADX INFO: renamed from: $r8$lambda$Ykl-gjOvLSGruSaXEzrBRjxVqQA, reason: not valid java name */
    public static /* synthetic */ Aead m917$r8$lambda$YklgjOvLSGruSaXEzrBRjxVqQA(LegacyKmsAeadKey r0) {
        return create(r0);
    }

    public static /* synthetic */ LegacyKmsAeadKey $r8$lambda$pxD48iqisjbMVo8rfEVzuOgUBeM(LegacyKmsAeadParameters r0, Integer r1) {
        return newKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    private static Aead create(LegacyKmsAeadKey key) throws GeneralSecurityException {
        return LegacyFullAead.create(KmsClients.get(key.getParameters().keyUri()).getAead(key.getParameters().keyUri()), key.getOutputPrefix());
    }

    static {
        LEGACY_KMS_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new KmsAeadKeyManager$$ExternalSyntheticLambda0(), LegacyKmsAeadKey.class, Aead.class);
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.REMOTE, KmsAeadKey.parser());
        KEY_CREATOR = new KmsAeadKeyManager$$ExternalSyntheticLambda1();
    }

    private static LegacyKmsAeadKey newKey(LegacyKmsAeadParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return LegacyKmsAeadKey.create(parameters, idRequirement);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        LegacyKmsAeadProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_KMS_AEAD_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, LegacyKmsAeadParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
    }

    public static KeyTemplate createKeyTemplate(String keyUri) {
        return KeyTemplate.createFrom(LegacyKmsAeadParameters.create(keyUri));
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private KmsAeadKeyManager() {
    }
}
