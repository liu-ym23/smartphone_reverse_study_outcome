package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.internal.LegacyFullAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class KmsEnvelopeAeadKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<LegacyKmsEnvelopeAeadParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<LegacyKmsEnvelopeAeadKey, Aead> LEGACY_KMS_ENVELOPE_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    private static final KeyManager<Aead> legacyKeyManager = null;

    /* JADX INFO: renamed from: $r8$lambda$DAcTAZIpg_0GCeNkm-MqqNof9yc, reason: not valid java name */
    public static /* synthetic */ LegacyKmsEnvelopeAeadKey m918$r8$lambda$DAcTAZIpg_0GCeNkmMqqNof9yc(LegacyKmsEnvelopeAeadParameters r0, Integer r1) {
        return newKey(r0, r1);
    }

    public static /* synthetic */ Aead $r8$lambda$YG6K5pltHximMieOcUnTanjyZa4(LegacyKmsEnvelopeAeadKey r0) {
        return create(r0);
    }

    static String getKeyType() {
        return TYPE_URL;
    }

    static {
        legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, KmsEnvelopeAeadKey.parser());
        KEY_CREATOR = new KmsEnvelopeAeadKeyManager$$ExternalSyntheticLambda0();
        LEGACY_KMS_ENVELOPE_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new KmsEnvelopeAeadKeyManager$$ExternalSyntheticLambda1(), LegacyKmsEnvelopeAeadKey.class, Aead.class);
    }

    private static LegacyKmsEnvelopeAeadKey newKey(LegacyKmsEnvelopeAeadParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return LegacyKmsEnvelopeAeadKey.create(parameters, idRequirement);
    }

    private static Aead create(LegacyKmsEnvelopeAeadKey key) throws GeneralSecurityException {
        String r0 = key.getParameters().getKekUri();
        return LegacyFullAead.create(KmsEnvelopeAead.create(key.getParameters().getDekParametersForNewKeys(), KmsClients.get(r0).getAead(r0)), key.getOutputPrefix());
    }

    private static AeadParameters makeRawAesGcm(AesGcmParameters parameters) throws GeneralSecurityException {
        return AesGcmParameters.builder().setIvSizeBytes(parameters.getIvSizeBytes()).setKeySizeBytes(parameters.getKeySizeBytes()).setTagSizeBytes(parameters.getTagSizeBytes()).setVariant(AesGcmParameters.Variant.NO_PREFIX).build();
    }

    private static AeadParameters makeRawChaCha20Poly1305() {
        return ChaCha20Poly1305Parameters.create(ChaCha20Poly1305Parameters.Variant.NO_PREFIX);
    }

    private static AeadParameters makeRawXChaCha20Poly1305() {
        return XChaCha20Poly1305Parameters.create(XChaCha20Poly1305Parameters.Variant.NO_PREFIX);
    }

    private static AeadParameters makeRawAesCtrHmacAead(AesCtrHmacAeadParameters parameters) throws GeneralSecurityException {
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(parameters.getAesKeySizeBytes()).setHmacKeySizeBytes(parameters.getHmacKeySizeBytes()).setTagSizeBytes(parameters.getTagSizeBytes()).setIvSizeBytes(parameters.getIvSizeBytes()).setHashType(parameters.getHashType()).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build();
    }

    private static AeadParameters makeRawAesEax(AesEaxParameters parameters) throws GeneralSecurityException {
        return AesEaxParameters.builder().setIvSizeBytes(parameters.getIvSizeBytes()).setKeySizeBytes(parameters.getKeySizeBytes()).setTagSizeBytes(parameters.getTagSizeBytes()).setVariant(AesEaxParameters.Variant.NO_PREFIX).build();
    }

    private static AeadParameters makeRawAesGcmSiv(AesGcmSivParameters parameters) throws GeneralSecurityException {
        return AesGcmSivParameters.builder().setKeySizeBytes(parameters.getKeySizeBytes()).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build();
    }

    private static AeadParameters makeRaw(Parameters parameters) throws GeneralSecurityException {
        if ((parameters instanceof AesGcmParameters) == false) goto L7;
        return makeRawAesGcm((AesGcmParameters) parameters);
    L7:
        if ((parameters instanceof ChaCha20Poly1305Parameters) == false) goto L11;
        return makeRawChaCha20Poly1305();
    L11:
        if ((parameters instanceof XChaCha20Poly1305Parameters) == false) goto L15;
        return makeRawXChaCha20Poly1305();
    L15:
        if ((parameters instanceof AesCtrHmacAeadParameters) == false) goto L19;
        return makeRawAesCtrHmacAead((AesCtrHmacAeadParameters) parameters);
    L19:
        if ((parameters instanceof AesEaxParameters) == false) goto L23;
        return makeRawAesEax((AesEaxParameters) parameters);
    L23:
        if ((parameters instanceof AesGcmSivParameters) == false) goto L27;
        return makeRawAesGcmSiv((AesGcmSivParameters) parameters);
    L27:
        throw new IllegalArgumentException("Illegal parameters" + parameters);
    }

    private static LegacyKmsEnvelopeAeadParameters.DekParsingStrategy getRequiredParsingStrategy(AeadParameters parameters) {
        if ((parameters instanceof AesGcmParameters) == false) goto L7;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_GCM;
    L7:
        if ((parameters instanceof ChaCha20Poly1305Parameters) == false) goto L11;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_CHACHA20POLY1305;
    L11:
        if ((parameters instanceof XChaCha20Poly1305Parameters) == false) goto L15;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_XCHACHA20POLY1305;
    L15:
        if ((parameters instanceof AesCtrHmacAeadParameters) == false) goto L19;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_CTR_HMAC;
    L19:
        if ((parameters instanceof AesEaxParameters) == false) goto L23;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_EAX;
    L23:
        if ((parameters instanceof AesGcmSivParameters) == false) goto L27;
        return LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_GCM_SIV;
    L27:
        throw new IllegalArgumentException("Illegal parameters" + parameters);
    }

    public static KeyTemplate createKeyTemplate(String kekUri, KeyTemplate dekTemplate) {
        AeadParameters r0 = makeRaw(dekTemplate.toParameters());     // Catch: GeneralSecurityException -> L4
        return KeyTemplate.createFrom(LegacyKmsEnvelopeAeadParameters.builder().setKekUri(kekUri).setDekParsingStrategy(getRequiredParsingStrategy(r0)).setDekParametersForNewKeys(r0).build());
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Cannot create LegacyKmsEnvelopeAeadParameters for template: " + dekTemplate, e);
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        LegacyKmsEnvelopeAeadProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, LegacyKmsEnvelopeAeadParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_KMS_ENVELOPE_AEAD_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }

    private KmsEnvelopeAeadKeyManager() {
    }
}
