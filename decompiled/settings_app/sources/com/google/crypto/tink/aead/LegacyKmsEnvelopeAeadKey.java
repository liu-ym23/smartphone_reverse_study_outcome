package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyKmsEnvelopeAeadKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final LegacyKmsEnvelopeAeadParameters parameters;

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ AeadParameters getParameters() {
        return getParameters();
    }

    private LegacyKmsEnvelopeAeadKey(LegacyKmsEnvelopeAeadParameters parameters, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static LegacyKmsEnvelopeAeadKey create(LegacyKmsEnvelopeAeadParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.getVariant() != LegacyKmsEnvelopeAeadParameters.Variant.NO_PREFIX) goto L9;
        if (idRequirement != null) goto L7;
        Bytes r0 = OutputPrefixUtil.EMPTY_PREFIX;
    L13:
        return new LegacyKmsEnvelopeAeadKey(parameters, r0, idRequirement);
    L7:
        throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
    L9:
        if (parameters.getVariant() != LegacyKmsEnvelopeAeadParameters.Variant.TINK) goto L17;
        if (idRequirement == null) goto L15;
        r0 = OutputPrefixUtil.getTinkOutputPrefix(idRequirement.intValue());
        goto L13
    L15:
        throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
    L17:
        throw new GeneralSecurityException("Unknown Variant: " + parameters.getVariant());
    }

    public static LegacyKmsEnvelopeAeadKey create(LegacyKmsEnvelopeAeadParameters parameters) throws GeneralSecurityException {
        return create(parameters, null);
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public LegacyKmsEnvelopeAeadParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof LegacyKmsEnvelopeAeadKey) == true) goto L5;
        return false;
    L5:
        LegacyKmsEnvelopeAeadKey r4 = (LegacyKmsEnvelopeAeadKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
