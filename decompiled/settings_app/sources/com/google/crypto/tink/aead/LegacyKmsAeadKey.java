package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyKmsAeadKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final LegacyKmsAeadParameters parameters;

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ AeadParameters getParameters() {
        return getParameters();
    }

    private LegacyKmsAeadKey(LegacyKmsAeadParameters parameters, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static LegacyKmsAeadKey create(LegacyKmsAeadParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.variant() != LegacyKmsAeadParameters.Variant.TINK) goto L9;
        if (idRequirement == null) goto L7;
        Bytes r0 = Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(idRequirement.intValue()).array());
    L13:
        return new LegacyKmsAeadKey(parameters, r0, idRequirement);
    L7:
        throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
    L9:
        if (parameters.variant() != LegacyKmsAeadParameters.Variant.NO_PREFIX) goto L17;
        if (idRequirement != null) goto L15;
        r0 = Bytes.copyFrom(new byte[0]);
        goto L13
    L15:
        throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
    L17:
        throw new GeneralSecurityException("Unknown Variant: " + parameters.variant());
    }

    public static LegacyKmsAeadKey create(LegacyKmsAeadParameters parameters) throws GeneralSecurityException {
        return create(parameters, null);
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public LegacyKmsAeadParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof LegacyKmsAeadKey) == true) goto L5;
        return false;
    L5:
        LegacyKmsAeadKey r4 = (LegacyKmsAeadKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
